package sn.esmt.inscription.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import sn.esmt.inscription.model.Inscription;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class InscriptionRepositoryImpl implements InscriptionRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Inscription> rowMapper = (rs, rowNum) -> new Inscription(
            rs.getLong("id"),
            rs.getString("nom"),
            rs.getString("prenom"),
            rs.getDate("date_naissance").toLocalDate(),
            rs.getString("telephone"),
            rs.getString("type_evenement")
    );

    public InscriptionRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Inscription save(Inscription inscription) {
        String sql = "INSERT INTO inscription (nom, prenom, date_naissance, telephone, type_evenement) " +
                "VALUES (?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, inscription.getNom());
            ps.setString(2, inscription.getPrenom());
            ps.setDate(3, Date.valueOf(inscription.getDateNaissance()));
            ps.setString(4, inscription.getTelephone());
            ps.setString(5, inscription.getTypeEvenement());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            inscription.setId(key.longValue());
        }
        return inscription;
    }

    @Override
    public List<Inscription> findAll() {
        String sql = "SELECT id, nom, prenom, date_naissance, telephone, type_evenement " +
                "FROM inscription ORDER BY id DESC";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Inscription> findById(Long id) {
        String sql = "SELECT id, nom, prenom, date_naissance, telephone, type_evenement " +
                "FROM inscription WHERE id = ?";
        List<Inscription> results = jdbcTemplate.query(sql, rowMapper, id);
        return results.stream().findFirst();
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM inscription WHERE id = ?", id);
    }
}

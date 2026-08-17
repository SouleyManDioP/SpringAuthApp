package sn.esmt.inscription.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import sn.esmt.inscription.model.Utilisateur;

import java.util.List;

@Repository
public class UtilisateurRepository {

    private final JdbcTemplate jdbcTemplate;

    public UtilisateurRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Utilisateur> rowMapper = (rs, rowNum) -> {
        Utilisateur u = new Utilisateur();
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setRole(rs.getString("role"));
        u.setEnabled(rs.getBoolean("enabled"));
        return u;
    };

    public Utilisateur findByUsername(String username) {
        String sql = "SELECT * FROM utilisateur WHERE username = ?";
        List<Utilisateur> resultats = jdbcTemplate.query(sql, rowMapper, username);
        return resultats.isEmpty() ? null : resultats.get(0);
    }

    public void save(Utilisateur u) {
        String sql = "INSERT INTO utilisateur (username, password, role, enabled) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, u.getUsername(), u.getPassword(), u.getRole(), u.isEnabled());
    }
}
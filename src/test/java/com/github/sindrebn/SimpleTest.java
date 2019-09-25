package com.github.sindrebn;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleTest extends DBTest {

    @Test
    void henter_riktig_antall_faggrupper() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(database);

        int antallFaggrupper = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FAGGRUPPE", Integer.class);

        assertEquals(2, antallFaggrupper);
    }

    @Test
    void henter_riktig_antall_ansatte() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(database);

        List<Ansatt> alleAnsatte = jdbcTemplate.query(
                "SELECT * FROM ANSATT",
                (rs, rowNum) -> new Ansatt(rs.getInt("id"), rs.getString("fornavn"), rs.getInt("faggruppe_id"))
        );
        assertThat(alleAnsatte, hasSize(17));
    }
}

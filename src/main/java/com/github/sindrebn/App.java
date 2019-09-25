package com.github.sindrebn;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class App {

    public static void main(String[] args) {
        DataSource dataSource = DB.getInstance();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int antallFaggrupper = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FAGGRUPPE", Integer.class);
        System.out.println("Antall faggrupper: " + antallFaggrupper);

        List<Ansatt> alleAnsatte = jdbcTemplate.query(
                "SELECT * FROM ANSATT",
                (rs, rowNum) -> new Ansatt(rs.getInt("id"), rs.getString("fornavn"), rs.getInt("faggruppe_id"))
        );

        System.out.println("Alle ansatte: ");
        alleAnsatte.stream()
                .map(ansatt -> "\t" + ansatt)
                .forEach(System.out::println);
    }

}

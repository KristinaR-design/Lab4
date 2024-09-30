package org.example.lab4;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public class DBController {
    private static final String cr = "CREATE TABLE Student (\n" +
            "    id SERIAL PRIMARY KEY,\n" +
            "    name VARCHAR(100) NOT NULL,\n" +
            "    surname VARCHAR(100) NOT NULL,\n" +
            "    age INT NOT NULL,\n" +
            "    gpa REAL\n" +
            ");\n";

    private static final String query = "INSERT INTO Student (id, name, surname, age, gpa) VALUES (:id, :name, :surname, :age, :gpa)";

    private static final String SQL_GET_PROFILE_BY_ID =
            "select id, first_name, last_name, age from Students where id = :id";

    private static final String del = "DELETE FROM Studen WHERE id = :id;";
    private static final String upd = "UPDATE Student\n" +
            "SET name = :name, \n" +
            "    surname = :surname, \n" +
            "    age = :age, \n" +
            "    gpa = :gpa\n" +
            "WHERE id = :id;";

    @Autowired
    private final JpaRepository<Student, Long> rep;

    public DBController(JpaRepository<Student, Long> rep) {
        this.rep = rep;
    }

    public Optional<Student> getProfileById() {
        var params = new MapSqlParameterSource();
        params.addValue("id",1);
        params.addValue("name", "Oleg");
        params.addValue("surname", "Hi");
        params.addValue("age", 56);
        params.addValue("gpa", 4);
        return jdbcTemplate.query(
                        SQL_GET_PROFILE_BY_ID,
                        params,
                        profileMapper
                ).stream()
                .findFirst();
    }
}

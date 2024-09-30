package org.example.lab4;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;



import java.util.Optional;

@Service
public class mainController{
    private final NamedParameterJdbcTemplate


    @GetMapping
        public Student getStudent() {
            return DBController.getProfileById().orElseThrow(() -> new RuntimeException("eXEPTION"));

        }
}


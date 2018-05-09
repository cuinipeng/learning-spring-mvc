package com.percy.repository;

import com.percy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserRepository {
    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcUserRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public void addUser(User user) {
        String INSERT_SQL = "INSERT INTO user(id, lastname, firstname, address, city) VALUES (?, ?, ?, ?, ?);";
        jdbcOperations.update(INSERT_SQL, user.getId(), user.getLastname(),
                user.getFirstname(), user.getAddress(), user.getCity());
    }

    public User findUserById(int id) {
        String QUERY_SQL = "SELECT id, lastname, firstname, address, city FROM user WHERE id = ?";
        return jdbcOperations.queryForObject(QUERY_SQL, new UserRowMapper(), id);
    }
}

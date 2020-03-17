package com.vulk.shkola.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.vulk.shkola.model.User;

public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;

	public UserDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(User user) {
		String sql = "INSERT INTO users (firstname, lastname, email, gender) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, user.getFirstname(), user.getLastname(), user.getEmail(), user.getGender());
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM users WHERE id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public int update(User user) {
		String sql = "UPDATE users SET firstname=?, lastname=?, email=?, gender=? WHERE id=?";
		return jdbcTemplate.update(sql, user.getFirstname(), user.getLastname(), user.getEmail(), user.getGender(),
				user.getId());
	}

	@Override
	public User getUserByID(Integer id) {
		String sql = "SELECT * FROM users WHERE id=" + id;

		ResultSetExtractor<User> extractor = new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {
					Integer id = rs.getInt("id");
					String firstname = rs.getString("firstname");
					String lastname = rs.getString("lastname");
					String email = rs.getString("email");
					String gender = rs.getString("gender");
					return new User(id, firstname, lastname, email, gender);
				}
				return null;
			}

		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM users";

		RowMapper<User> rowMapper = new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				return new User(id, firstname, lastname, email, gender);
			}

		};

		return jdbcTemplate.query(sql, rowMapper);
	}

}

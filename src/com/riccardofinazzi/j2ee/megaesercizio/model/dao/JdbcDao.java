package com.riccardofinazzi.j2ee.megaesercizio.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.riccardofinazzi.j2ee.megaesercizio.controller.persistencedelegate.PersistenceService;
import com.riccardofinazzi.j2ee.megaesercizio.model.User;
import com.riccardofinazzi.j2ee.util.JdbcUtil;

public class JdbcDao implements PersistenceService {

	private Connection connection;

	public JdbcDao() {
		connection = JdbcUtil.getConnection("jdbc:mysql://localhost:3306/j2ee?useSSL=false","root","root");
	}

	public void checkUser(User user) {
		try {
			PreparedStatement ps = connection.prepareStatement("select uname from users where uname = ?");
			ps.setString(1, user.getUname());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) // found
			{
				updateUser(user);
			} else {
				addUser(user);
			}
		} catch (Exception ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		}
	}

	public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(uname, password, email, registeredon) values (?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, user.getUname());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setDate(4, new java.sql.Date(user.getRegisteredon().getTime()));
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(String userId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from users where uname=?");
			// Parameters start with 1
			preparedStatement.setString(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update users set password=?, email=?, registeredon=?" + "where uname=?");
			// Parameters start with 1
			System.out.println(new java.sql.Date(user.getRegisteredon().getTime()));
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setDate(3, new java.sql.Date(user.getRegisteredon().getTime()));
			preparedStatement.setString(4, user.getUname());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				User user = new User();
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setRegisteredon(rs.getDate("registeredon"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public User getUserById(String userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where uname=?");
			preparedStatement.setString(1, userId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setRegisteredon(rs.getDate("registeredon"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
}
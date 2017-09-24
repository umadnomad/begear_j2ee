package com.riccardofinazzi.j2ee.megaesercizio.controller.persistencedelegate;

import java.util.List;

import com.riccardofinazzi.j2ee.megaesercizio.model.User;

public interface PersistenceService {
	void checkUser(User user);
	void addUser(User user);
	void deleteUser(String userId);
	void updateUser(User user);
	List<User> getAllUsers();
	User getUserById(String userId);
}

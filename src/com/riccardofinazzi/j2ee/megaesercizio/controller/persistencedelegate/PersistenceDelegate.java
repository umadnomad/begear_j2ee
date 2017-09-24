package com.riccardofinazzi.j2ee.megaesercizio.controller.persistencedelegate;

import java.util.List;

import com.riccardofinazzi.j2ee.megaesercizio.model.User;

public class PersistenceDelegate {
	private PersistenceLookUp lookupService = new PersistenceLookUp();
	private PersistenceService businessService;
	private ServiceType serviceType;

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public void addUser(User user) {
		businessService = lookupService.getPersistenceService(serviceType);
		businessService.addUser(user);
	}

	public void updateUser(User user) {
		businessService = lookupService.getPersistenceService(serviceType);
		businessService.updateUser(user);
	}
	
	public void deleteUser(String userId) {
		businessService = lookupService.getPersistenceService(serviceType);
		businessService.deleteUser(userId);
	}

	public List<User> getAllUsers() {
		businessService = lookupService.getPersistenceService(serviceType);
		return businessService.getAllUsers();
	}

	public User getUserById(String userId) {
		businessService = lookupService.getPersistenceService(serviceType);
		return businessService.getUserById(userId);
	}

	public void checkUser(User user) {
		businessService = lookupService.getPersistenceService(serviceType);
		businessService.checkUser(user);
	}

}
package com.riccardofinazzi.j2ee.megaesercizio.controller.persistencedelegate;

import com.riccardofinazzi.j2ee.megaesercizio.model.dao.JdbcDao;

public class PersistenceLookUp {
	
	public PersistenceService getPersistenceService(ServiceType service) {

		switch (service) {
		case JDBC:
			return new JdbcDao();
		case HIBERNATE:
		}
		
		return null;
	}
}

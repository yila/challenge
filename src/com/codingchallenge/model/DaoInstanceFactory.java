package com.codingchallenge.model;

public class DaoInstanceFactory {

	private static EmployeeDao dao;

	public static EmployeeDao getDao() {
		if(dao == null){
			dao = new EmployeeDao();
		}
		return dao;
	}

	public static void set(EmployeeDao dao) {
		DaoInstanceFactory.dao = dao;
	}

}

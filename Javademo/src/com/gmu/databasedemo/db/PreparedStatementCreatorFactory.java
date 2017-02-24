package com.gmu.databasedemo.db;

public class PreparedStatementCreatorFactory {

	private final PreparedStatementCreator preparedStatementCreator;

	private PreparedStatementCreatorFactory() {
		this.preparedStatementCreator = new PreparedStatementCreator();
	}
	
	public PreparedStatementCreator getPreparedStatementCreator() {
		return preparedStatementCreator;
	}
	
	public static final PreparedStatementCreatorFactory instance 
		= new PreparedStatementCreatorFactory();
}

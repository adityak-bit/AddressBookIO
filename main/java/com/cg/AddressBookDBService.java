package com.cg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {

	private static AddressBookDBService dbService;
	
	private AddressBookDBService() {}
	
	public static AddressBookDBService getInstance() {
		if(dbService == null) {
			dbService = new AddressBookDBService();
		}
		return dbService;
	}

	private Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/address_book?useSSL=false";
		String username = "root";
		String password = "Aditya@987";
		Connection connection;
		System.out.println("Connecting to DB: "+jdbcURL);
		connection = DriverManager.getConnection(jdbcURL,username,password);
		System.out.println(" Connection is established!!!!: "+connection);
		return connection;
	}
	
	public List<AddressBookData> getData() {
		String sql  = "SELECT * FROM contacts c, address_info a WHERE c.address = a.zip;";
		return this.getDataUsingDB(sql);
	}

	public List<AddressBookData> getData(String fname) {
		List<AddressBookData> addrList =  null;
		if(this.dataStatement == null)
			this.prepareStatementForData();
		try {
			employeePayrollDataStatement.setString(1, name);
			ResultSet resultSet = employeePayrollDataStatement.executeQuery();
			employeePayrollList = this.getEmployeePayrollData(resultSet);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}
	
	private List<AddressBookData> getDataUsingDB(String sql){
		List<AddressBookData> addrList = new ArrayList<>();
		try (Connection connection = this.getConnection()){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			addrList = this.getData(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addrList;
	}
	
	private List<AddressBookData> getData(ResultSet resultSet) {
		List<AddressBookData> addrList = new ArrayList<>();
		try {
			while(resultSet.next()) {
				String fname = resultSet.getString("fname");
				String lname = resultSet.getString("lname");
				double address = resultSet.getDouble("address");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				double zip = resultSet.getDouble("zip");
				double phone_number =  resultSet.getDouble("phone_number");
				String email = resultSet.getString("email");
				addrList.add(new AddressBookData(fname, lname, address, city,
						                         state, zip, phone_number, email));
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return addrList;
	}
	
	public int updatePersonData(String fname, String email) {
		return this.updatePersonDataUsingStatement(fname, email);
	}

	private int updatePersonDataUsingStatement(String fname, String email) {
		String sql = String.format("update contacts set email = '%s' where fname = '%s'", email, fname);
		try (Connection connection = this.getConnection()){
			Statement statement = connection.createStatement();
			return statement.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
}

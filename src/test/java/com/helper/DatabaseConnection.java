package com.helper;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseConnection {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://elastic.rapidtestpro.com:2777/VULCAN_APPIUM";

	// Database credentials
	static final String USER = "belitypi";
	static final String PASS = "47GWrkhPknA3";

	public static Object[][] getDataFromDatabase(String tableName) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet Data_RS = null;
		// Object data[][] = new Object[50][50];

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql;
			sql = "SELECT * FROM " + tableName;
			System.out.println(sql);
			Data_RS = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = Data_RS.getMetaData();

			boolean b = Data_RS.last();
			int lastRow = Data_RS.getRow();

			Object data[][] = new Object[Data_RS.getRow()][rsmd.getColumnCount()];
			b = Data_RS.first();

			for (int i = 0; i < lastRow; i++) {
				for (int k = 0; k < rsmd.getColumnCount(); k++) {
					String columnName = rsmd.getColumnName(k + 1);
					String type = rsmd.getColumnTypeName(k + 1);
					String columnValue = null;

					if (type.contentEquals("VARCHAR")) {
						columnValue = Data_RS.getString(columnName);
					} else if (type.contentEquals("INT")) {
						columnValue = Integer.toString(Data_RS.getInt(columnName));
					}

					System.out.println(i + " " + k + " " + columnName + " " + type + " " + columnValue);

					if (!(columnValue == "")) {
						data[i][k] = columnValue.toString();
					}

				}
				Data_RS.next();
			}

			return data;

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			Data_RS.close();
			stmt.close();
			conn.close();
		}
		return null;
	}
}
=======
import java.sql.*;
	 
	public class DatabaseConnection {
	    // JDBC driver name and database URL
	    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	    static final String DB_URL = "jdbc:mysql://elastic.rapidtestpro.com:2777/VULCAN_APPIUM";


	 
	    // Database credentials
	    static final String USER = "belitypi";
	    static final String PASS = "47GWrkhPknA3";
	    
	    
	    
	    public static Object[][] getDataFromDatabase(String tableName)
	            throws SQLException {
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet  Data_RS = null;
//	        Object data[][] = new Object[50][50]; 
	        
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Connecting to database...");
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            System.out.println("Creating statement...");
	            stmt = conn.createStatement(
	                     ResultSet.TYPE_SCROLL_INSENSITIVE,
	                        ResultSet.CONCUR_READ_ONLY);
	            String sql;
	            sql = "SELECT * FROM " + tableName ;
	            System.out.println(sql);
	            Data_RS =  stmt.executeQuery(sql);
	            ResultSetMetaData rsmd = Data_RS.getMetaData();        
	            
	            boolean b= Data_RS.last();
	            int lastRow = Data_RS.getRow();
	        
	            Object data[][]=new Object[Data_RS.getRow()][rsmd.getColumnCount()];
	            b = Data_RS.first();
	                
	            for(int i=0;i<lastRow;i++) {
	                for(int k=0;k<rsmd.getColumnCount();k++) {
	                    String columnName = rsmd.getColumnName(k+1);
	                    String type = rsmd.getColumnTypeName(k+1);
	                    String columnValue = null;
	                    
	                    
	                    
	                    
	                    if(type.contentEquals("VARCHAR")) {
	                        columnValue = Data_RS.getString(columnName);
	                    }else if(type.contentEquals("INT")) {
	                        columnValue = Integer.toString(Data_RS.getInt(columnName));
	                    }
	                    
	                    System.out.println(i +  " "+k +  " "+columnName + " " + type +" "+columnValue  );
	                    
	            
	                    if (!(columnValue == "")) {
	                        data[i][k] = columnValue.toString();
	                    }
	                }
	                Data_RS.next();
	            }
	            return data;
	            
	            } catch (Exception e) {

	            e.printStackTrace();
	        } 
	        finally {
	            Data_RS.close();
	            stmt.close();
	            conn.close();
	        }
	        return null;
	    }
	}


>>>>>>> origin/Kevinrynjah

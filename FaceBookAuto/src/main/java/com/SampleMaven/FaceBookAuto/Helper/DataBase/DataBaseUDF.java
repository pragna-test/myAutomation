package com.SampleMaven.FaceBookAuto.Helper.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUDF {
	
	//connection
		public static Connection con;
		public static Connection fnConnection(String DriverName, String dburl, String username, String password) throws ClassNotFoundException, SQLException 
				
		{
			Class.forName(DriverName);
			Connection con=DriverManager.getConnection(dburl, username, password);
			return con;
		}
		
		//class loader
		//sql statement
		//close
		public static void fnCloseConnection(Connection con) throws SQLException 
		{
			con.close();		
		}
		
		//Result Set
		public static ResultSet rs;
		
		public static ResultSet fnResultSet( String DriverName, String dburl, String username, 
				String password, String query ) throws ClassNotFoundException, SQLException
		
		{
			//Load mysql driver		
			Class.forName(DriverName);
			//create connection
			Connection con=DriverManager.getConnection(dburl, username, password);
			
			//create statement
			Statement st=con.createStatement();
			
			//execute the sql query and store in result set
			rs=st.executeQuery(query);
			
			return rs;
			
			
		}
		
		//Sample second method to pass connection and sql statement
		public static ResultSet rs2;
		public static ResultSet fnResultSet2( Connection con, String query) throws SQLException
		
		{
				
			//create statement
			Statement st=con.createStatement();
			
			//execute the sql query and store in result set
			rs2=st.executeQuery(query);
			
			return rs2;
			
			
		}
		
		//Only column names
		public static ResultSetMetaData md;
		public static ResultSetMetaData fnColumnNames(Connection con, String query) throws SQLException 
		{
			Statement st=con.createStatement();
			//sql 
			ResultSet rs=st.executeQuery(query);
			
			md=(ResultSetMetaData) rs.getMetaData();
			return md;
			
		}
		

}

package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionTesting {
	public static void main(String[] args) throws SQLException {
		
		//create Basic DataSource
		BasicDataSource bds = new BasicDataSource();
		
		//define Driver class
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//define server url
		bds.setUrl("jdbc:mysql://localhost:3306/college");
		//define username
		bds.setUsername("root");
		//define password
		bds.setPassword("admin");
		//max connections to be created
		bds.setMaxTotal(160);
		//time for wait before a connection is opened
		bds.setMaxIdle(5);
		bds.setMaxWaitMillis(1000*5);
		
		Date d1 = new Date();
		
		//testing whether the connection is being created
		for (int i =0; i <160; i++) {
			try {
				Connection con= bds.getConnection();
				System.out.println(con.toString() +" "+i);
				//con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		
	}
		Date d2 = new Date();
		System.out.println("Start time: "+ d1);
		System.out.println("Stop time: "+d2);
	}

}

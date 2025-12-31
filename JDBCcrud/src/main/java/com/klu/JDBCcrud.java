package com.klu;


import java.sql.*;
public class JDBCcrud {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/fsads3";
		String user="root";
		String pwd="Aditya#0314";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection Established");
			Statement st=con.createStatement();
			String createDept= "create table if not exists Dept("+" dept_id  int primary key auto_increment,"+"dept_name varchar(20)"+")";
			st.execute(createDept);
			System.out.println("Department table created");
			st.execute("CREATE TABLE IF NOT EXISTS Emp (\r\n"
					+ "    emp_id INT PRIMARY KEY AUTO_INCREMENT,\r\n"
					+ "    emp_name VARCHAR(50),\r\n"
					+ "    sal DOUBLE,\r\n"
					+ "    dept_id INT,\r\n"
					+ "    FOREIGN KEY (dept_id) REFERENCES Dept(dept_id)\r\n"
					+ ");");
			System.out.println("Employee table created");
			st.executeUpdate("insert into dept values(56,'CSE')");
			System.out.println("record have been inserted successfully into dept table");
			st.executeUpdate("insert into emp values(5582,'sai',520002,56)");
			System.out.println("record have been inserted successfully into emp table");
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
}

package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class StudentImplementation implements StudentInterface {
	Scanner sc=new Scanner(System.in);
	@Override
	public void addStudent() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement preparestatement=connection.prepareStatement("insert into student values(?,?,?,?,?)");
			System.out.println("enter id ");
			preparestatement.setInt(1, sc.nextInt());
			System.out.println("enter name");
			preparestatement.setString(2, sc.next());
			System.out.println("enter age ");
			preparestatement.setInt(3, sc.nextInt());
			System.out.println("enter phone number");
			preparestatement.setInt(4, sc.nextInt());
			System.out.println("enter marks");
			preparestatement.setInt(5, sc.nextInt());
			
			preparestatement.execute();
			connection.close();
			System.out.println("data added sucessfully");
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
			
		}
	}

	@Override
	public void deleteStudent() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
		PreparedStatement preparestatement =connection.prepareStatement("delete from student where sid=?");
		System.out.println("enter sid");
		preparestatement.setInt(1,sc.nextInt());
		preparestatement.execute();
		connection.close();
		System.out.println("data deleted successfully");
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
		
	}
	}

	@Override
	public void updateStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement preparestatement =connection.prepareStatement("update student set marks=? where sid=?");
			
			System.out.println("enter new marks ");
			preparestatement.setInt(1,sc.nextInt());
			System.out.println("enter sid");
			preparestatement.setInt(2,sc.nextInt());
			preparestatement.execute();
			connection.close();
			System.out.println("data updated  successfully");
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
			
		}
	}

	@Override
	public void getAllStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement preparestatement =connection.prepareStatement("select * from student");
			ResultSet resultset=preparestatement.executeQuery();
			while(resultset.next()) {
				System.out.println("----------------------------------------------");
				System.out.println("student id: "+resultset.getInt(1));
				System.out.println("student name: "+resultset.getString(2));
				System.out.println("student age: "+resultset.getInt(3));
				System.out.println("student phone number: "+resultset.getInt(4));
				System.out.println("student marks: "+resultset.getInt(5));
				
				
			}
			
			connection.close();
	
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
			
		}
	}

	@Override
	public void getStudentByMarks() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement preparestatement =connection.prepareStatement("select * from student where marks>?");
			System.out.println("enter marks");
			int limitmarks=sc.nextInt();
			preparestatement.setInt(1,limitmarks );
			ResultSet resultset=preparestatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt(5)>limitmarks) {
				System.out.println("----------------------------------------------");
				System.out.println("student id: "+resultset.getInt(1));
				System.out.println("student name: "+resultset.getString(2));
				System.out.println("student age: "+resultset.getInt(3));
				System.out.println("student phone number: "+resultset.getInt(4));
				System.out.println("student marks: "+resultset.getInt(5));
			}
			}
			connection.close();
	
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
			
		}
		
	}
  
}

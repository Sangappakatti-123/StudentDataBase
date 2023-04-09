package com.ty;
import java.util.Scanner;
public class Student {
  public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	StudentInterface si=new StudentImplementation();
	while(true) {
		System.out.println("welcome to student database");
		System.out.println("1.Addstudent\n2.DeleteStudent\n3.UpdateStudent\n4.getallstudent\n5.getStudentByMarks\n6.EXIT");
		System.out.println("enter your choice 1 to 6");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			si.addStudent();
			break;
		case 2:
			si.deleteStudent();
			break;
		case 3:
			si.updateStudent();
			break;
		case 4:
			si.getAllStudent();
			break;
		case 5:
			si.getStudentByMarks();
			break;
		case 6:System.out.println("thank you");
		  System.exit(0);
		  
			default:System.out.println("invalid choice");
			
		}
	}
}
}

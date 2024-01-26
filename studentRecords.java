package CodTechSolutions;

import java.util.ArrayList;
import java.util.Scanner;
class student
{
	    String name;
	    int rollNumber;
	    int[] marks;
	    public student(String name, int rollNumber, int[] marks)
	    {
	        this.name = name;
	        this.rollNumber = rollNumber;
	        this.marks = marks;
	    }
}
public class studentRecords {
	  static ArrayList<student> studentList = new ArrayList<>();
	     static final int subjects = 3; 
	     static Scanner scanner = new Scanner(System.in);
	     public static void main(String[] args) {
	        while (true)
	        {
	            System.out.println("1.Add Student\n2.Update Student\n3.Delete Student\n4.Display Students\n5.Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            switch (choice)
	            {
	                case 1:addStudent();
	                break;
	                case 2:updateStudent();
	                break;
	                case 3:deleteStudent();
	                break;
	                case 4:displayStudents();
	                break;
	                case 5:System.out.println("Exiting program.");
	                       System.exit(0);
	                break;
	                default:System.out.println("Invalid choice. Please try again.");
	            }
	        }
	        
	    }
	    public static void addStudent()
	    {
	        System.out.print("Enter student name: ");
	        String name = scanner.next();
	        System.out.print("Enter roll number: ");
	        int rollNumber = scanner.nextInt();
	        int[] marks = new int[subjects];
	        for (int i = 0; i <subjects; i++)
	        {
	            System.out.print("Enter marks for Subject" + (i + 1) + ": ");
	            marks[i] = scanner.nextInt();
	        }

	        student s = new student(name, rollNumber, marks);
	        studentList.add(s);

	        System.out.println("Student added successfully.");
	    }

	    public static void updateStudent()
	    {
	        System.out.print("Enter the roll number of the student to update: ");
	        int rollNumber = scanner.nextInt();
	        int index = findStudentIndexByRollNumber(rollNumber);
	        if (index == -1)
	        {
	            System.out.println("Student not found.");
	            return;
	        }
	        System.out.print("Enter new marks for Subject 1: ");
	        studentList.get(index).marks[0] = scanner.nextInt();
	        System.out.print("Enter new marks for Subject 2: ");
	        studentList.get(index).marks[1] = scanner.nextInt();
	        System.out.print("Enter new marks for Subject 3: ");
	        studentList.get(index).marks[2] = scanner.nextInt();
	        System.out.println("Student information updated successfully.");
	    }
	    public static void deleteStudent() {
	        System.out.print("Enter the roll number of the student to delete: ");
	        int rollNumber = scanner.nextInt();
	        int index = findStudentIndexByRollNumber(rollNumber);
	        if (index == -1)
	        {
	            System.out.println("Student not found.");
	            return;
	        }
	        studentList.remove(index);
	        System.out.println("Student deleted successfully.");
	    }
	    public static void displayStudents() {
	        if (studentList.isEmpty())
	        {
	            System.out.println("No students found.");
	        }

	        System.out.println("Student Information:");
	        for (student student : studentList)
	        {
	        	System.out.println("--------------------------");
	            System.out.println("Name		: " + student.name);
	            System.out.println("Roll Number	: " + student.rollNumber);
	            System.out.println("Marks		: " + student.marks[0] + ", " + student.marks[1] + ", " + student.marks[2]);
	            System.out.println("Percentage 	: " + calculatePercentage(student.marks) + "%");
	            System.out.println("Grade		: " + calculateGrade(calculatePercentage(student.marks)));
	            System.out.println("--------------------------");
	        }
	    }

	    public static int findStudentIndexByRollNumber(int rollNumber)
	    {
	        for (int i = 0; i < studentList.size(); i++)
	        {
	            if (studentList.get(i).rollNumber == rollNumber)
	            {
	                return i;
	            }
	        }
	        return -1;
	    }
	    public static double calculatePercentage(int[] marks)
	    {
	        return (marks[0] + marks[1] + marks[2]) / (double) subjects;
	    }
	    public static String calculateGrade(double percentage)
	    {
	        if (percentage >= 90) {
	            return "A";
	        } else if (percentage >= 80) {
	            return "B";
	        } else if (percentage >= 70) {
	            return "C";
	        } else if (percentage >= 60) {
	            return "D";
	        } else if (percentage >= 35) {
	            return "E";
	        } else
	        	return "F";
	    }
}

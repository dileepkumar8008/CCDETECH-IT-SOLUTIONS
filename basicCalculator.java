package CodTechSolutions;

import java.util.Scanner;

public class basicCalculator {
	 public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("----------------------------------------");
			System.out.println("Welcome to Basic calculator");
			System.out.println("----------------------------------------");
			System.out.println("(+)Addition\n(-)Subtraction\n(*)Multiplication\n(/)Division");
			int i=1;
			while(i==1)
			{
			System.out.println("Enter the First Number:");
			long First=sc.nextInt();					
			System.out.println("Enter the Second Number:");
			long Second=sc.nextInt();
			int j=1;
			while(j==1)
			{
			System.out.println("What Would You Like to Perform:\n1)Addition\n2)Subtraction\n3)Multiplication\n4)Division");
			int choice=sc.nextInt();
			System.out.println("----------------------------------------");
			System.out.print("The Output: ");
			switch(choice)
			{
			case 1:System.out.println(First+" + "+Second+" = "+(First+Second));
			break;
			case 2:System.out.println(First+" - "+Second+" = "+(First-Second));
			break;
			case 3:System.out.println(First+" x "+Second+" = "+(First*Second));
			break;
			case 4: try
			          {
				         System.out.println(First+" / "+Second+" = "+((double)First/(double)Second));
			          }
			       catch(ArithmeticException e)
			           {
				          System.out.println("Number cannot be divided by zero");
			           }
			break;
			default:System.out.println("Please Enter valid Choice:");
			break;
			}
			System.out.println("----------------------------------------");
			if(choice<0 || choice>4) 
			{
				continue;
			}
			
			System.out.println("Would you Like to perform other Operation for same Numbers ?,enter 1 else 0 ");
			j=sc.nextInt();
			}
			System.out.println("Would You Like To Continue:");
			System.out.println("Enter 1 for continue\nEnter 2 for Exit");
			i=sc.nextInt();
			}
			System.out.println("Thank you Visit Again!");
			sc.close();
		}
}

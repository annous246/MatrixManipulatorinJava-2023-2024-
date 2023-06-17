package determinant;

import java.util.*;
import java.lang.RuntimeException;

public class main {
	public static void main(String[] args) {int n=0;
			System.out.println("Welcome to Matrix manipulator\n");
		do {
		try {int r,c;
		    boolean breaker=false;
		    matrix A,B,result;
		    Scanner in=new Scanner(System.in);
			System.out.println("Provide dimensions for the main matrix(rows/cols)");
		    r=in.nextInt();
		    c=in.nextInt();
		    A=new matrix(r,c);
			System.out.println("Provide matrix A values one by one");
			A.printFiller(A.n, A.m,'A',null,1);
			A.fill();
			A.print();
		    do {
			System.out.println("\n\nChoose Operation");
			System.out.println("Ax=B Solver (1)");
			System.out.println("Small Operations (2)");
			System.out.println("AxB Product (3)");
			System.out.println("A+B Sum (4)");
			System.out.println("A-B Difference (5)");
			System.out.println("Remind me of A (6)");
			System.out.println("Erase (0)");
			System.out.println("Shutdown (-1)");
		    n=in.nextInt();
		    switch(n) {
		    case -1:breaker=true;break;
		    case 0:breaker=true;break;
		    case 1:
		    	try {
		    	A.inverse();
		    	System.out.println("Provide dimensions for second matrix B");
		    	r=in.nextInt();
		    	c=in.nextInt();
		    	B=new matrix(r,c);
				B.printFiller(B.n, B.m,'B',null,1);
		    	System.out.println("Provide second matrix B");
		    	B.fill();
		    	B.print();
		    	 result=A.product(B);
		    	System.out.println("Solution of Ax=B system is");
		    	result.printFiller(A.n, B.m, 'X',result,2);}
		    	catch(Exception p) {
		    		System.out.println(p);
		    	}
		    	break;
		    case 2:boolean breaker2=false;
		    	do {if(A.m!=A.n)throw new matrixException("Square matrix is needed");
		    		System.out.println("\n\nChoose operation to run on your matrix");
					System.out.println("Determinant of matrix A (1)");
					System.out.println("Inverse A (2)");
					System.out.println("Exit small operations(0)");
		    		n=in.nextInt();
					switch(n) {
					case 1:
					System.out.println("Determinant of A is "+matrix.getDet(A.mat, A.m, 0));
					break;

					case 2:try{A.inverse();
					System.out.println("Inversed A ");
					A.print();}
					catch(Exception e) {
						System.out.println();
					}
					break;
					case 0:breaker2=true;break;
					
					}
		    		if(breaker2)break;
		    	}while(true);
		    	
		    	break;

		    case 3:
		    	
                try{
		    	System.out.println("Provide dimensions for second matrix B");
		    	r=in.nextInt();
		    	c=in.nextInt();
		    	 B=new matrix(r,c);
				B.printFiller(B.n, B.m,'B',null,1);
		    	System.out.println("Provide second matrix B");
		    	B.fill();
		    	B.print();
		    	 result=A.product(B);
		    	System.out.println("Solution of AxB  is");
		    	result.print();
		    	do {
		    	System.out.println("Do you wanna keep the result as main matrix? (yes=1)(no=0)");
		    	n=in.nextInt();
		    	}while(n!=1&&n!=0);
		    	if(n==1)A=result;}
		    	catch(Exception p) {
		    		System.out.println(p);
		    	}
		    	;break;
		    case 4:
                 try{
		    	System.out.println("Provide dimensions for second matrix B");
		    	r=in.nextInt();
		    	c=in.nextInt();
		    	 B=new matrix(r,c);
				B.printFiller(B.n, B.m,'B',null,1);
		    	System.out.println("Provide second matrix B");
		    	B.fill();
		    	B.print();
		    	 result=A.sum(B);
		    	System.out.println("Solution of A+B  is");
		    	result.print();
		    	do {
		    	System.out.println("Do you wanna keep the result as main matrix? (yes=1)(no=0)");
		    	n=in.nextInt();
		    	}while(n!=1&&n!=0);
		    	if(n==1)A=result;;break;}

 		    	catch(Exception p) {
 		    		System.out.println(p);
 		    	}
		    case 5:
               try {
		    	System.out.println("Provide dimensions for second matrix B");
		    	r=in.nextInt();
		    	c=in.nextInt();
		    	 B=new matrix(r,c);
				B.printFiller(B.n, B.m,'B',null,1);
		    	System.out.println("Provide second matrix B");
		    	B.fill();
		    	B.print();
		    	 result=A.diff(B);
		    	System.out.println("Solution of A-B  is");
		    	result.print();
		    	do {
		    	System.out.println("Do you wanna keep the result as main matrix? (yes=1)(no=0)");
		    	n=in.nextInt();
		    	}while(n!=1&&n!=0);
		    	if(n==1)A=result;
               }

		    	catch(Exception p) {
		    		System.out.println(p);
		    	}
		    	break;
		    case 6:A.print();break;
		    }
		    if(breaker)break;
		    
			}while(true);
			
			
			
			
		}
		catch(matrixException e) {
			System.out.println(e);
		}
		catch(InputMismatchException e) {
			System.out.println("wrong input type");
		}
		
		
		if(n==-1)break;}while(true);
	}

}

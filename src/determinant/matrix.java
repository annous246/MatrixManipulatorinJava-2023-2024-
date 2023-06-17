package determinant;
import java.util.*;
public class matrix {
	double mat[][];
	int m=2,n=2;
	 double determ=0;
	 matrix(int n,int m)throws matrixException{this.m=m;this.n=n;
		if(m<1||n<1)throw new matrixException("Illegal Dimensions");
		mat=new double [n][m];
	}

	 matrix() {
		mat=new double [n][m];
		
	}
	 matrix(double ma[][],int n,int m) throws matrixException{
		if(m<2||n<2)throw new matrixException("Illegal Dimensions");
		mat=new double [n][m];
		this.n=n;this.m=m;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				mat[i][j]=ma[i][j];
			}}
		
	}
	 boolean square(matrix m) {
		 return m.m==m.n;
	 }
	void fill() {Scanner in=new Scanner(System.in);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				mat[i][j]=in.nextDouble();
			}
			
		}
	}
	void print() {
	for(int i=0;i<n;i++) {System.out.print("[");
	
		for(int j=0;j<m;j++) {
			System.out.print(mat[i][j]);
			if(j==m-1)System.out.print("]");
			else System.out.print("  ");
			
		}
		System.out.println(" ");
		System.out.println(" ");
		
	}
}

	void printFiller(int n,int m,char c,matrix k,int a) throws matrixException{
		
		if(a==1) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print("("+c+(i+1)+(j+1)+") ");
				
			}
			System.out.println(" ");
			System.out.println(" ");
			
		}}
		else if(a==2) {
			if(k.m!=m||k.n!=n)throw new matrixException("Incompatible for print");

			for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print("("+c+(i+1)+(j+1)+") = "+k.mat[i][j]);
				
			}
			System.out.println(" ");
			System.out.println(" ");
			
		}}
		
		
	}

	 static double getDet(double m[][],int d,double ans) throws matrixException{
		if(d==1)return m[0][0];
		if(d==2) {
			return (m[0][0]*m[1][1]-m[0][1]*m[1][0]);         
			}
			for(int i=0;i<d;i++) {
				double tm[][]=new double [d-1][d-1] ;Vector<Double> v=new Vector<Double>();
				for(int j=0;j<d;j++) {
					for(int l=0;l<d;l++) {
				 if(j!=0&&l!=i) {
					 v.add(m[j][l]);
				 }
			}
					}
				int c=0;
				for(int j=0;j<d-1;j++) {
						for(int l=0;l<d-1;l++) {
							tm[j][l]=v.get(c);c++;
						}
						
					}
				double sum=m[0][i]*getDet(tm,d-1,0);
				if(i%2==1)sum*=-1;
				ans+= sum;
				
				
			}return ans;
			
		
	}

	 public  void inverse() throws matrixException{int d=m;
		 if(getDet(mat,d,0)==0)throw new matrixException("matrix not inversible (determinant = 0) ");int s=0,sig=0;double res[][]=new double[d-1][d-1];Vector<Double> r=new Vector<Double>();
		 sig=1;
		 for(int i=0;i<d;i++) {
			 for(int j=0;j<d;j++) {Vector<Double> v=new Vector<Double>();s=0;sig=1-sig;
				 for(int k=0;k<d;k++) {if(k==i)continue;
					 for(int c=0;c<d;c++) {if(c==j)continue;
						 v.add(mat[k][c]);
					 }
					 
				 }
		 for(int e=0;e<d-1;e++) {
			 for(int f=0;f<d-1;f++) {
				 res[e][f]=v.get(s);s++;
				 }}
		 double value=getDet(res,d-1,0);if(sig==1)value*=-1;
		 r.add(value);
				 
			 }
			 
		 }
		 double det=getDet(mat,d,0);s=0;
		 for(int i=0;i<d;i++) {
			 for(int j=0;j<d;j++) {
				 
				 mat[j][i]=r.get(s)/det;s++;
			 }}
		 
		 
		 
	 }
	 public matrix product(matrix d) throws matrixException{
		 int n=d.n,m=d.m;double ma[][]=new double [n][m];ma=d.mat;
		 if(this.m!=n)throw new matrixException("incompatible product");
		 Vector<Double> v=new Vector<Double>();
		 for(int k=0;k<this.n;k++) {
			 for(int j=0;j<m;j++) {double sum=0;
		 for(int i=0;i<n;i++) {
			 sum+=mat[k][i]*ma[i][j];
		 }
			 v.add(sum);}
		 
	 }matrix res= new matrix(this.n,m);int k=0;
	 for(int i=0;i<this.n;i++) {
		 for(int j=0;j<m;j++) {
			 res.mat[i][j]=v.get(k);k++;
		 }}return res;
		 }

	 public matrix sum(matrix d) throws matrixException{
		 int n=d.n,m=d.m;double ma[][]=new double [n][m];ma=d.mat;
		 if(this.m!=m||this.n!=n)throw new matrixException("incompatible sum");
		 matrix res= new matrix(n,m);
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<m;j++) {
			 res.mat[i][j]=this.mat[i][j]+ma[i][j];
		 }}return res;
		 
		 
	 }
	 public matrix diff(matrix d) throws matrixException{
		 int n=d.n,m=d.m;double ma[][]=new double [n][m];ma=d.mat;
		 if(this.m!=m||this.n!=n)throw new matrixException("incompatible sum");
		 matrix res= new matrix(n,m);
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<m;j++) {
			 res.mat[i][j]=this.mat[i][j]-ma[i][j];
		 }}return res;
		 
		 
	 }
	
	
}

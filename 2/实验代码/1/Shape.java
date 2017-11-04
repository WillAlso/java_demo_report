import java.util.*;
interface Geometricinterface{
	void Permeter();
	void Area();
}
class Triangle implements Geometricinterface{
	private double a = 0;
	private double b = 0;
	private double c = 0;
	Triangle(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the Triangle's information:");
		double d = input.nextDouble();
		double e = input.nextDouble();
		double f = input.nextDouble();
		if(d+e>f && d+f>e && e+f>d){
			a = d;
			b = e;
			c = f;
		}
		else{
			System.out.println("Error!");
		}
			
	}
	public void Permeter(){
		double i = a+b+c;
		System.out.println("The triangle's permeter is " + i);
	}
	public void Area(){
		double p = 0.5*(a+b+c);
		double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		System.out.println("The triangle's area is " + s);	
	}
}
class Rectangle implements Geometricinterface{
	private double length = 0;
	private double width = 0;
	Rectangle(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the rectangle's length and width");
		length = input.nextDouble();
		width = input.nextDouble();
	}
	public void Permeter(){
		double c = 2*(length+width);
		System.out.println("The rectangle's permeter is " + c);
	}
	public void Area(){
		double s = length*width;
		System.out.println("The rectangle's area is " + s);
	}
}
class Shape{
	public static void main(String[] args){
		Geometricinterface[] temp = new Geometricinterface[2];
		temp[0] = new Triangle();
		temp[1] = new Rectangle();
		temp[0].Permeter();
		temp[0].Area();
		temp[1].Permeter();
		temp[1].Area();
	}
}

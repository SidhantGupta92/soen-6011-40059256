import java.io.*;
import java.util.*;

public class D2 {

	// Algorithm for tan(x), where x is in degrees
	public double tan(double x) {
		
		try
		{
		// Check periodicity i.e. reduce x to the range 0<= x <= 180
		if (!(x >= 0.0 && x <= 180.0)) {
			int multiplier = (int) x / 180;
			x = x - (180.0 * multiplier);
		}
		//check 90 and corresponding angles 
		if(x == 90.0)
		{
			throw new ArithmeticException("Undeifned");
		}

		// Check symmetry i.e. if x is in 1st quadrant or not
		// Reduce x to first quadrant
		if (x > 90.0 && x <= 180.0) {
			x = x - 180.0;
		}
		
		//if x is negative at this point
		int y = 1;
		if(x < 0)
		{
			y = -1;
		}
		
		//Use co-function
		if(Math.abs(x)>= 45.0 && Math.abs(x) < 90.0)
		{
			return (y)*(1/tan(90.0 - Math.abs(x)));
		}
		
		if(Math.abs(x) >= 22.5 && Math.abs(x) <45.0 )
		{
			double result = tan(Math.abs(x)/2);
			return (double)y*((2*result)/(1- Math.pow(result, 2)));
		}
		
		if( Math.abs(x)>=0 && Math.abs(x) <= 22.5)
		{
			double radians = Math.abs(x) * (Math.PI /180);
			double result = radians + (Math.pow(radians, 3)/3) + (2* Math.pow(radians, 5)/15) + (17* Math.pow(radians, 7)/315);
			return (y)*result;
		}
		}
		catch(ArithmeticException ex)
		{
			System.out.println(ex.getMessage());
		}
		return Double.NaN;
	}
	
	public static void main(String[] args)
	{
		D2 objD2 = new D2();
//		System.out.println(objD2.tan(194));
//		System.out.println(objD2.tan(110));
//	
//		System.out.println(objD2.tan(40));
//		System.out.println(objD2.tan(90));
		System.out.println(objD2.tan(270));
	}
}

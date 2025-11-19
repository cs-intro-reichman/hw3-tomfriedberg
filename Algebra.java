// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		
		
		for(int n = 1;n<=x2;n++)
	{
		x1++;
	}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		
		for(int n = 1;n<=x2;n++)
	{
		x1--;
	}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		
		int m = x1;
		for(int n = 1;n<=m;n++)
	{
			for(int i = 1;i<x2;i++)
		{
			x1++;
		}
	}
		return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int m = x;

		if(n==0)
		{
			return 1;
		}

		for(int l = 1;l<n;l++)
		{
			x = times(x, m);
		}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int m = 0;

		while(x1>=x2)
		{
			x1 = minus(x1, x2);
			m++;
		}
		return m;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int m = 0;

		while(x1>=x2)
		{
			x1 = minus(x1, x2);
			m++;
		}
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) 
	{
		if (x == 0 || x == 1) 
		{
        return x;
    }

    int low = 1;
    int high = x;
    int result = 0; 

    while (low <= high) {
        
        int mid = div(plus(low, high), 2); 
        int midSquared = pow(mid, 2); 

        if (minus(x, midSquared) >= 0) { 
            result = mid; 
            low = plus(mid, 1);
        } else {
            high = minus(mid, 1);
        }
    }

    return result;
	}	  	  
}
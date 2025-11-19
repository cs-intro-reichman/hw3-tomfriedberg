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
		
        int result = x1;
        
        if (x2 > 0) {
            int i = 0;
            while (i < x2) {
                result++;
                i++;
            }
        } else if (x2 < 0) {
            int i = 0;
            while (i > x2) { 
                result--;
                i--;
            }
        }
        return result;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		
		if (x2 < 0) {
            return plus(x1, minus(0, x2)); 
        }
        
        int result = x1;
        int i = 0;
        while (i < x2) {
            result--;
            i++;
        }
        return result;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		
		boolean negativeResult = false;
        if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
            negativeResult = true;
        }
        
        int absX1 = x1;
        if (x1 < 0) {
            absX1 = minus(0, x1);
        }
        int absX2 = x2;
        if (x2 < 0) {
            absX2 = minus(0, x2);
        }
        
        int result = 0;
        int i = 0;
        while (i < absX2) {
            result = plus(result, absX1);
            i++;
			}
        
        if (negativeResult) {
            return minus(0, result);
        }
        return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) 
	{
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        
        if (x < 0) {
            if (mod(n, 2) == 0) {
                return pow(minus(0, x), n);
            } else {
                return minus(0, pow(minus(0, x), n));
            }
        }
        
        int result = 1;
        int i = 0;
        
        while (i < n) {
            result = times(result, x);
            i++;
        }
        
        return result;
	}

		

	

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x2 == 0) {
            return 0; 
        }
        
        boolean negativeResult = false;
        if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
            negativeResult = true;
        }
        
        int absX1 = x1;
        if (x1 < 0) {
            absX1 = minus(0, x1);
        }
        int absX2 = x2;
        if (x2 < 0) {
            absX2 = minus(0, x2);
        }
        
        int count = 0;
        int tempX1 = absX1;
        
        while (tempX1 >= absX2) {
            tempX1 = minus(tempX1, absX2);
            count++;
        }
        
        if (negativeResult) {
            return minus(0, count);
        }
        return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2 == 0) {
            return 0; 
        }
        
        if (x1 < 0 || x2 < 0) {
             return minus(x1, times(div(x1, x2), x2));
        }

        int tempX1 = x1;
        
        while (tempX1 >= x2) {
            tempX1 = minus(tempX1, x2);
        }
        
        return tempX1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) 
	{
		if (x < 0) {
            return 0;
        }
        
        int i = 0;
        while (times(i, i) <= x) {
            i++;
        }
        
        return minus(i, 1);
    }
}
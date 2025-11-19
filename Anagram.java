/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String cleaned1 = preProcess(str1);
        String cleaned2 = preProcess(str2);

        if (cleaned1.length() != cleaned2.length()) {
            return false;
        }
        
        String temp = cleaned1; 
        
        int i = 0;
        while (i < cleaned2.length()) {
            char targetChar = cleaned2.charAt(i);
            
            int j = 0;
            int foundIndex = -1; 
            
            while (j < temp.length()) {
                if (temp.charAt(j) == targetChar) {
                    foundIndex = j; 
                    break;
                }
                j++;
            }
            
            if (foundIndex == -1) {
                return false; 
            }
            
            String newTemp = "";
            j = 0;
            while (j < temp.length()) {
                if (j != foundIndex) {
                    newTemp = newTemp + temp.charAt(j);
                }
                j++;
            }
            temp = newTemp;
            
            i++;
        }
        
        return temp.length() == 0;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String lowerCaseStr = str.toLowerCase();
        String cleaned = ""; 
        
        int i = 0;
        while (i < lowerCaseStr.length()) {
            char c = lowerCaseStr.charAt(i);
            
            // שמירת אותיות קטנות ורווחים בלבד
            if ((c >= 'a' && c <= 'z') || c == ' ') { 
                cleaned = cleaned + c; 
            }
            i++;
        }
        return cleaned;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String remainingChars = str; 
        String result = "";
        
        java.util.Random random = new java.util.Random();
        
        while (remainingChars.length() > 0) {
            
            int randomIndex = random.nextInt(remainingChars.length());
            char randomChar = remainingChars.charAt(randomIndex);
            
            result = result + randomChar; 
            
            String newRemainingChars = "";
            
            int i = 0;
            while (i < remainingChars.length()) {
                
                if (i != randomIndex) {
                    newRemainingChars = newRemainingChars + remainingChars.charAt(i);
                }
                
                i++;
            }
            
            remainingChars = newRemainingChars;
        }
        
        return result;
	}
}

/**
 * 
 */
package cp120.assignments.assignment005;

/**
 * @author Jack Lisenko
 *
 */
public class Crypto {
	
	public static void main(String[] args)  {
		
		String test = "abcdefghi";
		String answer = encrypt(test);
		System.out.println(test);
		System.out.println(answer);
		String answer2 = decrypt(answer);
		System.out.println(answer2);		
	}	
	
	public static String encrypt( String str ) {
		int lengthString = str.length();
		int pad = 3 - lengthString%3;
		StringBuilder word = new StringBuilder();
		word.append(str);
		for(int i = 0; i < pad; i++) {
			word.append('\u0000');
		}
		
		if(word.length() > 3) {
			String t1 = word.substring(word.length() - 3, word.length());
			word = word.delete(word.length() - 3, word.length()).insert(0, t1);
		}
		
		char[] charWordArray = word.toString().toCharArray();
		
		for (int i = 0; i < charWordArray.length; i++) {
			//charWordArray[i] = (char)((int)charWordArray[i] + i);
			charWordArray[i] = (char)(charWordArray[i] + i);
		}
		return String.valueOf(charWordArray);
		
	}
	
	public static String decrypt( String str ) {
		char[] charWordArray = str.toCharArray();
		for (int i = 0; i < charWordArray.length; i++) {
			charWordArray[i] = (char)((int)charWordArray[i] - i);		
		}
		
		StringBuilder word = new StringBuilder();
		word.append(charWordArray);
		word.append(word.substring(0, 3));
		word.delete(0, 3);
		int j;
		for(int i = 0; i < 3; i++) {
			j = word.length() - 1;
			if(word.charAt(j) == '\u0000') {
				word.deleteCharAt(j);				
			}
		}
		return word.toString();
	}
}

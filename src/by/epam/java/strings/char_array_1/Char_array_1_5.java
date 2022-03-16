
/*
* Strings
 * —трока как массив символов, задание 5
 *ѕосчитать количество чисел в строке
 */

package by.epam.java.strings.char_array_1;

public class Char_array_1_5 {
	
	public static void main(String[] args) {

		String str = "   22vmdgtj  w5or6d66    dr6 66m6ilo8423dvt  w0ord9 45265 87dir45     mtoiv word55  ";
		
		str = delDubSpace(str);
		str = str.trim();
		System.out.print(str);
	}
	
	/*
	 * метод удал€ет все пробелы более одного подр€д.
	 */
	public static String delDubSpace (String str) {
		
		String sample = "  ";
	
		for (int i = 0; i<(str.length()-1); i++) {
			
			String ch = str.substring(i,(i+2));

			if(sample.equals(ch)) {
				
				str = str.substring(0,i+1) + str.substring((i+2),str.length());
				i--;
			}
		}
		return str;
	}
}

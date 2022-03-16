
/*
* Strings
 * Строка как массив символов, задание 3
 *Посчитать количество цифр в строке
 */

package by.epam.java.strings.char_array_1;

public class Char_array_1_3 {

	public static void main(String[] args) {
		
		String str = "vmdgtj w5or6d66 dr6 66m6ilo8dvt w0ord9 l87dir45jmt9oiv word";
		int count = 0;
		
		for(int i = 0; i<str.length(); i++) {
			
			char ch;
			
			ch = str.charAt(i);
			if(Character.isDigit(ch)) {
				count++;
			}
		}
		System.out.print("Строка содержит "+count+" цифр");
	}
}

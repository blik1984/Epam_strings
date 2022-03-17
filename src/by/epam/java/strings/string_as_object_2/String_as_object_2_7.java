
/*
* Strings
 * Строка как объект, задание 7
 *Вводится строка, необходимо удалить повторяющиеся символы и все пробелы
 */

package by.epam.java.strings.string_as_object_2;

import java.util.Scanner;

public class String_as_object_2_7 {

	public static void main(String[] args) {
		
		String delSymb = " ";
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		while(true) {
			
			String str = S.nextLine();
		
			str = delSymb(str,delSymb);
			str = delDubSymb(str);
		
			System.out.println(str);
		}
	}
	
	/*
	 * метод удаляет из строки все вхождения любого заданного символа
	 */
	public static String delSymb(String str, String delSymb) {
		
		int x;
		
		do {
			x = str.indexOf(delSymb);
			if(x>=0) {
				str = str.substring(0,x)+str.substring(x+1,str.length());
			}
			x = str.indexOf(delSymb);

		} while(x>=0);
		
		return str;
	}
	 /*
	  * Метод удаляет из строки дублирующиеся символы, один символ в разных регистрах считается за два разных символа
	  */
	public static String delDubSymb(String str) {
		
		String symb;
		String dubSymb;
		
		for(int i=0; i<str.length();i++) {
			symb = str.substring(i,i+1);
		
			for (int l = (i+1); l<str.length(); l++) {
				
				dubSymb = str.substring(l,l+1);
				
				if (symb.equals(dubSymb)) {
					str = str.substring(0,l)+str.substring(l+1,str.length());
					l--;
				}
			}
		}
	return str;
	}
}

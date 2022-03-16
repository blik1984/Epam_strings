
/*
* Strings
 * Строка как объект, задание 9
 *В строке слова разделены пробелами, найти самое длинное слово и вывести на экран. 
 *Случай наличия слов одинаковой длины не обрабатывать
 */

package by.epam.java.strings.string_as_object_2;

import java.util.Scanner;

public class String_as_object_2_9 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		while(true) {
			
			int count1 = 0;
			
			String str = S.nextLine();
			
			for(int i = 0; i<str.length(); i++) {
				
				char symb = str.charAt(i);
				if(symb>63&&symb<91|| symb>96&&symb<123) {
					
					count1++;
					} 
				}
			System.out.println("Количество символов английского алфавита в строке = " + count1);
		}
	}
}
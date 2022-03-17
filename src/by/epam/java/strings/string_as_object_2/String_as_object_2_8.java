
/*
* Strings
 * Строка как объект, задание 8
 *В строке слова разделены пробелами, найти самое длинное слово и вывести на экран. 
 *Случай наличия слов одинаковой длины не обрабатывать
 */

/*
 * При наличии нескольких слов с максимальным количеством знаков, будем выводить первое введённое
 */

package by.epam.java.strings.string_as_object_2;

import java.util.Scanner;
import by.epam.java.strings.char_array_1.Char_array_1_5;

public class String_as_object_2_8 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		while(true) {
			
			String word = "";
			String word2 = "";
			String space = " ";
			int count1 = 0;
			int count2 = 0;
			String str = S.nextLine();
			
			str = Char_array_1_5.delDubSpace(str);
			str = str.trim();

			for(int i = 0; i<str.length(); i++) {
				
				String symb = str.substring(i, (i+1));
				
				if(!symb.equals(space)) {
					
					word = word.concat(symb);
					count1++;
					
				} else {
					
					if(count1>count2) {
					word2 = word;
					count2 = count1;
					word = "";
					count1 = 0;
					} else {
						word = "";
						count1 = 0;
					}
				}
			}
			if(count1>count2) {
					word2 = word;
					count2 = count1;
				}
			System.out.println("Слово " + word2 + " самое длинное, количество символов в слове = " + count2);
			
		}
	}
}

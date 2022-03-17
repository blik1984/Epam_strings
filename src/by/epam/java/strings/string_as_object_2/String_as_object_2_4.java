
/*
* Strings
 * Строка как объект, задание 4
 *С помощью функции копирования и операции конкатенации из слова ИНФОРМАТИКА составить слово ТОРТ
 */

package by.epam.java.strings.string_as_object_2;

public class String_as_object_2_4 {

	public static void main(String[] args) {
		
		String Str = "информатика";
		String Str2 = Str.substring(7,8); 
		Str2 = Str2.concat(Str.substring(3,5));
		Str2 = Str2.concat(Str.substring(7,8));
		System.out.print(Str2);
	}
}

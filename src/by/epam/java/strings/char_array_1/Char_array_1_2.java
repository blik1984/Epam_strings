
/*
* Strings
 * ������ ��� ������ ��������, ������� 2
 *�������� � ������ ��� ��������� "word" �� "letter"
 */

package by.epam.java.strings.char_array_1;

public class Char_array_1_2 {

	public static void main(String[] args) {
		
		String str = "vmdgtj word dr milodvt word ldir5jmtoiv word";

		str = str.replaceAll("word", "letter");
		System.out.print(str);	
	}
}

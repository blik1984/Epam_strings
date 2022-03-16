
/*
* Strings
 * Строка как объект, задание 3
 *Проверить является ли слово палиндромом
 */

package by.epam.java.strings.string_as_object_2;

import java.util.ArrayList;

public class String_as_object_2_3 {

	public static void main(String[] args) {
		
		ArrayList<String> masStr = new ArrayList<>();
		masStr.add("");			//по сути пустота тоже палиндром, с какой стороны на неё ни посмотри
		masStr.add("112211");
		masStr.add("masVar2");
		masStr.add("ara");
		masStr.add("masVar4");
		masStr.add("ArrarRa");
		masStr.add("     ");
		
		for (int i = 0; i<masStr.size(); i++) {
			String Str = masStr.get(i);
			StringBuffer rev = new StringBuffer(masStr.get(i));
			rev.reverse();
			String revStr = ""+rev;
			if(revStr.equalsIgnoreCase(Str)) {
				System.out.println("Слово " + masStr.get(i) + " является палиндромом");
			}
		}
	}
}

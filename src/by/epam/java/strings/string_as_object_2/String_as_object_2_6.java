
/*
* Strings
 * Строка как объект, задание 6
 *Из данной строки получить новую, повторив каждый символ дважды
 */

package by.epam.java.strings.string_as_object_2;

public class String_as_object_2_6 {

	public static void main(String[] args) {
		
		String str = " a  22vmadgtj  w5or6ad66    dr6 66m6ilo84aa23dvt  w0ord9 45a265 87dir45     mtoiv word55  a    a";
		StringBuffer promStr = new StringBuffer (str);
		for(int i = 0; i<promStr.length(); i=i+2) {
			
			promStr.insert(i,promStr.charAt(i));
		}
		System.out.print(promStr);
	}
}

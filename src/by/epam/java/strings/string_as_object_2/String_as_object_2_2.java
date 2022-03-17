
/*
* Strings
 * Строка как объект, задание 2
 *В строке после каждого символа "а" вставить символ "b"
 */

package by.epam.java.strings.string_as_object_2;

public class String_as_object_2_2 {

	public static void main(String[] args) {
		
		String str = " a  22vmadgtj  w5or6ad66  a  dr6 66m6ilo84aa23dvt  w0ord9 45a265 87dir45     mtoiv word55  a    a";
		String sample = "a";
		String sample2 = "b";
		System.out.println("Исходная строка: " + str);
		for(int i = 0; i<str.length(); i++) {
			
			String ch = str.substring(i,(i+1));
			if(sample.equals(ch)) {
				
				str = str.substring(0,i+1) + sample2+str.substring((i+1), str.length());
			}
		}
		System.out.println("Измененная строка: " + str);
	}
}


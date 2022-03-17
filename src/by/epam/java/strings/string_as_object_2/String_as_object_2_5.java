
/*
* Strings
 * Строка как объект, задание 5
 *Посчитать сколько раз в строке встречается буква "а"
 */

package by.epam.java.strings.string_as_object_2;

public class String_as_object_2_5 {

	public static void main(String[] args) {
		
		String str = " a  22vmadgtj  w5or6ad66    dr6 66m6ilo84aa23dvt  w0ord9 45a265 87dir45     mtoiv word55  a    a";
		String flag = "a";
		int Count = 0;
		
		for(int i = 0; i<str.length();i++) {
			String strProm = str.substring(i,i+1);
			if(flag.equals(strProm)) {
				Count++;
			}
		}
		System.out.print(Count);
	}
}


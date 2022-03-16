
/*
* Strings
 * Строка как объект, задание 1
 *Найти наибольшее количество подряд идущих пробелов в строке
 */

package by.epam.java.strings.string_as_object_2;

public class String_as_object_2_1 {

	public static void main(String[] args) {
		
		String str = "   22vmdgtj  w5or6d66    dr6 66m6ilo8423dvt  w0ord9 45265 87dir45     mtoiv word55      ";
		String sample = " ";
		int count = 0;
		int maxCount = 0;
		
		for(int i = 0; i<str.length(); i++) {
			
			String ch = str.substring(i,(i+1));
			if(sample.equals(ch)) {
				
				count++;
				if(count>maxCount) {
					
					maxCount = count;
				}
			}else {
				
				count = 0;
			}
		}
		System.out.print(maxCount);
	}
}

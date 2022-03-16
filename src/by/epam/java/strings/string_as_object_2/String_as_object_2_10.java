
/*
* Strings
 * Строка как объект, задание 10
 *Строка состоит из предложений, которые отделяются точкой, восклицательным или вопросительным знаком.
 *Посчитать количество предложений.
 */

package by.epam.java.strings.string_as_object_2;

public class String_as_object_2_10 {

	public static void main(String[] args) {
		
		String str = "Маша мыла раму. Рама была из поливинилхлорида с двойным стеклопакетом. "
				+ "Мойка осуществлялась царской водкой. Вопрос: сколько осталось Маше?";
		String flag = "!?.";
		int count = 0;
		
		for(int i = 0; i<flag.length();i++) {
			String symb = flag.substring(i, i+1);
			count = count + countSymb(str, symb);
		}
		System.out.println("Количество предложений в тексте = "+count);
	}
	
	 /*
	  * метод считает количество вхождений данного заданного символа в заданной строке
	  */
	public static int countSymb (String str, String symb) {
		int count = 0;
		for(int i = 0; i<str.length();i++) {
			String symb2 = str.substring(i,i+1);
			if(symb.equals(symb2)) {
				count++;
			}
		}
		return count;
	}
}

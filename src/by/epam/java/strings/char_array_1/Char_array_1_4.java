
/*
* Strings
 * ������ ��� ������ ��������, ������� 4
 *��������� ���������� ����� � ������
 */

/*
 * ������ ����� ������� ����� ��������� ����, ������� ���� ��������������� ���� �� ������ ��� ��������
 */

/*
 * �������� ������� �������� ��������, ������� �����, ����� ��������, ��������� �������, ��������� ������ �������,
 *  ��� ������ ��������� ������ �� ����� - ����� �����������.
 */
package by.epam.java.strings.char_array_1;

public class Char_array_1_4 {

	public static void main(String[] args) {

		String str = "22vmdgtj w5or6d66 dr6 66m6ilo8423dvt w0ord9 45265 87dir45jmtoiv word55";
		int count = 0;
		
		for (int i = 0; i<str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if(Character.isDigit(ch)) {
				count++;
				for (int k = (i+1); k<str.length(); k++) {
					i++;
					char ch2 = str.charAt(k);
					
					if(!Character.isDigit(ch2)) {
						
						k = str.length();
					}
				}
			}
		}
		System.out.print(count);
	}
}


/*
* Strings
 * ������ ��� ������, ������� 9
 *� ������ ����� ��������� ���������, ����� ����� ������� ����� � ������� �� �����. 
 *������ ������� ���� ���������� ����� �� ������������
 */

package by.epam.java.strings.string_as_object_2;

import java.util.Scanner;

public class String_as_object_2_9 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		while(true) {
			
			int count1 = 0;
			
			String str = S.nextLine();
			
			for(int i = 0; i<str.length(); i++) {
				
				char symb = str.charAt(i);
				if(symb>63&&symb<91|| symb>96&&symb<123) {
					
					count1++;
					} 
				}
			System.out.println("���������� �������� ����������� �������� � ������ = " + count1);
		}
	}
}
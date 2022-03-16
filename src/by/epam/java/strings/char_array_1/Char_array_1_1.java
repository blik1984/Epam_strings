
/*
* Strings
 * ������ ��� ������ ��������, ������� 1
 *��� ������ �������� ���������� � camelCase, ��������� � snake_case.
 */
/*
 * �� ������� ��� ����������� ������. ����������� ��� ��� ArrayList.
 * ���� ������ ���������� ����������� ������ �������, �� ��������� � ������ convertCamelToSnake()
 * ���������� ���������� ����� ���� ��� � �������� ���� ����� ���� ������.
 */


package by.epam.java.strings.char_array_1;

import java.util.ArrayList;


public class Char_array_1_1 {

	public static void main(String[] args) {
		
		ArrayList<String> masVar = new ArrayList<>();
		masVar.add("masVar");
		masVar.add("masVar1 masVar1 masVar1");
		masVar.add("masVar2");
		masVar.add("masVar3");
		masVar.add("masVar4");
		masVar.add("masVar5");
		masVar.add("masVar6");
		
		for (int i = 0; i<masVar.size(); i++) {
			
			String promVal = masVar.get(i);
			promVal = convertCamelToSnake(promVal);
			masVar.set(i,promVal);
		}
		for(int i = 0; i<masVar.size(); i++) {
			System.out.println(masVar.get(i));
		}
	}
	
	/*
	 * ����� ���� � ������ ������� � ������� �������� � ������ �� �� ������, 
	 * ��� ���� ��������� ����� ��������� �������� ������ �������������
	 */
public static String convertCamelToSnake (String promString) {
	
	for (int i = 0; i<promString.length(); i++) {
		
		char Symb = promString.charAt(i);
		
		if (Character.isUpperCase(Symb)) {
			
			Symb = Character.toLowerCase(Symb);
			promString = promString.substring(0,i)+"_"+Symb+promString.substring((i+1),promString.length());
			}
		}
	return promString;
	}
}

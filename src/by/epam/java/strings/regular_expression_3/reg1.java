
/* Strings_and_basics_of_text_processing. ���������� ��������� 1.
������� ����������, ����������� ����� (����� �������� � ������) � ����������� ��������� � ������� ��� ��������� ��������: ������������� ������ �� ���������� �����������;
� ������ ����������� ������������� ����� �� �����;
������������� ������� � ����������� �� �������� ���������� ��������� ��������� �������, � � ������ ��������� - �� ��������.
 */

package by.epam.java.strings.regular_expression_3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class reg1 {

	public static void main(String[] args) {
		String string = new String();
		string = "�� ��������� ��������������� ����� ����� �� ������ �������� ���������� ���� ����������� ����������� ����������� ����������� "
				+ "�������� ����������� � ������������, "
				+ "��������� �� ������������ � 6 ��������� � ����������� 7 ������� ������.\r\n"
				+ "�� ������ �������� � ����������� ������������ � ��������� � ������������ � ������������ ��� "
				+ "�������� ����������� � ������������."
				+ "� �������� ������ �������� ������ ����������������� ����������. ������� 25 ����������������� ����������, "
				+ "� ������ �����������-����� �������������, �� ���� ������� �������������� ������ ������-��������� � "
				+ "��������� ������� � ����������� �� ���� ��������� �����-����� ���������, ��������, ��������� � ��������� "
				+ "����� ����� ���� ��������� ���������. \r\n"
				+ "��� ����������������� ����������, �� ���� ������� ����������-���� ������ ��������������� � ��������� "
				+ "����������� �� ���� ������-��� ����������, ���������� ����������� ���� ������ ������� � �����-������ �� "
				+ "���� ��������������� ����������. \r\n"
				+ "����������� ������ � �������� 48 ������� �������� � ����� �����-����������� ������� ������, "
				+ "���� �������������� ������, ���� ����������� ������, ���� ������������� ������, ���� ������������� ������, "
				+ "����� ���������� ������� ������, ����� ����������� ������� ������, ���� ��������������� ������. "
				+ "��� ������� �������� �������� �� �������� � ��������������.\r\n";

		int flag = 0;
		System.out.println("1 - ������������� ������ �� ���������� ����������� \n2 - � ������ ����������� ������������� ����� �� ����� "
				+ "\n3 - ������������� ������� �� ���������� "
				+ "��������� ��������� ������� ");
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		do {
			System.out.println("�������� ����������� �������� � ������� ��������������� �����");
			
		String stringFlag = S.nextLine();
						
			if (stringFlag.equals("1")) {
				flag=1;
			}else if (stringFlag.equals("2")) {
				flag=2;
			}else if(stringFlag.equals("3")) {
					flag=3;
				}
		}while (flag == 0);
		
		Pattern PatternParagraphs = Pattern.compile("\\n*(\\n)\\n*");			//������� �� ������
		String[] paragraphs = PatternParagraphs.split(string);
		
		Pattern PatternSentences = Pattern.compile("\\s*(\\.+|!+|\\?+)\\s*");	//������� �� �����������
		String[] sentences = PatternSentences.split(string);
		
		if(flag==1) {
			int[] countSentences = new int[paragraphs.length];  //�������� ���������� �����������
			Pattern SentencesFlag = Pattern.compile("\\.+|!+|\\?+");
			
			for (int i = 0; i<paragraphs.length; i++) {
				int count = 0;
				String paragraph = paragraphs[i];
				Matcher text = SentencesFlag.matcher(paragraph);
				while(text.find()) {
					count++;
				}
				countSentences[i]=count;
			}
			
			for (int l = 1; l<paragraphs.length; l++) {
				if (countSentences[l]<countSentences[l-1]) {
				int prom = countSentences[l];
				countSentences[l]=countSentences[l-1];
				countSentences[l-1] = prom;
				String promS = paragraphs[l];
				paragraphs[l] = paragraphs[l-1];
				paragraphs[l-1] = promS;
				l--;
				}
			}
			for(String K:paragraphs) {
			System.out.println(K);
			}
		}
		
		if(flag ==2) {
		
			for(int i = 0; i<sentences.length; i++) {
				
				int []countLetter = null;
				
				String text = sentences[i];					//����� �����������
				text = text.replaceAll("\\p{Punct}","");    //������ ����� ����������
				
				Pattern WordFlag = Pattern.compile("\\s+");	//����� ����������� �� �����
				String[] words = WordFlag.split(text);
				countLetter = new int[words.length];
	
				for(int p = 0; p<words.length;p++) {		//���������� ����� � �����������
			
				int count = 0;
				String word  = words[p];
				
				Pattern letterFlag = Pattern.compile("(\\d|\\D)");	//������� ����� � �����
				Matcher text1 = letterFlag.matcher(word);
				
				while(text1.find()) {
					count++;
				}
				countLetter[p] = count;
			}
				for (int k = 0; k<words.length-1;) {			//��������� �����
					if (countLetter[k] <= countLetter[k+1]) {
						k++;
					} else {
						int prom = countLetter[k];
						countLetter[k] = countLetter[k+1];
						countLetter[k+1] = prom;
						String promS = words[k];
						words[k] = words[k+1];
						words[k+1] = promS;
						k--;
						if (k < 0) {		
							k = 0;
						}
					} 
				}
			for(String K:words) {
				System.out.println(K);
				}
			}
		}
			
			if (flag == 3) {
			
			String symb;
			int lFlag;
			do {
				System.out.println("������� ������ ��� ����������");
				lFlag = 0;
				symb = S.nextLine();
						
				if (symb.equals(" ")) {
					lFlag=1;
					}
			}while (lFlag == 1);
			
			for(int i = 0; i<sentences.length; i++) {
				
				int []countLetter = null;

				String text = sentences[i];					
				text = text.replaceAll("\\p{Punct}","");    
				text = text.replaceAll("\\d","");    		
				Pattern WordFlag = Pattern.compile("\\s+");	
				String[] words = WordFlag.split(text);
				countLetter = new int[words.length];

				for(int p = 0; p<words.length;p++) {		
				
					int count = 0;
					String word  = words[p];
					
					Pattern letterFlag = Pattern.compile(symb);	//������� ����� � �����
					Matcher text1 = letterFlag.matcher(word);
					
					while(text1.find()) {
						count++;
					}
					countLetter[p] = count;
					}
				
				for (int k = 0; k<words.length-1;) {			//��������� �����
					if (countLetter[k] > countLetter[k+1]) {
						k++;
					} else if (countLetter[k] < countLetter[k+1]){
						int prom = countLetter[k];
						countLetter[k] = countLetter[k+1];
						countLetter[k+1] = prom;
						String promS = words[k];
						words[k] = words[k+1];
						words[k+1] = promS;
						k--;
						if (k < 0) {		
							k = 0;
						}
					} else if(countLetter[k] == countLetter[k+1]) {
						
						String Str1 = words[k];
						String Str2 = words[k+1];
						int p;
						p = Str1.compareToIgnoreCase(Str2);
						if(p<=0) {
							k++;
						}else {
							int prom = countLetter[k];
							countLetter[k] = countLetter[k+1];
							countLetter[k+1] = prom;
							String promS = words[k];
							words[k] = words[k+1];
							words[k+1] = promS;
							k--;
							if (k < 0) {		
								k = 0;
							}
						}
					}
				}
			for(int K:countLetter) {
				System.out.println(K);
			}	
			for(String K:words) {
				System.out.println(K);
				}
			}
		}
	}
}

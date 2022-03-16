
/* Strings_and_basics_of_text_processing. Регулярные выражения 1.
Создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных операции: отсортировать абзацы по количеству предложений;
в каждом предложении отсортировать слова по длине;
отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства - по алфавиту.
 */

package by.epam.java.strings.regular_expression_3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class reg1 {

	public static void main(String[] args) {
		String string = new String();
		string = "По программе Индивидуального плана блама за период обучения необходимо было подготовить поБготовить пояготовить потготовить "
				+ "рукопись диссертации и автореферата, "
				+ "выступить на конференциях с 6 докладами и подготовить 7 научных статей.\r\n"
				+ "По итогам обучения в аспирантуре подготовлены и оформлены в соответствии с требованиями ВАК "
				+ "рукопись диссертации и автореферата."
				+ "В отчетный период проведен анализ лесоустроительных материалов. Выбрано 25 лесохозяйственных учреждений, "
				+ "с учетом геоботаниче-ского районирования, на базе которых осуществляется анализ распро-странения и "
				+ "состояния дубовых и производных от дуба березовых насаж-дений кисличных, снытевых, черничных и орляковых "
				+ "серий типов леса различных возрастов. \r\n"
				+ "Для лесохозяйственных учреждений, на базе которых осуществля-ется анализ распространения и состояния "
				+ "производных от дуба березо-вых насаждений, составлена повыдельная база данных дубовых и произ-водных от "
				+ "дуба мягколиственных насаждений. \r\n"
				+ "Осуществлен подбор и закладка 48 пробных площадей в ГОЛХУ «Буда-Кошелевский опытный лесхоз», "
				+ "ГЛХУ «Василевичский лесхоз», ГЛХУ «Хойникский лесхоз», ГЛХУ «Житковичский лесхоз», ГЛХУ «Петриковский лесхоз», "
				+ "ГОЛХУ «Мозырский опытный лесхоз», ГОЛХУ «Гомельский опытный лесхоз», ГЛХУ «Калинковичский лесхоз». "
				+ "Ряд пробных площадей заложены до обучения в аспирантуреааа.\r\n";

		int flag = 0;
		System.out.println("1 - отсортировать абзацы по количеству предложений \n2 - в каждом предложении отсортировать слова по длине "
				+ "\n3 - отсортировать лексемы по количеству "
				+ "вхождений заданного символа ");
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		do {
			System.out.println("выберите необходимое действие и нажмите соответствующую цифру");
			
		String stringFlag = S.nextLine();
						
			if (stringFlag.equals("1")) {
				flag=1;
			}else if (stringFlag.equals("2")) {
				flag=2;
			}else if(stringFlag.equals("3")) {
					flag=3;
				}
		}while (flag == 0);
		
		Pattern PatternParagraphs = Pattern.compile("\\n*(\\n)\\n*");			//разбили на абзацы
		String[] paragraphs = PatternParagraphs.split(string);
		
		Pattern PatternSentences = Pattern.compile("\\s*(\\.+|!+|\\?+)\\s*");	//разбили на предложения
		String[] sentences = PatternSentences.split(string);
		
		if(flag==1) {
			int[] countSentences = new int[paragraphs.length];  //хранение количества предложений
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
				
				String text = sentences[i];					//взяли предложение
				text = text.replaceAll("\\p{Punct}","");    //убрали знаки препинания
				
				Pattern WordFlag = Pattern.compile("\\s+");	//делим предложение на слова
				String[] words = WordFlag.split(text);
				countLetter = new int[words.length];
	
				for(int p = 0; p<words.length;p++) {		//перебираем слова в предложении
			
				int count = 0;
				String word  = words[p];
				
				Pattern letterFlag = Pattern.compile("(\\d|\\D)");	//считаем знаки в слове
				Matcher text1 = letterFlag.matcher(word);
				
				while(text1.find()) {
					count++;
				}
				countLetter[p] = count;
			}
				for (int k = 0; k<words.length-1;) {			//сортируем слова
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
				System.out.println("Введите символ для сортировки");
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
					
					Pattern letterFlag = Pattern.compile(symb);	//считаем знаки в слове
					Matcher text1 = letterFlag.matcher(word);
					
					while(text1.find()) {
						count++;
					}
					countLetter[p] = count;
					}
				
				for (int k = 0; k<words.length-1;) {			//сортируем слова
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

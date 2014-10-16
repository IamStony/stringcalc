package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.contains("\n")) {
			text = replaceNewline(text);
		}
		if(text.contains("//")) {
			text = text.replace(text.substring(2, 3),",");
			text = text.substring(3);
		}
		if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split(",");
	}
      
	private static int sum(String[] numbers){
 		int total = 0;
        	for(String number : numbers){
			total += toInt(number);
		}
		return total;
	}
	
	private static String replaceNewline(String text){
		return text.replace("\n",",");
	}

}

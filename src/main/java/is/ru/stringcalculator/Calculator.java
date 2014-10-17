package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.contains("//")) {
			text = delimCheck(text);
		}
		if(text.contains("\n")) {
                        text = replaceNewline(text);
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
		boolean containsNegative = false;
        	for(String number : numbers){
			if(toInt(number) < 0) containsNegative = true;
			if(toInt(number) > 1000) continue;
			total += toInt(number);
		}
		if(containsNegative == true) throw new RuntimeException("Negatives not allowed: " + negativeNumbers(numbers));
		else return total;
	}
	
	private static String negativeNumbers(String[] numbers) {
		String neg = "";
		for(String number : numbers){
			if(toInt(number) < 0) {
				if(neg.equals("")) neg += number;
				else neg += "," + number;
			}
		}
		return neg;
	}
	
	private static String replaceNewline(String text){
		return text.replace("\n",",");
	}
	
	public static String delimCheck(String text) {
		if(!(text.contains("[") && text.contains("]"))) return singleDelim(text);
		else {
			int beginIndex = 3; //Beint fyrir aftan '//['
			int endIndex = 4; //Notað með beginIndex í substring til að skoða eitt stak í einu
			while(!text.substring(beginIndex, endIndex).equals("]")) {
				beginIndex++;
				endIndex++;
			}
			String delim = text.substring(3, endIndex-1); //Byrjar beint fyrir aftan '//[' og endar fyrir framan ']'
			text = text.replace(delim, ",");
			text = text.substring(6);
    			return text;
		}
	}
	
	private static String singleDelim(String text) {
    		String delim = text.substring(2, 3);
    		text = text.replace(delim,",");
    		String newLine = text.substring(3, 4);
    		if(newLine.equals("\n")) { //Ef það er newline milli delim og talnanna fjarlægja bara hann
    				text = text.substring(0, 3) + text.substring(4);
    		}
    		return text = text.substring(3); //Eyðir delim úr strengnum
    	}

}

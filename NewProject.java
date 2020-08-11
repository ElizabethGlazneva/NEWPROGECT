import java.util.Scanner;
class Calculate {
	String line;
	String[] massive = {"1","2","3","4","5","6","7","8","9","10"};
	String[] massive3 = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
	int index;
	public void Error(int index) {
		try {
			if (index == -1) {
				throw new Exception("Ошибка! Некорректно введенные данные");
			}
		}
		catch (Exception e){
			System.err.println(e.getMessage());
			System.exit(0);
		}
	}
	public int GetNumber1() {
		String num1="0";
		Error(index);
		for(int i=0; i<massive.length; i++) {
			if (line.substring(0, index).trim().equals(massive[i])) {
				num1=massive[i]; break;
			}
		}
		Integer number_1 = Integer.valueOf(num1);
		int num_1 = number_1;
		return num_1;
	}
	public int GetNumber1_r() {
		Error(index);
		int num11 =0;
			for(int i=0; i<massive3.length; i++) {
				if (line.substring(0, index).trim().equals(massive3[i])) {
					num11=i+1; break;
				}
			}
		return num11;
	}
	public char GetOperate() {
		Error(index);
		char operate = line.charAt(index);
		return operate;
	
}
	public int GetNumber2() {
		String num2="0";
		Error(index);
		for(int i=0; i<massive.length; i++) {
			if (line.substring(index+1, line.length()).trim().equals(massive[i])) {
				num2=massive[i]; break;
			}
		}
		Integer number_2 = Integer.valueOf(num2);
		int num_2 = number_2;
		int num22 =0;
			for(int i=0; i<massive3.length; i++) {
				if (line.substring(index+1, line.length()).trim().equals(massive3[i])) {
					num22=i+1; break;
				}
			}
		int number2 = 0;
		if (GetNumber1() > GetNumber1_r()) {
			number2 = num_2;
		}
		else if (GetNumber1_r() > GetNumber1()){
			number2 = num22;
		}
		try {
			if (number2 == 0) {
				throw new Exception("Ошибка! Некорректно введенные данные");
			}
		}
		catch (Exception e){
			System.err.println(e.getMessage());
			System.exit(0);
		}
		return number2;
	}
}
class ResultofCalculate {
	char oper;
	int number_1;
	int number_1_r;
	int number_2;
	String[] massive = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100",};
	String[] massive2 = {"I","II","III","IV","V","VI","VII","VIII","IX","X", "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XL!","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIX","LV","LVI","LVII","LVIII","LIX","LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXI","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C",};
     public String Result() {
		String result="0";
		switch(oper) {
		case '+': 
			result = Integer.toString(Math.max(number_1,number_1_r) + number_2); break;
		case '-':
			result = Integer.toString(Math.max(number_1,number_1_r) - number_2); break;
		case '/': 
			result = String.format("%.1f",(((double)(Math.max(number_1,number_1_r)) / (double)(number_2)))); break;
		case '*':
			result = Integer.toString(Math.max(number_1,number_1_r) * number_2); break;
		default:
			System.out.print("Операция не распознана");
		}
		if (result.equals(String.format("%.1f",(((double)(Math.max(number_1,number_1_r)) / (double)(number_2)))))) {
			if((double)(Math.max(number_1,number_1_r)) % (double)(number_2) == 0) {
				result = String.format("%.0f",(((double)(Math.max(number_1,number_1_r)) / (double)(number_2))));
			}
		}

		if (number_1_r > number_1) {
			for(int i =0; i<massive.length; i++) {
				if(result.equals(massive[i])) {
					result = massive2[i];
				}
			}
		}
		return result;
}
}

public class name {
	
	public static void main(String[] args) {
	System.out.println("Введите операцию. Для записи римских цифр используйте английский алфавит");
	Scanner sc = new Scanner(System.in);
	Calculate calc = new Calculate();
	calc.line = sc.nextLine();
	calc.index = Math.max(Math.max(calc.line.indexOf("+"),calc.line.indexOf("-")),Math.max(calc.line.indexOf("*"),calc.line.indexOf("/")) );
	ResultofCalculate res = new ResultofCalculate();
	res.oper = calc.GetOperate();
	res.number_1 = calc.GetNumber1();
	res.number_1_r = calc.GetNumber1_r();
	res.number_2 = calc.GetNumber2();
	System.out.println("Результат: " + res.Result());
	}
}


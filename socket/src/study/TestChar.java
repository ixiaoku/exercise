package study;

public class TestChar {

	public static void main(String[] args) {
		
		String a = "a";
		String d = "D";
		String g = "g";
		
		testChar(a);
		testChar(d);
		testChar(g);
		
	}
	
	public static String testChar(String s){
		
		int at =Integer.valueOf(s.charAt(0));
		System.out.println(s+"的ASSIC值："+at);
		
		switch (at) {
		case 97:
			at = 122;
			break;
		case 65:
			at = 90;
			break;
		default:
			at--;
			break;
		}
		
		String as = String.valueOf((char)at);
		System.out.println("经过转换算法ACCIC："+as);
		return as;
	}
}

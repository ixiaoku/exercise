package study;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("animal1", "qe");
		int hashCode = map.hashCode();
		System.out.println(hashCode);
		
		int a = 17,b = 2;
		System.out.println("a:"+Integer.toBinaryString(a));
		System.out.println("b:"+Integer.toBinaryString(b));

		
		System.out.println("������"+Integer.toBinaryString(a&b));

		System.out.println("������"+Integer.toBinaryString(a|b));

		System.out.println("������"+Integer.toBinaryString(~a));

		System.out.println("�������"+Integer.toBinaryString(a^b));


	}
	
}
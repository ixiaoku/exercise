package classLoader;

public class Line {
    static {
        System.out.println("��̬�����ִ�У�loading line");
    }
 
    public static String s = getString();
 
    private static String getString() {
        System.out.println("����̬������ֵ�ľ�̬����ִ�У�loading line");
        return "ss";
    }
 
    public static void test() {
        System.out.println("��ͨ��̬����ִ�У�loading line");
    }
 
    {
        System.out.println("Ҫ����ͨ�Ĵ�����أ�");
    }
 
    public Line() {
        System.out.println("���췽��ִ��");
    }
}

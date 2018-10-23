package sql;

/**
 * 1ͨ��System.getProperty("sun.boot.class.path")�õ����ַ���bootClassPath,
 * ���Ӧ�þ���BootstrapClassLoader���ص�jar��·��
 * 
 *
 * 2
 * 
 * 
 * 3AppClassLoader���صľ���java.class.path�µ�·��
 * ���·����ʵ���ǵ�ǰjava����Ŀ¼bin�������ŵ��Ǳ������ɵ�class�ļ�
 * 
 * AppClassLoader��parent��ExtClassLoader��ExtClassLoader��parent��null��
 * 
 * @author dcr
 *
 */

public class TestClassLoader {

	public static void main(String[] args) {

		System.out.println("BootstrapClassLoader:"+System.getProperty("sun.boot.class.path"));
		
		System.out.println("ExtClassLoader:"+System.getProperty("java.ext.dirs"));
		
		System.out.println("AppClassLoader:"+System.getProperty("java.class.path"));
		
		
		ClassLoader cl = TestClassLoader.class.getClassLoader();

        System.out.println("ClassLoader is:"+cl.toString());
        
        System.out.println("ClassLoader\'s parent is:"+cl.getParent().toString());
        
        System.out.println("ClassLoader\'s grand father is:"+cl.getParent().getParent().toString());
	}
}

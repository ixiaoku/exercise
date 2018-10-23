package sql;

/**
 * 1通过System.getProperty("sun.boot.class.path")得到了字符串bootClassPath,
 * 这个应该就是BootstrapClassLoader加载的jar包路径
 * 
 *
 * 2
 * 
 * 
 * 3AppClassLoader加载的就是java.class.path下的路径
 * 这个路径其实就是当前java工程目录bin，里面存放的是编译生成的class文件
 * 
 * AppClassLoader的parent是ExtClassLoader，ExtClassLoader的parent是null。
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

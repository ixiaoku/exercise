package classLoader;

public class TestClassLoader {
    public static void main(String[] args) throws Exception {
        String wholeNameLine = "classLoader.Line";
        String wholeNamePoint = "classLoader.Point";
        System.out.println("下面是测试Classloader的效果");
        testClassloader(wholeNameLine, wholeNamePoint);
        System.out.println("----------------------------------");
        System.out.println("下面是测试Class.forName的效果");
        testForName(wholeNameLine, wholeNamePoint);
 
    }
 
    /**
     * classloader
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    private static void testClassloader(String wholeNameLine, String wholeNamePoint) throws Exception {
        Class<?> line;
        Class<?> point;
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            line = loader.loadClass(wholeNameLine);
            point = loader.loadClass(wholeNamePoint);
            //line.newInstance();
            System.out.println("1line   " + line.getName());
            System.out.println("2point   " + point.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Class.forName
     */
    @SuppressWarnings("rawtypes")
	private static void testForName(String wholeNameLine, String wholeNamePoint) {
 
        try {
            Class line = Class.forName(wholeNameLine);
            Class point = Class.forName(wholeNamePoint);
            System.out.println("3line   " + line.getName());
            System.out.println("4point   " + point.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
 
}


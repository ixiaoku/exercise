package movingProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * InvocationHandler ��һ���ӿڣ��ٷ��ĵ�����˵��
 * ÿ�������ʵ������һ����֮������ InvocationHandler ʵ���࣬�������ķ��������ã�
 * ��ô������֪ͨ��ת�����ڲ��� InvocationHandler ʵ���࣬������������
 * @author dcr
 *
 */
public class GuiTai implements InvocationHandler{

	private Object pingpai;

    public GuiTai(Object pingpai) {
        this.pingpai = pingpai;
    }

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("���ۿ�ʼ  ��̨�ǣ� "+this.getClass().getSimpleName());
        method.invoke(pingpai, args);
        System.out.println("���۽���");
        return null;
	}

    
}

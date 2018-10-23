package movingProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * InvocationHandler 是一个接口，官方文档解释说，
 * 每个代理的实例都有一个与之关联的 InvocationHandler 实现类，如果代理的方法被调用，
 * 那么代理便会通知和转发给内部的 InvocationHandler 实现类，由它决定处理
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
		System.out.println("销售开始  柜台是： "+this.getClass().getSimpleName());
        method.invoke(pingpai, args);
        System.out.println("销售结束");
        return null;
	}

    
}

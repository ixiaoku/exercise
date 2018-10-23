package movingProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestWine {

	public static void main(String[] args) {
		MaoTaiJiu maotaijiu = new MaoTaiJiu();
		WuLiangYe w = new WuLiangYe();
		
	    InvocationHandler jingxiao1 = new GuiTai(maotaijiu);
	    SellWine dynamicProxy1 = (SellWine) Proxy.newProxyInstance(MaoTaiJiu.class.getClassLoader(),
	    		MaoTaiJiu.class.getInterfaces(), jingxiao1);

	    dynamicProxy1.mainJiu();
	    
	    InvocationHandler jingxiao2 = new GuiTai(w);
	    SellWine dynamicProxy2 = (SellWine) Proxy.newProxyInstance(MaoTaiJiu.class.getClassLoader(),
	    		MaoTaiJiu.class.getInterfaces(), jingxiao2);

	    dynamicProxy2.mainJiu();
	    
	}
	
}

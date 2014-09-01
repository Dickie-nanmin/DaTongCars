package ldd.mvc.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements Interceptor {

	public void intercept(ActionInvocation ai) {
		Controller ctr = ai.getController();
		boolean rlt = true;
		//这里是个判断是否登录的拦截器功能演示 true
		if (rlt) {
			ai.invoke();
		} else {
			//未登录重定向登录页面
			ctr.redirect("/login");
		}
	}

}

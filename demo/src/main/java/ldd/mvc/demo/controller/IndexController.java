package ldd.mvc.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 控制类 ， 注意要继承 BaseController
 */
public class IndexController extends BaseController {
	private final static Logger log = LoggerFactory.getLogger(IndexController.class);

	/**
	 * 首页
	 */
	public void index() {
		log.info("...这里是首页....");
		
		render("/index.httl");
	}
	
	
	/**
	 * 登录
	 * -----
	 * 注解 ClearInterceptor 表示清空拦截器作用
	 * 注解 Before 表示需要校验表单
	 */
//	@ClearInterceptor(ClearLayer.ALL)
//	@Before(UserValidator.class)
	public void login() {
		//演示判断是否登录，重定向至首页
//		if (true) {
//			redirect("/index");
//			return ;
//		}
		
		render("/login.httl");
	}
}


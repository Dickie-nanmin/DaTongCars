package ldd.mvc.demo;

import httl.web.jfinal.HttlRenderFactory;
import ldd.mvc.demo.controller.ErrorController;
import ldd.mvc.demo.controller.IndexController;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;

/**
 * 启动配置文件
 */
public class AppConfig extends JFinalConfig {
	
	/**
	 * 配置常量
	 */
	@Override
	public void configConstant(Constants me) {
		//加载少量必要配置，随后可用getProperty(...)获取值
		loadPropertyFile("app_config.txt");
		//设定采用httl模板引擎
		me.setMainRenderFactory(new HttlRenderFactory());
		me.setEncoding("UTF-8");
		//设定错误页面
		me.setError404View("/404.html");
		me.setError500View("/500.html");
		//设定为开发者模式
		me.setDevMode(getPropertyToBoolean("devMode", false));
	}
	
	/**
	 * 配置路由
	 */
	@Override
	public void configRoute(Routes me) {
		me.add("/", IndexController.class);
		me.add("/error", ErrorController.class);
	}
	
	/**
	 * 配置插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		//需要用数据库把此处打开
		/*
			//初始化数据库连接池
			DruidPlugin dp = new DruidPlugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"));
			dp.addFilter(new StatFilter());
			WallFilter wall = new WallFilter();
			wall.setDbType("mysql");
			dp.addFilter(wall);
			
			//加载数据库连接池插件
			me.add(dp);
			
			//初始化activerecord
			ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
			//开发阶段，显示sql
	        arp.setShowSql(true);
	        
			//表映射
			//arp.addMapping(Table.TB_USER, User.class);
	        
	        //加载AR插件
			me.add(arp);
		*/
	}
	
	/**
	 * 配置全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		//此处拦截器配置
		//me.add(new LoginInterceptor());
	}
	
	/**
	 * 配置处理器
	 */
	@Override
	public void configHandler(Handlers me) {
		//Druid链接池状态处理器，可以通过访问 http://ip:port/druid 来查看数据库访问情况。
		/*
		DruidStatViewHandler dvh =  new DruidStatViewHandler("/druid");
		me.add(dvh);
		*/
		
		//该处理器将request.getContextPath()存储在BASE_PATH中，可以解决路径问题
		ContextPathHandler path = new ContextPathHandler("BASE_PATH");
		me.add(path);
	}
	
	/**
	 * 建议使用 JFinal 手册推荐的方式启动项目
	 * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
	 */
	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}
}

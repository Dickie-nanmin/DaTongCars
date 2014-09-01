package ldd.mvc.demo.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * 数据持久访问层
 */
public class User extends Model<User> {
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	public static final User dao = new User();
	
	
	/**
	 * 通过用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public static User getByUserName(String userName){
		return dao.findFirst("select * from user where loginname=?", userName);
	}

}


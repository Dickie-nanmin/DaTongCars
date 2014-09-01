package ldd.mvc.demo.controller.validator;

import ldd.mvc.demo.model.User;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * 表单校验
 */
public class UserValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		validateRequiredString("user.name", "nameMsg", "请输入用户名称!");
	}

	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(User.class);
		String actionKey = getActionKey();
		if (actionKey.equals("/project/save")) {
			controller.render("/project/add.httl");
		} else if (actionKey.equals("/project/update")) {
			controller.render("/project/add.httl");
		}
	}

}


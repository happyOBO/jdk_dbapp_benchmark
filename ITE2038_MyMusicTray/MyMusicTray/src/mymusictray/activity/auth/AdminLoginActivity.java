package mymusictray.activity.auth;

import mymusictray.activity.Activity;
import mymusictray.activity.admin.AdminRootActivity;
import mymusictray.exception.NotFoundException;
import mymusictray.model.Admin;
import mymusictray.util.IOUtil;

public class AdminLoginActivity implements Activity {

	@Override
	public void start() {
		IOUtil.printSection("[Admin Login]");
		System.out.println("Input ID and password to login.");

		String id = IOUtil.inputLine("ID");
		String password = IOUtil.inputLine("Password");

		try {
			Admin model = Admin.selectByAccountId(id);

			if (model.password.equals(password)) {
				IOUtil.printPopup("Login Succeed", "Hello " + model.name);

				(new AdminRootActivity(model)).start();

			}else {
				(new LoginFailedActivity("Id and password are not matched", this)).start();
			}

		}catch (NotFoundException e) {
			(new LoginFailedActivity("Account not exists", this)).start();
		}
	}
}
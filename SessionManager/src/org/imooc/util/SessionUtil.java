package org.imooc.util;

import java.util.ArrayList;

import org.imooc.entliy.User;

public class SessionUtil {

	public static Object getUserBySessionId(ArrayList<User> userList, String sessionIdString) {
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			if (user.getSessionIdString().equals(sessionIdString)) {
				return user;
			}
		}
		return null;
	}
}

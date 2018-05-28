package org.lanqiao.test;

import org.lanqiao.service.IAccountService;
import org.lanqiao.service.IAccountServiceImp;

public class Test {
	public static void main(String[] args) {
		IAccountService accountService = new IAccountServiceImp();
		accountService.transfer("zhangsan", "lisi", 1000);
	}
}

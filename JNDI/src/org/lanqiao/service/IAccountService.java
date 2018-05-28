package org.lanqiao.service;

public interface IAccountService {
	public abstract void transfer(String fromAccountName,
			String toAccountName,double transferMoney);
}

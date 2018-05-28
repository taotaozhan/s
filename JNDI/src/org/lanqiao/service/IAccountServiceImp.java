package org.lanqiao.service;

import java.sql.SQLException;

import org.lanqiao.dao.AccountDao;
import org.lanqiao.dao.AccountImp;
import org.lanqiao.eneity.Account;
import org.lanqiao.util.DBUtil;

public class IAccountServiceImp implements IAccountService{
	public void transfer(String fromAccountName, String toAccountName,
			 double transferMoney) {
			  try {
			   // 开启事务
			   DBUtil.beginTransaction();
			   AccountDao accountDao = new AccountImp();
			   // 付款方
			   Account fromAccount = accountDao.queryAccountByName(fromAccountName);
			   // 收款方
			   Account toAccount = accountDao.queryAccountByName(toAccountName);
			   // 转账
			   if (transferMoney < fromAccount.getBancle()) {
			    // 付款方的余额减少
			    double fromBalance = fromAccount.getBancle() - transferMoney;
			    fromAccount.setBancle(fromBalance);
			    // 收款方的余额增加
			    double toBalance = toAccount.getBancle() + transferMoney;
			    toAccount.setBancle(toBalance);
			    // 更新账户
			    accountDao.updateAccount(fromAccount);
			    accountDao.updateAccount(toAccount);
			    System.out.println("转账成功");
			    // 提交事务
			    DBUtil.commitTranscation();
			    System.out.println("提交成功");
			   } else {
			    System.out.println("余额不足，转账失败！");
			   }
			  } catch (SQLException e) {
			   System.out.println("提交失败！回滚...");
			   // 回滚事务
			   DBUtil.rollBackTranscation();
			   e.printStackTrace();
			  } catch (Exception e) {
			   e.printStackTrace();
			  } finally {
			   // 关闭事务
			   DBUtil.close();
			  }
			 }

}

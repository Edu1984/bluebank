package br.com.ibm.bluebank.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.ibm.bluebank.config.BlueBankConfig;
import br.com.ibm.bluebank.entity.Accountant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BlueBankConfig.class})
@Transactional  
public class AccountantHibernateDAOTest {

	@Autowired
	private AccountantDAO accountantDAO;

	@Test 
	public void findAccountantTest(){
		Accountant accountant = accountantDAO.findAccountant("34545666302", "9512", "60589");
		System.out.println("teste conta");
		Assert.assertNotNull(accountant);	
	}
	
	public void setAccountantDAO(AccountantDAO accountantDAO) {
		this.accountantDAO = accountantDAO;
	}
	
}

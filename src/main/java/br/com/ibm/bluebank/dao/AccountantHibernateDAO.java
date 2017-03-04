package br.com.ibm.bluebank.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.ibm.bluebank.entity.Accountant;
import br.com.ibm.bluebank.entity.ElectronicTransfer;

@Repository
public class AccountantHibernateDAO implements AccountantDAO {

	private SessionFactory sessionFactory;
	
	public AccountantHibernateDAO(){
	}
	
	public AccountantHibernateDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Accountant findAccountant(String document, String agencyCode, String accountNumber){
		Query query = getSession().createQuery("from Accountant where document = :document and agencyCode = :agencyCode and accountNumber = :accountNumber ");
		query.setParameter("document", document);
		query.setParameter("agencyCode", agencyCode);
		query.setParameter("accountNumber", accountNumber);
		
		Accountant accountant = (Accountant)query.uniqueResult();
		
		return accountant;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public Accountant findAccountantById(Integer id) {
		Accountant accountant = (Accountant)getSession().get(Accountant.class, id);
		return accountant;
	}

	public Accountant mergeAccountant(Accountant accountant) {
		accountant = (Accountant)getSession().merge(accountant);
		return accountant;
	}

	public ElectronicTransfer saveElectronicTransfer(ElectronicTransfer electronicTransfer) {
		Integer id = (Integer)getSession().save(electronicTransfer);
		System.out.println(id);
		return electronicTransfer;
	}
	
}

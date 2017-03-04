package br.com.ibm.bluebank.dao;

import org.hibernate.Session;

import br.com.ibm.bluebank.entity.Accountant;
import br.com.ibm.bluebank.entity.ElectronicTransfer;

public interface AccountantDAO {
	Accountant findAccountant(String document, String agencyCode, String accountNumber);
	Accountant findAccountantById(Integer id);
	Accountant mergeAccountant(Accountant accountant);
	Session getSession();	
	ElectronicTransfer saveElectronicTransfer(ElectronicTransfer electronicTransfer);
}

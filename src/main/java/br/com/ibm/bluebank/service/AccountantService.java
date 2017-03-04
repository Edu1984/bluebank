package br.com.ibm.bluebank.service;

import br.com.ibm.bluebank.jersey.type.AccountantSimple;
import br.com.ibm.bluebank.jersey.type.TranferRequest;
import br.com.ibm.bluebank.jersey.type.TranferResponse;

public interface AccountantService {
	AccountantSimple findAccountant(String document, String agencyCode, String accountNumber);
	
	TranferResponse doTransfer(TranferRequest tranferRequest);
	
	boolean transferValidate(TranferRequest tranferRequest, TranferResponse tranferResponse);	
}

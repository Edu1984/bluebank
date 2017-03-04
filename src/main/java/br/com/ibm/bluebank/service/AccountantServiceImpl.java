package br.com.ibm.bluebank.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import br.com.ibm.bluebank.dao.AccountantDAO;
import br.com.ibm.bluebank.entity.Accountant;
import br.com.ibm.bluebank.entity.ElectronicTransfer;
import br.com.ibm.bluebank.jersey.type.AccountantSimple;
import br.com.ibm.bluebank.jersey.type.ElectronicTransferSimple;
import br.com.ibm.bluebank.jersey.type.TranferRequest;
import br.com.ibm.bluebank.jersey.type.TranferResponse;

public class AccountantServiceImpl implements AccountantService {

	private AccountantDAO accountantDAO;
	
	public AccountantServiceImpl(AccountantDAO accountantDAO) {
		this.accountantDAO = accountantDAO;
	}

	public AccountantSimple findAccountant(String document, String agencyCode, String accountNumber) {
		this.accountantDAO.getSession().beginTransaction();
		Accountant accountant = this.accountantDAO.findAccountant(document, agencyCode, accountNumber);
		this.accountantDAO.getSession().getTransaction().commit();
		return toXsd(accountant);
	}

	private AccountantSimple toXsd(Accountant accountant) {
		AccountantSimple accountantSimple = new AccountantSimple();
		accountantSimple.setId(accountant.getId());
		accountantSimple.setName(accountant.getName());
		accountantSimple.setDocument(accountant.getDocument());
		accountantSimple.setAgencyCode(accountant.getAgencyCode());
		accountantSimple.setAccountNumber(accountant.getAccountNumber());
		accountantSimple.setBalanceAvailable(accountant.getBalanceAvailable());
		
		if(accountant.getCreditorEletronicTransfers() != null
				&& accountant.getCreditorEletronicTransfers().size() >0){
			Set<ElectronicTransferSimple> electronicTransferSimples = new HashSet<ElectronicTransferSimple>();
			for(ElectronicTransfer electronicTransfer : accountant.getCreditorEletronicTransfers()){
				ElectronicTransferSimple electronicTransferSimple = new ElectronicTransferSimple();
				electronicTransferSimple.setId(electronicTransfer.getId());
				electronicTransferSimple.setAccountantFromId(electronicTransfer.getAccountantFrom().getId());
				electronicTransferSimple.setAccountantFromName(electronicTransfer.getAccountantFrom().getName());
				electronicTransferSimple.setAccountantFromDocument(electronicTransfer.getAccountantFrom().getDocument());
				electronicTransferSimple.setAccountantFromAgencyCode(electronicTransfer.getAccountantFrom().getAgencyCode());
				electronicTransferSimple.setAccountantFromAccountNumber(electronicTransfer.getAccountantFrom().getAccountNumber());
				
				electronicTransferSimple.setAccountantToId(electronicTransfer.getAccountantTo().getId());
				electronicTransferSimple.setAccountantToName(electronicTransfer.getAccountantTo().getName());
				electronicTransferSimple.setAccountantToDocument(electronicTransfer.getAccountantTo().getDocument());
				electronicTransferSimple.setAccountantToAgencyCode(electronicTransfer.getAccountantTo().getAgencyCode());
				electronicTransferSimple.setAccountantToAccountNumber(electronicTransfer.getAccountantTo().getAccountNumber());
				
				electronicTransferSimple.setTransferValue(electronicTransfer.getTransferValue());
				electronicTransferSimple.setTransferDate(electronicTransfer.getTransferDate());
				
				electronicTransferSimples.add(electronicTransferSimple);
			}
			accountantSimple.getCreditorEletronicTransfers().addAll(electronicTransferSimples);
		}
		return accountantSimple;
	}
	
	public boolean transferValidate(TranferRequest tranferRequest, TranferResponse tranferResponse) {
		tranferResponse.setSuccess(Boolean.TRUE);
		this.accountantDAO.getSession().beginTransaction();
		
		Accountant accountantFrom = accountantDAO.findAccountantById(tranferRequest.getAccountantFromId());
		if(accountantFrom == null){
			tranferResponse.setMessage("A conta origem é inválida. Verifique!");
			tranferResponse.setSuccess(Boolean.FALSE);
		}
		else if(accountantFrom.getBalanceAvailable().floatValue() < tranferRequest.getTransferValue().floatValue()){
			tranferResponse.setMessage("A conta origem não tem saldo para a tranferência. Verifique!");
			tranferResponse.setSuccess(Boolean.FALSE);
		}
		else {
			Accountant accountantTo = accountantDAO.findAccountantById(tranferRequest.getAccountantToId());
			if(accountantTo == null){
				tranferResponse.setMessage("A conta destino é inválida. Verifique!");
				tranferResponse.setSuccess(Boolean.FALSE);
			}
		}
		this.accountantDAO.getSession().getTransaction().commit();
		
		return tranferResponse.getSuccess();
	}

	public TranferResponse doTransfer(TranferRequest tranferRequest) {
		TranferResponse tranferResponse= new TranferResponse();
		
		this.accountantDAO.getSession().beginTransaction();
		
		Accountant accountantFrom = accountantDAO.findAccountantById(tranferRequest.getAccountantFromId());
		BigDecimal balanceAccountantFrom = accountantFrom.getBalanceAvailable().subtract(tranferRequest.getTransferValue());
		accountantFrom.setBalanceAvailable(balanceAccountantFrom);
		accountantDAO.mergeAccountant(accountantFrom);
		
		Accountant accountantTo = accountantDAO.findAccountantById(tranferRequest.getAccountantToId());
		balanceAccountantFrom = accountantTo.getBalanceAvailable().add(tranferRequest.getTransferValue());
		accountantTo.setBalanceAvailable(balanceAccountantFrom);
		accountantDAO.mergeAccountant(accountantTo);
		
		ElectronicTransfer electronicTransfer = new ElectronicTransfer();
		electronicTransfer.setAccountantFrom(accountantFrom);
		electronicTransfer.setAccountantTo(accountantTo);
		electronicTransfer.setTransferValue(tranferRequest.getTransferValue());
		electronicTransfer.setTransferDate(new Date());
		accountantDAO.saveElectronicTransfer(electronicTransfer);
		
		this.accountantDAO.getSession().getTransaction().commit();
		
		tranferResponse.setSuccess(Boolean.TRUE);
		tranferResponse.setMessage("Transferência realizada com sucesso.");
		tranferResponse.setTranferRequest(tranferRequest);
		return tranferResponse;
	}
	
}

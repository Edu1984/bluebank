package br.com.ibm.bluebank.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibm.bluebank.jersey.type.AccountantSimple;
import br.com.ibm.bluebank.jersey.type.TranferRequest;
import br.com.ibm.bluebank.jersey.type.TranferResponse;
import br.com.ibm.bluebank.service.AccountantService;

@Service("services")
@Path("/services")
public class InterfaceRest {

	@Autowired
	private AccountantService accountantService;
	
	@GET
	@Path("findAccountant")
	@Produces(MediaType.APPLICATION_JSON)
	public AccountantSimple findAccountant(
			@QueryParam("document") String document, 
			@QueryParam("agencyCode") String agencyCode, 
			@QueryParam("accountNumber") String accountNumber){
		
		return accountantService.findAccountant(document, agencyCode, accountNumber);
	}
	
	@POST
	@Path("doTransfer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TranferResponse doTransfer(TranferRequest tranferRequest){
		TranferResponse tranferResponse = new TranferResponse();
		if(accountantService.transferValidate(tranferRequest, tranferResponse)){
			tranferResponse = accountantService.doTransfer(tranferRequest);
		}
		return tranferResponse;
		
	}

	public void setAccountantService(AccountantService accountantService) {
		this.accountantService = accountantService;
	}

}

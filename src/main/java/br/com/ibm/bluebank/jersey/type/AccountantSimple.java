package br.com.ibm.bluebank.jersey.type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Accountant", propOrder = {
    "id",
    "name",
    "document",
    "agencyCode",
    "accountNumber",
    "balanceAvailable",
    "creditorEletronicTransfers"
})
public class AccountantSimple implements Serializable {

	private static final long serialVersionUID = 4726343532690809072L;

	@XmlElement(name = "Id")
	private Integer id;
	
	@XmlElement(name = "Name")
	private String name;
	
	@XmlElement(name = "Document")
	private String document;
	
	@XmlElement(name = "AgencyCode")
	private String agencyCode;
	
	@XmlElement(name = "AccountNumber")
	private String accountNumber;
	
	@XmlElement(name = "BalanceAvailable")
	private BigDecimal balanceAvailable;
	
	@XmlElement(name = "CreditorEletronicTransfers")
 	private Set<ElectronicTransferSimple> creditorEletronicTransfers;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	
	public String getAgencyCode() {
		return agencyCode;
	}
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public BigDecimal getBalanceAvailable() {
		return balanceAvailable;
	}
	public void setBalanceAvailable(BigDecimal balanceAvailable) {
		this.balanceAvailable = balanceAvailable;
	}
	
	public Set<ElectronicTransferSimple> getCreditorEletronicTransfers() {
		if(creditorEletronicTransfers == null){
			creditorEletronicTransfers = new HashSet<ElectronicTransferSimple>();
		}
		return creditorEletronicTransfers;
	}
	public void setCreditorEletronicTransfers(Set<ElectronicTransferSimple> creditorEletronicTransfers) {
		this.creditorEletronicTransfers = creditorEletronicTransfers;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountantSimple other = (AccountantSimple) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Accountant [id=" + id + ", name=" + name + ", document=" + document + ", agencyCode=" + agencyCode
				+ ", accountNumber=" + accountNumber + ", balanceAvailable=" + balanceAvailable + "]";
	}

}

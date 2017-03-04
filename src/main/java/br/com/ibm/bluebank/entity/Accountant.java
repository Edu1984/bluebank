package br.com.ibm.bluebank.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Accountant implements Serializable {

	private static final long serialVersionUID = 4726343532690809072L;

	@Id
	@Column(name="Id")
	private Integer id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Document")
	private String document;
	
	@Column(name="AgencyCode")
	private String agencyCode;
	
	@Column(name="AccountNumber")
	private String accountNumber;
	
	@Column(name="BalanceAvailable")
	private BigDecimal balanceAvailable;
	
	@OneToMany(mappedBy = "accountantFrom",fetch = FetchType.EAGER)
 	private Set<ElectronicTransfer> creditorEletronicTransfers;
	
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
	
	public Set<ElectronicTransfer> getCreditorEletronicTransfers() {
		return creditorEletronicTransfers;
	}
	public void setCreditorEletronicTransfers(Set<ElectronicTransfer> creditorEletronicTransfers) {
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
		Accountant other = (Accountant) obj;
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

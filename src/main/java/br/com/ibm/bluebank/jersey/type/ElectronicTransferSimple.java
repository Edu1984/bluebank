package br.com.ibm.bluebank.jersey.type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElectronicTransfer", propOrder = {
    "id",
    "accountantFromId",
    "accountantFromName",
    "accountantFromDocument",
    "accountantFromAgencyCode",
    "accountantFromAccountNumber",
    "accountantToId",
    "accountantToName",
    "accountantToDocument",
    "accountantToAgencyCode",
    "accountantToAccountNumber",
    "transferValue",
    "transferDate"
})
public class ElectronicTransferSimple implements Serializable {

	private static final long serialVersionUID = 4726343532690809072L;

	@XmlElement(name = "Id")
	private Integer id;
	
	@XmlElement(name = "AccountantFromId")
	private Integer accountantFromId;
	
	@XmlElement(name = "AccountantFromName")
	private String accountantFromName;
	
	@XmlElement(name = "AccountantFromDocument")
	private String accountantFromDocument;
	
	@XmlElement(name = "AccountantFromAgencyCode")
	private String accountantFromAgencyCode;
	
	@XmlElement(name = "AccountantFromAccountNumber")
	private String accountantFromAccountNumber;
	
	@XmlElement(name = "AccountantToId")
	private Integer accountantToId;
	
	@XmlElement(name = "AccountantToName")
	private String accountantToName;
	
	@XmlElement(name = "AccountantToDocument")
	private String accountantToDocument;
	
	@XmlElement(name = "AccountantToAgencyCode")
	private String accountantToAgencyCode;
	
	@XmlElement(name = "AccountantToAccountNumber")
	private String accountantToAccountNumber;

	@XmlElement(name = "TransferValue")
	private BigDecimal transferValue;
	
	@XmlElement(name = "TransferDate")
	private Date transferDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getAccountantFromId() {
		return accountantFromId;
	}
	public void setAccountantFromId(Integer accountantFromId) {
		this.accountantFromId = accountantFromId;
	}
	public String getAccountantFromName() {
		return accountantFromName;
	}
	public void setAccountantFromName(String accountantFromName) {
		this.accountantFromName = accountantFromName;
	}
	public String getAccountantFromDocument() {
		return accountantFromDocument;
	}
	public void setAccountantFromDocument(String accountantFromDocument) {
		this.accountantFromDocument = accountantFromDocument;
	}
	public String getAccountantFromAgencyCode() {
		return accountantFromAgencyCode;
	}
	public void setAccountantFromAgencyCode(String accountantFromAgencyCode) {
		this.accountantFromAgencyCode = accountantFromAgencyCode;
	}
	public String getAccountantFromAccountNumber() {
		return accountantFromAccountNumber;
	}
	public void setAccountantFromAccountNumber(String accountantFromAccountNumber) {
		this.accountantFromAccountNumber = accountantFromAccountNumber;
	}
	public Integer getAccountantToId() {
		return accountantToId;
	}
	public void setAccountantToId(Integer accountantToId) {
		this.accountantToId = accountantToId;
	}
	public String getAccountantToName() {
		return accountantToName;
	}
	public void setAccountantToName(String accountantToName) {
		this.accountantToName = accountantToName;
	}
	public String getAccountantToDocument() {
		return accountantToDocument;
	}
	public void setAccountantToDocument(String accountantToDocument) {
		this.accountantToDocument = accountantToDocument;
	}
	public String getAccountantToAgencyCode() {
		return accountantToAgencyCode;
	}
	public void setAccountantToAgencyCode(String accountantToAgencyCode) {
		this.accountantToAgencyCode = accountantToAgencyCode;
	}
	public String getAccountantToAccountNumber() {
		return accountantToAccountNumber;
	}
	public void setAccountantToAccountNumber(String accountantToAccountNumber) {
		this.accountantToAccountNumber = accountantToAccountNumber;
	}
	public BigDecimal getTransferValue() {
		return transferValue;
	}
	public void setTransferValue(BigDecimal transferValue) {
		this.transferValue = transferValue;
	}
	
	public Date getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
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
		ElectronicTransferSimple other = (ElectronicTransferSimple) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ElectronicTransferSimple [id=" + id + ", accountantFromId=" + accountantFromId + ", accountantFromName="
				+ accountantFromName + ", accountantFromDocument=" + accountantFromDocument
				+ ", accountantFromAgencyCode=" + accountantFromAgencyCode + ", accountantFromAccountNumber="
				+ accountantFromAccountNumber + ", accountantToId=" + accountantToId + ", accountantToName="
				+ accountantToName + ", accountantToDocument=" + accountantToDocument + ", accountantToAgencyCode="
				+ accountantToAgencyCode + ", accountantToAccountNumber=" + accountantToAccountNumber
				+ ", transferValue=" + transferValue + ", transferDate=" + transferDate + "]";
	}
	
}

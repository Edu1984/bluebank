package br.com.ibm.bluebank.jersey.type;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElectronicTransfer", propOrder = {
    "accountantFromId",
    "accountantToId",
    "transferValue"
})
public class TranferRequest implements Serializable {

	private static final long serialVersionUID = 4726343532690809072L;
	
	@XmlElement(name = "AccountantFromId")
	private Integer accountantFromId;
	
	@XmlElement(name = "AccountantToId")
	private Integer accountantToId;

	@XmlElement(name = "TransferValue")
	private BigDecimal transferValue;

	public Integer getAccountantFromId() {
		return accountantFromId;
	}
	public void setAccountantFromId(Integer accountantFromId) {
		this.accountantFromId = accountantFromId;
	}

	public Integer getAccountantToId() {
		return accountantToId;
	}
	public void setAccountantToId(Integer accountantToId) {
		this.accountantToId = accountantToId;
	}

	public BigDecimal getTransferValue() {
		return transferValue;
	}
	public void setTransferValue(BigDecimal transferValue) {
		this.transferValue = transferValue;
	}
	
	@Override
	public String toString() {
		return "TranferInput [accountantFromId=" + accountantFromId + ", accountantToId=" + accountantToId
				+ ", transferValue=" + transferValue + "]";
	}
	
}

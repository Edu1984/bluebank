package br.com.ibm.bluebank.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ElectronicTransfer implements Serializable {

	private static final long serialVersionUID = 4726343532690809072L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "AccountantFrom")
	private Accountant accountantFrom;
	
	@ManyToOne
	@JoinColumn(name = "AccountantTo")
	private Accountant accountantTo;
	
	@Column(name="TransferValue")
	private BigDecimal transferValue;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TransferDate")
	private Date transferDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Accountant getAccountantFrom() {
		return accountantFrom;
	}
	public void setAccountantFrom(Accountant accountantFrom) {
		this.accountantFrom = accountantFrom;
	}
	
	public Accountant getAccountantTo() {
		return accountantTo;
	}
	public void setAccountantTo(Accountant accountantTo) {
		this.accountantTo = accountantTo;
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
		ElectronicTransfer other = (ElectronicTransfer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "EletronicTransfer [id=" + id + ", accountantFrom=" + accountantFrom + ", accountantTo=" + accountantTo
				+ ", transferValue=" + transferValue + ", transferDate=" + transferDate + "]";
	}
	
}

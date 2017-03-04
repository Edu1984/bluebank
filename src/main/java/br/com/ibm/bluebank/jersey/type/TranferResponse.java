package br.com.ibm.bluebank.jersey.type;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TranferResponse", propOrder = {
    "success",
    "message",
    "tranferRequest"
})
public class TranferResponse implements Serializable {

	private static final long serialVersionUID = 4726343532690809072L;

	@XmlElement(name = "Success")
	private Boolean success;
	
	@XmlElement(name = "Message")
	private String message;

	@XmlElement(name = "TranferRequest")
	private TranferRequest tranferRequest;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TranferRequest getTranferRequest() {
		return tranferRequest;
	}

	public void setTranferRequest(TranferRequest tranferRequest) {
		this.tranferRequest = tranferRequest;
	}

	@Override
	public String toString() {
		return "TranferResponse [success=" + success + ", message=" + message + ", tranferRequest=" + tranferRequest
				+ "]";
	}
	
}

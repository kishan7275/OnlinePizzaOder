package com.opoa.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	@NotNull(message = "Name cannot be null.")
	@Size(min = 3, message = "cardName should be of min 3 chars.")
	private String cardName;
	@Size(min = 10, message = "cardNumber should be of min 10 digit.")
	private String cardNumber;
	@Size(min = 3, message = "BankName should be of min 3 chars.")
	private String bankName;
	private String cardExpiry;
	private double amount;
	

	
	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", cardName=" + cardName + ", cardNumber=" + cardNumber
				+ ", bankName=" + bankName + ", cardExpiry=" + cardExpiry + ", amount=" + amount + "]";
	}

	public Payment(Integer paymentId, String cardName, String cardNumber, String bankName, String cardExpiry,
			Double amount) {
		super();
		this.paymentId = paymentId;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.bankName = bankName;
		this.cardExpiry = cardExpiry;
		this.amount = amount;
	}

	public Payment() {
		super();
	}

}
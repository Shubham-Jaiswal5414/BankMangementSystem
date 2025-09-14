package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_record")
public class customer 
{
	@Id
	int Bank_ID;
	String Name;
	String Address;
	String Phone_No;
	int Balance;
	int Loan_Amt;
	public customer()
	{
	}
	public customer(int bank_ID, String name, String address, String phone_No, int balance, int loan_Amt) {
		super();
		Bank_ID = bank_ID;
		Name = name;
		Address = address;
		Phone_No = phone_No;
		Balance = balance;
		Loan_Amt = loan_Amt;
	}
	public int getBank_ID() {
		return Bank_ID;
	}
	public void setBank_ID(int bank_ID) {
		Bank_ID = bank_ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone_No() {
		return Phone_No;
	}
	public void setPhone_No(String phone_No) {
		Phone_No = phone_No;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public int getLoan_Amt() {
		return Loan_Amt;
	}
	public void setLoan_Amt(int loan_Amt) {
		Loan_Amt = loan_Amt;
	}
	
	

}

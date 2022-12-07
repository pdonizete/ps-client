package net.paulosoft.client.dto;

import java.io.Serializable;
import java.time.Instant;

import net.paulosoft.client.entities.Client;


public class ClientDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String cpf;
    private double income;
    private Instant birtDate;
    private Integer children;
public ClientDTO() {
}

public ClientDTO(Long id, String name, String cpf, double income, Instant birtDate, Integer children) {

	this.id = id;
	this.name = name;
	this.cpf = cpf;
	this.income = income;
	this.birtDate = birtDate;
	this.children = children;
}
public ClientDTO(Client entity) {
	this.id=entity.getId();
	this.name=entity.getName();
	this.cpf=entity.getCpf();
	this.income=entity.getIncome();
	this.children=entity.getChildren();
	this.birtDate=entity.getBirtDate();
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public double getIncome() {
	return income;
}
public void setIncome(double income) {
	this.income = income;
}
public Instant getBirtDate() {
	return birtDate;
}
public void setBirtDate(Instant birtDate) {
	this.birtDate = birtDate;
}
public Integer getChildren() {
	return children;
}
public void setChildren(Integer children) {
	this.children = children;
}

}

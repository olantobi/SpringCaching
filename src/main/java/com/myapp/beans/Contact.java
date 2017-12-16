package com.myapp.beans;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="Contact")
@JsonSerialize
public class Contact implements Serializable{
	//Added in master branch..
	private static final long serialVersionUID = 3093242533060827239L;

	//no conflict added.
	public Contact() {
	}

	public Contact(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//Dev Branch 
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private int id;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
        
        
}
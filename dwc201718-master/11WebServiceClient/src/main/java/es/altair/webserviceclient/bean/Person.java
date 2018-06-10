package es.altair.webserviceclient.bean;

import java.io.Serializable;

public class Person implements Serializable {

	private int id;

	private String name;

	private String country;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(int id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}

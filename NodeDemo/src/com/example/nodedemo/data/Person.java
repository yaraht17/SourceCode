package com.example.nodedemo.data;

import java.io.Serializable;




public class Person implements Serializable{
	private String name,age,address;
	private int id;

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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Person(String name, String age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Person(int id, String name, String age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.id = id;
	}

	public Person() {
		super();
	}


	

}

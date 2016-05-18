package com.beabettercoder.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="person")
public class Subscriber {
	
	@Id
	@Column(name="id")
	//@TODO play with auto increment and see if we have manual values also if needed
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id ;

	@Size(min=2,max=30)
	@Column(name="name")
	private String name;
	
	@NotEmpty @Email
	@Transient
	private String email;	
	
	@NotNull @Min(13) @Max(110)
	@Transient
	private Integer age;
	
	@NotNull
	@Transient
	private Gender gender;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	@NotEmpty
	@Transient
	private String phone;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
//	@NotNull @Past
	@Transient
	private Date birthday;
	
	@Transient
	private Frequency newsletterFrequency;
	
	@Transient
	private Boolean receiveNewsletter;
	
	public enum Frequency {
		HOURLY, DAILY, WEEKLY, MONTHLY, ANNUALLY
	}
	
	
	public enum Gender {
		MONKEY, FEMALE
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Frequency getNewsletterFrequency() {
		return newsletterFrequency;
	}

	public void setNewsletterFrequency(Frequency newsletterFrequency) {
		this.newsletterFrequency = newsletterFrequency;
	}

	public Boolean getReceiveNewsletter() {
		return receiveNewsletter;
	}

	public void setReceiveNewsletter(Boolean receiveNewsletter) {
		this.receiveNewsletter = receiveNewsletter;
	}

	public String getPhone() {
		return phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Subscriber [name=" + name + ", age=" + age + ", gender=" + gender
				+ ", newsletterFrequency=" + newsletterFrequency
				+ ", receiveNewsletter=" + receiveNewsletter + "]";
	}
	
}
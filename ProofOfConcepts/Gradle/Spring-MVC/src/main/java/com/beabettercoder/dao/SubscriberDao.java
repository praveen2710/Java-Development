package com.beabettercoder.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

//import com.beabettercoder.entities.Person;
import com.beabettercoder.entities.Subscriber;

//@TODO add interface and impl class and expand this
@Transactional
public class SubscriberDao {
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	public void savePerson(Subscriber s) {
		hibernateTemplate.save(s);
	}
}

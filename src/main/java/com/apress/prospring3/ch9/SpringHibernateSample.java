/**
 * Created on Oct 13, 2011
 */
package com.apress.prospring3.ch9;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring3.ch9.dao.ContactDao;
import com.apress.prospring3.ch9.domain.Contact;
import com.apress.prospring3.ch9.domain.ContactTelDetail;
import com.apress.prospring3.ch9.domain.Hobby;

/**
 * @author Clarence
 *
 */
public class SpringHibernateSample {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		
		// List contacts without details
		List<Contact> contacts = contactDao.findAll();
		//listContacts(contacts);	
		
		
		// List contacts with details
		contacts = contactDao.findAllWithDetail();
		listContactsWithDetail(contacts);
		/*
		Contact contact;
		
		// Find contact by ID
		contact = contactDao.findById(1l);
		System.out.println("");
		//System.out.println("Contact with id 1:" + contact);
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact);
		listContactsWithDetail(contacts);
		System.out.println("");		
		*/
		
		// Add new contact
		/*
		Contact contact;
		contact = new Contact();
		contact.setFirstName("Michael");
		contact.setLastName("Jackson");
		contact.setBirthDate(new Date());
		ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111111");
		contact.addContactTelDetail(contactTelDetail);
		contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
		contact.addContactTelDetail(contactTelDetail);
		contactDao.save(contact);
		contacts = contactDao.findAllWithDetail();
		listContactsWithDetail(contacts);
		*/
		
		// Update contact
		/*
		Contact contact = contactDao.findById(4l);
		contact.setFirstName("Kim Fung");
		Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
		ContactTelDetail toDeleteContactTel = null;
		for (ContactTelDetail contactTel: contactTels) {
			if (contactTel.getTelType().equals("Home")) {
				toDeleteContactTel = contactTel;
			}
		}
		contact.removeContactTelDetail(toDeleteContactTel);
		contactDao.save(contact);
		contacts = contactDao.findAllWithDetail();
		listContactsWithDetail(contacts);
		*/
		
		// Delete contact
		/*
		Contact contact = contactDao.findById(4l);
		contactDao.delete(contact);
		contacts = contactDao.findAllWithDetail();
		listContactsWithDetail(contacts);
		*/
		
		
	}
	
	private static void listContacts(List<Contact> contacts) {
		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (Contact contact: contacts) {
			System.out.println(contact);		
			System.out.println();	
		}
	}	
	
	private static void listContactsWithDetail(List<Contact> contacts) {
		System.out.println("");
		System.out.println("Listing contacts with details:");
		for (Contact contact: contacts) {
			System.out.println(contact);
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
					System.out.println(contactTelDetail);
				}
			}
			if (contact.getHobbies() != null) {
				for (Hobby hobby: contact.getHobbies()) {
					System.out.println(hobby);
				}
			}			
			System.out.println();
		}		
	}	
	
}

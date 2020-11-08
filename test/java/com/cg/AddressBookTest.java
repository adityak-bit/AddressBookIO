package com.cg;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.AddressBookService.IOService;

public class AddressBookTest {

	AddressBookService service;
	
	@Before
	public void setUp() {
		service = new AddressBookService();
	}
	
	//UC16
	@Test
	public void givenAddressBookDB_WhenRetrieved_ShouldMatchCount() {
		List<AddressBookData> addrList = service.readData(IOService.DB_IO);
		Assert.assertEquals(3, addrList.size());
	}
	
	//UC17
	@Test
	public void givenNewEmailForPerson_WhenUpdated_ShouldSyncWithDB() {
		List<AddressBookData> addrList = service.readData(IOService.DB_IO);
		service.updatePersonData("A", "A@GMAIL.COM");
		boolean result = service.checkPersonDataInSyncWithDB("A");
		Assert.assertTrue(result);
	}
	
	//UC19
	@Test
	public void givenAddressBookDB_WhenRetrievedByState_ShouldMatchCount() {
		List<AddressBookData> addrList = service.readDataByState(IOService.DB_IO, "A");
		Assert.assertEquals(2, addrList.size());
	}
}

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
	
	@Test
	public void givenAddressBookDB_WhenRetrieved_ShouldMatchCount() {
		List<AddressBookData> addrList = service.readData(IOService.DB_IO);
		Assert.assertEquals(3, addrList.size());
	}
}

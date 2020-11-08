package com.cg;

import java.util.List;

public class AddressBookService {

	private List<AddressBookData> addrList;
	private AddressBookDBService dbService;
	
	public enum IOService{
		DB_IO,
		REST_IO;
	}
	
	public AddressBookService() {
		dbService = AddressBookDBService.getInstance();
	}
	
	public AddressBookService(List<AddressBookData> addrList) {
		this();
		this.addrList = addrList;
	}

	public List<AddressBookData> readData(IOService ioService) {
		if(ioService.equals(IOService.DB_IO)) {
			this.addrList =  dbService.getData();
		}
		return addrList;
	}
}

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

	public void updatePersonData(String fname, String email) {
		int result = dbService.updatePersonData(fname, email);
		if(result == 0) return;
		AddressBookData data = this.getData(fname);
		if(data != null) data.email = email;
	}

	private AddressBookData getData(String fname) {
		return addrList.stream()
				       .filter(addressBookData ->  addressBookData.firstName.equals(fname))
				       .findFirst()
				       .orElse(null);
	}

	public boolean checkPersonDataInSyncWithDB(String fname) {
		List<AddressBookData> addrList = dbService.getData();
		return addrList.get(0).equals(getData(fname));
	}
}

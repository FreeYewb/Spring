package com.spring5.hibernate.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring5.hibernate.service.BookShopService;
import com.spring5.hibernate.service.Cashier;

@Service
public class CashierImpl implements Cashier {
	
	private BookShopService bookShopService;
	@Override
	public void checkout(String username, List<String> isbns) {
		// TODO Auto-generated method stub
		for(String isbn : isbns ) {
			bookShopService.purchase(username, isbn);
		}
	}

}

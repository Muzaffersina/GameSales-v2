package com.steamlike.steamlike.core.mernis.concretes;

import org.springframework.stereotype.Service;


import com.steamlike.steamlike.core.mernis.abstracts.PersonCheckAdapterService;
import com.steamlike.steamlike.entity.concretes.Gamer;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class PersonCheckAdapterManager implements PersonCheckAdapterService {
	
	

	@Override
	public boolean isPersonExist(Gamer gamer) {
	
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();

		try {
			kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(gamer.getSsn()), gamer.getFirstName(),
					gamer.getLastName(), gamer.getDateOfBirth());
			System.out.println("successful validation");
			return true;

		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("failed validation");
			return false;
		}
	}
}

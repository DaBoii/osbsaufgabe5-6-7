package de.hfu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;

public class StubResidentRepository implements ResidentRepository {
	
	List <Resident> bewohner = new ArrayList<Resident>();
	
	public StubResidentRepository() {
		super();
		bewohner.add(new Resident("Tobi", "Utry", "Straße", "Rottweil", new Date(123456)));
		bewohner.add(new Resident("Peter", "Utry", "Straße", "Rottweil", new Date(123456)));
		bewohner.add(new Resident("Jonas", "Schlecht", "Toll", "Rottweil", new Date(123456)));
		bewohner.add(new Resident("Leon", "Flaig", "Uhland", "Rottweil", new Date(123456)));
	}


	public List<Resident> getResidents() {

		return bewohner;
	}

}

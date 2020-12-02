package de.hfu;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class ResidentTest {

	@Test
	public void testGetFilteredResidentsList() {
		BaseResidentService base = new BaseResidentService();
		StubResidentRepository stub = new StubResidentRepository();
		base.setResidentRepository(stub);
		Resident filter = new Resident();
		filter.setGivenName("Tobi");
		assertEquals(1, base.getFilteredResidentsList(filter).size());
		filter.setFamilyName("Utry");
		assertEquals(1, base.getFilteredResidentsList(filter).size());
		filter.setStreet("Straße");
		assertEquals(1, base.getFilteredResidentsList(filter).size());
		Resident filter1 = new Resident();
		filter1.setFamilyName("Utry");
		assertEquals(2, base.getFilteredResidentsList(filter1).size());	
	}
	
	@Test
	public void testGetUniqueResident() throws ResidentServiceException {
		BaseResidentService base = new BaseResidentService();
		StubResidentRepository stub = new StubResidentRepository();
		base.setResidentRepository(stub);
		
		Resident filter = new Resident();
		filter.setGivenName("Tobi");
		
		Resident control = new Resident("Tobi", "Utry", "Straße", "Rottweil", new Date(123456));
		
		assertEquals(control,base.getUniqueResident(filter));
		
		Resident filter1 = new Resident();
		filter1.setFamilyName("Schlecht");
		Resident control1 = new Resident("Jonas", "Schlecht", "Toll", "Rottweil", new Date(123456));
		
		assertEquals(control1,base.getUniqueResident(filter1));
		
		Resident filter2 = new Resident();
		filter2.setStreet("Uhland");
		Resident control2 = new Resident("Leon", "Flaig", "Uhland", "Rottweil", new Date(123456));
		
		assertEquals(control2,base.getUniqueResident(filter2));
	}
	
	@Test(expected=ResidentServiceException.class)
	public void testGivinNameException() throws ResidentServiceException {
		BaseResidentService base = new BaseResidentService();
		StubResidentRepository stub = new StubResidentRepository();
		base.setResidentRepository(stub);
		
		Resident filter = new Resident();
		filter.setGivenName("*");
		
		Resident control = new Resident("Tobi", "Utry", "Straße", "Rottweil", new Date(123456));
		
		assertEquals(control,base.getUniqueResident(filter));
	}
	
	@Test(expected=ResidentServiceException.class)
	public void testFamilyNameException() throws ResidentServiceException {
		BaseResidentService base = new BaseResidentService();
		StubResidentRepository stub = new StubResidentRepository();
		base.setResidentRepository(stub);
		
		Resident filter = new Resident();
		filter.setFamilyName("*");
		
		Resident control = new Resident("Tobi", "Utry", "Straße", "Rottweil", new Date(123456));
		
		assertEquals(control,base.getUniqueResident(filter));
	}
	
	@Test(expected=ResidentServiceException.class)
	public void testStreetException() throws ResidentServiceException {
		BaseResidentService base = new BaseResidentService();
		StubResidentRepository stub = new StubResidentRepository();
		base.setResidentRepository(stub);
		
		Resident filter = new Resident();
		filter.setStreet("*");
		
		Resident control = new Resident("Tobi", "Utry", "Straße", "Rottweil", new Date(123456));
		
		assertEquals(control,base.getUniqueResident(filter));
	}
	
	@Test(expected=ResidentServiceException.class)
	public void testNoFoundException() throws ResidentServiceException {
		BaseResidentService base = new BaseResidentService();
		StubResidentRepository stub = new StubResidentRepository();
		base.setResidentRepository(stub);
		
		Resident filter = new Resident();
		filter.setStreet("Rolf");
		
		Resident control = new Resident("Tobi", "Utry", "Straße", "Rottweil", new Date(123456));
		
		assertEquals(control,base.getUniqueResident(filter));
	}
}


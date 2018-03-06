package com.lanu.trucks_repair_shop;

import com.lanu.trucks_repair_shop.entities.Part;
import com.lanu.trucks_repair_shop.entities.Unit;
import com.lanu.trucks_repair_shop.services.PartService;
import com.lanu.trucks_repair_shop.services.UnitService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrucksRepairShopApplicationTests {

	@Autowired
	private UnitService unitService;

	@Autowired
	private PartService partService;

	@Before
	public void initDb(){

		Unit theUnit = new Unit(new Long(12345678), "truck", 775, 2011);
		unitService.createUnit(theUnit);

		Part thePart = new Part("Tire", new Date());
		Unit unit = unitService.findOne(12345678);
		partService.createPart(thePart, unit);
	}

	@Test
	public void testUnit(){
		Unit unit = unitService.findOne(12345678);
		assertNotNull(unit);
		assertEquals(unit.getVinNumber(),new Long(12345678));
	}

	@Test
	public void testPart(){
		Unit unit = unitService.findOne(12345678);
		List<Part> parts = partService.findUnitParts(unit);
		assertNotNull(parts);
	}

}

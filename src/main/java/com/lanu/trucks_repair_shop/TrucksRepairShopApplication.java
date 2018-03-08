package com.lanu.trucks_repair_shop;

import com.lanu.trucks_repair_shop.entities.Breaking;
import com.lanu.trucks_repair_shop.entities.Part;
import com.lanu.trucks_repair_shop.entities.Unit;
import com.lanu.trucks_repair_shop.services.BreakingService;
import com.lanu.trucks_repair_shop.services.PartService;
import com.lanu.trucks_repair_shop.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TrucksRepairShopApplication implements CommandLineRunner{

	@Autowired
	private UnitService unitService;

	@Autowired
	private BreakingService breakingService;

	@Autowired
	private PartService partService;

	public static void main(String[] args) {
		SpringApplication.run(TrucksRepairShopApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		Unit unit = new Unit(new Long(12345678), 775, "Truck", "Volvo", "780", 2011);
		Unit unit2 = new Unit(new Long(67347612), 800, "Truck", "Volvo", "780", 2013);
		Unit unit3 = new Unit(new Long(87455437), 777, "Trailer", "Grey Dane", "", 2011);
		Part part = new Part("Hose", "03/07/2018", unit, new Long(966000));
		Breaking breaking = new Breaking(new Date(), new Long(966000), unit);

		unitService.save(unit);
		unitService.save(unit2);
		unitService.save(unit3);
		breakingService.createBreaking(breaking, unit2);
		partService.createPart(part, unit3);
	}
}

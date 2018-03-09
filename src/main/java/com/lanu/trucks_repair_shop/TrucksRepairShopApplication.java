package com.lanu.trucks_repair_shop;

import com.lanu.trucks_repair_shop.entities.*;
import com.lanu.trucks_repair_shop.services.BreakingService;
import com.lanu.trucks_repair_shop.services.PartService;
import com.lanu.trucks_repair_shop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrucksRepairShopApplication implements CommandLineRunner{

	@Autowired
	private VehicleService vehicleService;

	@Autowired PartService partService;

	@Autowired
	private BreakingService breakingService;

	public static void main(String[] args) {
		SpringApplication.run(TrucksRepairShopApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Truck truck = new Truck("Cummins",
						775,
						"12345678",
						"Truck",
						"Volvo",
						"780",
						2011);

		Trailer trailer = new Trailer(
						1025,
						"87654321",
						"Trailer",
						"GreyDane",
						"",
						2003,
						53,
						true);

		Part part = new Part("Tire", "03/07/2018", 966000);

		Breaking breaking = new Breaking("03/07/2018", 966700);

		vehicleService.save(truck);
		vehicleService.save(trailer);
		partService.createPart(part, truck);
		breakingService.createBreaking(breaking, truck);




		/*Truck truck1 = (Truck) vehicleService.findByNumber(new Integer(775));
		System.out.println(truck1);*/
	}
}

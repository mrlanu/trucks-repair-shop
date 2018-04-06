package com.lanu.trucks_repair_shop;

import com.lanu.trucks_repair_shop.domain.breaking.Breaking;
import com.lanu.trucks_repair_shop.domain.breaking.BreakingDetail;
import com.lanu.trucks_repair_shop.domain.security.Role;
import com.lanu.trucks_repair_shop.domain.security.User;
import com.lanu.trucks_repair_shop.domain.vehicle.Make;
import com.lanu.trucks_repair_shop.domain.vehicle.Trailer;
import com.lanu.trucks_repair_shop.domain.vehicle.Truck;
import com.lanu.trucks_repair_shop.repositories.MakeRepository;
import com.lanu.trucks_repair_shop.services.security_services.UserService;
import com.lanu.trucks_repair_shop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TrucksRepairShopApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private MakeRepository makeRepository;

	public static void main(String[] args) {
		SpringApplication.run(TrucksRepairShopApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		init();
	}

	private void init(){

		User userAdmin = new User("fargo", "fargo", "Serhiy", "Khabenyuk",
				"mrlanu@gmail.com", "(773)430 7554");
		userAdmin.addRole(new Role("ADMIN"));
		userService.createUser(userAdmin);

		User userDriver = new User("driver", "driver", "Igor", "Shershen",
				"shershen@mail.com", "(773)231 1716");
		userDriver.addRole(new Role("DRIVER"));
		userService.createUser(userDriver);

		User userUser = new User("user", "user", "Susan", "Public",
				"public@yahoo.com", "(800)555 7334");
		userService.createUser(userUser);

		Truck truck1 = new Truck("Cummins", 775, "123PI678", "Truck", "780", "2011");
		Truck truck2 = new Truck("Cummins", 777, "RTI45361", "Truck", "670", "2007");
		Truck truck3 = new Truck("Cummins", 800, "56238586", "Truck", "670", "2017");
		Truck truck4 = new Truck("Cummins", 779, "FMI67342", "Truck", "670", "2015");
		Truck truck5 = new Truck("Cummins", 802, "FX56P872", "Truck", "780", "2018");

		Trailer trailer1 = new Trailer(1025, "HTP67TY7", "Trailer", "model 02", "2003", 53, true);
		Trailer trailer2 = new Trailer(1009, "87654321", "Trailer", "3000 R", "2005", 53, true);
		Trailer trailer3 = new Trailer(1118, "7378TY89", "Trailer", "model 02", "2005", 53, false);
		Trailer trailer4 = new Trailer(1010, "WE782395", "Trailer", "3000 R", "2009", 53, true);
		Trailer trailer5 = new Trailer(1011, "PUY78673", "Trailer", "model 01", "2011", 53, false);
		Trailer trailer6 = new Trailer(1001, "HYW98HYI", "Trailer", "53X102", "2003", 53, true);

		Make makeVolvo = new Make("Volvo", "Truck");
		Make makeFreightliner = new Make("Freightliner", "Truck");
		Make makePeterbilt = new Make("Peterbilt", "Truck");
		Make makeGreatDane = new Make("Great Dane", "Trailer");
		Make makeUtility = new Make("Utility", "Trailer");
		Make makeWabash = new Make("Wabash", "Trailer");
		makeRepository.save(makeVolvo);
		makeRepository.save(makeFreightliner);
		makeRepository.save(makePeterbilt);
		makeRepository.save(makeGreatDane);
		makeRepository.save(makeUtility);
		makeRepository.save(makeWabash);

		truck1.setMake(makeFreightliner);
		truck2.setMake(makeVolvo);
		truck3.setMake(makeVolvo);
		truck4.setMake(makeFreightliner);
		truck5.setMake(makeVolvo);
		trailer1.setMake(makeGreatDane);
		trailer2.setMake(makeGreatDane);
		trailer3.setMake(makeUtility);
		trailer4.setMake(makeWabash);
		trailer5.setMake(makeUtility);
		trailer6.setMake(makeUtility);

		truck1.setBroken(true);
		Breaking breaking = new Breaking(new Date(), 875456);
		breaking.addBreakingDetail(new BreakingDetail("Tires", "Left inside"));
		breaking.addBreakingDetail(new BreakingDetail("Oil, PM service", "Change Oil"));
		breaking.setUserCreate(userDriver);
		truck1.addBreaking(breaking);
		vehicleService.save(truck1);
		vehicleService.save(truck2);
		vehicleService.save(truck3);
		vehicleService.save(truck4);
		vehicleService.save(truck5);

		vehicleService.save(trailer1);
		vehicleService.save(trailer2);
		vehicleService.save(trailer3);
		vehicleService.save(trailer4);
		vehicleService.save(trailer5);
		vehicleService.save(trailer6);

	}
}

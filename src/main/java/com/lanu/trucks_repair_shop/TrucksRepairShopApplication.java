package com.lanu.trucks_repair_shop;

import com.lanu.trucks_repair_shop.domain.*;
import com.lanu.trucks_repair_shop.domain.security.Role;
import com.lanu.trucks_repair_shop.domain.security.User;
import com.lanu.trucks_repair_shop.domain.vehicle.Make;
import com.lanu.trucks_repair_shop.domain.vehicle.Trailer;
import com.lanu.trucks_repair_shop.domain.vehicle.Truck;
import com.lanu.trucks_repair_shop.repositories.MakeRepository;
import com.lanu.trucks_repair_shop.services.BreakingDetailService;
import com.lanu.trucks_repair_shop.services.BreakingService;
import com.lanu.trucks_repair_shop.services.PartService;
import com.lanu.trucks_repair_shop.services.security_services.UserService;
import com.lanu.trucks_repair_shop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class TrucksRepairShopApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private MakeRepository makeRepository;

	@Autowired PartService partService;

	@Autowired
	private BreakingService breakingService;

	@Autowired
	private BreakingDetailService breakingDetailService;

	public static void main(String[] args) {
		SpringApplication.run(TrucksRepairShopApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		init();
	}

	private void init(){

		User userAdmin = new User();
		userAdmin.setUsername("fargo");
		userAdmin.setPassword("28335555");
		userAdmin.addRole(new Role("ADMIN"));
		userService.createUser(userAdmin);

		User userDriver = new User();
		userDriver.setUsername("driver");
		userDriver.setPassword("driver");
		userDriver.addRole(new Role("DRIVER"));
		userService.createUser(userDriver);

		User userUser = new User();
		userUser.setUsername("user");
		userUser.setPassword("user");
		userUser.addRole(new Role("USER"));
		userService.createUser(userUser);

		Truck truck1 = new Truck("Cummins", 775, "123PI678", "Truck", "780", "2011");
		Truck truck2 = new Truck("Cummins", 777, "RTI45361", "Truck", "670", "2007");
		Truck truck3 = new Truck("Cummins", 800, "56238586", "Truck", "670", "2017");
		Truck truck4 = new Truck("Cummins", 779, "FMI67342", "Truck", "670", "2015");
		Truck truck5 = new Truck("Cummins", 802, "FX56P872", "Truck", "780", "2018");
        truck1.setBroken(true);
        truck4.setBroken(true);

		Trailer trailer1 = new Trailer(1025, "HTP67TY7", "Trailer", "model 02", "2003", 53, true);
		Trailer trailer2 = new Trailer(1009, "87654321", "Trailer", "3000 R", "2005", 53, true);
		Trailer trailer3 = new Trailer(1118, "7378TY89", "Trailer", "model 02", "2005", 53, false);
		Trailer trailer4 = new Trailer(1010, "WE782395", "Trailer", "3000 R", "2009", 53, true);
		Trailer trailer5 = new Trailer(1011, "PUY78673", "Trailer", "model 01", "2011", 53, false);
		Trailer trailer6 = new Trailer(1001, "HYW98HYI", "Trailer", "53X102", "2003", 53, true);
        trailer3.setBroken(true);
        trailer2.setBroken(true);

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


		Part part1 = new Part("Tire", "03/07/2018", 966000);
		Part part2 = new Part("Hose", "01/17/2018", 113897);
		Part part3 = new Part("Hud", "01/07/2018", 500897);
		Part part4 = new Part("Rim", "03/04/2018", 480783);


		Breaking breaking1 = new Breaking(new Date(), 380990);
		Breaking breaking2 = new Breaking(new Date(), 380978);
		Breaking breaking3 = new Breaking(new Date(), 345345);
		Breaking breaking4 = new Breaking(new Date(), 966700);

		/*BreakingDetail breakingDetail = new BreakingDetail();
		breakingDetail.setDetail("Pizdec");

		breaking1.getBreakingDetailList().add(breakingDetail);*/

		vehicleService.save(truck1, "Volvo");
		vehicleService.save(truck2, "Volvo");
		vehicleService.save(truck3, "Volvo");
		vehicleService.save(truck4, "Peterbilt");
		vehicleService.save(truck5, "Freightliner");

		vehicleService.save(trailer1, "Wabash");
		vehicleService.save(trailer2, "Utility");
		vehicleService.save(trailer3, "Great Dane");
		vehicleService.save(trailer4, "Utility");
		vehicleService.save(trailer5, "Great Dane");
		vehicleService.save(trailer6, "Great Dane");

		partService.createPart(part1, truck2);
		partService.createPart(part2, truck1);
		partService.createPart(part3, truck5);
		partService.createPart(part4, truck2);

		breakingService.createBreaking(breaking1, truck1, userDriver);
		breakingService.createBreaking(breaking2, truck5, userDriver);
		breakingService.createBreaking(breaking3, truck2, userDriver);
		breakingService.createBreaking(breaking4, truck2, userDriver);

	}
}

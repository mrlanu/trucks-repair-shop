package com.lanu.trucks_repair_shop;

import com.lanu.trucks_repair_shop.domain.breaking.Breaking;
import com.lanu.trucks_repair_shop.domain.breaking.BreakingDetail;
import com.lanu.trucks_repair_shop.domain.security.Role;
import com.lanu.trucks_repair_shop.domain.security.Users;
import com.lanu.trucks_repair_shop.domain.vehicle.Make;
import com.lanu.trucks_repair_shop.domain.vehicle.Model;
import com.lanu.trucks_repair_shop.domain.vehicle.Trailer;
import com.lanu.trucks_repair_shop.domain.vehicle.Truck;
import com.lanu.trucks_repair_shop.repositories.MakeRepository;
import com.lanu.trucks_repair_shop.services.security_services.UserService;
import com.lanu.trucks_repair_shop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${spring.datasource.url}")
	private String springDatasourceUrl;

	public static void main(String[] args) {
		SpringApplication.run(TrucksRepairShopApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		//when running app on the localhost H2 DB the init() method will run

		String localDBUrlH2 = "jdbc:h2:mem:testdb";

		//if (springDatasourceUrl.equals(localDBUrlH2)){
			init();
		//}
	}

	private void init(){

	}
}

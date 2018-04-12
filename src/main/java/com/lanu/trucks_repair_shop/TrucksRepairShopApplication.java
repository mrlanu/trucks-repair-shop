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
import com.lanu.trucks_repair_shop.services.security_services.RoleService;
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

    @Autowired
    private RoleService roleService;

    @Value("${spring.datasource.url}")
    private String springDatasourceUrl;

    public static void main(String[] args) {
        SpringApplication.run(TrucksRepairShopApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        //when running app on the localhost H2 DB the init() method will run

        String localDBUrlH2 = "jdbc:h2:mem:testdb;";

        if (springDatasourceUrl.equals(localDBUrlH2)){
            init();
        }
    }

    private void init(){

        Role roleUser = new Role("USER");
        roleService.save(roleUser);
        Role roleAdmin = new Role("ADMIN");
        roleService.save(roleAdmin);
        Role roleDriver = new Role("DRIVER");
        roleService.save(roleDriver);
        Role roleMechanic = new Role("MECHANIC");
        roleService.save(roleMechanic);

        Users userAdmin = new Users("fargo", "fargo", "Serhiy", "Khabenyuk",
                "mrlanu@gmail.com", "(773)430 7554");
        userAdmin.addRole(roleAdmin);
        userService.createUser(userAdmin);

        Users userDriver = new Users("driver", "driver", "Igor", "Shershen",
                "shershen@mail.com", "(773)231 1716");
        userDriver.addRole(roleDriver);
        userService.createUser(userDriver);

        Users userMechanic = new Users("mechanic", "mechanic", "Piotr", "Borush",
                "piotr_KYS@kysexpress.com", "(773)589 9565");
        userMechanic.addRole(roleMechanic);
        userService.createUser(userMechanic);

        Users userUser = new Users("user", "user", "Susan", "Public",
                "public@yahoo.com", "(800)555 7334");
        userService.createUser(userUser);

        Truck truck1 = new Truck("Cummins", 775, "123PI678", "Truck", "2011");
        Truck truck2 = new Truck("Cummins", 777, "RTI45361", "Truck","2007");
        Truck truck3 = new Truck("Cummins", 800, "56238586", "Truck", "2017");
        Truck truck4 = new Truck("Cummins", 779, "FMI67342", "Truck", "2015");
        Truck truck5 = new Truck("Cummins", 802, "FX56P872", "Truck", "2018");


        Trailer trailer1 = new Trailer(1025, "HTP67TY7", "Trailer", "2003", 53, true);
        Trailer trailer2 = new Trailer(1009, "87654321", "Trailer", "2005", 53, true);
        Trailer trailer3 = new Trailer(1118, "7378TY89", "Trailer", "2005", 53, false);
        Trailer trailer4 = new Trailer(1010, "WE782395", "Trailer", "2009", 53, true);
        Trailer trailer5 = new Trailer(1011, "PUY78673", "Trailer", "2011", 53, false);
        Trailer trailer6 = new Trailer(1001, "HYW98HYI", "Trailer", "2003", 53, true);

        Make makeVolvo = new Make("Volvo", "Truck");
        Model model630 = new Model("630");
        Model model670 = new Model("670");
        Model model780 = new Model("780");
        makeVolvo.addModel(model630);
        makeVolvo.addModel(model670);
        makeVolvo.addModel(model780);

        Make makeFreightliner = new Make("Freightliner", "Truck");
        Model modelCascadia = new Model("Cascadia");
        Model modelColumbia = new Model("Columbia");
        Model modelCentury = new Model("Century");
        Model modelCoronado = new Model("Coronado");
        makeFreightliner.addModel(modelCascadia);
        makeFreightliner.addModel(modelCentury);
        makeFreightliner.addModel(modelColumbia);
        makeFreightliner.addModel(modelCoronado);

        Make makePeterbilt = new Make("Peterbilt", "Truck");
        Model model357 = new Model("357");
        Model model365 = new Model("365");
        Model model387 = new Model("387");
        Model model379 = new Model("379");
        makePeterbilt.addModel(model357);
        makePeterbilt.addModel(model365);
        makePeterbilt.addModel(model387);
        makePeterbilt.addModel(model379);

        Make makeGreatDane = new Make("Great Dane", "Trailer");
        Make makeUtility = new Make("Utility", "Trailer");
        Make makeWabash = new Make("Wabash", "Trailer");

        makeRepository.save(makeVolvo);
        makeRepository.save(makeFreightliner);
        makeRepository.save(makePeterbilt);
        makeRepository.save(makeGreatDane);
        makeRepository.save(makeUtility);
        makeRepository.save(makeWabash);

        truck1.setMake(makeVolvo);
        truck1.setModel(model780);
        truck2.setMake(makeFreightliner);
        truck2.setModel(modelCascadia);
        truck3.setMake(makeFreightliner);
        truck3.setMake(makePeterbilt);
        truck3.setModel(model379);
        truck4.setMake(makeFreightliner);
        truck4.setModel(modelColumbia);
        truck5.setMake(makeVolvo);
        truck5.setModel(model670);
        trailer1.setMake(makeGreatDane);
        trailer2.setMake(makeGreatDane);
        trailer3.setMake(makeUtility);
        trailer4.setMake(makeWabash);
        trailer5.setMake(makeUtility);
        trailer6.setMake(makeUtility);

        truck1.setBroken(true);
        Breaking breaking = new Breaking(new Date(), "875456");
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
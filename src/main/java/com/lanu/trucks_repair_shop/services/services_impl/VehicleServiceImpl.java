package com.lanu.trucks_repair_shop.services.services_impl;

import com.lanu.trucks_repair_shop.domain.breaking.Breaking;
import com.lanu.trucks_repair_shop.domain.breaking.BreakingDetail;
import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;
import com.lanu.trucks_repair_shop.repositories.BreakingRepository;
import com.lanu.trucks_repair_shop.repositories.MakeRepository;
import com.lanu.trucks_repair_shop.repositories.VehicleRepository;
import com.lanu.trucks_repair_shop.services.VehicleService;
import com.lanu.trucks_repair_shop.services.security_services.UserService;
import com.lanu.trucks_repair_shop.util.KindOfBreaking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private KindOfBreaking kindOfBreaking;

    @Autowired
    private BreakingRepository breakingRepository;

    @Override
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle findByNumber(Integer number) {
        return vehicleRepository.findByNumber(number);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public boolean isVehiclePresent(Vehicle vehicle) {
        return vehicleRepository.findByNumber(vehicle.getNumber()) != null ? true:false;
    }

    @Override
    public void deleteVehicle(Integer number) {
        vehicleRepository.delete(number);
    }

    @Override
    public void createBreaking(Integer[] breakingKind, String[] descriptionList,
                               Integer vehicleNumber, Principal principal, Breaking breaking){
        Map<Integer, String> map = kindOfBreaking.getKindMap();
        Vehicle vehicle = vehicleRepository.findByNumber(vehicleNumber);
        List<BreakingDetail> breakingDetailList = Arrays.asList(breakingKind)
                .stream()
                .map(i -> new BreakingDetail(map.get(i), descriptionList[i]))
                .collect(Collectors.toList());

        breaking.setBreakingDetailList(breakingDetailList);
        breaking.setUserCreate(userService.findByUsername(principal.getName()));
        breaking.setDateCreate(new Date());
        vehicle.addBreaking(breaking);
        vehicle.setBroken(true);
        vehicleRepository.save(vehicle);
    }

    @Override
    public void fixingBreaking(Integer id, Principal principal) {
        Breaking breaking = breakingRepository.findByBreakingId(id);
        breaking.setDateFixed(new Date());
        breaking.setUserFixing(userService.findByUsername(principal.getName()));
        breaking.setFixed(true);
        breakingRepository.save(breaking);
    }
}

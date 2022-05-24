package furama_resort.services.impl;

import furama_resort.model.facility.Facility;
import furama_resort.services.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityServiceImpl  implements FacilityService {
    FacilityService villaService=new VillaServiceImpl();
    FacilityService houseService=new HouseServiceImpl();
    FacilityService roomService=new RoomServiceImpl();

    static Map<Facility,Integer> facilityMap=new LinkedHashMap<>();
    static {

    }

    @Override
    public void display() {
        villaService.display();
        houseService.display();
        roomService.display();
    }

    public void maintenanceDisplay(){

    }

    @Override
    public void add() {

    }
}

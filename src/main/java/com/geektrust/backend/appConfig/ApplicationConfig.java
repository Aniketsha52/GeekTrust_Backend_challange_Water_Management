package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.AddGuestCommand;
import com.geektrust.backend.commands.AllotWaterCommand;
import com.geektrust.backend.commands.BillCommand;
import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.repositories.*;
import com.geektrust.backend.services.*;

public class ApplicationConfig {
    private final IApartmentRepository apartmentRepository = new ApartmentRepository();
    private final IGuestRepository guestRepository = new GuestRepository();
    private final IWaterFor2BHKApartmentRepo waterFor2BHKApartmentRepo = new WaterFor2BHKApartmentRepo();
    private final IWaterFor3BHKApartmentRepo waterFor3BHKApartmentRepo = new WaterFor3BHKApartmentRepo();

    private final IApartmentService apartmentService = new ApartmentService(apartmentRepository);
    private final IAddGuestService addGuestService = new AddGuestService(guestRepository);
    private final IBillGenerationService billGenerationService = new BillGenerationService(waterFor2BHKApartmentRepo,waterFor3BHKApartmentRepo,addGuestService);


    private final AllotWaterCommand allotWaterCommand = new AllotWaterCommand(apartmentService);
    private final AddGuestCommand addGuestCommand = new AddGuestCommand(addGuestService);
    private final BillCommand billCommand = new BillCommand(apartmentService,billGenerationService,addGuestService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("ALLOT_WATER",allotWaterCommand);
        commandInvoker.register("ADD_GUESTS",addGuestCommand);
        commandInvoker.register("BILL" ,billCommand);
        return commandInvoker;
    }
}

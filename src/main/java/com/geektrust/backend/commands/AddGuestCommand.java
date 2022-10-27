package com.geektrust.backend.commands;

import com.geektrust.backend.entites.Guest;
import com.geektrust.backend.exception.NoSuchCommandException;
import com.geektrust.backend.services.IAddGuestService;

import java.util.List;

public class AddGuestCommand implements ICommand{
    private final IAddGuestService addGuestService;

    public AddGuestCommand(IAddGuestService addGuestService) {
        this.addGuestService = addGuestService;
    }

    @Override
    public void execute(List<String> tokens)throws NoSuchCommandException {
        try {
            String name = tokens.get(0);
            String guests = tokens.get(1);
            Guest guest = addGuestService.addGuest(guests);
            //System.out.println(guest);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}

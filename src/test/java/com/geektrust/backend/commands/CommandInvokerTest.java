package com.geektrust.backend.commands;

import com.geektrust.backend.exception.NoSuchCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;

@DisplayName("CommandInvokerTest")
@ExtendWith(MockitoExtension.class)
class CommandInvokerTest {
    private CommandInvoker commandInvoker;
    @Mock
    private AddGuestCommand addGuestCommand;
    @Mock
    private AllotWaterCommand allotWaterCommand;
    @Mock
    private BillCommand billCommand;

    @BeforeEach
    void setup(){
        commandInvoker = new CommandInvoker();
        commandInvoker.register("ALLOT_WATER",allotWaterCommand);
        commandInvoker.register("ADD_GUESTS",addGuestCommand);
        commandInvoker.register("BILL" ,billCommand);
    }

    @Test
    @DisplayName("executeCommand method Should Execute Command Given CommandName and List of tokens")
    void executeCommand_GivenNameAndTokens_ShouldExecuteCommand() {
        commandInvoker.executeCommand("ALLOT_WATER",anyList());
        commandInvoker.executeCommand("ADD_GUESTS",anyList());
        commandInvoker.executeCommand("BILL",anyList());
    }
    @Test
    @DisplayName("executeCommand method Should Throw Exception Given Incorrect CommandName and List of tokens")
    public void executeCommand_GivenIncorrectNameAndTokens_ShouldThrowException() {
        //Act and Assert
        Assertions.assertThrows(NoSuchCommandException.class,() -> commandInvoker.executeCommand("RANDOM-COMMAND",new ArrayList<String>()));

    }
}
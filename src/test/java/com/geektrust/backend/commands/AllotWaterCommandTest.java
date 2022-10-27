package com.geektrust.backend.commands;

import com.geektrust.backend.entites.Apartment;
import com.geektrust.backend.entites.ApartmentType;
import com.geektrust.backend.exception.ApartmentNotFound;
import com.geektrust.backend.exception.WaterRatioNotFound;
import com.geektrust.backend.services.IAddGuestService;
import com.geektrust.backend.services.IApartmentService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@DisplayName("Allot water Test")
@ExtendWith(MockitoExtension.class)
class AllotWaterCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    IApartmentService apartmentServiceMock;
    @InjectMocks
    AllotWaterCommand allotWaterCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }




    @Test
    @DisplayName("execute method of AllotWaterCommand Should Print Error Message To Console If Apartment Not Found")
    public void executeMethod_PrintIfApartment_NotFound(){
        String expectedOutput = "Allot Water for given apartment:  not found!";
        doThrow(new ApartmentNotFound(expectedOutput)).when(apartmentServiceMock).create(any(ApartmentType.class),anyString());
        allotWaterCommand.execute(List.of("ALLOT_WATER","2","1:2"));
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
        verify(apartmentServiceMock,times(1)).create(any(ApartmentType.class),anyString());
    }

    @Test
    @DisplayName("execute method of AllotWaterCommand Should Print Error Message To Console If water Not Found")
    public void executeMethod_PrintIfWaterRatio_NotFound(){
        String expectedOutput = "Allot Water for given waterRatio:  not found!";
        doThrow(new WaterRatioNotFound(expectedOutput)).when(apartmentServiceMock).create(any(ApartmentType.class),anyString());
        allotWaterCommand.execute(List.of("ALLOT_WATER","2","1:2"));
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
        verify(apartmentServiceMock,times(1)).create(any(ApartmentType.class),anyString());
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}
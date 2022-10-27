package com.geektrust.backend.services;

import com.geektrust.backend.dtos.BillGenerationDto;
import com.geektrust.backend.entites.ApartmentType;
import com.geektrust.backend.entites.Water;
import com.geektrust.backend.entites.WaterType;
import com.geektrust.backend.repositories.IGuestRepository;
import com.geektrust.backend.repositories.IWaterFor2BHKApartmentRepo;
import com.geektrust.backend.repositories.IWaterFor3BHKApartmentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@DisplayName("BillGenerationTest")
@ExtendWith(MockitoExtension.class)
class BillGenerationServiceTest {
    @Mock
    private IWaterFor2BHKApartmentRepo waterFor2BHKApartmentMock;
    @Mock
    private IWaterFor3BHKApartmentRepo waterFor3BHKApartmentMock;

    @Mock
    private IGuestRepository guestRepositoryMock;

    @Mock
    private IAddGuestService addGuestServiceMock;

    @InjectMocks
    private BillGenerationService billGenerationService;


    @Test
    @DisplayName("This method should return total water price and total water if Apartment is 2BHK")
   public void billFor_2BHKApartment() {
        ApartmentType apartmentType = ApartmentType.apartment_2BHK;
        int corporationWaterRatio = 1;
        int borewellWaterPrice = 2;

        Water water = new Water(900,1200);

        double waterPrice = 1200.0;
        double totalWater = 900.0;


        BillGenerationDto expectedBillGenerationDto = new BillGenerationDto(water);

        when(waterFor2BHKApartmentMock.waterPrice(anyInt(),anyInt())).thenReturn(waterPrice);
        when(waterFor2BHKApartmentMock.totalWaterFor2BHK()).thenReturn(totalWater);

        BillGenerationDto actualBillGenerationDto = billGenerationService.BillForEveryMonthAllotedWater(apartmentType,corporationWaterRatio,borewellWaterPrice);

        Assertions.assertEquals(expectedBillGenerationDto.toString(),actualBillGenerationDto.toString());

        verify(waterFor2BHKApartmentMock,times(1)).waterPrice(anyInt(),anyInt());

        verify(waterFor2BHKApartmentMock,times(1)).totalWaterFor2BHK();
    }

    @Test
    @DisplayName("This method should return total water price and total water if Apartment is 3BHK")
   public void billFor_2BHK(){
        ApartmentType apartmentType = ApartmentType.apartment_3BHK;
        int corporationWaterRatio = 2;
        int borewellWaterPrice = 1;

        Water water = new Water(1500.0,1750.0);

        double waterPrice = 1750.0;
        double totalWater = 1500.0;

        BillGenerationDto expectedBillGenerationDto = new BillGenerationDto(water);

        when(waterFor3BHKApartmentMock.waterPrice(anyInt(),anyInt())).thenReturn(waterPrice);
        when(waterFor3BHKApartmentMock.totalWaterFor3BHK()).thenReturn(totalWater);

        BillGenerationDto actualBillGenerationDto = billGenerationService.BillForEveryMonthAllotedWater(apartmentType,corporationWaterRatio,borewellWaterPrice);
        //System.out.println(actualBillGenerationDto.toString());
        Assertions.assertEquals(expectedBillGenerationDto.toString(),actualBillGenerationDto.toString());
        verify(waterFor3BHKApartmentMock,times(1)).waterPrice(anyInt(),anyInt());

        verify(waterFor3BHKApartmentMock,times(1)).totalWaterFor3BHK();
    }

    @DisplayName("This method should return water used By guest")
    @Test
    public void billFor_Guest(){
        WaterType waterType = WaterType.tanker;
        double totalWater = 1500;
        double totalPriceOfWater = 4000;

        Water water = new Water(1500,4000);
        BillGenerationDto expectedBillGenerationDto = new BillGenerationDto(water);
        when(addGuestServiceMock.totalWaterUsedByGuest(any(WaterType.class))).thenReturn(totalWater);
        when(addGuestServiceMock.totalWaterPriceForGuest(any(WaterType.class))).thenReturn(totalPriceOfWater);

        BillGenerationDto actualBillGenerationDto = billGenerationService.BillForGuest(waterType);

        Assertions.assertEquals(expectedBillGenerationDto.toString(),actualBillGenerationDto.toString());
        verify(addGuestServiceMock,times(1)).totalWaterPriceForGuest(any(WaterType.class));
        verify(addGuestServiceMock,times(1)).totalWaterPriceForGuest(any(WaterType.class));

    }
}
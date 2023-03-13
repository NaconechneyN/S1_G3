package com.bootcamp.spring1.unit.repository;

import com.bootcamp.spring1.model.HotelModel;
import com.bootcamp.spring1.repository.HotelRepository;
import com.bootcamp.spring1.utils.HotelFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HotelRepositoryTest {
    HotelRepository hotelRepository = new HotelRepository();

    @Test

    public void getHotelsQuantityTest() {

        //arrange
          Integer expected = 1;

        //act
          var result = hotelRepository.getHotels();

        //assert
        Assertions.assertEquals(expected, result.size());
    }

    @Test

    public void getHotelsTest() {

        //arrange
        List<HotelModel> expected = new ArrayList<>();
        HotelModel hotels = HotelFactory.getHotels();
        expected.add(hotels);

        //act

        var result = hotelRepository.getHotels();

        //assert

        Assertions.assertEquals(expected, result);
    }

    @Test

    public void buscarPrecioHotelTest() {
        //arrange
        String codeHotel = "CH-0002";
        Double expected = HotelFactory.getHotels().getPrice();

        //act
        var result = hotelRepository.buscarPrecioHotel(codeHotel);

        //assert
        Assertions.assertEquals(expected, result);
    }

}

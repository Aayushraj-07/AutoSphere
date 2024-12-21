package com.codewithaayush.services.admin;

import com.codewithaayush.dto.BookACarDto;
import com.codewithaayush.dto.CarDto;
import com.codewithaayush.dto.CarDtoListDto;
import com.codewithaayush.dto.SearchCarDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    boolean postCar(CarDto carDto) throws IOException;

    List<CarDto> getAllCars();

    void deleteCar(Long id );

    CarDto getCarById(Long id);

    boolean updateCar(Long carId, CarDto carDto) throws IOException;

    List<BookACarDto> getBookings();

    boolean changeBookingsStatus(Long bookingId, String status);

     CarDtoListDto searchCar(SearchCarDto searchCarDto);
}

package com.codewithaayush.services.customer;

import com.codewithaayush.dto.BookACarDto;
import com.codewithaayush.dto.CarDto;
import com.codewithaayush.dto.CarDtoListDto;
import com.codewithaayush.dto.SearchCarDto;

import java.util.List;

public interface CustomerService {

    List<CarDto> getAllCars();

    boolean bookACar(BookACarDto bookACarDto);

    CarDto getCarById(Long carId);

    List<BookACarDto> getBookingsByUserId(Long userId);

    CarDtoListDto searchCar(SearchCarDto searchCarDto);

}

package com.codewithaayush.dto;

import lombok.Data;

import java.util.List;

@Data
public class CarDtoListDto {
    private List<CarDto> carDtoList;

    public List<CarDto> getCarDtoList() {
        return carDtoList;
    }

    public void setCarDtoList(List<CarDto> carDtoList) {
        this.carDtoList = carDtoList;
    }
}

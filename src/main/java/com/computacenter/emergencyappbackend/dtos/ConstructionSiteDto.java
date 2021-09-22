package com.computacenter.emergencyappbackend.dtos;

import lombok.Data;

@Data
public class ConstructionSiteDto {

    public Long id;
    public String city;
    public String street;
    public int houseNumber;
    public Long zipCode;
}

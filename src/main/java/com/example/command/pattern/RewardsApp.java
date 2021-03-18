package com.example.command.pattern;


import com.example.command.pattern.domain.Breakdown;
import com.example.command.pattern.domain.Requestdto;
import com.example.command.pattern.domain.ResponseDto;
import com.example.command.pattern.domain.Reward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RewardsApp {

    public static void main(String[] args) {

        System.out.println(" Here in main ");
        RewardsService rs = new RewardsService();
        ResponseDto responseDto = rs.prepareResponse();

        printAllDivident(responseDto);
        double dd = rs.calculateTotalRewards(responseDto);
        System.out.println(" Ends here "+ dd);

        

        // Demo invalid search parameter
       /* SearchCustomer searchBy2 = SeachCommandFactory.getSearchCommand("xxx")
                .orElseThrow(() -> new IllegalArgumentException("Missing valid search parameter ...."));
        searchBy.execute();*/



    }

    private static void printAllDivident(ResponseDto responseDto) {
        System.out.println(" Input to calculate Rewards "+responseDto.toString());
        System.out.println("Rewards total " + responseDto.getRewardsTotal());
        for (Reward rewards : responseDto.getRewards()) {
            for (Breakdown br :
                    rewards.getBreakdowns()) {
                if (br.getBalanceType().contains("Dividend")) {
                    System.out.println("Dividen " +br.getBalanceAmount());
                }

            }
        }
    }


   /* public static SearchResponseDto transform(List<Customer> customerList) {
        List<ResultDto> resultDtoList = new ArrayList<>();

        customerList.stream().forEach(customer -> {
            List<PhoneDto> phoneDtoList = new ArrayList<>();
            if(customer.getPhone().getPrimaryPhone()!=null)
                phoneDtoList.add(PhoneDto.builder().original(customer.getPhone().getPrimaryPhone())
                        .type(OTHER).build());
            if(customer.getPhone().getSecondaryPhone()!=null)
                phoneDtoList.add(PhoneDto.builder().original(customer.getPhone().getSecondaryPhone())
                        .type(OTHER).build());
            resultDtoList.add(ResultDto.builder()
                    .phones(!phoneDtoList.isEmpty()?phoneDtoList:null)
                    .customAttributes(CustomAttributesDto.builder()
                            .firstName(customer.getNameInfo().getFirstName())
                            .lastName(customer.getNameInfo().getLastName())
                            .streetAddress1(customer.getAddress().getAddressLine1())
                            .streetAddress2(customer.getAddress().getAddressLine2())
                            .city(customer.getAddress().getCity())
                            .state(customer.getAddress().getStateProvinceCode())
                            .country(customer.getAddress().getCountryCode())
                            .memberId(customer.getMemberId())
                            .employeeId(customer.getEmployeeId())
                            .opId(customer.getEmployeeId())
                            .postalCode(customer.getAddress().getPostalCode())
                            .build())
                    .email(customer.getEmail()).build());
        retun null;
        });
        return  SearchResponseDto.builder().results(resultDtoList).build();
    }*/







}

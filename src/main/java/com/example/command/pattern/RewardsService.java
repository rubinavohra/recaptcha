package com.example.command.pattern;

import com.example.command.pattern.domain.Breakdown;
import com.example.command.pattern.domain.ResponseDto;
import com.example.command.pattern.domain.Reward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class RewardsService {

     /*responseDto.getRewards().stream().filter(
            b -> {
        b.getBreakdowns().stream().filter(
                bal -> {
                    System.out.println("Balance Amount =>" + bal.getBalanceAmount());
                })
    });*/

    public double calculateTotalRewards(ResponseDto responseDto) {


        return responseDto.getRewardsTotal() - (responseDto.getRewards().stream().map(br -> br.getBreakdowns()).
                flatMap(bal -> bal.stream()).
                filter(bal -> bal.getBalanceType().contains("Dividend")).mapToDouble(Breakdown::getBalanceAmount).sum());


    }


    public ResponseDto prepareResponse() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMemberId("M1");
        responseDto.setFirstName("Name 1");
        responseDto.setLastName("L Name 1");
        responseDto.setRewardsTotal(875.00);
        responseDto.setRewards(createRewards());
        return responseDto;
    }

    private List<Reward> createRewards() {
        return Arrays.asList(
                new Reward(7.5, 2020, 2021, "2021-12-31T23:59:59.997", true,
                        Arrays.asList(new Breakdown("CoopMemberReward", "Co-op Member Reward", 7.5, false))),
                new Reward(305.69, 2019, 2020, "2022-01-03T23:59:59.997", true,
                        Arrays.asList(new Breakdown("Dividend", "Dividend", 26.07, true),
                                new Breakdown("MastercardReward", "Master card Reward", 279.62, true))),
                new Reward(441.82, 2020, 2021, "2023-01-03T23:59:59.997", true,
                        Arrays.asList(new Breakdown("MastercardReward", "Master card Reward", 441.82, true),
                                new Breakdown("Dividend", "Dividend", 48.93, true)))

        );
    }
}

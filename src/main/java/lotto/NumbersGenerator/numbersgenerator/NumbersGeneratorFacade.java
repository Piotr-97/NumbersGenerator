package lotto.NumbersGenerator.numbersgenerator;


import lombok.AllArgsConstructor;
import lotto.NumbersGenerator.dtos.DrawDateDto;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class NumbersGeneratorFacade {

    private final WinningNumberGenerator winningNumberGenerator;
    private final WinningNumberRepository winningNumberRepository;




    public WinningNumbersDto generateWinningNumbers(DrawDateDto drawDateDto) {


        if (winningNumberRepository.findByDate(drawDateDto.drawDate()).isPresent()) {
            WinningNumbers winningNumbers = winningNumberRepository.findByDate(drawDateDto.drawDate()).get();
            return new WinningNumbersDto(winningNumbers.getWinningNumbers());
        }
        List<Integer> winningNumbers = winningNumberGenerator.generateWinningNumberList();

        LocalDateTime drawDate = drawDateDto.drawDate();
        WinningNumbers saved = winningNumberRepository.save(WinningNumbers.builder()
                .date(drawDate)
                .winningNumbers(winningNumbers)
                .build());
        return new WinningNumbersDto(saved.getWinningNumbers());
    }


    public WinningNumbersDto retriveWinningNumbersforDate(DrawDateDto drawDateDto) {
        WinningNumbers winningNumbers = winningNumberRepository.findByDate(drawDateDto.drawDate()).orElseThrow(
                () -> new WinningNumbersNotFoundException("Winning numbers not found for date"));
        return new WinningNumbersDto(winningNumbers.getWinningNumbers());
    }

}

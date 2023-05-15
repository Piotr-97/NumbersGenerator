package lotto.NumbersGenerator.infrastructure;


import lombok.AllArgsConstructor;
import lotto.NumbersGenerator.dtos.DrawDateDto;
import lotto.NumbersGenerator.numbersgenerator.NumbersGeneratorFacade;
import lotto.NumbersGenerator.numbersgenerator.WinningNumbersDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {


     private final NumbersGeneratorFacade numbersGeneratorFacade;

    @GetMapping("/winningnumbers")
    public WinningNumbersDto getWinningNumbers(@RequestBody DrawDateDto drawDateDto){
        return numbersGeneratorFacade.generateWinningNumbers(drawDateDto);

    }
    @GetMapping("/retriveWinningNumbersforDate")
    public WinningNumbersDto retriveWinningNumbersforDate(@RequestBody DrawDateDto drawDateDto){
        return numbersGeneratorFacade.retriveWinningNumbersforDate(drawDateDto);
    }

}

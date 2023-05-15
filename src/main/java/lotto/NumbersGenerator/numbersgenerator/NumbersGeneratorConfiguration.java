package lotto.NumbersGenerator.numbersgenerator;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NumbersGeneratorConfiguration {


    @Bean
    public  NumbersGeneratorFacade numbersGeneratorFacade(WinningNumberRepository winningNumberRepository){
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();

        return new NumbersGeneratorFacade(winningNumberGenerator,winningNumberRepository);
    }

    public NumbersGeneratorFacade numbersGeneratorFacadeForTest(WinningNumberRepository winningNumberRepository){
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
        return  new NumbersGeneratorFacade(winningNumberGenerator,winningNumberRepository);
    }



}


package newmanuevers.config;

import newmanuevers.GuessCount;
import newmanuevers.MaxNumber;
import newmanuevers.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "newmanuevers")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == fields ==
    @Value("${game.maxNumber:20}")
    private int _maxNumber;

    @Value("${game.guessCount:5}")
    private int _guessCount;

    @Value("${game.minNumber:10}")
    private int _minNumber;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber(){
        return _maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return _guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return _minNumber;
    }

}

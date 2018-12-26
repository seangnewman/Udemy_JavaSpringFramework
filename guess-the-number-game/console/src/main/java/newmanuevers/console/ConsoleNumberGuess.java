package newmanuevers.console;

import newmanuevers.IGame;
import newmanuevers.IMessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
//public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {
public class ConsoleNumberGuess  {
    // == constants ==
    private static final Logger _log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // == fields ==
    @Autowired
    private IGame game;

    @Autowired
    private IMessageGenerator messageGenerator;




    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        _log.info("start() --> Container ready for use.");

        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();

            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again? (y/n)");
                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }

        }// end while
    }

}

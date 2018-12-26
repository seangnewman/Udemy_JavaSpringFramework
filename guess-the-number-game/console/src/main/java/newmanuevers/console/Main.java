package newmanuevers.console;

import newmanuevers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        log.info("Guess the Number Game!");

        // create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //get number generator bean from context (container)
        //INumberGenerator numberGenerator = context.getBean("numberGenerator", INumberGenerator.class);
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
        // Call method next to get a random number
        int number = numberGenerator.next();

        // log generated number
        log.info("number = {}", number);

        // get message generator  from context(container)
        IMessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage={}", messageGenerator.getMainMessage());
        log.info("getResultMessage={}", messageGenerator.getResultMessage());

        // call the reset method
        //game.reset();

        // close context
        context.close();

    }
}

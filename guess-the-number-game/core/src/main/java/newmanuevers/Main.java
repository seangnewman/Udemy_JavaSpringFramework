package newmanuevers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the Number Game!");

        // create context (container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        //get number generator bean from context (container)
        //INumberGenerator numberGenerator = context.getBean("numberGenerator", INumberGenerator.class);
        INumberGenerator numberGenerator = context.getBean(INumberGenerator.class);
        // Call method next to get a random number
        int number = numberGenerator.next();

        // log generated number
        log.info("number = {}", number);

        // get game bean from context(container)
        IGame game = context.getBean(IGame.class);

        // call the reset method
        //game.reset();

        // close context
        context.close();

    }
}

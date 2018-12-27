package newmanuevers;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;


public class NumberGenerator implements INumberGenerator {

    // == fields ==
    private final Random random = new Random();

    @Autowired
    @MaxNumber
    private int maxNumber;

    @Autowired
    @MinNumber
    private int minNumber;



    // == public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber);

    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}

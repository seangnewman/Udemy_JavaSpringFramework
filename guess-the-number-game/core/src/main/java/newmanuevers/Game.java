package newmanuevers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Game  implements IGame {

    // == constants ==
    private static final Logger _log = LoggerFactory.getLogger(Game.class);

    // == fields ==
    private final INumberGenerator _numberGenerator;

    private final int _guessCount;

    //@Autowired
    //@MinNumber
    //private final int _minNumber;


    private int _number;
    private int _guess;
    private int _smallest;

    private int _biggest;
    private int _remainingGuesses;
    private boolean _validNumberRange = true;

    // == constructor ==
    @Autowired
    public Game(INumberGenerator _numberGenerator, @GuessCount int _guessCount) {
        this._numberGenerator = _numberGenerator;
        this._guessCount = _guessCount;
    }

    // == init ==
    @PostConstruct
    @Override
    public void reset() {
        _smallest = _numberGenerator.getMinNumber();
        _guess = _numberGenerator.getMinNumber();
        _remainingGuesses = _guessCount;
        _biggest = _numberGenerator.getMaxNumber();
        _number = _numberGenerator.next();
        _log.debug("Reset:the number is {}", _number);
    }

    @PreDestroy
    public void preDestroy(){
    _log.info("in Game preDestroy()");
    }


    // == public methods ==
    /*
    public void setNumberGenerator(NumberGenerator numberGenerator){
        this._numberGenerator = numberGenerator;
    }
     */


    @Override
    public int getNumber() {
        return _number;
    }

    @Override
    public int getGuess() {
        return _guess;
    }

    @Override
    public void setGuess(int guess) {
        this._guess = guess;
    }

    @Override
    public int getSmallest() {
        return _smallest;
    }

    @Override
    public int getBiggest() {
        return _biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return _remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return _guessCount;
    }

    @Override
    public void check() {

        checkValidNumberRange();

        if(_validNumberRange){
            if(_guess > _number){
                _biggest = _guess - 1;
            }

            if(_guess < _number){
                _smallest = _guess + 1;
            }
        }

        _remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return _validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return _guess == _number;
    }

    @Override
    public boolean isGameLost() {
        return (!isGameWon() && _remainingGuesses <= 0);
    }

    // == private methods ==
    private void checkValidNumberRange(){
        _validNumberRange = ( _guess >= _smallest) && (_guess <= _biggest);
    }
}

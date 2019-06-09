package com.company.U1M4SummativeBasavarajRamya.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.company.U1M4SummativeBasavarajRamya.model.*;
import javax.annotation.PostConstruct;
import javax.validation.Valid;

/**
 * This is a web service, that displays quote-of-the-day,
 * word-of-the-day, and magic 8-ball answer
 */
@RestController
public class U1M4SummativeController {

    private Map<Integer, Quote> mapAuthorQuote = new HashMap<>();
    private Map<Integer, Definition> mapWordDefinition = new HashMap<>();
    private Map<Integer, Answer> mapQuestionAnswer = new HashMap<>();
    private Random randomNumGenerator = new Random();
    private Quote quote;
    private Definition definition;
    private int randomNumber;

    /**
     * Quotes are served up at random.
     * @return quote object
     */
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote() {
        randomNumber = randomNumGenerator.nextInt(10) + 1;
        for (Map.Entry<Integer, Quote> entry : mapAuthorQuote.entrySet()) {
            if (entry.getKey() == randomNumber) {
                quote = new Quote(entry.getValue().getAuthor(),entry.getValue().getQuote());
            }
        }
        return quote;
    }

    /**
     * Words and definitions are served up at random.
     * @return definition object
     */
    @RequestMapping(value = "/definition", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getDefinition() {
        randomNumber = randomNumGenerator.nextInt(10) + 1;
        for (Map.Entry<Integer, Definition> entry : mapWordDefinition.entrySet()) {
            if (entry.getKey() == randomNumber) {
                definition= new Definition(entry.getValue().getWord(),entry.getValue().getDefinition());
            }
        }
        return definition;
    }

    /**
     * 8-ball answers must be served up at random.
     * @param answer object
     * @return answer object
     */
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer getAnswer(@RequestBody @Valid Answer answer) {
        randomNumber = randomNumGenerator.nextInt(6) + 1;
        for (Map.Entry<Integer, Answer> entry : mapQuestionAnswer.entrySet()) {
            if (entry.getKey() == randomNumber) {
                entry.getValue().setQuestion(answer.getQuestion());
                answer =new Answer(entry.getValue().getQuestion(),entry.getValue().getAnswer()) ;
            }
        }
        return answer;
    }

    /**
     * Initialize Data in-memory using Map
     */
    @PostConstruct
    public void initializeQuote() {
        mapAuthorQuote.put(1, new Quote("Arthur Ashe", "Start where you are. Use what you have. Do what you can."));
        mapAuthorQuote.put(2, new Quote("BK Shivani", "Happiness is not a dependency it is a decision"));
        mapAuthorQuote.put(3, new Quote("Buddha", "The mind is everything. What you think you become."));
        mapAuthorQuote.put(4, new Quote("Norman Vincent Peale", "Change your thoughts and you change your world."));
        mapAuthorQuote.put(5, new Quote("Confucius", "The will to win, the desire to succeed, the urge to reach your full potential... these are the keys that will unlock the door to personal excellence."));
        mapAuthorQuote.put(6, new Quote("Rabindranath Tagore", "You can't cross the sea merely by standing and staring at the water."));
        mapAuthorQuote.put(7, new Quote("Sadhguru", "Learning to listen is the essence of intelligent living"));
        mapAuthorQuote.put(8, new Quote("Albert Einstein", "Learn from yesterday, live for today, hope for tomorrow."));
        mapAuthorQuote.put(9, new Quote("Nelson Mandela", "It always seems impossible until it is done."));
        mapAuthorQuote.put(10, new Quote("Walt Disney", "All your dreams can come true if you have the courage to pursue them"));

        mapWordDefinition.put(1, new Definition("Excellent", "Extremely good"));
        mapWordDefinition.put(2, new Definition("Courage", "The ability to do something that frightens one"));
        mapWordDefinition.put(3, new Definition("Excitement", "A feeling of great enthusiasm and eagerness."));
        mapWordDefinition.put(4, new Definition("Determination", "Firmness of purpose"));
        mapWordDefinition.put(5, new Definition("Elegant", "Pleasingly graceful and stylish in appearance or manner."));
        mapWordDefinition.put(6, new Definition("Honest", "free of deceit and untruthfulness or sincere"));
        mapWordDefinition.put(7, new Definition("punctual", "happening or doing something at the agreed or proper time; on time."));
        mapWordDefinition.put(8, new Definition("compatible", "able to exist or occur together without conflict."));
        mapWordDefinition.put(9, new Definition("encourage", "give support, confidence, or hope to (someone)"));
        mapWordDefinition.put(10, new Definition("confidence", "the state of feeling certain about the truth of something."));

        mapQuestionAnswer.put(1, new Answer("Yes - definitely."));
        mapQuestionAnswer.put(2, new Answer("Signs point to yes."));
        mapQuestionAnswer.put(3, new Answer("Ask again later."));
        mapQuestionAnswer.put(4, new Answer("Concentrate and ask again."));
        mapQuestionAnswer.put(5, new Answer("Most likely."));
        mapQuestionAnswer.put(6, new Answer("Outlook good."));
    }
}

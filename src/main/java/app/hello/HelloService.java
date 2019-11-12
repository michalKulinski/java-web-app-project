package app.hello;

import app.lang.Lang;
import app.lang.LangRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class HelloService {

    static final String FALLBACK_NAME = "world";
    static final Lang FALLBACK_LANG = new Lang(1,"Hello","en");
    private static final Logger logger = LogManager.getLogger(HelloService.class);


    private LangRepository repository;


    HelloService(){
        this(new LangRepository());
    }

    HelloService(LangRepository repository){
        this.repository = repository;
    }



    String prepareGreeting(String name, String lang){
        Integer langId = null;
        try {
            langId = Optional.ofNullable(lang).map(Integer::valueOf).orElse(FALLBACK_LANG.getId());
        } catch (NumberFormatException e) {
            logger.warn("Non-numeric language id used: " + lang);
            langId = FALLBACK_LANG.getId();
        }
        String welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
        String nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameToWelcome + "!";
    }

}


package com.love.backend.Services;

import com.love.backend.Entities.Log;
import com.love.backend.Repositories.LogRepository;

/**
 * Implementation of {@link ILoveService}
 */
public class LoveService implements ILoveService {

    private final LogRepository logRepository;

    public LoveService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public String showLove(String message) {
        if (message == null || message.length() == 0) {
            return "Hello my love <3";
        }
        String result = String.format("%s my love <3", message);

        // add log to database
        Log log = new Log();
        log.setMessage(message);
        logRepository.save(log);

        return result;
    }

}

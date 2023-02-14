package com.archi.trademe;

import com.archi.trademe.logger.FileLogger;
import com.archi.trademe.logger.InAppLogger;
import com.archi.trademe.application.signals.NotificationSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(ApplicationConfiguration.class)
@SpringBootApplication
public class TradeMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeMeApplication.class, args);
        NotificationSender.getInstance().register(InAppLogger.getInstance());
        NotificationSender.getInstance().register(FileLogger.getInstance());
    }

}

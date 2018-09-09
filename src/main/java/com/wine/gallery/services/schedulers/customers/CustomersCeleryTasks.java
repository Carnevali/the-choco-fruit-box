package com.wine.gallery.services.schedulers.customers;

import com.wine.gallery.services.interfaces.customers.CustomersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by felipe on 9/9/18.
 */
@Component
public class CustomersCeleryTasks {
    private static final Logger logger = LoggerFactory.getLogger(CustomersCeleryTasks.class);
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Autowired
    CustomersService customersService;

    @Scheduled(fixedRate = ((1000 * 60) * 60) * 24)
    public void generateRecommendationsAndSendEmail() {
        customersService.sendEmail(customersService.generateRecommendations());
        logger.info("generateRecommendationsAndSendEmail :: Execution Time - {}", dateFormatter.format(LocalDateTime.now()));
    }
}

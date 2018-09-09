package com.wine.gallery.services.schedulers.invoices;

import com.wine.gallery.services.interfaces.invoices.InvoicesService;
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
public class InvoicesCeleryTasks {
    private static final Logger logger = LoggerFactory.getLogger(InvoicesCeleryTasks.class);
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Autowired
    InvoicesService invoicesService;

    @Scheduled(fixedRate = ((1000 * 60) * 60) * 24)
    public void generateInvoicesAndCloseOrders() {
        invoicesService.closeOrders(invoicesService.generateInvoices());
        logger.info("generateRecommendationsAndSendEmail :: Execution Time - {}", dateFormatter.format(LocalDateTime.now()));
    }
}

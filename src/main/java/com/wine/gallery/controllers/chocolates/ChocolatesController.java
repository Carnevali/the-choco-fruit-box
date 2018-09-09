package com.wine.gallery.controllers.chocolates;

import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.customers.Recommendations;
import com.wine.gallery.services.interfaces.customers.RecommendationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@RestController
@RequestMapping("/api/chocolates")
@Transactional
public class ChocolatesController {
    public static final Logger logger = LoggerFactory.getLogger(ChocolatesController.class);

    @Autowired
    RecommendationsService recommendationsService;

    @RequestMapping(value = "/recommendations/{customer}", method = RequestMethod.GET)
    public ResponseEntity<List<Recommendations>> getRecommendations(@PathVariable("customer") Customers customers) {
        logger.info("Fetching recommendations with customers {}", customers);

        List<Recommendations> recommendationsList = recommendationsService.findByCustomers(customers);

        if (recommendationsList == null || recommendationsList.size() == 0) {
            logger.error("Recommendations with customers {} not found.", customers);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Recommendations>>(recommendationsList, HttpStatus.OK);
    }
}
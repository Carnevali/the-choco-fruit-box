package com.wine.gallery.services.implementations.customers;

import com.wine.gallery.enums.subscriptions.SubscriptionsType;
import com.wine.gallery.models.customers.Customers;
import com.wine.gallery.models.customers.Recommendations;
import com.wine.gallery.repositories.customers.CustomersRepository;
import com.wine.gallery.repositories.customers.RecommendationsRepository;
import com.wine.gallery.services.interfaces.customers.CustomersService;
import com.wine.gallery.utils.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Service("customersService")
@Transactional
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private RecommendationsRepository recommendationsRepository;

    public Customers findById(Long id) {
        return customersRepository.findById(id).orElse(null);
    }

    public Customers findByName(String name) {
        return customersRepository.findByName(name);
    }

    public Customers save(Customers customers) {
        return customersRepository.save(customers);
    }

    public Customers update(Customers customers){
        return save(customers);
    }

    public List<Recommendations> generateRecommendations() {
        List<Recommendations> recommendationsList = new ArrayList<>();
        List<Customers> customersList = customersRepository.findByType(SubscriptionsType.SUBSCRIBER);

        //API Dummy
        RestTemplate restTemplate = new RestTemplate();

        for (Customers customer: customersList) {
            String url = "https://www.api.com/api/getRecomedation/" + customer.getKitCustomers().getChocolates().getType().getValue();

            Recommendations response = restTemplate.getForObject(url, Recommendations.class);
            recommendationsRepository.save(response);

            recommendationsList.add(response);
        }

        return recommendationsList;
    }

    public void sendEmail(List<Recommendations> recommendationsList) {
        for (Recommendations recommendations: recommendationsList) {
            SendEmail.send(recommendations);
        }
    }

    public Boolean isCustomerExist(Customers customers) {
        return customersRepository.findByEmail(customers.getEmail()) != null;
    }
}

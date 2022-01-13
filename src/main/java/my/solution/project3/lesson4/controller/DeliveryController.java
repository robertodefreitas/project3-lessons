package my.solution.project3.lesson4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.solution.project3.lesson4.model.Delivery;
import my.solution.project3.lesson4.model.RecipientAndPrice;
import my.solution.project3.lesson4.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryController.class);

    @Autowired
    DeliveryService deliveryService;

    /**
     * You should now be able to use Postman to send
     * a POST request to http://localhost:8311/delivery
     * with the following JSON as a request body to create
     * a Delivery object in your database:
     */
    /*
    {
     "name": "Terry",
     "address": "1234 Sesame Blvd",
     "deliveryTime": "2020-03-07T18:07",
     "plants": [
         {"name": "Petunia",
         "price": "3.50"},
         {"name": "Tulip",
         "price": "2.50"}
     ]
    }
     */
    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        String methodeName = new Object(){}.getClass().getEnclosingMethod().getName();
        logger.info("[{}] POST /delivery [Adress: {}] [Delivery Time: {}]", methodeName, delivery.getAddress(), delivery.getDeliveryTime());

        return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId) {
        String methodeName = new Object(){}.getClass().getEnclosingMethod().getName();
        logger.info("[{}] GET /delivery/bill/{} [Delivery ID: {}]", methodeName, deliveryId, deliveryId);

        return deliveryService.getBill(deliveryId);
    }

}

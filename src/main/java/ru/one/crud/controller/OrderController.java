package ru.one.crud.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.one.crud.entity.IncomingOrder;
import ru.one.crud.repository.BookRepository;
import ru.one.crud.repository.IncomongOrderRepository;
import ru.one.crud.service.HttpClient;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    private HttpClient httpClient;

    @Autowired
    IncomongOrderRepository orderRepository;

    @PostMapping(value = {"convert"},
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
         public ResponseEntity<?> convertOrder(@RequestPart(value = "file", required = true) MultipartFile file) {
            try {
                IncomingOrder order = new IncomingOrder();
                order.setReciviedOrder(file.getBytes());
                JsonNode jsonString = httpClient.requestOrder(file).getBody();
                order.setConvertedOrder(jsonString.toString());
                orderRepository.save(order);
                return ResponseEntity.accepted().body(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }


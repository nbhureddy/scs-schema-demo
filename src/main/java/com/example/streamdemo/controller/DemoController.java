package com.example.streamdemo.controller;

import com.example.streamdemo.domain.EventPojo;
import com.example.streamdemo.domain.InsurancePojo;
import com.example.streamdemo.processor.DemoKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

  @Autowired
  DemoKafkaProducer producer;

  @PostMapping("insurance")
  public void sendInsurance(@RequestBody InsurancePojo insurance) {
    logger.debug("Received insurance from browser: " + insurance);
    producer.sendInsuranceMessage(insurance);
//    return Respo
  }

  @PostMapping("event")
  public void sendEvent(@RequestBody EventPojo eventPojo) {
    logger.debug("Received event from browser: " + eventPojo);
    producer.sendEventMessage(eventPojo);
//    return Respo
  }
}

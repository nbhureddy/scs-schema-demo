package com.example.streamdemo.processor;

import com.example.streamdemo.domain.EventAvro;
import com.example.streamdemo.domain.EventPojo;
import com.example.streamdemo.domain.InsuranceAvro;
import com.example.streamdemo.domain.InsurancePojo;
import com.example.streamdemo.util.AvroCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(DemoKafkaProducer.Source.class)
public class DemoKafkaProducer {

  @Autowired
  @Qualifier("streamDemo")
  MessageChannel output;

  @SendTo(Source.OUTPUT)
  public void sendInsuranceMessage(InsurancePojo insurancePojo) {
    InsuranceAvro insuranceAvro =  InsuranceAvro.newBuilder()
        .setPlan(insurancePojo.getPlan())
        .setCompany(insurancePojo.getCompany())
        .setValidFrom(insurancePojo.getValidFrom())
        .setAge(insurancePojo.getAge())
        .build();
    Message<?> message = MessageBuilder.withPayload(insuranceAvro).build();
    output.send(message);
  }


  @SendTo(Source.OUTPUT)
  public void sendEventMessage(EventPojo eventPojo) {
    EventAvro insuranceAvro =  EventAvro.newBuilder()
        .setName(eventPojo.getName())
        .setDescription(eventPojo.getDescription())
        .setVersion(eventPojo.getVersion())
        .build();
    Message<?> message = MessageBuilder.withPayload(insuranceAvro).build();
    output.send(message);
  }


//  public void sendInsuranceMessage(InsurancePojo insurancePojo) {
//    InsuranceAvro insurance = InsuranceAvro.newBuilder()
//        .setPlan(insurancePojo.getPlan())
//        .setCompany(insurancePojo.getCompany())
//        .setValidFrom(insurancePojo.getValidFrom())
//        .setAge(insurancePojo.getAge())
//        .build();
//
//    Message<?> message = MessageBuilder.withPayload(insurance).build();
////
////    byte[] payload = null;
////
////    try {
////      payload = new AvroCodec().encode(insurance);
////    } catch (Exception ex) {
////      ex.printStackTrace();
////    }
////
////    Message<?> message = MessageBuilder.withPayload(payload).build();
//
//    output.send(message);
//  }


//  @SendTo(Source.OUTPUT)
//  public InsuranceAvro sendInsuranceMessage(InsurancePojo insurancePojo) {
//    InsuranceAvro insurance = InsuranceAvro.newBuilder()
//        .setPlan(insurancePojo.getPlan())
//        .setCompany(insurancePojo.getCompany())
//        .setValidFrom(insurancePojo.getValidFrom())
//        .setAge(insurancePojo.getAge())
//        .build();
//
//      return insurance;
////    byte[] payload = null;
////
////    try {
////      payload = new AvroCodec().encode(insurance);
////    } catch (Exception ex) {
////      ex.printStackTrace();
////    }
////
////    Message<?> message = MessageBuilder.withPayload(payload).build();
////    output.output().send(message);
//  }

  public interface Source {

    String OUTPUT = "streamDemo";

    @Output(OUTPUT)
    MessageChannel output();
  }
}

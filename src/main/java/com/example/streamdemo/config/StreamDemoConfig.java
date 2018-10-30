package com.example.streamdemo.config;

//import com.example.streamdemo.util.ConfluentSchemaRegistryClientMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamMessageConverter;
import org.springframework.cloud.stream.schema.client.ConfluentSchemaRegistryClient;
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StreamDemoConfig {
  @Value("${spring.cloud.stream.schemaRegistryClient.endpoint}")
  String endpoint;

  @Bean public SchemaRegistryClient schemaRegistryClient(){
    ConfluentSchemaRegistryClient client = new ConfluentSchemaRegistryClient();
    client.setEndpoint(endpoint);
    return client;
  }

//  @Bean
//  @StreamMessageConverter
//  public MessageConverter userMessageConverter() throws IOException {
//      return new AvroSchemaMessageConverter(MimeType.valueOf("avro/bytes"));
//  }


//  @Bean
//  @StreamMessageConverter
//  public ConfluentSchemaRegistryClientMessageConverter messageConverter() {
//    ConfluentSchemaRegistryClientMessageConverter converter = new ConfluentSchemaRegistryClientMessageConverter(
//        (ConfluentSchemaRegistryClient) schemaRegistryClient());
//    converter.setDynamicSchemaGenerationEnabled(true);
//    return converter;
//  }
}

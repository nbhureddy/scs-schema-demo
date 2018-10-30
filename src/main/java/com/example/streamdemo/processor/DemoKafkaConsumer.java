package com.example.streamdemo.processor;

import com.example.streamdemo.domain.Insurance;
import com.example.streamdemo.processor.DemoKafkaConsumer.Source;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.avro.Schema;
import org.apache.avro.Schema.Parser;
import org.apache.avro.generic.GenericArray;
import org.apache.avro.generic.GenericContainer;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericData.Record;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.schema.ParsedSchema;
import org.springframework.cloud.stream.schema.SchemaReference;
import org.springframework.cloud.stream.schema.avro.AvroSchemaMessageConverter;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.ContentTypeResolver;
import org.springframework.messaging.converter.DefaultContentTypeResolver;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.util.MimeType;
import org.springframework.web.client.RestTemplate;

@EnableBinding(Source.class)
@EnableSchemaRegistryClient
public class DemoKafkaConsumer {
  private static final Logger logger = LoggerFactory.getLogger(DemoKafkaConsumer.class);

  private CacheManager cacheManager = new ConcurrentMapCacheManager();

//  @StreamListener(Source.INPUT)
//  public void receiveMessage(GenericMessage insurance) {
//    logger.info("Received Kafka message " + insurance);
//  }


  @Autowired
  SchemaRegistryClient schemaRegistryClient;

  @StreamListener(Source.INPUT)
  public void messageConsumer(GenericMessage genericMessage) {
    MimeType contentType = (MimeType) genericMessage.getHeaders().get("contentType");
    Schema schema = getSchema(contentType.toString());

    final DatumReader<GenericRecord> reader = new GenericDatumReader(schema);
    final Decoder decoder = DecoderFactory.get().binaryDecoder((byte[]) genericMessage.getPayload(), null);
    try {
      GenericRecord genericRecord = reader.read( (GenericRecord) null, decoder);
      logger.info(genericRecord.toString());
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  private Schema getSchema(String contentType) {
    SchemaReference schemaReference = extractSchemaReference(contentType);
    if (schemaReference != null) {
      ParsedSchema parsedSchema = (ParsedSchema)this.cacheManager.getCache("org.springframework.cloud.stream.schema.referenceCache").get(schemaReference, ParsedSchema.class);
      if (parsedSchema == null) {
        String schemaContent = this.schemaRegistryClient.fetch(schemaReference);
        if (schemaContent != null) {
          Schema schema = (new Parser()).parse(schemaContent);
          parsedSchema = new ParsedSchema(schema);
          this.cacheManager.getCache("org.springframework.cloud.stream.schema.referenceCache").putIfAbsent(schemaReference, parsedSchema);
        }
      }

      if (parsedSchema != null) {
        return parsedSchema.getSchema();
      }
    }
    return null;
  }

  private SchemaReference extractSchemaReference(String contentType) {
    Pattern versionSchema = Pattern.compile("application/vnd\\.([\\p{Alnum}\\$\\.]+)\\.v(\\p{Digit}+)\\+" + "avro");

    SchemaReference schemaReference = null;
    Matcher schemaMatcher = versionSchema.matcher(contentType);
    if (schemaMatcher.find()) {
      String subject = schemaMatcher.group(1);
      Integer version = Integer.parseInt(schemaMatcher.group(2));
      schemaReference = new SchemaReference(subject, version, "avro");
    }
    return schemaReference;
  }



//  private ContentTypeResolver contentTypeResolver = new DefaultContentTypeResolver();
////  @StreamListener(Source.INPUT)
//  public void receiveMessage(GenericMessage genericMessage) {
//    String schemaName = (String) messageHeaders.get("contentType");
//    logger.info("Got payload with schema: ", schemaName);
//
////
////    try {
////      MimeType mimeType = contentTypeResolver.resolve(genericMessage.getHeaders());
////
////      Schema writerSchema = this.resolveWriterSchemaForDeserialization(mimeType);
////      Schema readerSchema = this.resolveReaderSchemaForDeserialization(targetClass);
////      DatumReader<Object> reader = this.getDatumReader(targetClass, readerSchema, writerSchema);
////
////      Decoder decoder = DecoderFactory.get().binaryDecoder(payload, (BinaryDecoder)null);
////      result = reader.read((Object)null, decoder);
////      return result;
////    } catch (IOException var11) {
////      throw new MessageConversionException(message, "Failed to read payload", var11);
////    }
//
//    try {
//      DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>(schema);
//      BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(payload, null);
//      GenericRecord result = reader.read(null, decoder);
//
//      logger.info("Result is " + result);
//
////
////      DatumReader<GenericRecord> reader = new GenericDatumReader<>(null, schema);
////      DataFileReader<GenericRecord> dataFileReader =
////          new DataFileReader<GenericRecord>(new File(INPUT_AVRO_FILE), reader);
////
////      GenericRecord result = null;
////
////      while (dataFileReader.hasNext()) {
////        System.out.println("Received: " + jsonCar);
////      }
//    } catch (Exception e) {
//      System.err.println("Exception thrown in prepareSchema " + e);
//    }
//  }

  public interface Source {
    String INPUT = "streamDemoConsumer";

    @Input(Source.INPUT)
    MessageChannel input();
  }
}

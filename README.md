# scs-schema-demo
Demo project where a single Kafka topic is able to read messages serialized with different Avro schemas.

Spring Cloud Stream based consumer and producer.





Running the application: 

Testing the application:

Post these requests:

Request:
    curl -X POST \
      http://localhost:8090/insurance \
      -H 'content-type: application/json' \
      -d '{
          "plan":"complete_2018",
          "company":"Aetna",
          "validFrom":"2018",
          "age":150
       }'
Response:  c.e.s.processor.DemoKafkaConsumer        : {"plan": "complete_2018", "company": "Aetna", "validFrom": "2018", "age": 150}



Request: 
    curl -X POST \
      http://localhost:8090/event \
      -H 'content-type: application/json' \
      -d '{
        "name":"event1",
        "description":"First event ",
        "version":150
       }'
Response:   c.e.s.processor.DemoKafkaConsumer        : {"plan": "complete_2018", "company": "Aetna", "validFrom": "2018", "age": 150}

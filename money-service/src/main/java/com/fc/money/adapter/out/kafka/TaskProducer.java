package com.fc.money.adapter.out.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.common.RechargingMoneyTask;
import com.fc.money.application.port.out.SendRechargingMoneyTaskPort;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class TaskProducer implements SendRechargingMoneyTaskPort {

    private final ObjectMapper objectMapper;

    private final KafkaProducer<String, String> producer;

    private final String topic;

    public TaskProducer(
            @Value("${kafka.clusters.bootstrapservers}") String bootstrapServers,
            @Value("${task.topic}") String topic,
            ObjectMapper objectMapper
    ) {
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        this.producer = new KafkaProducer<>(props);
        this.topic = topic;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendRechargingMoneyTaskPort(RechargingMoneyTask task) {
        this.sendMessage(task.getTaskID(), task);
    }


    private void sendMessage(String key, RechargingMoneyTask value) {

        String jsonStringToProduce;
        // jsonString
        try {
            jsonStringToProduce = objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, jsonStringToProduce);
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                // System.out.println("Message sent successfully. Offset: " + metadata.offset());
            } else {
                exception.printStackTrace();
                // System.err.println("Failed to send message: " + exception.getMessage());
            }
        });
    }

}

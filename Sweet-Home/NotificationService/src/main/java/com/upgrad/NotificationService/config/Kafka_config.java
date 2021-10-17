package com.upgrad.NotificationService.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

public class Kafka_config {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","ec2-54-90-80-84.compute-1.amazonaws.com:9092");
        properties.put("group.id","com.upgrad");
        properties.put("enable.auto.commit","true");
        properties.put("auto.commit.interval.ms",1000);
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList("bookingNotification"));
        Set<String> SubscribedTopics = consumer.subscription();

        for(String topic : SubscribedTopics){
            System.out.println(topic);
        }
        try {
            while (true){
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String , String> record : records){
                    System.out.println(record.value());
                }

            }
        }finally {
            consumer.close();
        }

    }
}

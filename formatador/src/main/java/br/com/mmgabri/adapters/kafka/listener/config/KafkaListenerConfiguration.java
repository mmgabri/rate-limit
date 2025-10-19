package br.com.mmgabri.adapters.kafka.listener.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaListenerConfiguration {

    private ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory(Map<String, Object> properties, String bootstrapServers) {
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        DefaultKafkaConsumerFactory<String, Object> consumerFactoryEdited = new DefaultKafkaConsumerFactory(properties);

        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryEdited);
       // factory.setAutoStartup(false);
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(ConsumerFactory<String, String> consumerFactory) {
        final Map<String, Object> configurations = consumerFactory.getConfigurationProperties();
        final Map<String, Object> newConfigurations = new HashMap<>(configurations);

        ConcurrentKafkaListenerContainerFactory<String, String> factory = listenerContainerFactory(newConfigurations, "localhost:9092");
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.valueOf("MANUAL"));
        factory.setConcurrency(3);
        return factory;
    }
}

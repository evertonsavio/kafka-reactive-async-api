package dev.evertonsavio.app.config.amqp;

import dev.evertonsavio.app.config.constants.KafkaConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String kafkaAddress;

    @Bean
    public NewTopic topic() {
        return new NewTopic(KafkaConstants.TOPIC_REGISTER, 3, (short) 1);
    }
}

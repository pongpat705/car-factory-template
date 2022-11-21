package th.prior.training.car.showroom.component.kafka.config;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {

    @Value("${app.kafka.bootstrap-servers}")
    private String bootstrapServers;

    //security
    @Value("${app.kafka.truststore.location}")
    private String trustStoreLocation;

    @Value("${app.kafka.truststore.password}")
    private String trustStorePassword;

    @Value("${app.kafka.security.username}")
    private String securityUsername;

    @Value("${app.kafka.security.password}")
    private String securityPassword;

    @Bean
    public Map<String, Object> settingProducerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        //security
        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
        props.put(SaslConfigs.SASL_MECHANISM, "SCRAM-SHA-512");
        props.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"" + securityUsername + "\" password=\""+ securityPassword +"\";");
        props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, trustStoreLocation);
        props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, trustStorePassword);

        return props;
    }

    @Bean
    public ProducerFactory<String, String> generateProducerFactory() {
        return new DefaultKafkaProducerFactory<>(settingProducerConfigs());
    }

    @Bean(name = "showroomKafkaTemplate")
    public KafkaTemplate<String, String> showroomKafkaTemplate() {
        return new KafkaTemplate<>(generateProducerFactory());
    }

}

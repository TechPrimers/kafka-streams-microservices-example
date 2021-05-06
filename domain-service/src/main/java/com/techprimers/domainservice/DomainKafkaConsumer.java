package com.techprimers.domainservice;

import com.techprimers.domaincrawler.Domain;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class DomainKafkaConsumer {

  @Bean
  public Consumer<KStream<String, Domain>> domainService() {
    return kstream -> kstream.foreach((key, domain) -> {
      System.out.println(String.format("Domain consumed[%s] Status[%s]", domain.getDomain(), domain.isDead()));
    });
  }
}

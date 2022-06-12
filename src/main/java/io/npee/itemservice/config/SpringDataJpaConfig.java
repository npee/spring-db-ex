package io.npee.itemservice.config;

import io.npee.itemservice.repository.ItemRepository;
import io.npee.itemservice.repository.jpa.JpaItemRepositoryV1;
import io.npee.itemservice.repository.jpa.JpaItemRepositoryV2;
import io.npee.itemservice.repository.jpa.SpringDataJpaItemRepository;
import io.npee.itemservice.service.ItemService;
import io.npee.itemservice.service.ItemServiceV1;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringDataJpaConfig {

    private final SpringDataJpaItemRepository repository;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV2(repository);
    }

}

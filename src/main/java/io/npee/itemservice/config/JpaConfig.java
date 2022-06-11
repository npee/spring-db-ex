package io.npee.itemservice.config;

import io.npee.itemservice.repository.ItemRepository;
import io.npee.itemservice.repository.jpa.JpaItemRepository;
import io.npee.itemservice.service.ItemService;
import io.npee.itemservice.service.ItemServiceV1;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JpaConfig {

    private final EntityManager em;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepository(em);
    }

}

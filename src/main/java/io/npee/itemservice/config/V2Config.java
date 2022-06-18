package io.npee.itemservice.config;

import io.npee.itemservice.repository.ItemRepository;
import io.npee.itemservice.repository.jpa.JpaItemRepositoryV3;
import io.npee.itemservice.repository.v2.ItemQueryRepositoryV2;
import io.npee.itemservice.repository.v2.ItemRepositoryV2;
import io.npee.itemservice.service.ItemServiceV2;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class V2Config {

    private final EntityManager em;
    private final ItemRepositoryV2 itemRepositoryV2;

    @Bean
    public ItemServiceV2 itemService() {
        return new ItemServiceV2(itemRepositoryV2, itemQueryRepositoryV2());
    }

    @Bean
    public ItemQueryRepositoryV2 itemQueryRepositoryV2() {
        return new ItemQueryRepositoryV2(em);
    }

    // 테스트에서 사용
    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV3(em);
    }
}

package io.npee.itemservice;

import io.npee.itemservice.config.JdbcTemplateV1Config;
import io.npee.itemservice.config.JdbcTemplateV2Config;
import io.npee.itemservice.config.JdbcTemplateV3Config;
import io.npee.itemservice.config.JpaConfig;
import io.npee.itemservice.config.MyBatisConfig;
import io.npee.itemservice.config.QuerydslConfig;
import io.npee.itemservice.config.SpringDataJpaConfig;
import io.npee.itemservice.config.V2Config;
import io.npee.itemservice.repository.ItemRepository;
import io.npee.itemservice.config.MemoryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;


//@Import(MemoryConfig.class)
//@Import(JdbcTemplateV1Config.class)
//@Import(JdbcTemplateV2Config.class)
//@Import(JdbcTemplateV3Config.class)
//@Import(MyBatisConfig.class)
//@Import(JpaConfig.class)
//@Import(SpringDataJpaConfig.class)
//@Import(QuerydslConfig.class)
@Import(V2Config.class)
@SpringBootApplication(scanBasePackages = "io.npee.itemservice.web")
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

}

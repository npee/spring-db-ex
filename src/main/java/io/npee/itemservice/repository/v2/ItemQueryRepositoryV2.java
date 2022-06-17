package io.npee.itemservice.repository.v2;

import static io.npee.itemservice.domain.QItem.item;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.npee.itemservice.domain.Item;
import io.npee.itemservice.repository.ItemSearchCond;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class ItemQueryRepositoryV2 {

    private final JPAQueryFactory factory;

    public ItemQueryRepositoryV2(EntityManager em) {
        this.factory = new JPAQueryFactory(em);
    }

    public List<Item> findAll(ItemSearchCond cond) {
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();
        return factory
            .select(item)
            .from(item)
            .where(likeItemName(itemName), maxPrice(maxPrice))
            .fetch();
    }

    private BooleanExpression likeItemName(String itemName) {
        if (StringUtils.hasText(itemName)) {
            return item.itemName.contains(itemName);
        }
        return null;
    }

    private BooleanExpression maxPrice(Integer maxPrice) {
        if (maxPrice != null) {
            return item.price.loe(maxPrice);
        }
        return null;
    }
}

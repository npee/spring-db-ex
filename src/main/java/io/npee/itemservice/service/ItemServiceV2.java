package io.npee.itemservice.service;

import io.npee.itemservice.domain.Item;
import io.npee.itemservice.repository.ItemSearchCond;
import io.npee.itemservice.repository.ItemUpdateDto;
import io.npee.itemservice.repository.v2.ItemQueryRepositoryV2;
import io.npee.itemservice.repository.v2.ItemRepositoryV2;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceV2 implements ItemService {

    private final ItemRepositoryV2 itemRepository;
    private final ItemQueryRepositoryV2 itemQueryRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item findItem = itemRepository.findById(itemId).orElseThrow();
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> findItems(ItemSearchCond cond) {
        return itemQueryRepository.findAll(cond);
    }
}

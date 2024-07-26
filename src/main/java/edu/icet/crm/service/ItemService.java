package edu.icet.crm.service;

import edu.icet.crm.model.Item;
import edu.icet.crm.model.ItemCreate;

public interface ItemService {
    Item persist(ItemCreate dto);
    Item update(Item dto);
    void delete(Long id);
    Item searchById(Long id);
}

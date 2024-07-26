package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.HardwareItemEntity;
import edu.icet.crm.exception.InvalidParameterException;
import edu.icet.crm.exception.RecordNotFoundException;
import edu.icet.crm.model.Item;
import edu.icet.crm.model.ItemCreate;
import edu.icet.crm.repository.HardwareItemRepository;
import edu.icet.crm.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final HardwareItemRepository itemRepository;
    private final ObjectMapper mapper;
    @Override
    public Item persist(ItemCreate dto) {
        if (! StringUtils.hasText(dto.getName()))
            throw new InvalidParameterException("Invalid Name");

        if (dto.getFinePerDay() < 0 || dto.getFinePerDay().isNaN())
            throw new InvalidParameterException("Invalid Fine per Day");

        if (dto.getRentalPerDay() < 0 || dto.getRentalPerDay().isNaN())
            throw new InvalidParameterException("Invalid Rental per Day");

        HardwareItemEntity saved = itemRepository.save(mapper.convertValue(
                dto,
                HardwareItemEntity.class)
        );

        return mapper.convertValue(saved, Item.class);

    }

    @Override
    public Item update(Item dto) {
        if (dto.getItemId() < 0)
            throw new InvalidParameterException("Invalid Item Id");

        if (! StringUtils.hasText(dto.getName()))
            throw new InvalidParameterException("Invalid Name");

        if (dto.getFinePerDay() < 0 || dto.getFinePerDay().isNaN())
            throw new InvalidParameterException("Invalid Fine per Day");

        if (dto.getRentalPerDay() < 0 || dto.getRentalPerDay().isNaN())
            throw new InvalidParameterException("Invalid Rental per Day");

        HardwareItemEntity saved = itemRepository.save(mapper.convertValue(
                dto,
                HardwareItemEntity.class)
        );

        return mapper.convertValue(saved, Item.class);
    }

    @Override
    public void delete(Long id) {
        if (id < 0)
            throw new InvalidParameterException("Invalid Item Id");

        Optional<HardwareItemEntity> byId = itemRepository.findById(id);

        if (byId.isEmpty()){
            throw new RecordNotFoundException("Item not available");
        }

        itemRepository.delete(byId.get());

    }

    @Override
    public Item searchById(Long id) {
        Optional<HardwareItemEntity> byId = itemRepository.findById(id);

        if (byId.isEmpty())
            throw new RecordNotFoundException("Item not available");

        return mapper.convertValue(
                byId.get(),
                Item.class
        );

    }

    @Override
    public List<String> getAllNames() {
        List<String> allItemNames = itemRepository.findAllNames();

        if (allItemNames.isEmpty())
            throw new RecordNotFoundException("No Item Records");

        return allItemNames;
    }
}

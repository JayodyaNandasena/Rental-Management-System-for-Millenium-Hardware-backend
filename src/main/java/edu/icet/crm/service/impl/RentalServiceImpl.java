package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.entity.RentalDetailEntity;
import edu.icet.crm.entity.RentalEntity;
import edu.icet.crm.exception.RecordNotFoundException;
import edu.icet.crm.model.CartItem;
import edu.icet.crm.model.Rental;
import edu.icet.crm.model.RentalCreate;
import edu.icet.crm.repository.CustomerRepository;
import edu.icet.crm.repository.RentalDetailRepository;
import edu.icet.crm.repository.RentalRepository;
import edu.icet.crm.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final RentalRepository rentalRepository;
    private final RentalDetailRepository rentalDetailRepository;
    private final CustomerRepository customerRepository;
    private final ObjectMapper mapper;
    @Override
    public Rental persist(RentalCreate dto) {
        Optional<CustomerEntity> customer = customerRepository.findByContactNumber(dto.getCustomerMobile());

        if (customer.isEmpty())
            throw new RecordNotFoundException("Customer Not Found");

        RentalEntity rentalEntity = new RentalEntity();

        rentalEntity.setCustomer(customer.get());
        rentalEntity.setRentalDate(dto.getRentalDate());
        rentalEntity.setDueDate(dto.getDueDate());
        rentalEntity.setTotalCost(BigDecimal.valueOf(dto.getTotalCost()));

        RentalEntity saved = rentalRepository.save(rentalEntity);

        saveRentalDetails(saved.getRentalId(), dto.getItems());

        return mapper.convertValue(saved, Rental.class);
    }

    private void saveRentalDetails(Long rentalId, List<CartItem> items){
        RentalDetailEntity entity = new RentalDetailEntity();

        int i =0;
        System.out.println(items.size());

        for (CartItem item:items) {
            entity.setRentalId(rentalId);
            entity.setItemId(item.getItemId());
            entity.setQty(item.getQuantity());
            entity.setTotalItemCost(BigDecimal.valueOf(item.getTotalItemCost()));

            rentalDetailRepository.save(entity);
            System.out.println(i++);
        }
    }
}

package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.entity.HardwareItemEntity;
import edu.icet.crm.exception.InvalidParameterException;
import edu.icet.crm.exception.RecordNotFoundException;
import edu.icet.crm.model.Customer;
import edu.icet.crm.model.CustomerCreate;
import edu.icet.crm.model.Item;
import edu.icet.crm.model.ItemCreate;
import edu.icet.crm.repository.CustomerRepository;
import edu.icet.crm.repository.HardwareItemRepository;
import edu.icet.crm.service.CustomerService;
import edu.icet.crm.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ObjectMapper mapper;

    @Override
    public Customer persist(CustomerCreate dto) {
        if (! StringUtils.hasText(dto.getName()))
            throw new InvalidParameterException("Invalid Name");

        if (! StringUtils.hasText(dto.getCity()))
            throw new InvalidParameterException("Invalid City");

        if (! StringUtils.hasText(dto.getContactNumber()))
            throw new InvalidParameterException("Invalid contact number");

        if (customerRepository.findByContactNumber(dto.getContactNumber()).isPresent())
            throw new InvalidParameterException("Contact number already exists");

        CustomerEntity saved = customerRepository.save(mapper.convertValue(
                dto,
                CustomerEntity.class)
        );

        return mapper.convertValue(saved, Customer.class);
    }

    @Override
    public Customer update(Customer dto) {
        if (dto.getCustomerId() < 0)
            throw new InvalidParameterException("Invalid Customer Id");

        if (! StringUtils.hasText(dto.getName()))
            throw new InvalidParameterException("Invalid Name");

        if (! StringUtils.hasText(dto.getCity()))
            throw new InvalidParameterException("Invalid City");

        if (! StringUtils.hasText(dto.getContactNumber()))
            throw new InvalidParameterException("Invalid contact number");

        Optional<CustomerEntity> byId = customerRepository.findById(dto.getCustomerId());

        if (byId.isEmpty())
            throw new RecordNotFoundException("Customer Not Found");

        if (!Objects.equals(byId.get().getContactNumber(), dto.getContactNumber()) &&
                customerRepository.findByContactNumber(dto.getContactNumber()).isPresent())
                throw new InvalidParameterException("Contact number already exists");


        CustomerEntity saved = customerRepository.save(mapper.convertValue(
                dto,
                CustomerEntity.class)
        );

        return mapper.convertValue(saved, Customer.class);
    }

    @Override
    public void delete(Long id) {
        if (id < 0)
            throw new InvalidParameterException("Invalid Customer Id");

        Optional<CustomerEntity> byId = customerRepository.findById(id);

        if (byId.isEmpty()){
            throw new RecordNotFoundException("Customer not available");
        }

        customerRepository.delete(byId.get());

    }

    @Override
    public Customer searchById(Long id) {
        Optional<CustomerEntity> byId = customerRepository.findById(id);

        if (byId.isEmpty())
            throw new RecordNotFoundException("Customer not available");

        return mapper.convertValue(
                byId.get(),
                Customer.class
        );

    }

    @Override
    public Customer searchByMobile(String mobile) {
        Optional<CustomerEntity> byId = customerRepository.findByContactNumber(mobile);

        if (byId.isEmpty())
            throw new RecordNotFoundException("Customer not available");

        return mapper.convertValue(
                byId.get(),
                Customer.class
        );
    }

    @Override
    public List<String> getAllMobiles() {
        List<String> allContactNumbers = customerRepository.findAllContactNumbers();

        if (allContactNumbers.isEmpty())
            throw new RecordNotFoundException("No Customer Records");

        return allContactNumbers;
    }

    private Boolean checkMobile(String mobile){
        return customerRepository.findByContactNumber(mobile).isPresent();
    }
}

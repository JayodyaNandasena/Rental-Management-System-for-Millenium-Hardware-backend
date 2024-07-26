package edu.icet.crm.service;

import edu.icet.crm.model.Customer;
import edu.icet.crm.model.CustomerCreate;
import edu.icet.crm.model.Item;
import edu.icet.crm.model.ItemCreate;

import java.util.List;

public interface CustomerService {
    Customer persist(CustomerCreate dto);
    Customer update(Customer dto);
    void delete(Long id);
    Customer searchById(Long id);
    Customer searchByMobile(String mobile);
    List<String> getAllMobiles();
}

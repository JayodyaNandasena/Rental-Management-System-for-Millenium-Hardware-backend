package edu.icet.crm.service;

import edu.icet.crm.model.Rental;
import edu.icet.crm.model.RentalCreate;

public interface RentalService {
    Rental persist(RentalCreate dto);
}

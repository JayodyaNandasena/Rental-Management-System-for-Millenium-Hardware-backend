package edu.icet.crm.controller;

import edu.icet.crm.model.Rental;
import edu.icet.crm.model.RentalCreate;
import edu.icet.crm.model.SuccessResponse;
import edu.icet.crm.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rental")
@RequiredArgsConstructor
@CrossOrigin
public class RentalController {
    private final RentalService rentalService;

    @PostMapping
    public SuccessResponse persist(@RequestBody RentalCreate dto){
        Rental persisted = rentalService.persist(dto);

        return SuccessResponse.builder()
                .status("Success")
                .result(persisted)
                .build();

    }
}

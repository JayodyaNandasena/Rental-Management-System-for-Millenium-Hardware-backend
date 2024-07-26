package edu.icet.crm.controller;

import edu.icet.crm.model.Item;
import edu.icet.crm.model.ItemCreate;
import edu.icet.crm.model.SuccessResponse;
import edu.icet.crm.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@CrossOrigin
public class ItemController {
    private final ItemService itemService;
    @GetMapping("/by-id")
    public SuccessResponse byId(@RequestParam(name = "id") Long id){
        Item item = itemService.searchById(id);

        return SuccessResponse.builder()
                .status("Success")
                .result(item)
                .build();

    }

    @GetMapping("/all-names")
    public SuccessResponse getAllMobiles(){
        List<String> items = itemService.getAllNames();

        return SuccessResponse.builder()
                .status("Success")
                .result(items)
                .build();
    }

    @PostMapping
    public SuccessResponse persist(@RequestBody ItemCreate item){
        Item savedItem = itemService.persist(item);

        return SuccessResponse.builder()
                .status("Success")
                .result(savedItem)
                .build();
    }

    @PutMapping
    public SuccessResponse update(@RequestBody Item item){
        Item savedItem = itemService.update(item);

        return SuccessResponse.builder()
                .status("Success")
                .result(savedItem)
                .build();
    }

    @DeleteMapping
    public SuccessResponse delete(@RequestParam(name = "id") Long id){
        itemService.delete(id);

        return SuccessResponse.builder()
                .status("Success")
                .result("Deleted")
                .build();
    }
}

package com.example.demo.Controller;

import com.example.demo.Dto.ApiResponse;
import com.example.demo.Model.Items;
import com.example.demo.Service.ItemService;
import com.example.demo.Service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v2")
@RestController
public class ItemsCotroller {

    private final ItemService itemService;

    @GetMapping("/get")
    public ResponseEntity getItems() {
        List<Items> items = itemService.getItems();
        return ResponseEntity.status(200).body(items);
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@RequestBody @Valid Items items) {

        itemService.addItems(items);
        return ResponseEntity.status(200).body(new ApiResponse("Item added!"));
    }

    @PutMapping("/update/{code}")
    public ResponseEntity updateItems(@PathVariable Integer code, @RequestBody @Valid Items items) {

        itemService.updateItems(code, items);
        return ResponseEntity.status(200).body(new ApiResponse("Item updated!"));
    }

    @DeleteMapping("/delete/{code}")
    public String deleteBlog(@PathVariable Integer code) {
        itemService.deletItems(code);
        return "Item deleted";
    }

    @GetMapping("/itembysupplierid/{ID}")
    public ResponseEntity getItemsBySupplierId(@PathVariable Integer ID) {
    Items items = itemService.getItemsBySupplierId(ID);
       return ResponseEntity.status(200).body(items);

    }

    @GetMapping("/bycode/{code}")
    public ResponseEntity<Items> getItemsByCode(@PathVariable Integer code){
        Items items=itemService.getItemBycode(code);
        return ResponseEntity.status(200).body(items);
    }


    @GetMapping("/byname/{name}")
    public ResponseEntity getItemsByName(@PathVariable String name){
        Items items=itemService.getItemByName(name);
        return ResponseEntity.status(200).body(items);
    }

    @GetMapping("/byquantity/{quantity}")
    public ResponseEntity getItemsByQuantity(@PathVariable String quantity){
        Items items=itemService.getItemByName(quantity);
        return ResponseEntity.status(200).body(items);
    }

    @GetMapping("/byprice/{price}")
    public ResponseEntity getItemsByPrice(@PathVariable Integer price){
        Items items=itemService.getItemsByPrice(price);
        return ResponseEntity.status(200).body(items);
    }

}

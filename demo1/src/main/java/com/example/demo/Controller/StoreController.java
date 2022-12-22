package com.example.demo.Controller;

import com.example.demo.Dto.ApiResponse;
import com.example.demo.Model.Stores;
import com.example.demo.Model.Supplier;
import com.example.demo.Service.StoreService;
import com.example.demo.Service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v3")
@RestController
public class StoreController {
    private final StoreService storeService;


    @GetMapping("/get")
    public ResponseEntity getStores() {
        List<Stores> stores = storeService.getStores();
        return ResponseEntity.status(200).body(stores);
    }

    @PostMapping("/add")
    public ResponseEntity addStores(@RequestBody @Valid Stores stores) {

        storeService.addStore(stores);
        return ResponseEntity.status(200).body(new ApiResponse("Store added!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStore(@PathVariable Integer ID, @RequestBody @Valid Stores stores) {

        storeService.updatestore(ID, stores);
        return ResponseEntity.status(200).body(new ApiResponse("Store updated!"));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStore(@PathVariable Integer ID) {
        storeService.deletStore(ID);
        return "Store deleted";
    }

    @GetMapping("/storebyitemcode/{code}")
    public ResponseEntity getSupplierByItemCode(@PathVariable Integer code){
        Stores stores=storeService.getStoreBySupplierId(code);
        return ResponseEntity.status(200).body(stores);

    }
}

package com.example.demo.Controller;

import com.example.demo.Dto.ApiResponse;
import com.example.demo.Model.Supplier;
import com.example.demo.Service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class SupplierController {

    private final SupplierService supplierService;


    @GetMapping("/get")
    public ResponseEntity getSupplier() {
        List<Supplier> supplier = supplierService.getSupplier();
        return ResponseEntity.status(200).body(supplier);
    }

    @PostMapping("/add")
    public ResponseEntity addSupplier(@RequestBody @Valid Supplier supplier) {

        supplierService.addSupplier(supplier);
        return ResponseEntity.status(200).body(new ApiResponse("Supplier added!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateSupplier(@PathVariable Integer ID, @RequestBody @Valid Supplier supplier) {

        supplierService.updateSupplier(ID, supplier);
        return ResponseEntity.status(200).body(new ApiResponse("Supplier updated!"));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSupplier(@PathVariable Integer ID) {
           supplierService.deletSupplier(ID);
           return "Supplier deleted";
    }

    @GetMapping("/bySupplierID/{ID}")
    public ResponseEntity getSupplierById(@PathVariable Integer ID){
           Supplier supplier=supplierService.getSupplierById(ID);
           return ResponseEntity.status(200).body(supplier);
    }

    @GetMapping("/bysuppliername/{name}")
    public ResponseEntity getSupplierByName(@PathVariable String name){
           Supplier supplier=supplierService.getSupplierByName(name);
           return ResponseEntity.status(200).body(supplier);
    }

    @GetMapping("/bysupplierregion/{region}")
    public ResponseEntity getSupplierByRegion(@PathVariable String region){
           Supplier supplier=supplierService.getSupplierbyRegion(region);
           return ResponseEntity.status(200).body(supplier);
    }

    @GetMapping("/supplierbyitemcode/{code}")
    public ResponseEntity getSupplierByItemCode(@PathVariable Integer code){
        Supplier supplier=supplierService.getSupplierByItemCode(code);
           return ResponseEntity.status(200).body(supplier);

    }

}

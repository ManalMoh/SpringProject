package com.example.demo.Service;

import com.example.demo.Exption.ApiExption;
import com.example.demo.Model.Supplier;
import com.example.demo.Repostery.SupplierRepostery;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepostery supplierRepostery;
    public List<Supplier> getSupplier(){
        return supplierRepostery.findAll();
    }

    public void addSupplier(Supplier suppliers){
        supplierRepostery.save(suppliers);
    }

    public void deletSupplier(Integer ID){
        Supplier suppliers =supplierRepostery.findSuppliersByID(ID);
        if(suppliers==null){
            throw new ApiExption("Item deleted");
        }
        supplierRepostery.delete(suppliers);

    }

    public void updateSupplier(Integer ID,Supplier suppliers){
        Supplier oldSupplier=supplierRepostery.findSuppliersByID(ID);
        if (oldSupplier==null){
            throw new ApiExption("Wrong code");
        }
        oldSupplier.setID(suppliers.getID());
        oldSupplier.setName(suppliers.getName());
        oldSupplier.setRegion(suppliers.getRegion());


        supplierRepostery.save(suppliers);
    }

    public Supplier getSupplierById(Integer ID){
           Supplier supplier=supplierRepostery.findSuppliersByID(ID);
           if (supplier==null){
               throw new ApiExption("No supplier found with this ID!");
           }
           return supplier;
    }

    public Supplier getSupplierByName(String name){
           Supplier supplier=supplierRepostery.findSuppliersByName(name);
           if (supplier==null){
               throw new ApiExption("No supplier found with this name!");
           }
           return supplier;
    }

    public Supplier getSupplierbyRegion(String region){
           Supplier supplier=supplierRepostery.findSuppliersByRegion(region);
           if (supplierRepostery.findSuppliersByRegion(region)==null){
               throw new ApiExption("No supplier on this region!");
           }
           return supplier;
    }
    public Supplier getSupplierByItemCode(Integer code){
           Supplier supplier=supplierRepostery.findSuppliersByItemCode(code);
           if(supplierRepostery.findSuppliersByItemCode(code)==null){
               throw new ApiExption("No suppliers for this item");
          }
               return supplier;

    }


}

package com.example.demo.Repostery;

import com.example.demo.Model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepostery extends JpaRepository<Supplier,Integer> {
       Supplier findSuppliersByID(Integer ID);
       Supplier findSuppliersByName(String name);
       Supplier findSuppliersByRegion(String region);
       Supplier findSuppliersByItemCode(Integer code);
}

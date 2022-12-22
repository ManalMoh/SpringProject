package com.example.demo.Repostery;

import com.example.demo.Model.Items;
import com.example.demo.Model.Stores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoresRepostery extends JpaRepository<Stores,Integer> {
       Stores findStoresByCode(Integer Id);
       Stores findStoresByLocation(String location);
       Stores findStoresBySId(Integer sId);
}

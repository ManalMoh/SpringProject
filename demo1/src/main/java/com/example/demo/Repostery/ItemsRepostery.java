package com.example.demo.Repostery;

import com.example.demo.Model.Items;
import com.example.demo.Model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepostery extends JpaRepository<Items,Integer> {
       Items findItemsByCode(Integer code);
       Items findItemsBySIdIs(Integer SId);
       Items findItemsByName(String name);
       Items findItemsByQuantity(Integer quantity);
       Items findItemsByPrice(Integer price);

}

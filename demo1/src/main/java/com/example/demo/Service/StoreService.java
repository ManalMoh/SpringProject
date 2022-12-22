package com.example.demo.Service;

import com.example.demo.Exption.ApiExption;
import com.example.demo.Model.Items;
import com.example.demo.Model.Stores;
import com.example.demo.Repostery.StoresRepostery;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class StoreService {
    private final StoresRepostery storesRepostery;

    public List<Stores> getStores(){
        return storesRepostery.findAll();
    }

    public void addStore(Stores stores){
        storesRepostery.save(stores);
    }

    public void deletStore(Integer code){
        Stores stores =storesRepostery.findStoresByCode(code);
        if(stores==null){
            throw new ApiExption("Item deleted");
        }
        storesRepostery.delete(stores);

    }

    public void updatestore(Integer code,Stores stores){
           Stores oldStore=storesRepostery.findStoresByCode(code);
            if (oldStore==null){
               throw new ApiExption("Wrong code");
        }
            oldStore.setCode(stores.getCode());
            oldStore.setLocation(stores.getLocation());
            oldStore.setSId(stores.getSId());

            storesRepostery.save(stores);
    }

    public Stores getStoreByLocation(String location){
           Stores stores=storesRepostery.findStoresByLocation(location);
           if (stores==null){
               throw new ApiExption("No stores on this location");
           }
               return stores;
    }

    public Stores getStoreBySupplierId(Integer Id){
           Stores stores=storesRepostery.findStoresBySId(Id);
           if (stores==null){
               throw new ApiExption("No stores with this supplier ID!");
           }
               return stores;
    }


}

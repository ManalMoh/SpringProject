package com.example.demo.Service;

import com.example.demo.Exption.ApiExption;
import com.example.demo.Model.Items;
import com.example.demo.Repostery.ItemsRepostery;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
@RequiredArgsConstructor
public class ItemService {
    private final ItemsRepostery itemsRepostery;

    public List<Items> getItems(){
        return itemsRepostery.findAll();
    }

    public void addItems(Items items){
        itemsRepostery.save(items);
    }

    public void deletItems(Integer code){
        Items items =itemsRepostery.findItemsByCode(code);
        if(items==null){
            throw new ApiExption("Item deleted");
        }
        itemsRepostery.delete(items);

    }

    public void updateItems(Integer code,Items items){
        Items oldItem=itemsRepostery.findItemsByCode(code);
        if (oldItem==null){
            throw new ApiExption("Wrong code");
        }
        oldItem.setCode(items.getCode());
        oldItem.setName(items.getName());
        oldItem.setQuantity(items.getQuantity());
        oldItem.setPrice(items.getPrice());

        itemsRepostery.save(items);
    }

    public Items getItemsBySupplierId(Integer Id){
        Items items= itemsRepostery.findItemsBySIdIs(Id);
        if(items==null){
            throw new ApiExption("No items with this supplier!");
        }
        return items;
    }



    public Items getItemBycode(Integer code){
        Items items = itemsRepostery.findItemsByCode(code);
        if(items==null){
            throw new ApiExption("No item found!");
        }
        return items;
    }

    public Items getItemByName(String name){
        Items items = itemsRepostery.findItemsByName(name);
        if (items==null){
            throw new ApiExption("Wrong name!");
        }
        return items;
    }

    public Items getItemByQuantity(Integer quantity){
        Items items = itemsRepostery.findItemsByQuantity(quantity);
        if (items==null){
            throw new ApiExption("No items found with this quantity!");
        }
        return items;
    }

    public Items getItemsByPrice(Integer price){
        Items items = itemsRepostery.findItemsByPrice(price);
        if (items==null){
            throw new ApiExption("No items with this price!");
        }
        return items;
    }
}

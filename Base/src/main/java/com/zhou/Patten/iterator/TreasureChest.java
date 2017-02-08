package com.zhou.Patten.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */
public class TreasureChest {

    private List<Item> items;

    public TreasureChest(){
        items = new ArrayList<>();
        items.add(new Item(ItemType.POTTION,"Potion of courage"));
        items.add(new Item(ItemType.RING, "Ring of shadows"));
        items.add(new Item(ItemType.POTTION, "Potion of wisdom"));
        items.add(new Item(ItemType.POTTION, "Potion of blood"));
        items.add(new Item(ItemType.WEAPON, "Sword of silver +1"));
        items.add(new Item(ItemType.POTTION, "Potion of rust"));
        items.add(new Item(ItemType.POTTION, "Potion of healing"));
        items.add(new Item(ItemType.RING, "Ring of armor"));
        items.add(new Item(ItemType.WEAPON, "Steel halberd"));
        items.add(new Item(ItemType.WEAPON, "Dagger of poison"));
    }

    ItemIterator iterator(ItemType itemType){
        return new TreasureChestItemIterator(this,itemType);
    }

    public List<Item> getItems(){
        List<Item> list = new ArrayList<>();
        list.addAll(items);
        return list;
    }
}

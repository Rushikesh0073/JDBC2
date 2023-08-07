package com.DAO;

import com.Entity.Item;

public interface ItemDao {

    public void AddItem(Item I);
    public void DeleteItem(int itemid);
    public void UpdateItem(int itemid);
    public Item GetItemByID(int itemid);
    public void DisplayAllItem();

}

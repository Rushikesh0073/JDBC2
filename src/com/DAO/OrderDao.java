package com.DAO;

import com.Entity.Order;

public interface OrderDao {
    public void AddOrder(Order o);

    public void UpdateOder(int oid);

    public void DeleteOder(int oid);

    public Order GetOderByID(int oid);

    public void DisplayAllOrder();

}

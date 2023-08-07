package com.DAO;

import com.Entity.Customer;

public interface CustomerDao {
    public void addCust(Customer c);

    public void deleteCust(int cid);

    public void updateCust(int cid);

    public Customer GetCustByID(int cid);

    public void DisplayAllCust();


    void addCustomer(Customer c);
}

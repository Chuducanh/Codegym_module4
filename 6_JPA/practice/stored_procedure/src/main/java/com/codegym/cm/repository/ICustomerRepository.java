package com.codegym.cm.repository;

import com.codegym.cm.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}

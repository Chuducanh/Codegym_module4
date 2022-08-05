package com.codegym.cm.service;

import com.codegym.cm.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}

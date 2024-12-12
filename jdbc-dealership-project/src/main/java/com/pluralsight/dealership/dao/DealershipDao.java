package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.model.Dealership;
import com.pluralsight.dealership.model.Vehicle;

import java.util.List;

/*
    DealershipDao provides an interface that provides a contract
    for accessing dealership related methods.
 */
public interface DealershipDao {

    // returns single dealership by id
    Dealership findDealershipById(int id);
    // returns all dealerships
    List<Dealership> findAllDealerships();


}

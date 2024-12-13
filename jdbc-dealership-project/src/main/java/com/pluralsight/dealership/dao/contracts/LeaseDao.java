package com.pluralsight.dealership.dao.contracts;

import com.pluralsight.dealership.model.LeaseContract;
import com.pluralsight.dealership.model.SalesContract;

public interface LeaseDao {
    void saveLeaseContract(LeaseContract leaseContract);
}

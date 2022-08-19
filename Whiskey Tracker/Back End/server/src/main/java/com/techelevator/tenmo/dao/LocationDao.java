package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.LocationRecord;

public interface LocationDao {


    boolean create(LocationRecord locationRecord);

    LocationRecord retrieve(int locationID);

    boolean delete(int locationID);

}

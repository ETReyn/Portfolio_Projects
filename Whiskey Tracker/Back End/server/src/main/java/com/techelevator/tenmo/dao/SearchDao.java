package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.SearchRecord;

public interface SearchDao {

    boolean create(SearchRecord searchRecord);

    SearchRecord retrieveOne(String name);

    SearchRecord[] retrieveAll(String name);

    boolean update(SearchRecord searchRecord);

    boolean destroy(int searchID);

}

package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.ResultsRecord;

public interface ResultsDao {

    boolean create(ResultsRecord resultsRecord);

    ResultsRecord retrieve(int resultID);

    boolean update(ResultsRecord resultsRecord);

    boolean delete(int resultID);
}

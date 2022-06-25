package com.database.stuff.DAO;

import com.database.stuff.Model.HappinessData;

import java.util.List;

public interface HappinessDao {

    /**
     * Get a happiness report from the database that has the given id
     * return null if not found
     * @param happiness_id the id of the country's happiness rating
     * @return a filled out happiness data object
     */
    public HappinessData getCountryData(int happiness_id, String table);

    /**
     * Get a list of all reports for country happiness data
     *
     * @return all happiness reports as objects
     */
    public List<HappinessData> getAllReports(String table);

    /**
     * Creates a new record of country happiness data
     * @param data the record to be added
     * @return the record in the database
     */
    public HappinessData createHappinessData(HappinessData data, String table);

    /**
     * Deletes an record from the dataset
     *
     * @param happiness_id is the id of the record to be deleted
     */
    public void deleteData(int happiness_id, String table);

    /**
     * Updates a record from the database
     *
     * @param data the object to update
     */
    public void updateData(HappinessData data, String table);

}

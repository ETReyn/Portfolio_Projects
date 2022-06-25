package com.database.stuff.DAO;

import com.database.stuff.Model.HappinessPercentageData;

import java.util.List;

public interface HappinessPercentageDao {

    /**
     * Get a happiness report from the database that has the given id
     * return null if not found
     * @param happiness_id the id of the country's happiness rating
     * @return a filled out happiness data object
     */
    public HappinessPercentageData getCountryData(int happiness_id);

    /**
     * Get a list of all reports for country happiness data
     *
     * @return all happiness reports as objects
     */
    public List<HappinessPercentageData> getAllReports();

    /**
     * Creates a new record of country happiness data
     * @param data the record to be added
     * @return the record in the database
     */
    public HappinessPercentageData createHappinessData(HappinessPercentageData data);

    /**
     * Deletes an record from the dataset
     *
     * @param happiness_id is the id of the record to be deleted
     */
    public void deleteData(int happiness_id);

    /**
     * Updates a record from the database
     *
     * @param data the object to update
     */
    public void updateData(HappinessPercentageData data);
}

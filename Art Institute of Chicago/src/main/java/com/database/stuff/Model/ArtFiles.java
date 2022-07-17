package com.database.stuff.Model;

import java.util.List;

public class ArtFiles {

    private String id;
    private String title;
    private String mainReferenceNumber;
    private String departmentTitle;
    private String artistTitle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainReferenceNumber() {
        return mainReferenceNumber;
    }

    public void setMainReferenceNumber(String mainReferenceNumber) {
        this.mainReferenceNumber = mainReferenceNumber;
    }

    public String getDepartmentTitle() {
        return departmentTitle;
    }

    public void setDepartmentTitle(String departmentTitle) {
        this.departmentTitle = departmentTitle;
    }

    public String getArtistTitle() {
        return artistTitle;
    }

    public void setArtistTitle(String artistTitle) {
        this.artistTitle = artistTitle;
    }

    @Override
    public String toString() {
        return "ArtFiles{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", mainReferenceNumber='" + mainReferenceNumber + '\'' +
                ", departmentTitle=" + departmentTitle +
                ", artistTitle='" + artistTitle + '\'' +
                '}';
    }
}

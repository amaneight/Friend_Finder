/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient;

/**
 *
 * @author Dangerlal
 */
public class LocationCount {
    
    String locName;
    Long locVisitCount;

    public LocationCount() {
    }

    public LocationCount(String locName, Long locVisitCount) {
        this.locName = locName;
        this.locVisitCount = locVisitCount;
    }

    public LocationCount(String location, int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public Long getLocVisitCount() {
        return locVisitCount;
    }

    public void setLocVisitCount(Long locVisitCount) {
        this.locVisitCount = locVisitCount;
    }

    
}

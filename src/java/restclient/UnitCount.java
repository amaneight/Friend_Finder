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
public class UnitCount {

    String unitName;
    Long unitCount;

    public UnitCount() {
    }

    public UnitCount(String unitName, Long unitCount) {
        this.unitName = unitName;
        this.unitCount = unitCount;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Long getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Long unitCount) {
        this.unitCount = unitCount;
    }
    
    
}

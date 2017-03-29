/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dangerlal
 */
@Entity
@Table(name = "STU_LOCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StuLocation.findAll", query = "SELECT s FROM StuLocation s")
    , @NamedQuery(name = "StuLocation.findByLocId", query = "SELECT s FROM StuLocation s WHERE s.locId = :locId")
    , @NamedQuery(name = "StuLocation.findByLocLat", query = "SELECT s FROM StuLocation s WHERE s.locLat = :locLat")
    , @NamedQuery(name = "StuLocation.findByLocLon", query = "SELECT s FROM StuLocation s WHERE s.locLon = :locLon")
    , @NamedQuery(name = "StuLocation.findByLocDate", query = "SELECT s FROM StuLocation s WHERE s.locDate = :locDate")
    , @NamedQuery(name = "StuLocation.findByLocTime", query = "SELECT s FROM StuLocation s WHERE s.locTime = :locTime")
    , @NamedQuery(name = "StuLocation.findByLocName", query = "SELECT s FROM StuLocation s WHERE s.locName = :locName")
    , @NamedQuery(name = "StuLocation.findByLocNameANDFavSport", query = "SELECT DISTINCT(s.stuId) FROM StuLocation s JOIN FETCH s.stuId st WHERE st.stuFavSport = :stuFavSport AND s.locName = :locName")})
public class StuLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOC_ID")
    private Integer locId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOC_LAT")
    private double locLat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOC_LON")
    private double locLon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOC_DATE")
    @Temporal(TemporalType.DATE)
    private Date locDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "LOC_TIME")
    private String locTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "LOC_NAME")
    private String locName;
    @JoinColumn(name = "STU_ID", referencedColumnName = "STU_ID")
    @ManyToOne(optional = false)
    private StuProfile stuId;

    public StuLocation() {
    }

    public StuLocation(Integer locId) {
        this.locId = locId;
    }

    public StuLocation(Integer locId, double locLat, double locLon, Date locDate, String locTime, String locName) {
        this.locId = locId;
        this.locLat = locLat;
        this.locLon = locLon;
        this.locDate = locDate;
        this.locTime = locTime;
        this.locName = locName;
    }

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public double getLocLat() {
        return locLat;
    }

    public void setLocLat(double locLat) {
        this.locLat = locLat;
    }

    public double getLocLon() {
        return locLon;
    }

    public void setLocLon(double locLon) {
        this.locLon = locLon;
    }

    public Date getLocDate() {
        return locDate;
    }

    public void setLocDate(Date locDate) {
        this.locDate = locDate;
    }

    public String getLocTime() {
        return locTime;
    }

    public void setLocTime(String locTime) {
        this.locTime = locTime;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public StuProfile getStuId() {
        return stuId;
    }

    public void setStuId(StuProfile stuId) {
        this.stuId = stuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locId != null ? locId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StuLocation)) {
            return false;
        }
        StuLocation other = (StuLocation) object;
        if ((this.locId == null && other.locId != null) || (this.locId != null && !this.locId.equals(other.locId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restclient.StuLocation[ locId=" + locId + " ]";
    }
    
}

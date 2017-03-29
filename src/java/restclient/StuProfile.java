/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dangerlal
 */
@Entity
@Table(name = "STU_PROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StuProfile.findAll", query = "SELECT s FROM StuProfile s")
    , @NamedQuery(name = "StuProfile.findByStuId", query = "SELECT s FROM StuProfile s WHERE s.stuId = :stuId")
    , @NamedQuery(name = "StuProfile.findByStuFname", query = "SELECT s FROM StuProfile s WHERE s.stuFname = :stuFname")
    , @NamedQuery(name = "StuProfile.findByStuLname", query = "SELECT s FROM StuProfile s WHERE s.stuLname = :stuLname")
    , @NamedQuery(name = "StuProfile.findByStuDob", query = "SELECT s FROM StuProfile s WHERE s.stuDob = :stuDob")
    , @NamedQuery(name = "StuProfile.findByStuGender", query = "SELECT s FROM StuProfile s WHERE s.stuGender = :stuGender")
    , @NamedQuery(name = "StuProfile.findByStuCourse", query = "SELECT s FROM StuProfile s WHERE s.stuCourse = :stuCourse")
    , @NamedQuery(name = "StuProfile.findByStuAddress", query = "SELECT s FROM StuProfile s WHERE s.stuAddress = :stuAddress")
    , @NamedQuery(name = "StuProfile.findByStuSuburb", query = "SELECT s FROM StuProfile s WHERE s.stuSuburb = :stuSuburb")
    , @NamedQuery(name = "StuProfile.findByStuNationality", query = "SELECT s FROM StuProfile s WHERE s.stuNationality = :stuNationality")
    , @NamedQuery(name = "StuProfile.findByStuNativeLang", query = "SELECT s FROM StuProfile s WHERE s.stuNativeLang = :stuNativeLang")
    , @NamedQuery(name = "StuProfile.findByStuFavSport", query = "SELECT s FROM StuProfile s WHERE s.stuFavSport = :stuFavSport")
    , @NamedQuery(name = "StuProfile.findByStuFavMovie", query = "SELECT s FROM StuProfile s WHERE s.stuFavMovie = :stuFavMovie")
    , @NamedQuery(name = "StuProfile.findByStuFavUnit", query = "SELECT s FROM StuProfile s WHERE s.stuFavUnit = :stuFavUnit")
    , @NamedQuery(name = "StuProfile.findByStuCurrJob", query = "SELECT s FROM StuProfile s WHERE s.stuCurrJob = :stuCurrJob")
    , @NamedQuery(name = "StuProfile.findByStuUniEmail", query = "SELECT s FROM StuProfile s WHERE s.stuUniEmail = :stuUniEmail")
    , @NamedQuery(name = "StuProfile.findByStuUniPassword", query = "SELECT s FROM StuProfile s WHERE s.stuUniPassword = :stuUniPassword")
    , @NamedQuery(name = "StuProfile.findByStuSubDate", query = "SELECT s FROM StuProfile s WHERE s.stuSubDate = :stuSubDate")
    , @NamedQuery(name = "StuProfile.findByStuSubTime", query = "SELECT s FROM StuProfile s WHERE s.stuSubTime = :stuSubTime")})
public class StuProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "STU_ID")
    private String stuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "STU_FNAME")
    private String stuFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "STU_LNAME")
    private String stuLname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STU_DOB")
    @Temporal(TemporalType.DATE)
    private Date stuDob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "STU_GENDER")
    private String stuGender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "STU_COURSE")
    private String stuCourse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "STU_ADDRESS")
    private String stuAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "STU_SUBURB")
    private String stuSuburb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "STU_NATIONALITY")
    private String stuNationality;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "STU_NATIVE_LANG")
    private String stuNativeLang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "STU_FAV_SPORT")
    private String stuFavSport;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "STU_FAV_MOVIE")
    private String stuFavMovie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "STU_FAV_UNIT")
    private String stuFavUnit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "STU_CURR_JOB")
    private String stuCurrJob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "STU_UNI_EMAIL")
    private String stuUniEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "STU_UNI_PASSWORD")
    private String stuUniPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STU_SUB_DATE")
    @Temporal(TemporalType.DATE)
    private Date stuSubDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STU_SUB_TIME")
    @Temporal(TemporalType.TIME)
    private Date stuSubTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stuId")
    private Collection<StuLocation> stuLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "frFriendId")
    private Collection<StuFriendship> stuFriendshipCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "frStuId")
    private Collection<StuFriendship> stuFriendshipCollection1;

    public StuProfile() {
    }

    public StuProfile(String stuId) {
        this.stuId = stuId;
    }

    public StuProfile(String stuId, String stuFname, String stuLname, Date stuDob, String stuGender, String stuCourse, String stuAddress, String stuSuburb, String stuNationality, String stuNativeLang, String stuFavSport, String stuFavMovie, String stuFavUnit, String stuCurrJob, String stuUniEmail, String stuUniPassword, Date stuSubDate, Date stuSubTime) {
        this.stuId = stuId;
        this.stuFname = stuFname;
        this.stuLname = stuLname;
        this.stuDob = stuDob;
        this.stuGender = stuGender;
        this.stuCourse = stuCourse;
        this.stuAddress = stuAddress;
        this.stuSuburb = stuSuburb;
        this.stuNationality = stuNationality;
        this.stuNativeLang = stuNativeLang;
        this.stuFavSport = stuFavSport;
        this.stuFavMovie = stuFavMovie;
        this.stuFavUnit = stuFavUnit;
        this.stuCurrJob = stuCurrJob;
        this.stuUniEmail = stuUniEmail;
        this.stuUniPassword = stuUniPassword;
        this.stuSubDate = stuSubDate;
        this.stuSubTime = stuSubTime;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuFname() {
        return stuFname;
    }

    public void setStuFname(String stuFname) {
        this.stuFname = stuFname;
    }

    public String getStuLname() {
        return stuLname;
    }

    public void setStuLname(String stuLname) {
        this.stuLname = stuLname;
    }

    public Date getStuDob() {
        return stuDob;
    }

    public void setStuDob(Date stuDob) {
        this.stuDob = stuDob;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public String getStuCourse() {
        return stuCourse;
    }

    public void setStuCourse(String stuCourse) {
        this.stuCourse = stuCourse;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public String getStuSuburb() {
        return stuSuburb;
    }

    public void setStuSuburb(String stuSuburb) {
        this.stuSuburb = stuSuburb;
    }

    public String getStuNationality() {
        return stuNationality;
    }

    public void setStuNationality(String stuNationality) {
        this.stuNationality = stuNationality;
    }

    public String getStuNativeLang() {
        return stuNativeLang;
    }

    public void setStuNativeLang(String stuNativeLang) {
        this.stuNativeLang = stuNativeLang;
    }

    public String getStuFavSport() {
        return stuFavSport;
    }

    public void setStuFavSport(String stuFavSport) {
        this.stuFavSport = stuFavSport;
    }

    public String getStuFavMovie() {
        return stuFavMovie;
    }

    public void setStuFavMovie(String stuFavMovie) {
        this.stuFavMovie = stuFavMovie;
    }

    public String getStuFavUnit() {
        return stuFavUnit;
    }

    public void setStuFavUnit(String stuFavUnit) {
        this.stuFavUnit = stuFavUnit;
    }

    public String getStuCurrJob() {
        return stuCurrJob;
    }

    public void setStuCurrJob(String stuCurrJob) {
        this.stuCurrJob = stuCurrJob;
    }

    public String getStuUniEmail() {
        return stuUniEmail;
    }

    public void setStuUniEmail(String stuUniEmail) {
        this.stuUniEmail = stuUniEmail;
    }

    public String getStuUniPassword() {
        return stuUniPassword;
    }

    public void setStuUniPassword(String stuUniPassword) {
        this.stuUniPassword = stuUniPassword;
    }

    public Date getStuSubDate() {
        return stuSubDate;
    }

    public void setStuSubDate(Date stuSubDate) {
        this.stuSubDate = stuSubDate;
    }

    public Date getStuSubTime() {
        return stuSubTime;
    }

    public void setStuSubTime(Date stuSubTime) {
        this.stuSubTime = stuSubTime;
    }

    @XmlTransient
    public Collection<StuLocation> getStuLocationCollection() {
        return stuLocationCollection;
    }

    public void setStuLocationCollection(Collection<StuLocation> stuLocationCollection) {
        this.stuLocationCollection = stuLocationCollection;
    }

    @XmlTransient
    public Collection<StuFriendship> getStuFriendshipCollection() {
        return stuFriendshipCollection;
    }

    public void setStuFriendshipCollection(Collection<StuFriendship> stuFriendshipCollection) {
        this.stuFriendshipCollection = stuFriendshipCollection;
    }

    @XmlTransient
    public Collection<StuFriendship> getStuFriendshipCollection1() {
        return stuFriendshipCollection1;
    }

    public void setStuFriendshipCollection1(Collection<StuFriendship> stuFriendshipCollection1) {
        this.stuFriendshipCollection1 = stuFriendshipCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stuId != null ? stuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StuProfile)) {
            return false;
        }
        StuProfile other = (StuProfile) object;
        if ((this.stuId == null && other.stuId != null) || (this.stuId != null && !this.stuId.equals(other.stuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restclient.StuProfile[ stuId=" + stuId + " ]";
    }
    
}

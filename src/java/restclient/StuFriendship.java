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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dangerlal
 */
@Entity
@Table(name = "STU_FRIENDSHIP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StuFriendship.findAll", query = "SELECT s FROM StuFriendship s")
    , @NamedQuery(name = "StuFriendship.findByFrId", query = "SELECT s FROM StuFriendship s WHERE s.frId = :frId")
    , @NamedQuery(name = "StuFriendship.findByFrStartDate", query = "SELECT s FROM StuFriendship s WHERE s.frStartDate = :frStartDate")
    , @NamedQuery(name = "StuFriendship.findByFrEndDate", query = "SELECT s FROM StuFriendship s WHERE s.frEndDate = :frEndDate")})
public class StuFriendship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FR_ID")
    private Integer frId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FR_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date frStartDate;
    @Column(name = "FR_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date frEndDate;
    @JoinColumn(name = "FR_FRIEND_ID", referencedColumnName = "STU_ID")
    @ManyToOne(optional = false)
    private StuProfile frFriendId;
    @JoinColumn(name = "FR_STU_ID", referencedColumnName = "STU_ID")
    @ManyToOne(optional = false)
    private StuProfile frStuId;

    public StuFriendship() {
    }

    public StuFriendship(Integer frId) {
        this.frId = frId;
    }

    public StuFriendship(Integer frId, Date frStartDate) {
        this.frId = frId;
        this.frStartDate = frStartDate;
    }

    public Integer getFrId() {
        return frId;
    }

    public void setFrId(Integer frId) {
        this.frId = frId;
    }

    public Date getFrStartDate() {
        return frStartDate;
    }

    public void setFrStartDate(Date frStartDate) {
        this.frStartDate = frStartDate;
    }

    public Date getFrEndDate() {
        return frEndDate;
    }

    public void setFrEndDate(Date frEndDate) {
        this.frEndDate = frEndDate;
    }

    public StuProfile getFrFriendId() {
        return frFriendId;
    }

    public void setFrFriendId(StuProfile frFriendId) {
        this.frFriendId = frFriendId;
    }

    public StuProfile getFrStuId() {
        return frStuId;
    }

    public void setFrStuId(StuProfile frStuId) {
        this.frStuId = frStuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frId != null ? frId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StuFriendship)) {
            return false;
        }
        StuFriendship other = (StuFriendship) object;
        if ((this.frId == null && other.frId != null) || (this.frId != null && !this.frId.equals(other.frId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restclient.StuFriendship[ frId=" + frId + " ]";
    }
    
}

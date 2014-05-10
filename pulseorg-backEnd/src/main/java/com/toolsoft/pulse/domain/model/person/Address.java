// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model.person;

import com.toolsoft.common.backend.AssertionConcern;
import com.toolsoft.pulse.domain.model.Country;
import com.toolsoft.pulse.domain.model.State;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Defines an address object.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@Embeddable
public class Address extends AssertionConcern implements Serializable {

    @Column(name = "mailing")
    private boolean mailing;

    @Column(name = "addressLine1", length = 250)
    private String addressLine1;

    @Column(name = "addressLine2", length = 250)
    private String addressLine2;

    @Column(name = "addressLine3", length = 250)
    private String addressLine3;

    @Column(name = "localizedAddressLine1", length = 250)
    private String localizedAddressLine1;

    @Column(name = "localizedAddressLine2", length = 250)
    private String localizedAddressLine2;

    @Column(name = "city", length = 250)
    private String city;

    @Column(name = "region", length = 100)
    private String region;

    @JoinColumn(name = "idReferenceDetail", nullable = false)
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private State state;

    @JoinColumn(name = "idReference", nullable = false)
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Country country;

    public boolean isMailing() {
        return mailing;
    }

    public void setMailing(boolean mailing) {
        this.mailing = mailing;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getLocalizedAddressLine1() {
        return localizedAddressLine1;
    }

    public void setLocalizedAddressLine1(String localizedAddressLine1) {
        this.localizedAddressLine1 = localizedAddressLine1;
    }

    public String getLocalizedAddressLine2() {
        return localizedAddressLine2;
    }

    public void setLocalizedAddressLine2(String localizedAddressLine2) {
        this.localizedAddressLine2 = localizedAddressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

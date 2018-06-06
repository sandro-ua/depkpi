package com.globallogic;

public class Deputy {

    public String fullName;
    private String party;
    private String linkToProfile;
    private int pysmovaReestracia;
    private int illness;
    private int businessTrip;
    private int unknown;
    private int present;
    private int absent;


    public Deputy (String fullName, String party, String linkToProfile, int pysmovaReestracia, int illness, int businessTrip, int unknown, int present, int absent) {
        this.fullName = fullName;
        this.party = party;
        this.linkToProfile = linkToProfile;
        this.pysmovaReestracia = pysmovaReestracia;
        this.illness = illness;
        this.businessTrip = businessTrip;
        this.unknown = unknown;
        this.present = present;
        this.absent = absent;
    }

    public Deputy () {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getLinkToProfile() {
        return linkToProfile;
    }

    public void setLinkToProfile(String linkToProfile) {
        this.linkToProfile = linkToProfile;
    }

    public int getIllness() {
        return illness;
    }

    public void setIllness(int illness) {
        this.illness = illness;
    }

    public int getUsinessTrip() {
        return businessTrip;
    }

    public void setUsinessTrip(int usinessTrip) {
        this.businessTrip = usinessTrip;
    }

    public int getUnknown() {
        return unknown;
    }

    public void setUnknown(int unknown) {
        this.unknown = unknown;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

}

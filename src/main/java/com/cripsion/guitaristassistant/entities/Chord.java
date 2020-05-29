package com.cripsion.guitaristassistant.entities;

import static com.cripsion.guitaristassistant.Constants.UPPER_OR_LOWER_KEY_MAP;

public class Chord {
    private String tone;    //C
    private int upperOrLowerKey;    //0-origin, 1-#, 2-b.
    private String fullName; //#Cm
    private String chordType;    //m
    private String fullType;    //major

    public String getChordType() {
        return chordType;
    }

    public void setChordType(String chordType) {
        this.chordType = chordType;
        String fullName = UPPER_OR_LOWER_KEY_MAP.get(this.getUpperOrLowerKey()) + this.getTone() + this.getChordType();
        this.fullName = fullName;
    }

    public String getFullType() {
        return fullType;
    }

    public void setFullType(String fullType) {
        this.fullType = fullType;
    }

    public int getUpperOrLowerKey() {
        return upperOrLowerKey;
    }

    public void setUpperOrLowerKey(int upperOrLowerKey) {
        this.upperOrLowerKey = upperOrLowerKey;
        String fullName = UPPER_OR_LOWER_KEY_MAP.get(this.getUpperOrLowerKey()) + this.getTone() + this.getChordType();
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
        String fullName = UPPER_OR_LOWER_KEY_MAP.get(this.getUpperOrLowerKey()) + this.getTone() + this.getChordType();
        this.fullName = fullName;
    }
}

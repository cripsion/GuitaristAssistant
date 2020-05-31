package com.cripsion.guitaristassistant.entities;

import static com.cripsion.guitaristassistant.Constants.*;

public class Chord {
    private String tone;    //C
    private int flatOrSharp;    //0:origin, 1:#, -1:b.
    private String fullName; //#Cm
    private String chordType;    //m
    private String fullType;    //major

    public String getChordType() {
        return chordType;
    }

    public void setChordType(String chordType) {
        this.chordType = chordType;
    }

    public String getFullType() {
        return fullType;
    }

    public void setFullType(String fullType) {
        this.fullType = fullType;
    }

    public int getFlatOrSharp() {
        return flatOrSharp;
    }

    public void setFlatOrSharp(int flatOrSharp) {
        this.flatOrSharp = flatOrSharp;
    }

    public String getFullName() {
        String fullName = FLAT_OR_SHARP_MAP.get(this.getFlatOrSharp()) + this.getTone() + this.getChordType();
        this.setFullName(fullName);
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
    }
}

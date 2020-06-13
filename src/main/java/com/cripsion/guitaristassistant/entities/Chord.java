package com.cripsion.guitaristassistant.entities;

import java.util.ArrayList;
import java.util.List;

import static com.cripsion.guitaristassistant.Constants.*;

/**
 * Entity for describing a chord
 */
public class Chord {
    private String root;    //C
    private int flatOrSharp;    //0:origin, 1:#, -1:b.
    private String fullName; //#Cm
    private String chordType;    //m
    private String chordFullType;    //major
    private List<Pitch> pitchesList;    //For traid C:  pitches are C/E/G

    public String getChordType() {
        return chordType;
    }

    public void setChordType(String chordType) {
        this.chordType = chordType;
    }

    public String getChordFullType() {
        return chordFullType;
    }

    public void setChordFullType(String chordFullType) {
        this.chordFullType = chordFullType;
    }

    public int getFlatOrSharp() {
        return flatOrSharp;
    }

    public void setFlatOrSharp(int flatOrSharp) {
        this.flatOrSharp = flatOrSharp;
    }

    public String getFullName() {
        String fullName = FLAT_OR_SHARP_MAP.get(this.getFlatOrSharp()) + this.getRoot() + this.getChordType();
        this.setFullName(fullName);
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public List<Pitch> getPitchesList() {
        return pitchesList;
    }

    public void setPitchesList(List<Pitch> pitchesList) {
        this.pitchesList = pitchesList;
    }
}

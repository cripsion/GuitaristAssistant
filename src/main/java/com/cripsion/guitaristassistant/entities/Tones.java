package com.cripsion.guitaristassistant.entities;

public class Tones {
    private int sequence;
    private String name;

    public Tones(int seq, String name) {
       this.sequence = seq;
       this.name = name;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

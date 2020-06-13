package com.cripsion.guitaristassistant.entities;

/**
 *Entity for describing a pitch in a chord
 */
public class Pitch implements Cloneable {
    private int sequence;   //序号
    private String name;
    private int progression;    //级数

    public Pitch(){}

    public Pitch(int seq, String name) {
       this.sequence = seq;
       this.name = name;
    }

    public Pitch(int seq, String name, int progression) {
        this.sequence = seq;
        this.name = name;
        this.progression = progression;
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

    public int getProgression() {
        return progression;
    }

    public void setProgression(int sequence) {
        switch (sequence) {
            case 0:
                this.progression = 1;
                break;
            case 2:
                this.progression = 2;
                break;
            case 4:
                this.progression = 3;
                break;
            case 5:
                this.progression = 4;
                break;
            case 7:
                this.progression = 5;
                break;
            case 9:
                this.progression = 6;
                break;
            case 11:
                this.progression = 7;
                break;
        }

    }

    @Override
    public Pitch clone() {
        Pitch pitch = null;
        try {
            pitch = (Pitch) super.clone();
            //deep copy
            pitch = new Pitch(pitch.getSequence(), pitch.getName(), pitch.getProgression());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return pitch;
    }
}

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

    public void setProgression(int progression) {
        this.progression = progression;
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

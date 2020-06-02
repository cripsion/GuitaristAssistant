package com.cripsion.guitaristassistant;

import com.cripsion.guitaristassistant.entities.Tones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Constants {
    public static String MAJOR = "MAJOR";
    public static String MINOR = "MINOR";
    public static String DIMINISH = "DIMINISH";

    private static String MAJOR_SUFFIX = "";
    private static String MINOR_SUFFIX = "m";
    private static String DIMINISH_SUFFIX = "-";

    public static Tones tone_A = new Tones(0, "A");
    public static Tones tone_sA = new Tones(1, "#A");
    public static Tones tone_B = new Tones(2, "B");
    public static Tones tone_C = new Tones(3, "C");
    public static Tones tone_sC = new Tones(4, "#C");
    public static Tones tone_D = new Tones(5, "D");
    public static Tones tone_sD = new Tones(6, "#D");
    public static Tones tone_E = new Tones(7, "E");
    public static Tones tone_F = new Tones(8, "F");
    public static Tones tone_sF = new Tones(9, "#F");
    public static Tones tone_G = new Tones(10, "G");
    public static Tones tone_sG = new Tones(11, "#G");



    public static List<Tones> KEY_C_CHORD_SEQUENCE = new ArrayList<>() {
        {
            add(tone_A);
            add(tone_sA);
            add(tone_B);
            add(tone_C);
            add(tone_sC);
            add(tone_D);
            add(tone_sD);
            add(tone_E);
            add(tone_F);
            add(tone_sF);
            add(tone_G);
            add(tone_sG);
        }
    };

//    public static TreeMap<Integer, String> TONE_SEQUENCE = new TreeMap<>() {{
//        put(1, "C");
//        put(2, "#C");
//
//    }};
    public static Map<Integer, String> FLAT_OR_SHARP_MAP = Map.of(0, "", 1, "#", 2, "b");
    public static Map<Integer, String> CHORD_TYPE_MAP_FULL = Map.of(1, MAJOR, 2, MINOR, 3, MINOR, 4, MAJOR, 5, MAJOR, 6, MINOR, 7, DIMINISH);
    public static Map<Integer, String> CHORD_TYPE_MAP = Map.of(1, MAJOR_SUFFIX, 2, MINOR_SUFFIX, 3, MINOR_SUFFIX, 4, MAJOR_SUFFIX, 5, MAJOR_SUFFIX, 6, MINOR_SUFFIX, 7, DIMINISH_SUFFIX);


}

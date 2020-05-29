package com.cripsion.guitaristassistant;

import java.util.List;
import java.util.Map;

public class Constants {
    public static String MAJOR = "MAJOR";
    public static String MINOR = "MINOR";
    public static String DIMINISH = "DIMINISH";

    private static String MAJOR_SUFFIX = "";
    private static String MINOR_SUFFIX = "m";
    private static String DIMINISH_SUFFIX = "-";

    public static List<Character> KEY_C_CHORD_SEQUENCE = List.of('C', 'D', 'E', 'F', 'G', 'A', 'B');
    public static Map<Integer, String> UPPER_OR_LOWER_KEY_MAP = Map.of(0, "", 1, "#", 2, "b");
    public static Map<Integer, String> CHORD_TYPE_MAP_FULL = Map.of(1, MAJOR, 2, MINOR, 3, MINOR, 4, MAJOR, 5, MAJOR, 6, MINOR, 7, DIMINISH);
    public static Map<Integer, String> CHORD_TYPE_MAP = Map.of(1, MAJOR_SUFFIX, 2, MINOR_SUFFIX, 3, MINOR_SUFFIX, 4, MAJOR_SUFFIX, 5, MAJOR_SUFFIX, 6, MINOR_SUFFIX, 7, DIMINISH_SUFFIX);


}

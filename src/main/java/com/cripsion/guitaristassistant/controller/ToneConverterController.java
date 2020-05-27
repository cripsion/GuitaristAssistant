package com.cripsion.guitaristassistant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.cripsion.guitaristassistant.Constants.*;

@Controller
@RequestMapping("/toneConverterController")
public class ToneConverterController {
    private static List<Character> KEY_C_CHORD_SEQUENCE = List.of('C', 'D', 'E', 'F', 'G', 'A', 'B');
    private static Map<Integer, String> MAJOR_MINOR_MAP = Map.of(1, MAJOR, 2, MINOR, 3, MINOR, 4, MAJOR, 5, MAJOR, 6, MINOR, 7, DIMINISH);

    @PostMapping("/calcChords")
    @ResponseBody
    public List calcChords(@RequestParam(value = "key", required=false) String key,
                           @RequestParam(value = "risingOrFallingTone", required=false) String risingOrFallingTone,
                           @RequestParam(value = "chordProgression", required=false) String chordProgression) {
        int keyDifferenceValue = key.toCharArray()[0] - 'C';
        List thisKeyChordSequence = KEY_C_CHORD_SEQUENCE.stream().map(k -> k + keyDifferenceValue).collect(Collectors.toList());
        List<char[]> chordProgressionList = Arrays.asList(chordProgression.toCharArray());
        List chordsList = chordProgressionList.stream().map(k->k + MAJOR_MINOR_MAP.get(k)).collect(Collectors.toList());
        return chordsList;
    }

}

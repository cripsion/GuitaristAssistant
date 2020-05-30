package com.cripsion.guitaristassistant.controller;

import com.cripsion.guitaristassistant.entities.Chord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.cripsion.guitaristassistant.Constants.*;

@Controller
@RequestMapping("/toneConverterController")
public class ToneConverterController {


    @PostMapping("/calcChords")
    @ResponseBody
    public List calcChords(@RequestParam(value = "key", required = false) String key,
                           @RequestParam(value = "risingOrFallingTone", required = false) String risingOrFallingTone,
                           @RequestParam(value = "chordProgression", required = false) String chordProgression) {
        int keyDifferenceValue = key.toCharArray()[0] - 'C';
        List<Character> thisKeyChordSequence = KEY_C_CHORD_SEQUENCE.stream().map(k -> (char) (k + keyDifferenceValue)).collect(Collectors.toList());
        List<Integer> chordProgressionList = Arrays.asList(chordProgression.split("")).stream().map(k -> Integer.valueOf(k)).collect(Collectors.toList());
        List chordsList = new ArrayList();
        for (var chordNumber : chordProgressionList) {
            Chord thisChord = new Chord();
            //thisChord.setUpperOrLowerKey();
            thisChord.setChordType(CHORD_TYPE_MAP.get(chordNumber));
            thisChord.setTone((thisKeyChordSequence.get(chordNumber - 1)).toString());
            chordsList.add(thisChord.getFullName());
        }
        return chordsList;
    }

}

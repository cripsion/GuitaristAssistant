package com.cripsion.guitaristassistant.controller;

import com.cripsion.guitaristassistant.entities.Chord;
import com.cripsion.guitaristassistant.entities.Tones;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.cripsion.guitaristassistant.Constants.*;

@Controller
@RequestMapping("/toneConverterController")
public class ToneConverterController {


    @PostMapping("/calcChords")
    @ResponseBody
    public List calcChords(@RequestParam(value = "key", required = false) Integer key,
                           @RequestParam(value = "flatOrSharp", required = false) String flatOrSharp,
                           @RequestParam(value = "chordProgression", required = false) String chordProgression) {
        int keyDifferenceValue = key;
        List<Tones> thisKeyChordSequence = KEY_C_CHORD_SEQUENCE.stream().map(chordConverter(keyDifferenceValue)).collect(Collectors.toList());
        List<Integer> chordProgressionList = Arrays.asList(chordProgression.split("")).stream().map(k -> Integer.valueOf(k)).collect(Collectors.toList());
        List chordsList = new ArrayList();
        for (var chordNumber : chordProgressionList) {
            Chord thisChord = new Chord();
            //thisChord.setFlatOrSharp(Integer.valueOf(flatOrSharp));
            thisChord.setChordType(CHORD_TYPE_MAP.get(chordNumber));
            thisChord.setTone((thisKeyChordSequence.get(chordNumber - 1)).getName());
            chordsList.add(thisChord.getFullName());
        }
        return chordsList;
    }

    private Function<Tones, Tones> chordConverter(int keyDifferenceValue) {
        return tone -> {
            Tones res;
            if (tone.getSequence() + keyDifferenceValue > 11) {
                res = KEY_C_CHORD_SEQUENCE.get(tone.getSequence() + keyDifferenceValue - 12);
                return res;
            } else {
                res = KEY_C_CHORD_SEQUENCE.get(tone.getSequence() + keyDifferenceValue);
                return res;
            }
        };

    }

}

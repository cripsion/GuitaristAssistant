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

import static com.cripsion.guitaristassistant.Constants.CHORD_TYPE_MAP;
import static com.cripsion.guitaristassistant.Constants.KEY_C_CHORD_SEQUENCE;

/**
 * This controller is to handle the biz of converting chord progression to chords list.
 */
@Controller
@RequestMapping("/toneConverterController")
public class ToneConverterController {


    @PostMapping("/calcChords")
    @ResponseBody
    public List calcChords(@RequestParam(value = "key", required = false) Integer key,
                           @RequestParam(value = "flatOrSharp", required = false) String flatOrSharp,
                           @RequestParam(value = "chordProgression", required = false) String chordProgression) {
        int keyDifferenceValue = key;

        List<Tones> toneSequenceList = new ArrayList();
        for (var tone : KEY_C_CHORD_SEQUENCE) {
            toneSequenceList.add(tone.clone());
        }
        List<Tones> thisKeyChordSequence = toneSequenceList.stream().map(chordConverter(keyDifferenceValue, toneSequenceList)).collect(Collectors.toList());
        for (int i = 0; i < thisKeyChordSequence.size(); i++) {
            Tones thisTone = thisKeyChordSequence.get(i);
            thisTone.setSequence(i);
            thisTone.setProgression(i);
        }

        List<Integer> chordProgressionList = Arrays.asList(chordProgression.split("")).stream().map(k -> Integer.valueOf(k)).collect(Collectors.toList());
        List chordsList = new ArrayList();
        for (var chordNumber : chordProgressionList) {
            Chord thisChord = new Chord();
            //thisChord.setFlatOrSharp(Integer.valueOf(flatOrSharp));
            thisChord.setChordType(CHORD_TYPE_MAP.get(chordNumber));
            thisChord.setTone((thisKeyChordSequence.stream().filter(chord -> chord.getProgression() == chordNumber)).collect(Collectors.toList()).get(0).getName());
            chordsList.add(thisChord.getFullName());
        }
        return chordsList;
    }

    private Function<Tones, Tones> chordConverter(int keyDifferenceValue, List<Tones> toneSequence) {
        return tone -> {
            Tones res;
            if (tone.getSequence() + keyDifferenceValue > 11) {
                res = toneSequence.get(tone.getSequence() + keyDifferenceValue - 12);
                return res;
            } else {
                res = toneSequence.get(tone.getSequence() + keyDifferenceValue);
                return res;
            }
        };

    }

}

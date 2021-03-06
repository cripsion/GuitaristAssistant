package com.cripsion.guitaristassistant.controller;

import com.cripsion.guitaristassistant.entities.Chord;
import com.cripsion.guitaristassistant.entities.Pitch;
import com.cripsion.guitaristassistant.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * This controller is to handle the biz of converting chord progression to chords list.
 */
@Controller
@RequestMapping("/toneConverterController")
public class ToneConverterController {
    @Autowired
    UtilsService utilsService;

    @PostMapping("/calcChords")
    @ResponseBody
    public List<Chord> calcChords(@RequestParam(value = "key", required = false) Integer key,  //also means the difference to key C
                           @RequestParam(value = "chordProgression", required = false) String chordProgression) {
        List<Pitch> thisKeyPitchesList = utilsService.getAllPitchesInOneKey(key);

        List<Integer> chordProgressionList = Arrays.asList(chordProgression.split("")).stream().map(k -> Integer.valueOf(k)).collect(Collectors.toList());
        List chordsList = new ArrayList();
        for (var chordNumber : chordProgressionList) {
            Chord thisChord = new Chord();
            thisChord.setChordType(CHORD_TYPE_MAP.get(chordNumber));
            thisChord.setChordFullType(CHORD_TYPE_MAP_FULL.get(chordNumber));
            thisChord.setRoot((thisKeyPitchesList.stream().filter(pitch -> pitch.getProgression() == chordNumber)).collect(Collectors.toList()).get(0).getName());
            thisChord.setFullName(thisChord.getFullName());
            thisChord.setPitchesList(utilsService.getPitchesInOneChord(thisKeyPitchesList, thisChord.getRoot(), thisChord.getChordFullType()));
            chordsList.add(thisChord);
        }
        return chordsList;
    }



}

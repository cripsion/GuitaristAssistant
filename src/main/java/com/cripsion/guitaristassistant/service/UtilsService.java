package com.cripsion.guitaristassistant.service;

import com.cripsion.guitaristassistant.entities.Chord;
import com.cripsion.guitaristassistant.entities.Pitch;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.cripsion.guitaristassistant.Constants.*;

@Component
public class UtilsService {
    public List<Pitch> getAllPitchesInOneKey(int key) {
        List<Pitch> pitchesList = new ArrayList();
        for (var pitch : KEY_C_CHORD_SEQUENCE) {
            //deep copy to get a new list so that it won't affect the static data;
            pitchesList.add(pitch.clone());
        }

        pitchesList = pitchesList.stream().map(chordConverter(key, pitchesList)).collect(Collectors.toList());
        for (int i = 0; i < pitchesList.size(); i++) {
            Pitch thisPitch = pitchesList.get(i);
            thisPitch.setSequence(i);
            thisPitch.setProgression(progressionMapping(i));
        }
        return pitchesList;
    }

    public List<Pitch> getPitchesInOneChord(List<Pitch> thisKeyPitchesList, String chordRoot, String chordType) {
        //differential between chord root pitch and base key
        int seqDifferential = thisKeyPitchesList.stream().filter(k->k.getName().equals(chordRoot)).collect(Collectors.toList())
                .get(0).getSequence();
        List res = null;

        if (MAJOR.equals(chordType)) {  //大三和弦
            res = Stream.of(
                    thisKeyPitchesList.stream().filter(k -> k.getSequence() == (seqDifferential) % 12).collect(Collectors.toList()),
                    thisKeyPitchesList.stream().filter(k -> k.getSequence() == (4 + seqDifferential) % 12).collect(Collectors.toList()),
                    thisKeyPitchesList.stream().filter(k -> k.getSequence() == (7 + seqDifferential) % 12).collect(Collectors.toList()))
                    .flatMap(Collection::stream).collect(Collectors.toList());
        } else if (MINOR.equals(chordType)) {   //小三和弦
            res = Stream.of(
                    thisKeyPitchesList.stream().filter(k -> k.getSequence() == (seqDifferential) % 12).collect(Collectors.toList()),
                    thisKeyPitchesList.stream().filter(k -> k.getSequence() == (3 + seqDifferential) % 12).collect(Collectors.toList()),
                    thisKeyPitchesList.stream().filter(k -> k.getSequence() == (7 + seqDifferential) % 12).collect(Collectors.toList()))
                    .flatMap(Collection::stream).collect(Collectors.toList());
        } else if (DIMINISH.equals(chordType)) {    //减三和弦
            res = Stream.of(
                    thisKeyPitchesList.stream().filter(k -> k.getSequence() == (seqDifferential) % 12).collect(Collectors.toList()),
                    thisKeyPitchesList.stream().filter(k -> k.getSequence() == (3 + seqDifferential) % 12).collect(Collectors.toList()),
                    thisKeyPitchesList.stream().filter(k -> k.getSequence() == (6 + seqDifferential) % 12).collect(Collectors.toList()))
                    .flatMap(Collection::stream).collect(Collectors.toList());
        }
        
        return res;
    }

    private Function<Pitch, Pitch> chordConverter(int key, List<Pitch> pitchesList) {
        return pitch -> pitchesList.get((pitch.getSequence() + key) % 12);
    }

    private int progressionMapping(int sequence) {
        int res = -1;
        switch (sequence) {
            case 0:
                res = 1;
                break;
            case 2:
                res = 2;
                break;
            case 4:
                res = 3;
                break;
            case 5:
                res = 4;
                break;
            case 7:
                res = 5;
                break;
            case 9:
                res = 6;
                break;
            case 11:
                res = 7;
                break;
        }
        return res;
    }
}

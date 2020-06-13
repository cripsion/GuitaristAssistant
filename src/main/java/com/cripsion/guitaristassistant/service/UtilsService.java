package com.cripsion.guitaristassistant.service;

import com.cripsion.guitaristassistant.entities.Chord;
import com.cripsion.guitaristassistant.entities.Pitch;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.cripsion.guitaristassistant.Constants.KEY_C_CHORD_SEQUENCE;

@Component
public class UtilsService {
    public List<Pitch> getPitches(int key) {
        List<Pitch> toneSequenceList = new ArrayList();
        for (var tone : KEY_C_CHORD_SEQUENCE) {
            toneSequenceList.add(tone.clone());
        }
        return toneSequenceList.stream().map(chordConverter(key, toneSequenceList)).collect(Collectors.toList());
    }

    private Function<Pitch, Pitch> chordConverter(int keyDifferenceValue, List<Pitch> toneSequence) {
        return tone -> {
            Pitch res;
            if (tone.getSequence() + keyDifferenceValue > 11) {
                res = toneSequence.get(tone.getSequence() + keyDifferenceValue - 12);
            } else {
                res = toneSequence.get(tone.getSequence() + keyDifferenceValue);
            }
            return res;
        };

    }
}

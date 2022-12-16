package com.example.demo.statics;

import com.example.demo.model.CandidateType;
import com.example.demo.model.Status;

import static com.example.demo.model.CandidateType.*;
import static com.example.demo.model.Status.*;

public class EnumStatics {

    public static Status statusEnum(int statusInt) {
        return switch (statusInt) {
            case 0 -> PHONE_SCREEN;
            case 1 -> INTERVIEW;
            case 2 -> AWAITING_DECISION;
            default -> null;
        };
    }

    public static CandidateType candidateTypeEnum(int type){
        return switch (type) {
            case 0 -> UNSOLICITED;
            case 1 -> SOLICITED;
            case 2 -> INTERNAL;
            default -> null;
        };
    }
}

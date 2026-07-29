package com.flydigi.cyberfox.h1.models.equalizer.parameters;

/* JADX INFO: loaded from: classes7.dex */
public enum ParameterType {
    FILTER,
    FREQUENCY,
    GAIN,
    QUALITY;

    private static final ParameterType[] values = values();

    public static int getSize() {
        return values.length;
    }

    public static ParameterType valueOf(int i10) {
        if (i10 < 0) {
            return null;
        }
        ParameterType[] parameterTypeArr = values;
        if (i10 >= parameterTypeArr.length) {
            return null;
        }
        return parameterTypeArr[i10];
    }
}

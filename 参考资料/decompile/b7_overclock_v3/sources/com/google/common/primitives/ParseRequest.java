package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
final class ParseRequest {
    public final int radix;
    public final String rawValue;

    private ParseRequest(String str, int i10) {
        this.rawValue = str;
        this.radix = i10;
    }

    public static ParseRequest fromString(String str) {
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        char cCharAt = str.charAt(0);
        int i10 = 16;
        if (str.startsWith("0x") || str.startsWith("0X")) {
            str = str.substring(2);
        } else if (cCharAt == '#') {
            str = str.substring(1);
        } else if (cCharAt != '0' || str.length() <= 1) {
            i10 = 10;
        } else {
            str = str.substring(1);
            i10 = 8;
        }
        return new ParseRequest(str, i10);
    }
}

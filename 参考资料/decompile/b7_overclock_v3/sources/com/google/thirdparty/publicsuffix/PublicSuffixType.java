package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtCompatible
public enum PublicSuffixType {
    PRIVATE(':', ','),
    REGISTRY(PublicSuffixDatabase.f43873i, '?');

    private final char innerNodeCode;
    private final char leafNodeCode;

    PublicSuffixType(char c10, char c11) {
        this.innerNodeCode = c10;
        this.leafNodeCode = c11;
    }

    public static PublicSuffixType fromCode(char c10) {
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.getInnerNodeCode() == c10 || publicSuffixType.getLeafNodeCode() == c10) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c10);
    }

    public static PublicSuffixType fromIsPrivate(boolean z10) {
        return z10 ? PRIVATE : REGISTRY;
    }

    public char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    public char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}

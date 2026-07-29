package com.google.android.exoplayer2.drm;

/* JADX INFO: loaded from: classes3.dex */
public class DecryptionException extends Exception {
    public final int errorCode;

    public DecryptionException(int i10, String str) {
        super(str);
        this.errorCode = i10;
    }
}

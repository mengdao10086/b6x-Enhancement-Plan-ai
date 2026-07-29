package com.google.android.exoplayer2.drm;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class UnsupportedDrmException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f17045a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f17046b = 2;
    public final int reason;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public UnsupportedDrmException(int i10) {
        this.reason = i10;
    }

    public UnsupportedDrmException(int i10, Exception exc) {
        super(exc);
        this.reason = i10;
    }
}

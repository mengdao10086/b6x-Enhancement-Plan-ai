package com.google.android.exoplayer2;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class ExoTimeoutException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16681a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16682b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16683c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16684d = 3;
    public final int timeoutOperation;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public ExoTimeoutException(int i10) {
        super(a(i10));
        this.timeoutOperation = i10;
    }

    public static String a(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "Undefined timeout." : "Detaching surface timed out." : "Setting foreground mode timed out." : "Player release timed out.";
    }
}

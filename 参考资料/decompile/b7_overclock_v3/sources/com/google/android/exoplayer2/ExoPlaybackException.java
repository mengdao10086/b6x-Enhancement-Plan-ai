package com.google.android.exoplayer2;

import android.os.SystemClock;
import android.text.TextUtils;
import ec.n;
import g.j;
import g.p0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class ExoPlaybackException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16677a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16678b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16679c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16680d = 3;

    @p0
    private final Throwable cause;
    public final boolean isRecoverable;

    @p0
    public final n mediaPeriodId;

    @p0
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;

    @p0
    public final String rendererName;
    public final long timestampMs;
    public final int type;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public ExoPlaybackException(int i10, Throwable th2) {
        this(i10, th2, null, null, -1, null, 4, false);
    }

    public static ExoPlaybackException b(String str) {
        return new ExoPlaybackException(3, str);
    }

    public static ExoPlaybackException c(Exception exc) {
        return new ExoPlaybackException(1, exc, null, null, -1, null, 4, false);
    }

    public static ExoPlaybackException d(Throwable th2, String str, int i10, @p0 Format format, int i11) {
        return f(th2, str, i10, format, i11, false);
    }

    public static ExoPlaybackException f(Throwable th2, String str, int i10, @p0 Format format, int i11, boolean z10) {
        return new ExoPlaybackException(1, th2, null, str, i10, format, format == null ? 4 : i11, z10);
    }

    public static ExoPlaybackException h(IOException iOException) {
        return new ExoPlaybackException(0, iOException);
    }

    public static ExoPlaybackException i(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, runtimeException);
    }

    @p0
    public static String k(int i10, @p0 String str, @p0 String str2, int i11, @p0 Format format, int i12) {
        String str3;
        if (i10 == 0) {
            str3 = "Source error";
        } else if (i10 != 1) {
            str3 = i10 != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i11 + ", format=" + format + ", format_supported=" + g.b(i12);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    @j
    public ExoPlaybackException a(@p0 n nVar) {
        return new ExoPlaybackException(getMessage(), this.cause, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, nVar, this.timestampMs, this.isRecoverable);
    }

    public Exception l() {
        hd.a.i(this.type == 1);
        return (Exception) hd.a.g(this.cause);
    }

    public IOException m() {
        hd.a.i(this.type == 0);
        return (IOException) hd.a.g(this.cause);
    }

    public RuntimeException n() {
        hd.a.i(this.type == 2);
        return (RuntimeException) hd.a.g(this.cause);
    }

    public ExoPlaybackException(int i10, String str) {
        this(i10, null, str, null, -1, null, 4, false);
    }

    public ExoPlaybackException(int i10, @p0 Throwable th2, @p0 String str, @p0 String str2, int i11, @p0 Format format, int i12, boolean z10) {
        this(k(i10, str, str2, i11, format, i12), th2, i10, str2, i11, format, i12, null, SystemClock.elapsedRealtime(), z10);
    }

    public ExoPlaybackException(@p0 String str, @p0 Throwable th2, int i10, @p0 String str2, int i11, @p0 Format format, int i12, @p0 n nVar, long j10, boolean z10) {
        super(str, th2);
        this.type = i10;
        this.cause = th2;
        this.rendererName = str2;
        this.rendererIndex = i11;
        this.rendererFormat = format;
        this.rendererFormatSupport = i12;
        this.mediaPeriodId = nVar;
        this.timestampMs = j10;
        this.isRecoverable = z10;
    }
}

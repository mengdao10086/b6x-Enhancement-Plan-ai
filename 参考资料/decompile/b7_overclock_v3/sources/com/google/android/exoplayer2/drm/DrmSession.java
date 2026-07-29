package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.b;
import g.p0;
import gb.s;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public interface DrmSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f17040a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f17041b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f17042c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f17043d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f17044e = 4;

    public static class DrmSessionException extends IOException {
        public DrmSessionException(Throwable th2) {
            super(th2);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @p0
    DrmSessionException d();

    void e(@p0 b.a aVar);

    void f(@p0 b.a aVar);

    UUID g();

    int getState();

    boolean h();

    @p0
    Map<String, String> i();

    @p0
    s j();

    @p0
    byte[] k();
}

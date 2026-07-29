package com.google.android.exoplayer2.source.ads;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import g.p0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import ya.j1;

/* JADX INFO: loaded from: classes3.dex */
public interface b {

    public interface a {
        @Deprecated
        View[] a();

        List<c> getAdOverlayInfos();

        @p0
        ViewGroup getAdViewGroup();
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.ads.b$b, reason: collision with other inner class name */
    public interface InterfaceC0182b {
        void a(com.google.android.exoplayer2.source.ads.a aVar);

        void b();

        void c(AdsMediaSource.AdLoadException adLoadException, com.google.android.exoplayer2.upstream.b bVar);

        void d();
    }

    public static final class c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f17555d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f17556e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f17557f = 2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f17558g = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f17559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public final String f17561c;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public c(View view, int i10) {
            this(view, i10, null);
        }

        public c(View view, int i10, @p0 String str) {
            this.f17559a = view;
            this.f17560b = i10;
            this.f17561c = str;
        }
    }

    void a(AdsMediaSource adsMediaSource, int i10, int i11);

    void b(AdsMediaSource adsMediaSource, int i10, int i11, IOException iOException);

    void c(AdsMediaSource adsMediaSource, InterfaceC0182b interfaceC0182b);

    void d(AdsMediaSource adsMediaSource, com.google.android.exoplayer2.upstream.b bVar, Object obj, a aVar, InterfaceC0182b interfaceC0182b);

    void e(int... iArr);

    void f(@p0 j1 j1Var);

    void release();
}

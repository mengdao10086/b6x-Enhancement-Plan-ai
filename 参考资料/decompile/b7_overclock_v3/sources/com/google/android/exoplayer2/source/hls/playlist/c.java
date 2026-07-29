package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import g.p0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends lc.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f18024u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f18025v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f18026w = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f18027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f18028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f18029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f18030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f18031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f18032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f18033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f18034k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f18035l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f18036m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f18037n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public final DrmInitData f18038o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<e> f18039p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<b> f18040q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<Uri, d> f18041r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f18042s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final g f18043t;

    public static final class b extends f {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f18044l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f18045m;

        public b(String str, @p0 e eVar, long j10, int i10, long j11, @p0 DrmInitData drmInitData, @p0 String str2, @p0 String str3, long j12, long j13, boolean z10, boolean z11, boolean z12) {
            super(str, eVar, j10, i10, j11, drmInitData, str2, str3, j12, j13, z10);
            this.f18044l = z11;
            this.f18045m = z12;
        }

        public b d(long j10, int i10) {
            return new b(this.f18051a, this.f18052b, this.f18053c, i10, j10, this.f18056f, this.f18057g, this.f18058h, this.f18059i, this.f18060j, this.f18061k, this.f18044l, this.f18045m);
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.hls.playlist.c$c, reason: collision with other inner class name */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0189c {
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f18046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f18047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f18048c;

        public d(Uri uri, long j10, int i10) {
            this.f18046a = uri;
            this.f18047b = j10;
            this.f18048c = i10;
        }
    }

    public static class f implements Comparable<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final e f18052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f18053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f18054d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f18055e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public final DrmInitData f18056f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @p0
        public final String f18057g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @p0
        public final String f18058h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f18059i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f18060j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f18061k;

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(Long l10) {
            if (this.f18055e > l10.longValue()) {
                return 1;
            }
            return this.f18055e < l10.longValue() ? -1 : 0;
        }

        public f(String str, @p0 e eVar, long j10, int i10, long j11, @p0 DrmInitData drmInitData, @p0 String str2, @p0 String str3, long j12, long j13, boolean z10) {
            this.f18051a = str;
            this.f18052b = eVar;
            this.f18053c = j10;
            this.f18054d = i10;
            this.f18055e = j11;
            this.f18056f = drmInitData;
            this.f18057g = str2;
            this.f18058h = str3;
            this.f18059i = j12;
            this.f18060j = j13;
            this.f18061k = z10;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f18062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f18063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f18064c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f18065d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f18066e;

        public g(long j10, boolean z10, long j11, long j12, boolean z11) {
            this.f18062a = j10;
            this.f18063b = z10;
            this.f18064c = j11;
            this.f18065d = j12;
            this.f18066e = z11;
        }
    }

    public c(int i10, String str, List<String> list, long j10, long j11, boolean z10, int i11, long j12, int i12, long j13, long j14, boolean z11, boolean z12, boolean z13, @p0 DrmInitData drmInitData, List<e> list2, List<b> list3, g gVar, Map<Uri, d> map) {
        super(str, list, z11);
        this.f18027d = i10;
        this.f18029f = j11;
        this.f18030g = z10;
        this.f18031h = i11;
        this.f18032i = j12;
        this.f18033j = i12;
        this.f18034k = j13;
        this.f18035l = j14;
        this.f18036m = z12;
        this.f18037n = z13;
        this.f18038o = drmInitData;
        this.f18039p = ImmutableList.copyOf((Collection) list2);
        this.f18040q = ImmutableList.copyOf((Collection) list3);
        this.f18041r = ImmutableMap.copyOf((Map) map);
        if (!list3.isEmpty()) {
            b bVar = (b) Iterables.getLast(list3);
            this.f18042s = bVar.f18055e + bVar.f18053c;
        } else if (list2.isEmpty()) {
            this.f18042s = 0L;
        } else {
            e eVar = (e) Iterables.getLast(list2);
            this.f18042s = eVar.f18055e + eVar.f18053c;
        }
        this.f18028e = j10 == ya.g.f56663b ? -9223372036854775807L : j10 >= 0 ? j10 : this.f18042s + j10;
        this.f18043t = gVar;
    }

    @Override // cc.y
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a(List<StreamKey> list) {
        return this;
    }

    public c c(long j10, int i10) {
        return new c(this.f18027d, this.f39566a, this.f39567b, this.f18028e, j10, true, i10, this.f18032i, this.f18033j, this.f18034k, this.f18035l, this.f39568c, this.f18036m, this.f18037n, this.f18038o, this.f18039p, this.f18040q, this.f18043t, this.f18041r);
    }

    public c d() {
        return this.f18036m ? this : new c(this.f18027d, this.f39566a, this.f39567b, this.f18028e, this.f18029f, this.f18030g, this.f18031h, this.f18032i, this.f18033j, this.f18034k, this.f18035l, this.f39568c, true, this.f18037n, this.f18038o, this.f18039p, this.f18040q, this.f18043t, this.f18041r);
    }

    public long e() {
        return this.f18029f + this.f18042s;
    }

    public boolean f(@p0 c cVar) {
        if (cVar == null) {
            return true;
        }
        long j10 = this.f18032i;
        long j11 = cVar.f18032i;
        if (j10 > j11) {
            return true;
        }
        if (j10 < j11) {
            return false;
        }
        int size = this.f18039p.size() - cVar.f18039p.size();
        if (size != 0) {
            return size > 0;
        }
        int size2 = this.f18040q.size();
        int size3 = cVar.f18040q.size();
        if (size2 <= size3) {
            return size2 == size3 && this.f18036m && !cVar.f18036m;
        }
        return true;
    }

    public static final class e extends f {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f18049l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final List<b> f18050m;

        public e(String str, long j10, long j11, @p0 String str2, @p0 String str3) {
            this(str, null, "", 0L, -1, ya.g.f56663b, null, str2, str3, j10, j11, false, ImmutableList.of());
        }

        public e d(long j10, int i10) {
            ArrayList arrayList = new ArrayList();
            long j11 = j10;
            for (int i11 = 0; i11 < this.f18050m.size(); i11++) {
                b bVar = this.f18050m.get(i11);
                arrayList.add(bVar.d(j11, i10));
                j11 += bVar.f18053c;
            }
            return new e(this.f18051a, this.f18052b, this.f18049l, this.f18053c, i10, j10, this.f18056f, this.f18057g, this.f18058h, this.f18059i, this.f18060j, this.f18061k, arrayList);
        }

        public e(String str, @p0 e eVar, String str2, long j10, int i10, long j11, @p0 DrmInitData drmInitData, @p0 String str3, @p0 String str4, long j12, long j13, boolean z10, List<b> list) {
            super(str, eVar, j10, i10, j11, drmInitData, str3, str4, j12, j13, z10);
            this.f18049l = str2;
            this.f18050m = ImmutableList.copyOf((Collection) list);
        }
    }
}

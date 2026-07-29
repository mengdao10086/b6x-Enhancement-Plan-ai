package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import cc.y;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.offline.StreamKey;
import g.p0;
import hd.s0;
import hd.u0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import ob.p;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public class a implements y<a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f18404i = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final C0192a f18409e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b[] f18410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f18411g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f18412h;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.a$a, reason: collision with other inner class name */
    public static class C0192a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f18413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f18414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p[] f18415c;

        public C0192a(UUID uuid, byte[] bArr, p[] pVarArr) {
            this.f18413a = uuid;
            this.f18414b = bArr;
            this.f18415c = pVarArr;
        }
    }

    public a(int i10, int i11, long j10, long j11, long j12, int i12, boolean z10, @p0 C0192a c0192a, b[] bVarArr) {
        this(i10, i11, j11 == 0 ? -9223372036854775807L : u0.h1(j11, 1000000L, j10), j12 != 0 ? u0.h1(j12, 1000000L, j10) : g.f56663b, i12, z10, c0192a, bVarArr);
    }

    @Override // cc.y
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final a a(List<StreamKey> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVar = null;
        int i10 = 0;
        while (i10 < arrayList.size()) {
            StreamKey streamKey = (StreamKey) arrayList.get(i10);
            b bVar2 = this.f18410f[streamKey.f17422b];
            if (bVar2 != bVar && bVar != null) {
                arrayList2.add(bVar.b((Format[]) arrayList3.toArray(new Format[0])));
                arrayList3.clear();
            }
            arrayList3.add(bVar2.f18429j[streamKey.f17423c]);
            i10++;
            bVar = bVar2;
        }
        if (bVar != null) {
            arrayList2.add(bVar.b((Format[]) arrayList3.toArray(new Format[0])));
        }
        return new a(this.f18405a, this.f18406b, this.f18411g, this.f18412h, this.f18407c, this.f18408d, this.f18409e, (b[]) arrayList2.toArray(new b[0]));
    }

    public static class b {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final String f18416q = "{start time}";

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final String f18417r = "{start_time}";

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final String f18418s = "{bitrate}";

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final String f18419t = "{Bitrate}";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f18421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f18422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f18423d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f18424e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f18425f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f18426g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f18427h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @p0
        public final String f18428i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Format[] f18429j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f18430k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f18431l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f18432m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final List<Long> f18433n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final long[] f18434o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final long f18435p;

        public b(String str, String str2, int i10, String str3, long j10, String str4, int i11, int i12, int i13, int i14, @p0 String str5, Format[] formatArr, List<Long> list, long j11) {
            this(str, str2, i10, str3, j10, str4, i11, i12, i13, i14, str5, formatArr, list, u0.i1(list, 1000000L, j10), u0.h1(j11, 1000000L, j10));
        }

        public Uri a(int i10, int i11) {
            hd.a.i(this.f18429j != null);
            hd.a.i(this.f18433n != null);
            hd.a.i(i11 < this.f18433n.size());
            String string = Integer.toString(this.f18429j[i10].f16694h);
            String string2 = this.f18433n.get(i11).toString();
            return s0.e(this.f18431l, this.f18432m.replace(f18418s, string).replace(f18419t, string).replace(f18416q, string2).replace(f18417r, string2));
        }

        public b b(Format[] formatArr) {
            return new b(this.f18431l, this.f18432m, this.f18420a, this.f18421b, this.f18422c, this.f18423d, this.f18424e, this.f18425f, this.f18426g, this.f18427h, this.f18428i, formatArr, this.f18433n, this.f18434o, this.f18435p);
        }

        public long c(int i10) {
            if (i10 == this.f18430k - 1) {
                return this.f18435p;
            }
            long[] jArr = this.f18434o;
            return jArr[i10 + 1] - jArr[i10];
        }

        public int d(long j10) {
            return u0.j(this.f18434o, j10, true, true);
        }

        public long e(int i10) {
            return this.f18434o[i10];
        }

        public b(String str, String str2, int i10, String str3, long j10, String str4, int i11, int i12, int i13, int i14, @p0 String str5, Format[] formatArr, List<Long> list, long[] jArr, long j11) {
            this.f18431l = str;
            this.f18432m = str2;
            this.f18420a = i10;
            this.f18421b = str3;
            this.f18422c = j10;
            this.f18423d = str4;
            this.f18424e = i11;
            this.f18425f = i12;
            this.f18426g = i13;
            this.f18427h = i14;
            this.f18428i = str5;
            this.f18429j = formatArr;
            this.f18433n = list;
            this.f18434o = jArr;
            this.f18435p = j11;
            this.f18430k = list.size();
        }
    }

    public a(int i10, int i11, long j10, long j11, int i12, boolean z10, @p0 C0192a c0192a, b[] bVarArr) {
        this.f18405a = i10;
        this.f18406b = i11;
        this.f18411g = j10;
        this.f18412h = j11;
        this.f18407c = i12;
        this.f18408d = z10;
        this.f18409e = c0192a;
        this.f18410f = bVarArr;
    }
}

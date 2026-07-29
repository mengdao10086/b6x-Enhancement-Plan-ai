package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.hls.s;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.m;
import com.google.common.primitives.Ints;
import ec.d0;
import ed.z;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import ya.t1;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements com.google.android.exoplayer2.source.k, s.b, HlsPlaylistTracker.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f17885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HlsPlaylistTracker f17886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f17887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final z f17888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f17889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b.a f17890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.j f17891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m.a f17892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ed.b f17893i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ec.d f17896l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f17897m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f17898n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f17899o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public k.a f17900p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f17901q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TrackGroupArray f17902r;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f17906v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public com.google.android.exoplayer2.source.s f17907w;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IdentityHashMap<d0, Integer> f17894j = new IdentityHashMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final v f17895k = new v();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public s[] f17903s = new s[0];

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public s[] f17904t = new s[0];

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int[][] f17905u = new int[0][];

    public l(h hVar, HlsPlaylistTracker hlsPlaylistTracker, g gVar, @p0 z zVar, com.google.android.exoplayer2.drm.c cVar, b.a aVar, com.google.android.exoplayer2.upstream.j jVar, m.a aVar2, ed.b bVar, ec.d dVar, boolean z10, int i10, boolean z11) {
        this.f17885a = hVar;
        this.f17886b = hlsPlaylistTracker;
        this.f17887c = gVar;
        this.f17888d = zVar;
        this.f17889e = cVar;
        this.f17890f = aVar;
        this.f17891g = jVar;
        this.f17892h = aVar2;
        this.f17893i = bVar;
        this.f17896l = dVar;
        this.f17897m = z10;
        this.f17898n = i10;
        this.f17899o = z11;
        this.f17907w = dVar.a(new com.google.android.exoplayer2.source.s[0]);
    }

    public static Format x(Format format, @p0 Format format2, boolean z10) {
        String str;
        Metadata metadata;
        int i10;
        int i11;
        int i12;
        String str2;
        String str3;
        if (format2 != null) {
            str2 = format2.f16695i;
            metadata = format2.f16696j;
            int i13 = format2.f16712y;
            i11 = format2.f16690d;
            int i14 = format2.f16691e;
            String str4 = format2.f16689c;
            str3 = format2.f16688b;
            i12 = i13;
            i10 = i14;
            str = str4;
        } else {
            String strS = u0.S(format.f16695i, 1);
            Metadata metadata2 = format.f16696j;
            if (z10) {
                int i15 = format.f16712y;
                int i16 = format.f16690d;
                int i17 = format.f16691e;
                str = format.f16689c;
                str2 = strS;
                str3 = format.f16688b;
                i12 = i15;
                i11 = i16;
                metadata = metadata2;
                i10 = i17;
            } else {
                str = null;
                metadata = metadata2;
                i10 = 0;
                i11 = 0;
                i12 = -1;
                str2 = strS;
                str3 = null;
            }
        }
        return new Format.b().S(format.f16687a).U(str3).K(format.f16697k).e0(hd.w.g(str2)).I(str2).X(metadata).G(z10 ? format.f16692f : -1).Z(z10 ? format.f16693g : -1).H(i12).g0(i11).c0(i10).V(str).E();
    }

    public static Map<String, DrmInitData> y(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        int i10 = 0;
        while (i10 < arrayList.size()) {
            DrmInitData drmInitDataS = list.get(i10);
            String str = drmInitDataS.f17033c;
            i10++;
            int i11 = i10;
            while (i11 < arrayList.size()) {
                DrmInitData drmInitData = (DrmInitData) arrayList.get(i11);
                if (TextUtils.equals(drmInitData.f17033c, str)) {
                    drmInitDataS = drmInitDataS.s(drmInitData);
                    arrayList.remove(i11);
                } else {
                    i11++;
                }
            }
            map.put(str, drmInitDataS);
        }
        return map;
    }

    public static Format z(Format format) {
        String strS = u0.S(format.f16695i, 2);
        return new Format.b().S(format.f16687a).U(format.f16688b).K(format.f16697k).e0(hd.w.g(strS)).I(strS).X(format.f16696j).G(format.f16692f).Z(format.f16693g).j0(format.f16704q).Q(format.f16705r).P(format.f16706s).g0(format.f16690d).c0(format.f16691e).E();
    }

    @Override // com.google.android.exoplayer2.source.s.a
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public void i(s sVar) {
        this.f17900p.i(this);
    }

    public void B() {
        this.f17886b.b(this);
        for (s sVar : this.f17903s) {
            sVar.f0();
        }
        this.f17900p = null;
    }

    @Override // com.google.android.exoplayer2.source.hls.s.b
    public void a() {
        int i10 = this.f17901q - 1;
        this.f17901q = i10;
        if (i10 > 0) {
            return;
        }
        int i11 = 0;
        for (s sVar : this.f17903s) {
            i11 += sVar.r().f17502a;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i11];
        int i12 = 0;
        for (s sVar2 : this.f17903s) {
            int i13 = sVar2.r().f17502a;
            int i14 = 0;
            while (i14 < i13) {
                trackGroupArr[i12] = sVar2.r().a(i14);
                i14++;
                i12++;
            }
        }
        this.f17902r = new TrackGroupArray(trackGroupArr);
        this.f17900p.l(this);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long b() {
        return this.f17907w.b();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long c(long j10, t1 t1Var) {
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void d() {
        for (s sVar : this.f17903s) {
            sVar.b0();
        }
        this.f17900p.i(this);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean e(long j10) {
        if (this.f17902r != null) {
            return this.f17907w.e(j10);
        }
        for (s sVar : this.f17903s) {
            sVar.B();
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long f() {
        return this.f17907w.f();
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public void g(long j10) {
        this.f17907w.g(j10);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public boolean h(Uri uri, long j10) {
        boolean zA0 = true;
        for (s sVar : this.f17903s) {
            zA0 &= sVar.a0(uri, j10);
        }
        this.f17900p.i(this);
        return zA0;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean isLoading() {
        return this.f17907w.isLoading();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v7 */
    @Override // com.google.android.exoplayer2.source.k
    public List<StreamKey> j(List<com.google.android.exoplayer2.trackselection.b> list) {
        int[] iArr;
        TrackGroupArray trackGroupArrayR;
        int iM;
        l lVar = this;
        com.google.android.exoplayer2.source.hls.playlist.b bVar = (com.google.android.exoplayer2.source.hls.playlist.b) hd.a.g(lVar.f17886b.e());
        boolean z10 = !bVar.f18005e.isEmpty();
        int length = lVar.f17903s.length - bVar.f18008h.size();
        int i10 = 0;
        if (z10) {
            s sVar = lVar.f17903s[0];
            iArr = lVar.f17905u[0];
            trackGroupArrayR = sVar.r();
            iM = sVar.M();
        } else {
            iArr = new int[0];
            trackGroupArrayR = TrackGroupArray.f17501d;
            iM = 0;
        }
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        boolean z12 = false;
        for (com.google.android.exoplayer2.trackselection.b bVar2 : list) {
            TrackGroup trackGroupA = bVar2.a();
            int iB = trackGroupArrayR.b(trackGroupA);
            if (iB == -1) {
                ?? r15 = z10;
                while (true) {
                    s[] sVarArr = lVar.f17903s;
                    if (r15 >= sVarArr.length) {
                        break;
                    }
                    if (sVarArr[r15].r().b(trackGroupA) != -1) {
                        int i11 = r15 < length ? 1 : 2;
                        int[] iArr2 = lVar.f17905u[r15];
                        for (int i12 = 0; i12 < bVar2.length(); i12++) {
                            arrayList.add(new StreamKey(i11, iArr2[bVar2.c(i12)]));
                        }
                    } else {
                        lVar = this;
                        r15++;
                    }
                }
            } else if (iB == iM) {
                for (int i13 = 0; i13 < bVar2.length(); i13++) {
                    arrayList.add(new StreamKey(i10, iArr[bVar2.c(i13)]));
                }
                z12 = true;
            } else {
                z11 = true;
            }
            lVar = this;
            i10 = 0;
        }
        if (z11 && !z12) {
            int i14 = iArr[0];
            int i15 = bVar.f18005e.get(iArr[0]).f18019b.f16694h;
            for (int i16 = 1; i16 < iArr.length; i16++) {
                int i17 = bVar.f18005e.get(iArr[i16]).f18019b.f16694h;
                if (i17 < i15) {
                    i14 = iArr[i16];
                    i15 = i17;
                }
            }
            arrayList.add(new StreamKey(0, i14));
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.hls.s.b
    public void k(Uri uri) {
        this.f17886b.h(uri);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void m() throws IOException {
        for (s sVar : this.f17903s) {
            sVar.m();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public long n(long j10) {
        s[] sVarArr = this.f17904t;
        if (sVarArr.length > 0) {
            boolean zI0 = sVarArr[0].i0(j10, false);
            int i10 = 1;
            while (true) {
                s[] sVarArr2 = this.f17904t;
                if (i10 >= sVarArr2.length) {
                    break;
                }
                sVarArr2[i10].i0(j10, zI0);
                i10++;
            }
            if (zI0) {
                this.f17895k.b();
            }
        }
        return j10;
    }

    public final void o(long j10, List<b.a> list, List<s> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = list.get(i10).f18017d;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z10 = true;
                for (int i11 = 0; i11 < list.size(); i11++) {
                    if (u0.c(str, list.get(i11).f18017d)) {
                        b.a aVar = list.get(i11);
                        arrayList3.add(Integer.valueOf(i11));
                        arrayList.add(aVar.f18014a);
                        arrayList2.add(aVar.f18015b);
                        z10 &= u0.R(aVar.f18015b.f16695i, 1) == 1;
                    }
                }
                s sVarW = w(1, (Uri[]) arrayList.toArray((Uri[]) u0.l(new Uri[0])), (Format[]) arrayList2.toArray(new Format[0]), null, Collections.emptyList(), map, j10);
                list3.add(Ints.toArray(arrayList3));
                list2.add(sVarW);
                if (this.f17897m && z10) {
                    sVarW.d0(new TrackGroup[]{new TrackGroup((Format[]) arrayList2.toArray(new Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public long p() {
        return ya.g.f56663b;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void q(k.a aVar, long j10) {
        this.f17900p = aVar;
        this.f17886b.j(this);
        v(j10);
    }

    @Override // com.google.android.exoplayer2.source.k
    public TrackGroupArray r() {
        return (TrackGroupArray) hd.a.g(this.f17902r);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00e3  */
    @Override // com.google.android.exoplayer2.source.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long s(com.google.android.exoplayer2.trackselection.b[] r22, boolean[] r23, ec.d0[] r24, boolean[] r25, long r26) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.l.s(com.google.android.exoplayer2.trackselection.b[], boolean[], ec.d0[], boolean[], long):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(com.google.android.exoplayer2.source.hls.playlist.b r20, long r21, java.util.List<com.google.android.exoplayer2.source.hls.s> r23, java.util.List<int[]> r24, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> r25) {
        /*
            Method dump skipped, instruction units count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.l.t(com.google.android.exoplayer2.source.hls.playlist.b, long, java.util.List, java.util.List, java.util.Map):void");
    }

    @Override // com.google.android.exoplayer2.source.k
    public void u(long j10, boolean z10) {
        for (s sVar : this.f17904t) {
            sVar.u(j10, z10);
        }
    }

    public final void v(long j10) {
        com.google.android.exoplayer2.source.hls.playlist.b bVar = (com.google.android.exoplayer2.source.hls.playlist.b) hd.a.g(this.f17886b.e());
        Map<String, DrmInitData> mapY = this.f17899o ? y(bVar.f18013m) : Collections.emptyMap();
        boolean z10 = !bVar.f18005e.isEmpty();
        List<b.a> list = bVar.f18007g;
        List<b.a> list2 = bVar.f18008h;
        this.f17901q = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z10) {
            t(bVar, j10, arrayList, arrayList2, mapY);
        }
        o(j10, list, arrayList, arrayList2, mapY);
        this.f17906v = arrayList.size();
        int i10 = 0;
        while (i10 < list2.size()) {
            b.a aVar = list2.get(i10);
            int i11 = i10;
            s sVarW = w(3, new Uri[]{aVar.f18014a}, new Format[]{aVar.f18015b}, null, Collections.emptyList(), mapY, j10);
            arrayList2.add(new int[]{i11});
            arrayList.add(sVarW);
            sVarW.d0(new TrackGroup[]{new TrackGroup(aVar.f18015b)}, 0, new int[0]);
            i10 = i11 + 1;
        }
        this.f17903s = (s[]) arrayList.toArray(new s[0]);
        this.f17905u = (int[][]) arrayList2.toArray(new int[0][]);
        s[] sVarArr = this.f17903s;
        this.f17901q = sVarArr.length;
        sVarArr[0].m0(true);
        for (s sVar : this.f17903s) {
            sVar.B();
        }
        this.f17904t = this.f17903s;
    }

    public final s w(int i10, Uri[] uriArr, Format[] formatArr, @p0 Format format, @p0 List<Format> list, Map<String, DrmInitData> map, long j10) {
        return new s(i10, this, new f(this.f17885a, this.f17886b, uriArr, formatArr, this.f17887c, this.f17888d, this.f17895k, list), map, this.f17893i, j10, format, this.f17889e, this.f17890f, this.f17891g, this.f17892h, this.f17898n);
    }
}

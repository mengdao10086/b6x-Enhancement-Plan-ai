package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.d;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.upstream.j;
import com.google.common.primitives.Ints;
import ec.d0;
import ed.u;
import ed.z;
import g.p0;
import gc.h;
import hd.u0;
import hd.w;
import ic.e;
import ic.f;
import ic.i;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ya.g;
import ya.t1;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements k, s.a<h<com.google.android.exoplayer2.source.dash.a>>, h.b<com.google.android.exoplayer2.source.dash.a> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Pattern f17667w = Pattern.compile("CC([1-4])=(.+)");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Pattern f17668x = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a.InterfaceC0184a f17670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final z f17671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f17672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f17673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f17674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u f17675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ed.b f17676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TrackGroupArray f17677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a[] f17678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ec.d f17679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f17680l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m.a f17682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b.a f17683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public k.a f17684p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public s f17687s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ic.b f17688t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f17689u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List<e> f17690v;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public h<com.google.android.exoplayer2.source.dash.a>[] f17685q = F(0);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public hc.h[] f17686r = new hc.h[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final IdentityHashMap<h<com.google.android.exoplayer2.source.dash.a>, d.c> f17681m = new IdentityHashMap<>();

    public static final class a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f17691h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f17692i = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f17693j = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f17694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f17696c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f17697d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f17698e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f17699f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f17700g;

        /* JADX INFO: renamed from: com.google.android.exoplayer2.source.dash.b$a$a, reason: collision with other inner class name */
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface InterfaceC0185a {
        }

        public a(int i10, int i11, int[] iArr, int i12, int i13, int i14, int i15) {
            this.f17695b = i10;
            this.f17694a = iArr;
            this.f17696c = i11;
            this.f17698e = i12;
            this.f17699f = i13;
            this.f17700g = i14;
            this.f17697d = i15;
        }

        public static a a(int[] iArr, int i10) {
            return new a(3, 1, iArr, i10, -1, -1, -1);
        }

        public static a b(int[] iArr, int i10) {
            return new a(5, 1, iArr, i10, -1, -1, -1);
        }

        public static a c(int i10) {
            return new a(5, 2, new int[0], -1, -1, -1, i10);
        }

        public static a d(int i10, int[] iArr, int i11, int i12, int i13) {
            return new a(i10, 0, iArr, i11, i12, i13, -1);
        }
    }

    public b(int i10, ic.b bVar, int i11, a.InterfaceC0184a interfaceC0184a, @p0 z zVar, com.google.android.exoplayer2.drm.c cVar, b.a aVar, j jVar, m.a aVar2, long j10, u uVar, ed.b bVar2, ec.d dVar, d.b bVar3) {
        this.f17669a = i10;
        this.f17688t = bVar;
        this.f17689u = i11;
        this.f17670b = interfaceC0184a;
        this.f17671c = zVar;
        this.f17672d = cVar;
        this.f17683o = aVar;
        this.f17673e = jVar;
        this.f17682n = aVar2;
        this.f17674f = j10;
        this.f17675g = uVar;
        this.f17676h = bVar2;
        this.f17679k = dVar;
        this.f17680l = new d(bVar, bVar3, bVar2);
        this.f17687s = dVar.a(this.f17685q);
        f fVarD = bVar.d(i11);
        List<e> list = fVarD.f32069d;
        this.f17690v = list;
        Pair<TrackGroupArray, a[]> pairV = v(cVar, fVarD.f32068c, list);
        this.f17677i = (TrackGroupArray) pairV.first;
        this.f17678j = (a[]) pairV.second;
    }

    public static int[][] A(List<ic.a> list) {
        int iMin;
        ic.d dVarW;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i10 = 0; i10 < size; i10++) {
            sparseIntArray.put(list.get(i10).f32026a, i10);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i10));
            arrayList.add(arrayList2);
            sparseArray.put(i10, arrayList2);
        }
        for (int i11 = 0; i11 < size; i11++) {
            ic.a aVar = list.get(i11);
            ic.d dVarY = y(aVar.f32030e);
            if (dVarY == null) {
                dVarY = y(aVar.f32031f);
            }
            if (dVarY == null || (iMin = sparseIntArray.get(Integer.parseInt(dVarY.f32059b), -1)) == -1) {
                iMin = i11;
            }
            if (iMin == i11 && (dVarW = w(aVar.f32031f)) != null) {
                for (String str : u0.n1(dVarW.f32059b, ag.c.f654g)) {
                    int i12 = sparseIntArray.get(Integer.parseInt(str), -1);
                    if (i12 != -1) {
                        iMin = Math.min(iMin, i12);
                    }
                }
            }
            if (iMin != i11) {
                List list2 = (List) sparseArray.get(i11);
                List list3 = (List) sparseArray.get(iMin);
                list3.addAll(list2);
                sparseArray.put(i11, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i13 = 0; i13 < size2; i13++) {
            iArr[i13] = Ints.toArray((Collection) arrayList.get(i13));
            Arrays.sort(iArr[i13]);
        }
        return iArr;
    }

    public static boolean D(List<ic.a> list, int[] iArr) {
        for (int i10 : iArr) {
            List<i> list2 = list.get(i10).f32028c;
            for (int i11 = 0; i11 < list2.size(); i11++) {
                if (!list2.get(i11).f32085f.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int E(int i10, List<ic.a> list, int[][] iArr, boolean[] zArr, Format[][] formatArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            if (D(list, iArr[i12])) {
                zArr[i12] = true;
                i11++;
            }
            formatArr[i12] = z(list, iArr[i12]);
            if (formatArr[i12].length != 0) {
                i11++;
            }
        }
        return i11;
    }

    public static h<com.google.android.exoplayer2.source.dash.a>[] F(int i10) {
        return new h[i10];
    }

    public static Format[] H(ic.d dVar, Pattern pattern, Format format) {
        String str = dVar.f32059b;
        if (str == null) {
            return new Format[]{format};
        }
        String[] strArrN1 = u0.n1(str, ";");
        Format[] formatArr = new Format[strArrN1.length];
        for (int i10 = 0; i10 < strArrN1.length; i10++) {
            Matcher matcher = pattern.matcher(strArrN1[i10]);
            if (!matcher.matches()) {
                return new Format[]{format};
            }
            int i11 = Integer.parseInt(matcher.group(1));
            formatArr[i10] = format.a().S(format.f16687a + ":" + i11).F(i11).V(matcher.group(2)).E();
        }
        return formatArr;
    }

    public static void h(List<e> list, TrackGroup[] trackGroupArr, a[] aVarArr, int i10) {
        int i11 = 0;
        while (i11 < list.size()) {
            trackGroupArr[i10] = new TrackGroup(new Format.b().S(list.get(i11).a()).e0(w.f31219x0).E());
            aVarArr[i10] = a.c(i11);
            i11++;
            i10++;
        }
    }

    public static int o(com.google.android.exoplayer2.drm.c cVar, List<ic.a> list, int[][] iArr, int i10, boolean[] zArr, Format[][] formatArr, TrackGroup[] trackGroupArr, a[] aVarArr) {
        int i11;
        int i12;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i10) {
            int[] iArr2 = iArr[i13];
            ArrayList arrayList = new ArrayList();
            for (int i15 : iArr2) {
                arrayList.addAll(list.get(i15).f32028c);
            }
            int size = arrayList.size();
            Format[] formatArr2 = new Format[size];
            for (int i16 = 0; i16 < size; i16++) {
                Format format = ((i) arrayList.get(i16)).f32082c;
                formatArr2[i16] = format.g(cVar.b(format));
            }
            ic.a aVar = list.get(iArr2[0]);
            int i17 = i14 + 1;
            if (zArr[i13]) {
                i11 = i17 + 1;
            } else {
                i11 = i17;
                i17 = -1;
            }
            if (formatArr[i13].length != 0) {
                i12 = i11 + 1;
            } else {
                i12 = i11;
                i11 = -1;
            }
            trackGroupArr[i14] = new TrackGroup(formatArr2);
            aVarArr[i14] = a.d(aVar.f32027b, iArr2, i14, i17, i11);
            if (i17 != -1) {
                trackGroupArr[i17] = new TrackGroup(new Format.b().S(aVar.f32026a + ":emsg").e0(w.f31219x0).E());
                aVarArr[i17] = a.b(iArr2, i14);
            }
            if (i11 != -1) {
                trackGroupArr[i11] = new TrackGroup(formatArr[i13]);
                aVarArr[i11] = a.a(iArr2, i14);
            }
            i13++;
            i14 = i12;
        }
        return i14;
    }

    public static Pair<TrackGroupArray, a[]> v(com.google.android.exoplayer2.drm.c cVar, List<ic.a> list, List<e> list2) {
        int[][] iArrA = A(list);
        int length = iArrA.length;
        boolean[] zArr = new boolean[length];
        Format[][] formatArr = new Format[length][];
        int iE = E(length, list, iArrA, zArr, formatArr) + length + list2.size();
        TrackGroup[] trackGroupArr = new TrackGroup[iE];
        a[] aVarArr = new a[iE];
        h(list2, trackGroupArr, aVarArr, o(cVar, list, iArrA, length, zArr, formatArr, trackGroupArr, aVarArr));
        return Pair.create(new TrackGroupArray(trackGroupArr), aVarArr);
    }

    @p0
    public static ic.d w(List<ic.d> list) {
        return x(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    @p0
    public static ic.d x(List<ic.d> list, String str) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            ic.d dVar = list.get(i10);
            if (str.equals(dVar.f32058a)) {
                return dVar;
            }
        }
        return null;
    }

    @p0
    public static ic.d y(List<ic.d> list) {
        return x(list, "http://dashif.org/guidelines/trickmode");
    }

    public static Format[] z(List<ic.a> list, int[] iArr) {
        for (int i10 : iArr) {
            ic.a aVar = list.get(i10);
            List<ic.d> list2 = list.get(i10).f32029d;
            for (int i11 = 0; i11 < list2.size(); i11++) {
                ic.d dVar = list2.get(i11);
                if ("urn:scte:dash:cc:cea-608:2015".equals(dVar.f32058a)) {
                    return H(dVar, f17667w, new Format.b().e0(w.f31195l0).S(aVar.f32026a + ":cea608").E());
                }
                if ("urn:scte:dash:cc:cea-708:2015".equals(dVar.f32058a)) {
                    return H(dVar, f17668x, new Format.b().e0(w.f31197m0).S(aVar.f32026a + ":cea708").E());
                }
            }
        }
        return new Format[0];
    }

    public final int B(int i10, int[] iArr) {
        int i11 = iArr[i10];
        if (i11 == -1) {
            return -1;
        }
        int i12 = this.f17678j[i11].f17698e;
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            if (i14 == i12 && this.f17678j[i14].f17696c == 0) {
                return i13;
            }
        }
        return -1;
    }

    public final int[] C(com.google.android.exoplayer2.trackselection.b[] bVarArr) {
        int[] iArr = new int[bVarArr.length];
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            if (bVarArr[i10] != null) {
                iArr[i10] = this.f17677i.b(bVarArr[i10].a());
            } else {
                iArr[i10] = -1;
            }
        }
        return iArr;
    }

    @Override // com.google.android.exoplayer2.source.s.a
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void i(h<com.google.android.exoplayer2.source.dash.a> hVar) {
        this.f17684p.i(this);
    }

    public void I() {
        this.f17680l.o();
        for (h<com.google.android.exoplayer2.source.dash.a> hVar : this.f17685q) {
            hVar.Q(this);
        }
        this.f17684p = null;
    }

    public final void J(com.google.android.exoplayer2.trackselection.b[] bVarArr, boolean[] zArr, d0[] d0VarArr) {
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            if (bVarArr[i10] == null || !zArr[i10]) {
                if (d0VarArr[i10] instanceof h) {
                    ((h) d0VarArr[i10]).Q(this);
                } else if (d0VarArr[i10] instanceof h.a) {
                    ((h.a) d0VarArr[i10]).c();
                }
                d0VarArr[i10] = null;
            }
        }
    }

    public final void K(com.google.android.exoplayer2.trackselection.b[] bVarArr, d0[] d0VarArr, int[] iArr) {
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            if ((d0VarArr[i10] instanceof ec.h) || (d0VarArr[i10] instanceof h.a)) {
                int iB = B(i10, iArr);
                if (!(iB == -1 ? d0VarArr[i10] instanceof ec.h : (d0VarArr[i10] instanceof h.a) && ((h.a) d0VarArr[i10]).f29198a == d0VarArr[iB])) {
                    if (d0VarArr[i10] instanceof h.a) {
                        ((h.a) d0VarArr[i10]).c();
                    }
                    d0VarArr[i10] = null;
                }
            }
        }
    }

    public final void L(com.google.android.exoplayer2.trackselection.b[] bVarArr, d0[] d0VarArr, boolean[] zArr, long j10, int[] iArr) {
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            com.google.android.exoplayer2.trackselection.b bVar = bVarArr[i10];
            if (bVar != null) {
                if (d0VarArr[i10] == null) {
                    zArr[i10] = true;
                    a aVar = this.f17678j[iArr[i10]];
                    int i11 = aVar.f17696c;
                    if (i11 == 0) {
                        d0VarArr[i10] = t(aVar, bVar, j10);
                    } else if (i11 == 2) {
                        d0VarArr[i10] = new hc.h(this.f17690v.get(aVar.f17697d), bVar.a().a(0), this.f17688t.f32035d);
                    }
                } else if (d0VarArr[i10] instanceof h) {
                    ((com.google.android.exoplayer2.source.dash.a) ((h) d0VarArr[i10]).E()).b(bVar);
                }
            }
        }
        for (int i12 = 0; i12 < bVarArr.length; i12++) {
            if (d0VarArr[i12] == null && bVarArr[i12] != null) {
                a aVar2 = this.f17678j[iArr[i12]];
                if (aVar2.f17696c == 1) {
                    int iB = B(i12, iArr);
                    if (iB == -1) {
                        d0VarArr[i12] = new ec.h();
                    } else {
                        d0VarArr[i12] = ((h) d0VarArr[iB]).T(j10, aVar2.f17695b);
                    }
                }
            }
        }
    }

    public void M(ic.b bVar, int i10) {
        this.f17688t = bVar;
        this.f17689u = i10;
        this.f17680l.q(bVar);
        h<com.google.android.exoplayer2.source.dash.a>[] hVarArr = this.f17685q;
        if (hVarArr != null) {
            for (h<com.google.android.exoplayer2.source.dash.a> hVar : hVarArr) {
                ((com.google.android.exoplayer2.source.dash.a) hVar.E()).g(bVar, i10);
            }
            this.f17684p.i(this);
        }
        this.f17690v = bVar.d(i10).f32069d;
        for (hc.h hVar2 : this.f17686r) {
            Iterator<e> it2 = this.f17690v.iterator();
            while (true) {
                if (it2.hasNext()) {
                    e next = it2.next();
                    if (next.a().equals(hVar2.b())) {
                        hVar2.e(next, bVar.f32035d && i10 == bVar.e() - 1);
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long b() {
        return this.f17687s.b();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long c(long j10, t1 t1Var) {
        for (h<com.google.android.exoplayer2.source.dash.a> hVar : this.f17685q) {
            if (hVar.f29175a == 2) {
                return hVar.c(j10, t1Var);
            }
        }
        return j10;
    }

    @Override // gc.h.b
    public synchronized void d(h<com.google.android.exoplayer2.source.dash.a> hVar) {
        d.c cVarRemove = this.f17681m.remove(hVar);
        if (cVarRemove != null) {
            cVarRemove.n();
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean e(long j10) {
        return this.f17687s.e(j10);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long f() {
        return this.f17687s.f();
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public void g(long j10) {
        this.f17687s.g(j10);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean isLoading() {
        return this.f17687s.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.k
    public List<StreamKey> j(List<com.google.android.exoplayer2.trackselection.b> list) {
        List<ic.a> list2 = this.f17688t.d(this.f17689u).f32068c;
        ArrayList arrayList = new ArrayList();
        for (com.google.android.exoplayer2.trackselection.b bVar : list) {
            a aVar = this.f17678j[this.f17677i.b(bVar.a())];
            if (aVar.f17696c == 0) {
                int[] iArr = aVar.f17694a;
                int length = bVar.length();
                int[] iArr2 = new int[length];
                for (int i10 = 0; i10 < bVar.length(); i10++) {
                    iArr2[i10] = bVar.c(i10);
                }
                Arrays.sort(iArr2);
                int size = list2.get(iArr[0]).f32028c.size();
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 0; i13 < length; i13++) {
                    int i14 = iArr2[i13];
                    while (true) {
                        int i15 = i12 + size;
                        if (i14 >= i15) {
                            i11++;
                            size = list2.get(iArr[i11]).f32028c.size();
                            i12 = i15;
                        }
                    }
                    arrayList.add(new StreamKey(this.f17689u, iArr[i11], i14 - i12));
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void m() throws IOException {
        this.f17675g.a();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long n(long j10) {
        for (h<com.google.android.exoplayer2.source.dash.a> hVar : this.f17685q) {
            hVar.S(j10);
        }
        for (hc.h hVar2 : this.f17686r) {
            hVar2.c(j10);
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long p() {
        return g.f56663b;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void q(k.a aVar, long j10) {
        this.f17684p = aVar;
        aVar.l(this);
    }

    @Override // com.google.android.exoplayer2.source.k
    public TrackGroupArray r() {
        return this.f17677i;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long s(com.google.android.exoplayer2.trackselection.b[] bVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j10) {
        int[] iArrC = C(bVarArr);
        J(bVarArr, zArr, d0VarArr);
        K(bVarArr, d0VarArr, iArrC);
        L(bVarArr, d0VarArr, zArr2, j10, iArrC);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (d0 d0Var : d0VarArr) {
            if (d0Var instanceof h) {
                arrayList.add((h) d0Var);
            } else if (d0Var instanceof hc.h) {
                arrayList2.add((hc.h) d0Var);
            }
        }
        h<com.google.android.exoplayer2.source.dash.a>[] hVarArrF = F(arrayList.size());
        this.f17685q = hVarArrF;
        arrayList.toArray(hVarArrF);
        hc.h[] hVarArr = new hc.h[arrayList2.size()];
        this.f17686r = hVarArr;
        arrayList2.toArray(hVarArr);
        this.f17687s = this.f17679k.a(this.f17685q);
        return j10;
    }

    public final h<com.google.android.exoplayer2.source.dash.a> t(a aVar, com.google.android.exoplayer2.trackselection.b bVar, long j10) {
        TrackGroup trackGroupA;
        int i10;
        TrackGroup trackGroupA2;
        int i11;
        int i12 = aVar.f17699f;
        boolean z10 = i12 != -1;
        d.c cVarK = null;
        if (z10) {
            trackGroupA = this.f17677i.a(i12);
            i10 = 1;
        } else {
            trackGroupA = null;
            i10 = 0;
        }
        int i13 = aVar.f17700g;
        boolean z11 = i13 != -1;
        if (z11) {
            trackGroupA2 = this.f17677i.a(i13);
            i10 += trackGroupA2.f17498a;
        } else {
            trackGroupA2 = null;
        }
        Format[] formatArr = new Format[i10];
        int[] iArr = new int[i10];
        if (z10) {
            formatArr[0] = trackGroupA.a(0);
            iArr[0] = 5;
            i11 = 1;
        } else {
            i11 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z11) {
            for (int i14 = 0; i14 < trackGroupA2.f17498a; i14++) {
                formatArr[i11] = trackGroupA2.a(i14);
                iArr[i11] = 3;
                arrayList.add(formatArr[i11]);
                i11++;
            }
        }
        if (this.f17688t.f32035d && z10) {
            cVarK = this.f17680l.k();
        }
        d.c cVar = cVarK;
        h<com.google.android.exoplayer2.source.dash.a> hVar = new h<>(aVar.f17695b, iArr, formatArr, this.f17670b.a(this.f17675g, this.f17688t, this.f17689u, aVar.f17694a, bVar, aVar.f17695b, this.f17674f, z10, arrayList, cVar, this.f17671c), this, this.f17676h, j10, this.f17672d, this.f17683o, this.f17673e, this.f17682n);
        synchronized (this) {
            this.f17681m.put(hVar, cVar);
        }
        return hVar;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void u(long j10, boolean z10) {
        for (h<com.google.android.exoplayer2.source.dash.a> hVar : this.f17685q) {
            hVar.u(j10, z10);
        }
    }
}

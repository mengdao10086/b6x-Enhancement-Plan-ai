package com.google.android.exoplayer2.trackselection;

import ad.j;
import ad.k;
import android.util.Pair;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.l;
import g.p0;
import hd.u0;
import hd.w;
import java.util.Arrays;
import ya.p1;
import ya.q1;
import ya.r1;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public a f18627c;

    public static final class a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f18628h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f18629i = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f18630j = 2;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f18631k = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f18633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f18634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TrackGroupArray[] f18635d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f18636e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[][][] f18637f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TrackGroupArray f18638g;

        public a(String[] strArr, int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f18633b = strArr;
            this.f18634c = iArr;
            this.f18635d = trackGroupArrayArr;
            this.f18637f = iArr3;
            this.f18636e = iArr2;
            this.f18638g = trackGroupArray;
            this.f18632a = iArr.length;
        }

        public int a(int i10, int i11, boolean z10) {
            int i12 = this.f18635d[i10].a(i11).f17498a;
            int[] iArr = new int[i12];
            int i13 = 0;
            for (int i14 = 0; i14 < i12; i14++) {
                int iH = h(i10, i11, i14);
                if (iH == 4 || (z10 && iH == 3)) {
                    iArr[i13] = i14;
                    i13++;
                }
            }
            return b(i10, i11, Arrays.copyOf(iArr, i13));
        }

        public int b(int i10, int i11, int[] iArr) {
            int i12 = 0;
            String str = null;
            boolean z10 = false;
            int i13 = 0;
            int iMin = 16;
            while (i12 < iArr.length) {
                String str2 = this.f18635d[i10].a(i11).a(iArr[i12]).f16699l;
                int i14 = i13 + 1;
                if (i13 == 0) {
                    str = str2;
                } else {
                    z10 |= !u0.c(str, str2);
                }
                iMin = Math.min(iMin, p1.c(this.f18637f[i10][i11][i12]));
                i12++;
                i13 = i14;
            }
            return z10 ? Math.min(iMin, this.f18636e[i10]) : iMin;
        }

        public int c() {
            return this.f18632a;
        }

        public String d(int i10) {
            return this.f18633b[i10];
        }

        public int e(int i10) {
            int iMax = 0;
            for (int[] iArr : this.f18637f[i10]) {
                for (int i11 : iArr) {
                    int iD = p1.d(i11);
                    int i12 = 2;
                    if (iD == 0 || iD == 1 || iD == 2) {
                        i12 = 1;
                    } else if (iD != 3) {
                        if (iD == 4) {
                            return 3;
                        }
                        throw new IllegalStateException();
                    }
                    iMax = Math.max(iMax, i12);
                }
            }
            return iMax;
        }

        public int f(int i10) {
            return this.f18634c[i10];
        }

        public TrackGroupArray g(int i10) {
            return this.f18635d[i10];
        }

        public int h(int i10, int i11, int i12) {
            return p1.d(this.f18637f[i10][i11][i12]);
        }

        public int i(int i10) {
            int iMax = 0;
            for (int i11 = 0; i11 < this.f18632a; i11++) {
                if (this.f18634c[i11] == i10) {
                    iMax = Math.max(iMax, e(i11));
                }
            }
            return iMax;
        }

        public TrackGroupArray j() {
            return this.f18638g;
        }
    }

    public static int f(q1[] q1VarArr, TrackGroup trackGroup, int[] iArr, boolean z10) throws ExoPlaybackException {
        int length = q1VarArr.length;
        int i10 = 0;
        boolean z11 = true;
        for (int i11 = 0; i11 < q1VarArr.length; i11++) {
            q1 q1Var = q1VarArr[i11];
            int iMax = 0;
            for (int i12 = 0; i12 < trackGroup.f17498a; i12++) {
                iMax = Math.max(iMax, p1.d(q1Var.a(trackGroup.a(i12))));
            }
            boolean z12 = iArr[i11] == 0;
            if (iMax > i10 || (iMax == i10 && z10 && !z11 && z12)) {
                length = i11;
                z11 = z12;
                i10 = iMax;
            }
        }
        return length;
    }

    public static int[] h(q1 q1Var, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.f17498a];
        for (int i10 = 0; i10 < trackGroup.f17498a; i10++) {
            iArr[i10] = q1Var.a(trackGroup.a(i10));
        }
        return iArr;
    }

    public static int[] i(q1[] q1VarArr) throws ExoPlaybackException {
        int length = q1VarArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = q1VarArr[i10].p();
        }
        return iArr;
    }

    @Override // ad.j
    public final void d(@p0 Object obj) {
        this.f18627c = (a) obj;
    }

    @Override // ad.j
    public final k e(q1[] q1VarArr, TrackGroupArray trackGroupArray, l.a aVar, x1 x1Var) throws ExoPlaybackException {
        int[] iArr = new int[q1VarArr.length + 1];
        int length = q1VarArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr2 = new int[q1VarArr.length + 1][][];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = trackGroupArray.f17502a;
            trackGroupArr[i10] = new TrackGroup[i11];
            iArr2[i10] = new int[i11][];
        }
        int[] iArrI = i(q1VarArr);
        for (int i12 = 0; i12 < trackGroupArray.f17502a; i12++) {
            TrackGroup trackGroupA = trackGroupArray.a(i12);
            int iF = f(q1VarArr, trackGroupA, iArr, w.l(trackGroupA.a(0).f16699l) == 5);
            int[] iArrH = iF == q1VarArr.length ? new int[trackGroupA.f17498a] : h(q1VarArr[iF], trackGroupA);
            int i13 = iArr[iF];
            trackGroupArr[iF][i13] = trackGroupA;
            iArr2[iF][i13] = iArrH;
            iArr[iF] = iArr[iF] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[q1VarArr.length];
        String[] strArr = new String[q1VarArr.length];
        int[] iArr3 = new int[q1VarArr.length];
        for (int i14 = 0; i14 < q1VarArr.length; i14++) {
            int i15 = iArr[i14];
            trackGroupArrayArr[i14] = new TrackGroupArray((TrackGroup[]) u0.V0(trackGroupArr[i14], i15));
            iArr2[i14] = (int[][]) u0.V0(iArr2[i14], i15);
            strArr[i14] = q1VarArr[i14].getName();
            iArr3[i14] = q1VarArr[i14].h();
        }
        a aVar2 = new a(strArr, iArr3, trackGroupArrayArr, iArrI, iArr2, new TrackGroupArray((TrackGroup[]) u0.V0(trackGroupArr[q1VarArr.length], iArr[q1VarArr.length])));
        Pair<r1[], b[]> pairJ = j(aVar2, iArr2, iArrI, aVar, x1Var);
        return new k((r1[]) pairJ.first, (b[]) pairJ.second, aVar2);
    }

    @p0
    public final a g() {
        return this.f18627c;
    }

    public abstract Pair<r1[], b[]> j(a aVar, int[][][] iArr, int[] iArr2, l.a aVar2, x1 x1Var) throws ExoPlaybackException;
}

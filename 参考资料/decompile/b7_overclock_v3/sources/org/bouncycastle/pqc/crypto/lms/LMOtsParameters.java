package org.bouncycastle.pqc.crypto.lms;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class LMOtsParameters {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f45705h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final LMOtsParameters f45706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final LMOtsParameters f45707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final LMOtsParameters f45708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final LMOtsParameters f45709l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map<Object, LMOtsParameters> f45710m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f45712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f45713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f45714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f45715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f45716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final gm.y f45717g;

    static {
        gm.y yVar = kn.d.f37592c;
        f45706i = new LMOtsParameters(1, 32, 1, gg.b.f29505x, 7, 8516, yVar);
        f45707j = new LMOtsParameters(2, 32, 2, 133, 6, 4292, yVar);
        f45708k = new LMOtsParameters(3, 32, 4, 67, 4, 2180, yVar);
        f45709l = new LMOtsParameters(4, 32, 8, 34, 0, 1124, yVar);
        f45710m = new HashMap<Object, LMOtsParameters>() { // from class: org.bouncycastle.pqc.crypto.lms.LMOtsParameters.1
            {
                LMOtsParameters lMOtsParameters = LMOtsParameters.f45706i;
                put(Integer.valueOf(lMOtsParameters.f45711a), lMOtsParameters);
                LMOtsParameters lMOtsParameters2 = LMOtsParameters.f45707j;
                put(Integer.valueOf(lMOtsParameters2.f45711a), lMOtsParameters2);
                LMOtsParameters lMOtsParameters3 = LMOtsParameters.f45708k;
                put(Integer.valueOf(lMOtsParameters3.f45711a), lMOtsParameters3);
                LMOtsParameters lMOtsParameters4 = LMOtsParameters.f45709l;
                put(Integer.valueOf(lMOtsParameters4.f45711a), lMOtsParameters4);
            }
        };
    }

    public LMOtsParameters(int i10, int i11, int i12, int i13, int i14, int i15, gm.y yVar) {
        this.f45711a = i10;
        this.f45712b = i11;
        this.f45713c = i12;
        this.f45714d = i13;
        this.f45715e = i14;
        this.f45716f = i15;
        this.f45717g = yVar;
    }

    public static LMOtsParameters f(int i10) {
        return f45710m.get(Integer.valueOf(i10));
    }

    public gm.y b() {
        return this.f45717g;
    }

    public int c() {
        return this.f45715e;
    }

    public int d() {
        return this.f45712b;
    }

    public int e() {
        return this.f45714d;
    }

    public int g() {
        return this.f45716f;
    }

    public int h() {
        return this.f45711a;
    }

    public int i() {
        return this.f45713c;
    }
}

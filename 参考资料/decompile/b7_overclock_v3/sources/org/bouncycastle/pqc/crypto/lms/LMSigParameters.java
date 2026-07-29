package org.bouncycastle.pqc.crypto.lms;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class LMSigParameters {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LMSigParameters f45718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LMSigParameters f45719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LMSigParameters f45720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LMSigParameters f45721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final LMSigParameters f45722i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Map<Object, LMSigParameters> f45723j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f45725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f45726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gm.y f45727d;

    static {
        gm.y yVar = kn.d.f37592c;
        f45718e = new LMSigParameters(5, 32, 5, yVar);
        f45719f = new LMSigParameters(6, 32, 10, yVar);
        f45720g = new LMSigParameters(7, 32, 15, yVar);
        f45721h = new LMSigParameters(8, 32, 20, yVar);
        f45722i = new LMSigParameters(9, 32, 25, yVar);
        f45723j = new HashMap<Object, LMSigParameters>() { // from class: org.bouncycastle.pqc.crypto.lms.LMSigParameters.1
            {
                LMSigParameters lMSigParameters = LMSigParameters.f45718e;
                put(Integer.valueOf(lMSigParameters.f45724a), lMSigParameters);
                LMSigParameters lMSigParameters2 = LMSigParameters.f45719f;
                put(Integer.valueOf(lMSigParameters2.f45724a), lMSigParameters2);
                LMSigParameters lMSigParameters3 = LMSigParameters.f45720g;
                put(Integer.valueOf(lMSigParameters3.f45724a), lMSigParameters3);
                LMSigParameters lMSigParameters4 = LMSigParameters.f45721h;
                put(Integer.valueOf(lMSigParameters4.f45724a), lMSigParameters4);
                LMSigParameters lMSigParameters5 = LMSigParameters.f45722i;
                put(Integer.valueOf(lMSigParameters5.f45724a), lMSigParameters5);
            }
        };
    }

    public LMSigParameters(int i10, int i11, int i12, gm.y yVar) {
        this.f45724a = i10;
        this.f45725b = i11;
        this.f45726c = i12;
        this.f45727d = yVar;
    }

    public static LMSigParameters e(int i10) {
        return f45723j.get(Integer.valueOf(i10));
    }

    public gm.y b() {
        return this.f45727d;
    }

    public int c() {
        return this.f45726c;
    }

    public int d() {
        return this.f45725b;
    }

    public int f() {
        return this.f45724a;
    }
}

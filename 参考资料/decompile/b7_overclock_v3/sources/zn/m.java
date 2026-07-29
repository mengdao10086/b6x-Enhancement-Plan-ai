package zn;

import java.math.BigInteger;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes5.dex */
public class m extends gm.w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f58825b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f58826c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f58827d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f58828e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f58829f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f58830g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f58831h = 6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f58832i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f58833j = 9;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f58834k = 10;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f58835l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f58836m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f58837n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f58838o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f58839p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f58840q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f58841r = 6;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f58842s = 8;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f58843t = 9;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f58844u = 10;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String[] f58845v = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Hashtable f58846w = new Hashtable();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.k f58847a;

    public m(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Invalid CRL reason : not in (0..MAX)");
        }
        this.f58847a = new gm.k(i10);
    }

    public static m x(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return z(gm.k.I(obj).M());
        }
        return null;
    }

    public static m z(int i10) {
        Integer numG = org.bouncycastle.util.j.g(i10);
        Hashtable hashtable = f58846w;
        if (!hashtable.containsKey(numG)) {
            hashtable.put(numG, new m(i10));
        }
        return (m) hashtable.get(numG);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f58847a;
    }

    public String toString() {
        int iIntValue = y().intValue();
        return "CRLReason: " + ((iIntValue < 0 || iIntValue > 10) ? "invalid" : f58845v[iIntValue]);
    }

    public BigInteger y() {
        return this.f58847a.J();
    }
}

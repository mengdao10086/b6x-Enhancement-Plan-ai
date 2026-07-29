package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<Integer, w> f45954e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f45955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f45956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f45957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f45958d;

    static {
        HashMap map = new HashMap();
        Integer numG = org.bouncycastle.util.j.g(1);
        gm.y yVar = kn.d.f37592c;
        map.put(numG, new w(20, 2, yVar));
        map.put(org.bouncycastle.util.j.g(2), new w(20, 4, yVar));
        map.put(org.bouncycastle.util.j.g(3), new w(40, 2, yVar));
        map.put(org.bouncycastle.util.j.g(4), new w(40, 4, yVar));
        map.put(org.bouncycastle.util.j.g(5), new w(40, 8, yVar));
        map.put(org.bouncycastle.util.j.g(6), new w(60, 3, yVar));
        map.put(org.bouncycastle.util.j.g(7), new w(60, 6, yVar));
        map.put(org.bouncycastle.util.j.g(8), new w(60, 12, yVar));
        Integer numG2 = org.bouncycastle.util.j.g(9);
        gm.y yVar2 = kn.d.f37596e;
        map.put(numG2, new w(20, 2, yVar2));
        map.put(org.bouncycastle.util.j.g(10), new w(20, 4, yVar2));
        map.put(org.bouncycastle.util.j.g(11), new w(40, 2, yVar2));
        map.put(org.bouncycastle.util.j.g(12), new w(40, 4, yVar2));
        map.put(org.bouncycastle.util.j.g(13), new w(40, 8, yVar2));
        map.put(org.bouncycastle.util.j.g(14), new w(60, 3, yVar2));
        map.put(org.bouncycastle.util.j.g(15), new w(60, 6, yVar2));
        map.put(org.bouncycastle.util.j.g(16), new w(60, 12, yVar2));
        Integer numG3 = org.bouncycastle.util.j.g(17);
        gm.y yVar3 = kn.d.f37612m;
        map.put(numG3, new w(20, 2, yVar3));
        map.put(org.bouncycastle.util.j.g(18), new w(20, 4, yVar3));
        map.put(org.bouncycastle.util.j.g(19), new w(40, 2, yVar3));
        map.put(org.bouncycastle.util.j.g(20), new w(40, 4, yVar3));
        map.put(org.bouncycastle.util.j.g(21), new w(40, 8, yVar3));
        map.put(org.bouncycastle.util.j.g(22), new w(60, 3, yVar3));
        map.put(org.bouncycastle.util.j.g(23), new w(60, 6, yVar3));
        map.put(org.bouncycastle.util.j.g(24), new w(60, 12, yVar3));
        Integer numG4 = org.bouncycastle.util.j.g(25);
        gm.y yVar4 = kn.d.f37614n;
        map.put(numG4, new w(20, 2, yVar4));
        map.put(org.bouncycastle.util.j.g(26), new w(20, 4, yVar4));
        map.put(org.bouncycastle.util.j.g(27), new w(40, 2, yVar4));
        map.put(org.bouncycastle.util.j.g(28), new w(40, 4, yVar4));
        map.put(org.bouncycastle.util.j.g(29), new w(40, 8, yVar4));
        map.put(org.bouncycastle.util.j.g(30), new w(60, 3, yVar4));
        map.put(org.bouncycastle.util.j.g(31), new w(60, 6, yVar4));
        map.put(org.bouncycastle.util.j.g(32), new w(60, 12, yVar4));
        f45954e = Collections.unmodifiableMap(map);
    }

    public w(int i10, int i11, gm.y yVar) {
        this.f45957c = i10;
        this.f45958d = i11;
        this.f45956b = new d0(l(i10, i11), yVar);
        this.f45955a = a.c(e(), g(), i(), c(), a(), i11);
    }

    public w(int i10, int i11, org.bouncycastle.crypto.s sVar) {
        this(i10, i11, c.c(sVar.b()));
    }

    public static w k(int i10) {
        return f45954e.get(org.bouncycastle.util.j.g(i10));
    }

    public static int l(int i10, int i11) throws IllegalArgumentException {
        if (i10 < 2) {
            throw new IllegalArgumentException("totalHeight must be > 1");
        }
        if (i10 % i11 != 0) {
            throw new IllegalArgumentException("layers must divide totalHeight without remainder");
        }
        int i12 = i10 / i11;
        if (i12 != 1) {
            return i12;
        }
        throw new IllegalArgumentException("height / layers must be greater than 1");
    }

    public int a() {
        return this.f45957c;
    }

    public int b() {
        return this.f45958d;
    }

    public int c() {
        return this.f45956b.d();
    }

    public c0 d() {
        return this.f45955a;
    }

    public String e() {
        return this.f45956b.f();
    }

    public gm.y f() {
        return this.f45956b.g();
    }

    public int g() {
        return this.f45956b.h();
    }

    public h h() {
        return this.f45956b.i();
    }

    public int i() {
        return this.f45956b.j();
    }

    public d0 j() {
        return this.f45956b;
    }
}

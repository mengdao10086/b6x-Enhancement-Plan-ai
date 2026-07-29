package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class d0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<Integer, d0> f45836i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f45837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f45838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f45839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gm.y f45840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f45841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f45842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f45843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f45844h;

    static {
        HashMap map = new HashMap();
        Integer numG = org.bouncycastle.util.j.g(1);
        gm.y yVar = kn.d.f37592c;
        map.put(numG, new d0(10, yVar));
        map.put(org.bouncycastle.util.j.g(2), new d0(16, yVar));
        map.put(org.bouncycastle.util.j.g(3), new d0(20, yVar));
        Integer numG2 = org.bouncycastle.util.j.g(4);
        gm.y yVar2 = kn.d.f37596e;
        map.put(numG2, new d0(10, yVar2));
        map.put(org.bouncycastle.util.j.g(5), new d0(16, yVar2));
        map.put(org.bouncycastle.util.j.g(6), new d0(20, yVar2));
        Integer numG3 = org.bouncycastle.util.j.g(7);
        gm.y yVar3 = kn.d.f37612m;
        map.put(numG3, new d0(10, yVar3));
        map.put(org.bouncycastle.util.j.g(8), new d0(16, yVar3));
        map.put(org.bouncycastle.util.j.g(9), new d0(20, yVar3));
        Integer numG4 = org.bouncycastle.util.j.g(10);
        gm.y yVar4 = kn.d.f37614n;
        map.put(numG4, new d0(10, yVar4));
        map.put(org.bouncycastle.util.j.g(11), new d0(16, yVar4));
        map.put(org.bouncycastle.util.j.g(12), new d0(20, yVar4));
        f45836i = Collections.unmodifiableMap(map);
    }

    public d0(int i10, gm.y yVar) {
        if (i10 < 2) {
            throw new IllegalArgumentException("height must be >= 2");
        }
        Objects.requireNonNull(yVar, "digest == null");
        this.f45838b = i10;
        this.f45839c = a();
        String strB = c.b(yVar);
        this.f45842f = strB;
        this.f45840d = yVar;
        j jVar = new j(yVar);
        this.f45844h = jVar;
        int iF = jVar.f();
        this.f45843g = iF;
        int iG = jVar.g();
        this.f45841e = iG;
        this.f45837a = b.c(strB, iF, iG, jVar.a(), i10);
    }

    public d0(int i10, org.bouncycastle.crypto.s sVar) {
        this(i10, c.c(sVar.b()));
    }

    public static d0 k(int i10) {
        return f45836i.get(org.bouncycastle.util.j.g(i10));
    }

    public final int a() {
        int i10 = 2;
        while (true) {
            int i11 = this.f45838b;
            if (i10 > i11) {
                throw new IllegalStateException("should never happen...");
            }
            if ((i11 - i10) % 2 == 0) {
                return i10;
            }
            i10++;
        }
    }

    public int b() {
        return this.f45838b;
    }

    public int c() {
        return this.f45839c;
    }

    public int d() {
        return this.f45844h.a();
    }

    public c0 e() {
        return this.f45837a;
    }

    public String f() {
        return this.f45842f;
    }

    public gm.y g() {
        return this.f45840d;
    }

    public int h() {
        return this.f45843g;
    }

    public h i() {
        return new h(this.f45844h);
    }

    public int j() {
        return this.f45841e;
    }
}

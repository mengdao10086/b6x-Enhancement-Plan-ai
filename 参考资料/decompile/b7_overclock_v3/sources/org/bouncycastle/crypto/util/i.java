package org.bouncycastle.crypto.util;

import gm.d2;
import gm.y;
import java.util.HashMap;
import java.util.Map;
import pn.s;

/* JADX INFO: loaded from: classes5.dex */
public class i extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zn.b f44742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zn.b f44743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zn.b f44744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zn.b f44745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final zn.b f44746i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map f44747j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f44748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f44749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zn.b f44750d;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f44751a = 1024;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f44752b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public zn.b f44753c = i.f44742e;

        public i d() {
            return new i(this);
        }

        public b e(int i10) {
            this.f44751a = i10;
            return this;
        }

        public b f(zn.b bVar) {
            this.f44753c = bVar;
            return this;
        }

        public b g(int i10) {
            this.f44752b = i10;
            return this;
        }
    }

    static {
        y yVar = s.f46806g4;
        d2 d2Var = d2.f29657b;
        f44742e = new zn.b(yVar, d2Var);
        y yVar2 = s.f46812i4;
        f44743f = new zn.b(yVar2, d2Var);
        y yVar3 = s.f46818k4;
        f44744g = new zn.b(yVar3, d2Var);
        y yVar4 = kn.d.f37616p;
        f44745h = new zn.b(yVar4, d2Var);
        y yVar5 = kn.d.f37618r;
        f44746i = new zn.b(yVar5, d2Var);
        HashMap map = new HashMap();
        f44747j = map;
        map.put(yVar, org.bouncycastle.util.j.g(20));
        map.put(yVar2, org.bouncycastle.util.j.g(32));
        map.put(yVar3, org.bouncycastle.util.j.g(64));
        map.put(s.f46809h4, org.bouncycastle.util.j.g(28));
        map.put(s.f46815j4, org.bouncycastle.util.j.g(48));
        map.put(kn.d.f37615o, org.bouncycastle.util.j.g(28));
        map.put(yVar4, org.bouncycastle.util.j.g(32));
        map.put(kn.d.f37617q, org.bouncycastle.util.j.g(48));
        map.put(yVar5, org.bouncycastle.util.j.g(64));
        map.put(qm.a.f47453c, org.bouncycastle.util.j.g(32));
        map.put(qn.a.f47515e, org.bouncycastle.util.j.g(32));
        map.put(qn.a.f47516f, org.bouncycastle.util.j.g(64));
        map.put(xm.b.f55618c0, org.bouncycastle.util.j.g(32));
    }

    public i(b bVar) {
        super(s.X3);
        this.f44748b = bVar.f44751a;
        zn.b bVar2 = bVar.f44753c;
        this.f44750d = bVar2;
        this.f44749c = bVar.f44752b < 0 ? e(bVar2.x()) : bVar.f44752b;
    }

    public static int e(y yVar) {
        Map map = f44747j;
        if (map.containsKey(yVar)) {
            return ((Integer) map.get(yVar)).intValue();
        }
        throw new IllegalStateException("no salt size for algorithm: " + yVar);
    }

    public int b() {
        return this.f44748b;
    }

    public zn.b c() {
        return this.f44750d;
    }

    public int d() {
        return this.f44749c;
    }
}

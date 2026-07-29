package za;

import android.util.Base64;
import com.google.android.exoplayer2.source.l;
import com.google.common.base.Supplier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import ya.x1;
import za.h1;
import za.k1;

/* JADX INFO: loaded from: classes3.dex */
public final class j1 implements k1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Supplier<String> f58123h = new Supplier() { // from class: za.i1
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return j1.k();
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Random f58124i = new Random();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f58125j = 12;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x1.c f58126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x1.b f58127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, a> f58128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Supplier<String> f58129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k1.a f58130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x1 f58131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.p0
    public String f58132g;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f58133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f58134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f58135c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public l.a f58136d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f58137e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f58138f;

        public a(String str, int i10, @g.p0 l.a aVar) {
            this.f58133a = str;
            this.f58134b = i10;
            this.f58135c = aVar == null ? -1L : aVar.f26859d;
            if (aVar == null || !aVar.b()) {
                return;
            }
            this.f58136d = aVar;
        }

        public boolean i(int i10, @g.p0 l.a aVar) {
            if (aVar == null) {
                return i10 == this.f58134b;
            }
            l.a aVar2 = this.f58136d;
            return aVar2 == null ? !aVar.b() && aVar.f26859d == this.f58135c : aVar.f26859d == aVar2.f26859d && aVar.f26857b == aVar2.f26857b && aVar.f26858c == aVar2.f26858c;
        }

        public boolean j(h1.b bVar) {
            long j10 = this.f58135c;
            if (j10 == -1) {
                return false;
            }
            l.a aVar = bVar.f58102d;
            if (aVar == null) {
                return this.f58134b != bVar.f58101c;
            }
            if (aVar.f26859d > j10) {
                return true;
            }
            if (this.f58136d == null) {
                return false;
            }
            int iB = bVar.f58100b.b(aVar.f26856a);
            int iB2 = bVar.f58100b.b(this.f58136d.f26856a);
            l.a aVar2 = bVar.f58102d;
            if (aVar2.f26859d < this.f58136d.f26859d || iB < iB2) {
                return false;
            }
            if (iB > iB2) {
                return true;
            }
            if (!aVar2.b()) {
                int i10 = bVar.f58102d.f26860e;
                return i10 == -1 || i10 > this.f58136d.f26857b;
            }
            l.a aVar3 = bVar.f58102d;
            int i11 = aVar3.f26857b;
            int i12 = aVar3.f26858c;
            l.a aVar4 = this.f58136d;
            int i13 = aVar4.f26857b;
            return i11 > i13 || (i11 == i13 && i12 > aVar4.f26858c);
        }

        public void k(int i10, @g.p0 l.a aVar) {
            if (this.f58135c == -1 && i10 == this.f58134b && aVar != null) {
                this.f58135c = aVar.f26859d;
            }
        }

        public final int l(x1 x1Var, x1 x1Var2, int i10) {
            if (i10 >= x1Var.q()) {
                if (i10 < x1Var2.q()) {
                    return i10;
                }
                return -1;
            }
            x1Var.n(i10, j1.this.f58126a);
            for (int i11 = j1.this.f58126a.f57252m; i11 <= j1.this.f58126a.f57253n; i11++) {
                int iB = x1Var2.b(x1Var.m(i11));
                if (iB != -1) {
                    return x1Var2.f(iB, j1.this.f58127b).f57234c;
                }
            }
            return -1;
        }

        public boolean m(x1 x1Var, x1 x1Var2) {
            int iL = l(x1Var, x1Var2, this.f58134b);
            this.f58134b = iL;
            if (iL == -1) {
                return false;
            }
            l.a aVar = this.f58136d;
            return aVar == null || x1Var2.b(aVar.f26856a) != -1;
        }
    }

    public j1() {
        this(f58123h);
    }

    public static String k() {
        byte[] bArr = new byte[12];
        f58124i.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d7 A[Catch: all -> 0x010e, TryCatch #0 {, blocks: (B:4:0x0005, B:7:0x001b, B:9:0x0026, B:12:0x0030, B:19:0x0041, B:21:0x004d, B:22:0x0053, B:24:0x0057, B:26:0x005d, B:28:0x0076, B:30:0x00d1, B:32:0x00d7, B:34:0x00ed, B:36:0x00f9, B:38:0x00ff), top: B:44:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e9  */
    @Override // za.k1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(za.h1.b r25) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: za.j1.a(za.h1$b):void");
    }

    @Override // za.k1
    public void b(h1.b bVar) {
        k1.a aVar;
        this.f58132g = null;
        Iterator<a> it2 = this.f58128c.values().iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            it2.remove();
            if (next.f58137e && (aVar = this.f58130e) != null) {
                aVar.W(bVar, next.f58133a, false);
            }
        }
    }

    @Override // za.k1
    public synchronized void c(h1.b bVar) {
        hd.a.g(this.f58130e);
        x1 x1Var = this.f58131f;
        this.f58131f = bVar.f58100b;
        Iterator<a> it2 = this.f58128c.values().iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!next.m(x1Var, this.f58131f)) {
                it2.remove();
                if (next.f58137e) {
                    if (next.f58133a.equals(this.f58132g)) {
                        this.f58132g = null;
                    }
                    this.f58130e.W(bVar, next.f58133a, false);
                }
            }
        }
        g(bVar, 4);
    }

    @Override // za.k1
    public synchronized String d(x1 x1Var, l.a aVar) {
        return l(x1Var.h(aVar.f26856a, this.f58127b).f57234c, aVar).f58133a;
    }

    @Override // za.k1
    public synchronized boolean e(h1.b bVar, String str) {
        a aVar = this.f58128c.get(str);
        if (aVar == null) {
            return false;
        }
        aVar.k(bVar.f58101c, bVar.f58102d);
        return aVar.i(bVar.f58101c, bVar.f58102d);
    }

    @Override // za.k1
    public void f(k1.a aVar) {
        this.f58130e = aVar;
    }

    @Override // za.k1
    public synchronized void g(h1.b bVar, int i10) {
        hd.a.g(this.f58130e);
        boolean z10 = i10 == 0 || i10 == 3;
        Iterator<a> it2 = this.f58128c.values().iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (next.j(bVar)) {
                it2.remove();
                if (next.f58137e) {
                    boolean zEquals = next.f58133a.equals(this.f58132g);
                    boolean z11 = z10 && zEquals && next.f58138f;
                    if (zEquals) {
                        this.f58132g = null;
                    }
                    this.f58130e.W(bVar, next.f58133a, z11);
                }
            }
        }
        a aVar = this.f58128c.get(this.f58132g);
        a aVarL = l(bVar.f58101c, bVar.f58102d);
        this.f58132g = aVarL.f58133a;
        a(bVar);
        l.a aVar2 = bVar.f58102d;
        if (aVar2 != null && aVar2.b() && (aVar == null || aVar.f58135c != bVar.f58102d.f26859d || aVar.f58136d == null || aVar.f58136d.f26857b != bVar.f58102d.f26857b || aVar.f58136d.f26858c != bVar.f58102d.f26858c)) {
            l.a aVar3 = bVar.f58102d;
            this.f58130e.q(bVar, l(bVar.f58101c, new l.a(aVar3.f26856a, aVar3.f26859d)).f58133a, aVarL.f58133a);
        }
    }

    public final a l(int i10, @g.p0 l.a aVar) {
        a aVar2 = null;
        long j10 = Long.MAX_VALUE;
        for (a aVar3 : this.f58128c.values()) {
            aVar3.k(i10, aVar);
            if (aVar3.i(i10, aVar)) {
                long j11 = aVar3.f58135c;
                if (j11 == -1 || j11 < j10) {
                    aVar2 = aVar3;
                    j10 = j11;
                } else if (j11 == j10 && ((a) hd.u0.k(aVar2)).f58136d != null && aVar3.f58136d != null) {
                    aVar2 = aVar3;
                }
            }
        }
        if (aVar2 != null) {
            return aVar2;
        }
        String str = this.f58129d.get();
        a aVar4 = new a(str, i10, aVar);
        this.f58128c.put(str, aVar4);
        return aVar4;
    }

    public j1(Supplier<String> supplier) {
        this.f58129d = supplier;
        this.f58126a = new x1.c();
        this.f58127b = new x1.b();
        this.f58128c = new HashMap<>();
        this.f58131f = x1.f57231a;
    }
}

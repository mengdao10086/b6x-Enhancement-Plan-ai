package ob;

import g.p0;
import hd.c0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f43292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f43293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f43294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f43295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f43296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f43297f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f43304m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public p f43306o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f43308q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f43309r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f43310s;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f43298g = new long[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f43299h = new int[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f43300i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f43301j = new int[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long[] f43302k = new long[0];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean[] f43303l = new boolean[0];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean[] f43305n = new boolean[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c0 f43307p = new c0();

    public void a(hb.l lVar) throws IOException {
        lVar.readFully(this.f43307p.d(), 0, this.f43307p.f());
        this.f43307p.S(0);
        this.f43308q = false;
    }

    public void b(c0 c0Var) {
        c0Var.k(this.f43307p.d(), 0, this.f43307p.f());
        this.f43307p.S(0);
        this.f43308q = false;
    }

    public long c(int i10) {
        return this.f43302k[i10] + ((long) this.f43301j[i10]);
    }

    public void d(int i10) {
        this.f43307p.O(i10);
        this.f43304m = true;
        this.f43308q = true;
    }

    public void e(int i10, int i11) {
        this.f43296e = i10;
        this.f43297f = i11;
        if (this.f43299h.length < i10) {
            this.f43298g = new long[i10];
            this.f43299h = new int[i10];
        }
        if (this.f43300i.length < i11) {
            int i12 = (i11 * 125) / 100;
            this.f43300i = new int[i12];
            this.f43301j = new int[i12];
            this.f43302k = new long[i12];
            this.f43303l = new boolean[i12];
            this.f43305n = new boolean[i12];
        }
    }

    public void f() {
        this.f43296e = 0;
        this.f43309r = 0L;
        this.f43310s = false;
        this.f43304m = false;
        this.f43308q = false;
        this.f43306o = null;
    }

    public boolean g(int i10) {
        return this.f43304m && this.f43305n[i10];
    }
}

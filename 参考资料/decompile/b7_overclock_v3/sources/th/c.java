package th;

import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.R;
import g.d1;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<MimeType> f51292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f51293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f51294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d1
    public int f51295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f51296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f51297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f51298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f51299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f51300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<sh.a> f51301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f51302k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public th.a f51303l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f51304m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f51305n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f51306o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public qh.a f51307p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f51308q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ai.c f51309r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f51310s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f51311t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f51312u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ai.a f51313v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f51314w;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f51315a = new c();
    }

    public static c a() {
        c cVarB = b();
        cVarB.g();
        return cVarB;
    }

    public static c b() {
        return b.f51315a;
    }

    public boolean c() {
        return this.f51296e != -1;
    }

    public boolean d() {
        return this.f51294c && MimeType.ofGif().equals(this.f51292a);
    }

    public boolean e() {
        return this.f51294c && MimeType.ofImage().containsAll(this.f51292a);
    }

    public boolean f() {
        return this.f51294c && MimeType.ofVideo().containsAll(this.f51292a);
    }

    public final void g() {
        this.f51292a = null;
        this.f51293b = true;
        this.f51294c = false;
        this.f51295d = R.style.Matisse_Zhihu;
        this.f51296e = 0;
        this.f51297f = false;
        this.f51298g = 1;
        this.f51299h = 0;
        this.f51300i = 0;
        this.f51301j = null;
        this.f51302k = false;
        this.f51303l = null;
        this.f51304m = 3;
        this.f51305n = 0;
        this.f51306o = 0.5f;
        this.f51307p = new rh.a();
        this.f51308q = true;
        this.f51310s = false;
        this.f51311t = false;
        this.f51312u = Integer.MAX_VALUE;
        this.f51314w = true;
    }

    public boolean h() {
        if (!this.f51297f) {
            if (this.f51298g == 1) {
                return true;
            }
            if (this.f51299h == 1 && this.f51300i == 1) {
                return true;
            }
        }
        return false;
    }

    public c() {
    }
}

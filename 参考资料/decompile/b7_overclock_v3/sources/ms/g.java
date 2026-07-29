package ms;

import ft.a0;
import ft.x;
import ft.y;

/* JADX INFO: loaded from: classes6.dex */
public class g extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ft.h f41610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public y f41611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public x f41612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ft.e f41613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public y[] f41614i;

    public g(int i10, int i11, ft.h hVar, y yVar, ft.e eVar, x xVar, String str) {
        super(true, str);
        this.f41608c = i10;
        this.f41609d = i11;
        this.f41610e = hVar;
        this.f41611f = yVar;
        this.f41613h = eVar;
        this.f41612g = xVar;
        this.f41614i = new a0(hVar, yVar).c();
    }

    public g(int i10, int i11, ft.h hVar, y yVar, x xVar, String str) {
        this(i10, i11, hVar, yVar, ft.s.b(hVar, yVar), xVar, str);
    }

    public ft.h e() {
        return this.f41610e;
    }

    public y f() {
        return this.f41611f;
    }

    public ft.e g() {
        return this.f41613h;
    }

    public int h() {
        return this.f41609d;
    }

    public int i() {
        return this.f41608c;
    }

    public x j() {
        return this.f41612g;
    }

    public y[] k() {
        return this.f41614i;
    }

    public int l() {
        return this.f41611f.n();
    }
}

package ms;

import ft.s;
import ft.x;
import java.security.SecureRandom;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes6.dex */
public class c implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f41598n = "1.3.6.1.4.1.8301.3.1.3.4.2";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f41599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f41600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f41601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f41602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f41603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SecureRandom f41604l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f41605m = false;

    @Override // org.bouncycastle.crypto.d
    public void a(y yVar) {
        this.f41599g = (b) yVar;
        this.f41604l = yVar.a();
        this.f41600h = this.f41599g.c().b();
        this.f41601i = this.f41599g.c().c();
        this.f41602j = this.f41599g.c().d();
        this.f41603k = this.f41599g.c().a();
        this.f41605m = true;
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        if (!this.f41605m) {
            c();
        }
        ft.h hVar = new ft.h(this.f41600h, this.f41603k);
        ft.y yVar = new ft.y(hVar, this.f41602j, 'I', this.f41604l);
        s.a aVarA = ft.s.a(ft.s.b(hVar, yVar), this.f41604l);
        ft.e eVarC = aVarA.c();
        x xVarB = aVarA.b();
        ft.e eVar = (ft.e) eVarC.p();
        return new org.bouncycastle.crypto.c((np.c) new h(this.f41601i, this.f41602j, eVar, this.f41599g.c().e()), (np.c) new g(this.f41601i, eVar.d(), hVar, yVar, xVarB, this.f41599g.c().e()));
    }

    public final void c() {
        a(new b(null, new e()));
    }
}

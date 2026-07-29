package ms;

import ft.a0;
import ft.s;
import ft.x;
import java.security.SecureRandom;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes6.dex */
public class l implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f41637n = "1.3.6.1.4.1.8301.3.1.3.4.1";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k f41638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f41639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f41640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f41641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f41642k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SecureRandom f41643l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f41644m = false;

    @Override // org.bouncycastle.crypto.d
    public void a(y yVar) {
        d(yVar);
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        return c();
    }

    public final org.bouncycastle.crypto.c c() {
        if (!this.f41644m) {
            e();
        }
        ft.h hVar = new ft.h(this.f41639h, this.f41642k);
        ft.y yVar = new ft.y(hVar, this.f41641j, 'I', this.f41643l);
        new a0(hVar, yVar).c();
        s.a aVarA = ft.s.a(ft.s.b(hVar, yVar), this.f41643l);
        ft.e eVarC = aVarA.c();
        x xVarB = aVarA.b();
        ft.e eVar = (ft.e) eVarC.p();
        ft.e eVarR = eVar.r();
        int iD = eVar.d();
        ft.e[] eVarArrQ = ft.e.q(iD, this.f41643l);
        x xVar = new x(this.f41640i, this.f41643l);
        return new org.bouncycastle.crypto.c((np.c) new r(this.f41640i, this.f41641j, (ft.e) ((ft.e) eVarArrQ[0].g(eVarR)).h(xVar)), (np.c) new q(this.f41640i, iD, hVar, yVar, xVarB, xVar, eVarArrQ[1]));
    }

    public final void d(y yVar) {
        this.f41638g = (k) yVar;
        this.f41643l = yVar.a();
        this.f41639h = this.f41638g.c().b();
        this.f41640i = this.f41638g.c().c();
        this.f41641j = this.f41638g.c().d();
        this.f41642k = this.f41638g.c().a();
        this.f41644m = true;
    }

    public final void e() {
        d(new k(null, new o()));
    }
}

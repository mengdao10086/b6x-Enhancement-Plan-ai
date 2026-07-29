package k6;

import com.qualcomm.qti.libraries.gaia.GaiaException;
import java.io.File;
import jg.c;

/* JADX INFO: loaded from: classes7.dex */
public class k extends k6.a implements c.d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f37061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f37062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final jg.c f37063l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f37064m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f37065n;

    public interface a {
        boolean E(byte[] bArr, boolean z10);

        void F();

        void M(boolean z10);

        void P(double d10);

        void b(int i10);

        void e(int i10);

        void h(jg.b bVar);

        void v();

        void y();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte f37066a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final byte f37067b = 0;
    }

    public k(a aVar, int i10) {
        super(i10);
        this.f37061j = "UpgradeGaiaManager";
        this.f37064m = false;
        this.f37062k = aVar;
        this.f37065n = i10 == 1 ? 254 : 16;
        jg.c cVar = new jg.c(this);
        this.f37063l = cVar;
        cVar.N(false);
    }

    public void E() {
        this.f37063l.a();
    }

    public final void F(int i10) {
        try {
            l(hg.a.b(10, 16386, i10, null, n()));
        } catch (GaiaException e10) {
            e10.getMessage();
        }
    }

    public void G(boolean z10) {
        A(z10);
        this.f37063l.N(z10);
    }

    public void H() {
        R();
    }

    public int I() {
        return this.f37063l.e();
    }

    public boolean J() {
        return this.f37064m;
    }

    public boolean K() {
        return this.f37063l.g();
    }

    public void L() {
        if (this.f37063l.g()) {
            if (this.f37064m) {
                X(true);
            }
            P(18);
            T();
        }
    }

    public void M() {
        this.f37064m = false;
    }

    public void N() {
        this.f37063l.i();
    }

    public final boolean O(hg.a aVar) {
        byte[] bArrH = aVar.h();
        if (bArrH.length <= 0) {
            k(aVar, 5, null);
            return true;
        }
        if (aVar.g() != 18 || this.f37063l == null) {
            return false;
        }
        k(aVar, 0, null);
        byte[] bArr = new byte[bArrH.length - 1];
        System.arraycopy(bArrH, 1, bArr, 0, bArrH.length - 1);
        this.f37063l.u(bArr);
        return true;
    }

    public final void P(int i10) {
        try {
            l(hg.a.b(10, gg.b.E2, i10, null, n()));
        } catch (GaiaException e10) {
            e10.getMessage();
        }
    }

    public void Q(int i10, boolean z10) throws Throwable {
        if (this.f37063l.g()) {
            this.f37063l.A(i10, z10);
        }
    }

    public final void R() {
        l(new hg.b(10, gg.b.f29447i1));
    }

    public final void S(byte[] bArr) {
        l(new hg.b(10, gg.b.f29443h1, bArr));
    }

    public final void T() {
        l(C(1600));
    }

    public final void U(byte[] bArr, boolean z10) {
        if (!z10 || !this.f37064m) {
            l(D(gg.b.f29416a2, bArr));
            return;
        }
        hg.a aVarD = D(gg.b.f29416a2, bArr);
        try {
            if (this.f37062k.E(aVarD.d(), true)) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Fail to send GAIA packet for GAIA command: ");
            sb2.append(aVarD.f());
            r(aVarD);
        } catch (GaiaException e10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Exception when attempting to create GAIA packet: ");
            sb3.append(e10.toString());
        }
    }

    public final void V() {
        l(C(gg.b.Z1));
    }

    public void W(int i10) {
        this.f37065n = i10 - 4;
    }

    public void X(boolean z10) {
        this.f37064m = z10;
        S(new byte[]{z10 ? (byte) 1 : (byte) 0});
    }

    public void Y(File file) {
        if (this.f37063l.g()) {
            return;
        }
        P(18);
        this.f37063l.L(file);
        T();
    }

    @Override // jg.c.d
    public void b(int i10) {
        this.f37062k.b(i10);
    }

    @Override // jg.c.d
    public void c(int i10) {
        this.f37062k.e(i10);
    }

    @Override // jg.c.d
    public void d(jg.b bVar) {
        this.f37062k.h(bVar);
        int iA = bVar.a();
        if (iA == 1 || iA == 2 || iA == 3 || iA == 4) {
            this.f37063l.a();
        }
    }

    @Override // jg.c.d
    public void e() {
        this.f37062k.y();
        h();
    }

    @Override // jg.c.d
    public void f(byte[] bArr, boolean z10) {
        U(bArr, z10);
    }

    @Override // jg.c.d
    public void g(double d10) {
        this.f37062k.P(d10);
    }

    @Override // jg.c.d
    public void h() {
        F(18);
        V();
    }

    @Override // gg.c
    public void o(hg.a aVar) {
        if (aVar.e() == 557) {
            this.f37062k.F();
        } else if (aVar.e() == 558 || aVar.e() == 686) {
            this.f37062k.v();
        }
    }

    @Override // gg.c
    public boolean p(hg.a aVar) {
        if (aVar.e() != 16387) {
            return false;
        }
        return O(aVar);
    }

    @Override // gg.c
    public void r(hg.a aVar) {
    }

    @Override // gg.c
    public void t(hg.a aVar) throws Throwable {
        int iE = aVar.e();
        if (iE == 558) {
            this.f37062k.M(this.f37064m);
        }
        if (iE == 686) {
            boolean z10 = aVar.h()[1] == 1;
            this.f37064m = z10;
            this.f37062k.M(z10);
            return;
        }
        switch (iE) {
            case 1600:
                if (!this.f37063l.g()) {
                    int i10 = this.f37065n;
                    if (this.f37064m) {
                        i10--;
                        if (i10 % 2 != 0) {
                            i10--;
                        }
                    }
                    this.f37063l.Q(i10, J());
                } else {
                    this.f37063l.x();
                }
                break;
            case gg.b.Z1 /* 1601 */:
                this.f37063l.j();
                this.f37062k.F();
                break;
            case gg.b.f29416a2 /* 1602 */:
                this.f37063l.i();
                break;
        }
    }

    @Override // gg.c
    public void u(hg.a aVar) {
        if (aVar.e() == 1600 || aVar.e() == 1602) {
            V();
            return;
        }
        if (aVar.e() == 1601) {
            this.f37062k.F();
        } else if (aVar.e() == 558 || aVar.e() == 686) {
            this.f37064m = false;
            this.f37062k.v();
        }
    }

    @Override // gg.c
    public void v() {
        super.v();
    }

    @Override // gg.c
    public boolean y(byte[] bArr) {
        return this.f37062k.E(bArr, false);
    }
}

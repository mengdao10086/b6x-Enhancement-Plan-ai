package rm;

import gm.j2;
import gm.n2;
import gm.t;
import java.math.BigInteger;
import zn.b0;
import zn.c0;
import zn.s0;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f48876k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f48877l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f48878m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f48879n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f48880o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f48881p = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f48882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f48883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f48884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f48885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f48886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c0 f48887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s0 f48888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c0 f48889h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c0 f48890i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z f48891j;

    public h(g gVar) {
        this.f48882a = 1;
        this.f48884c = gVar;
        this.f48883b = gVar.G();
        this.f48882a = gVar.H();
        this.f48885d = gVar.C();
        this.f48886e = gVar.E();
        this.f48888g = gVar.D();
        this.f48889h = gVar.x();
        this.f48890i = gVar.y();
    }

    public h(m mVar) {
        this.f48882a = 1;
        this.f48883b = mVar;
    }

    public g a() {
        gm.i iVar = new gm.i(9);
        if (this.f48882a != 1) {
            iVar.a(new t(this.f48882a));
        }
        iVar.a(this.f48883b);
        if (this.f48885d != null) {
            iVar.a(new t(this.f48885d));
        }
        j jVar = this.f48886e;
        if (jVar != null) {
            iVar.a(jVar);
        }
        int[] iArr = {0, 1, 2, 3, 4};
        gm.h[] hVarArr = {this.f48887f, this.f48888g, this.f48889h, this.f48890i, this.f48891j};
        for (int i10 = 0; i10 < 5; i10++) {
            int i11 = iArr[i10];
            gm.h hVar = hVarArr[i10];
            if (hVar != null) {
                iVar.a(new n2(false, i11, hVar));
            }
        }
        return g.B(new j2(iVar));
    }

    public void b(b0 b0Var) {
        c(new c0(b0Var));
    }

    public void c(c0 c0Var) {
        this.f48889h = c0Var;
    }

    public void d(b0 b0Var) {
        e(new c0(b0Var));
    }

    public void e(c0 c0Var) {
        this.f48890i = c0Var;
    }

    public void f(z zVar) {
        if (this.f48884c != null) {
            throw new IllegalStateException("cannot change extensions in existing DVCSRequestInformation");
        }
        this.f48891j = zVar;
    }

    public void g(BigInteger bigInteger) {
        g gVar = this.f48884c;
        if (gVar != null) {
            if (gVar.C() == null) {
                this.f48885d = bigInteger;
            } else {
                byte[] byteArray = this.f48884c.C().toByteArray();
                byte[] bArrC = org.bouncycastle.util.b.c(bigInteger);
                byte[] bArr = new byte[byteArray.length + bArrC.length];
                System.arraycopy(byteArray, 0, bArr, 0, byteArray.length);
                System.arraycopy(bArrC, 0, bArr, byteArray.length, bArrC.length);
                this.f48885d = new BigInteger(bArr);
            }
        }
        this.f48885d = bigInteger;
    }

    public void h(s0 s0Var) {
        if (this.f48884c != null) {
            throw new IllegalStateException("cannot change request policy in existing DVCSRequestInformation");
        }
        this.f48888g = s0Var;
    }

    public void i(j jVar) {
        if (this.f48884c != null) {
            throw new IllegalStateException("cannot change request time in existing DVCSRequestInformation");
        }
        this.f48886e = jVar;
    }

    public void j(b0 b0Var) {
        k(new c0(b0Var));
    }

    public void k(c0 c0Var) {
        this.f48887f = c0Var;
    }

    public void l(int i10) {
        if (this.f48884c != null) {
            throw new IllegalStateException("cannot change version in existing DVCSRequestInformation");
        }
        this.f48882a = i10;
    }
}

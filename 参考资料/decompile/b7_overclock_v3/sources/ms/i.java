package ms;

import ft.x;
import ft.y;
import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes6.dex */
public class i implements js.e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f41618i = "1.3.6.1.4.1.8301.3.1.3.4.1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecureRandom f41619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f41623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f41624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m f41625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f41626h;

    @Override // js.e
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f41626h = z10;
        if (!z10) {
            q qVar = (q) kVar;
            this.f41625g = qVar;
            g(qVar);
        } else {
            if (!(kVar instanceof w1)) {
                this.f41619a = org.bouncycastle.crypto.n.f();
                r rVar = (r) kVar;
                this.f41625g = rVar;
                h(rVar);
                return;
            }
            w1 w1Var = (w1) kVar;
            this.f41619a = w1Var.b();
            r rVar2 = (r) w1Var.a();
            this.f41625g = rVar2;
            h(rVar2);
        }
    }

    @Override // js.e
    public byte[] b(byte[] bArr) throws InvalidCipherTextException {
        if (this.f41626h) {
            throw new IllegalStateException("cipher initialised for decryption");
        }
        ft.g gVarF = ft.g.f(this.f41620b, bArr);
        q qVar = (q) this.f41625g;
        ft.h hVarE = qVar.e();
        y yVarF = qVar.f();
        ft.e eVarM = qVar.m();
        x xVarJ = qVar.j();
        x xVarK = qVar.k();
        ft.e eVarG = qVar.g();
        y[] yVarArrL = qVar.l();
        x xVarE = xVarJ.e(xVarK);
        ft.g gVar = (ft.g) gVarF.e(xVarE.a());
        ft.g gVarC = ft.s.c((ft.g) eVarG.i(gVar), hVarE, yVarF, yVarArrL);
        ft.g gVar2 = (ft.g) ((ft.g) gVar.a(gVarC)).e(xVarJ);
        return d((ft.g) eVarM.f(gVar2.h(this.f41621c)));
    }

    @Override // js.e
    public byte[] c(byte[] bArr) {
        if (!this.f41626h) {
            throw new IllegalStateException("cipher initialised for decryption");
        }
        ft.g gVarE = e(bArr);
        return ((ft.g) ((r) this.f41625g).e().f(gVarE).a(new ft.g(this.f41620b, this.f41622d, this.f41619a))).b();
    }

    public final byte[] d(ft.g gVar) throws InvalidCipherTextException {
        byte[] bArrB = gVar.b();
        int length = bArrB.length - 1;
        while (length >= 0 && bArrB[length] == 0) {
            length--;
        }
        if (length < 0 || bArrB[length] != 1) {
            throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
        }
        byte[] bArr = new byte[length];
        System.arraycopy(bArrB, 0, bArr, 0, length);
        return bArr;
    }

    public final ft.g e(byte[] bArr) {
        byte[] bArr2 = new byte[this.f41623e + ((this.f41621c & 7) != 0 ? 1 : 0)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        bArr2[bArr.length] = 1;
        return ft.g.f(this.f41621c, bArr2);
    }

    public int f(m mVar) {
        if (mVar instanceof r) {
            return ((r) mVar).g();
        }
        if (mVar instanceof q) {
            return ((q) mVar).i();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    public final void g(q qVar) {
        this.f41620b = qVar.i();
        int iH = qVar.h();
        this.f41621c = iH;
        this.f41623e = iH >> 3;
        this.f41624f = this.f41620b >> 3;
    }

    public final void h(r rVar) {
        this.f41620b = rVar.g();
        this.f41621c = rVar.f();
        this.f41622d = rVar.h();
        this.f41624f = this.f41620b >> 3;
        this.f41623e = this.f41621c >> 3;
    }
}

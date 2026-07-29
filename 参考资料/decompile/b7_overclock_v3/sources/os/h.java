package os;

import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.n;

/* JADX INFO: loaded from: classes6.dex */
public class h implements js.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f46220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f46221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f46222c;

    @Override // js.f
    public void a(boolean z10, k kVar) {
        int iE;
        if (z10) {
            if (kVar instanceof w1) {
                w1 w1Var = (w1) kVar;
                this.f46222c = w1Var.b();
                this.f46221b = (e) w1Var.a();
            } else {
                this.f46222c = n.f();
                this.f46221b = (e) kVar;
            }
            this.f46220a = null;
            iE = this.f46221b.e();
        } else {
            this.f46221b = null;
            f fVar = (f) kVar;
            this.f46220a = fVar;
            iE = fVar.e();
        }
        g.e(iE);
    }

    @Override // js.f
    public byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[g.d(this.f46221b.e())];
        int iE = this.f46221b.e();
        if (iE == 5) {
            i.m(bArr2, bArr, 0, bArr.length, this.f46221b.d(), this.f46222c);
        } else {
            if (iE != 6) {
                throw new IllegalArgumentException("unknown security category: " + this.f46221b.e());
            }
            j.n(bArr2, bArr, 0, bArr.length, this.f46221b.d(), this.f46222c);
        }
        return bArr2;
    }

    @Override // js.f
    public boolean d(byte[] bArr, byte[] bArr2) {
        int iU;
        int iE = this.f46220a.e();
        if (iE == 5) {
            iU = i.u(bArr, bArr2, 0, bArr2.length, this.f46220a.d());
        } else {
            if (iE != 6) {
                throw new IllegalArgumentException("unknown security category: " + this.f46220a.e());
            }
            iU = j.v(bArr, bArr2, 0, bArr2.length, this.f46220a.d());
        }
        return iU == 0;
    }
}

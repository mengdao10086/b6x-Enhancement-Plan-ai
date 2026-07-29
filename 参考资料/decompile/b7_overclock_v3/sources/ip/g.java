package ip;

import np.n1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class g implements a0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f35493f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zo.f f35494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f35495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f35496c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f35497d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f35498e;

    public g(int i10) {
        this.f35494a = new zo.f(i10);
        this.f35495b = i10 / 8;
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        this.f35496c = null;
        reset();
        if (!(kVar instanceof n1)) {
            throw new IllegalArgumentException("Bad parameter passed");
        }
        byte[] bArrA = ((n1) kVar).a();
        this.f35497d = new byte[bArrA.length];
        this.f35496c = f(bArrA);
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f35497d;
            if (i10 >= bArr.length) {
                zo.f fVar = this.f35494a;
                byte[] bArr2 = this.f35496c;
                fVar.update(bArr2, 0, bArr2.length);
                return;
            }
            bArr[i10] = (byte) (~bArrA[i10]);
            i10++;
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return "DSTU7564Mac";
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        if (this.f35496c == null) {
            throw new IllegalStateException(b() + " not initialised");
        }
        if (bArr.length - i10 < this.f35495b) {
            throw new OutputLengthException("Output buffer too short");
        }
        e();
        zo.f fVar = this.f35494a;
        byte[] bArr2 = this.f35497d;
        fVar.update(bArr2, 0, bArr2.length);
        this.f35498e = 0L;
        int iC = this.f35494a.c(bArr, i10);
        reset();
        return iC;
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35495b;
    }

    public final void e() {
        int iG = this.f35494a.g() - ((int) (this.f35498e % ((long) this.f35494a.g())));
        if (iG < 13) {
            iG += this.f35494a.g();
        }
        byte[] bArr = new byte[iG];
        bArr[0] = -128;
        org.bouncycastle.util.o.F(this.f35498e * 8, bArr, iG - 12);
        this.f35494a.update(bArr, 0, iG);
    }

    public final byte[] f(byte[] bArr) {
        int length = (((bArr.length + this.f35494a.g()) - 1) / this.f35494a.g()) * this.f35494a.g();
        if (length - bArr.length < 13) {
            length += this.f35494a.g();
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        bArr2[bArr.length] = -128;
        org.bouncycastle.util.o.m(bArr.length * 8, bArr2, length - 12);
        return bArr2;
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        this.f35498e = 0L;
        this.f35494a.reset();
        byte[] bArr = this.f35496c;
        if (bArr != null) {
            this.f35494a.update(bArr, 0, bArr.length);
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) throws IllegalStateException {
        this.f35494a.update(b10);
        this.f35498e++;
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) throws IllegalStateException, DataLengthException {
        if (bArr.length - i10 < i11) {
            throw new DataLengthException("Input buffer too short");
        }
        if (this.f35496c != null) {
            this.f35494a.update(bArr, i10, i11);
            this.f35498e += (long) i11;
        } else {
            throw new IllegalStateException(b() + " not initialised");
        }
    }
}

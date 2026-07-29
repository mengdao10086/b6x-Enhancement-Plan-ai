package ip;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f35547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f35548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f35549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f35550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public org.bouncycastle.crypto.f f35551e;

    public o(org.bouncycastle.crypto.f fVar, int i10) {
        this.f35551e = fVar;
        this.f35550d = i10 / 8;
        this.f35547a = new byte[fVar.c()];
        this.f35548b = new byte[fVar.c()];
        this.f35549c = new byte[fVar.c()];
    }

    public String a() {
        return this.f35551e.b() + "/CFB" + (this.f35550d * 8);
    }

    public int b() {
        return this.f35550d;
    }

    public void c(byte[] bArr) {
        this.f35551e.d(this.f35548b, 0, bArr, 0);
    }

    public void d(org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.f fVar;
        if (kVar instanceof v1) {
            v1 v1Var = (v1) kVar;
            byte[] bArrA = v1Var.a();
            int length = bArrA.length;
            byte[] bArr = this.f35547a;
            if (length < bArr.length) {
                System.arraycopy(bArrA, 0, bArr, bArr.length - bArrA.length, bArrA.length);
            } else {
                System.arraycopy(bArrA, 0, bArr, 0, bArr.length);
            }
            f();
            fVar = this.f35551e;
            kVar = v1Var.b();
        } else {
            f();
            fVar = this.f35551e;
        }
        fVar.a(true, kVar);
    }

    public int e(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        int i12 = this.f35550d;
        if (i10 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        this.f35551e.d(this.f35548b, 0, this.f35549c, 0);
        int i13 = 0;
        while (true) {
            int i14 = this.f35550d;
            if (i13 >= i14) {
                byte[] bArr3 = this.f35548b;
                System.arraycopy(bArr3, i14, bArr3, 0, bArr3.length - i14);
                byte[] bArr4 = this.f35548b;
                int length = bArr4.length;
                int i15 = this.f35550d;
                System.arraycopy(bArr2, i11, bArr4, length - i15, i15);
                return this.f35550d;
            }
            bArr2[i11 + i13] = (byte) (this.f35549c[i13] ^ bArr[i10 + i13]);
            i13++;
        }
    }

    public void f() {
        byte[] bArr = this.f35547a;
        System.arraycopy(bArr, 0, this.f35548b, 0, bArr.length);
        this.f35551e.reset();
    }
}

package cp;

/* JADX INFO: loaded from: classes5.dex */
public class o extends f1 {
    @Override // cp.f1, org.bouncycastle.crypto.k0
    public String b() {
        return "ChaCha7539";
    }

    @Override // cp.f1
    public void c() {
        int[] iArr = this.f25292c;
        int i10 = iArr[12] + 1;
        iArr[12] = i10;
        if (i10 == 0) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
    }

    @Override // cp.f1
    public void d(long j10) {
        int i10 = (int) j10;
        if (((int) (j10 >>> 32)) > 0) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
        int[] iArr = this.f25292c;
        int i11 = iArr[12];
        iArr[12] = iArr[12] + i10;
        if (i11 != 0 && iArr[12] < i11) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
    }

    @Override // cp.f1
    public void h(byte[] bArr) {
        p.t(this.f25290a, this.f25292c, this.f25293d);
        org.bouncycastle.util.o.o(this.f25293d, bArr, 0);
    }

    @Override // cp.f1
    public long i() {
        return ((long) this.f25292c[12]) & 4294967295L;
    }

    @Override // cp.f1
    public int j() {
        return 12;
    }

    @Override // cp.f1
    public void n() {
        this.f25292c[12] = 0;
    }

    @Override // cp.f1
    public void p() {
        int[] iArr = this.f25292c;
        if (iArr[12] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        iArr[12] = iArr[12] - 1;
    }

    @Override // cp.f1
    public void q(long j10) {
        int i10 = (int) j10;
        if (((int) (j10 >>> 32)) != 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int[] iArr = this.f25292c;
        if ((((long) iArr[12]) & 4294967295L) < (4294967295L & ((long) i10))) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        iArr[12] = iArr[12] - i10;
    }

    @Override // cp.f1
    public void s(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length != 32) {
                throw new IllegalArgumentException(b() + " requires 256 bit key");
            }
            m(bArr.length, this.f25292c, 0);
            org.bouncycastle.util.o.t(bArr, 0, this.f25292c, 4, 8);
        }
        org.bouncycastle.util.o.t(bArr2, 0, this.f25292c, 13, 3);
    }
}

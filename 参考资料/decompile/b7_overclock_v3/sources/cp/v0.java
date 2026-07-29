package cp;

import np.w1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class v0 implements org.bouncycastle.crypto.l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.f f25707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public np.n1 f25709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f25711e;

    public v0(org.bouncycastle.crypto.f fVar) {
        this(fVar, false);
    }

    public v0(org.bouncycastle.crypto.f fVar, boolean z10) {
        this.f25711e = new byte[]{-90, -90, -90, -90, -90, -90, -90, -90};
        this.f25707a = fVar;
        this.f25708b = !z10;
    }

    @Override // org.bouncycastle.crypto.l0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f25710d = z10;
        if (kVar instanceof w1) {
            kVar = ((w1) kVar).a();
        }
        if (kVar instanceof np.n1) {
            this.f25709c = (np.n1) kVar;
            return;
        }
        if (kVar instanceof np.v1) {
            np.v1 v1Var = (np.v1) kVar;
            this.f25711e = v1Var.a();
            this.f25709c = (np.n1) v1Var.b();
            if (this.f25711e.length != 8) {
                throw new IllegalArgumentException("IV not equal to 8");
            }
        }
    }

    @Override // org.bouncycastle.crypto.l0
    public String b() {
        return this.f25707a.b();
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] c(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.f25710d) {
            throw new IllegalStateException("not set for unwrapping");
        }
        int i12 = i11 / 8;
        if (i12 * 8 != i11) {
            throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
        }
        byte[] bArr2 = this.f25711e;
        byte[] bArr3 = new byte[i11 - bArr2.length];
        byte[] bArr4 = new byte[bArr2.length];
        byte[] bArr5 = new byte[bArr2.length + 8];
        System.arraycopy(bArr, i10, bArr4, 0, bArr2.length);
        byte[] bArr6 = this.f25711e;
        System.arraycopy(bArr, i10 + bArr6.length, bArr3, 0, i11 - bArr6.length);
        this.f25707a.a(!this.f25708b, this.f25709c);
        int i13 = i12 - 1;
        for (int i14 = 5; i14 >= 0; i14--) {
            for (int i15 = i13; i15 >= 1; i15--) {
                System.arraycopy(bArr4, 0, bArr5, 0, this.f25711e.length);
                int i16 = (i15 - 1) * 8;
                System.arraycopy(bArr3, i16, bArr5, this.f25711e.length, 8);
                int i17 = (i13 * i14) + i15;
                int i18 = 1;
                while (i17 != 0) {
                    int length = this.f25711e.length - i18;
                    bArr5[length] = (byte) (((byte) i17) ^ bArr5[length]);
                    i17 >>>= 8;
                    i18++;
                }
                this.f25707a.d(bArr5, 0, bArr5, 0);
                System.arraycopy(bArr5, 0, bArr4, 0, 8);
                System.arraycopy(bArr5, 8, bArr3, i16, 8);
            }
        }
        if (org.bouncycastle.util.a.I(bArr4, this.f25711e)) {
            return bArr3;
        }
        throw new InvalidCipherTextException("checksum failed");
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] d(byte[] bArr, int i10, int i11) {
        if (!this.f25710d) {
            throw new IllegalStateException("not set for wrapping");
        }
        int i12 = i11 / 8;
        if (i12 * 8 != i11) {
            throw new DataLengthException("wrap data must be a multiple of 8 bytes");
        }
        byte[] bArr2 = this.f25711e;
        byte[] bArr3 = new byte[bArr2.length + i11];
        byte[] bArr4 = new byte[bArr2.length + 8];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i10, bArr3, this.f25711e.length, i11);
        this.f25707a.a(this.f25708b, this.f25709c);
        for (int i13 = 0; i13 != 6; i13++) {
            for (int i14 = 1; i14 <= i12; i14++) {
                System.arraycopy(bArr3, 0, bArr4, 0, this.f25711e.length);
                int i15 = i14 * 8;
                System.arraycopy(bArr3, i15, bArr4, this.f25711e.length, 8);
                this.f25707a.d(bArr4, 0, bArr4, 0);
                int i16 = (i12 * i13) + i14;
                int i17 = 1;
                while (i16 != 0) {
                    int length = this.f25711e.length - i17;
                    bArr4[length] = (byte) (((byte) i16) ^ bArr4[length]);
                    i16 >>>= 8;
                    i17++;
                }
                System.arraycopy(bArr4, 0, bArr3, 0, 8);
                System.arraycopy(bArr4, 8, bArr3, i15, 8);
            }
        }
        return bArr3;
    }
}

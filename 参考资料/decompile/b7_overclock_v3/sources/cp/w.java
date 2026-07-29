package cp;

import java.util.ArrayList;
import np.w1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class w implements org.bouncycastle.crypto.l0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25712h = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f25714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f25715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f25716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f25717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f25718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<byte[]> f25719g;

    public w(int i10) {
        v vVar = new v(i10);
        this.f25714b = vVar;
        this.f25715c = new byte[vVar.c() / 2];
        this.f25717e = new byte[this.f25714b.c()];
        this.f25718f = new byte[this.f25714b.c()];
        this.f25719g = new ArrayList<>();
        this.f25716d = new byte[4];
    }

    @Override // org.bouncycastle.crypto.l0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof w1) {
            kVar = ((w1) kVar).a();
        }
        this.f25713a = z10;
        if (!(kVar instanceof np.n1)) {
            throw new IllegalArgumentException("invalid parameters passed to DSTU7624WrapEngine");
        }
        this.f25714b.a(z10, kVar);
    }

    @Override // org.bouncycastle.crypto.l0
    public String b() {
        return "DSTU7624WrapEngine";
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] c(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.f25713a) {
            throw new IllegalStateException("not set for unwrapping");
        }
        if (i11 % this.f25714b.c() != 0) {
            throw new DataLengthException("unwrap data must be a multiple of " + this.f25714b.c() + " bytes");
        }
        int iC = (i11 * 2) / this.f25714b.c();
        int i12 = iC - 1;
        int i13 = i12 * 6;
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        byte[] bArr3 = new byte[this.f25714b.c() / 2];
        System.arraycopy(bArr2, 0, bArr3, 0, this.f25714b.c() / 2);
        this.f25719g.clear();
        int iC2 = i11 - (this.f25714b.c() / 2);
        int iC3 = this.f25714b.c() / 2;
        while (iC2 != 0) {
            byte[] bArr4 = new byte[this.f25714b.c() / 2];
            System.arraycopy(bArr2, iC3, bArr4, 0, this.f25714b.c() / 2);
            this.f25719g.add(bArr4);
            iC2 -= this.f25714b.c() / 2;
            iC3 += this.f25714b.c() / 2;
        }
        for (int i14 = 0; i14 < i13; i14++) {
            System.arraycopy(this.f25719g.get(iC - 2), 0, bArr2, 0, this.f25714b.c() / 2);
            System.arraycopy(bArr3, 0, bArr2, this.f25714b.c() / 2, this.f25714b.c() / 2);
            e(i13 - i14, this.f25716d, 0);
            for (int i15 = 0; i15 < 4; i15++) {
                int iC4 = (this.f25714b.c() / 2) + i15;
                bArr2[iC4] = (byte) (bArr2[iC4] ^ this.f25716d[i15]);
            }
            this.f25714b.d(bArr2, 0, bArr2, 0);
            System.arraycopy(bArr2, 0, bArr3, 0, this.f25714b.c() / 2);
            for (int i16 = 2; i16 < iC; i16++) {
                int i17 = iC - i16;
                System.arraycopy(this.f25719g.get(i17 - 1), 0, this.f25719g.get(i17), 0, this.f25714b.c() / 2);
            }
            System.arraycopy(bArr2, this.f25714b.c() / 2, this.f25719g.get(0), 0, this.f25714b.c() / 2);
        }
        System.arraycopy(bArr3, 0, bArr2, 0, this.f25714b.c() / 2);
        int iC5 = this.f25714b.c() / 2;
        for (int i18 = 0; i18 < i12; i18++) {
            System.arraycopy(this.f25719g.get(i18), 0, bArr2, iC5, this.f25714b.c() / 2);
            iC5 += this.f25714b.c() / 2;
        }
        System.arraycopy(bArr2, i11 - this.f25714b.c(), this.f25717e, 0, this.f25714b.c());
        byte[] bArr5 = new byte[i11 - this.f25714b.c()];
        if (!org.bouncycastle.util.a.g(this.f25717e, this.f25718f)) {
            throw new InvalidCipherTextException("checksum failed");
        }
        System.arraycopy(bArr2, 0, bArr5, 0, i11 - this.f25714b.c());
        return bArr5;
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] d(byte[] bArr, int i10, int i11) {
        if (!this.f25713a) {
            throw new IllegalStateException("not set for wrapping");
        }
        if (i11 % this.f25714b.c() != 0) {
            throw new DataLengthException("wrap data must be a multiple of " + this.f25714b.c() + " bytes");
        }
        if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        int iC = ((i11 / this.f25714b.c()) + 1) * 2;
        int i12 = iC - 1;
        int i13 = i12 * 6;
        int iC2 = this.f25714b.c() + i11;
        byte[] bArr2 = new byte[iC2];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        System.arraycopy(bArr2, 0, this.f25715c, 0, this.f25714b.c() / 2);
        this.f25719g.clear();
        int iC3 = iC2 - (this.f25714b.c() / 2);
        int iC4 = this.f25714b.c() / 2;
        while (iC3 != 0) {
            byte[] bArr3 = new byte[this.f25714b.c() / 2];
            System.arraycopy(bArr2, iC4, bArr3, 0, this.f25714b.c() / 2);
            this.f25719g.add(bArr3);
            iC3 -= this.f25714b.c() / 2;
            iC4 += this.f25714b.c() / 2;
        }
        int i14 = 0;
        while (i14 < i13) {
            System.arraycopy(this.f25715c, 0, bArr2, 0, this.f25714b.c() / 2);
            System.arraycopy(this.f25719g.get(0), 0, bArr2, this.f25714b.c() / 2, this.f25714b.c() / 2);
            this.f25714b.d(bArr2, 0, bArr2, 0);
            i14++;
            e(i14, this.f25716d, 0);
            for (int i15 = 0; i15 < 4; i15++) {
                int iC5 = (this.f25714b.c() / 2) + i15;
                bArr2[iC5] = (byte) (bArr2[iC5] ^ this.f25716d[i15]);
            }
            System.arraycopy(bArr2, this.f25714b.c() / 2, this.f25715c, 0, this.f25714b.c() / 2);
            for (int i16 = 2; i16 < iC; i16++) {
                System.arraycopy(this.f25719g.get(i16 - 1), 0, this.f25719g.get(i16 - 2), 0, this.f25714b.c() / 2);
            }
            System.arraycopy(bArr2, 0, this.f25719g.get(iC - 2), 0, this.f25714b.c() / 2);
        }
        System.arraycopy(this.f25715c, 0, bArr2, 0, this.f25714b.c() / 2);
        int iC6 = this.f25714b.c() / 2;
        for (int i17 = 0; i17 < i12; i17++) {
            System.arraycopy(this.f25719g.get(i17), 0, bArr2, iC6, this.f25714b.c() / 2);
            iC6 += this.f25714b.c() / 2;
        }
        return bArr2;
    }

    public final void e(int i10, byte[] bArr, int i11) {
        bArr[i11 + 3] = (byte) (i10 >> 24);
        bArr[i11 + 2] = (byte) (i10 >> 16);
        bArr[i11 + 1] = (byte) (i10 >> 8);
        bArr[i11] = (byte) i10;
    }
}

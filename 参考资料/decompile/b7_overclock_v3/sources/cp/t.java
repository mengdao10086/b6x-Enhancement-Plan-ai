package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class t extends s {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f25659t = 8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f25660p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int[] f25661q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int[] f25662r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f25663s;

    @Override // cp.s, org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!(kVar instanceof np.n1)) {
            throw new IllegalArgumentException("invalid parameter passed to DESede init - " + kVar.getClass().getName());
        }
        byte[] bArrA = ((np.n1) kVar).a();
        if (bArrA.length != 24 && bArrA.length != 16) {
            throw new IllegalArgumentException("key size must be 16 or 24 bytes.");
        }
        this.f25663s = z10;
        byte[] bArr = new byte[8];
        System.arraycopy(bArrA, 0, bArr, 0, 8);
        this.f25660p = f(z10, bArr);
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArrA, 8, bArr2, 0, 8);
        this.f25661q = f(!z10, bArr2);
        if (bArrA.length != 24) {
            this.f25662r = this.f25660p;
            return;
        }
        byte[] bArr3 = new byte[8];
        System.arraycopy(bArrA, 16, bArr3, 0, 8);
        this.f25662r = f(z10, bArr3);
    }

    @Override // cp.s, org.bouncycastle.crypto.f
    public String b() {
        return "DESede";
    }

    @Override // cp.s, org.bouncycastle.crypto.f
    public int c() {
        return 8;
    }

    @Override // cp.s, org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArr = this.f25660p;
        if (iArr == null) {
            throw new IllegalStateException("DESede engine not initialised");
        }
        if (i10 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        byte[] bArr3 = new byte[8];
        if (this.f25663s) {
            e(iArr, bArr, i10, bArr3, 0);
            e(this.f25661q, bArr3, 0, bArr3, 0);
            e(this.f25662r, bArr3, 0, bArr2, i11);
        } else {
            e(this.f25662r, bArr, i10, bArr3, 0);
            e(this.f25661q, bArr3, 0, bArr3, 0);
            e(this.f25660p, bArr3, 0, bArr2, i11);
        }
        return 8;
    }

    @Override // cp.s, org.bouncycastle.crypto.f
    public void reset() {
    }
}

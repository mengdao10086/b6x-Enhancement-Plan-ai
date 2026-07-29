package ip;

import np.n1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class h implements a0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f35499j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f35500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f35501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f35503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public cp.v f35504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f35505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f35506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f35507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f35508i = false;

    public h(int i10, int i11) {
        this.f35504e = new cp.v(i10);
        int i12 = i10 / 8;
        this.f35503d = i12;
        this.f35502c = i11 / 8;
        this.f35505f = new byte[i12];
        this.f35507h = new byte[i12];
        this.f35506g = new byte[i12];
        this.f35500a = new byte[i12];
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        if (!(kVar instanceof n1)) {
            throw new IllegalArgumentException("Invalid parameter passed to DSTU7624Mac");
        }
        this.f35504e.a(true, kVar);
        this.f35508i = true;
        reset();
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return "DSTU7624Mac";
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        int i11 = this.f35501b;
        byte[] bArr2 = this.f35500a;
        if (i11 % bArr2.length != 0) {
            throw new DataLengthException("input must be a multiple of blocksize");
        }
        f(this.f35505f, 0, bArr2, 0, this.f35506g);
        f(this.f35506g, 0, this.f35507h, 0, this.f35505f);
        cp.v vVar = this.f35504e;
        byte[] bArr3 = this.f35505f;
        vVar.d(bArr3, 0, bArr3, 0);
        int i12 = this.f35502c;
        if (i12 + i10 > bArr.length) {
            throw new OutputLengthException("output buffer too short");
        }
        System.arraycopy(this.f35505f, 0, bArr, i10, i12);
        reset();
        return this.f35502c;
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35502c;
    }

    public final void e(byte[] bArr, int i10) {
        f(this.f35505f, 0, bArr, i10, this.f35506g);
        this.f35504e.d(this.f35506g, 0, this.f35505f, 0);
    }

    public final void f(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3) {
        int length = bArr.length - i10;
        int i12 = this.f35503d;
        if (length < i12 || bArr2.length - i11 < i12 || bArr3.length < i12) {
            throw new IllegalArgumentException("some of input buffers too short");
        }
        for (int i13 = 0; i13 < this.f35503d; i13++) {
            bArr3[i13] = (byte) (bArr[i13 + i10] ^ bArr2[i13 + i11]);
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        org.bouncycastle.util.a.d0(this.f35505f, (byte) 0);
        org.bouncycastle.util.a.d0(this.f35506g, (byte) 0);
        org.bouncycastle.util.a.d0(this.f35507h, (byte) 0);
        org.bouncycastle.util.a.d0(this.f35500a, (byte) 0);
        this.f35504e.reset();
        if (this.f35508i) {
            cp.v vVar = this.f35504e;
            byte[] bArr = this.f35507h;
            vVar.d(bArr, 0, bArr, 0);
        }
        this.f35501b = 0;
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) {
        int i10 = this.f35501b;
        byte[] bArr = this.f35500a;
        if (i10 == bArr.length) {
            e(bArr, 0);
            this.f35501b = 0;
        }
        byte[] bArr2 = this.f35500a;
        int i11 = this.f35501b;
        this.f35501b = i11 + 1;
        bArr2[i11] = b10;
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("can't have a negative input length!");
        }
        int iC = this.f35504e.c();
        int i12 = this.f35501b;
        int i13 = iC - i12;
        if (i11 > i13) {
            System.arraycopy(bArr, i10, this.f35500a, i12, i13);
            e(this.f35500a, 0);
            this.f35501b = 0;
            i11 -= i13;
            i10 += i13;
            while (i11 > iC) {
                e(bArr, i10);
                i11 -= iC;
                i10 += iC;
            }
        }
        System.arraycopy(bArr, i10, this.f35500a, this.f35501b, i11);
        this.f35501b += i11;
    }
}

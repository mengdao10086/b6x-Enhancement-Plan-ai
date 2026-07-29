package jp;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class h implements a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte f36609m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte f36610n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte f36611o = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f36612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f36613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.bouncycastle.crypto.a0 f36615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f36616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f36617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f36618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f36619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f36620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f36621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f36622k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f36623l;

    public h(org.bouncycastle.crypto.f fVar) {
        this.f36614c = fVar.c();
        ip.e eVar = new ip.e(fVar);
        this.f36615d = eVar;
        this.f36618g = new byte[this.f36614c];
        this.f36617f = new byte[eVar.d()];
        this.f36616e = new byte[this.f36615d.d()];
        this.f36612a = new c0(fVar);
    }

    @Override // jp.b
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        byte[] bArrA;
        org.bouncycastle.crypto.k kVarB;
        this.f36613b = z10;
        if (kVar instanceof np.a) {
            np.a aVar = (np.a) kVar;
            bArrA = aVar.d();
            this.f36623l = aVar.a();
            this.f36619h = aVar.c() / 8;
            kVarB = aVar.b();
        } else {
            if (!(kVar instanceof v1)) {
                throw new IllegalArgumentException("invalid parameters passed to EAX");
            }
            v1 v1Var = (v1) kVar;
            bArrA = v1Var.a();
            this.f36623l = null;
            this.f36619h = this.f36615d.d() / 2;
            kVarB = v1Var.b();
        }
        this.f36620i = new byte[z10 ? this.f36614c : this.f36614c + this.f36619h];
        byte[] bArr = new byte[this.f36614c];
        this.f36615d.a(kVarB);
        int i10 = this.f36614c;
        bArr[i10 - 1] = 0;
        this.f36615d.update(bArr, 0, i10);
        this.f36615d.update(bArrA, 0, bArrA.length);
        this.f36615d.c(this.f36616e, 0);
        this.f36612a.a(true, new v1(null, this.f36616e));
        reset();
    }

    @Override // jp.b
    public String b() {
        return this.f36612a.i().b() + "/EAX";
    }

    @Override // jp.b
    public int c(byte[] bArr, int i10) throws InvalidCipherTextException, IllegalStateException {
        n();
        int i11 = this.f36621j;
        byte[] bArr2 = this.f36620i;
        byte[] bArr3 = new byte[bArr2.length];
        this.f36621j = 0;
        if (this.f36613b) {
            int i12 = i10 + i11;
            if (bArr.length < this.f36619h + i12) {
                throw new OutputLengthException("Output buffer too short");
            }
            this.f36612a.d(bArr2, 0, bArr3, 0);
            System.arraycopy(bArr3, 0, bArr, i10, i11);
            this.f36615d.update(bArr3, 0, i11);
            l();
            System.arraycopy(this.f36618g, 0, bArr, i12, this.f36619h);
            p(false);
            return i11 + this.f36619h;
        }
        int i13 = this.f36619h;
        if (i11 < i13) {
            throw new InvalidCipherTextException("data too short");
        }
        if (bArr.length < (i10 + i11) - i13) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (i11 > i13) {
            this.f36615d.update(bArr2, 0, i11 - i13);
            this.f36612a.d(this.f36620i, 0, bArr3, 0);
            System.arraycopy(bArr3, 0, bArr, i10, i11 - this.f36619h);
        }
        l();
        if (!q(this.f36620i, i11 - this.f36619h)) {
            throw new InvalidCipherTextException("mac check in EAX failed");
        }
        p(false);
        return i11 - this.f36619h;
    }

    @Override // jp.b
    public byte[] d() {
        int i10 = this.f36619h;
        byte[] bArr = new byte[i10];
        System.arraycopy(this.f36618g, 0, bArr, 0, i10);
        return bArr;
    }

    @Override // jp.b
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        n();
        if (bArr.length < i10 + i11) {
            throw new DataLengthException("Input buffer too short");
        }
        int iO = 0;
        for (int i13 = 0; i13 != i11; i13++) {
            iO += o(bArr[i10 + i13], bArr2, i12 + iO);
        }
        return iO;
    }

    @Override // jp.a
    public org.bouncycastle.crypto.f f() {
        return this.f36612a.i();
    }

    @Override // jp.b
    public int g(int i10) {
        int i11 = i10 + this.f36621j;
        if (!this.f36613b) {
            int i12 = this.f36619h;
            if (i11 < i12) {
                return 0;
            }
            i11 -= i12;
        }
        return i11 - (i11 % this.f36614c);
    }

    @Override // jp.b
    public int h(int i10) {
        int i11 = i10 + this.f36621j;
        if (this.f36613b) {
            return i11 + this.f36619h;
        }
        int i12 = this.f36619h;
        if (i11 < i12) {
            return 0;
        }
        return i11 - i12;
    }

    @Override // jp.b
    public int i(byte b10, byte[] bArr, int i10) throws DataLengthException {
        n();
        return o(b10, bArr, i10);
    }

    @Override // jp.b
    public void j(byte b10) {
        if (this.f36622k) {
            throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
        }
        this.f36615d.update(b10);
    }

    @Override // jp.b
    public void k(byte[] bArr, int i10, int i11) {
        if (this.f36622k) {
            throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
        }
        this.f36615d.update(bArr, i10, i11);
    }

    public final void l() {
        byte[] bArr = new byte[this.f36614c];
        int i10 = 0;
        this.f36615d.c(bArr, 0);
        while (true) {
            byte[] bArr2 = this.f36618g;
            if (i10 >= bArr2.length) {
                return;
            }
            bArr2[i10] = (byte) ((this.f36616e[i10] ^ this.f36617f[i10]) ^ bArr[i10]);
            i10++;
        }
    }

    public int m() {
        return this.f36612a.c();
    }

    public final void n() {
        if (this.f36622k) {
            return;
        }
        this.f36622k = true;
        this.f36615d.c(this.f36617f, 0);
        int i10 = this.f36614c;
        byte[] bArr = new byte[i10];
        bArr[i10 - 1] = 2;
        this.f36615d.update(bArr, 0, i10);
    }

    public final int o(byte b10, byte[] bArr, int i10) {
        int iD;
        byte[] bArr2 = this.f36620i;
        int i11 = this.f36621j;
        int i12 = i11 + 1;
        this.f36621j = i12;
        bArr2[i11] = b10;
        if (i12 != bArr2.length) {
            return 0;
        }
        int length = bArr.length;
        int i13 = this.f36614c;
        if (length < i10 + i13) {
            throw new OutputLengthException("Output buffer is too short");
        }
        if (this.f36613b) {
            iD = this.f36612a.d(bArr2, 0, bArr, i10);
            this.f36615d.update(bArr, i10, this.f36614c);
        } else {
            this.f36615d.update(bArr2, 0, i13);
            iD = this.f36612a.d(this.f36620i, 0, bArr, i10);
        }
        this.f36621j = 0;
        if (!this.f36613b) {
            byte[] bArr3 = this.f36620i;
            System.arraycopy(bArr3, this.f36614c, bArr3, 0, this.f36619h);
            this.f36621j = this.f36619h;
        }
        return iD;
    }

    public final void p(boolean z10) {
        this.f36612a.reset();
        this.f36615d.reset();
        this.f36621j = 0;
        org.bouncycastle.util.a.d0(this.f36620i, (byte) 0);
        if (z10) {
            org.bouncycastle.util.a.d0(this.f36618g, (byte) 0);
        }
        int i10 = this.f36614c;
        byte[] bArr = new byte[i10];
        bArr[i10 - 1] = 1;
        this.f36615d.update(bArr, 0, i10);
        this.f36622k = false;
        byte[] bArr2 = this.f36623l;
        if (bArr2 != null) {
            k(bArr2, 0, bArr2.length);
        }
    }

    public final boolean q(byte[] bArr, int i10) {
        int i11 = 0;
        for (int i12 = 0; i12 < this.f36619h; i12++) {
            i11 |= this.f36618g[i12] ^ bArr[i10 + i12];
        }
        return i11 == 0;
    }

    @Override // jp.b
    public void reset() {
        p(true);
    }
}

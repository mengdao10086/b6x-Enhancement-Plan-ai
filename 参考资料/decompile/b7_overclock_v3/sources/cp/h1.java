package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class h1 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25316g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25317h = 32;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25318i = -1640531527;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f25320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25324f;

    public static int r(int i10, int i11) {
        return (i10 >>> (-i11)) | (i10 << i11);
    }

    public static int s(int i10, int i11) {
        return (i10 << (-i11)) | (i10 >>> i11);
    }

    public final void A(int i10, int i11, int i12, int i13) {
        int i14 = i11 ^ i12;
        int i15 = (i12 & i14) ^ i13;
        int i16 = i10 ^ i15;
        int i17 = i11 ^ ((i13 | i14) & i16);
        this.f25322d = i17;
        int i18 = (i10 & i16) ^ i14;
        this.f25324f = i18;
        int i19 = (i17 | i15) ^ i16;
        int i20 = i15 ^ (i18 & i19);
        this.f25323e = i20;
        this.f25321c = (i18 & i20) ^ (~i19);
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof np.n1) {
            this.f25319a = z10;
            this.f25320b = q(((np.n1) kVar).a());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to " + b() + " init - " + kVar.getClass().getName());
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "Serpent";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.f
    public final int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        if (this.f25320b == null) {
            throw new IllegalStateException(b() + " not initialised");
        }
        if (i10 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.f25319a) {
            g(bArr, i10, bArr2, i11);
            return 16;
        }
        f(bArr, i10, bArr2, i11);
        return 16;
    }

    public final void e() {
        int iR = r(this.f25321c, 13);
        int iR2 = r(this.f25323e, 3);
        int i10 = (this.f25322d ^ iR) ^ iR2;
        int i11 = (this.f25324f ^ iR2) ^ (iR << 3);
        this.f25322d = r(i10, 1);
        int iR3 = r(i11, 7);
        this.f25324f = iR3;
        this.f25321c = r((iR ^ this.f25322d) ^ iR3, 5);
        this.f25323e = r((this.f25324f ^ iR2) ^ (this.f25322d << 7), 22);
    }

    public abstract void f(byte[] bArr, int i10, byte[] bArr2, int i11);

    public abstract void g(byte[] bArr, int i10, byte[] bArr2, int i11);

    public final void h(int i10, int i11, int i12, int i13) {
        int i14 = ~i10;
        int i15 = i11 ^ i10;
        int i16 = (i14 | i15) ^ i13;
        int i17 = i12 ^ i16;
        int i18 = i15 ^ i17;
        this.f25323e = i18;
        int i19 = (i15 & i13) ^ i14;
        int i20 = (i18 & i19) ^ i16;
        this.f25322d = i20;
        int i21 = (i10 & i16) ^ (i20 | i17);
        this.f25324f = i21;
        this.f25321c = i21 ^ (i19 ^ i17);
    }

    public final void i(int i10, int i11, int i12, int i13) {
        int i14 = i13 ^ i11;
        int i15 = i10 ^ (i11 & i14);
        int i16 = i14 ^ i15;
        int i17 = i12 ^ i16;
        this.f25324f = i17;
        int i18 = i11 ^ (i14 & i15);
        int i19 = i15 ^ (i17 | i18);
        this.f25322d = i19;
        int i20 = ~i19;
        int i21 = i18 ^ i17;
        this.f25321c = i20 ^ i21;
        this.f25323e = (i20 | i21) ^ i16;
    }

    public final void j(int i10, int i11, int i12, int i13) {
        int i14 = i11 ^ i13;
        int i15 = ~i14;
        int i16 = i10 ^ i12;
        int i17 = i12 ^ i14;
        int i18 = (i11 & i17) ^ i16;
        this.f25321c = i18;
        int i19 = (((i10 | i15) ^ i13) | i16) ^ i14;
        this.f25324f = i19;
        int i20 = ~i17;
        int i21 = i19 | i18;
        this.f25322d = i20 ^ i21;
        this.f25323e = (i21 ^ i16) ^ (i13 & i20);
    }

    public final void k(int i10, int i11, int i12, int i13) {
        int i14 = i10 | i11;
        int i15 = i11 ^ i12;
        int i16 = i10 ^ (i11 & i15);
        int i17 = i12 ^ i16;
        int i18 = i13 | i16;
        int i19 = i15 ^ i18;
        this.f25321c = i19;
        int i20 = (i18 | i15) ^ i13;
        this.f25323e = i17 ^ i20;
        int i21 = i14 ^ i20;
        int i22 = i16 ^ (i19 & i21);
        this.f25324f = i22;
        this.f25322d = i22 ^ (i21 ^ i19);
    }

    public final void l(int i10, int i11, int i12, int i13) {
        int i14 = i11 ^ ((i12 | i13) & i10);
        int i15 = i12 ^ (i10 & i14);
        int i16 = i13 ^ i15;
        this.f25322d = i16;
        int i17 = ~i10;
        int i18 = (i15 & i16) ^ i14;
        this.f25324f = i18;
        int i19 = i13 ^ (i16 | i17);
        this.f25321c = i18 ^ i19;
        this.f25323e = (i17 ^ i16) ^ (i14 & i19);
    }

    public final void m(int i10, int i11, int i12, int i13) {
        int i14 = ~i12;
        int i15 = (i11 & i14) ^ i13;
        int i16 = i10 & i15;
        int i17 = (i11 ^ i14) ^ i16;
        this.f25324f = i17;
        int i18 = i17 | i11;
        this.f25322d = i15 ^ (i10 & i18);
        int i19 = i13 | i10;
        this.f25321c = (i14 ^ i18) ^ i19;
        this.f25323e = ((i10 ^ i12) | i16) ^ (i11 & i19);
    }

    public final void n(int i10, int i11, int i12, int i13) {
        int i14 = ~i10;
        int i15 = i10 ^ i11;
        int i16 = i12 ^ i15;
        int i17 = (i12 | i14) ^ i13;
        this.f25322d = i16 ^ i17;
        int i18 = i15 ^ (i16 & i17);
        int i19 = i17 ^ (i11 | i18);
        this.f25324f = i19;
        int i20 = i11 | i19;
        this.f25321c = i18 ^ i20;
        this.f25323e = (i13 & i14) ^ (i20 ^ i16);
    }

    public final void o(int i10, int i11, int i12, int i13) {
        int i14 = (i10 & i11) | i12;
        int i15 = (i10 | i11) & i13;
        int i16 = i14 ^ i15;
        this.f25324f = i16;
        int i17 = i11 ^ i15;
        int i18 = ((i16 ^ (~i13)) | i17) ^ i10;
        this.f25322d = i18;
        int i19 = (i17 ^ i12) ^ (i13 | i18);
        this.f25321c = i19;
        this.f25323e = ((i10 & i16) ^ i19) ^ (i14 ^ i18);
    }

    public final void p() {
        int iS = (s(this.f25323e, 22) ^ this.f25324f) ^ (this.f25322d << 7);
        int iS2 = s(this.f25321c, 5) ^ this.f25322d;
        int i10 = this.f25324f;
        int i11 = iS2 ^ i10;
        int iS3 = s(i10, 7);
        int iS4 = s(this.f25322d, 1);
        this.f25324f = (iS3 ^ iS) ^ (i11 << 3);
        this.f25322d = (iS4 ^ i11) ^ iS;
        this.f25323e = s(iS, 3);
        this.f25321c = s(i11, 13);
    }

    public abstract int[] q(byte[] bArr);

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }

    public final void t(int i10, int i11, int i12, int i13) {
        int i14 = i10 ^ i13;
        int i15 = i12 ^ i14;
        int i16 = i11 ^ i15;
        int i17 = (i13 & i10) ^ i16;
        this.f25324f = i17;
        int i18 = i10 ^ (i11 & i14);
        this.f25323e = (i12 | i18) ^ i16;
        int i19 = (i15 ^ i18) & i17;
        this.f25322d = (~i15) ^ i19;
        this.f25321c = (~i18) ^ i19;
    }

    public final void u(int i10, int i11, int i12, int i13) {
        int i14 = (~i10) ^ i11;
        int i15 = (i10 | i14) ^ i12;
        int i16 = i13 ^ i15;
        this.f25323e = i16;
        int i17 = i11 ^ (i13 | i14);
        int i18 = i16 ^ i14;
        int i19 = (i15 & i17) ^ i18;
        this.f25324f = i19;
        int i20 = i17 ^ i15;
        this.f25322d = i19 ^ i20;
        this.f25321c = i15 ^ (i20 & i18);
    }

    public final void v(int i10, int i11, int i12, int i13) {
        int i14 = ~i10;
        int i15 = i11 ^ i13;
        int i16 = (i12 & i14) ^ i15;
        this.f25321c = i16;
        int i17 = i12 ^ i14;
        int i18 = i11 & (i12 ^ i16);
        int i19 = i17 ^ i18;
        this.f25324f = i19;
        int i20 = i10 ^ ((i18 | i13) & (i16 | i17));
        this.f25323e = i20;
        this.f25322d = (i20 ^ (i13 | i14)) ^ (i15 ^ i19);
    }

    public final void w(int i10, int i11, int i12, int i13) {
        int i14 = i10 ^ i11;
        int i15 = i10 & i12;
        int i16 = i10 | i13;
        int i17 = i12 ^ i13;
        int i18 = i15 | (i14 & i16);
        int i19 = i17 ^ i18;
        this.f25323e = i19;
        int i20 = (i16 ^ i11) ^ i18;
        int i21 = i14 ^ (i17 & i20);
        this.f25321c = i21;
        int i22 = i21 & i19;
        this.f25322d = i20 ^ i22;
        this.f25324f = (i11 | i13) ^ (i17 ^ i22);
    }

    public final void x(int i10, int i11, int i12, int i13) {
        int i14 = i10 ^ i13;
        int i15 = i12 ^ (i13 & i14);
        int i16 = i11 | i15;
        this.f25324f = i14 ^ i16;
        int i17 = ~i11;
        int i18 = (i14 | i17) ^ i15;
        this.f25321c = i18;
        int i19 = i17 ^ i14;
        int i20 = (i16 & i19) ^ (i18 & i10);
        this.f25323e = i20;
        this.f25322d = (i10 ^ i15) ^ (i19 & i20);
    }

    public final void y(int i10, int i11, int i12, int i13) {
        int i14 = ~i10;
        int i15 = i10 ^ i11;
        int i16 = i10 ^ i13;
        int i17 = (i12 ^ i14) ^ (i15 | i16);
        this.f25321c = i17;
        int i18 = i13 & i17;
        int i19 = (i15 ^ i17) ^ i18;
        this.f25322d = i19;
        int i20 = i16 ^ (i17 | i14);
        this.f25323e = (i15 | i18) ^ i20;
        this.f25324f = (i20 & i19) ^ (i11 ^ i18);
    }

    public final void z(int i10, int i11, int i12, int i13) {
        int i14 = ~i10;
        int i15 = i10 ^ i13;
        int i16 = i11 ^ i15;
        int i17 = i12 ^ (i14 | i15);
        int i18 = i11 ^ i17;
        this.f25322d = i18;
        int i19 = (i15 | i18) ^ i13;
        int i20 = (i17 & i19) ^ i16;
        this.f25323e = i20;
        int i21 = i19 ^ i17;
        this.f25321c = i20 ^ i21;
        this.f25324f = (i21 & i16) ^ (~i17);
    }
}

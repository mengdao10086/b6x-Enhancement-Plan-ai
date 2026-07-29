package zo;

/* JADX INFO: loaded from: classes5.dex */
public class e extends j0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f59256i = new byte[100];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f59257h;

    public e(int i10, byte[] bArr, byte[] bArr2) {
        super(i10);
        if ((bArr == null || bArr.length == 0) && (bArr2 == null || bArr2.length == 0)) {
            this.f59257h = null;
        } else {
            this.f59257h = org.bouncycastle.util.a.C(r0.c(this.f59433c / 8), u(bArr), u(bArr2));
            t();
        }
    }

    public e(e eVar) {
        super(eVar);
        this.f59257h = org.bouncycastle.util.a.p(eVar.f59257h);
    }

    @Override // zo.j0, zo.q, org.bouncycastle.crypto.s
    public String b() {
        return "CSHAKE" + this.f59435e;
    }

    @Override // zo.j0, org.bouncycastle.crypto.m0
    public int e(byte[] bArr, int i10, int i11) {
        if (this.f59257h == null) {
            return super.e(bArr, i10, i11);
        }
        if (!this.f59436f) {
            l(0, 2);
        }
        q(bArr, i10, ((long) i11) * 8);
        return i11;
    }

    @Override // zo.q, org.bouncycastle.crypto.s
    public void reset() {
        super.reset();
        if (this.f59257h != null) {
            t();
        }
    }

    public final void t() {
        int i10 = this.f59433c / 8;
        byte[] bArr = this.f59257h;
        k(bArr, 0, bArr.length);
        int length = this.f59257h.length % i10;
        if (length == 0) {
            return;
        }
        while (true) {
            i10 -= length;
            byte[] bArr2 = f59256i;
            if (i10 <= bArr2.length) {
                k(bArr2, 0, i10);
                return;
            } else {
                k(bArr2, 0, bArr2.length);
                length = bArr2.length;
            }
        }
    }

    public final byte[] u(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? r0.c(0L) : org.bouncycastle.util.a.B(r0.c(((long) bArr.length) * 8), bArr);
    }
}

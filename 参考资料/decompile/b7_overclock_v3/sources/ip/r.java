package ip;

import org.bouncycastle.crypto.DataLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class r extends s {
    public r() {
    }

    public r(int i10, int i11) {
        super(i10, i11);
    }

    @Override // ip.s, org.bouncycastle.crypto.a0
    public String b() {
        return "SipHash128-" + this.f35582a + "-" + this.f35583b;
    }

    @Override // ip.s, org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        long j10 = this.f35590i;
        int i11 = this.f35591j;
        this.f35590i = ((j10 >>> ((7 - i11) << 3)) >>> 8) | ((((long) ((this.f35592k << 3) + i11)) & 255) << 56);
        g();
        this.f35588g ^= 238;
        e(this.f35583b);
        long j11 = this.f35586e;
        long j12 = this.f35587f;
        long j13 = ((j11 ^ j12) ^ this.f35588g) ^ this.f35589h;
        this.f35587f = j12 ^ 221;
        e(this.f35583b);
        long j14 = ((this.f35586e ^ this.f35587f) ^ this.f35588g) ^ this.f35589h;
        reset();
        org.bouncycastle.util.o.F(j13, bArr, i10);
        org.bouncycastle.util.o.F(j14, bArr, i10 + 8);
        return 16;
    }

    @Override // ip.s, org.bouncycastle.crypto.a0
    public int d() {
        return 16;
    }

    @Override // ip.s
    public long f() throws IllegalStateException, DataLengthException {
        throw new UnsupportedOperationException("doFinal() is not supported");
    }

    @Override // ip.s, org.bouncycastle.crypto.a0
    public void reset() {
        super.reset();
        this.f35587f ^= 238;
    }
}

package kp;

import java.lang.reflect.Array;
import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes5.dex */
public class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f39092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[][] f39093b;

    @Override // kp.d
    public void a(byte[] bArr) {
        if (this.f39093b == null) {
            this.f39093b = (long[][]) Array.newInstance((Class<?>) long.class, 256, 2);
        } else if (e.a(this.f39092a, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.f39092a = bArr2;
        e.l(bArr, bArr2);
        e.j(this.f39092a, this.f39093b[1]);
        long[][] jArr = this.f39093b;
        e.z(jArr[1], jArr[1]);
        for (int i10 = 2; i10 < 256; i10 += 2) {
            long[][] jArr2 = this.f39093b;
            e.o(jArr2[i10 >> 1], jArr2[i10]);
            long[][] jArr3 = this.f39093b;
            e.S(jArr3[i10], jArr3[1], jArr3[i10 + 1]);
        }
    }

    @Override // kp.d
    public void b(byte[] bArr) {
        long[] jArr = this.f39093b[bArr[15] & 255];
        long j10 = jArr[0];
        long j11 = jArr[1];
        for (int i10 = 14; i10 >= 0; i10--) {
            long[] jArr2 = this.f39093b[bArr[i10] & 255];
            long j12 = j11 << 56;
            j11 = ((j11 >>> 8) | (j10 << 56)) ^ jArr2[1];
            j10 = (((((j10 >>> 8) ^ jArr2[0]) ^ j12) ^ (j12 >>> 1)) ^ (j12 >>> 2)) ^ (j12 >>> 7);
        }
        o.z(j10, bArr, 0);
        o.z(j11, bArr, 8);
    }
}

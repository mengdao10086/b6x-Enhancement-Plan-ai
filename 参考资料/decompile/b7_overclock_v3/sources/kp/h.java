package kp;

import java.lang.reflect.Array;
import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes5.dex */
public class h implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f39094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[][][] f39095b;

    @Override // kp.d
    public void a(byte[] bArr) {
        if (this.f39095b == null) {
            this.f39095b = (long[][][]) Array.newInstance((Class<?>) long.class, 16, 256, 2);
        } else if (e.a(this.f39094a, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.f39094a = bArr2;
        e.l(bArr, bArr2);
        for (int i10 = 0; i10 < 16; i10++) {
            long[][][] jArr = this.f39095b;
            long[][] jArr2 = jArr[i10];
            if (i10 == 0) {
                e.j(this.f39094a, jArr2[1]);
                e.z(jArr2[1], jArr2[1]);
            } else {
                e.D(jArr[i10 - 1][1], jArr2[1]);
            }
            for (int i11 = 2; i11 < 256; i11 += 2) {
                e.o(jArr2[i11 >> 1], jArr2[i11]);
                e.S(jArr2[i11], jArr2[1], jArr2[i11 + 1]);
            }
        }
    }

    @Override // kp.d
    public void b(byte[] bArr) {
        long[] jArr = this.f39095b[15][bArr[15] & 255];
        long j10 = jArr[0];
        long j11 = jArr[1];
        for (int i10 = 14; i10 >= 0; i10--) {
            long[] jArr2 = this.f39095b[i10][bArr[i10] & 255];
            j10 ^= jArr2[0];
            j11 ^= jArr2[1];
        }
        o.z(j10, bArr, 0);
        o.z(j11, bArr, 8);
    }
}

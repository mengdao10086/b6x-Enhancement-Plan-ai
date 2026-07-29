package kp;

import java.lang.reflect.Array;
import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes5.dex */
public class i implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f39096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[][][] f39097b;

    @Override // kp.d
    public void a(byte[] bArr) {
        if (this.f39097b == null) {
            this.f39097b = (long[][][]) Array.newInstance((Class<?>) long.class, 32, 16, 2);
        } else if (e.a(this.f39096a, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.f39096a = bArr2;
        e.l(bArr, bArr2);
        for (int i10 = 0; i10 < 32; i10++) {
            long[][][] jArr = this.f39097b;
            long[][] jArr2 = jArr[i10];
            if (i10 == 0) {
                e.j(this.f39096a, jArr2[1]);
                e.x(jArr2[1], jArr2[1]);
            } else {
                e.y(jArr[i10 - 1][1], jArr2[1]);
            }
            for (int i11 = 2; i11 < 16; i11 += 2) {
                e.o(jArr2[i11 >> 1], jArr2[i11]);
                e.S(jArr2[i11], jArr2[1], jArr2[i11 + 1]);
            }
        }
    }

    @Override // kp.d
    public void b(byte[] bArr) {
        long j10 = 0;
        long j11 = 0;
        for (int i10 = 15; i10 >= 0; i10--) {
            long[][][] jArr = this.f39097b;
            int i11 = i10 + i10;
            long[] jArr2 = jArr[i11 + 1][bArr[i10] & 15];
            long[] jArr3 = jArr[i11][(bArr[i10] & 240) >>> 4];
            j10 ^= jArr2[0] ^ jArr3[0];
            j11 ^= jArr3[1] ^ jArr2[1];
        }
        o.z(j10, bArr, 0);
        o.z(j11, bArr, 8);
    }
}

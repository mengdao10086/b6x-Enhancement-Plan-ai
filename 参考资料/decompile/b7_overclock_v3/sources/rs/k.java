package rs;

import cp.p;
import np.n1;
import np.v1;
import org.bouncycastle.util.o;
import rs.l;

/* JADX INFO: loaded from: classes6.dex */
public class k {
    public static void a(a aVar, byte[] bArr, int i10, byte[] bArr2, l.a aVar2) {
        byte[] bArr3 = new byte[40];
        for (int i11 = 0; i11 < 32; i11++) {
            bArr3[i11] = bArr2[i11];
        }
        o.F((aVar2.f49175c << 59) | ((long) aVar2.f49173a) | (aVar2.f49174b << 4), bArr3, 32);
        aVar.f(bArr, i10, bArr3, 40);
    }

    public static void b(byte[] bArr, int i10, long j10, byte[] bArr2, int i11) {
        p pVar = new p(12);
        pVar.a(true, new v1(new n1(bArr2, i11, 32), new byte[8]));
        pVar.e(bArr, i10, (int) j10, bArr, i10);
    }
}

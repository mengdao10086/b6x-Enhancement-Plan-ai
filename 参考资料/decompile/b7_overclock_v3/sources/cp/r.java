package cp;

import np.w1;
import np.x1;
import np.z1;

/* JADX INFO: loaded from: classes5.dex */
public class r extends a0 {
    public static boolean e(byte b10, int i10) {
        return (b10 & (1 << i10)) != 0;
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i10 = 0; i10 != 8; i10++) {
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 != 8; i13++) {
                int iR = org.bouncycastle.util.o.r(bArr, i13 * 4);
                if (e(bArr2[i10], i13)) {
                    i11 += iR;
                } else {
                    i12 += iR;
                }
            }
            byte[] bArr4 = new byte[8];
            org.bouncycastle.util.o.m(i11, bArr4, 0);
            org.bouncycastle.util.o.m(i12, bArr4, 4);
            jp.m mVar = new jp.m(new z());
            mVar.a(true, new np.v1(new x1(new np.n1(bArr), bArr3), bArr4));
            mVar.d(bArr, 0, bArr, 0);
            mVar.d(bArr, 8, bArr, 8);
            mVar.d(bArr, 16, bArr, 16);
            mVar.d(bArr, 24, bArr, 24);
        }
        return bArr;
    }

    @Override // cp.a0, org.bouncycastle.crypto.l0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        byte[] bArrB;
        np.n1 n1Var;
        if (kVar instanceof w1) {
            kVar = ((w1) kVar).a();
        }
        z1 z1Var = (z1) kVar;
        if (z1Var.a() instanceof x1) {
            n1Var = (np.n1) ((x1) z1Var.a()).a();
            bArrB = ((x1) z1Var.a()).b();
        } else {
            bArrB = null;
            n1Var = (np.n1) z1Var.a();
        }
        np.n1 n1Var2 = new np.n1(f(n1Var.a(), z1Var.b(), bArrB));
        super.a(z10, bArrB != null ? new z1(new x1(n1Var2, bArrB), z1Var.b()) : new z1(n1Var2, z1Var.b()));
    }
}

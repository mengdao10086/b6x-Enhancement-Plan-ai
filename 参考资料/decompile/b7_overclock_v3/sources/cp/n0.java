package cp;

/* JADX INFO: loaded from: classes5.dex */
public class n0 extends h0 {
    public n0(org.bouncycastle.crypto.e eVar, org.bouncycastle.crypto.q qVar, org.bouncycastle.crypto.a0 a0Var) {
        super(eVar, qVar, a0Var);
    }

    public n0(org.bouncycastle.crypto.e eVar, org.bouncycastle.crypto.q qVar, org.bouncycastle.crypto.a0 a0Var, org.bouncycastle.crypto.h hVar) {
        super(eVar, qVar, a0Var, hVar);
    }

    @Override // cp.h0
    public byte[] e(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        if (bArr != null) {
            org.bouncycastle.util.o.h(bArr.length * 8, bArr2, 0);
        }
        return bArr2;
    }
}

package fp;

import java.security.SecureRandom;
import np.m2;

/* JADX INFO: loaded from: classes5.dex */
public class o0 implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SecureRandom f28683g;

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        this.f28683g = yVar.a();
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        m2 m2Var = new m2(this.f28683g);
        return new org.bouncycastle.crypto.c((np.c) m2Var.e(), (np.c) m2Var);
    }
}

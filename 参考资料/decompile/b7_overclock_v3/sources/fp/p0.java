package fp;

import java.security.SecureRandom;
import np.p2;

/* JADX INFO: loaded from: classes5.dex */
public class p0 implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SecureRandom f28686g;

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        this.f28686g = yVar.a();
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        p2 p2Var = new p2(this.f28686g);
        return new org.bouncycastle.crypto.c((np.c) p2Var.e(), (np.c) p2Var);
    }
}

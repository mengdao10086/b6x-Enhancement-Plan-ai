package fp;

import java.security.SecureRandom;
import np.r0;

/* JADX INFO: loaded from: classes5.dex */
public class r implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SecureRandom f28688g;

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        this.f28688g = yVar.a();
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        r0 r0Var = new r0(this.f28688g);
        return new org.bouncycastle.crypto.c((np.c) r0Var.e(), (np.c) r0Var);
    }
}

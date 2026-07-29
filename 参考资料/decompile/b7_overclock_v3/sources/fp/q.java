package fp;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class q implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SecureRandom f28687g;

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        this.f28687g = yVar.a();
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        np.o0 o0Var = new np.o0(this.f28687g);
        return new org.bouncycastle.crypto.c((np.c) o0Var.e(), (np.c) o0Var);
    }
}

package ns;

import java.security.SecureRandom;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes6.dex */
public class e implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SecureRandom f42641g;

    @Override // org.bouncycastle.crypto.d
    public void a(y yVar) {
        this.f42641g = yVar.a();
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        byte[] bArr = new byte[1824];
        short[] sArr = new short[1024];
        k.f(this.f42641g, bArr, sArr);
        return new org.bouncycastle.crypto.c((np.c) new h(bArr), (np.c) new g(sArr));
    }
}

package rs;

import java.security.SecureRandom;
import org.bouncycastle.crypto.s;
import org.bouncycastle.crypto.y;
import rs.l;

/* JADX INFO: loaded from: classes6.dex */
public class f implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SecureRandom f49164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s f49165h;

    @Override // org.bouncycastle.crypto.d
    public void a(y yVar) {
        this.f49164g = yVar.a();
        this.f49165h = ((e) yVar).c();
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        l.a aVar = new l.a();
        byte[] bArr = new byte[d.f49161j];
        this.f49164g.nextBytes(bArr);
        byte[] bArr2 = new byte[d.f49160i];
        System.arraycopy(bArr, 32, bArr2, 0, 1024);
        aVar.f49173a = 11;
        aVar.f49174b = 0L;
        aVar.f49175c = 0L;
        l.c(new a(this.f49165h), bArr2, 1024, 5, bArr, aVar, bArr2, 0);
        return new org.bouncycastle.crypto.c((np.c) new j(bArr2, this.f49165h.b()), (np.c) new i(bArr, this.f49165h.b()));
    }
}

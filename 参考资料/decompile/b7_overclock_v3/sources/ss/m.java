package ss;

import java.security.SecureRandom;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes6.dex */
public class m implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SecureRandom f50472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o f50473h;

    @Override // org.bouncycastle.crypto.d
    public void a(y yVar) {
        this.f50472g = yVar.a();
        this.f50473h = ((l) yVar).c();
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        k kVarA = this.f50473h.a();
        j jVar = new j(c(kVarA.f50451b), c(kVarA.f50451b));
        byte[] bArrC = c(kVarA.f50451b);
        f fVar = new f(bArrC, new c(kVarA, jVar.f50448a, bArrC).f50433e);
        return new org.bouncycastle.crypto.c((np.c) new q(this.f50473h, fVar), (np.c) new p(this.f50473h, jVar, fVar));
    }

    public final byte[] c(int i10) {
        byte[] bArr = new byte[i10];
        this.f50472g.nextBytes(bArr);
        return bArr;
    }
}

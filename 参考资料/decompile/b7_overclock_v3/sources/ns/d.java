package ns;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class d implements js.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecureRandom f42640a;

    public d(SecureRandom secureRandom) {
        this.f42640a = secureRandom;
    }

    @Override // js.d
    public js.c a(np.c cVar) {
        byte[] bArr = new byte[32];
        byte[] bArr2 = new byte[2048];
        k.i(this.f42640a, bArr, bArr2, ((h) cVar).f42648b);
        return new js.c(new h(bArr2), bArr);
    }

    @Override // js.d
    public js.c b(np.c cVar) {
        return a(cVar);
    }
}

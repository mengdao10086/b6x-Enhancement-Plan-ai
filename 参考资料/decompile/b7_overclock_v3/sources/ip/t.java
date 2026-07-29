package ip;

import np.j2;
import np.n1;
import org.bouncycastle.crypto.a0;
import zo.n0;

/* JADX INFO: loaded from: classes5.dex */
public class t implements a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f35593b = 256;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f35594c = 512;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f35595d = 1024;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n0 f35596a;

    public t(int i10, int i11) {
        this.f35596a = new n0(i10, i11);
    }

    public t(t tVar) {
        this.f35596a = new n0(tVar.f35596a);
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        j2 j2VarA;
        if (kVar instanceof j2) {
            j2VarA = (j2) kVar;
        } else {
            if (!(kVar instanceof n1)) {
                throw new IllegalArgumentException("Invalid parameter passed to Skein MAC init - " + kVar.getClass().getName());
            }
            j2VarA = new j2.b().c(((n1) kVar).a()).a();
        }
        if (j2VarA.b() == null) {
            throw new IllegalArgumentException("Skein MAC requires a key parameter.");
        }
        this.f35596a.k(j2VarA);
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return "Skein-MAC-" + (this.f35596a.g() * 8) + "-" + (this.f35596a.h() * 8);
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) {
        return this.f35596a.f(bArr, i10);
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35596a.h();
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        this.f35596a.o();
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) {
        this.f35596a.t(b10);
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) {
        this.f35596a.u(bArr, i10, i11);
    }
}

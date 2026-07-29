package uo;

import np.r2;
import np.s2;
import org.bouncycastle.crypto.d0;

/* JADX INFO: loaded from: classes5.dex */
public class o implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f52383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r2 f52384b;

    public o(d0 d0Var) {
        this.f52383a = d0Var;
    }

    @Override // org.bouncycastle.crypto.d0
    public void a(org.bouncycastle.crypto.k kVar) {
        this.f52384b = (r2) kVar;
    }

    @Override // org.bouncycastle.crypto.d0
    public void b(org.bouncycastle.crypto.k kVar, byte[] bArr, int i10) {
        s2 s2Var = (s2) kVar;
        this.f52383a.a(this.f52384b.a());
        this.f52383a.b(s2Var.a(), bArr, i10);
        this.f52383a.a(this.f52384b.c());
        this.f52383a.b(s2Var.b(), bArr, i10 + this.f52383a.c());
    }

    @Override // org.bouncycastle.crypto.d0
    public int c() {
        return this.f52383a.c() * 2;
    }
}

package org.bouncycastle.pqc.crypto.lms;

/* JADX INFO: loaded from: classes6.dex */
public class e implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f45737g;

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        this.f45737g = (d) yVar;
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        f fVarA = c.a(this.f45737g);
        return new org.bouncycastle.crypto.c((np.c) fVarA.l(), (np.c) fVarA);
    }
}

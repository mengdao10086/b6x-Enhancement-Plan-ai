package org.bouncycastle.pqc.crypto.lms;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class r implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public q f45774g;

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        this.f45774g = (q) yVar;
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        SecureRandom secureRandomA = this.f45774g.a();
        byte[] bArr = new byte[16];
        secureRandomA.nextBytes(bArr);
        byte[] bArr2 = new byte[32];
        secureRandomA.nextBytes(bArr2);
        u uVarA = m.a(this.f45774g.c().b(), this.f45774g.c().a(), 0, bArr, bArr2);
        return new org.bouncycastle.crypto.c((np.c) uVarA.p(), (np.c) uVarA);
    }
}

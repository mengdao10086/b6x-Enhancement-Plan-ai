package org.bouncycastle.crypto;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecureRandom f44687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f44688b;

    public byte[] a() {
        byte[] bArr = new byte[this.f44688b];
        this.f44687a.nextBytes(bArr);
        return bArr;
    }

    public void b(y yVar) {
        this.f44687a = yVar.a();
        this.f44688b = (yVar.b() + 7) / 8;
    }
}

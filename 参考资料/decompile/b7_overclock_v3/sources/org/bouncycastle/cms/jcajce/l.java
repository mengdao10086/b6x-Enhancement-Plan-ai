package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes5.dex */
public class l extends OutputStream {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f44581b = new byte[1];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cipher f44582a;

    public l(Cipher cipher) {
        this.f44582a = cipher;
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        byte[] bArr = f44581b;
        bArr[0] = (byte) i10;
        this.f44582a.updateAAD(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f44582a.updateAAD(bArr, i10, i11);
    }
}

package vq;

import java.security.DigestException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes7.dex */
public class a extends MessageDigest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f53335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f53336b;

    public a(org.bouncycastle.crypto.s sVar) {
        super(sVar.b());
        this.f53335a = sVar;
        this.f53336b = sVar.h();
    }

    @Override // java.security.MessageDigestSpi
    public int engineDigest(byte[] bArr, int i10, int i11) throws DigestException {
        int i12 = this.f53336b;
        if (i11 < i12) {
            throw new DigestException("partial digests not returned");
        }
        if (bArr.length - i10 < i12) {
            throw new DigestException("insufficient space in the output buffer to store the digest");
        }
        this.f53335a.c(bArr, i10);
        return this.f53336b;
    }

    @Override // java.security.MessageDigestSpi
    public byte[] engineDigest() {
        byte[] bArr = new byte[this.f53336b];
        this.f53335a.c(bArr, 0);
        return bArr;
    }

    @Override // java.security.MessageDigestSpi
    public int engineGetDigestLength() {
        return this.f53336b;
    }

    @Override // java.security.MessageDigestSpi
    public void engineReset() {
        this.f53335a.reset();
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte b10) {
        this.f53335a.update(b10);
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) {
        this.f53335a.update(bArr, i10, i11);
    }
}

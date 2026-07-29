package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes5.dex */
public interface e0 {
    void a(boolean z10, k kVar);

    boolean d(byte[] bArr);

    byte[] e() throws DataLengthException, CryptoException;

    void reset();

    void update(byte b10);

    void update(byte[] bArr, int i10, int i11);
}

package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes5.dex */
public interface a0 {
    void a(k kVar) throws IllegalArgumentException;

    String b();

    int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException;

    int d();

    void reset();

    void update(byte b10) throws IllegalStateException;

    void update(byte[] bArr, int i10, int i11) throws IllegalStateException, DataLengthException;
}

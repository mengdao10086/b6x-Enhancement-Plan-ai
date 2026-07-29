package jp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public interface b {
    void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException;

    String b();

    int c(byte[] bArr, int i10) throws InvalidCipherTextException, IllegalStateException;

    byte[] d();

    int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException;

    int g(int i10);

    int h(int i10);

    int i(byte b10, byte[] bArr, int i10) throws DataLengthException;

    void j(byte b10);

    void k(byte[] bArr, int i10, int i11);

    void reset();
}

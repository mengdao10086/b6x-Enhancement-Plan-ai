package org.bouncycastle.util.test;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class g extends FilterOutputStream {
    public g(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new RuntimeException("close() called on UncloseableOutputStream");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i10, i11);
    }
}

package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtIncompatible
public final class CountingOutputStream extends FilterOutputStream {
    private long count;

    public CountingOutputStream(OutputStream outputStream) {
        super((OutputStream) Preconditions.checkNotNull(outputStream));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    public long getCount() {
        return this.count;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i10, i11);
        this.count += (long) i11;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) throws IOException {
        ((FilterOutputStream) this).out.write(i10);
        this.count++;
    }
}

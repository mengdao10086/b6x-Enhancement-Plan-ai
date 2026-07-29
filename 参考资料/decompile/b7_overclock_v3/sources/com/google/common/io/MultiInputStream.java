package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
final class MultiInputStream extends InputStream {

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    @NullableDecl
    private InputStream f21252in;

    /* JADX INFO: renamed from: it, reason: collision with root package name */
    private Iterator<? extends ByteSource> f21253it;

    public MultiInputStream(Iterator<? extends ByteSource> it2) throws IOException {
        this.f21253it = (Iterator) Preconditions.checkNotNull(it2);
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.f21253it.hasNext()) {
            this.f21252in = this.f21253it.next().openStream();
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.f21252in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f21252in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f21252in = null;
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f21252in;
            if (inputStream == null) {
                return -1;
            }
            int i10 = inputStream.read();
            if (i10 != -1) {
                return i10;
            }
            advance();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        InputStream inputStream = this.f21252in;
        if (inputStream == null || j10 <= 0) {
            return 0L;
        }
        long jSkip = inputStream.skip(j10);
        if (jSkip != 0) {
            return jSkip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f21252in.skip(j10 - 1) + 1;
    }

    @Override // java.io.InputStream
    public int read(@NullableDecl byte[] bArr, int i10, int i11) throws IOException {
        while (true) {
            InputStream inputStream = this.f21252in;
            if (inputStream == null) {
                return -1;
            }
            int i12 = inputStream.read(bArr, i10, i11);
            if (i12 != -1) {
                return i12;
            }
            advance();
        }
    }
}

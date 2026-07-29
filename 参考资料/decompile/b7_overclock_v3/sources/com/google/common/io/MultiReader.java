package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
class MultiReader extends Reader {

    @NullableDecl
    private Reader current;

    /* JADX INFO: renamed from: it, reason: collision with root package name */
    private final Iterator<? extends CharSource> f21254it;

    public MultiReader(Iterator<? extends CharSource> it2) throws IOException {
        this.f21254it = it2;
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.f21254it.hasNext()) {
            this.current = this.f21254it.next().openStream();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader reader = this.current;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.current = null;
            }
        }
    }

    @Override // java.io.Reader
    public int read(@NullableDecl char[] cArr, int i10, int i11) throws IOException {
        Reader reader = this.current;
        if (reader == null) {
            return -1;
        }
        int i12 = reader.read(cArr, i10, i11);
        if (i12 != -1) {
            return i12;
        }
        advance();
        return read(cArr, i10, i11);
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader reader = this.current;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader
    public long skip(long j10) throws IOException {
        Preconditions.checkArgument(j10 >= 0, "n is negative");
        if (j10 > 0) {
            while (true) {
                Reader reader = this.current;
                if (reader == null) {
                    break;
                }
                long jSkip = reader.skip(j10);
                if (jSkip > 0) {
                    return jSkip;
                }
                advance();
            }
        }
        return 0L;
    }
}

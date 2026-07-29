package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
final class CharSequenceReader extends Reader {
    private int mark;
    private int pos;
    private CharSequence seq;

    public CharSequenceReader(CharSequence charSequence) {
        this.seq = (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    private void checkOpen() throws IOException {
        if (this.seq == null) {
            throw new IOException("reader closed");
        }
    }

    private boolean hasRemaining() {
        return remaining() > 0;
    }

    private int remaining() {
        return this.seq.length() - this.pos;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.seq = null;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i10) throws IOException {
        Preconditions.checkArgument(i10 >= 0, "readAheadLimit (%s) may not be negative", i10);
        checkOpen();
        this.mark = this.pos;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer charBuffer) throws IOException {
        Preconditions.checkNotNull(charBuffer);
        checkOpen();
        if (!hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(charBuffer.remaining(), remaining());
        for (int i10 = 0; i10 < iMin; i10++) {
            CharSequence charSequence = this.seq;
            int i11 = this.pos;
            this.pos = i11 + 1;
            charBuffer.put(charSequence.charAt(i11));
        }
        return iMin;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() throws IOException {
        checkOpen();
        return true;
    }

    @Override // java.io.Reader
    public synchronized void reset() throws IOException {
        checkOpen();
        this.pos = this.mark;
    }

    @Override // java.io.Reader
    public synchronized long skip(long j10) throws IOException {
        int iMin;
        Preconditions.checkArgument(j10 >= 0, "n (%s) may not be negative", j10);
        checkOpen();
        iMin = (int) Math.min(remaining(), j10);
        this.pos += iMin;
        return iMin;
    }

    @Override // java.io.Reader
    public synchronized int read() throws IOException {
        int iCharAt;
        checkOpen();
        if (hasRemaining()) {
            CharSequence charSequence = this.seq;
            int i10 = this.pos;
            this.pos = i10 + 1;
            iCharAt = charSequence.charAt(i10);
        } else {
            iCharAt = -1;
        }
        return iCharAt;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cArr, int i10, int i11) throws IOException {
        Preconditions.checkPositionIndexes(i10, i10 + i11, cArr.length);
        checkOpen();
        if (!hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i11, remaining());
        for (int i12 = 0; i12 < iMin; i12++) {
            CharSequence charSequence = this.seq;
            int i13 = this.pos;
            this.pos = i13 + 1;
            cArr[i10 + i12] = charSequence.charAt(i13);
        }
        return iMin;
    }
}

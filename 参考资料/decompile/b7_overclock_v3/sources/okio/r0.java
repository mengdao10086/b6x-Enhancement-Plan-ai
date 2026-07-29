package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lokio/r0;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "Lokio/v0;", "U", "close", "okio"}, k = 1, mv = {1, 5, 1})
public interface r0 extends Closeable, Flushable {
    @yt.k
    v0 U();

    void V0(@yt.k j jVar, long j10) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;
}

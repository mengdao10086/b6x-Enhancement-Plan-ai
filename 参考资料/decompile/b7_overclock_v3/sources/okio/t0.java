package okio;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lokio/t0;", "Ljava/io/Closeable;", "Lokio/Closeable;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lokio/v0;", "U", "Lkotlin/z1;", "close", "okio"}, k = 1, mv = {1, 5, 1})
public interface t0 extends Closeable {
    long F1(@yt.k j jVar, long j10) throws IOException;

    @yt.k
    v0 U();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}

package tl;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okio.j;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Ltl/a;", "", "", "pos", "Lokio/j;", "source", "byteCount", "Lkotlin/z1;", "b", "sink", "a", "Ljava/nio/channels/FileChannel;", "fileChannel", "<init>", "(Ljava/nio/channels/FileChannel;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final FileChannel f51316a;

    public a(@k FileChannel fileChannel) {
        f0.p(fileChannel, "fileChannel");
        this.f51316a = fileChannel;
    }

    public final void a(long j10, @k j sink, long j11) throws IOException {
        f0.p(sink, "sink");
        if (j11 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j11 > 0) {
            long jTransferTo = this.f51316a.transferTo(j10, j11, sink);
            j10 += jTransferTo;
            j11 -= jTransferTo;
        }
    }

    public final void b(long j10, @k j source, long j11) throws IOException {
        f0.p(source, "source");
        if (j11 < 0 || j11 > source.m2()) {
            throw new IndexOutOfBoundsException();
        }
        long j12 = j10;
        long j13 = j11;
        while (j13 > 0) {
            long jTransferFrom = this.f51316a.transferFrom(source, j12, j13);
            j12 += jTransferFrom;
            j13 -= jTransferFrom;
        }
    }
}

package dm;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okio.a0;
import okio.j;
import okio.t0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, d2 = {"Ldm/c;", "Ljava/io/Closeable;", "Lokio/j;", "buffer", "Lkotlin/z1;", "a", "close", "", "noContextTakeover", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class c implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f26313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final j f26314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final Inflater f26315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final a0 f26316d;

    public c(boolean z10) {
        this.f26313a = z10;
        j jVar = new j();
        this.f26314b = jVar;
        Inflater inflater = new Inflater(true);
        this.f26315c = inflater;
        this.f26316d = new a0((t0) jVar, inflater);
    }

    public final void a(@k j buffer) throws IOException {
        f0.p(buffer, "buffer");
        if (!(this.f26314b.m2() == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.f26313a) {
            this.f26315c.reset();
        }
        this.f26314b.X0(buffer);
        this.f26314b.writeInt(65535);
        long bytesRead = this.f26315c.getBytesRead() + this.f26314b.m2();
        do {
            this.f26316d.a(buffer, Long.MAX_VALUE);
        } while (this.f26315c.getBytesRead() < bytesRead);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26316d.close();
    }
}

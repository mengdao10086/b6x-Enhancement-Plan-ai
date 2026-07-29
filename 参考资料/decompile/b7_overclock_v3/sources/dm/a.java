package dm;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okio.ByteString;
import okio.j;
import okio.o;
import okio.r0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0014\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Ldm/a;", "Ljava/io/Closeable;", "Lokio/j;", "buffer", "Lkotlin/z1;", "a", "close", "Lokio/ByteString;", "suffix", "", "c", "noContextTakeover", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f26307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final j f26308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final Deflater f26309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final o f26310d;

    public a(boolean z10) {
        this.f26307a = z10;
        j jVar = new j();
        this.f26308b = jVar;
        Deflater deflater = new Deflater(-1, true);
        this.f26309c = deflater;
        this.f26310d = new o((r0) jVar, deflater);
    }

    public final void a(@k j buffer) throws IOException {
        f0.p(buffer, "buffer");
        if (!(this.f26308b.m2() == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.f26307a) {
            this.f26309c.reset();
        }
        this.f26310d.V0(buffer, buffer.m2());
        this.f26310d.flush();
        if (c(this.f26308b, b.f26311a)) {
            long jM2 = this.f26308b.m2() - ((long) 4);
            j.a aVarZ1 = j.z1(this.f26308b, null, 1, null);
            try {
                aVarZ1.f(jM2);
                kotlin.io.b.a(aVarZ1, null);
            } finally {
            }
        } else {
            this.f26308b.writeByte(0);
        }
        j jVar = this.f26308b;
        buffer.V0(jVar, jVar.m2());
    }

    public final boolean c(j jVar, ByteString byteString) {
        return jVar.N0(jVar.m2() - ((long) byteString.x0()), byteString);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.f26310d.close();
    }
}

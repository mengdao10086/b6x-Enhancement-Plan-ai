package dm;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okio.ByteString;
import okio.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Ldm/i;", "Ljava/io/Closeable;", "Lokio/ByteString;", "payload", "Lkotlin/z1;", "i", "k", "", "code", "reason", "d", "formatOpcode", "data", "h", "close", "opcode", "f", "Lokio/k;", "sink", "Lokio/k;", "c", "()Lokio/k;", "Ljava/util/Random;", "random", "Ljava/util/Random;", "a", "()Ljava/util/Random;", "", "isClient", "perMessageDeflate", "noContextTakeover", "", "minimumDeflateSize", "<init>", "(ZLokio/k;Ljava/util/Random;ZZJ)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f26408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final okio.k f26409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final Random f26410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f26411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f26412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f26413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public final j f26414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public final j f26415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f26416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @l
    public a f26417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @l
    public final byte[] f26418k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @l
    public final j.a f26419l;

    public i(boolean z10, @k okio.k sink, @k Random random, boolean z11, boolean z12, long j10) {
        f0.p(sink, "sink");
        f0.p(random, "random");
        this.f26408a = z10;
        this.f26409b = sink;
        this.f26410c = random;
        this.f26411d = z11;
        this.f26412e = z12;
        this.f26413f = j10;
        this.f26414g = new j();
        this.f26415h = sink.g();
        this.f26418k = z10 ? new byte[4] : null;
        this.f26419l = z10 ? new j.a() : null;
    }

    @k
    public final Random a() {
        return this.f26410c;
    }

    @k
    public final okio.k c() {
        return this.f26409b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        a aVar = this.f26417j;
        if (aVar == null) {
            return;
        }
        aVar.close();
    }

    public final void d(int i10, @l ByteString byteString) throws IOException {
        ByteString byteStringZ0 = ByteString.f44030d;
        if (i10 != 0 || byteString != null) {
            if (i10 != 0) {
                g.f26369a.d(i10);
            }
            j jVar = new j();
            jVar.writeShort(i10);
            if (byteString != null) {
                jVar.B1(byteString);
            }
            byteStringZ0 = jVar.Z0();
        }
        try {
            f(8, byteStringZ0);
        } finally {
            this.f26416i = true;
        }
    }

    public final void f(int i10, ByteString byteString) throws IOException {
        if (this.f26416i) {
            throw new IOException("closed");
        }
        int iX0 = byteString.x0();
        if (!(((long) iX0) <= 125)) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        this.f26415h.writeByte(i10 | 128);
        if (this.f26408a) {
            this.f26415h.writeByte(iX0 | 128);
            Random random = this.f26410c;
            byte[] bArr = this.f26418k;
            f0.m(bArr);
            random.nextBytes(bArr);
            this.f26415h.write(this.f26418k);
            if (iX0 > 0) {
                long jM2 = this.f26415h.m2();
                this.f26415h.B1(byteString);
                j jVar = this.f26415h;
                j.a aVar = this.f26419l;
                f0.m(aVar);
                jVar.u1(aVar);
                this.f26419l.h(jM2);
                g.f26369a.c(this.f26419l, this.f26418k);
                this.f26419l.close();
            }
        } else {
            this.f26415h.writeByte(iX0);
            this.f26415h.B1(byteString);
        }
        this.f26409b.flush();
    }

    public final void h(int i10, @k ByteString data) throws IOException {
        f0.p(data, "data");
        if (this.f26416i) {
            throw new IOException("closed");
        }
        this.f26414g.B1(data);
        int i11 = i10 | 128;
        if (this.f26411d && data.x0() >= this.f26413f) {
            a aVar = this.f26417j;
            if (aVar == null) {
                aVar = new a(this.f26412e);
                this.f26417j = aVar;
            }
            aVar.a(this.f26414g);
            i11 |= 64;
        }
        long jM2 = this.f26414g.m2();
        this.f26415h.writeByte(i11);
        int i12 = this.f26408a ? 128 : 0;
        if (jM2 <= 125) {
            this.f26415h.writeByte(((int) jM2) | i12);
        } else if (jM2 <= g.f26388t) {
            this.f26415h.writeByte(i12 | 126);
            this.f26415h.writeShort((int) jM2);
        } else {
            this.f26415h.writeByte(i12 | 127);
            this.f26415h.writeLong(jM2);
        }
        if (this.f26408a) {
            Random random = this.f26410c;
            byte[] bArr = this.f26418k;
            f0.m(bArr);
            random.nextBytes(bArr);
            this.f26415h.write(this.f26418k);
            if (jM2 > 0) {
                j jVar = this.f26414g;
                j.a aVar2 = this.f26419l;
                f0.m(aVar2);
                jVar.u1(aVar2);
                this.f26419l.h(0L);
                g.f26369a.c(this.f26419l, this.f26418k);
                this.f26419l.close();
            }
        }
        this.f26415h.V0(this.f26414g, jM2);
        this.f26409b.E();
    }

    public final void i(@k ByteString payload) throws IOException {
        f0.p(payload, "payload");
        f(9, payload);
    }

    public final void k(@k ByteString payload) throws IOException {
        f0.p(payload, "payload");
        f(10, payload);
    }
}

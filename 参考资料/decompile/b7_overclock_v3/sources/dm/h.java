package dm;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okio.ByteString;
import okio.j;
import okio.l;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB/\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Ldm/h;", "Ljava/io/Closeable;", "Lkotlin/z1;", "c", "close", "f", "d", "i", "k", "h", "Lokio/l;", "source", "Lokio/l;", "a", "()Lokio/l;", "", "isClient", "Ldm/h$a;", "frameCallback", "perMessageDeflate", "noContextTakeover", "<init>", "(ZLokio/l;Ldm/h$a;ZZ)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f26392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final l f26393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final a f26394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f26395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f26396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f26397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f26398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f26399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f26400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f26401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f26402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @k
    public final j f26403l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @k
    public final j f26404m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.l
    public c f26405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @yt.l
    public final byte[] f26406o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @yt.l
    public final j.a f26407p;

    @d0(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H&¨\u0006\u0010"}, d2 = {"Ldm/h$a;", "", "", "text", "Lkotlin/z1;", "d", "Lokio/ByteString;", "bytes", "c", "payload", "e", "h", "", "code", "reason", "i", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface a {
        void c(@k ByteString byteString) throws IOException;

        void d(@k String str) throws IOException;

        void e(@k ByteString byteString);

        void h(@k ByteString byteString);

        void i(int i10, @k String str);
    }

    public h(boolean z10, @k l source, @k a frameCallback, boolean z11, boolean z12) {
        f0.p(source, "source");
        f0.p(frameCallback, "frameCallback");
        this.f26392a = z10;
        this.f26393b = source;
        this.f26394c = frameCallback;
        this.f26395d = z11;
        this.f26396e = z12;
        this.f26403l = new j();
        this.f26404m = new j();
        this.f26406o = z10 ? null : new byte[4];
        this.f26407p = z10 ? null : new j.a();
    }

    @k
    public final l a() {
        return this.f26393b;
    }

    public final void c() throws IOException {
        f();
        if (this.f26401j) {
            d();
        } else {
            i();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        c cVar = this.f26405n;
        if (cVar == null) {
            return;
        }
        cVar.close();
    }

    public final void d() throws IOException {
        String strY1;
        long j10 = this.f26399h;
        if (j10 > 0) {
            this.f26393b.g0(this.f26403l, j10);
            if (!this.f26392a) {
                j jVar = this.f26403l;
                j.a aVar = this.f26407p;
                f0.m(aVar);
                jVar.u1(aVar);
                this.f26407p.h(0L);
                g gVar = g.f26369a;
                j.a aVar2 = this.f26407p;
                byte[] bArr = this.f26406o;
                f0.m(bArr);
                gVar.c(aVar2, bArr);
                this.f26407p.close();
            }
        }
        switch (this.f26398g) {
            case 8:
                short s10 = 1005;
                long jM2 = this.f26403l.m2();
                if (jM2 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (jM2 != 0) {
                    s10 = this.f26403l.readShort();
                    strY1 = this.f26403l.y1();
                    String strB = g.f26369a.b(s10);
                    if (strB != null) {
                        throw new ProtocolException(strB);
                    }
                } else {
                    strY1 = "";
                }
                this.f26394c.i(s10, strY1);
                this.f26397f = true;
                return;
            case 9:
                this.f26394c.e(this.f26403l.Z0());
                return;
            case 10:
                this.f26394c.h(this.f26403l.Z0());
                return;
            default:
                throw new ProtocolException(f0.C("Unknown control opcode: ", rl.f.d0(this.f26398g)));
        }
    }

    public final void f() throws IOException {
        boolean z10;
        if (this.f26397f) {
            throw new IOException("closed");
        }
        long j10 = this.f26393b.U().j();
        this.f26393b.U().b();
        try {
            int iD = rl.f.d(this.f26393b.readByte(), 255);
            this.f26393b.U().i(j10, TimeUnit.NANOSECONDS);
            int i10 = iD & 15;
            this.f26398g = i10;
            boolean z11 = (iD & 128) != 0;
            this.f26400i = z11;
            boolean z12 = (iD & 8) != 0;
            this.f26401j = z12;
            if (z12 && !z11) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z13 = (iD & 64) != 0;
            if (i10 == 1 || i10 == 2) {
                if (!z13) {
                    z10 = false;
                } else {
                    if (!this.f26395d) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z10 = true;
                }
                this.f26402k = z10;
            } else if (z13) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((iD & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((iD & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int iD2 = rl.f.d(this.f26393b.readByte(), 255);
            boolean z14 = (iD2 & 128) != 0;
            if (z14 == this.f26392a) {
                throw new ProtocolException(this.f26392a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j11 = iD2 & 127;
            this.f26399h = j11;
            if (j11 == 126) {
                this.f26399h = rl.f.e(this.f26393b.readShort(), 65535);
            } else if (j11 == 127) {
                long j12 = this.f26393b.readLong();
                this.f26399h = j12;
                if (j12 < 0) {
                    throw new ProtocolException("Frame length 0x" + rl.f.e0(this.f26399h) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.f26401j && this.f26399h > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z14) {
                l lVar = this.f26393b;
                byte[] bArr = this.f26406o;
                f0.m(bArr);
                lVar.readFully(bArr);
            }
        } catch (Throwable th2) {
            this.f26393b.U().i(j10, TimeUnit.NANOSECONDS);
            throw th2;
        }
    }

    public final void h() throws IOException {
        while (!this.f26397f) {
            long j10 = this.f26399h;
            if (j10 > 0) {
                this.f26393b.g0(this.f26404m, j10);
                if (!this.f26392a) {
                    j jVar = this.f26404m;
                    j.a aVar = this.f26407p;
                    f0.m(aVar);
                    jVar.u1(aVar);
                    this.f26407p.h(this.f26404m.m2() - this.f26399h);
                    g gVar = g.f26369a;
                    j.a aVar2 = this.f26407p;
                    byte[] bArr = this.f26406o;
                    f0.m(bArr);
                    gVar.c(aVar2, bArr);
                    this.f26407p.close();
                }
            }
            if (this.f26400i) {
                return;
            }
            k();
            if (this.f26398g != 0) {
                throw new ProtocolException(f0.C("Expected continuation opcode. Got: ", rl.f.d0(this.f26398g)));
            }
        }
        throw new IOException("closed");
    }

    public final void i() throws IOException {
        int i10 = this.f26398g;
        if (i10 != 1 && i10 != 2) {
            throw new ProtocolException(f0.C("Unknown opcode: ", rl.f.d0(i10)));
        }
        h();
        if (this.f26402k) {
            c cVar = this.f26405n;
            if (cVar == null) {
                cVar = new c(this.f26396e);
                this.f26405n = cVar;
            }
            cVar.a(this.f26404m);
        }
        if (i10 == 1) {
            this.f26394c.d(this.f26404m.y1());
        } else {
            this.f26394c.c(this.f26404m.Z0());
        }
    }

    public final void k() throws IOException {
        while (!this.f26397f) {
            f();
            if (!this.f26401j) {
                return;
            } else {
                d();
            }
        }
    }
}

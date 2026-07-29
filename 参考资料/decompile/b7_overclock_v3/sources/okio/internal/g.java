package okio.internal;

import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.io.EOFException;
import java.io.IOException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import m0.k;
import okio.ByteString;
import okio.n0;
import okio.r0;
import okio.t0;
import okio.v0;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b\u001a\u0015\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0080\b\u001a%\u0010\r\u001a\u00020\t*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u0010\u001a\u00020\t*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0080\b\u001a%\u0010\u0013\u001a\u00020\t*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u0015\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0016H\u0080\b\u001a%\u0010\u0018\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0019H\u0080\b\u001a\u001d\u0010\u001b\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b\u001a\u0015\u0010\u001d\u001a\u00020\t*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020\t*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010 \u001a\u00020\t*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010!\u001a\u00020\t*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\"\u001a\u00020\t*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\t*\u00020\u00002\u0006\u0010 \u001a\u00020\u0003H\u0080\b\u001a\u0015\u0010#\u001a\u00020\t*\u00020\u00002\u0006\u0010 \u001a\u00020\u0003H\u0080\b\u001a\u0015\u0010$\u001a\u00020\t*\u00020\u00002\u0006\u0010 \u001a\u00020\u0003H\u0080\b\u001a\u0015\u0010%\u001a\u00020\t*\u00020\u00002\u0006\u0010 \u001a\u00020\u0003H\u0080\b\u001a\r\u0010&\u001a\u00020\t*\u00020\u0000H\u0080\b\u001a\r\u0010\u001c\u001a\u00020\t*\u00020\u0000H\u0080\b\u001a\r\u0010'\u001a\u00020\u0005*\u00020\u0000H\u0080\b\u001a\r\u0010(\u001a\u00020\u0005*\u00020\u0000H\u0080\b\u001a\r\u0010*\u001a\u00020)*\u00020\u0000H\u0080\b\u001a\r\u0010+\u001a\u00020\u000e*\u00020\u0000H\u0080\b¨\u0006,"}, d2 = {"Lokio/n0;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", l.f16298a, "Lokio/ByteString;", "byteString", "Lokio/k;", "g", "", w.c.R, "h", "", w.b.f53669e, "w", "beginIndex", "endIndex", "x", "codePoint", "y", "", xf.j.f55230b, "k", "Lokio/t0;", k.f40564b, "i", "b", "n", an.aB, "u", "v", "q", SsManifestParser.e.J, "t", "o", "p", "c", "d", "a", "Lokio/v0;", "e", "f", "okio"}, k = 2, mv = {1, 5, 1})
public final class g {
    public static final void a(@yt.k n0 n0Var) throws Throwable {
        f0.p(n0Var, "<this>");
        if (n0Var.f44162c) {
            return;
        }
        Throwable th2 = null;
        try {
            if (n0Var.f44161b.m2() > 0) {
                r0 r0Var = n0Var.f44160a;
                okio.j jVar = n0Var.f44161b;
                r0Var.V0(jVar, jVar.m2());
            }
        } catch (Throwable th3) {
            th2 = th3;
        }
        try {
            n0Var.f44160a.close();
        } catch (Throwable th4) {
            if (th2 == null) {
                th2 = th4;
            }
        }
        n0Var.f44162c = true;
        if (th2 != null) {
            throw th2;
        }
    }

    @yt.k
    public static final okio.k b(@yt.k n0 n0Var) throws IOException {
        f0.p(n0Var, "<this>");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        long jM2 = n0Var.f44161b.m2();
        if (jM2 > 0) {
            n0Var.f44160a.V0(n0Var.f44161b, jM2);
        }
        return n0Var;
    }

    @yt.k
    public static final okio.k c(@yt.k n0 n0Var) throws IOException {
        f0.p(n0Var, "<this>");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        long jH = n0Var.f44161b.h();
        if (jH > 0) {
            n0Var.f44160a.V0(n0Var.f44161b, jH);
        }
        return n0Var;
    }

    public static final void d(@yt.k n0 n0Var) throws IOException {
        f0.p(n0Var, "<this>");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (n0Var.f44161b.m2() > 0) {
            r0 r0Var = n0Var.f44160a;
            okio.j jVar = n0Var.f44161b;
            r0Var.V0(jVar, jVar.m2());
        }
        n0Var.f44160a.flush();
    }

    @yt.k
    public static final v0 e(@yt.k n0 n0Var) {
        f0.p(n0Var, "<this>");
        return n0Var.f44160a.U();
    }

    @yt.k
    public static final String f(@yt.k n0 n0Var) {
        f0.p(n0Var, "<this>");
        return "buffer(" + n0Var.f44160a + ')';
    }

    @yt.k
    public static final okio.k g(@yt.k n0 n0Var, @yt.k ByteString byteString) {
        f0.p(n0Var, "<this>");
        f0.p(byteString, "byteString");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.B1(byteString);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k h(@yt.k n0 n0Var, @yt.k ByteString byteString, int i10, int i11) {
        f0.p(n0Var, "<this>");
        f0.p(byteString, "byteString");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.J(byteString, i10, i11);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k i(@yt.k n0 n0Var, @yt.k t0 source, long j10) throws IOException {
        f0.p(n0Var, "<this>");
        f0.p(source, "source");
        while (j10 > 0) {
            long jF1 = source.F1(n0Var.f44161b, j10);
            if (jF1 == -1) {
                throw new EOFException();
            }
            j10 -= jF1;
            n0Var.l0();
        }
        return n0Var;
    }

    @yt.k
    public static final okio.k j(@yt.k n0 n0Var, @yt.k byte[] source) {
        f0.p(n0Var, "<this>");
        f0.p(source, "source");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.write(source);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k k(@yt.k n0 n0Var, @yt.k byte[] source, int i10, int i11) {
        f0.p(n0Var, "<this>");
        f0.p(source, "source");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.write(source, i10, i11);
        return n0Var.l0();
    }

    public static final void l(@yt.k n0 n0Var, @yt.k okio.j source, long j10) throws IOException {
        f0.p(n0Var, "<this>");
        f0.p(source, "source");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.V0(source, j10);
        n0Var.l0();
    }

    public static final long m(@yt.k n0 n0Var, @yt.k t0 source) throws IOException {
        f0.p(n0Var, "<this>");
        f0.p(source, "source");
        long j10 = 0;
        while (true) {
            long jF1 = source.F1(n0Var.f44161b, 8192L);
            if (jF1 == -1) {
                return j10;
            }
            j10 += jF1;
            n0Var.l0();
        }
    }

    @yt.k
    public static final okio.k n(@yt.k n0 n0Var, int i10) {
        f0.p(n0Var, "<this>");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.writeByte(i10);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k o(@yt.k n0 n0Var, long j10) {
        f0.p(n0Var, "<this>");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.W1(j10);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k p(@yt.k n0 n0Var, long j10) {
        f0.p(n0Var, "<this>");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.Y0(j10);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k q(@yt.k n0 n0Var, int i10) {
        f0.p(n0Var, "<this>");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.writeInt(i10);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k r(@yt.k n0 n0Var, int i10) {
        f0.p(n0Var, "<this>");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.c0(i10);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k s(@yt.k n0 n0Var, long j10) {
        f0.p(n0Var, "<this>");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.writeLong(j10);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k t(@yt.k n0 n0Var, long j10) {
        f0.p(n0Var, "<this>");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.N(j10);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k u(@yt.k n0 n0Var, int i10) {
        f0.p(n0Var, "<this>");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.writeShort(i10);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k v(@yt.k n0 n0Var, int i10) {
        f0.p(n0Var, "<this>");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.D0(i10);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k w(@yt.k n0 n0Var, @yt.k String string) {
        f0.p(n0Var, "<this>");
        f0.p(string, "string");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.H0(string);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k x(@yt.k n0 n0Var, @yt.k String string, int i10, int i11) {
        f0.p(n0Var, "<this>");
        f0.p(string, "string");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.W0(string, i10, i11);
        return n0Var.l0();
    }

    @yt.k
    public static final okio.k y(@yt.k n0 n0Var, int i10) {
        f0.p(n0Var, "<this>");
        if (!(!n0Var.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.f44161b.H(i10);
        return n0Var.l0();
    }
}

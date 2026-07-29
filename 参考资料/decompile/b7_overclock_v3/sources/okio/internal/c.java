package okio.internal;

import androidx.multidex.MultiDexExtractor;
import java.util.ArrayList;
import java.util.List;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okio.k0;
import w.w;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0012\u0012\b\b\u0002\u0010 \u001a\u00020\u001c\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010%\u001a\u00020\u0012¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010 \u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0018\u0010\u001fR\u0019\u0010$\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001d\u0010#R\u0017\u0010%\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b!\u0010\u0016R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020&8\u0006¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b\b\u0010(¨\u0006,"}, d2 = {"Lokio/internal/c;", "", "Lokio/k0;", "a", "Lokio/k0;", "()Lokio/k0;", "canonicalPath", "", "b", "Z", xf.j.f55230b, "()Z", "isDirectory", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "comment", "", "d", "J", "f", "()J", MultiDexExtractor.f6375o, "e", "compressedSize", "i", "size", "", "g", "I", "()I", "compressionMethod", "h", "Ljava/lang/Long;", "()Ljava/lang/Long;", "lastModifiedAtMillis", w.c.R, "", "Ljava/util/List;", "()Ljava/util/List;", "children", "<init>", "(Lokio/k0;ZLjava/lang/String;JJJILjava/lang/Long;J)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final k0 f44096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f44097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final String f44098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f44099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f44100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f44101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f44102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public final Long f44103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f44104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @k
    public final List<k0> f44105j;

    public c(@k k0 canonicalPath, boolean z10, @k String comment, long j10, long j11, long j12, int i10, @l Long l10, long j13) {
        f0.p(canonicalPath, "canonicalPath");
        f0.p(comment, "comment");
        this.f44096a = canonicalPath;
        this.f44097b = z10;
        this.f44098c = comment;
        this.f44099d = j10;
        this.f44100e = j11;
        this.f44101f = j12;
        this.f44102g = i10;
        this.f44103h = l10;
        this.f44104i = j13;
        this.f44105j = new ArrayList();
    }

    @k
    public final k0 a() {
        return this.f44096a;
    }

    @k
    public final List<k0> b() {
        return this.f44105j;
    }

    @k
    public final String c() {
        return this.f44098c;
    }

    public final long d() {
        return this.f44100e;
    }

    public final int e() {
        return this.f44102g;
    }

    public final long f() {
        return this.f44099d;
    }

    @l
    public final Long g() {
        return this.f44103h;
    }

    public final long h() {
        return this.f44104i;
    }

    public final long i() {
        return this.f44101f;
    }

    public final boolean j() {
        return this.f44097b;
    }

    public /* synthetic */ c(k0 k0Var, boolean z10, String str, long j10, long j11, long j12, int i10, Long l10, long j13, int i11, u uVar) {
        this(k0Var, (i11 & 2) != 0 ? false : z10, (i11 & 4) != 0 ? "" : str, (i11 & 8) != 0 ? -1L : j10, (i11 & 16) != 0 ? -1L : j11, (i11 & 32) != 0 ? -1L : j12, (i11 & 64) != 0 ? -1 : i10, (i11 & 128) != 0 ? null : l10, (i11 & 256) == 0 ? j13 : -1L);
    }
}

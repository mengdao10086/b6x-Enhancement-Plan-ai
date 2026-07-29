package okhttp3;

import androidx.lifecycle.r0;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.t0;
import okhttp3.u;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0002\u000e\fB%\b\u0000\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001a\u0010\u0015\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001c\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0004¨\u0006 "}, d2 = {"Lokhttp3/s;", "Lokhttp3/c0;", "", an.aB, "()I", "index", "", "t", "v", "u", "x", "Lokhttp3/w;", "b", "", "a", "Lokio/k;", "sink", "Lkotlin/z1;", SsManifestParser.e.J, "", "countBytes", "y", "", "Ljava/util/List;", "encodedNames", "c", "encodedValues", "w", "size", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "d", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class s extends c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final b f43938d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final w f43939e = w.f43984e.c("application/x-www-form-urlencoded");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final List<String> f43940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final List<String> f43941c;

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/s$b;", "", "Lokhttp3/w;", "CONTENT_TYPE", "Lokhttp3/w;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public s(@yt.k List<String> encodedNames, @yt.k List<String> encodedValues) {
        kotlin.jvm.internal.f0.p(encodedNames, "encodedNames");
        kotlin.jvm.internal.f0.p(encodedValues, "encodedValues");
        this.f43940b = rl.f.h0(encodedNames);
        this.f43941c = rl.f.h0(encodedValues);
    }

    @Override // okhttp3.c0
    public long a() {
        return y(null, true);
    }

    @Override // okhttp3.c0
    @yt.k
    public w b() {
        return f43939e;
    }

    @Override // okhttp3.c0
    public void r(@yt.k okio.k sink) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        y(sink, false);
    }

    @hk.h(name = "-deprecated_size")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "size", imports = {}))
    public final int s() {
        return w();
    }

    @yt.k
    public final String t(int i10) {
        return this.f43940b.get(i10);
    }

    @yt.k
    public final String u(int i10) {
        return this.f43941c.get(i10);
    }

    @yt.k
    public final String v(int i10) {
        return u.b.n(u.f43948k, t(i10), 0, 0, true, 3, null);
    }

    @hk.h(name = "size")
    public final int w() {
        return this.f43940b.size();
    }

    @yt.k
    public final String x(int i10) {
        return u.b.n(u.f43948k, u(i10), 0, 0, true, 3, null);
    }

    public final long y(okio.k kVar, boolean z10) throws EOFException {
        okio.j jVarG;
        if (z10) {
            jVarG = new okio.j();
        } else {
            kotlin.jvm.internal.f0.m(kVar);
            jVarG = kVar.g();
        }
        int i10 = 0;
        int size = this.f43940b.size();
        while (i10 < size) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                jVarG.writeByte(38);
            }
            jVarG.H0(this.f43940b.get(i10));
            jVarG.writeByte(61);
            jVarG.H0(this.f43941c.get(i10));
            i10 = i11;
        }
        if (!z10) {
            return 0L;
        }
        long jM2 = jVarG.m2();
        jVarG.d();
        return jM2;
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\r¨\u0006\u0012"}, d2 = {"Lokhttp3/s$a;", "", "", "name", "value", "a", "b", "Lokhttp3/s;", "c", "Ljava/nio/charset/Charset;", "Ljava/nio/charset/Charset;", "charset", "", "Ljava/util/List;", "names", r0.f6236g, "<init>", "(Ljava/nio/charset/Charset;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.l
        public final Charset f43942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final List<String> f43943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final List<String> f43944c;

        /* JADX WARN: Multi-variable type inference failed */
        @hk.i
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @hk.i
        public a(@yt.l Charset charset) {
            this.f43942a = charset;
            this.f43943b = new ArrayList();
            this.f43944c = new ArrayList();
        }

        @yt.k
        public final a a(@yt.k String name, @yt.k String value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            List<String> list = this.f43943b;
            u.b bVar = u.f43948k;
            list.add(u.b.f(bVar, name, 0, 0, u.f43958u, false, false, true, false, this.f43942a, 91, null));
            this.f43944c.add(u.b.f(bVar, value, 0, 0, u.f43958u, false, false, true, false, this.f43942a, 91, null));
            return this;
        }

        @yt.k
        public final a b(@yt.k String name, @yt.k String value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            List<String> list = this.f43943b;
            u.b bVar = u.f43948k;
            list.add(u.b.f(bVar, name, 0, 0, u.f43958u, true, false, true, false, this.f43942a, 83, null));
            this.f43944c.add(u.b.f(bVar, value, 0, 0, u.f43958u, true, false, true, false, this.f43942a, 83, null));
            return this;
        }

        @yt.k
        public final s c() {
            return new s(this.f43943b, this.f43944c);
        }

        public /* synthetic */ a(Charset charset, int i10, kotlin.jvm.internal.u uVar) {
            this((i10 & 1) != 0 ? null : charset);
        }
    }
}

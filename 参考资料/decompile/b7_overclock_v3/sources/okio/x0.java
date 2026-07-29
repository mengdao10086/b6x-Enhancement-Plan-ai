package okio;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.collections.CollectionsKt___CollectionsKt;
import okio.internal.ZipKt;
import okio.k0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 /2\u00020\u0001:\u00010B7\b\u0000\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0001\u0012\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020'0&\u0012\b\u0010,\u001a\u0004\u0018\u00010*¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\nH\u0002R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010!R\u0014\u0010%\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010(R\u0016\u0010,\u001a\u0004\u0018\u00010*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010+¨\u00061"}, d2 = {"Lokio/x0;", "Lokio/s;", "Lokio/k0;", "path", "h", "Lokio/r;", "D", m7.a.f40702b, "Lokio/q;", i1.a.S4, "", "mustCreate", "mustExist", "G", "dir", "", "x", "y", "Lokio/t0;", "L", "Lokio/r0;", "J", "e", "Lkotlin/z1;", "n", "source", "target", "g", SsManifestParser.e.J, "p", "N", "throwOnFailure", "O", "Lokio/k0;", "zipPath", "f", "Lokio/s;", "fileSystem", "", "Lokio/internal/c;", "Ljava/util/Map;", "entries", "", "Ljava/lang/String;", "comment", "<init>", "(Lokio/k0;Lokio/s;Ljava/util/Map;Ljava/lang/String;)V", "i", "a", "okio"}, k = 1, mv = {1, 5, 1})
public final class x0 extends s {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final a f44242i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    @Deprecated
    public static final k0 f44243j = k0.a.h(k0.f44129b, fh.a.f28350w, false, 1, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final k0 f44244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final s f44245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final Map<k0, okio.internal.c> f44246g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.l
    public final String f44247h;

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokio/x0$a;", "", "Lokio/k0;", "ROOT", "Lokio/k0;", "a", "()Lokio/k0;", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final k0 a() {
            return x0.f44243j;
        }
    }

    public x0(@yt.k k0 zipPath, @yt.k s fileSystem, @yt.k Map<k0, okio.internal.c> entries, @yt.l String str) {
        kotlin.jvm.internal.f0.p(zipPath, "zipPath");
        kotlin.jvm.internal.f0.p(fileSystem, "fileSystem");
        kotlin.jvm.internal.f0.p(entries, "entries");
        this.f44244e = zipPath;
        this.f44245f = fileSystem;
        this.f44246g = entries;
        this.f44247h = str;
    }

    @Override // okio.s
    @yt.l
    public r D(@yt.k k0 path) throws Throwable {
        l lVarE;
        kotlin.jvm.internal.f0.p(path, "path");
        okio.internal.c cVar = this.f44246g.get(N(path));
        Throwable th2 = null;
        if (cVar == null) {
            return null;
        }
        r rVar = new r(!cVar.j(), cVar.j(), null, cVar.j() ? null : Long.valueOf(cVar.i()), null, cVar.g(), null, null, 128, null);
        if (cVar.h() == -1) {
            return rVar;
        }
        q qVarE = this.f44245f.E(this.f44244e);
        try {
            lVarE = f0.e(qVarE.h1(cVar.h()));
        } catch (Throwable th3) {
            th2 = th3;
            lVarE = null;
        }
        if (qVarE != null) {
            try {
                qVarE.close();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                } else {
                    kotlin.o.a(th2, th4);
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
        kotlin.jvm.internal.f0.m(lVarE);
        return ZipKt.i(lVarE, rVar);
    }

    @Override // okio.s
    @yt.k
    public q E(@yt.k k0 file) {
        kotlin.jvm.internal.f0.p(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.s
    @yt.k
    public q G(@yt.k k0 file, boolean z10, boolean z11) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // okio.s
    @yt.k
    public r0 J(@yt.k k0 file, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.s
    @yt.k
    public t0 L(@yt.k k0 path) throws Throwable {
        l lVarE;
        kotlin.jvm.internal.f0.p(path, "path");
        okio.internal.c cVar = this.f44246g.get(N(path));
        if (cVar == null) {
            throw new FileNotFoundException(kotlin.jvm.internal.f0.C("no such file: ", path));
        }
        q qVarE = this.f44245f.E(this.f44244e);
        Throwable th2 = null;
        try {
            lVarE = f0.e(qVarE.h1(cVar.h()));
        } catch (Throwable th3) {
            lVarE = null;
            th2 = th3;
        }
        if (qVarE != null) {
            try {
                qVarE.close();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                } else {
                    kotlin.o.a(th2, th4);
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
        kotlin.jvm.internal.f0.m(lVarE);
        ZipKt.l(lVarE);
        return cVar.e() == 0 ? new okio.internal.b(lVarE, cVar.i(), true) : new okio.internal.b(new a0(new okio.internal.b(lVarE, cVar.d(), true), new Inflater(true)), cVar.i(), false);
    }

    public final k0 N(k0 k0Var) {
        return f44243j.B(k0Var, true);
    }

    public final List<k0> O(k0 k0Var, boolean z10) throws IOException {
        okio.internal.c cVar = this.f44246g.get(N(k0Var));
        if (cVar != null) {
            return CollectionsKt___CollectionsKt.Q5(cVar.b());
        }
        if (z10) {
            throw new IOException(kotlin.jvm.internal.f0.C("not a directory: ", k0Var));
        }
        return null;
    }

    @Override // okio.s
    @yt.k
    public r0 e(@yt.k k0 file, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.s
    public void g(@yt.k k0 source, @yt.k k0 target) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.s
    @yt.k
    public k0 h(@yt.k k0 path) {
        kotlin.jvm.internal.f0.p(path, "path");
        return N(path);
    }

    @Override // okio.s
    public void n(@yt.k k0 dir, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.s
    public void p(@yt.k k0 source, @yt.k k0 target) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.s
    public void r(@yt.k k0 path, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.s
    @yt.k
    public List<k0> x(@yt.k k0 dir) throws IOException {
        kotlin.jvm.internal.f0.p(dir, "dir");
        List<k0> listO = O(dir, true);
        kotlin.jvm.internal.f0.m(listO);
        return listO;
    }

    @Override // okio.s
    @yt.l
    public List<k0> y(@yt.k k0 dir) {
        kotlin.jvm.internal.f0.p(dir, "dir");
        return O(dir, false);
    }
}

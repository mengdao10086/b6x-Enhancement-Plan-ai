package okio;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.util.List;
import okio.internal.ResourceFileSystem;
import okio.internal._FileSystemKt;
import okio.k0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H&J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u0002H&J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0002H&J$\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\bH&J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0002H&J:\u0010 \u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u0012\u001a\u00020\u00022\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00028\u00000\u001c¢\u0006\u0002\b\u001eH\u0087\bø\u0001\u0000¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\bH&J\u000e\u0010$\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0002JD\u0010'\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\b2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00028\u00000\u001c¢\u0006\u0002\b\u001eH\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001a\u0010)\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\bH&J\u000e\u0010*\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0002J\u001a\u0010,\u001a\u00020+2\u0006\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\bH&J\u000e\u0010-\u001a\u00020+2\u0006\u0010\n\u001a\u00020\u0002J\u0018\u0010.\u001a\u00020+2\u0006\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\bJ\u000e\u0010/\u001a\u00020+2\u0006\u0010\n\u001a\u00020\u0002J\u0018\u00102\u001a\u00020+2\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0002H&J\u0018\u00103\u001a\u00020+2\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0002H\u0016J\u001a\u00104\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\bH&J\u000e\u00105\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u00107\u001a\u00020+2\u0006\u00106\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\bH\u0016J\u000e\u00108\u001a\u00020+2\u0006\u00106\u001a\u00020\u0002J\u0018\u00109\u001a\u00020+2\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0002H&\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006<"}, d2 = {"Lokio/s;", "", "Lokio/k0;", "path", "h", "Lokio/r;", "C", "D", "", "w", "dir", "", "x", "y", "followSymlinks", "Lkotlin/sequences/m;", i1.a.W4, an.aD, m7.a.f40702b, "Lokio/q;", i1.a.S4, "mustCreate", "mustExist", "G", "F", "Lokio/t0;", "L", i1.a.f31577d5, "Lkotlin/Function1;", "Lokio/l;", "Lkotlin/t;", "readerAction", "a", "(Lokio/k0;Lik/l;)Ljava/lang/Object;", "Lokio/r0;", "J", "I", "Lokio/k;", "writerAction", "b", "(Lokio/k0;ZLik/l;)Ljava/lang/Object;", "e", "d", "Lkotlin/z1;", "n", m0.k.f40564b, "k", xf.j.f55230b, "source", "target", "g", "i", SsManifestParser.e.J, "q", "fileOrDirectory", "u", "t", "p", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f44203a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final s f44204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final k0 f44205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final s f44206d;

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lokio/s$a;", "", "Lokio/s;", "RESOURCES", "Lokio/s;", "SYSTEM", "Lokio/k0;", "SYSTEM_TEMPORARY_DIRECTORY", "Lokio/k0;", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    static {
        s d0Var;
        try {
            Class.forName("java.nio.file.Files");
            d0Var = new e0();
        } catch (ClassNotFoundException unused) {
            d0Var = new d0();
        }
        f44204b = d0Var;
        k0.a aVar = k0.f44129b;
        String property = System.getProperty("java.io.tmpdir");
        kotlin.jvm.internal.f0.o(property, "getProperty(\"java.io.tmpdir\")");
        f44205c = k0.a.h(aVar, property, false, 1, null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        kotlin.jvm.internal.f0.o(classLoader, "ResourceFileSystem::class.java.classLoader");
        f44206d = new ResourceFileSystem(classLoader, false);
    }

    public static /* synthetic */ kotlin.sequences.m B(s sVar, k0 k0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return sVar.A(k0Var, z10);
    }

    public static /* synthetic */ q H(s sVar, k0 k0Var, boolean z10, boolean z11, int i10, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        return sVar.G(k0Var, z10, z11);
    }

    public static /* synthetic */ r0 K(s sVar, k0 k0Var, boolean z10, int i10, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return sVar.J(k0Var, z10);
    }

    public static /* synthetic */ Object c(s sVar, k0 file, boolean z10, ik.l writerAction, int i10, Object obj) throws Throwable {
        Object objI;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        kotlin.jvm.internal.f0.p(file, "file");
        kotlin.jvm.internal.f0.p(writerAction, "writerAction");
        k kVarD = f0.d(sVar.J(file, z10));
        Throwable th2 = null;
        try {
            objI = writerAction.i(kVarD);
        } catch (Throwable th3) {
            objI = null;
            th2 = th3;
        }
        if (kVarD != null) {
            try {
                kVarD.close();
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
        kotlin.jvm.internal.f0.m(objI);
        return objI;
    }

    public static /* synthetic */ r0 f(s sVar, k0 k0Var, boolean z10, int i10, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return sVar.e(k0Var, z10);
    }

    public static /* synthetic */ void l(s sVar, k0 k0Var, boolean z10, int i10, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        sVar.k(k0Var, z10);
    }

    public static /* synthetic */ void o(s sVar, k0 k0Var, boolean z10, int i10, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        sVar.n(k0Var, z10);
    }

    public static /* synthetic */ void s(s sVar, k0 k0Var, boolean z10, int i10, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        sVar.r(k0Var, z10);
    }

    public static /* synthetic */ void v(s sVar, k0 k0Var, boolean z10, int i10, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        sVar.u(k0Var, z10);
    }

    @yt.k
    public kotlin.sequences.m<k0> A(@yt.k k0 dir, boolean z10) {
        kotlin.jvm.internal.f0.p(dir, "dir");
        return _FileSystemKt.f(this, dir, z10);
    }

    @yt.k
    public final r C(@yt.k k0 path) throws IOException {
        kotlin.jvm.internal.f0.p(path, "path");
        return _FileSystemKt.g(this, path);
    }

    @yt.l
    public abstract r D(@yt.k k0 k0Var) throws IOException;

    @yt.k
    public abstract q E(@yt.k k0 k0Var) throws IOException;

    @yt.k
    public final q F(@yt.k k0 file) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        return G(file, false, false);
    }

    @yt.k
    public abstract q G(@yt.k k0 k0Var, boolean z10, boolean z11) throws IOException;

    @yt.k
    public final r0 I(@yt.k k0 file) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        return J(file, false);
    }

    @yt.k
    public abstract r0 J(@yt.k k0 k0Var, boolean z10) throws IOException;

    @yt.k
    public abstract t0 L(@yt.k k0 k0Var) throws IOException;

    @hk.h(name = "-read")
    public final <T> T a(@yt.k k0 file, @yt.k ik.l<? super l, ? extends T> readerAction) throws Throwable {
        T tI;
        kotlin.jvm.internal.f0.p(file, "file");
        kotlin.jvm.internal.f0.p(readerAction, "readerAction");
        l lVarE = f0.e(L(file));
        Throwable th2 = null;
        try {
            tI = readerAction.i(lVarE);
        } catch (Throwable th3) {
            th2 = th3;
            tI = null;
        }
        if (lVarE != null) {
            try {
                lVarE.close();
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
        kotlin.jvm.internal.f0.m(tI);
        return tI;
    }

    @hk.h(name = "-write")
    public final <T> T b(@yt.k k0 file, boolean z10, @yt.k ik.l<? super k, ? extends T> writerAction) throws Throwable {
        T tI;
        kotlin.jvm.internal.f0.p(file, "file");
        kotlin.jvm.internal.f0.p(writerAction, "writerAction");
        k kVarD = f0.d(J(file, z10));
        Throwable th2 = null;
        try {
            tI = writerAction.i(kVarD);
        } catch (Throwable th3) {
            tI = null;
            th2 = th3;
        }
        if (kVarD != null) {
            try {
                kVarD.close();
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
        kotlin.jvm.internal.f0.m(tI);
        return tI;
    }

    @yt.k
    public final r0 d(@yt.k k0 file) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        return e(file, false);
    }

    @yt.k
    public abstract r0 e(@yt.k k0 k0Var, boolean z10) throws IOException;

    public abstract void g(@yt.k k0 k0Var, @yt.k k0 k0Var2) throws IOException;

    @yt.k
    public abstract k0 h(@yt.k k0 k0Var) throws IOException;

    public void i(@yt.k k0 source, @yt.k k0 target) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(target, "target");
        _FileSystemKt.b(this, source, target);
    }

    public final void j(@yt.k k0 dir) throws IOException {
        kotlin.jvm.internal.f0.p(dir, "dir");
        k(dir, false);
    }

    public final void k(@yt.k k0 dir, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(dir, "dir");
        _FileSystemKt.c(this, dir, z10);
    }

    public final void m(@yt.k k0 dir) throws IOException {
        kotlin.jvm.internal.f0.p(dir, "dir");
        n(dir, false);
    }

    public abstract void n(@yt.k k0 k0Var, boolean z10) throws IOException;

    public abstract void p(@yt.k k0 k0Var, @yt.k k0 k0Var2) throws IOException;

    public final void q(@yt.k k0 path) throws IOException {
        kotlin.jvm.internal.f0.p(path, "path");
        r(path, false);
    }

    public abstract void r(@yt.k k0 k0Var, boolean z10) throws IOException;

    public final void t(@yt.k k0 fileOrDirectory) throws IOException {
        kotlin.jvm.internal.f0.p(fileOrDirectory, "fileOrDirectory");
        u(fileOrDirectory, false);
    }

    public void u(@yt.k k0 fileOrDirectory, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(fileOrDirectory, "fileOrDirectory");
        _FileSystemKt.d(this, fileOrDirectory, z10);
    }

    public final boolean w(@yt.k k0 path) throws IOException {
        kotlin.jvm.internal.f0.p(path, "path");
        return _FileSystemKt.e(this, path);
    }

    @yt.k
    public abstract List<k0> x(@yt.k k0 k0Var) throws IOException;

    @yt.l
    public abstract List<k0> y(@yt.k k0 k0Var);

    @yt.k
    public final kotlin.sequences.m<k0> z(@yt.k k0 dir) {
        kotlin.jvm.internal.f0.p(dir, "dir");
        return A(dir, false);
    }
}

package okio;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import okio.k0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J \u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J \u0010!\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u000eH\u0002J\f\u0010\"\u001a\u00020\u0017*\u00020\u0002H\u0002J\f\u0010#\u001a\u00020\u0017*\u00020\u0002H\u0002¨\u0006&"}, d2 = {"Lokio/d0;", "Lokio/s;", "Lokio/k0;", "path", "h", "Lokio/r;", "D", "dir", "", "x", "y", m7.a.f40702b, "Lokio/q;", i1.a.S4, "", "mustCreate", "mustExist", "G", "Lokio/t0;", "L", "Lokio/r0;", "J", "e", "Lkotlin/z1;", "n", "source", "target", "g", SsManifestParser.e.J, "p", "", "toString", "throwOnFailure", "M", "O", "N", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
public class d0 extends s {
    @Override // okio.s
    @yt.l
    public r D(@yt.k k0 path) {
        kotlin.jvm.internal.f0.p(path, "path");
        File fileG = path.G();
        boolean zIsFile = fileG.isFile();
        boolean zIsDirectory = fileG.isDirectory();
        long jLastModified = fileG.lastModified();
        long length = fileG.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || fileG.exists()) {
            return new r(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null, null, 128, null);
        }
        return null;
    }

    @Override // okio.s
    @yt.k
    public q E(@yt.k k0 file) {
        kotlin.jvm.internal.f0.p(file, "file");
        return new c0(false, new RandomAccessFile(file.G(), SsManifestParser.e.J));
    }

    @Override // okio.s
    @yt.k
    public q G(@yt.k k0 file, boolean z10, boolean z11) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        if (!((z10 && z11) ? false : true)) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
        }
        if (z10) {
            N(file);
        }
        if (z11) {
            O(file);
        }
        return new c0(true, new RandomAccessFile(file.G(), "rw"));
    }

    @Override // okio.s
    @yt.k
    public r0 J(@yt.k k0 file, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        if (z10) {
            N(file);
        }
        return g0.q(file.G(), false, 1, null);
    }

    @Override // okio.s
    @yt.k
    public t0 L(@yt.k k0 file) {
        kotlin.jvm.internal.f0.p(file, "file");
        return f0.t(file.G());
    }

    public final List<k0> M(k0 k0Var, boolean z10) throws IOException {
        File fileG = k0Var.G();
        String[] list = fileG.list();
        if (list == null) {
            if (!z10) {
                return null;
            }
            if (fileG.exists()) {
                throw new IOException(kotlin.jvm.internal.f0.C("failed to list ", k0Var));
            }
            throw new FileNotFoundException(kotlin.jvm.internal.f0.C("no such file: ", k0Var));
        }
        ArrayList arrayList = new ArrayList();
        for (String it2 : list) {
            kotlin.jvm.internal.f0.o(it2, "it");
            arrayList.add(k0Var.v(it2));
        }
        kotlin.collections.w.j0(arrayList);
        return arrayList;
    }

    public final void N(k0 k0Var) throws IOException {
        if (w(k0Var)) {
            throw new IOException(k0Var + " already exists.");
        }
    }

    public final void O(k0 k0Var) throws IOException {
        if (w(k0Var)) {
            return;
        }
        throw new IOException(k0Var + " doesn't exist.");
    }

    @Override // okio.s
    @yt.k
    public r0 e(@yt.k k0 file, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        if (z10) {
            O(file);
        }
        return f0.o(file.G(), true);
    }

    @Override // okio.s
    public void g(@yt.k k0 source, @yt.k k0 target) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(target, "target");
        if (source.G().renameTo(target.G())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // okio.s
    @yt.k
    public k0 h(@yt.k k0 path) throws IOException {
        kotlin.jvm.internal.f0.p(path, "path");
        File canonicalFile = path.G().getCanonicalFile();
        if (!canonicalFile.exists()) {
            throw new FileNotFoundException("no such file");
        }
        k0.a aVar = k0.f44129b;
        kotlin.jvm.internal.f0.o(canonicalFile, "canonicalFile");
        return k0.a.g(aVar, canonicalFile, false, 1, null);
    }

    @Override // okio.s
    public void n(@yt.k k0 dir, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(dir, "dir");
        if (dir.G().mkdir()) {
            return;
        }
        r rVarD = D(dir);
        boolean z11 = false;
        if (rVarD != null && rVarD.j()) {
            z11 = true;
        }
        if (!z11) {
            throw new IOException(kotlin.jvm.internal.f0.C("failed to create directory: ", dir));
        }
        if (z10) {
            throw new IOException(dir + " already exist.");
        }
    }

    @Override // okio.s
    public void p(@yt.k k0 source, @yt.k k0 target) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(target, "target");
        throw new IOException("unsupported");
    }

    @Override // okio.s
    public void r(@yt.k k0 path, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(path, "path");
        File fileG = path.G();
        if (fileG.delete()) {
            return;
        }
        if (fileG.exists()) {
            throw new IOException(kotlin.jvm.internal.f0.C("failed to delete ", path));
        }
        if (z10) {
            throw new FileNotFoundException(kotlin.jvm.internal.f0.C("no such file: ", path));
        }
    }

    @yt.k
    public String toString() {
        return "JvmSystemFileSystem";
    }

    @Override // okio.s
    @yt.k
    public List<k0> x(@yt.k k0 dir) throws IOException {
        kotlin.jvm.internal.f0.p(dir, "dir");
        List<k0> listM = M(dir, true);
        kotlin.jvm.internal.f0.m(listM);
        return listM;
    }

    @Override // okio.s
    @yt.l
    public List<k0> y(@yt.k k0 dir) {
        kotlin.jvm.internal.f0.p(dir, "dir");
        return M(dir, false);
    }
}

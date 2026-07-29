package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.o;
import kotlin.sequences.m;
import kotlin.sequences.q;
import okio.k0;
import okio.r;
import okio.s;
import okio.t0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\r\u001a\u00020\t*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\t*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0005H\u0000\u001a\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0005H\u0000\u001aK\u0010\u0019\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lokio/s;", "Lokio/k0;", "path", "Lokio/r;", "g", "", "e", "dir", "mustCreate", "Lkotlin/z1;", "c", "source", "target", "b", "fileOrDirectory", "mustExist", "d", "followSymlinks", "Lkotlin/sequences/m;", "f", "Lkotlin/sequences/o;", "fileSystem", "Lkotlin/collections/i;", "stack", "postorder", "a", "(Lkotlin/sequences/o;Lokio/s;Lkotlin/collections/i;Lokio/k0;ZZLkotlin/coroutines/c;)Ljava/lang/Object;", "h", "okio"}, k = 2, mv = {1, 5, 1})
public final class _FileSystemKt {
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d6, code lost:
    
        if (r0 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d8, code lost:
    
        if (r14 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00da, code lost:
    
        r6.addLast(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e1, code lost:
    
        r13 = r12;
        r12 = r11;
        r11 = r6;
        r6 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0125, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0126, code lost:
    
        r11 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4, types: [kotlin.sequences.o] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.Object, kotlin.sequences.o, kotlin.sequences.o<? super okio.k0>] */
    /* JADX WARN: Type inference failed for: r17v1, types: [kotlin.sequences.o] */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(@yt.k kotlin.sequences.o<? super okio.k0> r17, @yt.k okio.s r18, @yt.k kotlin.collections.i<okio.k0> r19, @yt.k okio.k0 r20, boolean r21, boolean r22, @yt.k kotlin.coroutines.c<? super kotlin.z1> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._FileSystemKt.a(kotlin.sequences.o, okio.s, kotlin.collections.i, okio.k0, boolean, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public static final void b(@k s sVar, @k k0 source, @k k0 target) throws IOException {
        Long lValueOf;
        Long lValueOf2;
        f0.p(sVar, "<this>");
        f0.p(source, "source");
        f0.p(target, "target");
        t0 t0VarL = sVar.L(source);
        Throwable th2 = null;
        try {
            okio.k kVarD = okio.f0.d(sVar.I(target));
            try {
                lValueOf2 = Long.valueOf(kVarD.X0(t0VarL));
                th = null;
            } catch (Throwable th3) {
                th = th3;
                lValueOf2 = null;
            }
            if (kVarD != null) {
                try {
                    kVarD.close();
                } catch (Throwable th4) {
                    if (th == null) {
                        th = th4;
                    } else {
                        o.a(th, th4);
                    }
                }
            }
        } catch (Throwable th5) {
            th2 = th5;
            lValueOf = null;
        }
        if (th != null) {
            throw th;
        }
        f0.m(lValueOf2);
        lValueOf = Long.valueOf(lValueOf2.longValue());
        if (t0VarL != null) {
            try {
                t0VarL.close();
            } catch (Throwable th6) {
                if (th2 == null) {
                    th2 = th6;
                } else {
                    o.a(th2, th6);
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
        f0.m(lValueOf);
    }

    public static final void c(@k s sVar, @k k0 dir, boolean z10) throws IOException {
        f0.p(sVar, "<this>");
        f0.p(dir, "dir");
        kotlin.collections.i iVar = new kotlin.collections.i();
        for (k0 k0VarT = dir; k0VarT != null && !sVar.w(k0VarT); k0VarT = k0VarT.t()) {
            iVar.addFirst(k0VarT);
        }
        if (z10 && iVar.isEmpty()) {
            throw new IOException(dir + " already exist.");
        }
        Iterator<E> it2 = iVar.iterator();
        while (it2.hasNext()) {
            sVar.m((k0) it2.next());
        }
    }

    public static final void d(@k s sVar, @k k0 fileOrDirectory, boolean z10) throws IOException {
        f0.p(sVar, "<this>");
        f0.p(fileOrDirectory, "fileOrDirectory");
        Iterator it2 = q.b(new _FileSystemKt$commonDeleteRecursively$sequence$1(sVar, fileOrDirectory, null)).iterator();
        while (it2.hasNext()) {
            sVar.r((k0) it2.next(), z10 && !it2.hasNext());
        }
    }

    public static final boolean e(@k s sVar, @k k0 path) throws IOException {
        f0.p(sVar, "<this>");
        f0.p(path, "path");
        return sVar.D(path) != null;
    }

    @k
    public static final m<k0> f(@k s sVar, @k k0 dir, boolean z10) throws IOException {
        f0.p(sVar, "<this>");
        f0.p(dir, "dir");
        return q.b(new _FileSystemKt$commonListRecursively$1(dir, sVar, z10, null));
    }

    @k
    public static final r g(@k s sVar, @k k0 path) throws IOException {
        f0.p(sVar, "<this>");
        f0.p(path, "path");
        r rVarD = sVar.D(path);
        if (rVarD != null) {
            return rVarD;
        }
        throw new FileNotFoundException(f0.C("no such file: ", path));
    }

    @l
    public static final k0 h(@k s sVar, @k k0 path) throws IOException {
        f0.p(sVar, "<this>");
        f0.p(path, "path");
        k0 k0VarI = sVar.C(path).i();
        if (k0VarI == null) {
            return null;
        }
        k0 k0VarT = path.t();
        f0.m(k0VarT);
        return k0VarT.A(k0VarI);
    }
}

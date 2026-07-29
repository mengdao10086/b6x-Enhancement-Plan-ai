package okio;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010*\u001a\u00020\u0001¢\u0006\u0004\b+\u0010,J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J \u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0016J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\u0017\u0010*\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\u001e\u0010'\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lokio/ForwardingFileSystem;", "Lokio/s;", "Lokio/k0;", "path", "", "functionName", "parameterName", "N", "O", "h", "Lokio/r;", "D", "dir", "", "x", "y", "", "followSymlinks", "Lkotlin/sequences/m;", i1.a.W4, m7.a.f40702b, "Lokio/q;", i1.a.S4, "mustCreate", "mustExist", "G", "Lokio/t0;", "L", "Lokio/r0;", "J", "e", "Lkotlin/z1;", "n", "source", "target", "g", SsManifestParser.e.J, "p", "toString", "Lokio/s;", "M", "()Lokio/s;", "delegate", "<init>", "(Lokio/s;)V", "okio"}, k = 1, mv = {1, 5, 1})
public abstract class ForwardingFileSystem extends s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final s f44033e;

    public ForwardingFileSystem(@yt.k s delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        this.f44033e = delegate;
    }

    @Override // okio.s
    @yt.k
    public kotlin.sequences.m<k0> A(@yt.k k0 dir, boolean z10) {
        kotlin.jvm.internal.f0.p(dir, "dir");
        return SequencesKt___SequencesKt.k1(this.f44033e.A(N(dir, "listRecursively", "dir"), z10), new ik.l<k0, k0>() { // from class: okio.ForwardingFileSystem$listRecursively$1
            {
                super(1);
            }

            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final k0 i(@yt.k k0 it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return this.this$0.O(it2, "listRecursively");
            }
        });
    }

    @Override // okio.s
    @yt.l
    public r D(@yt.k k0 path) throws IOException {
        kotlin.jvm.internal.f0.p(path, "path");
        r rVarD = this.f44033e.D(N(path, "metadataOrNull", "path"));
        if (rVarD == null) {
            return null;
        }
        return rVarD.i() == null ? rVarD : rVarD.a((mb.e.f41067u1 & 1) != 0 ? rVarD.f44195a : false, (mb.e.f41067u1 & 2) != 0 ? rVarD.f44196b : false, (mb.e.f41067u1 & 4) != 0 ? rVarD.f44197c : O(rVarD.i(), "metadataOrNull"), (mb.e.f41067u1 & 8) != 0 ? rVarD.f44198d : null, (mb.e.f41067u1 & 16) != 0 ? rVarD.f44199e : null, (mb.e.f41067u1 & 32) != 0 ? rVarD.f44200f : null, (mb.e.f41067u1 & 64) != 0 ? rVarD.f44201g : null, (mb.e.f41067u1 & 128) != 0 ? rVarD.f44202h : null);
    }

    @Override // okio.s
    @yt.k
    public q E(@yt.k k0 file) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        return this.f44033e.E(N(file, "openReadOnly", m7.a.f40702b));
    }

    @Override // okio.s
    @yt.k
    public q G(@yt.k k0 file, boolean z10, boolean z11) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        return this.f44033e.G(N(file, "openReadWrite", m7.a.f40702b), z10, z11);
    }

    @Override // okio.s
    @yt.k
    public r0 J(@yt.k k0 file, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        return this.f44033e.J(N(file, "sink", m7.a.f40702b), z10);
    }

    @Override // okio.s
    @yt.k
    public t0 L(@yt.k k0 file) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        return this.f44033e.L(N(file, "source", m7.a.f40702b));
    }

    @hk.h(name = "delegate")
    @yt.k
    public final s M() {
        return this.f44033e;
    }

    @yt.k
    public k0 N(@yt.k k0 path, @yt.k String functionName, @yt.k String parameterName) {
        kotlin.jvm.internal.f0.p(path, "path");
        kotlin.jvm.internal.f0.p(functionName, "functionName");
        kotlin.jvm.internal.f0.p(parameterName, "parameterName");
        return path;
    }

    @yt.k
    public k0 O(@yt.k k0 path, @yt.k String functionName) {
        kotlin.jvm.internal.f0.p(path, "path");
        kotlin.jvm.internal.f0.p(functionName, "functionName");
        return path;
    }

    @Override // okio.s
    @yt.k
    public r0 e(@yt.k k0 file, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(file, "file");
        return this.f44033e.e(N(file, "appendingSink", m7.a.f40702b), z10);
    }

    @Override // okio.s
    public void g(@yt.k k0 source, @yt.k k0 target) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(target, "target");
        this.f44033e.g(N(source, "atomicMove", "source"), N(target, "atomicMove", "target"));
    }

    @Override // okio.s
    @yt.k
    public k0 h(@yt.k k0 path) throws IOException {
        kotlin.jvm.internal.f0.p(path, "path");
        return O(this.f44033e.h(N(path, "canonicalize", "path")), "canonicalize");
    }

    @Override // okio.s
    public void n(@yt.k k0 dir, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(dir, "dir");
        this.f44033e.n(N(dir, "createDirectory", "dir"), z10);
    }

    @Override // okio.s
    public void p(@yt.k k0 source, @yt.k k0 target) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(target, "target");
        this.f44033e.p(N(source, "createSymlink", "source"), N(target, "createSymlink", "target"));
    }

    @Override // okio.s
    public void r(@yt.k k0 path, boolean z10) throws IOException {
        kotlin.jvm.internal.f0.p(path, "path");
        this.f44033e.r(N(path, "delete", "path"), z10);
    }

    @yt.k
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) kotlin.jvm.internal.n0.d(getClass()).K());
        sb2.append('(');
        sb2.append(this.f44033e);
        sb2.append(')');
        return sb2.toString();
    }

    @Override // okio.s
    @yt.k
    public List<k0> x(@yt.k k0 dir) throws IOException {
        kotlin.jvm.internal.f0.p(dir, "dir");
        List<k0> listX = this.f44033e.x(N(dir, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = listX.iterator();
        while (it2.hasNext()) {
            arrayList.add(O((k0) it2.next(), "list"));
        }
        kotlin.collections.w.j0(arrayList);
        return arrayList;
    }

    @Override // okio.s
    @yt.l
    public List<k0> y(@yt.k k0 dir) {
        kotlin.jvm.internal.f0.p(dir, "dir");
        List<k0> listY = this.f44033e.y(N(dir, "listOrNull", "dir"));
        if (listY == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = listY.iterator();
        while (it2.hasNext()) {
            arrayList.add(O((k0) it2.next(), "listOrNull"));
        }
        kotlin.collections.w.j0(arrayList);
        return arrayList;
    }
}

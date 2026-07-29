package okio.internal;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.b0;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.collections.x;
import kotlin.d0;
import kotlin.d1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.StringsKt__StringsKt;
import kotlin.z;
import okio.k0;
import okio.q;
import okio.r;
import okio.r0;
import okio.s;
import okio.t0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001,B\u0019\b\u0000\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010(\u001a\u00020\f¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010 \u001a\u00020\u001f*\u00020\u0002H\u0002R-\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020!0\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b#\u0010$¨\u0006-"}, d2 = {"Lokio/internal/ResourceFileSystem;", "Lokio/s;", "Lokio/k0;", "path", "h", "dir", "", "x", "y", m7.a.f40702b, "Lokio/q;", i1.a.S4, "", "mustCreate", "mustExist", "G", "Lokio/r;", "D", "Lokio/t0;", "L", "Lokio/r0;", "J", "e", "Lkotlin/z1;", "n", "source", "target", "g", SsManifestParser.e.J, "p", "O", "", "Q", "Lkotlin/Pair;", "Lkotlin/z;", "P", "()Ljava/util/List;", "roots", "Ljava/lang/ClassLoader;", "classLoader", "indexEagerly", "<init>", "(Ljava/lang/ClassLoader;Z)V", "f", "Companion", "okio"}, k = 1, mv = {1, 5, 1})
public final class ResourceFileSystem extends s {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public static final Companion f44073f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    @Deprecated
    public static final k0 f44074g = k0.a.h(k0.f44129b, fh.a.f28350w, false, 1, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public final z f44075e;

    @d0(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006*\u00020\u0005J\u0018\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007*\u00020\nJ\u0018\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007*\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lokio/internal/ResourceFileSystem$Companion;", "", "Lokio/k0;", xc.d.W, "d", "Ljava/lang/ClassLoader;", "", "Lkotlin/Pair;", "Lokio/s;", "e", "Ljava/net/URL;", "f", "g", "path", "", "c", "ROOT", "Lokio/k0;", "b", "()Lokio/k0;", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }

        @k
        public final k0 b() {
            return ResourceFileSystem.f44074g;
        }

        public final boolean c(k0 k0Var) {
            return !kotlin.text.u.J1(k0Var.q(), ".class", true);
        }

        @k
        public final k0 d(@k k0 k0Var, @k k0 base) {
            f0.p(k0Var, "<this>");
            f0.p(base, "base");
            return b().v(kotlin.text.u.k2(StringsKt__StringsKt.d4(k0Var.toString(), base.toString()), '\\', zc.f.f58380j, false, 4, null));
        }

        @k
        public final List<Pair<s, k0>> e(@k ClassLoader classLoader) throws IOException {
            f0.p(classLoader, "<this>");
            Enumeration<URL> resources = classLoader.getResources("");
            f0.o(resources, "getResources(\"\")");
            ArrayList<URL> list = Collections.list(resources);
            f0.o(list, "java.util.Collections.list(this)");
            ArrayList arrayList = new ArrayList();
            for (URL it2 : list) {
                Companion companion = ResourceFileSystem.f44073f;
                f0.o(it2, "it");
                Pair<s, k0> pairF = companion.f(it2);
                if (pairF != null) {
                    arrayList.add(pairF);
                }
            }
            Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
            f0.o(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
            ArrayList<URL> list2 = Collections.list(resources2);
            f0.o(list2, "java.util.Collections.list(this)");
            ArrayList arrayList2 = new ArrayList();
            for (URL it3 : list2) {
                Companion companion2 = ResourceFileSystem.f44073f;
                f0.o(it3, "it");
                Pair<s, k0> pairG = companion2.g(it3);
                if (pairG != null) {
                    arrayList2.add(pairG);
                }
            }
            return CollectionsKt___CollectionsKt.y4(arrayList, arrayList2);
        }

        @l
        public final Pair<s, k0> f(@k URL url) {
            f0.p(url, "<this>");
            if (f0.g(url.getProtocol(), m7.a.f40702b)) {
                return d1.a(s.f44204b, k0.a.g(k0.f44129b, new File(url.toURI()), false, 1, null));
            }
            return null;
        }

        @l
        public final Pair<s, k0> g(@k URL url) {
            int iG3;
            f0.p(url, "<this>");
            String string = url.toString();
            f0.o(string, "toString()");
            if (!kotlin.text.u.v2(string, "jar:file:", false, 2, null) || (iG3 = StringsKt__StringsKt.G3(string, "!", 0, false, 6, null)) == -1) {
                return null;
            }
            k0.a aVar = k0.f44129b;
            String strSubstring = string.substring(4, iG3);
            f0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return d1.a(ZipKt.d(k0.a.g(aVar, new File(URI.create(strSubstring)), false, 1, null), s.f44204b, new ik.l<c, Boolean>() { // from class: okio.internal.ResourceFileSystem$Companion$toJarRoot$zip$1
                @Override // ik.l
                @k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Boolean i(@k c entry) {
                    f0.p(entry, "entry");
                    return Boolean.valueOf(ResourceFileSystem.f44073f.c(entry.a()));
                }
            }), b());
        }
    }

    public ResourceFileSystem(@k final ClassLoader classLoader, boolean z10) {
        f0.p(classLoader, "classLoader");
        this.f44075e = b0.a(new ik.a<List<? extends Pair<? extends s, ? extends k0>>>() { // from class: okio.internal.ResourceFileSystem$roots$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final List<Pair<s, k0>> o() {
                return ResourceFileSystem.f44073f.e(classLoader);
            }
        });
        if (z10) {
            P().size();
        }
    }

    @Override // okio.s
    @l
    public r D(@k k0 path) throws IOException {
        f0.p(path, "path");
        if (!f44073f.c(path)) {
            return null;
        }
        String strQ = Q(path);
        for (Pair<s, k0> pair : P()) {
            r rVarD = pair.a().D(pair.b().v(strQ));
            if (rVarD != null) {
                return rVarD;
            }
        }
        return null;
    }

    @Override // okio.s
    @k
    public q E(@k k0 file) throws FileNotFoundException {
        f0.p(file, "file");
        if (!f44073f.c(file)) {
            throw new FileNotFoundException(f0.C("file not found: ", file));
        }
        String strQ = Q(file);
        for (Pair<s, k0> pair : P()) {
            try {
                return pair.a().E(pair.b().v(strQ));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException(f0.C("file not found: ", file));
    }

    @Override // okio.s
    @k
    public q G(@k k0 file, boolean z10, boolean z11) throws IOException {
        f0.p(file, "file");
        throw new IOException("resources are not writable");
    }

    @Override // okio.s
    @k
    public r0 J(@k k0 file, boolean z10) throws IOException {
        f0.p(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.s
    @k
    public t0 L(@k k0 file) throws FileNotFoundException {
        f0.p(file, "file");
        if (!f44073f.c(file)) {
            throw new FileNotFoundException(f0.C("file not found: ", file));
        }
        String strQ = Q(file);
        for (Pair<s, k0> pair : P()) {
            try {
                return pair.a().L(pair.b().v(strQ));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException(f0.C("file not found: ", file));
    }

    public final k0 O(k0 k0Var) {
        return f44074g.B(k0Var, true);
    }

    public final List<Pair<s, k0>> P() {
        return (List) this.f44075e.getValue();
    }

    public final String Q(k0 k0Var) {
        return O(k0Var).u(f44074g).toString();
    }

    @Override // okio.s
    @k
    public r0 e(@k k0 file, boolean z10) throws IOException {
        f0.p(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.s
    public void g(@k k0 source, @k k0 target) throws IOException {
        f0.p(source, "source");
        f0.p(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.s
    @k
    public k0 h(@k k0 path) {
        f0.p(path, "path");
        return O(path);
    }

    @Override // okio.s
    public void n(@k k0 dir, boolean z10) throws IOException {
        f0.p(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.s
    public void p(@k k0 source, @k k0 target) throws IOException {
        f0.p(source, "source");
        f0.p(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.s
    public void r(@k k0 path, boolean z10) throws IOException {
        f0.p(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.s
    @k
    public List<k0> x(@k k0 dir) throws FileNotFoundException {
        f0.p(dir, "dir");
        String strQ = Q(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z10 = false;
        for (Pair<s, k0> pair : P()) {
            s sVarA = pair.a();
            k0 k0VarB = pair.b();
            try {
                List<k0> listX = sVarA.x(k0VarB.v(strQ));
                ArrayList arrayList = new ArrayList();
                for (Object obj : listX) {
                    if (f44073f.c((k0) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(t.Y(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(f44073f.d((k0) it2.next(), k0VarB));
                }
                x.n0(linkedHashSet, arrayList2);
                z10 = true;
            } catch (IOException unused) {
            }
        }
        if (z10) {
            return CollectionsKt___CollectionsKt.Q5(linkedHashSet);
        }
        throw new FileNotFoundException(f0.C("file not found: ", dir));
    }

    @Override // okio.s
    @l
    public List<k0> y(@k k0 dir) {
        f0.p(dir, "dir");
        String strQ = Q(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Pair<s, k0>> it2 = P().iterator();
        boolean z10 = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it2.hasNext()) {
                break;
            }
            Pair<s, k0> next = it2.next();
            s sVarA = next.a();
            k0 k0VarB = next.b();
            List<k0> listY = sVarA.y(k0VarB.v(strQ));
            if (listY != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listY) {
                    if (f44073f.c((k0) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(t.Y(arrayList2, 10));
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(f44073f.d((k0) it3.next(), k0VarB));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                x.n0(linkedHashSet, arrayList);
                z10 = true;
            }
        }
        if (z10) {
            return CollectionsKt___CollectionsKt.Q5(linkedHashSet);
        }
        return null;
    }
}

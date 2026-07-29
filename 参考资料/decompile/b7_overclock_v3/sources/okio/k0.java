package okio;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0010\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dB\u0011\b\u0000\u0012\u0006\u0010!\u001a\u00020\u0006¢\u0006\u0004\b=\u0010>J\u0018\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0016\u001a\u00020\u0015H\u0007J\u0011\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016R\u001a\u0010!\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0013\u0010$\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060%8F¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0011\u0010-\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0011\u0010/\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b.\u0010,R\u0013\u00103\u001a\u0004\u0018\u0001008G¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00105\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b4\u0010 R\u0011\u00108\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b6\u00107R\u0013\u0010:\u001a\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b9\u0010#R\u0011\u0010<\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b;\u0010,¨\u0006@"}, d2 = {"Lokio/k0;", "", "", "child", "v", "(Ljava/lang/String;)Lokio/k0;", "Lokio/ByteString;", "x", "(Lokio/ByteString;)Lokio/k0;", i1.a.W4, "(Lokio/k0;)Lokio/k0;", "", "normalize", "w", "y", "B", "other", "u", an.aB, "Ljava/io/File;", "G", "Ljava/nio/file/Path;", "H", "", "c", "", "equals", "hashCode", "toString", "a", "Lokio/ByteString;", xf.j.f55230b, "()Lokio/ByteString;", "bytes", "k", "()Lokio/k0;", "root", "", com.flydigi.sdk.bluetooth.l.f16298a, "()Ljava/util/List;", "segments", m0.k.f40564b, "segmentsBytes", "n", "()Z", "isAbsolute", "o", "isRelative", "", "I", "()Ljava/lang/Character;", "volumeLetter", SsManifestParser.e.J, "nameBytes", "q", "()Ljava/lang/String;", "name", "t", androidx.constraintlayout.widget.d.V1, "p", "isRoot", "<init>", "(Lokio/ByteString;)V", "b", "okio"}, k = 1, mv = {1, 5, 1})
public final class k0 implements Comparable<k0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final a f44129b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final String f44130c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final ByteString f44131a;

    @kotlin.d0(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u00020\u0005*\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u0005*\u00020\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lokio/k0$a;", "", "", "", "normalize", "Lokio/k0;", "d", "(Ljava/lang/String;Z)Lokio/k0;", "Ljava/io/File;", "b", "(Ljava/io/File;Z)Lokio/k0;", "Ljava/nio/file/Path;", "f", "(Ljava/nio/file/Path;Z)Lokio/k0;", "DIRECTORY_SEPARATOR", "Ljava/lang/String;", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ k0 g(a aVar, File file, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return aVar.b(file, z10);
        }

        public static /* synthetic */ k0 h(a aVar, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return aVar.d(str, z10);
        }

        public static /* synthetic */ k0 i(a aVar, Path path, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return aVar.f(path, z10);
        }

        @hk.h(name = "get")
        @hk.i
        @hk.m
        @yt.k
        public final k0 a(@yt.k File file) {
            kotlin.jvm.internal.f0.p(file, "<this>");
            return g(this, file, false, 1, null);
        }

        @hk.h(name = "get")
        @hk.i
        @hk.m
        @yt.k
        public final k0 b(@yt.k File file, boolean z10) {
            kotlin.jvm.internal.f0.p(file, "<this>");
            String string = file.toString();
            kotlin.jvm.internal.f0.o(string, "toString()");
            return d(string, z10);
        }

        @hk.h(name = "get")
        @hk.i
        @hk.m
        @yt.k
        public final k0 c(@yt.k String str) {
            kotlin.jvm.internal.f0.p(str, "<this>");
            return h(this, str, false, 1, null);
        }

        @hk.h(name = "get")
        @hk.i
        @hk.m
        @yt.k
        public final k0 d(@yt.k String str, boolean z10) {
            kotlin.jvm.internal.f0.p(str, "<this>");
            return okio.internal.f.B(str, z10);
        }

        @hk.h(name = "get")
        @hk.i
        @IgnoreJRERequirement
        @hk.m
        @yt.k
        public final k0 e(@yt.k Path path) {
            kotlin.jvm.internal.f0.p(path, "<this>");
            return i(this, path, false, 1, null);
        }

        @hk.h(name = "get")
        @hk.i
        @IgnoreJRERequirement
        @hk.m
        @yt.k
        public final k0 f(@yt.k Path path, boolean z10) {
            kotlin.jvm.internal.f0.p(path, "<this>");
            return d(path.toString(), z10);
        }
    }

    static {
        String separator = File.separator;
        kotlin.jvm.internal.f0.o(separator, "separator");
        f44130c = separator;
    }

    public k0(@yt.k ByteString bytes) {
        kotlin.jvm.internal.f0.p(bytes, "bytes");
        this.f44131a = bytes;
    }

    public static /* synthetic */ k0 D(k0 k0Var, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return k0Var.w(str, z10);
    }

    public static /* synthetic */ k0 E(k0 k0Var, ByteString byteString, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return k0Var.y(byteString, z10);
    }

    public static /* synthetic */ k0 F(k0 k0Var, k0 k0Var2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return k0Var.B(k0Var2, z10);
    }

    @hk.h(name = "get")
    @hk.i
    @hk.m
    @yt.k
    public static final k0 d(@yt.k File file) {
        return f44129b.a(file);
    }

    @hk.h(name = "get")
    @hk.i
    @hk.m
    @yt.k
    public static final k0 e(@yt.k File file, boolean z10) {
        return f44129b.b(file, z10);
    }

    @hk.h(name = "get")
    @hk.i
    @hk.m
    @yt.k
    public static final k0 f(@yt.k String str) {
        return f44129b.c(str);
    }

    @hk.h(name = "get")
    @hk.i
    @hk.m
    @yt.k
    public static final k0 g(@yt.k String str, boolean z10) {
        return f44129b.d(str, z10);
    }

    @hk.h(name = "get")
    @hk.i
    @IgnoreJRERequirement
    @hk.m
    @yt.k
    public static final k0 h(@yt.k Path path) {
        return f44129b.e(path);
    }

    @hk.h(name = "get")
    @hk.i
    @IgnoreJRERequirement
    @hk.m
    @yt.k
    public static final k0 i(@yt.k Path path, boolean z10) {
        return f44129b.f(path, z10);
    }

    @hk.h(name = "resolve")
    @yt.k
    public final k0 A(@yt.k k0 child) {
        kotlin.jvm.internal.f0.p(child, "child");
        return okio.internal.f.x(this, child, false);
    }

    @yt.k
    public final k0 B(@yt.k k0 child, boolean z10) {
        kotlin.jvm.internal.f0.p(child, "child");
        return okio.internal.f.x(this, child, z10);
    }

    @yt.k
    public final File G() {
        return new File(toString());
    }

    @yt.k
    @IgnoreJRERequirement
    public final Path H() {
        Path path = Paths.get(toString(), new String[0]);
        kotlin.jvm.internal.f0.o(path, "get(toString())");
        return path;
    }

    @hk.h(name = "volumeLetter")
    @yt.l
    public final Character I() {
        boolean z10 = false;
        if (ByteString.M(j(), okio.internal.f.f44111a, 0, 2, null) != -1 || j().x0() < 2 || j().v(1) != ((byte) 58)) {
            return null;
        }
        char cV = (char) j().v(0);
        if (!('a' <= cV && cV <= 'z')) {
            if ('A' <= cV && cV <= 'Z') {
                z10 = true;
            }
            if (!z10) {
                return null;
            }
        }
        return Character.valueOf(cV);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@yt.k k0 other) {
        kotlin.jvm.internal.f0.p(other, "other");
        return j().compareTo(other.j());
    }

    public boolean equals(@yt.l Object obj) {
        return (obj instanceof k0) && kotlin.jvm.internal.f0.g(((k0) obj).j(), j());
    }

    public int hashCode() {
        return j().hashCode();
    }

    @yt.k
    public final ByteString j() {
        return this.f44131a;
    }

    @yt.l
    public final k0 k() {
        int iM = okio.internal.f.M(this);
        if (iM == -1) {
            return null;
        }
        return new k0(j().F0(0, iM));
    }

    @yt.k
    public final List<String> l() {
        ArrayList arrayList = new ArrayList();
        int iM = okio.internal.f.M(this);
        if (iM == -1) {
            iM = 0;
        } else if (iM < j().x0() && j().v(iM) == ((byte) 92)) {
            iM++;
        }
        int iX0 = j().x0();
        if (iM < iX0) {
            int i10 = iM;
            while (true) {
                int i11 = iM + 1;
                if (j().v(iM) == ((byte) 47) || j().v(iM) == ((byte) 92)) {
                    arrayList.add(j().F0(i10, iM));
                    i10 = i11;
                }
                if (i11 >= iX0) {
                    break;
                }
                iM = i11;
            }
            iM = i10;
        }
        if (iM < j().x0()) {
            arrayList.add(j().F0(iM, j().x0()));
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.t.Y(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((ByteString) it2.next()).O0());
        }
        return arrayList2;
    }

    @yt.k
    public final List<ByteString> m() {
        ArrayList arrayList = new ArrayList();
        int iM = okio.internal.f.M(this);
        if (iM == -1) {
            iM = 0;
        } else if (iM < j().x0() && j().v(iM) == ((byte) 92)) {
            iM++;
        }
        int iX0 = j().x0();
        if (iM < iX0) {
            int i10 = iM;
            while (true) {
                int i11 = iM + 1;
                if (j().v(iM) == ((byte) 47) || j().v(iM) == ((byte) 92)) {
                    arrayList.add(j().F0(i10, iM));
                    i10 = i11;
                }
                if (i11 >= iX0) {
                    break;
                }
                iM = i11;
            }
            iM = i10;
        }
        if (iM < j().x0()) {
            arrayList.add(j().F0(iM, j().x0()));
        }
        return arrayList;
    }

    public final boolean n() {
        return okio.internal.f.M(this) != -1;
    }

    public final boolean o() {
        return okio.internal.f.M(this) == -1;
    }

    public final boolean p() {
        return okio.internal.f.M(this) == j().x0();
    }

    @hk.h(name = "name")
    @yt.k
    public final String q() {
        return r().O0();
    }

    @hk.h(name = "nameBytes")
    @yt.k
    public final ByteString r() {
        int I = okio.internal.f.I(this);
        return I != -1 ? ByteString.G0(j(), I + 1, 0, 2, null) : (I() == null || j().x0() != 2) ? j() : ByteString.f44030d;
    }

    @yt.k
    public final k0 s() {
        return f44129b.d(toString(), true);
    }

    @hk.h(name = androidx.constraintlayout.widget.d.V1)
    @yt.l
    public final k0 t() {
        k0 k0Var;
        if (kotlin.jvm.internal.f0.g(j(), okio.internal.f.f44114d) || kotlin.jvm.internal.f0.g(j(), okio.internal.f.f44111a) || kotlin.jvm.internal.f0.g(j(), okio.internal.f.f44112b) || okio.internal.f.L(this)) {
            return null;
        }
        int I = okio.internal.f.I(this);
        if (I != 2 || I() == null) {
            if (I == 1 && j().y0(okio.internal.f.f44112b)) {
                return null;
            }
            if (I != -1 || I() == null) {
                if (I == -1) {
                    return new k0(okio.internal.f.f44114d);
                }
                if (I != 0) {
                    return new k0(ByteString.G0(j(), 0, I, 1, null));
                }
                k0Var = new k0(ByteString.G0(j(), 0, 1, 1, null));
            } else {
                if (j().x0() == 2) {
                    return null;
                }
                k0Var = new k0(ByteString.G0(j(), 0, 2, 1, null));
            }
        } else {
            if (j().x0() == 3) {
                return null;
            }
            k0Var = new k0(ByteString.G0(j(), 0, 3, 1, null));
        }
        return k0Var;
    }

    @yt.k
    public String toString() {
        return j().O0();
    }

    @yt.k
    public final k0 u(@yt.k k0 other) {
        kotlin.jvm.internal.f0.p(other, "other");
        if (!kotlin.jvm.internal.f0.g(k(), other.k())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        List<ByteString> listM = m();
        List<ByteString> listM2 = other.m();
        int iMin = Math.min(listM.size(), listM2.size());
        int i10 = 0;
        while (i10 < iMin && kotlin.jvm.internal.f0.g(listM.get(i10), listM2.get(i10))) {
            i10++;
        }
        if (i10 == iMin && j().x0() == other.j().x0()) {
            return a.h(f44129b, j3.b.f36044h, false, 1, null);
        }
        if (!(listM2.subList(i10, listM2.size()).indexOf(okio.internal.f.f44115e) == -1)) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        j jVar = new j();
        ByteString byteStringK = okio.internal.f.K(other);
        if (byteStringK == null && (byteStringK = okio.internal.f.K(this)) == null) {
            byteStringK = okio.internal.f.Q(f44130c);
        }
        int size = listM2.size();
        if (i10 < size) {
            int i11 = i10;
            do {
                i11++;
                jVar.B1(okio.internal.f.f44115e);
                jVar.B1(byteStringK);
            } while (i11 < size);
        }
        int size2 = listM.size();
        if (i10 < size2) {
            while (true) {
                int i12 = i10 + 1;
                jVar.B1(listM.get(i10));
                jVar.B1(byteStringK);
                if (i12 >= size2) {
                    break;
                }
                i10 = i12;
            }
        }
        return okio.internal.f.O(jVar, false);
    }

    @hk.h(name = "resolve")
    @yt.k
    public final k0 v(@yt.k String child) {
        kotlin.jvm.internal.f0.p(child, "child");
        return okio.internal.f.x(this, okio.internal.f.O(new j().H0(child), false), false);
    }

    @yt.k
    public final k0 w(@yt.k String child, boolean z10) {
        kotlin.jvm.internal.f0.p(child, "child");
        return okio.internal.f.x(this, okio.internal.f.O(new j().H0(child), false), z10);
    }

    @hk.h(name = "resolve")
    @yt.k
    public final k0 x(@yt.k ByteString child) {
        kotlin.jvm.internal.f0.p(child, "child");
        return okio.internal.f.x(this, okio.internal.f.O(new j().B1(child), false), false);
    }

    @yt.k
    public final k0 y(@yt.k ByteString child, boolean z10) {
        kotlin.jvm.internal.f0.p(child, "child");
        return okio.internal.f.x(this, okio.internal.f.O(new j().B1(child), false), z10);
    }
}

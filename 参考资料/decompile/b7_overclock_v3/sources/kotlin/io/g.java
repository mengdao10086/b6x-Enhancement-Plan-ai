package kotlin.io;

import java.io.File;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final File f37790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final List<File> f37791b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@yt.k File root, @yt.k List<? extends File> segments) {
        f0.p(root, "root");
        f0.p(segments, "segments");
        this.f37790a = root;
        this.f37791b = segments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ g d(g gVar, File file, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            file = gVar.f37790a;
        }
        if ((i10 & 2) != 0) {
            list = gVar.f37791b;
        }
        return gVar.c(file, list);
    }

    @yt.k
    public final File a() {
        return this.f37790a;
    }

    @yt.k
    public final List<File> b() {
        return this.f37791b;
    }

    @yt.k
    public final g c(@yt.k File root, @yt.k List<? extends File> segments) {
        f0.p(root, "root");
        f0.p(segments, "segments");
        return new g(root, segments);
    }

    @yt.k
    public final File e() {
        return this.f37790a;
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return f0.g(this.f37790a, gVar.f37790a) && f0.g(this.f37791b, gVar.f37791b);
    }

    @yt.k
    public final String f() {
        String path = this.f37790a.getPath();
        f0.o(path, "root.path");
        return path;
    }

    @yt.k
    public final List<File> g() {
        return this.f37791b;
    }

    public final int h() {
        return this.f37791b.size();
    }

    public int hashCode() {
        return (this.f37790a.hashCode() * 31) + this.f37791b.hashCode();
    }

    public final boolean i() {
        String path = this.f37790a.getPath();
        f0.o(path, "root.path");
        return path.length() > 0;
    }

    @yt.k
    public final File j(int i10, int i11) {
        if (i10 < 0 || i10 > i11 || i11 > h()) {
            throw new IllegalArgumentException();
        }
        List<File> listSubList = this.f37791b.subList(i10, i11);
        String separator = File.separator;
        f0.o(separator, "separator");
        return new File(CollectionsKt___CollectionsKt.h3(listSubList, separator, null, null, 0, null, null, 62, null));
    }

    @yt.k
    public String toString() {
        return "FilePathComponents(root=" + this.f37790a + ", segments=" + this.f37791b + ')';
    }
}

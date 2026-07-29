package kotlin.io.path;

import java.nio.file.Path;
import java.util.Iterator;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Path f37854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public final Object f37855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public final j f37856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public Iterator<j> f37857d;

    public j(@yt.k Path path, @yt.l Object obj, @yt.l j jVar) {
        f0.p(path, "path");
        this.f37854a = path;
        this.f37855b = obj;
        this.f37856c = jVar;
    }

    @yt.l
    public final Iterator<j> a() {
        return this.f37857d;
    }

    @yt.l
    public final Object b() {
        return this.f37855b;
    }

    @yt.l
    public final j c() {
        return this.f37856c;
    }

    @yt.k
    public final Path d() {
        return this.f37854a;
    }

    public final void e(@yt.l Iterator<j> it2) {
        this.f37857d = it2;
    }
}

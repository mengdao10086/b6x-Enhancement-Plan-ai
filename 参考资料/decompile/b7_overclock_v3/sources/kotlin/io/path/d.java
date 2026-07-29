package kotlin.io.path;

import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f37836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final List<Exception> f37838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public Path f37839d;

    public d() {
        this(0, 1, null);
    }

    public d(int i10) {
        this.f37836a = i10;
        this.f37838c = new ArrayList();
    }

    public final void a(@yt.k Exception exception) {
        f0.p(exception, "exception");
        this.f37837b++;
        if (this.f37838c.size() < this.f37836a) {
            if (this.f37839d != null) {
                Throwable thInitCause = new FileSystemException(String.valueOf(this.f37839d)).initCause(exception);
                f0.n(thInitCause, "null cannot be cast to non-null type java.nio.file.FileSystemException");
                exception = (FileSystemException) thInitCause;
            }
            this.f37838c.add(exception);
        }
    }

    public final void b(@yt.k Path name) {
        f0.p(name, "name");
        Path path = this.f37839d;
        this.f37839d = path != null ? path.resolve(name) : null;
    }

    public final void c(@yt.k Path name) {
        f0.p(name, "name");
        Path path = this.f37839d;
        if (!f0.g(name, path != null ? path.getFileName() : null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Path path2 = this.f37839d;
        this.f37839d = path2 != null ? path2.getParent() : null;
    }

    @yt.k
    public final List<Exception> d() {
        return this.f37838c;
    }

    @yt.l
    public final Path e() {
        return this.f37839d;
    }

    public final int f() {
        return this.f37837b;
    }

    public final void g(@yt.l Path path) {
        this.f37839d = path;
    }

    public /* synthetic */ d(int i10, int i11, u uVar) {
        this((i11 & 1) != 0 ? 64 : i10);
    }
}

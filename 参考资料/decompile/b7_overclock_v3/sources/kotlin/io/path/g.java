package kotlin.io.path;

import ik.p;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
@e
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> f37840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> f37841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public p<? super Path, ? super IOException, ? extends FileVisitResult> f37842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public p<? super Path, ? super IOException, ? extends FileVisitResult> f37843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f37844e;

    @Override // kotlin.io.path.f
    public void a(@yt.k p<? super Path, ? super IOException, ? extends FileVisitResult> function) {
        f0.p(function, "function");
        f();
        g(this.f37842c, "onVisitFileFailed");
        this.f37842c = function;
    }

    @Override // kotlin.io.path.f
    public void b(@yt.k p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function) {
        f0.p(function, "function");
        f();
        g(this.f37841b, "onVisitFile");
        this.f37841b = function;
    }

    @Override // kotlin.io.path.f
    public void c(@yt.k p<? super Path, ? super IOException, ? extends FileVisitResult> function) {
        f0.p(function, "function");
        f();
        g(this.f37843d, "onPostVisitDirectory");
        this.f37843d = function;
    }

    @Override // kotlin.io.path.f
    public void d(@yt.k p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function) {
        f0.p(function, "function");
        f();
        g(this.f37840a, "onPreVisitDirectory");
        this.f37840a = function;
    }

    @yt.k
    public final FileVisitor<Path> e() {
        f();
        this.f37844e = true;
        return new h(this.f37840a, this.f37841b, this.f37842c, this.f37843d);
    }

    public final void f() {
        if (this.f37844e) {
            throw new IllegalStateException("This builder was already built");
        }
    }

    public final void g(Object obj, String str) {
        if (obj == null) {
            return;
        }
        throw new IllegalStateException(str + " was already defined");
    }
}

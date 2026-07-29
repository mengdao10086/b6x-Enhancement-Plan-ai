package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/DirectoryEntriesReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
public final class c extends SimpleFileVisitor<Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f37833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public j f37834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public kotlin.collections.i<j> f37835c = new kotlin.collections.i<>();

    public c(boolean z10) {
        this.f37833a = z10;
    }

    public final boolean a() {
        return this.f37833a;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @yt.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FileVisitResult preVisitDirectory(@yt.k Path dir, @yt.k BasicFileAttributes attrs) throws IOException {
        f0.p(dir, "dir");
        f0.p(attrs, "attrs");
        this.f37835c.add(new j(dir, attrs.fileKey(), this.f37834b));
        FileVisitResult fileVisitResultPreVisitDirectory = super.preVisitDirectory(dir, attrs);
        f0.o(fileVisitResultPreVisitDirectory, "super.preVisitDirectory(dir, attrs)");
        return fileVisitResultPreVisitDirectory;
    }

    @yt.k
    public final List<j> c(@yt.k j directoryNode) throws IOException {
        f0.p(directoryNode, "directoryNode");
        this.f37834b = directoryNode;
        Files.walkFileTree(directoryNode.d(), i.f37849a.b(this.f37833a), 1, this);
        this.f37835c.removeFirst();
        kotlin.collections.i<j> iVar = this.f37835c;
        this.f37835c = new kotlin.collections.i<>();
        return iVar;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @yt.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public FileVisitResult visitFile(@yt.k Path file, @yt.k BasicFileAttributes attrs) throws IOException {
        f0.p(file, "file");
        f0.p(attrs, "attrs");
        this.f37835c.add(new j(file, null, this.f37834b));
        FileVisitResult fileVisitResultVisitFile = super.visitFile(file, attrs);
        f0.o(fileVisitResultVisitFile, "super.visitFile(file, attrs)");
        return fileVisitResultVisitFile;
    }
}

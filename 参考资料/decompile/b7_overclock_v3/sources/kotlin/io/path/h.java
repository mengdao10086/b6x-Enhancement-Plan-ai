package kotlin.io.path;

import ik.p;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class h extends SimpleFileVisitor<Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public final p<Path, BasicFileAttributes, FileVisitResult> f37845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public final p<Path, BasicFileAttributes, FileVisitResult> f37846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public final p<Path, IOException, FileVisitResult> f37847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public final p<Path, IOException, FileVisitResult> f37848d;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@yt.l p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar, @yt.l p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar2, @yt.l p<? super Path, ? super IOException, ? extends FileVisitResult> pVar3, @yt.l p<? super Path, ? super IOException, ? extends FileVisitResult> pVar4) {
        this.f37845a = pVar;
        this.f37846b = pVar2;
        this.f37847c = pVar3;
        this.f37848d = pVar4;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @yt.k
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FileVisitResult postVisitDirectory(@yt.k Path dir, @yt.l IOException iOException) throws IOException {
        FileVisitResult fileVisitResultR0;
        f0.p(dir, "dir");
        p<Path, IOException, FileVisitResult> pVar = this.f37848d;
        if (pVar != null && (fileVisitResultR0 = pVar.r0(dir, iOException)) != null) {
            return fileVisitResultR0;
        }
        FileVisitResult fileVisitResultPostVisitDirectory = super.postVisitDirectory(dir, iOException);
        f0.o(fileVisitResultPostVisitDirectory, "super.postVisitDirectory(dir, exc)");
        return fileVisitResultPostVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @yt.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FileVisitResult preVisitDirectory(@yt.k Path dir, @yt.k BasicFileAttributes attrs) throws IOException {
        FileVisitResult fileVisitResultR0;
        f0.p(dir, "dir");
        f0.p(attrs, "attrs");
        p<Path, BasicFileAttributes, FileVisitResult> pVar = this.f37845a;
        if (pVar != null && (fileVisitResultR0 = pVar.r0(dir, attrs)) != null) {
            return fileVisitResultR0;
        }
        FileVisitResult fileVisitResultPreVisitDirectory = super.preVisitDirectory(dir, attrs);
        f0.o(fileVisitResultPreVisitDirectory, "super.preVisitDirectory(dir, attrs)");
        return fileVisitResultPreVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @yt.k
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public FileVisitResult visitFile(@yt.k Path file, @yt.k BasicFileAttributes attrs) throws IOException {
        FileVisitResult fileVisitResultR0;
        f0.p(file, "file");
        f0.p(attrs, "attrs");
        p<Path, BasicFileAttributes, FileVisitResult> pVar = this.f37846b;
        if (pVar != null && (fileVisitResultR0 = pVar.r0(file, attrs)) != null) {
            return fileVisitResultR0;
        }
        FileVisitResult fileVisitResultVisitFile = super.visitFile(file, attrs);
        f0.o(fileVisitResultVisitFile, "super.visitFile(file, attrs)");
        return fileVisitResultVisitFile;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    @yt.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public FileVisitResult visitFileFailed(@yt.k Path file, @yt.k IOException exc) throws IOException {
        FileVisitResult fileVisitResultR0;
        f0.p(file, "file");
        f0.p(exc, "exc");
        p<Path, IOException, FileVisitResult> pVar = this.f37847c;
        if (pVar != null && (fileVisitResultR0 = pVar.r0(file, exc)) != null) {
            return fileVisitResultR0;
        }
        FileVisitResult fileVisitResultVisitFileFailed = super.visitFileFailed(file, exc);
        f0.o(fileVisitResultVisitFileFailed, "super.visitFileFailed(file, exc)");
        return fileVisitResultVisitFileFailed;
    }
}

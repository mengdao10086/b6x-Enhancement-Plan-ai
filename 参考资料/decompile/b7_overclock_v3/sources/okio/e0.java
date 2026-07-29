package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import okio.k0;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lokio/e0;", "Lokio/d0;", "Lokio/k0;", "path", "Lokio/r;", "D", "source", "target", "Lkotlin/z1;", "g", "p", "", "toString", "Ljava/nio/file/attribute/FileTime;", "", "P", "(Ljava/nio/file/attribute/FileTime;)Ljava/lang/Long;", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
@IgnoreJRERequirement
public final class e0 extends d0 {
    @Override // okio.d0, okio.s
    @yt.l
    public r D(@yt.k k0 path) {
        kotlin.jvm.internal.f0.p(path, "path");
        Path pathH = path.H();
        try {
            BasicFileAttributes attributes = Files.readAttributes(pathH, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            Path symbolicLink = attributes.isSymbolicLink() ? Files.readSymbolicLink(pathH) : null;
            boolean zIsRegularFile = attributes.isRegularFile();
            boolean zIsDirectory = attributes.isDirectory();
            k0 k0VarI = symbolicLink == null ? null : k0.a.i(k0.f44129b, symbolicLink, false, 1, null);
            Long lValueOf = Long.valueOf(attributes.size());
            FileTime fileTimeCreationTime = attributes.creationTime();
            Long lP = fileTimeCreationTime == null ? null : P(fileTimeCreationTime);
            FileTime fileTimeLastModifiedTime = attributes.lastModifiedTime();
            Long lP2 = fileTimeLastModifiedTime == null ? null : P(fileTimeLastModifiedTime);
            FileTime fileTimeLastAccessTime = attributes.lastAccessTime();
            return new r(zIsRegularFile, zIsDirectory, k0VarI, lValueOf, lP, lP2, fileTimeLastAccessTime != null ? P(fileTimeLastAccessTime) : null, null, 128, null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }

    public final Long P(FileTime fileTime) {
        Long lValueOf = Long.valueOf(fileTime.toMillis());
        if (lValueOf.longValue() != 0) {
            return lValueOf;
        }
        return null;
    }

    @Override // okio.d0, okio.s
    public void g(@yt.k k0 source, @yt.k k0 target) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(target, "target");
        try {
            Files.move(source.H(), target.H(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e10) {
            throw new FileNotFoundException(e10.getMessage());
        }
    }

    @Override // okio.d0, okio.s
    public void p(@yt.k k0 source, @yt.k k0 target) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(target, "target");
        Files.createSymbolicLink(source.H(), target.H(), new FileAttribute[0]);
    }

    @Override // okio.d0
    @yt.k
    public String toString() {
        return "NioSystemFileSystem";
    }
}

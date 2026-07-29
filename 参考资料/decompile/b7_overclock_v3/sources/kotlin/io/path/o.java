package kotlin.io.path;

import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.c2;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.c1;
import kotlin.collections.d1;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.s0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.u;
import kotlin.v0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nPathUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1132:1\n26#2:1133\n26#2:1137\n1#3:1134\n1855#4,2:1135\n*S KotlinDebug\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n*L\n221#1:1133\n574#1:1137\n440#1:1135,2\n*E\n"})
public class o extends PathsKt__PathRecursiveFunctionsKt {
    @s0
    @yt.k
    public static final Void A0(@yt.k Path path, @yt.k Class<?> attributeViewClass) {
        f0.p(path, "path");
        f0.p(attributeViewClass, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + attributeViewClass + " is not available for the file " + path + '.');
    }

    @e
    @v0(version = "1.7")
    public static final void A1(@yt.k Path path, @yt.k FileVisitor<Path> visitor, int i10, boolean z10) throws IOException {
        f0.p(path, "<this>");
        f0.p(visitor, "visitor");
        Files.walkFileTree(path, z10 ? c1.f(FileVisitOption.FOLLOW_LINKS) : d1.k(), i10, visitor);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final /* synthetic */ <V extends FileAttributeView> V B0(Path path, LinkOption... options) {
        f0.p(path, "<this>");
        f0.p(options, "options");
        f0.y(4, i1.a.X4);
        V v10 = (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(options, options.length));
        if (v10 != null) {
            return v10;
        }
        f0.y(4, i1.a.X4);
        A0(path, FileAttributeView.class);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void B1(Path path, int i10, boolean z10, ik.l lVar, int i11, Object obj) throws IOException {
        if ((i11 & 1) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        z1(path, i10, z10, lVar);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final /* synthetic */ <V extends FileAttributeView> V C0(Path path, LinkOption... options) {
        f0.p(path, "<this>");
        f0.p(options, "options");
        f0.y(4, i1.a.X4);
        return (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    public static /* synthetic */ void C1(Path path, FileVisitor fileVisitor, int i10, boolean z10, int i11, Object obj) throws IOException {
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        A1(path, fileVisitor, i10, z10);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final long D0(Path path) throws IOException {
        f0.p(path, "<this>");
        return Files.size(path);
    }

    @e
    @v0(version = "1.7")
    @yt.k
    public static final kotlin.sequences.m<Path> D1(@yt.k Path path, @yt.k PathWalkOption... options) {
        f0.p(path, "<this>");
        f0.p(options, "options");
        return new PathTreeWalk(path, options);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final FileStore E0(Path path) throws IOException {
        f0.p(path, "<this>");
        FileStore fileStore = Files.getFileStore(path);
        f0.o(fileStore, "getFileStore(this)");
        return fileStore;
    }

    @e
    @v0(version = "1.7")
    @yt.k
    public static final FileVisitor<Path> F0(@yt.k ik.l<? super f, z1> builderAction) {
        f0.p(builderAction, "builderAction");
        g gVar = new g();
        builderAction.i(gVar);
        return gVar.e();
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final void G0(Path path, String glob, ik.l<? super Path, z1> action) throws IOException {
        f0.p(path, "<this>");
        f0.p(glob, "glob");
        f0.p(action, "action");
        DirectoryStream<Path> it2 = Files.newDirectoryStream(path, glob);
        try {
            f0.o(it2, "it");
            Iterator<Path> it3 = it2.iterator();
            while (it3.hasNext()) {
                action.i(it3.next());
            }
            z1 z1Var = z1.f38230a;
            c0.d(1);
            kotlin.io.b.a(it2, null);
            c0.c(1);
        } finally {
        }
    }

    public static /* synthetic */ void H0(Path path, String glob, ik.l action, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            glob = "*";
        }
        f0.p(path, "<this>");
        f0.p(glob, "glob");
        f0.p(action, "action");
        DirectoryStream<Path> it2 = Files.newDirectoryStream(path, glob);
        try {
            f0.o(it2, "it");
            Iterator<Path> it3 = it2.iterator();
            while (it3.hasNext()) {
                action.i(it3.next());
            }
            z1 z1Var = z1.f38230a;
            c0.d(1);
            kotlin.io.b.a(it2, null);
            c0.c(1);
        } finally {
        }
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Object I0(Path path, String attribute, LinkOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(attribute, "attribute");
        f0.p(options, "options");
        return Files.getAttribute(path, attribute, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @yt.k
    public static final String J0(@yt.k Path path) {
        String string;
        String strR5;
        f0.p(path, "<this>");
        Path fileName = path.getFileName();
        return (fileName == null || (string = fileName.toString()) == null || (strR5 = StringsKt__StringsKt.r5(string, '.', "")) == null) ? "" : strR5;
    }

    @c2(markerClass = {e.class})
    @v0(version = "1.5")
    public static /* synthetic */ void K0(Path path) {
    }

    public static final String L0(Path path) {
        f0.p(path, "<this>");
        return N0(path);
    }

    @bk.f
    @e
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @kotlin.t0(expression = "invariantSeparatorsPathString", imports = {}))
    @v0(version = "1.4")
    public static /* synthetic */ void M0(Path path) {
    }

    @yt.k
    public static final String N0(@yt.k Path path) {
        f0.p(path, "<this>");
        String separator = path.getFileSystem().getSeparator();
        if (f0.g(separator, fh.a.f28350w)) {
            return path.toString();
        }
        String string = path.toString();
        f0.o(separator, "separator");
        return u.l2(string, separator, fh.a.f28350w, false, 4, null);
    }

    @c2(markerClass = {e.class})
    @v0(version = "1.5")
    public static /* synthetic */ void O0(Path path) {
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final FileTime P0(Path path, LinkOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(options, "options");
        FileTime lastModifiedTime = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        f0.o(lastModifiedTime, "getLastModifiedTime(this, *options)");
        return lastModifiedTime;
    }

    @yt.k
    public static final String Q0(@yt.k Path path) {
        f0.p(path, "<this>");
        Path fileName = path.getFileName();
        String string = fileName != null ? fileName.toString() : null;
        return string == null ? "" : string;
    }

    @c2(markerClass = {e.class})
    @v0(version = "1.5")
    public static /* synthetic */ void R0(Path path) {
    }

    @yt.k
    public static final String S0(@yt.k Path path) {
        String string;
        String strC5;
        f0.p(path, "<this>");
        Path fileName = path.getFileName();
        return (fileName == null || (string = fileName.toString()) == null || (strC5 = StringsKt__StringsKt.C5(string, j3.b.f36044h, null, 2, null)) == null) ? "" : strC5;
    }

    @c2(markerClass = {e.class})
    @v0(version = "1.5")
    public static /* synthetic */ void T0(Path path) {
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final UserPrincipal U0(Path path, LinkOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(options, "options");
        return Files.getOwner(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    public static final String V0(Path path) {
        f0.p(path, "<this>");
        return path.toString();
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static /* synthetic */ void W0(Path path) {
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final Set<PosixFilePermission> X0(Path path, LinkOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(options, "options");
        Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(options, options.length));
        f0.o(posixFilePermissions, "getPosixFilePermissions(this, *options)");
        return posixFilePermissions;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final boolean Y0(Path path, LinkOption... options) {
        f0.p(path, "<this>");
        f0.p(options, "options");
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final boolean Z0(Path path) {
        f0.p(path, "<this>");
        return Files.isExecutable(path);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final boolean a1(Path path) throws IOException {
        f0.p(path, "<this>");
        return Files.isHidden(path);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path b0(String path) {
        f0.p(path, "path");
        Path path2 = Paths.get(path, new String[0]);
        f0.o(path2, "get(path)");
        return path2;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final boolean b1(Path path) {
        f0.p(path, "<this>");
        return Files.isReadable(path);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path c0(String base, String... subpaths) {
        f0.p(base, "base");
        f0.p(subpaths, "subpaths");
        Path path = Paths.get(base, (String[]) Arrays.copyOf(subpaths, subpaths.length));
        f0.o(path, "get(base, *subpaths)");
        return path;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final boolean c1(Path path, LinkOption... options) {
        f0.p(path, "<this>");
        f0.p(options, "options");
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path d0(Path path) {
        f0.p(path, "<this>");
        Path absolutePath = path.toAbsolutePath();
        f0.o(absolutePath, "toAbsolutePath()");
        return absolutePath;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final boolean d1(Path path, Path other) throws IOException {
        f0.p(path, "<this>");
        f0.p(other, "other");
        return Files.isSameFile(path, other);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final String e0(Path path) {
        f0.p(path, "<this>");
        return path.toAbsolutePath().toString();
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final boolean e1(Path path) {
        f0.p(path, "<this>");
        return Files.isSymbolicLink(path);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path f0(Path path, Path target, boolean z10) throws IOException {
        f0.p(path, "<this>");
        f0.p(target, "target");
        CopyOption[] copyOptionArr = z10 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathCopy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        f0.o(pathCopy, "copy(this, target, *options)");
        return pathCopy;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final boolean f1(Path path) {
        f0.p(path, "<this>");
        return Files.isWritable(path);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path g0(Path path, Path target, CopyOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(target, "target");
        f0.p(options, "options");
        Path pathCopy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        f0.o(pathCopy, "copy(this, target, *options)");
        return pathCopy;
    }

    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    @yt.k
    public static final List<Path> g1(@yt.k Path path, @yt.k String glob) throws IOException {
        f0.p(path, "<this>");
        f0.p(glob, "glob");
        DirectoryStream<Path> it2 = Files.newDirectoryStream(path, glob);
        try {
            f0.o(it2, "it");
            List<Path> listQ5 = CollectionsKt___CollectionsKt.Q5(it2);
            kotlin.io.b.a(it2, null);
            return listQ5;
        } finally {
        }
    }

    public static /* synthetic */ Path h0(Path path, Path target, boolean z10, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        f0.p(path, "<this>");
        f0.p(target, "target");
        CopyOption[] copyOptionArr = z10 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathCopy = Files.copy(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        f0.o(pathCopy, "copy(this, target, *options)");
        return pathCopy;
    }

    public static /* synthetic */ List h1(Path path, String str, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            str = "*";
        }
        return g1(path, str);
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final Path i0(Path path, FileAttribute<?>... attributes) throws IOException {
        f0.p(path, "<this>");
        f0.p(attributes, "attributes");
        Path pathCreateDirectories = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        f0.o(pathCreateDirectories, "createDirectories(this, *attributes)");
        return pathCreateDirectories;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path i1(Path path, Path target, boolean z10) throws IOException {
        f0.p(path, "<this>");
        f0.p(target, "target");
        CopyOption[] copyOptionArr = z10 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathMove = Files.move(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        f0.o(pathMove, "move(this, target, *options)");
        return pathMove;
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final Path j0(Path path, FileAttribute<?>... attributes) throws IOException {
        f0.p(path, "<this>");
        f0.p(attributes, "attributes");
        Path pathCreateDirectory = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        f0.o(pathCreateDirectory, "createDirectory(this, *attributes)");
        return pathCreateDirectory;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path j1(Path path, Path target, CopyOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(target, "target");
        f0.p(options, "options");
        Path pathMove = Files.move(path, target, (CopyOption[]) Arrays.copyOf(options, options.length));
        f0.o(pathMove, "move(this, target, *options)");
        return pathMove;
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final Path k0(Path path, FileAttribute<?>... attributes) throws IOException {
        f0.p(path, "<this>");
        f0.p(attributes, "attributes");
        Path pathCreateFile = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        f0.o(pathCreateFile, "createFile(this, *attributes)");
        return pathCreateFile;
    }

    public static /* synthetic */ Path k1(Path path, Path target, boolean z10, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        f0.p(path, "<this>");
        f0.p(target, "target");
        CopyOption[] copyOptionArr = z10 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path pathMove = Files.move(path, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        f0.o(pathMove, "move(this, target, *options)");
        return pathMove;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path l0(Path path, Path target) throws IOException {
        f0.p(path, "<this>");
        f0.p(target, "target");
        Path pathCreateLink = Files.createLink(path, target);
        f0.o(pathCreateLink, "createLink(this, target)");
        return pathCreateLink;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final boolean l1(Path path, LinkOption... options) {
        f0.p(path, "<this>");
        f0.p(options, "options");
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final Path m0(Path path, Path target, FileAttribute<?>... attributes) throws IOException {
        f0.p(path, "<this>");
        f0.p(target, "target");
        f0.p(attributes, "attributes");
        Path pathCreateSymbolicLink = Files.createSymbolicLink(path, target, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        f0.o(pathCreateSymbolicLink, "createSymbolicLink(this, target, *attributes)");
        return pathCreateSymbolicLink;
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final /* synthetic */ <A extends BasicFileAttributes> A m1(Path path, LinkOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(options, "options");
        f0.y(4, i1.a.W4);
        A a10 = (A) Files.readAttributes(path, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(options, options.length));
        f0.o(a10, "readAttributes(this, A::class.java, *options)");
        return a10;
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final Path n0(String str, FileAttribute<?>... attributes) throws IOException {
        f0.p(attributes, "attributes");
        Path pathCreateTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        f0.o(pathCreateTempDirectory, "createTempDirectory(prefix, *attributes)");
        return pathCreateTempDirectory;
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final Map<String, Object> n1(Path path, String attributes, LinkOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(attributes, "attributes");
        f0.p(options, "options");
        Map<String, Object> attributes2 = Files.readAttributes(path, attributes, (LinkOption[]) Arrays.copyOf(options, options.length));
        f0.o(attributes2, "readAttributes(this, attributes, *options)");
        return attributes2;
    }

    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    @yt.k
    public static final Path o0(@yt.l Path path, @yt.l String str, @yt.k FileAttribute<?>... attributes) throws IOException {
        f0.p(attributes, "attributes");
        if (path != null) {
            Path pathCreateTempDirectory = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            f0.o(pathCreateTempDirectory, "createTempDirectory(dire…ory, prefix, *attributes)");
            return pathCreateTempDirectory;
        }
        Path pathCreateTempDirectory2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        f0.o(pathCreateTempDirectory2, "createTempDirectory(prefix, *attributes)");
        return pathCreateTempDirectory2;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path o1(Path path) throws IOException {
        f0.p(path, "<this>");
        Path symbolicLink = Files.readSymbolicLink(path);
        f0.o(symbolicLink, "readSymbolicLink(this)");
        return symbolicLink;
    }

    public static /* synthetic */ Path p0(String str, FileAttribute[] attributes, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            str = null;
        }
        f0.p(attributes, "attributes");
        Path pathCreateTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        f0.o(pathCreateTempDirectory, "createTempDirectory(prefix, *attributes)");
        return pathCreateTempDirectory;
    }

    @c2(markerClass = {e.class})
    @v0(version = "1.5")
    @yt.k
    public static final Path p1(@yt.k Path path, @yt.k Path base) {
        f0.p(path, "<this>");
        f0.p(base, "base");
        try {
            return k.f37858a.a(path, base);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(e10.getMessage() + "\nthis path: " + path + "\nbase path: " + base, e10);
        }
    }

    public static /* synthetic */ Path q0(Path path, String str, FileAttribute[] fileAttributeArr, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            str = null;
        }
        return o0(path, str, fileAttributeArr);
    }

    @c2(markerClass = {e.class})
    @v0(version = "1.5")
    @yt.l
    public static final Path q1(@yt.k Path path, @yt.k Path base) {
        f0.p(path, "<this>");
        f0.p(base, "base");
        try {
            return k.f37858a.a(path, base);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final Path r0(String str, String str2, FileAttribute<?>... attributes) throws IOException {
        f0.p(attributes, "attributes");
        Path pathCreateTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        f0.o(pathCreateTempFile, "createTempFile(prefix, suffix, *attributes)");
        return pathCreateTempFile;
    }

    @c2(markerClass = {e.class})
    @v0(version = "1.5")
    @yt.k
    public static final Path r1(@yt.k Path path, @yt.k Path base) {
        f0.p(path, "<this>");
        f0.p(base, "base");
        Path pathQ1 = q1(path, base);
        return pathQ1 == null ? path : pathQ1;
    }

    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    @yt.k
    public static final Path s0(@yt.l Path path, @yt.l String str, @yt.l String str2, @yt.k FileAttribute<?>... attributes) throws IOException {
        f0.p(attributes, "attributes");
        if (path != null) {
            Path pathCreateTempFile = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
            f0.o(pathCreateTempFile, "createTempFile(directory…fix, suffix, *attributes)");
            return pathCreateTempFile;
        }
        Path pathCreateTempFile2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        f0.o(pathCreateTempFile2, "createTempFile(prefix, suffix, *attributes)");
        return pathCreateTempFile2;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path s1(Path path, String attribute, Object obj, LinkOption... options) throws IOException {
        f0.p(path, "<this>");
        f0.p(attribute, "attribute");
        f0.p(options, "options");
        Path attribute2 = Files.setAttribute(path, attribute, obj, (LinkOption[]) Arrays.copyOf(options, options.length));
        f0.o(attribute2, "setAttribute(this, attribute, value, *options)");
        return attribute2;
    }

    public static /* synthetic */ Path t0(String str, String str2, FileAttribute[] attributes, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        f0.p(attributes, "attributes");
        Path pathCreateTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(attributes, attributes.length));
        f0.o(pathCreateTempFile, "createTempFile(prefix, suffix, *attributes)");
        return pathCreateTempFile;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path t1(Path path, FileTime value) throws IOException {
        f0.p(path, "<this>");
        f0.p(value, "value");
        Path lastModifiedTime = Files.setLastModifiedTime(path, value);
        f0.o(lastModifiedTime, "setLastModifiedTime(this, value)");
        return lastModifiedTime;
    }

    public static /* synthetic */ Path u0(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        return s0(path, str, str2, fileAttributeArr);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path u1(Path path, UserPrincipal value) throws IOException {
        f0.p(path, "<this>");
        f0.p(value, "value");
        Path owner = Files.setOwner(path, value);
        f0.o(owner, "setOwner(this, value)");
        return owner;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final void v0(Path path) throws IOException {
        f0.p(path, "<this>");
        Files.delete(path);
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final Path v1(Path path, Set<? extends PosixFilePermission> value) throws IOException {
        f0.p(path, "<this>");
        f0.p(value, "value");
        Path posixFilePermissions = Files.setPosixFilePermissions(path, value);
        f0.o(posixFilePermissions, "setPosixFilePermissions(this, value)");
        return posixFilePermissions;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final boolean w0(Path path) throws IOException {
        f0.p(path, "<this>");
        return Files.deleteIfExists(path);
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path w1(URI uri) {
        f0.p(uri, "<this>");
        Path path = Paths.get(uri);
        f0.o(path, "get(this)");
        return path;
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path x0(Path path, String other) {
        f0.p(path, "<this>");
        f0.p(other, "other");
        Path pathResolve = path.resolve(other);
        f0.o(pathResolve, "this.resolve(other)");
        return pathResolve;
    }

    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {e.class})
    public static final <T> T x1(Path path, String glob, ik.l<? super kotlin.sequences.m<? extends Path>, ? extends T> block) throws IOException {
        f0.p(path, "<this>");
        f0.p(glob, "glob");
        f0.p(block, "block");
        DirectoryStream<Path> it2 = Files.newDirectoryStream(path, glob);
        try {
            f0.o(it2, "it");
            T tI = block.i(CollectionsKt___CollectionsKt.v1(it2));
            c0.d(1);
            kotlin.io.b.a(it2, null);
            c0.c(1);
            return tI;
        } finally {
        }
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final Path y0(Path path, Path other) {
        f0.p(path, "<this>");
        f0.p(other, "other");
        Path pathResolve = path.resolve(other);
        f0.o(pathResolve, "this.resolve(other)");
        return pathResolve;
    }

    public static /* synthetic */ Object y1(Path path, String glob, ik.l block, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            glob = "*";
        }
        f0.p(path, "<this>");
        f0.p(glob, "glob");
        f0.p(block, "block");
        DirectoryStream<Path> it2 = Files.newDirectoryStream(path, glob);
        try {
            f0.o(it2, "it");
            Object objI = block.i(CollectionsKt___CollectionsKt.v1(it2));
            c0.d(1);
            kotlin.io.b.a(it2, null);
            c0.c(1);
            return objI;
        } finally {
        }
    }

    @c2(markerClass = {e.class})
    @bk.f
    @v0(version = "1.5")
    public static final boolean z0(Path path, LinkOption... options) {
        f0.p(path, "<this>");
        f0.p(options, "options");
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(options, options.length));
    }

    @e
    @v0(version = "1.7")
    public static final void z1(@yt.k Path path, int i10, boolean z10, @yt.k ik.l<? super f, z1> builderAction) throws IOException {
        f0.p(path, "<this>");
        f0.p(builderAction, "builderAction");
        A1(path, F0(builderAction), i10, z10);
    }
}

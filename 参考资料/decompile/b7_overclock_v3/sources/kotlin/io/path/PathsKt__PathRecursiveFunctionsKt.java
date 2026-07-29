package kotlin.io.path;

import ik.p;
import ik.q;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u0;
import kotlin.v0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nPathRecursiveFunctions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,420:1\n336#1,2:424\n344#1:426\n344#1:427\n338#1,4:428\n336#1,2:432\n344#1:434\n338#1,4:435\n344#1:439\n336#1,6:440\n336#1,2:446\n344#1:448\n338#1,4:449\n1#2:421\n1855#3,2:422\n*S KotlinDebug\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n*L\n352#1:424,2\n361#1:426\n364#1:427\n352#1:428,4\n372#1:432,2\n373#1:434\n372#1:435,4\n384#1:439\n392#1:440,6\n410#1:446,2\n411#1:448\n410#1:449,4\n274#1:422,2\n*E\n"})
public class PathsKt__PathRecursiveFunctionsKt extends n {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f37829b;

        static {
            int[] iArr = new int[CopyActionResult.values().length];
            try {
                iArr[CopyActionResult.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CopyActionResult.TERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f37828a = iArr;
            int[] iArr2 = new int[OnErrorResult.values().length];
            try {
                iArr2[OnErrorResult.TERMINATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            f37829b = iArr2;
        }
    }

    public static final void J(d dVar, ik.a<z1> aVar) {
        try {
            aVar.o();
        } catch (Exception e10) {
            dVar.a(e10);
        }
    }

    @e
    @v0(version = "1.8")
    @yt.k
    public static final Path K(@yt.k final Path path, @yt.k final Path target, @yt.k final q<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> onError, boolean z10, @yt.k final q<? super kotlin.io.path.a, ? super Path, ? super Path, ? extends CopyActionResult> copyAction) throws IOException {
        f0.p(path, "<this>");
        f0.p(target, "target");
        f0.p(onError, "onError");
        f0.p(copyAction, "copyAction");
        LinkOption[] linkOptionArrA = i.f37849a.a(z10);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptionArrA, linkOptionArrA.length);
        if (!Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            throw new NoSuchFileException(path.toString(), target.toString(), "The source file doesn't exist.");
        }
        boolean zStartsWith = false;
        if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && (z10 || !Files.isSymbolicLink(path))) {
            boolean z11 = Files.exists(target, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && !Files.isSymbolicLink(target);
            if (!z11 || !Files.isSameFile(path, target)) {
                if (f0.g(path.getFileSystem(), target.getFileSystem())) {
                    if (z11) {
                        zStartsWith = target.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0]));
                    } else {
                        Path parent = target.getParent();
                        if (parent != null && Files.exists(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && parent.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0]))) {
                            zStartsWith = true;
                        }
                    }
                }
                if (zStartsWith) {
                    throw new FileSystemException(path.toString(), target.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
                }
            }
        }
        o.B1(path, 0, z10, new ik.l<f, z1>() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5

            /* JADX INFO: renamed from: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$1, reason: invalid class name */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements p<Path, BasicFileAttributes, FileVisitResult> {
                public final /* synthetic */ q<a, Path, Path, CopyActionResult> $copyAction;
                public final /* synthetic */ q<Path, Path, Exception, OnErrorResult> $onError;
                public final /* synthetic */ Path $target;
                public final /* synthetic */ Path $this_copyToRecursively;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass1(q<? super a, ? super Path, ? super Path, ? extends CopyActionResult> qVar, Path path, Path path2, q<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> qVar2) {
                    super(2, f0.a.class, "copy", "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
                    this.$copyAction = qVar;
                    this.$this_copyToRecursively = path;
                    this.$target = path2;
                    this.$onError = qVar2;
                }

                @Override // ik.p
                @yt.k
                /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
                public final FileVisitResult r0(@yt.k Path p02, @yt.k BasicFileAttributes p12) {
                    f0.p(p02, "p0");
                    f0.p(p12, "p1");
                    return PathsKt__PathRecursiveFunctionsKt.M(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError, p02, p12);
                }
            }

            /* JADX INFO: renamed from: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2, reason: invalid class name */
            public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements p<Path, BasicFileAttributes, FileVisitResult> {
                public final /* synthetic */ q<a, Path, Path, CopyActionResult> $copyAction;
                public final /* synthetic */ q<Path, Path, Exception, OnErrorResult> $onError;
                public final /* synthetic */ Path $target;
                public final /* synthetic */ Path $this_copyToRecursively;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass2(q<? super a, ? super Path, ? super Path, ? extends CopyActionResult> qVar, Path path, Path path2, q<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> qVar2) {
                    super(2, f0.a.class, "copy", "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
                    this.$copyAction = qVar;
                    this.$this_copyToRecursively = path;
                    this.$target = path2;
                    this.$onError = qVar2;
                }

                @Override // ik.p
                @yt.k
                /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
                public final FileVisitResult r0(@yt.k Path p02, @yt.k BasicFileAttributes p12) {
                    f0.p(p02, "p0");
                    f0.p(p12, "p1");
                    return PathsKt__PathRecursiveFunctionsKt.M(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError, p02, p12);
                }
            }

            /* JADX INFO: renamed from: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3, reason: invalid class name */
            public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements p<Path, Exception, FileVisitResult> {
                public final /* synthetic */ q<Path, Path, Exception, OnErrorResult> $onError;
                public final /* synthetic */ Path $target;
                public final /* synthetic */ Path $this_copyToRecursively;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass3(q<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> qVar, Path path, Path path2) {
                    super(2, f0.a.class, com.umeng.analytics.pro.d.O, "copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/Exception;)Ljava/nio/file/FileVisitResult;", 0);
                    this.$onError = qVar;
                    this.$this_copyToRecursively = path;
                    this.$target = path2;
                }

                @Override // ik.p
                @yt.k
                /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
                public final FileVisitResult r0(@yt.k Path p02, @yt.k Exception p12) {
                    f0.p(p02, "p0");
                    f0.p(p12, "p1");
                    return PathsKt__PathRecursiveFunctionsKt.Q(this.$onError, this.$this_copyToRecursively, this.$target, p02, p12);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void b(@yt.k f visitFileTree) {
                f0.p(visitFileTree, "$this$visitFileTree");
                visitFileTree.d(new AnonymousClass1(copyAction, path, target, onError));
                visitFileTree.b(new AnonymousClass2(copyAction, path, target, onError));
                visitFileTree.a(new AnonymousClass3(onError, path, target));
                final q<Path, Path, Exception, OnErrorResult> qVar = onError;
                final Path path2 = path;
                final Path path3 = target;
                visitFileTree.c(new p<Path, IOException, FileVisitResult>() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // ik.p
                    @yt.k
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final FileVisitResult r0(@yt.k Path directory, @yt.l IOException iOException) {
                        f0.p(directory, "directory");
                        return iOException == null ? FileVisitResult.CONTINUE : PathsKt__PathRecursiveFunctionsKt.Q(qVar, path2, path3, directory, iOException);
                    }
                });
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(f fVar) {
                b(fVar);
                return z1.f38230a;
            }
        }, 1, null);
        return target;
    }

    @e
    @v0(version = "1.8")
    @yt.k
    public static final Path L(@yt.k Path path, @yt.k Path target, @yt.k q<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> onError, final boolean z10, boolean z11) {
        f0.p(path, "<this>");
        f0.p(target, "target");
        f0.p(onError, "onError");
        return z11 ? K(path, target, onError, z10, new q<kotlin.io.path.a, Path, Path, CopyActionResult>() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // ik.q
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CopyActionResult A(@yt.k a copyToRecursively, @yt.k Path src, @yt.k Path dst) throws IllegalAccessException, FileSystemException, InvocationTargetException {
                f0.p(copyToRecursively, "$this$copyToRecursively");
                f0.p(src, "src");
                f0.p(dst, "dst");
                LinkOption[] linkOptionArrA = i.f37849a.a(z10);
                boolean zIsDirectory = Files.isDirectory(dst, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1));
                LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptionArrA, linkOptionArrA.length);
                if (!Files.isDirectory(src, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) || !zIsDirectory) {
                    if (zIsDirectory) {
                        PathsKt__PathRecursiveFunctionsKt.R(dst);
                    }
                    u0 u0Var = new u0(2);
                    u0Var.b(linkOptionArrA);
                    u0Var.a(StandardCopyOption.REPLACE_EXISTING);
                    CopyOption[] copyOptionArr = (CopyOption[]) u0Var.d(new CopyOption[u0Var.c()]);
                    f0.o(Files.copy(src, dst, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(this, target, *options)");
                }
                return CopyActionResult.CONTINUE;
            }
        }) : N(path, target, onError, z10, null, 8, null);
    }

    public static final FileVisitResult M(q<? super kotlin.io.path.a, ? super Path, ? super Path, ? extends CopyActionResult> qVar, Path path, Path path2, q<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> qVar2, Path path3, BasicFileAttributes basicFileAttributes) {
        try {
            return Y(qVar.A(b.f37832a, path3, P(path, path2, path3)));
        } catch (Exception e10) {
            return Q(qVar2, path, path2, path3, e10);
        }
    }

    public static /* synthetic */ Path N(Path path, Path path2, q qVar, final boolean z10, q qVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            qVar = new q() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$3
                @Override // ik.q
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Void A(@yt.k Path path3, @yt.k Path path4, @yt.k Exception exception) throws Exception {
                    f0.p(path3, "<anonymous parameter 0>");
                    f0.p(path4, "<anonymous parameter 1>");
                    f0.p(exception, "exception");
                    throw exception;
                }
            };
        }
        if ((i10 & 8) != 0) {
            qVar2 = new q<kotlin.io.path.a, Path, Path, CopyActionResult>() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // ik.q
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final CopyActionResult A(@yt.k a aVar, @yt.k Path src, @yt.k Path dst) {
                    f0.p(aVar, "$this$null");
                    f0.p(src, "src");
                    f0.p(dst, "dst");
                    return aVar.a(src, dst, z10);
                }
            };
        }
        return K(path, path2, qVar, z10, qVar2);
    }

    public static /* synthetic */ Path O(Path path, Path path2, q qVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            qVar = new q() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1
                @Override // ik.q
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Void A(@yt.k Path path3, @yt.k Path path4, @yt.k Exception exception) throws Exception {
                    f0.p(path3, "<anonymous parameter 0>");
                    f0.p(path4, "<anonymous parameter 1>");
                    f0.p(exception, "exception");
                    throw exception;
                }
            };
        }
        return L(path, path2, qVar, z10, z11);
    }

    public static final Path P(Path path, Path path2, Path path3) {
        Path pathResolve = path2.resolve(o.p1(path3, path).toString());
        f0.o(pathResolve, "target.resolve(relativePath.pathString)");
        return pathResolve;
    }

    public static final FileVisitResult Q(q<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> qVar, Path path, Path path2, Path path3, Exception exc) {
        return Z(qVar.A(path3, P(path, path2, path3), exc));
    }

    @e
    @v0(version = "1.8")
    public static final void R(@yt.k Path path) throws IllegalAccessException, FileSystemException, InvocationTargetException {
        f0.p(path, "<this>");
        List<Exception> listS = S(path);
        if (!listS.isEmpty()) {
            FileSystemException fileSystemException = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
            Iterator<T> it2 = listS.iterator();
            while (it2.hasNext()) {
                kotlin.o.a(fileSystemException, (Exception) it2.next());
            }
            throw fileSystemException;
        }
    }

    public static final List<Exception> S(Path path) {
        DirectoryStream<Path> directoryStreamNewDirectoryStream;
        boolean z10 = false;
        boolean z11 = true;
        d dVar = new d(0, 1, null);
        Path parent = path.getParent();
        if (parent != null) {
            try {
                directoryStreamNewDirectoryStream = Files.newDirectoryStream(parent);
            } catch (Throwable unused) {
                directoryStreamNewDirectoryStream = null;
            }
            if (directoryStreamNewDirectoryStream != null) {
                try {
                    if (directoryStreamNewDirectoryStream instanceof SecureDirectoryStream) {
                        dVar.g(parent);
                        Path fileName = path.getFileName();
                        f0.o(fileName, "this.fileName");
                        U((SecureDirectoryStream) directoryStreamNewDirectoryStream, fileName, dVar);
                    } else {
                        z10 = true;
                    }
                    z1 z1Var = z1.f38230a;
                    kotlin.io.b.a(directoryStreamNewDirectoryStream, null);
                    z11 = z10;
                } finally {
                }
            }
        }
        if (z11) {
            W(path, dVar);
        }
        return dVar.d();
    }

    public static final void T(SecureDirectoryStream<Path> secureDirectoryStream, Path path, d dVar) {
        SecureDirectoryStream<Path> secureDirectoryStreamNewDirectoryStream;
        try {
            try {
                secureDirectoryStreamNewDirectoryStream = secureDirectoryStream.newDirectoryStream(path, LinkOption.NOFOLLOW_LINKS);
            } catch (Exception e10) {
                dVar.a(e10);
                return;
            }
        } catch (NoSuchFileException unused) {
            secureDirectoryStreamNewDirectoryStream = null;
        }
        if (secureDirectoryStreamNewDirectoryStream == null) {
            return;
        }
        try {
            Iterator<Path> it2 = secureDirectoryStreamNewDirectoryStream.iterator();
            while (it2.hasNext()) {
                Path fileName = it2.next().getFileName();
                f0.o(fileName, "entry.fileName");
                U(secureDirectoryStreamNewDirectoryStream, fileName, dVar);
            }
            z1 z1Var = z1.f38230a;
            kotlin.io.b.a(secureDirectoryStreamNewDirectoryStream, null);
        } finally {
        }
    }

    public static final void U(SecureDirectoryStream<Path> secureDirectoryStream, Path path, d dVar) {
        dVar.b(path);
        try {
        } catch (Exception e10) {
            dVar.a(e10);
        }
        if (X(secureDirectoryStream, path, LinkOption.NOFOLLOW_LINKS)) {
            int iF = dVar.f();
            T(secureDirectoryStream, path, dVar);
            if (iF == dVar.f()) {
                secureDirectoryStream.deleteDirectory(path);
                z1 z1Var = z1.f38230a;
            }
            dVar.c(path);
        }
        secureDirectoryStream.deleteFile(path);
        z1 z1Var2 = z1.f38230a;
        dVar.c(path);
    }

    public static final void V(Path path, d dVar) {
        DirectoryStream<Path> directoryStreamNewDirectoryStream;
        try {
            try {
                directoryStreamNewDirectoryStream = Files.newDirectoryStream(path);
            } catch (Exception e10) {
                dVar.a(e10);
                return;
            }
        } catch (NoSuchFileException unused) {
            directoryStreamNewDirectoryStream = null;
        }
        if (directoryStreamNewDirectoryStream == null) {
            return;
        }
        try {
            for (Path entry : directoryStreamNewDirectoryStream) {
                f0.o(entry, "entry");
                W(entry, dVar);
            }
            z1 z1Var = z1.f38230a;
            kotlin.io.b.a(directoryStreamNewDirectoryStream, null);
        } finally {
        }
    }

    public static final void W(Path path, d dVar) {
        try {
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                int iF = dVar.f();
                V(path, dVar);
                if (iF == dVar.f()) {
                    Files.deleteIfExists(path);
                }
            } else {
                Files.deleteIfExists(path);
            }
        } catch (Exception e10) {
            dVar.a(e10);
        }
    }

    public static final boolean X(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) {
        Boolean boolValueOf;
        try {
            boolValueOf = Boolean.valueOf(((BasicFileAttributeView) secureDirectoryStream.getFileAttributeView(path, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))).readAttributes().isDirectory());
        } catch (NoSuchFileException unused) {
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    @e
    public static final FileVisitResult Y(CopyActionResult copyActionResult) {
        int i10 = a.f37828a[copyActionResult.ordinal()];
        if (i10 == 1) {
            return FileVisitResult.CONTINUE;
        }
        if (i10 == 2) {
            return FileVisitResult.TERMINATE;
        }
        if (i10 == 3) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @e
    public static final FileVisitResult Z(OnErrorResult onErrorResult) {
        int i10 = a.f37829b[onErrorResult.ordinal()];
        if (i10 == 1) {
            return FileVisitResult.TERMINATE;
        }
        if (i10 == 2) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <R> R a0(ik.a<? extends R> aVar) {
        try {
            return aVar.o();
        } catch (NoSuchFileException unused) {
            return null;
        }
    }
}

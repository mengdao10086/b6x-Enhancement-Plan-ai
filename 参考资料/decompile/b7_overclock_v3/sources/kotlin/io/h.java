package kotlin.io;

import ik.p;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public final class h implements kotlin.sequences.m<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final File f37792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final FileWalkDirection f37793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public final ik.l<File, Boolean> f37794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public final ik.l<File, z1> f37795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public final p<File, IOException, z1> f37796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f37797f;

    @t0({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$DirectoryState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
    public static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k File rootDir) {
            super(rootDir);
            f0.p(rootDir, "rootDir");
        }
    }

    public final class b extends kotlin.collections.a<File> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final ArrayDeque<c> f37798c;

        public final class a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f37800b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @yt.l
            public File[] f37801c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f37802d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f37803e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ b f37804f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@yt.k b bVar, File rootDir) {
                super(rootDir);
                f0.p(rootDir, "rootDir");
                this.f37804f = bVar;
            }

            @Override // kotlin.io.h.c
            @yt.l
            public File b() {
                if (!this.f37803e && this.f37801c == null) {
                    ik.l lVar = h.this.f37794c;
                    boolean z10 = false;
                    if (lVar != null && !((Boolean) lVar.i(a())).booleanValue()) {
                        z10 = true;
                    }
                    if (z10) {
                        return null;
                    }
                    File[] fileArrListFiles = a().listFiles();
                    this.f37801c = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        p pVar = h.this.f37796e;
                        if (pVar != null) {
                            pVar.r0(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.f37803e = true;
                    }
                }
                File[] fileArr = this.f37801c;
                if (fileArr != null) {
                    int i10 = this.f37802d;
                    f0.m(fileArr);
                    if (i10 < fileArr.length) {
                        File[] fileArr2 = this.f37801c;
                        f0.m(fileArr2);
                        int i11 = this.f37802d;
                        this.f37802d = i11 + 1;
                        return fileArr2[i11];
                    }
                }
                if (!this.f37800b) {
                    this.f37800b = true;
                    return a();
                }
                ik.l lVar2 = h.this.f37795d;
                if (lVar2 != null) {
                    lVar2.i(a());
                }
                return null;
            }
        }

        /* JADX INFO: renamed from: kotlin.io.h$b$b, reason: collision with other inner class name */
        @t0({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
        public final class C0433b extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f37805b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f37806c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0433b(@yt.k b bVar, File rootFile) {
                super(rootFile);
                f0.p(rootFile, "rootFile");
                this.f37806c = bVar;
            }

            @Override // kotlin.io.h.c
            @yt.l
            public File b() {
                if (this.f37805b) {
                    return null;
                }
                this.f37805b = true;
                return a();
            }
        }

        public final class c extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f37807b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @yt.l
            public File[] f37808c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f37809d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ b f37810e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@yt.k b bVar, File rootDir) {
                super(rootDir);
                f0.p(rootDir, "rootDir");
                this.f37810e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
            
                if (r0.length == 0) goto L33;
             */
            @Override // kotlin.io.h.c
            @yt.l
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f37807b
                    r1 = 0
                    if (r0 != 0) goto L2c
                    kotlin.io.h$b r0 = r10.f37810e
                    kotlin.io.h r0 = kotlin.io.h.this
                    ik.l r0 = kotlin.io.h.e(r0)
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L22
                    java.io.File r4 = r10.a()
                    java.lang.Object r0 = r0.i(r4)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L22
                    r2 = 1
                L22:
                    if (r2 == 0) goto L25
                    return r1
                L25:
                    r10.f37807b = r3
                    java.io.File r0 = r10.a()
                    return r0
                L2c:
                    java.io.File[] r0 = r10.f37808c
                    if (r0 == 0) goto L4b
                    int r2 = r10.f37809d
                    kotlin.jvm.internal.f0.m(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L39
                    goto L4b
                L39:
                    kotlin.io.h$b r0 = r10.f37810e
                    kotlin.io.h r0 = kotlin.io.h.this
                    ik.l r0 = kotlin.io.h.g(r0)
                    if (r0 == 0) goto L4a
                    java.io.File r2 = r10.a()
                    r0.i(r2)
                L4a:
                    return r1
                L4b:
                    java.io.File[] r0 = r10.f37808c
                    if (r0 != 0) goto L97
                    java.io.File r0 = r10.a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f37808c = r0
                    if (r0 != 0) goto L7b
                    kotlin.io.h$b r0 = r10.f37810e
                    kotlin.io.h r0 = kotlin.io.h.this
                    ik.p r0 = kotlin.io.h.f(r0)
                    if (r0 == 0) goto L7b
                    java.io.File r2 = r10.a()
                    kotlin.io.AccessDeniedException r9 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r10.a()
                    r5 = 0
                    r7 = 2
                    r8 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.r0(r2, r9)
                L7b:
                    java.io.File[] r0 = r10.f37808c
                    if (r0 == 0) goto L85
                    kotlin.jvm.internal.f0.m(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L97
                L85:
                    kotlin.io.h$b r0 = r10.f37810e
                    kotlin.io.h r0 = kotlin.io.h.this
                    ik.l r0 = kotlin.io.h.g(r0)
                    if (r0 == 0) goto L96
                    java.io.File r2 = r10.a()
                    r0.i(r2)
                L96:
                    return r1
                L97:
                    java.io.File[] r0 = r10.f37808c
                    kotlin.jvm.internal.f0.m(r0)
                    int r1 = r10.f37809d
                    int r2 = r1 + 1
                    r10.f37809d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.h.b.c.b():java.io.File");
            }
        }

        public /* synthetic */ class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f37811a;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                try {
                    iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f37811a = iArr;
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.f37798c = arrayDeque;
            if (h.this.f37792a.isDirectory()) {
                arrayDeque.push(g(h.this.f37792a));
            } else if (h.this.f37792a.isFile()) {
                arrayDeque.push(new C0433b(this, h.this.f37792a));
            } else {
                b();
            }
        }

        @Override // kotlin.collections.a
        public void a() {
            File fileH = h();
            if (fileH != null) {
                d(fileH);
            } else {
                b();
            }
        }

        public final a g(File file) {
            int i10 = d.f37811a[h.this.f37793b.ordinal()];
            if (i10 == 1) {
                return new c(this, file);
            }
            if (i10 == 2) {
                return new a(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }

        public final File h() {
            File fileB;
            while (true) {
                c cVarPeek = this.f37798c.peek();
                if (cVarPeek == null) {
                    return null;
                }
                fileB = cVarPeek.b();
                if (fileB == null) {
                    this.f37798c.pop();
                } else {
                    if (f0.g(fileB, cVarPeek.a()) || !fileB.isDirectory() || this.f37798c.size() >= h.this.f37797f) {
                        break;
                    }
                    this.f37798c.push(g(fileB));
                }
            }
            return fileB;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final File f37812a;

        public c(@yt.k File root) {
            f0.p(root, "root");
            this.f37812a = root;
        }

        @yt.k
        public final File a() {
            return this.f37812a;
        }

        @yt.l
        public abstract File b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(File file, FileWalkDirection fileWalkDirection, ik.l<? super File, Boolean> lVar, ik.l<? super File, z1> lVar2, p<? super File, ? super IOException, z1> pVar, int i10) {
        this.f37792a = file;
        this.f37793b = fileWalkDirection;
        this.f37794c = lVar;
        this.f37795d = lVar2;
        this.f37796e = pVar;
        this.f37797f = i10;
    }

    @yt.k
    public final h i(int i10) {
        if (i10 > 0) {
            return new h(this.f37792a, this.f37793b, this.f37794c, this.f37795d, this.f37796e, i10);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i10 + '.');
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<File> iterator() {
        return new b();
    }

    @yt.k
    public final h j(@yt.k ik.l<? super File, Boolean> function) {
        f0.p(function, "function");
        return new h(this.f37792a, this.f37793b, function, this.f37795d, this.f37796e, this.f37797f);
    }

    @yt.k
    public final h k(@yt.k p<? super File, ? super IOException, z1> function) {
        f0.p(function, "function");
        return new h(this.f37792a, this.f37793b, this.f37794c, this.f37795d, function, this.f37797f);
    }

    @yt.k
    public final h l(@yt.k ik.l<? super File, z1> function) {
        f0.p(function, "function");
        return new h(this.f37792a, this.f37793b, this.f37794c, function, this.f37796e, this.f37797f);
    }

    public /* synthetic */ h(File file, FileWalkDirection fileWalkDirection, ik.l lVar, ik.l lVar2, p pVar, int i10, int i11, u uVar) {
        this(file, (i11 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, lVar, lVar2, pVar, (i11 & 32) != 0 ? Integer.MAX_VALUE : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(@yt.k File start, @yt.k FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        f0.p(start, "start");
        f0.p(direction, "direction");
    }

    public /* synthetic */ h(File file, FileWalkDirection fileWalkDirection, int i10, u uVar) {
        this(file, (i10 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection);
    }
}

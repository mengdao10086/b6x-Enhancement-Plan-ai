package kotlin.io;

import ik.p;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.u;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,473:1\n1#2:474\n1266#3,3:475\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n*L\n347#1:475,3\n*E\n"})
public class FilesKt__UtilsKt extends k {
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean N(@yt.k java.io.File r11, @yt.k java.io.File r12, boolean r13, @yt.k final ik.p<? super java.io.File, ? super java.io.IOException, ? extends kotlin.io.OnErrorAction> r14) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__UtilsKt.N(java.io.File, java.io.File, boolean, ik.p):boolean");
    }

    public static /* synthetic */ boolean O(File file, File file2, boolean z10, p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            pVar = new p() { // from class: kotlin.io.FilesKt__UtilsKt$copyRecursively$1
                @Override // ik.p
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Void r0(@yt.k File file3, @yt.k IOException exception) throws IOException {
                    f0.p(file3, "<anonymous parameter 0>");
                    f0.p(exception, "exception");
                    throw exception;
                }
            };
        }
        return N(file, file2, z10, pVar);
    }

    @yt.k
    public static final File P(@yt.k File file, @yt.k File target, boolean z10, int i10) throws FileSystemException {
        f0.p(file, "<this>");
        f0.p(target, "target");
        if (!file.exists()) {
            throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z10) {
                throw new FileAlreadyExistsException(file, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new FileAlreadyExistsException(file, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (!file.isDirectory()) {
            File parentFile = target.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(target);
                try {
                    a.k(fileInputStream, fileOutputStream, i10);
                    b.a(fileOutputStream, null);
                    b.a(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } else if (!target.mkdirs()) {
            throw new FileSystemException(file, target, "Failed to create target directory.");
        }
        return target;
    }

    public static /* synthetic */ File Q(File file, File file2, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 8192;
        }
        return P(file, file2, z10, i10);
    }

    @kotlin.k(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    @yt.k
    public static final File R(@yt.k String prefix, @yt.l String str, @yt.l File file) throws IOException {
        f0.p(prefix, "prefix");
        File dir = File.createTempFile(prefix, str, file);
        dir.delete();
        if (dir.mkdir()) {
            f0.o(dir, "dir");
            return dir;
        }
        throw new IOException("Unable to create temporary directory " + dir + '.');
    }

    public static /* synthetic */ File S(String str, String str2, File file, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "tmp";
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            file = null;
        }
        return R(str, str2, file);
    }

    @kotlin.k(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    @yt.k
    public static final File T(@yt.k String prefix, @yt.l String str, @yt.l File file) throws IOException {
        f0.p(prefix, "prefix");
        File fileCreateTempFile = File.createTempFile(prefix, str, file);
        f0.o(fileCreateTempFile, "createTempFile(prefix, suffix, directory)");
        return fileCreateTempFile;
    }

    public static /* synthetic */ File U(String str, String str2, File file, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "tmp";
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            file = null;
        }
        return T(str, str2, file);
    }

    public static final boolean V(@yt.k File file) {
        f0.p(file, "<this>");
        while (true) {
            boolean z10 = true;
            for (File file2 : k.L(file)) {
                if (!file2.delete() && file2.exists()) {
                    z10 = false;
                } else {
                    if (z10) {
                        break;
                    }
                    z10 = false;
                }
            }
            return z10;
        }
    }

    public static final boolean W(@yt.k File file, @yt.k File other) {
        f0.p(file, "<this>");
        f0.p(other, "other");
        g gVarF = j.f(file);
        g gVarF2 = j.f(other);
        if (gVarF2.i()) {
            return f0.g(file, other);
        }
        int iH = gVarF.h() - gVarF2.h();
        if (iH < 0) {
            return false;
        }
        return gVarF.g().subList(iH, gVarF.h()).equals(gVarF2.g());
    }

    public static final boolean X(@yt.k File file, @yt.k String other) {
        f0.p(file, "<this>");
        f0.p(other, "other");
        return W(file, new File(other));
    }

    @yt.k
    public static final String Y(@yt.k File file) {
        f0.p(file, "<this>");
        String name = file.getName();
        f0.o(name, "name");
        return StringsKt__StringsKt.r5(name, '.', "");
    }

    @yt.k
    public static final String Z(@yt.k File file) {
        f0.p(file, "<this>");
        if (File.separatorChar != '/') {
            String path = file.getPath();
            f0.o(path, "path");
            return u.k2(path, File.separatorChar, zc.f.f58380j, false, 4, null);
        }
        String path2 = file.getPath();
        f0.o(path2, "path");
        return path2;
    }

    @yt.k
    public static final String a0(@yt.k File file) {
        f0.p(file, "<this>");
        String name = file.getName();
        f0.o(name, "name");
        return StringsKt__StringsKt.C5(name, j3.b.f36044h, null, 2, null);
    }

    @yt.k
    public static final File b0(@yt.k File file) {
        f0.p(file, "<this>");
        g gVarF = j.f(file);
        File fileE = gVarF.e();
        List<File> listC0 = c0(gVarF.g());
        String separator = File.separator;
        f0.o(separator, "separator");
        return i0(fileE, CollectionsKt___CollectionsKt.h3(listC0, separator, null, null, 0, null, null, 62, null));
    }

    public static final List<File> c0(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (!f0.g(name, j3.b.f36044h)) {
                if (!f0.g(name, "..")) {
                    arrayList.add(file);
                } else if (arrayList.isEmpty() || f0.g(((File) CollectionsKt___CollectionsKt.k3(arrayList)).getName(), "..")) {
                    arrayList.add(file);
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return arrayList;
    }

    public static final g d0(g gVar) {
        return new g(gVar.e(), c0(gVar.g()));
    }

    @yt.k
    public static final File e0(@yt.k File file, @yt.k File base) {
        f0.p(file, "<this>");
        f0.p(base, "base");
        return new File(n0(file, base));
    }

    @yt.l
    public static final File f0(@yt.k File file, @yt.k File base) throws IOException {
        f0.p(file, "<this>");
        f0.p(base, "base");
        String strO0 = o0(file, base);
        if (strO0 != null) {
            return new File(strO0);
        }
        return null;
    }

    @yt.k
    public static final File g0(@yt.k File file, @yt.k File base) throws IOException {
        f0.p(file, "<this>");
        f0.p(base, "base");
        String strO0 = o0(file, base);
        return strO0 != null ? new File(strO0) : file;
    }

    @yt.k
    public static final File h0(@yt.k File file, @yt.k File relative) {
        f0.p(file, "<this>");
        f0.p(relative, "relative");
        if (j.d(relative)) {
            return relative;
        }
        String string = file.toString();
        f0.o(string, "this.toString()");
        if ((string.length() == 0) || StringsKt__StringsKt.b3(string, File.separatorChar, false, 2, null)) {
            return new File(string + relative);
        }
        return new File(string + File.separatorChar + relative);
    }

    @yt.k
    public static final File i0(@yt.k File file, @yt.k String relative) {
        f0.p(file, "<this>");
        f0.p(relative, "relative");
        return h0(file, new File(relative));
    }

    @yt.k
    public static final File j0(@yt.k File file, @yt.k File relative) {
        f0.p(file, "<this>");
        f0.p(relative, "relative");
        g gVarF = j.f(file);
        return h0(h0(gVarF.e(), gVarF.h() == 0 ? new File("..") : gVarF.j(0, gVarF.h() - 1)), relative);
    }

    @yt.k
    public static final File k0(@yt.k File file, @yt.k String relative) {
        f0.p(file, "<this>");
        f0.p(relative, "relative");
        return j0(file, new File(relative));
    }

    public static final boolean l0(@yt.k File file, @yt.k File other) {
        f0.p(file, "<this>");
        f0.p(other, "other");
        g gVarF = j.f(file);
        g gVarF2 = j.f(other);
        if (f0.g(gVarF.e(), gVarF2.e()) && gVarF.h() >= gVarF2.h()) {
            return gVarF.g().subList(0, gVarF2.h()).equals(gVarF2.g());
        }
        return false;
    }

    public static final boolean m0(@yt.k File file, @yt.k String other) {
        f0.p(file, "<this>");
        f0.p(other, "other");
        return l0(file, new File(other));
    }

    @yt.k
    public static final String n0(@yt.k File file, @yt.k File base) throws IOException {
        f0.p(file, "<this>");
        f0.p(base, "base");
        String strO0 = o0(file, base);
        if (strO0 != null) {
            return strO0;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + base + '.');
    }

    public static final String o0(File file, File file2) throws IOException {
        g gVarD0 = d0(j.f(file));
        g gVarD02 = d0(j.f(file2));
        if (!f0.g(gVarD0.e(), gVarD02.e())) {
            return null;
        }
        int iH = gVarD02.h();
        int iH2 = gVarD0.h();
        int i10 = 0;
        int iMin = Math.min(iH2, iH);
        while (i10 < iMin && f0.g(gVarD0.g().get(i10), gVarD02.g().get(i10))) {
            i10++;
        }
        StringBuilder sb2 = new StringBuilder();
        int i11 = iH - 1;
        if (i10 <= i11) {
            while (!f0.g(gVarD02.g().get(i11).getName(), "..")) {
                sb2.append("..");
                if (i11 != i10) {
                    sb2.append(File.separatorChar);
                }
                if (i11 != i10) {
                    i11--;
                }
            }
            return null;
        }
        if (i10 < iH2) {
            if (i10 < iH) {
                sb2.append(File.separatorChar);
            }
            List listX1 = CollectionsKt___CollectionsKt.X1(gVarD0.g(), i10);
            String separator = File.separator;
            f0.o(separator, "separator");
            CollectionsKt___CollectionsKt.e3(listX1, sb2, (124 & 2) != 0 ? ", " : separator, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
        return sb2.toString();
    }
}

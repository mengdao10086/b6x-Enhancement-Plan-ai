package yl;

import hk.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okio.g0;
import okio.r0;
import okio.t0;
import w.w;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0002H&¨\u0006\u0014"}, d2 = {"Lyl/a;", "", "Ljava/io/File;", m7.a.f40702b, "Lokio/t0;", "a", "Lokio/r0;", "b", "g", "Lkotlin/z1;", "f", "", "d", "", "h", w.h.f53783c, "to", "e", "directory", "c", "okhttp"}, k = 1, mv = {1, 6, 0})
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final C0674a f57362a = C0674a.f57364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @e
    @k
    public static final a f57363b = new C0674a.C0675a();

    /* JADX INFO: renamed from: yl.a$a, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\b"}, d2 = {"Lyl/a$a;", "", "Lyl/a;", "SYSTEM", "Lyl/a;", "<init>", "()V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class C0674a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0674a f57364a = new C0674a();

        /* JADX INFO: renamed from: yl.a$a$a, reason: collision with other inner class name */
        @d0(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016¨\u0006\u0018"}, d2 = {"Lyl/a$a$a;", "Lyl/a;", "Ljava/io/File;", m7.a.f40702b, "Lokio/t0;", "a", "Lokio/r0;", "b", "g", "Lkotlin/z1;", "f", "", "d", "", "h", w.h.f53783c, "to", "e", "directory", "c", "", "toString", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class C0675a implements a {
            @Override // yl.a
            @k
            public t0 a(@k File file) throws FileNotFoundException {
                f0.p(file, "file");
                return okio.f0.t(file);
            }

            @Override // yl.a
            @k
            public r0 b(@k File file) throws FileNotFoundException {
                f0.p(file, "file");
                try {
                    return g0.q(file, false, 1, null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return g0.q(file, false, 1, null);
                }
            }

            @Override // yl.a
            public void c(@k File directory) throws IOException {
                f0.p(directory, "directory");
                File[] fileArrListFiles = directory.listFiles();
                if (fileArrListFiles == null) {
                    throw new IOException(f0.C("not a readable directory: ", directory));
                }
                int i10 = 0;
                int length = fileArrListFiles.length;
                while (i10 < length) {
                    File file = fileArrListFiles[i10];
                    i10++;
                    if (file.isDirectory()) {
                        f0.o(file, "file");
                        c(file);
                    }
                    if (!file.delete()) {
                        throw new IOException(f0.C("failed to delete ", file));
                    }
                }
            }

            @Override // yl.a
            public boolean d(@k File file) {
                f0.p(file, "file");
                return file.exists();
            }

            @Override // yl.a
            public void e(@k File from, @k File to2) throws IOException {
                f0.p(from, "from");
                f0.p(to2, "to");
                f(to2);
                if (from.renameTo(to2)) {
                    return;
                }
                throw new IOException("failed to rename " + from + " to " + to2);
            }

            @Override // yl.a
            public void f(@k File file) throws IOException {
                f0.p(file, "file");
                if (!file.delete() && file.exists()) {
                    throw new IOException(f0.C("failed to delete ", file));
                }
            }

            @Override // yl.a
            @k
            public r0 g(@k File file) throws FileNotFoundException {
                f0.p(file, "file");
                try {
                    return okio.f0.a(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return okio.f0.a(file);
                }
            }

            @Override // yl.a
            public long h(@k File file) {
                f0.p(file, "file");
                return file.length();
            }

            @k
            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }
    }

    @k
    t0 a(@k File file) throws FileNotFoundException;

    @k
    r0 b(@k File file) throws FileNotFoundException;

    void c(@k File file) throws IOException;

    boolean d(@k File file);

    void e(@k File file, @k File file2) throws IOException;

    void f(@k File file) throws IOException;

    @k
    r0 g(@k File file) throws FileNotFoundException;

    long h(@k File file);
}

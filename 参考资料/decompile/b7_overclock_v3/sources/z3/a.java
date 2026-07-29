package z3;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.blankj.utilcode.util.i0;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import zc.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Closeable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f57677o = "journal";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f57678p = "journal.tmp";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f57679q = "journal.bkp";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f57680r = "libcore.io.DiskLruCache";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f57681s = "1";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f57682t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f57683u = "CLEAN";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f57684v = "DIRTY";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f57685w = "REMOVE";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f57686x = "READ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f57687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f57688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f57689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f57690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f57691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f57692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f57693g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Writer f57695i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f57697k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f57694h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap<String, d> f57696j = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f57698l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ThreadPoolExecutor f57699m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Callable<Void> f57700n = new CallableC0683a();

    /* JADX INFO: renamed from: z3.a$a, reason: collision with other inner class name */
    public class CallableC0683a implements Callable<Void> {
        public CallableC0683a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f57695i == null) {
                    return null;
                }
                a.this.C1();
                if (a.this.M0()) {
                    a.this.m1();
                    a.this.f57697k = 0;
                }
                return null;
            }
        }
    }

    public static final class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ b(CallableC0683a callableC0683a) {
            this();
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f57702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f57703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f57704c;

        public /* synthetic */ c(a aVar, d dVar, CallableC0683a callableC0683a) {
            this(dVar);
        }

        public void a() throws IOException {
            a.this.I(this, false);
        }

        public void b() {
            if (this.f57704c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() throws IOException {
            a.this.I(this, true);
            this.f57704c = true;
        }

        public File f(int i10) throws IOException {
            File fileK;
            synchronized (a.this) {
                if (this.f57702a.f57711f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f57702a.f57710e) {
                    this.f57703b[i10] = true;
                }
                fileK = this.f57702a.k(i10);
                a.this.f57687a.mkdirs();
            }
            return fileK;
        }

        public String g(int i10) throws IOException {
            InputStream inputStreamH = h(i10);
            if (inputStreamH != null) {
                return a.G0(inputStreamH);
            }
            return null;
        }

        public final InputStream h(int i10) throws IOException {
            synchronized (a.this) {
                if (this.f57702a.f57711f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f57702a.f57710e) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f57702a.j(i10));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public void i(int i10, String str) throws Throwable {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(f(i10)), z3.c.f57728b);
                try {
                    outputStreamWriter2.write(str);
                    z3.c.a(outputStreamWriter2);
                } catch (Throwable th2) {
                    th = th2;
                    outputStreamWriter = outputStreamWriter2;
                    z3.c.a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public c(d dVar) {
            this.f57702a = dVar;
            this.f57703b = dVar.f57710e ? null : new boolean[a.this.f57693g];
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f57706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f57707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public File[] f57708c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public File[] f57709d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f57710e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f57711f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f57712g;

        public /* synthetic */ d(a aVar, String str, CallableC0683a callableC0683a) {
            this(str);
        }

        public File j(int i10) {
            return this.f57708c[i10];
        }

        public File k(int i10) {
            return this.f57709d[i10];
        }

        public String l() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f57707b) {
                sb2.append(f.f58383m);
                sb2.append(j10);
            }
            return sb2.toString();
        }

        public final IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) throws IOException {
            if (strArr.length != a.this.f57693g) {
                throw m(strArr);
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.f57707b[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public d(String str) {
            this.f57706a = str;
            this.f57707b = new long[a.this.f57693g];
            this.f57708c = new File[a.this.f57693g];
            this.f57709d = new File[a.this.f57693g];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i10 = 0; i10 < a.this.f57693g; i10++) {
                sb2.append(i10);
                this.f57708c[i10] = new File(a.this.f57687a, sb2.toString());
                sb2.append(".tmp");
                this.f57709d[i10] = new File(a.this.f57687a, sb2.toString());
                sb2.setLength(length);
            }
        }
    }

    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f57714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f57715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f57716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final File[] f57717d;

        public /* synthetic */ e(a aVar, String str, long j10, File[] fileArr, long[] jArr, CallableC0683a callableC0683a) {
            this(str, j10, fileArr, jArr);
        }

        public c a() throws IOException {
            return a.this.T(this.f57714a, this.f57715b);
        }

        public File b(int i10) {
            return this.f57717d[i10];
        }

        public long c(int i10) {
            return this.f57716c[i10];
        }

        public String d(int i10) throws IOException {
            return a.G0(new FileInputStream(this.f57717d[i10]));
        }

        public e(String str, long j10, File[] fileArr, long[] jArr) {
            this.f57714a = str;
            this.f57715b = j10;
            this.f57717d = fileArr;
            this.f57716c = jArr;
        }
    }

    public a(File file, int i10, int i11, long j10) {
        this.f57687a = file;
        this.f57691e = i10;
        this.f57688b = new File(file, f57677o);
        this.f57689c = new File(file, f57678p);
        this.f57690d = new File(file, f57679q);
        this.f57693g = i11;
        this.f57692f = j10;
    }

    public static String G0(InputStream inputStream) throws IOException {
        return z3.c.c(new InputStreamReader(inputStream, z3.c.f57728b));
    }

    public static void M(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void W(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static a d1(File file, int i10, int i11, long j10) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, f57679q);
        if (file2.exists()) {
            File file3 = new File(file, f57677o);
            if (file3.exists()) {
                file2.delete();
            } else {
                s1(file2, file3, false);
            }
        }
        a aVar = new a(file, i10, i11, j10);
        if (aVar.f57688b.exists()) {
            try {
                aVar.i1();
                aVar.h1();
                return aVar;
            } catch (IOException e10) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                aVar.L();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i10, i11, j10);
        aVar2.m1();
        return aVar2;
    }

    public static void s1(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            M(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void z(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final void C1() throws IOException {
        while (this.f57694h > this.f57692f) {
            p1(this.f57696j.entrySet().iterator().next().getKey());
        }
    }

    public synchronized long F0() {
        return this.f57692f;
    }

    public final synchronized void I(c cVar, boolean z10) throws IOException {
        d dVar = cVar.f57702a;
        if (dVar.f57711f != cVar) {
            throw new IllegalStateException();
        }
        if (z10 && !dVar.f57710e) {
            for (int i10 = 0; i10 < this.f57693g; i10++) {
                if (!cVar.f57703b[i10]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!dVar.k(i10).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.f57693g; i11++) {
            File fileK = dVar.k(i11);
            if (!z10) {
                M(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i11);
                fileK.renameTo(fileJ);
                long j10 = dVar.f57707b[i11];
                long length = fileJ.length();
                dVar.f57707b[i11] = length;
                this.f57694h = (this.f57694h - j10) + length;
            }
        }
        this.f57697k++;
        dVar.f57711f = null;
        if (dVar.f57710e || z10) {
            dVar.f57710e = true;
            this.f57695i.append((CharSequence) f57683u);
            this.f57695i.append(f.f58383m);
            this.f57695i.append((CharSequence) dVar.f57706a);
            this.f57695i.append((CharSequence) dVar.l());
            this.f57695i.append('\n');
            if (z10) {
                long j11 = this.f57698l;
                this.f57698l = 1 + j11;
                dVar.f57712g = j11;
            }
        } else {
            this.f57696j.remove(dVar.f57706a);
            this.f57695i.append((CharSequence) f57685w);
            this.f57695i.append(f.f58383m);
            this.f57695i.append((CharSequence) dVar.f57706a);
            this.f57695i.append('\n');
        }
        W(this.f57695i);
        if (this.f57694h > this.f57692f || M0()) {
            this.f57699m.submit(this.f57700n);
        }
    }

    public void L() throws IOException {
        close();
        z3.c.b(this.f57687a);
    }

    public final boolean M0() {
        int i10 = this.f57697k;
        return i10 >= 2000 && i10 >= this.f57696j.size();
    }

    public c P(String str) throws IOException {
        return T(str, -1L);
    }

    public final synchronized c T(String str, long j10) throws IOException {
        u();
        d dVar = this.f57696j.get(str);
        CallableC0683a callableC0683a = null;
        if (j10 != -1 && (dVar == null || dVar.f57712g != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, callableC0683a);
            this.f57696j.put(str, dVar);
        } else if (dVar.f57711f != null) {
            return null;
        }
        c cVar = new c(this, dVar, callableC0683a);
        dVar.f57711f = cVar;
        this.f57695i.append((CharSequence) f57684v);
        this.f57695i.append(f.f58383m);
        this.f57695i.append((CharSequence) str);
        this.f57695i.append('\n');
        W(this.f57695i);
        return cVar;
    }

    public synchronized e Z(String str) throws IOException {
        u();
        d dVar = this.f57696j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f57710e) {
            return null;
        }
        for (File file : dVar.f57708c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f57697k++;
        this.f57695i.append((CharSequence) f57686x);
        this.f57695i.append(f.f58383m);
        this.f57695i.append((CharSequence) str);
        this.f57695i.append('\n');
        if (M0()) {
            this.f57699m.submit(this.f57700n);
        }
        return new e(this, str, dVar.f57712g, dVar.f57708c, dVar.f57707b, null);
    }

    public File b0() {
        return this.f57687a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f57695i == null) {
            return;
        }
        for (d dVar : new ArrayList(this.f57696j.values())) {
            if (dVar.f57711f != null) {
                dVar.f57711f.a();
            }
        }
        C1();
        z(this.f57695i);
        this.f57695i = null;
    }

    public synchronized void flush() throws IOException {
        u();
        C1();
        W(this.f57695i);
    }

    public final void h1() throws IOException {
        M(this.f57689c);
        Iterator<d> it2 = this.f57696j.values().iterator();
        while (it2.hasNext()) {
            d next = it2.next();
            int i10 = 0;
            if (next.f57711f == null) {
                while (i10 < this.f57693g) {
                    this.f57694h += next.f57707b[i10];
                    i10++;
                }
            } else {
                next.f57711f = null;
                while (i10 < this.f57693g) {
                    M(next.j(i10));
                    M(next.k(i10));
                    i10++;
                }
                it2.remove();
            }
        }
    }

    public final void i1() throws IOException {
        z3.b bVar = new z3.b(new FileInputStream(this.f57688b), z3.c.f57727a);
        try {
            String strF = bVar.f();
            String strF2 = bVar.f();
            String strF3 = bVar.f();
            String strF4 = bVar.f();
            String strF5 = bVar.f();
            if (!f57680r.equals(strF) || !"1".equals(strF2) || !Integer.toString(this.f57691e).equals(strF3) || !Integer.toString(this.f57693g).equals(strF4) || !"".equals(strF5)) {
                throw new IOException("unexpected journal header: [" + strF + ", " + strF2 + ", " + strF4 + ", " + strF5 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    k1(bVar.f());
                    i10++;
                } catch (EOFException unused) {
                    this.f57697k = i10 - this.f57696j.size();
                    if (bVar.d()) {
                        m1();
                    } else {
                        this.f57695i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f57688b, true), z3.c.f57727a));
                    }
                    z3.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th2) {
            z3.c.a(bVar);
            throw th2;
        }
    }

    public synchronized boolean isClosed() {
        return this.f57695i == null;
    }

    public final void k1(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i10 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i10);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i10);
            if (iIndexOf == 6 && str.startsWith(f57685w)) {
                this.f57696j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iIndexOf2);
        }
        d dVar = this.f57696j.get(strSubstring);
        CallableC0683a callableC0683a = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, callableC0683a);
            this.f57696j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(f57683u)) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(i0.f11861z);
            dVar.f57710e = true;
            dVar.f57711f = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(f57684v)) {
            dVar.f57711f = new c(this, dVar, callableC0683a);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith(f57686x)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final synchronized void m1() throws IOException {
        Writer writer = this.f57695i;
        if (writer != null) {
            z(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f57689c), z3.c.f57727a));
        try {
            bufferedWriter.write(f57680r);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f57691e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f57693g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.f57696j.values()) {
                if (dVar.f57711f != null) {
                    bufferedWriter.write("DIRTY " + dVar.f57706a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.f57706a + dVar.l() + '\n');
                }
            }
            z(bufferedWriter);
            if (this.f57688b.exists()) {
                s1(this.f57688b, this.f57690d, true);
            }
            s1(this.f57689c, this.f57688b, false);
            this.f57690d.delete();
            this.f57695i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f57688b, true), z3.c.f57727a));
        } catch (Throwable th2) {
            z(bufferedWriter);
            throw th2;
        }
    }

    public synchronized boolean p1(String str) throws IOException {
        u();
        d dVar = this.f57696j.get(str);
        if (dVar != null && dVar.f57711f == null) {
            for (int i10 = 0; i10 < this.f57693g; i10++) {
                File fileJ = dVar.j(i10);
                if (fileJ.exists() && !fileJ.delete()) {
                    throw new IOException("failed to delete " + fileJ);
                }
                this.f57694h -= dVar.f57707b[i10];
                dVar.f57707b[i10] = 0;
            }
            this.f57697k++;
            this.f57695i.append((CharSequence) f57685w);
            this.f57695i.append(f.f58383m);
            this.f57695i.append((CharSequence) str);
            this.f57695i.append('\n');
            this.f57696j.remove(str);
            if (M0()) {
                this.f57699m.submit(this.f57700n);
            }
            return true;
        }
        return false;
    }

    public final void u() {
        if (this.f57695i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void u1(long j10) {
        this.f57692f = j10;
        this.f57699m.submit(this.f57700n);
    }

    public synchronized long z1() {
        return this.f57694h;
    }
}

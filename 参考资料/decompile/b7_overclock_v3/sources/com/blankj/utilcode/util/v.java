package com.blankj.utilcode.util;

import com.blankj.utilcode.util.l1;
import java.io.File;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12011a = System.getProperty("file.separator");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Thread.UncaughtExceptionHandler f12012b = Thread.getDefaultUncaughtExceptionHandler();

    public static class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f12013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f12014b;

        public a(c cVar, String str) {
            this.f12013a = cVar;
            this.f12014b = str;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@g.n0 Thread thread, @g.n0 Throwable th2) {
            Objects.requireNonNull(thread, "Argument 't' of type Thread (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(th2, "Argument 'e' of type Throwable (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            String str = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss").format(new Date());
            b bVar = new b(str, th2, null);
            c cVar = this.f12013a;
            if (cVar != null) {
                cVar.a(bVar);
            }
            l1.i1(this.f12014b + str + ".txt", bVar.toString(), true);
            if (v.f12012b != null) {
                v.f12012b.uncaughtException(thread, th2);
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l1.a f12015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Throwable f12016b;

        public /* synthetic */ b(String str, Throwable th2, a aVar) {
            this(str, th2);
        }

        public final void a(String str, String str2) {
            this.f12015a.b(str, str2);
        }

        public final void b(Map<String, String> map) {
            this.f12015a.c(map);
        }

        public final Throwable c() {
            return this.f12016b;
        }

        public String toString() {
            return this.f12015a.toString() + l1.T(this.f12016b);
        }

        public b(String str, Throwable th2) {
            this.f12016b = th2;
            l1.a aVar = new l1.a("Crash");
            this.f12015a = aVar;
            aVar.a("Time Of Crash", str);
        }
    }

    public interface c {
        void a(b bVar);
    }

    public v() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Thread.UncaughtExceptionHandler b(String str, c cVar) {
        return new a(cVar, str);
    }

    public static void c() {
        g("");
    }

    public static void d(c cVar) {
        h("", cVar);
    }

    public static void e(@g.n0 File file) {
        Objects.requireNonNull(file, "Argument 'crashDir' of type File (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        h(file.getAbsolutePath(), null);
    }

    public static void f(@g.n0 File file, c cVar) {
        Objects.requireNonNull(file, "Argument 'crashDir' of type File (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        h(file.getAbsolutePath(), cVar);
    }

    public static void g(String str) {
        h(str, null);
    }

    public static void h(String str, c cVar) {
        if (!l1.C0(str)) {
            String str2 = f12011a;
            if (!str.endsWith(str2)) {
                str = str + str2;
            }
        } else if (!l1.z0() || j1.a().getExternalFilesDir(null) == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j1.a().getFilesDir());
            String str3 = f12011a;
            sb2.append(str3);
            sb2.append("crash");
            sb2.append(str3);
            str = sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(j1.a().getExternalFilesDir(null));
            String str4 = f12011a;
            sb3.append(str4);
            sb3.append("crash");
            sb3.append(str4);
            str = sb3.toString();
        }
        Thread.setDefaultUncaughtExceptionHandler(b(str, cVar));
    }
}

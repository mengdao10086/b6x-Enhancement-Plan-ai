package e4;

import android.util.Log;
import e4.a;
import java.io.File;
import java.io.IOException;
import z3.a;

/* JADX INFO: loaded from: classes2.dex */
public class e implements a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f26615f = "DiskLruCacheWrapper";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f26616g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f26617h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static e f26618i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f26620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f26621c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z3.a f26623e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f26622d = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f26619a = new m();

    @Deprecated
    public e(File file, long j10) {
        this.f26620b = file;
        this.f26621c = j10;
    }

    public static a d(File file, long j10) {
        return new e(file, j10);
    }

    @Deprecated
    public static synchronized a e(File file, long j10) {
        if (f26618i == null) {
            f26618i = new e(file, j10);
        }
        return f26618i;
    }

    @Override // e4.a
    public File a(c4.b bVar) {
        String strB = this.f26619a.b(bVar);
        if (Log.isLoggable(f26615f, 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Get: Obtained: ");
            sb2.append(strB);
            sb2.append(" for for Key: ");
            sb2.append(bVar);
        }
        try {
            a.e eVarZ = f().Z(strB);
            if (eVarZ != null) {
                return eVarZ.b(0);
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // e4.a
    public void b(c4.b bVar, a.b bVar2) {
        z3.a aVarF;
        String strB = this.f26619a.b(bVar);
        this.f26622d.a(strB);
        try {
            if (Log.isLoggable(f26615f, 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Put: Obtained: ");
                sb2.append(strB);
                sb2.append(" for for Key: ");
                sb2.append(bVar);
            }
            try {
                aVarF = f();
            } catch (IOException unused) {
                Log.isLoggable(f26615f, 5);
            }
            if (aVarF.Z(strB) != null) {
                return;
            }
            a.c cVarP = aVarF.P(strB);
            if (cVarP == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + strB);
            }
            try {
                if (bVar2.a(cVarP.f(0))) {
                    cVarP.e();
                }
                cVarP.b();
            } catch (Throwable th2) {
                cVarP.b();
                throw th2;
            }
        } finally {
            this.f26622d.b(strB);
        }
    }

    @Override // e4.a
    public void c(c4.b bVar) {
        try {
            f().p1(this.f26619a.b(bVar));
        } catch (IOException unused) {
        }
    }

    @Override // e4.a
    public synchronized void clear() {
        try {
            try {
                f().L();
            } catch (IOException unused) {
                Log.isLoggable(f26615f, 5);
            }
        } finally {
            g();
        }
    }

    public final synchronized z3.a f() throws IOException {
        if (this.f26623e == null) {
            this.f26623e = z3.a.d1(this.f26620b, 1, 1, this.f26621c);
        }
        return this.f26623e;
    }

    public final synchronized void g() {
        this.f26623e = null;
    }
}

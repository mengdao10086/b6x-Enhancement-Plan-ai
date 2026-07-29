package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import g.j1;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6500a = "/data/misc/profiles/ref/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6501b = "/data/misc/profiles/cur/0/";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6502c = "primary.prof";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6503d = "profileInstalled";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f6506g = "ProfileVerifier";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final androidx.concurrent.futures.a<c> f6504e = androidx.concurrent.futures.a.u();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f6505f = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public static c f6507h = null;

    @v0(33)
    public static class a {
        @u
        public static PackageInfo a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f6508e = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f6511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f6512d;

        public b(int i10, int i11, long j10, long j11) {
            this.f6509a = i10;
            this.f6510b = i11;
            this.f6511c = j10;
            this.f6512d = j11;
        }

        public static b a(@n0 File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th2) {
                try {
                    dataInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }

        public void b(@n0 File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f6509a);
                dataOutputStream.writeInt(this.f6510b);
                dataOutputStream.writeLong(this.f6511c);
                dataOutputStream.writeLong(this.f6512d);
                dataOutputStream.close();
            } catch (Throwable th2) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f6510b == bVar.f6510b && this.f6511c == bVar.f6511c && this.f6509a == bVar.f6509a && this.f6512d == bVar.f6512d;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f6510b), Long.valueOf(this.f6511c), Integer.valueOf(this.f6509a), Long.valueOf(this.f6512d));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6513d = 16;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f6514e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f6515f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f6516g = 2;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f6517h = 3;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f6518i = 65536;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f6519j = 131072;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f6520k = 196608;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f6521l = 262144;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f6523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f6524c;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface a {
        }

        public c(int i10, boolean z10, boolean z11) {
            this.f6522a = i10;
            this.f6524c = z11;
            this.f6523b = z10;
        }

        public int a() {
            return this.f6522a;
        }

        public boolean b() {
            return this.f6524c;
        }

        public boolean c() {
            return this.f6523b;
        }
    }

    @n0
    public static ListenableFuture<c> a() {
        return f6504e;
    }

    public static long b(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static c c(int i10, boolean z10, boolean z11) {
        c cVar = new c(i10, z10, z11);
        f6507h = cVar;
        f6504e.p(cVar);
        return f6507h;
    }

    @j1
    @n0
    public static c d(@n0 Context context) {
        return e(context, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @g.j1
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    @g.n0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.profileinstaller.o.c e(@g.n0 android.content.Context r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.o.e(android.content.Context, boolean):androidx.profileinstaller.o$c");
    }
}

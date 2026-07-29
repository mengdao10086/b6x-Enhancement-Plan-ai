package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import androidx.annotation.RestrictTo;
import g.j1;
import g.n0;
import g.p0;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static final int A = 14;
    public static final int B = 15;
    public static final int C = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6461a = "ProfileInstaller";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6462b = "/data/misc/profiles/cur/0";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6463c = "primary.prof";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6464d = "dexopt/baseline.prof";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f6465e = "dexopt/baseline.profm";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f6466f = "profileinstaller_profileWrittenFor_lastUpdateTime.dat";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f6467g = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public static final d f6468h = new b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f6469i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f6470j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f6471k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f6472l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f6473m = 5;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f6474n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f6475o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f6476p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f6477q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f6478r = 5;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f6479s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f6480t = 7;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f6481u = 8;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f6482v = 9;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f6483w = 10;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f6484x = 11;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f6485y = 12;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f6486z = 13;

    public class a implements d {
        @Override // androidx.profileinstaller.i.d
        public void a(int i10, @p0 Object obj) {
        }

        @Override // androidx.profileinstaller.i.d
        public void b(int i10, @p0 Object obj) {
        }
    }

    public class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f6487a = "ProfileInstaller";

        @Override // androidx.profileinstaller.i.d
        public void a(int i10, @p0 Object obj) {
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0000. Please report as an issue. */
        @Override // androidx.profileinstaller.i.d
        public void b(int i10, @p0 Object obj) {
            switch (i10) {
            }
            if (i10 == 6 || i10 == 7 || i10 == 8) {
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface c {
    }

    public interface d {
        void a(int i10, @p0 Object obj);

        void b(int i10, @p0 Object obj);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface e {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean c(@n0 File file) {
        return new File(file, f6466f).delete();
    }

    @j1
    public static void d(@n0 Context context, @n0 Executor executor, @n0 d dVar) {
        c(context.getFilesDir());
        j(executor, dVar, 11, null);
    }

    public static void e(@n0 Executor executor, @n0 final d dVar, final int i10, @p0 final Object obj) {
        executor.execute(new Runnable() { // from class: androidx.profileinstaller.g
            @Override // java.lang.Runnable
            public final void run() {
                dVar.a(i10, obj);
            }
        });
    }

    @j1
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean f(PackageInfo packageInfo, File file, d dVar) {
        File file2 = new File(file, f6466f);
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long j10 = dataInputStream.readLong();
                dataInputStream.close();
                boolean z10 = j10 == packageInfo.lastUpdateTime;
                if (z10) {
                    dVar.b(2, null);
                }
                return z10;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void i(@n0 PackageInfo packageInfo, @n0 File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, f6466f)));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    public static void j(@n0 Executor executor, @n0 final d dVar, final int i10, @p0 final Object obj) {
        executor.execute(new Runnable() { // from class: androidx.profileinstaller.h
            @Override // java.lang.Runnable
            public final void run() {
                dVar.b(i10, obj);
            }
        });
    }

    public static boolean k(@n0 AssetManager assetManager, @n0 String str, @n0 PackageInfo packageInfo, @n0 File file, @n0 String str2, @n0 Executor executor, @n0 d dVar) {
        androidx.profileinstaller.c cVar = new androidx.profileinstaller.c(assetManager, executor, dVar, str2, f6464d, f6465e, new File(new File(f6462b, str), "primary.prof"));
        if (!cVar.e()) {
            return false;
        }
        boolean zN = cVar.i().m().n();
        if (zN) {
            i(packageInfo, file);
        }
        return zN;
    }

    @j1
    public static void l(@n0 Context context) {
        m(context, f.f6454a, f6467g);
    }

    @j1
    public static void m(@n0 Context context, @n0 Executor executor, @n0 d dVar) {
        n(context, executor, dVar, false);
    }

    @j1
    public static void n(@n0 Context context, @n0 Executor executor, @n0 d dVar, boolean z10) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z11 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z10 && f(packageInfo, filesDir, dVar)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Skipping profile installation for ");
                sb2.append(context.getPackageName());
                o.e(context, false);
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Installing profile for ");
            sb3.append(context.getPackageName());
            if (k(assets, packageName, packageInfo, filesDir, name, executor, dVar) && z10) {
                z11 = true;
            }
            o.e(context, z11);
        } catch (PackageManager.NameNotFoundException e10) {
            dVar.b(7, e10);
            o.e(context, false);
        }
    }

    @j1
    public static void o(@n0 Context context, @n0 Executor executor, @n0 d dVar) {
        try {
            i(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            j(executor, dVar, 10, null);
        } catch (PackageManager.NameNotFoundException e10) {
            j(executor, dVar, 7, e10);
        }
    }
}

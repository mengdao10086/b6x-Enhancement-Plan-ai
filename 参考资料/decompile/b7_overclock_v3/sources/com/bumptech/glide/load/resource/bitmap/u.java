package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import g.i1;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12635g = "HardwareConfig";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f12636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f12637i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @i1
    public static final int f12638j = 128;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f12639k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final File f12640l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f12641m = 50;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f12642n = 700;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f12643o = 20000;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f12644p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile u f12645q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile int f12646r;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.b0("this")
    public int f12650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.b0("this")
    public boolean f12651e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f12652f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12647a = h();

    static {
        int i10 = Build.VERSION.SDK_INT;
        f12636h = i10 < 29;
        f12637i = i10 >= 26;
        f12640l = new File("/proc/self/fd");
        f12646r = -1;
    }

    @i1
    public u() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f12648b = 20000;
            this.f12649c = 0;
        } else {
            this.f12648b = 700;
            this.f12649c = 128;
        }
    }

    public static u d() {
        if (f12645q == null) {
            synchronized (u.class) {
                if (f12645q == null) {
                    f12645q = new u();
                }
            }
        }
        return f12645q;
    }

    public static boolean h() {
        return (i() || j()) ? false : true;
    }

    public static boolean i() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        Iterator it2 = Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play").iterator();
        while (it2.hasNext()) {
            if (Build.MODEL.startsWith((String) it2.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean j() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
    }

    public boolean a() {
        v4.o.b();
        return !this.f12652f.get();
    }

    public final boolean b() {
        return f12636h && !this.f12652f.get();
    }

    public void c() {
        v4.o.b();
        this.f12652f.set(false);
    }

    public final int e() {
        return f12646r != -1 ? f12646r : this.f12648b;
    }

    public final synchronized boolean f() {
        boolean z10 = true;
        int i10 = this.f12650d + 1;
        this.f12650d = i10;
        if (i10 >= 50) {
            this.f12650d = 0;
            int length = f12640l.list().length;
            long jE = e();
            if (length >= jE) {
                z10 = false;
            }
            this.f12651e = z10;
            if (!z10 && Log.isLoggable(o.f12606f, 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                sb2.append(length);
                sb2.append(", limit ");
                sb2.append(jE);
            }
        }
        return this.f12651e;
    }

    public boolean g(int i10, int i11, boolean z10, boolean z11) {
        int i12;
        return z10 && this.f12647a && f12637i && !b() && !z11 && i10 >= (i12 = this.f12649c) && i11 >= i12 && f();
    }

    @TargetApi(26)
    public boolean k(int i10, int i11, BitmapFactory.Options options, boolean z10, boolean z11) {
        boolean zG = g(i10, i11, z10, z11);
        if (zG) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zG;
    }

    public void l() {
        v4.o.b();
        this.f12652f.set(true);
    }
}

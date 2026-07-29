package com.blankj.utilcode.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import com.blankj.utilcode.util.j1;
import f0.v;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11919a = -1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11920b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11921c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11922d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11923e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11924f = 4;

    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f11925b = new a(j1.a().getPackageName(), j1.a().getPackageName(), 3);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NotificationChannel f11926a;

        public a(String str, CharSequence charSequence, int i10) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f11926a = new NotificationChannel(str, charSequence, i10);
            }
        }

        public NotificationChannel b() {
            return this.f11926a;
        }

        public a c(boolean z10) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f11926a.setBypassDnd(z10);
            }
            return this;
        }

        public a d(String str) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f11926a.setDescription(str);
            }
            return this;
        }

        public a e(String str) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f11926a.setGroup(str);
            }
            return this;
        }

        public a f(int i10) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f11926a.setImportance(i10);
            }
            return this;
        }

        public a g(int i10) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f11926a.setLightColor(i10);
            }
            return this;
        }

        public a h(int i10) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f11926a.setLockscreenVisibility(i10);
            }
            return this;
        }

        public a i(CharSequence charSequence) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f11926a.setName(charSequence);
            }
            return this;
        }

        public a j(boolean z10) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f11926a.setShowBadge(z10);
            }
            return this;
        }

        public a k(Uri uri, AudioAttributes audioAttributes) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f11926a.setSound(uri, audioAttributes);
            }
            return this;
        }

        public a l(long[] jArr) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f11926a.setVibrationPattern(jArr);
            }
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public static boolean a() {
        return f0.a0.p(j1.a()).a();
    }

    public static void b(int i10) {
        f0.a0.p(j1.a()).b(i10);
    }

    public static void c(String str, int i10) {
        f0.a0.p(j1.a()).c(str, i10);
    }

    public static void d() {
        f0.a0.p(j1.a()).d();
    }

    public static Notification e(a aVar, j1.b<v.n> bVar) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            ((NotificationManager) j1.a().getSystemService("notification")).createNotificationChannel(aVar.b());
        }
        v.n nVar = new v.n(j1.a());
        if (i10 >= 26) {
            nVar.H(aVar.f11926a.getId());
        }
        if (bVar != null) {
            bVar.accept(nVar);
        }
        return nVar.h();
    }

    public static void f(String str) {
        try {
            Class.forName("android.app.StatusBarManager").getMethod(str, new Class[0]).invoke(j1.a().getSystemService("statusbar"), new Object[0]);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void g(int i10, a aVar, j1.b<v.n> bVar) {
        i(null, i10, aVar, bVar);
    }

    public static void h(int i10, j1.b<v.n> bVar) {
        i(null, i10, a.f11925b, bVar);
    }

    public static void i(String str, int i10, a aVar, j1.b<v.n> bVar) {
        f0.a0.p(j1.a()).D(str, i10, e(aVar, bVar));
    }

    public static void j(String str, int i10, j1.b<v.n> bVar) {
        i(str, i10, a.f11925b, bVar);
    }

    @g.y0("android.permission.EXPAND_STATUS_BAR")
    public static void k(boolean z10) {
        f(z10 ? "expandNotificationsPanel" : "collapsePanels");
    }
}

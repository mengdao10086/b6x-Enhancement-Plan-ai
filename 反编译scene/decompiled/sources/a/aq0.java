package a;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.SystemClock;
import android.util.LruCache;
import android.widget.RemoteViews;
import com.omarea.Scene;
import com.omarea.scene_mode.ReceiverSceneMode;
import com.omarea.vtools.AccessibilitySceneMode;
import com.omarea.vtools.activities.ActivityMain;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class aq0 implements ha0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f5632a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @SuppressLint({"StaticFieldLeak"})
    public static final nb f102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Notification f105a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final NotificationManager f106a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final boolean f108b = false;
    public static boolean c = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final aq0 f101a = new aq0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final xu0 f103a = new xu0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final z32 f104a = a42.a(zp0.f8087a);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final LruCache<String, CharSequence> f107a = new LruCache<>(50);
    public static final LruCache<Integer, Bitmap> b = new LruCache<>(20);

    static {
        nb nbVar;
        Object systemService = Scene.f4798a.c().getSystemService("notification");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
        f106a = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            if (f106a.getNotificationChannel("scene-scheduler") == null) {
                f106a.createNotificationChannel(new NotificationChannel("scene-scheduler", Scene.f4798a.c().getString(u61.accessibility_service_name), 2));
            }
            nbVar = new nb(Scene.f4798a.c(), "scene-scheduler");
        } else {
            nbVar = new nb(Scene.f4798a.c());
        }
        nbVar.d(false);
        nbVar.j(true);
        nbVar.o(null);
        nbVar.m(true);
        nbVar.l(false);
        f102a = nbVar;
    }

    public static /* synthetic */ void h(aq0 aq0Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        aq0Var.g(z);
    }

    public final Bitmap a(int i) {
        Bitmap bitmap = b.get(Integer.valueOf(i));
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(Scene.f4798a.c().getResources(), i);
        b.put(Integer.valueOf(i), bitmapDecodeResource);
        f92.c(bitmapDecodeResource, "img");
        return bitmapDecodeResource;
    }

    public final CharSequence b(String str) {
        CharSequence charSequenceLoadLabel;
        CharSequence charSequence = f107a.get(str);
        if (charSequence != null) {
            return charSequence;
        }
        try {
            charSequenceLoadLabel = d().getPackageInfo(str, 0).applicationInfo.loadLabel(d());
        } catch (Exception unused) {
            charSequenceLoadLabel = str;
        }
        f92.c(charSequenceLoadLabel, "try {\n                pm…packageName\n            }");
        f107a.put(str, charSequenceLoadLabel);
        return charSequenceLoadLabel;
    }

    public final int c(int i) {
        if (i < 20) {
            return 2131230848;
        }
        if (i < 30) {
            return 2131230849;
        }
        return i < 70 ? 2131230850 : 2131230851;
    }

    public final PackageManager d() {
        return (PackageManager) f104a.getValue();
    }

    public final boolean e() {
        return Scene.f4798a.b(hz0.f1282a.G(), tj0.f7508a.a() || tj0.f7508a.b());
    }

    @Override // a.ha0
    public boolean eventFilter(aa0 aa0Var) {
        f92.d(aa0Var, "eventType");
        return aa0Var == aa0.SCENE_MODE_ACTION || aa0Var == aa0.SCENE_NOTIFY_UPDATE;
    }

    public final void f() {
        if (f105a != null) {
            f106a.cancel(256);
            f105a = null;
        }
    }

    public final void g(boolean z) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (z || Math.abs(jCurrentTimeMillis - f5632a) > 5000) {
                String strD = wu0.f3480a.d();
                boolean z2 = true;
                if (strD.length() == 0) {
                    strD = "";
                }
                String strB = wu0.f3480a.q().b();
                String strJ = fa0.f867a.j();
                if (strB.length() == 0) {
                    strB = strJ.length() == 0 ? "android" : strJ;
                }
                String strM = wu0.f3480a.m();
                if (!(strM == null || strM.length() == 0)) {
                    strB = strM;
                }
                String strL = wu0.f3480a.l();
                if (strL != null && strL.length() != 0) {
                    z2 = false;
                }
                if (z2 || f92.a(strL, strD)) {
                    strL = null;
                }
                i(strB, strJ, strD, strL);
                f5632a = jCurrentTimeMillis;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public final void i(String str, String str2, String str3, String str4) {
        CharSequence charSequenceB;
        Bitmap bitmapA;
        String strK;
        String str5;
        if (c) {
            if (f92.a(str, str2)) {
                charSequenceB = b(str2);
            } else {
                charSequenceB = b(str).toString() + "/" + b(str2).toString();
            }
            String string = "";
            Bitmap bitmapA2 = a(f103a.b(str3));
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(fa0.f867a.o());
                sb.append((char) 8451);
                string = sb.toString();
                bitmapA = fa0.f867a.m() ? a(c(fa0.f867a.a())) : a(2131230852);
                try {
                    bitmapA2 = a(f103a.b(str3));
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                bitmapA = null;
            }
            boolean z = true;
            PendingIntent broadcast = f92.a(e50.f677a.y0(), "basic") ^ true ? PendingIntent.getBroadcast(Scene.f4798a.c(), 0, new Intent(Scene.f4798a.c(), (Class<?>) ReceiverSceneMode.class), 201326592) : PendingIntent.getActivity(Scene.f4798a.c(), 0, new Intent(Scene.f4798a.c(), (Class<?>) ActivityMain.class), 201326592);
            if (str4 != null && str4.length() != 0) {
                z = false;
            }
            if (z) {
                strK = wu0.f3480a.k(str3);
            } else {
                strK = "▶" + wu0.f3480a.k(str4);
            }
            if (SystemClock.uptimeMillis() - AccessibilitySceneMode.f8452a.a() < 55000) {
                str5 = fa0.f867a.n() + ' ' + fa0.f867a.a() + "% " + string;
            } else {
                str5 = fa0.f867a.a() + "% " + string;
            }
            int iA = f103a.a(str3);
            nb nbVar = f102a;
            nbVar.n(iA);
            nbVar.p(System.currentTimeMillis());
            if (f101a.e()) {
                nbVar.g(charSequenceB);
                nbVar.f(strK + "  " + str5);
                nbVar.h(null);
            } else {
                RemoteViews remoteViews = new RemoteViews(Scene.f4798a.c().getPackageName(), 2131558605);
                remoteViews.setTextViewText(t61.notify_title, charSequenceB);
                remoteViews.setTextViewText(t61.notify_text, strK);
                remoteViews.setTextViewText(t61.notify_battery_text, str5);
                remoteViews.setImageViewBitmap(t61.notify_mode, bitmapA2);
                if (bitmapA != null) {
                    remoteViews.setImageViewBitmap(t61.notify_battery_icon, bitmapA);
                }
                nbVar.h(remoteViews);
            }
            nbVar.e(broadcast);
            Notification notificationA = nbVar.a();
            notificationA.flags = 98;
            f105a = notificationA;
            f106a.notify(256, notificationA);
        }
    }

    @Override // a.ha0
    public boolean isAsync() {
        return f108b;
    }

    public final void j(boolean z) {
        c = z;
        if (z) {
            h(this, false, 1, null);
        } else {
            f();
        }
    }

    @Override // a.ha0
    public void onReceive(aa0 aa0Var, HashMap<String, Object> map) {
        f92.d(aa0Var, "eventType");
        Scene.f4798a.i(yp0.f8001a);
    }

    @Override // a.ha0
    public void onSubscribe() {
    }

    @Override // a.ha0
    public void onUnsubscribe() {
    }
}

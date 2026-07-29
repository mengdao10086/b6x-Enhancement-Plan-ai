package hu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes6.dex */
public class c {
    public static String A = null;
    public static volatile c B = null;
    public static volatile b C = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31466a = "VMS_IDLG_SDK_Client";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f31467b = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f31468c = "persist.sys.identifierid.supported";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f31469d = "appid";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f31470e = "type";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f31471f = "OAID";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f31472g = "VAID";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f31473h = "AAID";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f31474i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f31475j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f31476k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f31477l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f31478m = 11;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f31479n = 2000;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Context f31480o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f31481p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static d f31482q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static d f31483r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static d f31484s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static Object f31485t = new Object();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static HandlerThread f31486u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static Handler f31487v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f31488w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static String f31489x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static String f31490y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static String f31491z;

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 11) {
                String unused = c.f31488w = c.C.a(message.getData().getInt("type"), message.getData().getString("appid"));
                synchronized (c.f31485t) {
                    c.f31485t.notify();
                }
            }
        }
    }

    public static c a(Context context) {
        if (B == null) {
            synchronized (c.class) {
                f31480o = context.getApplicationContext();
                B = new c();
            }
        }
        if (C == null) {
            synchronized (c.class) {
                f31480o = context.getApplicationContext();
                o();
                C = new b(f31480o);
                l();
            }
        }
        return B;
    }

    public static String c(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e10) {
                e10.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void e(Context context, int i10, String str) {
        if (i10 == 0) {
            f31482q = new d(B, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f31482q);
            return;
        }
        if (i10 == 1) {
            f31483r = new d(B, 1, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, f31483r);
            return;
        }
        if (i10 != 2) {
            return;
        }
        f31484s = new d(B, 2, str);
        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, f31484s);
    }

    public static void l() {
        f31481p = "1".equals(c(f31468c, "0"));
    }

    public static void o() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        f31486u = handlerThread;
        handlerThread.start();
        f31487v = new a(f31486u.getLooper());
    }

    public String b(String str) {
        if (!f()) {
            return null;
        }
        String str2 = f31490y;
        if (str2 != null) {
            return str2;
        }
        d(1, str);
        if (f31483r == null && f31490y != null) {
            e(f31480o, 1, str);
        }
        return f31490y;
    }

    public void d(int i10, String str) {
        synchronized (f31485t) {
            i(i10, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                f31485t.wait(2000L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis < 2000) {
                if (i10 == 0) {
                    f31489x = f31488w;
                    f31488w = null;
                } else if (i10 != 1) {
                    if (i10 == 2) {
                        String str2 = f31488w;
                        if (str2 != null) {
                            f31491z = str2;
                            f31488w = null;
                        }
                    } else if (i10 != 4) {
                    }
                    A = f31488w;
                    f31488w = null;
                } else {
                    String str3 = f31488w;
                    if (str3 != null) {
                        f31490y = str3;
                        f31488w = null;
                    }
                }
            }
        }
    }

    public boolean f() {
        return f31481p;
    }

    public String g() {
        if (!f()) {
            return null;
        }
        String str = f31489x;
        if (str != null) {
            return str;
        }
        d(0, null);
        if (f31482q == null) {
            e(f31480o, 0, null);
        }
        return f31489x;
    }

    public String h(String str) {
        if (!f()) {
            return null;
        }
        String str2 = f31491z;
        if (str2 != null) {
            return str2;
        }
        d(2, str);
        if (f31484s == null && f31491z != null) {
            e(f31480o, 2, str);
        }
        return f31491z;
    }

    public final void i(int i10, String str) {
        Message messageObtainMessage = f31487v.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i10);
        if (i10 == 1 || i10 == 2) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        f31487v.sendMessage(messageObtainMessage);
    }

    public String j() {
        if (!f()) {
            return null;
        }
        d(4, null);
        return A;
    }
}

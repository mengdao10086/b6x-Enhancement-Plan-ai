package it.sephiroth.android.library.easing;

import android.os.Handler;
import android.os.SystemClock;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import nj.e;

/* JADX INFO: loaded from: classes5.dex */
public final class EasingManager {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f35866m = 60;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f35867n = 16;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Handler f35868o = new Handler();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f35869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f35870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f35871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f35872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f35873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f35874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f35875g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f35876h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f35877i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f35878j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f35879k = String.valueOf(System.currentTimeMillis());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f35880l;

    public enum EaseType {
        EaseIn,
        EaseOut,
        EaseInOut,
        EaseNone
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35881a;

        static {
            int[] iArr = new int[EaseType.values().length];
            f35881a = iArr;
            try {
                iArr[EaseType.EaseIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35881a[EaseType.EaseInOut.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35881a[EaseType.EaseNone.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35881a[EaseType.EaseOut.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface b {
        void a(double d10, double d11);

        void b(double d10);

        void c(double d10);
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long j10 = EasingManager.this.f35872d;
            long jUptimeMillis = SystemClock.uptimeMillis() - j10;
            EasingManager easingManager = EasingManager.this;
            double d10 = easingManager.f35876h;
            try {
                double dDoubleValue = ((Double) easingManager.f35870b.invoke(easingManager.f35869a, Long.valueOf(jUptimeMillis), Double.valueOf(EasingManager.this.f35874f), Double.valueOf(EasingManager.this.f35875g), Integer.valueOf(EasingManager.this.f35873e))).doubleValue();
                EasingManager easingManager2 = EasingManager.this;
                easingManager2.f35876h = dDoubleValue;
                long j11 = j10 + ((long) ((((int) (jUptimeMillis / 16)) + 1) * 16));
                if (jUptimeMillis >= easingManager2.f35873e) {
                    easingManager2.f35878j.c(easingManager2.f35877i ? easingManager2.f35875g : easingManager2.f35874f);
                    EasingManager.this.f35871c = false;
                    return;
                }
                b bVar = easingManager2.f35878j;
                if (easingManager2.f35877i) {
                    dDoubleValue = easingManager2.f35875g - dDoubleValue;
                }
                bVar.a(dDoubleValue, d10);
                EasingManager.f35868o.postAtTime(this, EasingManager.this.f35879k, j11);
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (IllegalArgumentException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f35883a;

        public d(double d10) {
            this.f35883a = d10;
        }

        @Override // java.lang.Runnable
        public void run() {
            EasingManager.this.f35878j.b(this.f35883a);
        }
    }

    public EasingManager(b bVar) {
        this.f35878j = bVar;
    }

    public e a(Class<? extends e> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
            return null;
        } catch (InstantiationException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public Method b(e eVar, EaseType easeType) {
        String strC = c(easeType);
        if (strC != null) {
            try {
                Class<?> cls = eVar.getClass();
                Class<?> cls2 = Double.TYPE;
                return cls.getMethod(strC, cls2, cls2, cls2, cls2);
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
                return null;
            } catch (SecurityException e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public String c(EaseType easeType) {
        int i10 = a.f35881a[easeType.ordinal()];
        if (i10 == 1) {
            return "easeIn";
        }
        if (i10 == 2) {
            return "easeInOut";
        }
        if (i10 == 3) {
            return "easeNone";
        }
        if (i10 != 4) {
            return null;
        }
        return "easeOut";
    }

    public void d(Class<? extends e> cls, EaseType easeType, double d10, double d11, int i10) {
        e(cls, easeType, d10, d11, i10, 0L);
    }

    public void e(Class<? extends e> cls, EaseType easeType, double d10, double d11, int i10, long j10) {
        if (this.f35871c) {
            return;
        }
        e eVarA = a(cls);
        this.f35869a = eVarA;
        if (eVarA == null) {
            return;
        }
        Method methodB = b(eVarA, easeType);
        this.f35870b = methodB;
        if (methodB == null) {
            return;
        }
        boolean z10 = d10 > d11;
        this.f35877i = z10;
        if (z10) {
            this.f35874f = d11;
            this.f35875g = d10;
        } else {
            this.f35874f = d10;
            this.f35875g = d11;
        }
        this.f35876h = this.f35874f;
        this.f35873e = i10;
        this.f35872d = SystemClock.uptimeMillis() + j10;
        this.f35871c = true;
        this.f35880l = new c();
        long jUptimeMillis = SystemClock.uptimeMillis() + 16 + j10;
        if (j10 == 0) {
            this.f35878j.b(d10);
        } else {
            f35868o.postAtTime(new d(d10), this.f35879k, jUptimeMillis - 16);
        }
        f35868o.postAtTime(this.f35880l, this.f35879k, jUptimeMillis);
    }

    public void f() {
        this.f35871c = false;
        f35868o.removeCallbacks(this.f35880l, this.f35879k);
    }
}

package e4;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import g.i1;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f26632e = "MemorySizeCalculator";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @i1
    public static final int f26633f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f26634g = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f26635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f26636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f26637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f26638d;

    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @i1
        public static final int f26639i = 2;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f26640j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final float f26641k = 0.4f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final float f26642l = 0.33f;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f26643m = 4194304;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f26644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ActivityManager f26645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f26646c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f26648e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f26647d = 2.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f26649f = 0.4f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f26650g = 0.33f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f26651h = 4194304;

        static {
            f26640j = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f26648e = f26640j;
            this.f26644a = context;
            this.f26645b = (ActivityManager) context.getSystemService(androidx.appcompat.widget.c.f2369r);
            this.f26646c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !l.e(this.f26645b)) {
                return;
            }
            this.f26648e = 0.0f;
        }

        public l a() {
            return new l(this);
        }

        @i1
        public a b(ActivityManager activityManager) {
            this.f26645b = activityManager;
            return this;
        }

        public a c(int i10) {
            this.f26651h = i10;
            return this;
        }

        public a d(float f10) {
            v4.m.a(f10 >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.f26648e = f10;
            return this;
        }

        public a e(float f10) {
            v4.m.a(f10 >= 0.0f && f10 <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.f26650g = f10;
            return this;
        }

        public a f(float f10) {
            v4.m.a(f10 >= 0.0f && f10 <= 1.0f, "Size multiplier must be between 0 and 1");
            this.f26649f = f10;
            return this;
        }

        public a g(float f10) {
            v4.m.a(f10 >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.f26647d = f10;
            return this;
        }

        @i1
        public a h(c cVar) {
            this.f26646c = cVar;
            return this;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DisplayMetrics f26652a;

        public b(DisplayMetrics displayMetrics) {
            this.f26652a = displayMetrics;
        }

        @Override // e4.l.c
        public int a() {
            return this.f26652a.heightPixels;
        }

        @Override // e4.l.c
        public int b() {
            return this.f26652a.widthPixels;
        }
    }

    public interface c {
        int a();

        int b();
    }

    public l(a aVar) {
        this.f26637c = aVar.f26644a;
        int i10 = e(aVar.f26645b) ? aVar.f26651h / 2 : aVar.f26651h;
        this.f26638d = i10;
        int iC = c(aVar.f26645b, aVar.f26649f, aVar.f26650g);
        float fB = aVar.f26646c.b() * aVar.f26646c.a() * 4;
        int iRound = Math.round(aVar.f26648e * fB);
        int iRound2 = Math.round(fB * aVar.f26647d);
        int i11 = iC - i10;
        int i12 = iRound2 + iRound;
        if (i12 <= i11) {
            this.f26636b = iRound2;
            this.f26635a = iRound;
        } else {
            float f10 = i11;
            float f11 = aVar.f26648e;
            float f12 = aVar.f26647d;
            float f13 = f10 / (f11 + f12);
            this.f26636b = Math.round(f12 * f13);
            this.f26635a = Math.round(f13 * aVar.f26648e);
        }
        if (Log.isLoggable(f26632e, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Calculation complete, Calculated memory cache size: ");
            sb2.append(f(this.f26636b));
            sb2.append(", pool size: ");
            sb2.append(f(this.f26635a));
            sb2.append(", byte array size: ");
            sb2.append(f(i10));
            sb2.append(", memory class limited? ");
            sb2.append(i12 > iC);
            sb2.append(", max size: ");
            sb2.append(f(iC));
            sb2.append(", memoryClass: ");
            sb2.append(aVar.f26645b.getMemoryClass());
            sb2.append(", isLowMemoryDevice: ");
            sb2.append(e(aVar.f26645b));
        }
    }

    public static int c(ActivityManager activityManager, float f10, float f11) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (e(activityManager)) {
            f10 = f11;
        }
        return Math.round(memoryClass * f10);
    }

    @TargetApi(19)
    public static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    public int a() {
        return this.f26638d;
    }

    public int b() {
        return this.f26635a;
    }

    public int d() {
        return this.f26636b;
    }

    public final String f(int i10) {
        return Formatter.formatFileSize(this.f26637c, i10);
    }
}

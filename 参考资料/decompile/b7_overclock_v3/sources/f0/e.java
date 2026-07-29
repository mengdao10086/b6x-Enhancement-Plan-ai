package f0;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f27415a = "android.activity.usage_time";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f27416b = "android.usage_time_packages";

    @v0(16)
    public static class a extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ActivityOptions f27417c;

        public a(ActivityOptions activityOptions) {
            this.f27417c = activityOptions;
        }

        @Override // f0.e
        public Rect a() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return C0319e.a(this.f27417c);
        }

        @Override // f0.e
        public void j(@n0 PendingIntent pendingIntent) {
            if (Build.VERSION.SDK_INT >= 23) {
                d.c(this.f27417c, pendingIntent);
            }
        }

        @Override // f0.e
        @n0
        public e k(@p0 Rect rect) {
            return Build.VERSION.SDK_INT < 24 ? this : new a(C0319e.b(this.f27417c, rect));
        }

        @Override // f0.e
        public Bundle l() {
            return this.f27417c.toBundle();
        }

        @Override // f0.e
        public void m(@n0 e eVar) {
            if (eVar instanceof a) {
                this.f27417c.update(((a) eVar).f27417c);
            }
        }
    }

    @v0(16)
    public static class b {
        @g.u
        public static ActivityOptions a(Context context, int i10, int i11) {
            return ActivityOptions.makeCustomAnimation(context, i10, i11);
        }

        @g.u
        public static ActivityOptions b(View view, int i10, int i11, int i12, int i13) {
            return ActivityOptions.makeScaleUpAnimation(view, i10, i11, i12, i13);
        }

        @g.u
        public static ActivityOptions c(View view, Bitmap bitmap, int i10, int i11) {
            return ActivityOptions.makeThumbnailScaleUpAnimation(view, bitmap, i10, i11);
        }
    }

    @v0(21)
    public static class c {
        @g.u
        public static ActivityOptions a(Activity activity, View view, String str) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, view, str);
        }

        @g.u
        @SafeVarargs
        public static ActivityOptions b(Activity activity, Pair<View, String>... pairArr) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, pairArr);
        }

        @g.u
        public static ActivityOptions c() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }

    @v0(23)
    public static class d {
        @g.u
        public static ActivityOptions a() {
            return ActivityOptions.makeBasic();
        }

        @g.u
        public static ActivityOptions b(View view, int i10, int i11, int i12, int i13) {
            return ActivityOptions.makeClipRevealAnimation(view, i10, i11, i12, i13);
        }

        @g.u
        public static void c(ActivityOptions activityOptions, PendingIntent pendingIntent) {
            activityOptions.requestUsageTimeReport(pendingIntent);
        }
    }

    /* JADX INFO: renamed from: f0.e$e, reason: collision with other inner class name */
    @v0(24)
    public static class C0319e {
        @g.u
        public static Rect a(ActivityOptions activityOptions) {
            return activityOptions.getLaunchBounds();
        }

        @g.u
        public static ActivityOptions b(ActivityOptions activityOptions, Rect rect) {
            return activityOptions.setLaunchBounds(rect);
        }
    }

    @n0
    public static e b() {
        return Build.VERSION.SDK_INT >= 23 ? new a(d.a()) : new e();
    }

    @n0
    public static e c(@n0 View view, int i10, int i11, int i12, int i13) {
        return Build.VERSION.SDK_INT >= 23 ? new a(d.b(view, i10, i11, i12, i13)) : new e();
    }

    @n0
    public static e d(@n0 Context context, int i10, int i11) {
        return new a(b.a(context, i10, i11));
    }

    @n0
    public static e e(@n0 View view, int i10, int i11, int i12, int i13) {
        return new a(b.b(view, i10, i11, i12, i13));
    }

    @n0
    public static e f(@n0 Activity activity, @n0 View view, @n0 String str) {
        return new a(c.a(activity, view, str));
    }

    @n0
    public static e g(@n0 Activity activity, @p0 androidx.core.util.k<View, String>... kVarArr) {
        Pair[] pairArr = null;
        if (kVarArr != null) {
            pairArr = new Pair[kVarArr.length];
            for (int i10 = 0; i10 < kVarArr.length; i10++) {
                pairArr[i10] = Pair.create(kVarArr[i10].f4741a, kVarArr[i10].f4742b);
            }
        }
        return new a(c.b(activity, pairArr));
    }

    @n0
    public static e h() {
        return new a(c.c());
    }

    @n0
    public static e i(@n0 View view, @n0 Bitmap bitmap, int i10, int i11) {
        return new a(b.c(view, bitmap, i10, i11));
    }

    @p0
    public Rect a() {
        return null;
    }

    public void j(@n0 PendingIntent pendingIntent) {
    }

    @n0
    public e k(@p0 Rect rect) {
        return this;
    }

    @p0
    public Bundle l() {
        return null;
    }

    public void m(@n0 e eVar) {
    }
}

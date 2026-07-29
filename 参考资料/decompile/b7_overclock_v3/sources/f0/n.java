package f0;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f27523b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f27524c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f27525d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f27526e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f27527f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f27528g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f27529h = 6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f27530i = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f27531j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f27532k = 8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f27533l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f27534m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f27535n = 4;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f27536o = 8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f27537p = 16;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f27538q = 32;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f27539r = 64;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f27540s = 128;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f27541t = 256;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f27542u = 511;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f27543a;

    @v0(24)
    public static class a extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f27544e = 1000000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f27545f = 500000;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static HandlerThread f27546g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static Handler f27547h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f27548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseIntArray[] f27549b = new SparseIntArray[9];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<WeakReference<Activity>> f27550c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Window.OnFrameMetricsAvailableListener f27551d = new WindowOnFrameMetricsAvailableListenerC0320a();

        /* JADX INFO: renamed from: f0.n$a$a, reason: collision with other inner class name */
        public class WindowOnFrameMetricsAvailableListenerC0320a implements Window.OnFrameMetricsAvailableListener {
            public WindowOnFrameMetricsAvailableListenerC0320a() {
            }

            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i10) {
                a aVar = a.this;
                if ((aVar.f27548a & 1) != 0) {
                    aVar.f(aVar.f27549b[0], frameMetrics.getMetric(8));
                }
                a aVar2 = a.this;
                if ((aVar2.f27548a & 2) != 0) {
                    aVar2.f(aVar2.f27549b[1], frameMetrics.getMetric(1));
                }
                a aVar3 = a.this;
                if ((aVar3.f27548a & 4) != 0) {
                    aVar3.f(aVar3.f27549b[2], frameMetrics.getMetric(3));
                }
                a aVar4 = a.this;
                if ((aVar4.f27548a & 8) != 0) {
                    aVar4.f(aVar4.f27549b[3], frameMetrics.getMetric(4));
                }
                a aVar5 = a.this;
                if ((aVar5.f27548a & 16) != 0) {
                    aVar5.f(aVar5.f27549b[4], frameMetrics.getMetric(5));
                }
                a aVar6 = a.this;
                if ((aVar6.f27548a & 64) != 0) {
                    aVar6.f(aVar6.f27549b[6], frameMetrics.getMetric(7));
                }
                a aVar7 = a.this;
                if ((aVar7.f27548a & 32) != 0) {
                    aVar7.f(aVar7.f27549b[5], frameMetrics.getMetric(6));
                }
                a aVar8 = a.this;
                if ((aVar8.f27548a & 128) != 0) {
                    aVar8.f(aVar8.f27549b[7], frameMetrics.getMetric(0));
                }
                a aVar9 = a.this;
                if ((aVar9.f27548a & 256) != 0) {
                    aVar9.f(aVar9.f27549b[8], frameMetrics.getMetric(2));
                }
            }
        }

        public a(int i10) {
            this.f27548a = i10;
        }

        @Override // f0.n.b
        public void a(Activity activity) {
            if (f27546g == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                f27546g = handlerThread;
                handlerThread.start();
                f27547h = new Handler(f27546g.getLooper());
            }
            for (int i10 = 0; i10 <= 8; i10++) {
                SparseIntArray[] sparseIntArrayArr = this.f27549b;
                if (sparseIntArrayArr[i10] == null && (this.f27548a & (1 << i10)) != 0) {
                    sparseIntArrayArr[i10] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f27551d, f27547h);
            this.f27550c.add(new WeakReference<>(activity));
        }

        @Override // f0.n.b
        public SparseIntArray[] b() {
            return this.f27549b;
        }

        @Override // f0.n.b
        public SparseIntArray[] c(Activity activity) {
            Iterator<WeakReference<Activity>> it2 = this.f27550c.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = it2.next();
                if (next.get() == activity) {
                    this.f27550c.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f27551d);
            return this.f27549b;
        }

        @Override // f0.n.b
        public SparseIntArray[] d() {
            SparseIntArray[] sparseIntArrayArr = this.f27549b;
            this.f27549b = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        @Override // f0.n.b
        public SparseIntArray[] e() {
            for (int size = this.f27550c.size() - 1; size >= 0; size--) {
                WeakReference<Activity> weakReference = this.f27550c.get(size);
                Activity activity = weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.f27551d);
                    this.f27550c.remove(size);
                }
            }
            return this.f27549b;
        }

        public void f(SparseIntArray sparseIntArray, long j10) {
            if (sparseIntArray != null) {
                int i10 = (int) ((500000 + j10) / 1000000);
                if (j10 >= 0) {
                    sparseIntArray.put(i10, sparseIntArray.get(i10) + 1);
                }
            }
        }
    }

    public static class b {
        public void a(Activity activity) {
        }

        public SparseIntArray[] b() {
            return null;
        }

        public SparseIntArray[] c(Activity activity) {
            return null;
        }

        public SparseIntArray[] d() {
            return null;
        }

        public SparseIntArray[] e() {
            return null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface c {
    }

    public n() {
        this(1);
    }

    public void a(@n0 Activity activity) {
        this.f27543a.a(activity);
    }

    @p0
    public SparseIntArray[] b() {
        return this.f27543a.b();
    }

    @p0
    public SparseIntArray[] c(@n0 Activity activity) {
        return this.f27543a.c(activity);
    }

    @p0
    public SparseIntArray[] d() {
        return this.f27543a.d();
    }

    @p0
    public SparseIntArray[] e() {
        return this.f27543a.e();
    }

    public n(int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f27543a = new a(i10);
        } else {
            this.f27543a = new b();
        }
    }
}

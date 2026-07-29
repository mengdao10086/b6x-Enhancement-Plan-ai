package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.work.x;
import g.n0;
import g.v0;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends x {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SuppressLint({"MinMaxConstant"})
    public static final long f8749g = 900000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SuppressLint({"MinMaxConstant"})
    public static final long f8750h = 300000;

    public p(a builder) {
        super(builder.f8766b, builder.f8767c, builder.f8768d);
    }

    public static final class a extends x.a<a, p> {
        public a(@n0 Class<? extends ListenableWorker> workerClass, long repeatInterval, @n0 TimeUnit repeatIntervalTimeUnit) {
            super(workerClass);
            this.f8767c.f(repeatIntervalTimeUnit.toMillis(repeatInterval));
        }

        @Override // androidx.work.x.a
        @n0
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public p c() {
            if (this.f8765a && Build.VERSION.SDK_INT >= 23 && this.f8767c.f51850j.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            if (this.f8767c.f51857q) {
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
            }
            return new p(this);
        }

        @Override // androidx.work.x.a
        @n0
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public a d() {
            return this;
        }

        @v0(26)
        public a(@n0 Class<? extends ListenableWorker> workerClass, @n0 Duration repeatInterval) {
            super(workerClass);
            this.f8767c.f(repeatInterval.toMillis());
        }

        public a(@n0 Class<? extends ListenableWorker> workerClass, long repeatInterval, @n0 TimeUnit repeatIntervalTimeUnit, long flexInterval, @n0 TimeUnit flexIntervalTimeUnit) {
            super(workerClass);
            this.f8767c.g(repeatIntervalTimeUnit.toMillis(repeatInterval), flexIntervalTimeUnit.toMillis(flexInterval));
        }

        @v0(26)
        public a(@n0 Class<? extends ListenableWorker> workerClass, @n0 Duration repeatInterval, @n0 Duration flexInterval) {
            super(workerClass);
            this.f8767c.g(repeatInterval.toMillis(), flexInterval.toMillis());
        }
    }
}

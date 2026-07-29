package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import g.h1;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager2 f8238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f8239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f8240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VelocityTracker f8241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f8243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f8245h;

    public d(ViewPager2 viewPager2, g gVar, RecyclerView recyclerView) {
        this.f8238a = viewPager2;
        this.f8239b = gVar;
        this.f8240c = recyclerView;
    }

    public final void a(long j10, int i10, float f10, float f11) {
        MotionEvent motionEventObtain = MotionEvent.obtain(this.f8245h, j10, i10, f10, f11, 0);
        this.f8241d.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    @h1
    public boolean b() {
        if (this.f8239b.i()) {
            return false;
        }
        this.f8244g = 0;
        this.f8243f = 0;
        this.f8245h = SystemClock.uptimeMillis();
        c();
        this.f8239b.m();
        if (!this.f8239b.k()) {
            this.f8240c.O1();
        }
        a(this.f8245h, 0, 0.0f, 0.0f);
        return true;
    }

    public final void c() {
        VelocityTracker velocityTracker = this.f8241d;
        if (velocityTracker != null) {
            velocityTracker.clear();
        } else {
            this.f8241d = VelocityTracker.obtain();
            this.f8242e = ViewConfiguration.get(this.f8238a.getContext()).getScaledMaximumFlingVelocity();
        }
    }

    @h1
    public boolean d() {
        if (!this.f8239b.j()) {
            return false;
        }
        this.f8239b.o();
        VelocityTracker velocityTracker = this.f8241d;
        velocityTracker.computeCurrentVelocity(1000, this.f8242e);
        if (this.f8240c.m0((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.f8238a.v();
        return true;
    }

    @h1
    public boolean e(float f10) {
        if (!this.f8239b.j()) {
            return false;
        }
        float f11 = this.f8243f - f10;
        this.f8243f = f11;
        int iRound = Math.round(f11 - this.f8244g);
        this.f8244g += iRound;
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean z10 = this.f8238a.getOrientation() == 0;
        int i10 = z10 ? iRound : 0;
        int i11 = z10 ? 0 : iRound;
        float f12 = z10 ? this.f8243f : 0.0f;
        float f13 = z10 ? 0.0f : this.f8243f;
        this.f8240c.scrollBy(i10, i11);
        a(jUptimeMillis, 2, f12, f13);
        return true;
    }

    public boolean f() {
        return this.f8239b.j();
    }
}

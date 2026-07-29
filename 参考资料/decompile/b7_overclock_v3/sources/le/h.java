package le;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f39601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f39602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScrollView f39603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f39604d = new int[2];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f39605e = new int[2];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewTreeObserver.OnScrollChangedListener f39606f = new a();

    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            h.this.e();
        }
    }

    public h(View view, j jVar, ScrollView scrollView) {
        this.f39601a = view;
        this.f39602b = jVar;
        this.f39603c = scrollView;
    }

    public void a(ScrollView scrollView) {
        this.f39603c = scrollView;
    }

    public void b(j jVar) {
        this.f39602b = jVar;
    }

    public void c(@n0 ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this.f39606f);
    }

    public void d(@n0 ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this.f39606f);
    }

    public void e() {
        ScrollView scrollView = this.f39603c;
        if (scrollView == null) {
            return;
        }
        if (scrollView.getChildCount() == 0) {
            throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
        }
        this.f39603c.getLocationInWindow(this.f39604d);
        this.f39603c.getChildAt(0).getLocationInWindow(this.f39605e);
        int top2 = (this.f39601a.getTop() - this.f39604d[1]) + this.f39605e[1];
        int height = this.f39601a.getHeight();
        int height2 = this.f39603c.getHeight();
        if (top2 < 0) {
            this.f39602b.p0(Math.max(0.0f, Math.min(1.0f, (top2 / height) + 1.0f)));
            this.f39601a.invalidate();
            return;
        }
        if (top2 + height > height2) {
            this.f39602b.p0(Math.max(0.0f, Math.min(1.0f, 1.0f - ((r0 - height2) / height))));
            this.f39601a.invalidate();
        } else if (this.f39602b.z() != 1.0f) {
            this.f39602b.p0(1.0f);
            this.f39601a.invalidate();
        }
    }
}

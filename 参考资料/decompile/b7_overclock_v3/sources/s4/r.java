package s4;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R;
import g.i1;
import g.n0;
import g.p0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class r<T extends View, Z> extends s4.b<Z> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f49500g = "ViewTarget";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f49501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f49502i = R.id.glide_custom_view_target_tag;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f49503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f49504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public View.OnAttachStateChangeListener f49505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f49506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f49507f;

    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.this.p();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.this.o();
        }
    }

    @i1
    public static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f49509e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @i1
        @p0
        public static Integer f49510f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f49511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<o> f49512b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f49513c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public a f49514d;

        public static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final WeakReference<b> f49515a;

            public a(@n0 b bVar) {
                this.f49515a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(r.f49500g, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("OnGlobalLayoutListener called attachStateListener=");
                    sb2.append(this);
                }
                b bVar = this.f49515a.get();
                if (bVar == null) {
                    return true;
                }
                bVar.a();
                return true;
            }
        }

        public b(@n0 View view) {
            this.f49511a = view;
        }

        public static int c(@n0 Context context) {
            if (f49510f == null) {
                Display defaultDisplay = ((WindowManager) v4.m.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f49510f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f49510f.intValue();
        }

        public void a() {
            if (this.f49512b.isEmpty()) {
                return;
            }
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                j(iG, iF);
                b();
            }
        }

        public void b() {
            ViewTreeObserver viewTreeObserver = this.f49511a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f49514d);
            }
            this.f49514d = null;
            this.f49512b.clear();
        }

        public void d(@n0 o oVar) {
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                oVar.e(iG, iF);
                return;
            }
            if (!this.f49512b.contains(oVar)) {
                this.f49512b.add(oVar);
            }
            if (this.f49514d == null) {
                ViewTreeObserver viewTreeObserver = this.f49511a.getViewTreeObserver();
                a aVar = new a(this);
                this.f49514d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        public final int e(int i10, int i11, int i12) {
            int i13 = i11 - i12;
            if (i13 > 0) {
                return i13;
            }
            if (this.f49513c && this.f49511a.isLayoutRequested()) {
                return 0;
            }
            int i14 = i10 - i12;
            if (i14 > 0) {
                return i14;
            }
            if (this.f49511a.isLayoutRequested() || i11 != -2) {
                return 0;
            }
            return c(this.f49511a.getContext());
        }

        public final int f() {
            int paddingTop = this.f49511a.getPaddingTop() + this.f49511a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f49511a.getLayoutParams();
            return e(this.f49511a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        public final int g() {
            int paddingLeft = this.f49511a.getPaddingLeft() + this.f49511a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f49511a.getLayoutParams();
            return e(this.f49511a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        public final boolean h(int i10) {
            return i10 > 0 || i10 == Integer.MIN_VALUE;
        }

        public final boolean i(int i10, int i11) {
            return h(i10) && h(i11);
        }

        public final void j(int i10, int i11) {
            Iterator it2 = new ArrayList(this.f49512b).iterator();
            while (it2.hasNext()) {
                ((o) it2.next()).e(i10, i11);
            }
        }

        public void k(@n0 o oVar) {
            this.f49512b.remove(oVar);
        }
    }

    public r(@n0 T t10) {
        this.f49503b = (T) v4.m.d(t10);
        this.f49504c = new b(t10);
    }

    @Deprecated
    public static void u(int i10) {
        if (f49501h) {
            throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        f49502i = i10;
    }

    @Override // s4.p
    @g.i
    public void f(@n0 o oVar) {
        this.f49504c.k(oVar);
    }

    @n0
    public T getView() {
        return this.f49503b;
    }

    @n0
    public final r<T, Z> h() {
        if (this.f49505d != null) {
            return this;
        }
        this.f49505d = new a();
        j();
        return this;
    }

    @p0
    public final Object i() {
        return this.f49503b.getTag(f49502i);
    }

    public final void j() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f49505d;
        if (onAttachStateChangeListener == null || this.f49507f) {
            return;
        }
        this.f49503b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f49507f = true;
    }

    public final void k() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f49505d;
        if (onAttachStateChangeListener == null || !this.f49507f) {
            return;
        }
        this.f49503b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f49507f = false;
    }

    @Override // s4.b, s4.p
    public void l(@p0 com.bumptech.glide.request.e eVar) {
        t(eVar);
    }

    @Override // s4.p
    @g.i
    public void m(@n0 o oVar) {
        this.f49504c.d(oVar);
    }

    public void o() {
        com.bumptech.glide.request.e eVarR = r();
        if (eVarR != null) {
            this.f49506e = true;
            eVarR.clear();
            this.f49506e = false;
        }
    }

    public void p() {
        com.bumptech.glide.request.e eVarR = r();
        if (eVarR == null || !eVarR.f()) {
            return;
        }
        eVarR.h();
    }

    @Override // s4.b, s4.p
    @g.i
    public void q(@p0 Drawable drawable) {
        super.q(drawable);
        j();
    }

    @Override // s4.b, s4.p
    @p0
    public com.bumptech.glide.request.e r() {
        Object objI = i();
        if (objI == null) {
            return null;
        }
        if (objI instanceof com.bumptech.glide.request.e) {
            return (com.bumptech.glide.request.e) objI;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // s4.b, s4.p
    @g.i
    public void s(@p0 Drawable drawable) {
        super.s(drawable);
        this.f49504c.b();
        if (this.f49506e) {
            return;
        }
        k();
    }

    public final void t(@p0 Object obj) {
        f49501h = true;
        this.f49503b.setTag(f49502i, obj);
    }

    public String toString() {
        return "Target for: " + this.f49503b;
    }

    @n0
    public final r<T, Z> v() {
        this.f49504c.f49513c = true;
        return this;
    }

    @Deprecated
    public r(@n0 T t10, boolean z10) {
        this(t10);
        if (z10) {
            v();
        }
    }
}

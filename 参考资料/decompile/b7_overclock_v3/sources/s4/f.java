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
import g.d0;
import g.i1;
import g.n0;
import g.p0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f<T extends View, Z> implements p<Z> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f49463f = "CustomViewTarget";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @d0
    public static final int f49464g = R.id.glide_custom_view_target_tag;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f49465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f49466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public View.OnAttachStateChangeListener f49467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f49468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f49469e;

    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            f.this.t();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            f.this.p();
        }
    }

    @i1
    public static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f49471e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @i1
        @p0
        public static Integer f49472f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f49473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<o> f49474b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f49475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public a f49476d;

        public static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final WeakReference<b> f49477a;

            public a(@n0 b bVar) {
                this.f49477a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(f.f49463f, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("OnGlobalLayoutListener called attachStateListener=");
                    sb2.append(this);
                }
                b bVar = this.f49477a.get();
                if (bVar == null) {
                    return true;
                }
                bVar.a();
                return true;
            }
        }

        public b(@n0 View view) {
            this.f49473a = view;
        }

        public static int c(@n0 Context context) {
            if (f49472f == null) {
                Display defaultDisplay = ((WindowManager) v4.m.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f49472f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f49472f.intValue();
        }

        public void a() {
            if (this.f49474b.isEmpty()) {
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
            ViewTreeObserver viewTreeObserver = this.f49473a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f49476d);
            }
            this.f49476d = null;
            this.f49474b.clear();
        }

        public void d(@n0 o oVar) {
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                oVar.e(iG, iF);
                return;
            }
            if (!this.f49474b.contains(oVar)) {
                this.f49474b.add(oVar);
            }
            if (this.f49476d == null) {
                ViewTreeObserver viewTreeObserver = this.f49473a.getViewTreeObserver();
                a aVar = new a(this);
                this.f49476d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        public final int e(int i10, int i11, int i12) {
            int i13 = i11 - i12;
            if (i13 > 0) {
                return i13;
            }
            if (this.f49475c && this.f49473a.isLayoutRequested()) {
                return 0;
            }
            int i14 = i10 - i12;
            if (i14 > 0) {
                return i14;
            }
            if (this.f49473a.isLayoutRequested() || i11 != -2) {
                return 0;
            }
            return c(this.f49473a.getContext());
        }

        public final int f() {
            int paddingTop = this.f49473a.getPaddingTop() + this.f49473a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f49473a.getLayoutParams();
            return e(this.f49473a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        public final int g() {
            int paddingLeft = this.f49473a.getPaddingLeft() + this.f49473a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f49473a.getLayoutParams();
            return e(this.f49473a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        public final boolean h(int i10) {
            return i10 > 0 || i10 == Integer.MIN_VALUE;
        }

        public final boolean i(int i10, int i11) {
            return h(i10) && h(i11);
        }

        public final void j(int i10, int i11) {
            Iterator it2 = new ArrayList(this.f49474b).iterator();
            while (it2.hasNext()) {
                ((o) it2.next()).e(i10, i11);
            }
        }

        public void k(@n0 o oVar) {
            this.f49474b.remove(oVar);
        }
    }

    public f(@n0 T t10) {
        this.f49466b = (T) v4.m.d(t10);
        this.f49465a = new b(t10);
    }

    @Override // p4.m
    public void a() {
    }

    @Override // p4.m
    public void b() {
    }

    @Override // p4.m
    public void c() {
    }

    @n0
    public final f<T, Z> d() {
        if (this.f49467c != null) {
            return this;
        }
        this.f49467c = new a();
        i();
        return this;
    }

    @p0
    public final Object e() {
        return this.f49466b.getTag(f49464g);
    }

    @Override // s4.p
    public final void f(@n0 o oVar) {
        this.f49465a.k(oVar);
    }

    @n0
    public final T h() {
        return this.f49466b;
    }

    public final void i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f49467c;
        if (onAttachStateChangeListener == null || this.f49469e) {
            return;
        }
        this.f49466b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f49469e = true;
    }

    public final void j() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f49467c;
        if (onAttachStateChangeListener == null || !this.f49469e) {
            return;
        }
        this.f49466b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f49469e = false;
    }

    public abstract void k(@p0 Drawable drawable);

    @Override // s4.p
    public final void l(@p0 com.bumptech.glide.request.e eVar) {
        u(eVar);
    }

    @Override // s4.p
    public final void m(@n0 o oVar) {
        this.f49465a.d(oVar);
    }

    public void o(@p0 Drawable drawable) {
    }

    public final void p() {
        com.bumptech.glide.request.e eVarR = r();
        if (eVarR != null) {
            this.f49468d = true;
            eVarR.clear();
            this.f49468d = false;
        }
    }

    @Override // s4.p
    public final void q(@p0 Drawable drawable) {
        i();
        o(drawable);
    }

    @Override // s4.p
    @p0
    public final com.bumptech.glide.request.e r() {
        Object objE = e();
        if (objE == null) {
            return null;
        }
        if (objE instanceof com.bumptech.glide.request.e) {
            return (com.bumptech.glide.request.e) objE;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // s4.p
    public final void s(@p0 Drawable drawable) {
        this.f49465a.b();
        k(drawable);
        if (this.f49468d) {
            return;
        }
        j();
    }

    public final void t() {
        com.bumptech.glide.request.e eVarR = r();
        if (eVarR == null || !eVarR.f()) {
            return;
        }
        eVarR.h();
    }

    public String toString() {
        return "Target for: " + this.f49466b;
    }

    public final void u(@p0 Object obj) {
        this.f49466b.setTag(f49464g, obj);
    }

    @Deprecated
    public final f<T, Z> v(@d0 int i10) {
        return this;
    }

    @n0
    public final f<T, Z> w() {
        this.f49465a.f49475c = true;
        return this;
    }
}

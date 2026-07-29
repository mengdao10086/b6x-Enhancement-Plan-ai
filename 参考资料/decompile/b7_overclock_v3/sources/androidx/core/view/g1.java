package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.view.j1;
import com.google.common.collect.LinkedHashMultimap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class g1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f4881b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f4882c = "WindowInsetsAnimCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f4883a;

    public static abstract class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f4886c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f4887d = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WindowInsets f4888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4889b;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface a {
        }

        public b(int i10) {
            this.f4889b = i10;
        }

        public final int a() {
            return this.f4889b;
        }

        public void b(@g.n0 g1 g1Var) {
        }

        public void c(@g.n0 g1 g1Var) {
        }

        @g.n0
        public abstract j1 d(@g.n0 j1 j1Var, @g.n0 List<g1> list);

        @g.n0
        public a e(@g.n0 g1 g1Var, @g.n0 a aVar) {
            return aVar;
        }
    }

    @g.v0(21)
    public static class c extends e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Interpolator f4890f = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Interpolator f4891g = new l1.a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Interpolator f4892h = new DecelerateInterpolator();

        @g.v0(21)
        public static class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f4893c = 160;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f4894a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public j1 f4895b;

            /* JADX INFO: renamed from: androidx.core.view.g1$c$a$a, reason: collision with other inner class name */
            public class C0044a implements ValueAnimator.AnimatorUpdateListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ g1 f4896a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ j1 f4897b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ j1 f4898c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ int f4899d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public final /* synthetic */ View f4900e;

                public C0044a(g1 g1Var, j1 j1Var, j1 j1Var2, int i10, View view) {
                    this.f4896a = g1Var;
                    this.f4897b = j1Var;
                    this.f4898c = j1Var2;
                    this.f4899d = i10;
                    this.f4900e = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f4896a.i(valueAnimator.getAnimatedFraction());
                    c.o(this.f4900e, c.s(this.f4897b, this.f4898c, this.f4896a.d(), this.f4899d), Collections.singletonList(this.f4896a));
                }
            }

            public class b extends AnimatorListenerAdapter {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ g1 f4902a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ View f4903b;

                public b(g1 g1Var, View view) {
                    this.f4902a = g1Var;
                    this.f4903b = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.f4902a.i(1.0f);
                    c.m(this.f4903b, this.f4902a);
                }
            }

            /* JADX INFO: renamed from: androidx.core.view.g1$c$a$c, reason: collision with other inner class name */
            public class RunnableC0045c implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ View f4905a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ g1 f4906b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ a f4907c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ ValueAnimator f4908d;

                public RunnableC0045c(View view, g1 g1Var, a aVar, ValueAnimator valueAnimator) {
                    this.f4905a = view;
                    this.f4906b = g1Var;
                    this.f4907c = aVar;
                    this.f4908d = valueAnimator;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.p(this.f4905a, this.f4906b, this.f4907c);
                    this.f4908d.start();
                }
            }

            public a(@g.n0 View view, @g.n0 b bVar) {
                this.f4894a = bVar;
                j1 j1VarO0 = u0.o0(view);
                this.f4895b = j1VarO0 != null ? new j1.b(j1VarO0).a() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                if (!view.isLaidOut()) {
                    this.f4895b = j1.L(windowInsets, view);
                    return c.q(view, windowInsets);
                }
                j1 j1VarL = j1.L(windowInsets, view);
                if (this.f4895b == null) {
                    this.f4895b = u0.o0(view);
                }
                if (this.f4895b == null) {
                    this.f4895b = j1VarL;
                    return c.q(view, windowInsets);
                }
                b bVarR = c.r(view);
                if (bVarR != null && Objects.equals(bVarR.f4888a, windowInsets)) {
                    return c.q(view, windowInsets);
                }
                int i10 = c.i(j1VarL, this.f4895b);
                if (i10 == 0) {
                    return c.q(view, windowInsets);
                }
                j1 j1Var = this.f4895b;
                g1 g1Var = new g1(i10, c.k(i10, j1VarL, j1Var), 160L);
                g1Var.i(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(g1Var.b());
                a aVarJ = c.j(j1VarL, j1Var, i10);
                c.n(view, g1Var, windowInsets, false);
                duration.addUpdateListener(new C0044a(g1Var, j1VarL, j1Var, i10, view));
                duration.addListener(new b(g1Var, view));
                n0.a(view, new RunnableC0045c(view, g1Var, aVarJ, duration));
                this.f4895b = j1VarL;
                return c.q(view, windowInsets);
            }
        }

        public c(int i10, @g.p0 Interpolator interpolator, long j10) {
            super(i10, interpolator, j10);
        }

        @SuppressLint({"WrongConstant"})
        public static int i(@g.n0 j1 j1Var, @g.n0 j1 j1Var2) {
            int i10 = 0;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if (!j1Var.f(i11).equals(j1Var2.f(i11))) {
                    i10 |= i11;
                }
            }
            return i10;
        }

        @g.n0
        public static a j(@g.n0 j1 j1Var, @g.n0 j1 j1Var2, int i10) {
            m0.i iVarF = j1Var.f(i10);
            m0.i iVarF2 = j1Var2.f(i10);
            return new a(m0.i.d(Math.min(iVarF.f40559a, iVarF2.f40559a), Math.min(iVarF.f40560b, iVarF2.f40560b), Math.min(iVarF.f40561c, iVarF2.f40561c), Math.min(iVarF.f40562d, iVarF2.f40562d)), m0.i.d(Math.max(iVarF.f40559a, iVarF2.f40559a), Math.max(iVarF.f40560b, iVarF2.f40560b), Math.max(iVarF.f40561c, iVarF2.f40561c), Math.max(iVarF.f40562d, iVarF2.f40562d)));
        }

        public static Interpolator k(int i10, j1 j1Var, j1 j1Var2) {
            return (i10 & 8) != 0 ? j1Var.f(j1.m.d()).f40562d > j1Var2.f(j1.m.d()).f40562d ? f4890f : f4891g : f4892h;
        }

        @g.n0
        public static View.OnApplyWindowInsetsListener l(@g.n0 View view, @g.n0 b bVar) {
            return new a(view, bVar);
        }

        public static void m(@g.n0 View view, @g.n0 g1 g1Var) {
            b bVarR = r(view);
            if (bVarR != null) {
                bVarR.b(g1Var);
                if (bVarR.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    m(viewGroup.getChildAt(i10), g1Var);
                }
            }
        }

        public static void n(View view, g1 g1Var, WindowInsets windowInsets, boolean z10) {
            b bVarR = r(view);
            if (bVarR != null) {
                bVarR.f4888a = windowInsets;
                if (!z10) {
                    bVarR.c(g1Var);
                    z10 = bVarR.a() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    n(viewGroup.getChildAt(i10), g1Var, windowInsets, z10);
                }
            }
        }

        public static void o(@g.n0 View view, @g.n0 j1 j1Var, @g.n0 List<g1> list) {
            b bVarR = r(view);
            if (bVarR != null) {
                j1Var = bVarR.d(j1Var, list);
                if (bVarR.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    o(viewGroup.getChildAt(i10), j1Var, list);
                }
            }
        }

        public static void p(View view, g1 g1Var, a aVar) {
            b bVarR = r(view);
            if (bVarR != null) {
                bVarR.e(g1Var, aVar);
                if (bVarR.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    p(viewGroup.getChildAt(i10), g1Var, aVar);
                }
            }
        }

        @g.n0
        public static WindowInsets q(@g.n0 View view, @g.n0 WindowInsets windowInsets) {
            return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        @g.p0
        public static b r(View view) {
            Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
            if (tag instanceof a) {
                return ((a) tag).f4894a;
            }
            return null;
        }

        @SuppressLint({"WrongConstant"})
        public static j1 s(j1 j1Var, j1 j1Var2, float f10, int i10) {
            j1.b bVar = new j1.b(j1Var);
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) == 0) {
                    bVar.c(i11, j1Var.f(i11));
                } else {
                    m0.i iVarF = j1Var.f(i11);
                    m0.i iVarF2 = j1Var2.f(i11);
                    float f11 = 1.0f - f10;
                    bVar.c(i11, j1.z(iVarF, (int) (((double) ((iVarF.f40559a - iVarF2.f40559a) * f11)) + 0.5d), (int) (((double) ((iVarF.f40560b - iVarF2.f40560b) * f11)) + 0.5d), (int) (((double) ((iVarF.f40561c - iVarF2.f40561c) * f11)) + 0.5d), (int) (((double) ((iVarF.f40562d - iVarF2.f40562d) * f11)) + 0.5d)));
                }
            }
            return bVar.a();
        }

        public static void t(@g.n0 View view, @g.p0 b bVar) {
            Object tag = view.getTag(R.id.tag_on_apply_window_listener);
            if (bVar == null) {
                view.setTag(R.id.tag_window_insets_animation_callback, null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListenerL = l(view, bVar);
            view.setTag(R.id.tag_window_insets_animation_callback, onApplyWindowInsetsListenerL);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListenerL);
            }
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f4916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @g.p0
        public final Interpolator f4917c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f4918d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f4919e;

        public e(int i10, @g.p0 Interpolator interpolator, long j10) {
            this.f4915a = i10;
            this.f4917c = interpolator;
            this.f4918d = j10;
        }

        public float a() {
            return this.f4919e;
        }

        public long b() {
            return this.f4918d;
        }

        public float c() {
            return this.f4916b;
        }

        public float d() {
            Interpolator interpolator = this.f4917c;
            return interpolator != null ? interpolator.getInterpolation(this.f4916b) : this.f4916b;
        }

        @g.p0
        public Interpolator e() {
            return this.f4917c;
        }

        public int f() {
            return this.f4915a;
        }

        public void g(float f10) {
            this.f4919e = f10;
        }

        public void h(float f10) {
            this.f4916b = f10;
        }
    }

    public g1(int i10, @g.p0 Interpolator interpolator, long j10) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f4883a = new d(i10, interpolator, j10);
        } else {
            this.f4883a = new c(i10, interpolator, j10);
        }
    }

    public static void h(@g.n0 View view, @g.p0 b bVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            d.l(view, bVar);
        } else {
            c.t(view, bVar);
        }
    }

    @g.v0(30)
    public static g1 j(WindowInsetsAnimation windowInsetsAnimation) {
        return new g1(windowInsetsAnimation);
    }

    @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float a() {
        return this.f4883a.a();
    }

    public long b() {
        return this.f4883a.b();
    }

    @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float c() {
        return this.f4883a.c();
    }

    public float d() {
        return this.f4883a.d();
    }

    @g.p0
    public Interpolator e() {
        return this.f4883a.e();
    }

    public int f() {
        return this.f4883a.f();
    }

    public void g(@g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        this.f4883a.g(f10);
    }

    public void i(@g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        this.f4883a.h(f10);
    }

    @g.v0(30)
    public static class d extends e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @g.n0
        public final WindowInsetsAnimation f4910f;

        @g.v0(30)
        public static class a extends WindowInsetsAnimation.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f4911a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List<g1> f4912b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public ArrayList<g1> f4913c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final HashMap<WindowInsetsAnimation, g1> f4914d;

            public a(@g.n0 b bVar) {
                super(bVar.a());
                this.f4914d = new HashMap<>();
                this.f4911a = bVar;
            }

            @g.n0
            public final g1 a(@g.n0 WindowInsetsAnimation windowInsetsAnimation) {
                g1 g1Var = this.f4914d.get(windowInsetsAnimation);
                if (g1Var != null) {
                    return g1Var;
                }
                g1 g1VarJ = g1.j(windowInsetsAnimation);
                this.f4914d.put(windowInsetsAnimation, g1VarJ);
                return g1VarJ;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(@g.n0 WindowInsetsAnimation windowInsetsAnimation) {
                this.f4911a.b(a(windowInsetsAnimation));
                this.f4914d.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(@g.n0 WindowInsetsAnimation windowInsetsAnimation) {
                this.f4911a.c(a(windowInsetsAnimation));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @g.n0
            public WindowInsets onProgress(@g.n0 WindowInsets windowInsets, @g.n0 List<WindowInsetsAnimation> list) {
                ArrayList<g1> arrayList = this.f4913c;
                if (arrayList == null) {
                    ArrayList<g1> arrayList2 = new ArrayList<>(list.size());
                    this.f4913c = arrayList2;
                    this.f4912b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimation = list.get(size);
                    g1 g1VarA = a(windowInsetsAnimation);
                    g1VarA.i(windowInsetsAnimation.getFraction());
                    this.f4913c.add(g1VarA);
                }
                return this.f4911a.d(j1.K(windowInsets), this.f4912b).J();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @g.n0
            public WindowInsetsAnimation.Bounds onStart(@g.n0 WindowInsetsAnimation windowInsetsAnimation, @g.n0 WindowInsetsAnimation.Bounds bounds) {
                return this.f4911a.e(a(windowInsetsAnimation), a.e(bounds)).d();
            }
        }

        public d(@g.n0 WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f4910f = windowInsetsAnimation;
        }

        @g.n0
        public static WindowInsetsAnimation.Bounds i(@g.n0 a aVar) {
            return new WindowInsetsAnimation.Bounds(aVar.a().h(), aVar.b().h());
        }

        @g.n0
        public static m0.i j(@g.n0 WindowInsetsAnimation.Bounds bounds) {
            return m0.i.g(bounds.getUpperBound());
        }

        @g.n0
        public static m0.i k(@g.n0 WindowInsetsAnimation.Bounds bounds) {
            return m0.i.g(bounds.getLowerBound());
        }

        public static void l(@g.n0 View view, @g.p0 b bVar) {
            view.setWindowInsetsAnimationCallback(bVar != null ? new a(bVar) : null);
        }

        @Override // androidx.core.view.g1.e
        public long b() {
            return this.f4910f.getDurationMillis();
        }

        @Override // androidx.core.view.g1.e
        public float c() {
            return this.f4910f.getFraction();
        }

        @Override // androidx.core.view.g1.e
        public float d() {
            return this.f4910f.getInterpolatedFraction();
        }

        @Override // androidx.core.view.g1.e
        @g.p0
        public Interpolator e() {
            return this.f4910f.getInterpolator();
        }

        @Override // androidx.core.view.g1.e
        public int f() {
            return this.f4910f.getTypeMask();
        }

        @Override // androidx.core.view.g1.e
        public void h(float f10) {
            this.f4910f.setFraction(f10);
        }

        public d(int i10, Interpolator interpolator, long j10) {
            this(new WindowInsetsAnimation(i10, interpolator, j10));
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m0.i f4884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m0.i f4885b;

        public a(@g.n0 m0.i iVar, @g.n0 m0.i iVar2) {
            this.f4884a = iVar;
            this.f4885b = iVar2;
        }

        @g.n0
        @g.v0(30)
        public static a e(@g.n0 WindowInsetsAnimation.Bounds bounds) {
            return new a(bounds);
        }

        @g.n0
        public m0.i a() {
            return this.f4884a;
        }

        @g.n0
        public m0.i b() {
            return this.f4885b;
        }

        @g.n0
        public a c(@g.n0 m0.i iVar) {
            return new a(j1.z(this.f4884a, iVar.f40559a, iVar.f40560b, iVar.f40561c, iVar.f40562d), j1.z(this.f4885b, iVar.f40559a, iVar.f40560b, iVar.f40561c, iVar.f40562d));
        }

        @g.n0
        @g.v0(30)
        public WindowInsetsAnimation.Bounds d() {
            return d.i(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f4884a + " upper=" + this.f4885b + zc.a.f58317e;
        }

        @g.v0(30)
        public a(@g.n0 WindowInsetsAnimation.Bounds bounds) {
            this.f4884a = d.k(bounds);
            this.f4885b = d.j(bounds);
        }
    }

    @g.v0(30)
    public g1(@g.n0 WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f4883a = new d(windowInsetsAnimation);
        }
    }
}

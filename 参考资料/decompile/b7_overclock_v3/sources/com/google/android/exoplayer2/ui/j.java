package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import g.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final long D = 2000;
    public static final long E = 250;
    public static final long F = 250;
    public static final int G = 0;
    public static final int H = 1;
    public static final int I = 2;
    public static final int J = 3;
    public static final int K = 4;
    public boolean A;
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.ui.i f18916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final View f18917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final ViewGroup f18918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final ViewGroup f18919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final ViewGroup f18920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final ViewGroup f18921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public final ViewGroup f18922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public final ViewGroup f18923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final ViewGroup f18924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public final View f18925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public final View f18926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AnimatorSet f18927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AnimatorSet f18928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AnimatorSet f18929n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AnimatorSet f18930o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AnimatorSet f18931p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ValueAnimator f18932q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ValueAnimator f18933r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Runnable f18934s = new Runnable() { // from class: cd.y
        @Override // java.lang.Runnable
        public final void run() {
            this.f10925a.d0();
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f18935t = new Runnable() { // from class: cd.g0
        @Override // java.lang.Runnable
        public final void run() {
            this.f10873a.D();
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f18936u = new Runnable() { // from class: cd.w
        @Override // java.lang.Runnable
        public final void run() {
            this.f10923a.H();
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Runnable f18937v = new Runnable() { // from class: cd.x
        @Override // java.lang.Runnable
        public final void run() {
            this.f10924a.G();
        }
    };

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f18938w = new Runnable() { // from class: cd.h0
        @Override // java.lang.Runnable
        public final void run() {
            this.f10875a.E();
        }
    };

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final View.OnLayoutChangeListener f18939x = new View.OnLayoutChangeListener() { // from class: cd.d0
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f10869a.S(view, i10, i11, i12, i13, i14, i15, i16, i17);
        }
    };
    public boolean C = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f18941z = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<View> f18940y = new ArrayList();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (j.this.f18917b != null) {
                j.this.f18917b.setVisibility(4);
            }
            if (j.this.f18918c != null) {
                j.this.f18918c.setVisibility(4);
            }
            if (j.this.f18920e != null) {
                j.this.f18920e.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!(j.this.f18925j instanceof com.google.android.exoplayer2.ui.b) || j.this.A) {
                return;
            }
            ((com.google.android.exoplayer2.ui.b) j.this.f18925j).i(250L);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (j.this.f18917b != null) {
                j.this.f18917b.setVisibility(0);
            }
            if (j.this.f18918c != null) {
                j.this.f18918c.setVisibility(0);
            }
            if (j.this.f18920e != null) {
                j.this.f18920e.setVisibility(j.this.A ? 0 : 4);
            }
            if (!(j.this.f18925j instanceof com.google.android.exoplayer2.ui.b) || j.this.A) {
                return;
            }
            ((com.google.android.exoplayer2.ui.b) j.this.f18925j).v(250L);
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.android.exoplayer2.ui.i f18944a;

        public c(com.google.android.exoplayer2.ui.i iVar) {
            this.f18944a = iVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j.this.a0(1);
            if (j.this.B) {
                this.f18944a.post(j.this.f18934s);
                j.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            j.this.a0(3);
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.android.exoplayer2.ui.i f18946a;

        public d(com.google.android.exoplayer2.ui.i iVar) {
            this.f18946a = iVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j.this.a0(2);
            if (j.this.B) {
                this.f18946a.post(j.this.f18934s);
                j.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            j.this.a0(3);
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.android.exoplayer2.ui.i f18948a;

        public e(com.google.android.exoplayer2.ui.i iVar) {
            this.f18948a = iVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j.this.a0(2);
            if (j.this.B) {
                this.f18948a.post(j.this.f18934s);
                j.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            j.this.a0(3);
        }
    }

    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            j.this.a0(4);
        }
    }

    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            j.this.a0(4);
        }
    }

    public class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (j.this.f18921f != null) {
                j.this.f18921f.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (j.this.f18923h != null) {
                j.this.f18923h.setVisibility(0);
                j.this.f18923h.setTranslationX(j.this.f18923h.getWidth());
                j.this.f18923h.scrollTo(j.this.f18923h.getWidth(), 0);
            }
        }
    }

    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (j.this.f18923h != null) {
                j.this.f18923h.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (j.this.f18921f != null) {
                j.this.f18921f.setVisibility(0);
            }
        }
    }

    public j(com.google.android.exoplayer2.ui.i iVar) {
        this.f18916a = iVar;
        this.f18917b = iVar.findViewById(R.id.exo_controls_background);
        this.f18918c = (ViewGroup) iVar.findViewById(R.id.exo_center_controls);
        this.f18920e = (ViewGroup) iVar.findViewById(R.id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) iVar.findViewById(R.id.exo_bottom_bar);
        this.f18919d = viewGroup;
        this.f18924i = (ViewGroup) iVar.findViewById(R.id.exo_time);
        View viewFindViewById = iVar.findViewById(R.id.exo_progress);
        this.f18925j = viewFindViewById;
        this.f18921f = (ViewGroup) iVar.findViewById(R.id.exo_basic_controls);
        this.f18922g = (ViewGroup) iVar.findViewById(R.id.exo_extra_controls);
        this.f18923h = (ViewGroup) iVar.findViewById(R.id.exo_extra_controls_scroll_view);
        View viewFindViewById2 = iVar.findViewById(R.id.exo_overflow_show);
        this.f18926k = viewFindViewById2;
        View viewFindViewById3 = iVar.findViewById(R.id.exo_overflow_hide);
        if (viewFindViewById2 != null && viewFindViewById3 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: cd.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f10867a.U(view);
                }
            });
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: cd.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f10867a.U(view);
                }
            });
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cd.z
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f10926a.K(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a());
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cd.v
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f10922a.L(valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addListener(new b());
        Resources resources = iVar.getResources();
        int i10 = R.dimen.exo_styled_bottom_bar_height;
        float dimension = resources.getDimension(i10) - resources.getDimension(R.dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(i10);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f18927l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new c(iVar));
        animatorSet.play(valueAnimatorOfFloat).with(O(0.0f, dimension, viewFindViewById)).with(O(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f18928m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d(iVar));
        animatorSet2.play(O(dimension, dimension2, viewFindViewById)).with(O(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f18929n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new e(iVar));
        animatorSet3.play(valueAnimatorOfFloat).with(O(0.0f, dimension2, viewFindViewById)).with(O(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f18930o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new f());
        animatorSet4.play(valueAnimatorOfFloat2).with(O(dimension, 0.0f, viewFindViewById)).with(O(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f18931p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new g());
        animatorSet5.play(valueAnimatorOfFloat2).with(O(dimension2, 0.0f, viewFindViewById)).with(O(dimension2, 0.0f, viewGroup));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f18932q = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cd.a0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f10860a.M(valueAnimator);
            }
        });
        valueAnimatorOfFloat3.addListener(new h());
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f18933r = valueAnimatorOfFloat4;
        valueAnimatorOfFloat4.setDuration(250L);
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cd.b0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f10865a.N(valueAnimator);
            }
        });
        valueAnimatorOfFloat4.addListener(new i());
    }

    public static int B(@p0 View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f18917b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.f18918c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.f18920e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f18917b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.f18918c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.f18920e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static ObjectAnimator O(float f10, float f11, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", f10, f11);
    }

    public static int z(@p0 View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public boolean A(@p0 View view) {
        return view != null && this.f18940y.contains(view);
    }

    public void C() {
        int i10 = this.f18941z;
        if (i10 == 3 || i10 == 2) {
            return;
        }
        W();
        if (!this.C) {
            E();
        } else if (this.f18941z == 1) {
            H();
        } else {
            D();
        }
    }

    public final void D() {
        this.f18929n.start();
    }

    public final void E() {
        a0(2);
    }

    public void F() {
        int i10 = this.f18941z;
        if (i10 == 3 || i10 == 2) {
            return;
        }
        W();
        E();
    }

    public final void G() {
        this.f18927l.start();
        V(this.f18936u, 2000L);
    }

    public final void H() {
        this.f18928m.start();
    }

    public boolean I() {
        return this.C;
    }

    public boolean J() {
        return this.f18941z == 0 && this.f18916a.k0();
    }

    public void P() {
        this.f18916a.addOnLayoutChangeListener(this.f18939x);
    }

    public void Q() {
        this.f18916a.removeOnLayoutChangeListener(this.f18939x);
    }

    public void R(boolean z10, int i10, int i11, int i12, int i13) {
        View view = this.f18917b;
        if (view != null) {
            view.layout(0, 0, i12 - i10, i13 - i11);
        }
    }

    public final void S(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        boolean zF0 = f0();
        if (this.A != zF0) {
            this.A = zF0;
            view.post(new Runnable() { // from class: cd.e0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10870a.e0();
                }
            });
        }
        boolean z10 = i12 - i10 != i16 - i14;
        if (this.A || !z10) {
            return;
        }
        view.post(new Runnable() { // from class: cd.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10871a.T();
            }
        });
    }

    public final void T() {
        int i10;
        if (this.f18921f == null || this.f18922g == null) {
            return;
        }
        int width = (this.f18916a.getWidth() - this.f18916a.getPaddingLeft()) - this.f18916a.getPaddingRight();
        while (true) {
            if (this.f18922g.getChildCount() <= 1) {
                break;
            }
            int childCount = this.f18922g.getChildCount() - 2;
            View childAt = this.f18922g.getChildAt(childCount);
            this.f18922g.removeViewAt(childCount);
            this.f18921f.addView(childAt, 0);
        }
        View view = this.f18926k;
        if (view != null) {
            view.setVisibility(8);
        }
        int iB = B(this.f18924i);
        int childCount2 = this.f18921f.getChildCount() - 1;
        for (int i11 = 0; i11 < childCount2; i11++) {
            iB += B(this.f18921f.getChildAt(i11));
        }
        if (iB <= width) {
            ViewGroup viewGroup = this.f18923h;
            if (viewGroup == null || viewGroup.getVisibility() != 0 || this.f18933r.isStarted()) {
                return;
            }
            this.f18932q.cancel();
            this.f18933r.start();
            return;
        }
        View view2 = this.f18926k;
        if (view2 != null) {
            view2.setVisibility(0);
            iB += B(this.f18926k);
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = this.f18921f.getChildAt(i12);
            iB -= B(childAt2);
            arrayList.add(childAt2);
            if (iB <= width) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f18921f.removeViews(0, arrayList.size());
        for (i10 = 0; i10 < arrayList.size(); i10++) {
            this.f18922g.addView((View) arrayList.get(i10), this.f18922g.getChildCount() - 1);
        }
    }

    public final void U(View view) {
        X();
        if (view.getId() == R.id.exo_overflow_show) {
            this.f18932q.start();
        } else if (view.getId() == R.id.exo_overflow_hide) {
            this.f18933r.start();
        }
    }

    public final void V(Runnable runnable, long j10) {
        if (j10 >= 0) {
            this.f18916a.postDelayed(runnable, j10);
        }
    }

    public void W() {
        this.f18916a.removeCallbacks(this.f18938w);
        this.f18916a.removeCallbacks(this.f18935t);
        this.f18916a.removeCallbacks(this.f18937v);
        this.f18916a.removeCallbacks(this.f18936u);
    }

    public void X() {
        if (this.f18941z == 3) {
            return;
        }
        W();
        int showTimeoutMs = this.f18916a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                V(this.f18938w, showTimeoutMs);
            } else if (this.f18941z == 1) {
                V(this.f18936u, 2000L);
            } else {
                V(this.f18937v, showTimeoutMs);
            }
        }
    }

    public void Y(boolean z10) {
        this.C = z10;
    }

    public void Z(@p0 View view, boolean z10) {
        if (view == null) {
            return;
        }
        if (!z10) {
            view.setVisibility(8);
            this.f18940y.remove(view);
            return;
        }
        if (this.A && b0(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.f18940y.add(view);
    }

    public final void a0(int i10) {
        int i11 = this.f18941z;
        this.f18941z = i10;
        if (i10 == 2) {
            this.f18916a.setVisibility(8);
        } else if (i11 == 2) {
            this.f18916a.setVisibility(0);
        }
        if (i11 != i10) {
            this.f18916a.m0();
        }
    }

    public final boolean b0(View view) {
        int id2 = view.getId();
        return id2 == R.id.exo_bottom_bar || id2 == R.id.exo_prev || id2 == R.id.exo_next || id2 == R.id.exo_rew || id2 == R.id.exo_rew_with_amount || id2 == R.id.exo_ffwd || id2 == R.id.exo_ffwd_with_amount;
    }

    public void c0() {
        if (!this.f18916a.k0()) {
            this.f18916a.setVisibility(0);
            this.f18916a.x0();
            this.f18916a.r0();
        }
        d0();
    }

    public final void d0() {
        if (!this.C) {
            a0(0);
            X();
            return;
        }
        int i10 = this.f18941z;
        if (i10 == 1) {
            this.f18930o.start();
        } else if (i10 == 2) {
            this.f18931p.start();
        } else if (i10 == 3) {
            this.B = true;
        } else if (i10 == 4) {
            return;
        }
        X();
    }

    public final void e0() {
        ViewGroup viewGroup = this.f18920e;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.A ? 0 : 4);
        }
        View view = this.f18925j;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.f18916a.getResources().getDimensionPixelSize(R.dimen.exo_styled_progress_margin_bottom);
            if (this.A) {
                dimensionPixelSize = 0;
            }
            marginLayoutParams.bottomMargin = dimensionPixelSize;
            this.f18925j.setLayoutParams(marginLayoutParams);
            View view2 = this.f18925j;
            if (view2 instanceof com.google.android.exoplayer2.ui.b) {
                com.google.android.exoplayer2.ui.b bVar = (com.google.android.exoplayer2.ui.b) view2;
                if (this.A) {
                    bVar.j(true);
                } else {
                    int i10 = this.f18941z;
                    if (i10 == 1) {
                        bVar.j(false);
                    } else if (i10 != 3) {
                        bVar.u();
                    }
                }
            }
        }
        for (View view3 : this.f18940y) {
            view3.setVisibility((this.A && b0(view3)) ? 4 : 0);
        }
    }

    public final boolean f0() {
        int width = (this.f18916a.getWidth() - this.f18916a.getPaddingLeft()) - this.f18916a.getPaddingRight();
        int height = (this.f18916a.getHeight() - this.f18916a.getPaddingBottom()) - this.f18916a.getPaddingTop();
        int iB = B(this.f18918c);
        ViewGroup viewGroup = this.f18918c;
        int paddingLeft = iB - (viewGroup != null ? viewGroup.getPaddingLeft() + this.f18918c.getPaddingRight() : 0);
        int iZ = z(this.f18918c);
        ViewGroup viewGroup2 = this.f18918c;
        return width <= Math.max(paddingLeft, B(this.f18924i) + B(this.f18926k)) || height <= (iZ - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.f18918c.getPaddingBottom() : 0)) + (z(this.f18919d) * 2);
    }

    public final void y(float f10) {
        if (this.f18923h != null) {
            this.f18923h.setTranslationX((int) (r0.getWidth() * (1.0f - f10)));
        }
        ViewGroup viewGroup = this.f18924i;
        if (viewGroup != null) {
            viewGroup.setAlpha(1.0f - f10);
        }
        ViewGroup viewGroup2 = this.f18921f;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f10);
        }
    }
}

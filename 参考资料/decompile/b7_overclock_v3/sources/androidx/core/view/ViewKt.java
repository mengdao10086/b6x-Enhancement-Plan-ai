package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Objects;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.jvm.internal.t0({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,432:1\n40#1:433\n56#1:434\n329#1,4:438\n43#2,3:435\n*S KotlinDebug\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n*L\n71#1:433\n71#1:434\n315#1:438,4\n238#1:435,3\n*E\n"})
public final class ViewKt {

    @kotlin.jvm.internal.t0({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnAttach$1\n*L\n1#1,432:1\n*E\n"})
    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f4785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.l<View, z1> f4786b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(View view, ik.l<? super View, z1> lVar) {
            this.f4785a = view;
            this.f4786b = lVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@yt.k View view) {
            kotlin.jvm.internal.f0.p(view, "view");
            this.f4785a.removeOnAttachStateChangeListener(this);
            this.f4786b.i(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@yt.k View view) {
            kotlin.jvm.internal.f0.p(view, "view");
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnDetach$1\n*L\n1#1,432:1\n*E\n"})
    public static final class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f4788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.l<View, z1> f4789b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(View view, ik.l<? super View, z1> lVar) {
            this.f4788a = view;
            this.f4789b = lVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@yt.k View view) {
            kotlin.jvm.internal.f0.p(view, "view");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@yt.k View view) {
            kotlin.jvm.internal.f0.p(view, "view");
            this.f4788a.removeOnAttachStateChangeListener(this);
            this.f4789b.i(view);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnNextLayout$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,432:1\n72#2,2:433\n*E\n"})
    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f4790a;

        public c(ik.l lVar) {
            this.f4790a = lVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@yt.k View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            kotlin.jvm.internal.f0.p(view, "view");
            view.removeOnLayoutChangeListener(this);
            this.f4790a.i(view);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnNextLayout$1\n*L\n1#1,432:1\n*E\n"})
    public static final class d implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l<View, z1> f4791a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(ik.l<? super View, z1> lVar) {
            this.f4791a = lVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@yt.k View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            kotlin.jvm.internal.f0.p(view, "view");
            view.removeOnLayoutChangeListener(this);
            this.f4791a.i(view);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnPreDraw$1\n*L\n1#1,432:1\n*E\n"})
    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l<View, z1> f4792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f4793b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(ik.l<? super View, z1> lVar, View view) {
            this.f4792a = lVar;
            this.f4793b = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f4792a.i(this.f4793b);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$postDelayed$runnable$1\n*L\n1#1,432:1\n*E\n"})
    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.a<z1> f4794a;

        public f(ik.a<z1> aVar) {
            this.f4794a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f4794a.o();
        }
    }

    public static final void A(@yt.k View view, @yt.k ik.l<? super ViewGroup.LayoutParams, z1> block) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        block.i(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    @hk.h(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void B(View view, ik.l<? super T, z1> block) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        kotlin.jvm.internal.f0.y(1, i1.a.f31577d5);
        block.i(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void C(@yt.k View view, @g.t0 int i10, @g.t0 int i11, @g.t0 int i12, @g.t0 int i13) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        view.setPadding(i10, i11, i12, i13);
    }

    public static /* synthetic */ void D(View view, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = view.getPaddingLeft();
        }
        if ((i14 & 2) != 0) {
            i11 = view.getPaddingTop();
        }
        if ((i14 & 4) != 0) {
            i12 = view.getPaddingRight();
        }
        if ((i14 & 8) != 0) {
            i13 = view.getPaddingBottom();
        }
        kotlin.jvm.internal.f0.p(view, "<this>");
        view.setPadding(i10, i11, i12, i13);
    }

    @SuppressLint({"ClassVerificationFailure"})
    @g.v0(17)
    public static final void E(@yt.k View view, @g.t0 int i10, @g.t0 int i11, @g.t0 int i12, @g.t0 int i13) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        view.setPaddingRelative(i10, i11, i12, i13);
    }

    public static /* synthetic */ void F(View view, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = view.getPaddingStart();
        }
        if ((i14 & 2) != 0) {
            i11 = view.getPaddingTop();
        }
        if ((i14 & 4) != 0) {
            i12 = view.getPaddingEnd();
        }
        if ((i14 & 8) != 0) {
            i13 = view.getPaddingBottom();
        }
        kotlin.jvm.internal.f0.p(view, "<this>");
        view.setPaddingRelative(i10, i11, i12, i13);
    }

    public static final void b(@yt.k View view, @yt.k ik.l<? super View, z1> action) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        if (u0.O0(view)) {
            action.i(view);
        } else {
            view.addOnAttachStateChangeListener(new a(view, action));
        }
    }

    public static final void c(@yt.k View view, @yt.k ik.l<? super View, z1> action) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        if (u0.O0(view)) {
            view.addOnAttachStateChangeListener(new b(view, action));
        } else {
            action.i(view);
        }
    }

    public static final void d(@yt.k View view, @yt.k ik.l<? super View, z1> action) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        if (!u0.U0(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new c(action));
        } else {
            action.i(view);
        }
    }

    public static final void e(@yt.k View view, @yt.k ik.l<? super View, z1> action) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        view.addOnLayoutChangeListener(new d(action));
    }

    @yt.k
    public static final n0 f(@yt.k View view, @yt.k ik.l<? super View, z1> action) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        n0 n0VarA = n0.a(view, new e(action, view));
        kotlin.jvm.internal.f0.o(n0VarA, "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        return n0VarA;
    }

    @yt.k
    public static final Bitmap g(@yt.k View view, @yt.k Bitmap.Config config) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        kotlin.jvm.internal.f0.p(config, "config");
        if (!u0.U0(view)) {
            throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
        kotlin.jvm.internal.f0.o(bitmapCreateBitmap, "createBitmap(width, height, config)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap h(View view, Bitmap.Config config, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return g(view, config);
    }

    @yt.k
    public static final kotlin.sequences.m<View> i(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        return kotlin.sequences.q.b(new ViewKt$allViews$1(view, null));
    }

    @yt.k
    public static final kotlin.sequences.m<ViewParent> j(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        return SequencesKt__SequencesKt.n(view.getParent(), ViewKt$ancestors$1.f4787c);
    }

    public static final int k(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int l(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return r.b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int m(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int n(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int o(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return r.c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int p(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean q(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        return view.getVisibility() == 8;
    }

    public static final boolean r(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        return view.getVisibility() == 4;
    }

    public static final boolean s(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        return view.getVisibility() == 0;
    }

    @yt.k
    public static final Runnable t(@yt.k View view, long j10, @yt.k ik.a<z1> action) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        f fVar = new f(action);
        view.postDelayed(fVar, j10);
        return fVar;
    }

    @yt.k
    @g.v0(16)
    public static final Runnable u(@yt.k View view, long j10, @yt.k final ik.a<z1> action) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.y0
            @Override // java.lang.Runnable
            public final void run() {
                ViewKt.v(action);
            }
        };
        androidx.core.view.c.a(view, runnable, j10);
        return runnable;
    }

    public static final void v(ik.a action) {
        kotlin.jvm.internal.f0.p(action, "$action");
        action.o();
    }

    public static final void w(@yt.k View view, boolean z10) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        view.setVisibility(z10 ? 8 : 0);
    }

    public static final void x(@yt.k View view, boolean z10) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        view.setVisibility(z10 ? 4 : 0);
    }

    public static final void y(@yt.k View view, @g.t0 int i10) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        view.setPadding(i10, i10, i10, i10);
    }

    public static final void z(@yt.k View view, boolean z10) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        view.setVisibility(z10 ? 0 : 8);
    }
}

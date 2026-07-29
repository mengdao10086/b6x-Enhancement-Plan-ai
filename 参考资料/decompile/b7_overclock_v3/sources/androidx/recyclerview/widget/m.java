package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.core.view.u0;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.RecyclerView;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m extends RecyclerView.n implements RecyclerView.q {
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 4;
    public static final int H = 8;
    public static final int I = 16;
    public static final int J = 32;
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 2;
    public static final int O = 4;
    public static final int P = 8;
    public static final String Q = "ItemTouchHelper";
    public static final boolean R = false;
    public static final int S = -1;
    public static final int T = 8;
    public static final int U = 255;
    public static final int V = 65280;
    public static final int W = 16711680;
    public static final int X = 1000;
    public g A;
    public Rect C;
    public long D;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f7111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f7112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f7113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f7114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f7115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f7116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f7117j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f7118k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public f f7120m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7122o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7124q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RecyclerView f7125r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public VelocityTracker f7127t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List<RecyclerView.e0> f7128u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List<Integer> f7129v;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public androidx.core.view.l f7133z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<View> f7108a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f7109b = new float[2];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView.e0 f7110c = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7119l = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7121n = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<h> f7123p = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Runnable f7126s = new a();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RecyclerView.j f7130w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f7131x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f7132y = -1;
    public final RecyclerView.s B = new b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar = m.this;
            if (mVar.f7110c == null || !mVar.B()) {
                return;
            }
            m mVar2 = m.this;
            RecyclerView.e0 e0Var = mVar2.f7110c;
            if (e0Var != null) {
                mVar2.w(e0Var);
            }
            m mVar3 = m.this;
            mVar3.f7125r.removeCallbacks(mVar3.f7126s);
            u0.p1(m.this.f7125r, this);
        }
    }

    public class b implements RecyclerView.s {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean onInterceptTouchEvent(@n0 RecyclerView recyclerView, @n0 MotionEvent motionEvent) {
            int iFindPointerIndex;
            h hVarP;
            m.this.f7133z.b(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                m.this.f7119l = motionEvent.getPointerId(0);
                m.this.f7111d = motionEvent.getX();
                m.this.f7112e = motionEvent.getY();
                m.this.x();
                m mVar = m.this;
                if (mVar.f7110c == null && (hVarP = mVar.p(motionEvent)) != null) {
                    m mVar2 = m.this;
                    mVar2.f7111d -= hVarP.f7154j;
                    mVar2.f7112e -= hVarP.f7155k;
                    mVar2.o(hVarP.f7149e, true);
                    if (m.this.f7108a.remove(hVarP.f7149e.itemView)) {
                        m mVar3 = m.this;
                        mVar3.f7120m.clearView(mVar3.f7125r, hVarP.f7149e);
                    }
                    m.this.C(hVarP.f7149e, hVarP.f7150f);
                    m mVar4 = m.this;
                    mVar4.J(motionEvent, mVar4.f7122o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                m mVar5 = m.this;
                mVar5.f7119l = -1;
                mVar5.C(null, 0);
            } else {
                int i10 = m.this.f7119l;
                if (i10 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i10)) >= 0) {
                    m.this.l(actionMasked, motionEvent, iFindPointerIndex);
                }
            }
            VelocityTracker velocityTracker = m.this.f7127t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return m.this.f7110c != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onRequestDisallowInterceptTouchEvent(boolean z10) {
            if (z10) {
                m.this.C(null, 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onTouchEvent(@n0 RecyclerView recyclerView, @n0 MotionEvent motionEvent) {
            m.this.f7133z.b(motionEvent);
            VelocityTracker velocityTracker = m.this.f7127t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (m.this.f7119l == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int iFindPointerIndex = motionEvent.findPointerIndex(m.this.f7119l);
            if (iFindPointerIndex >= 0) {
                m.this.l(actionMasked, motionEvent, iFindPointerIndex);
            }
            m mVar = m.this;
            RecyclerView.e0 e0Var = mVar.f7110c;
            if (e0Var == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (iFindPointerIndex >= 0) {
                        mVar.J(motionEvent, mVar.f7122o, iFindPointerIndex);
                        m.this.w(e0Var);
                        m mVar2 = m.this;
                        mVar2.f7125r.removeCallbacks(mVar2.f7126s);
                        m.this.f7126s.run();
                        m.this.f7125r.invalidate();
                        return;
                    }
                    return;
                }
                if (actionMasked != 3) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    m mVar3 = m.this;
                    if (pointerId == mVar3.f7119l) {
                        mVar3.f7119l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                        m mVar4 = m.this;
                        mVar4.J(motionEvent, mVar4.f7122o, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = mVar.f7127t;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            m.this.C(null, 0);
            m.this.f7119l = -1;
        }
    }

    public class c extends h {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ int f7136o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.e0 f7137p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(RecyclerView.e0 e0Var, int i10, int i11, float f10, float f11, float f12, float f13, int i12, RecyclerView.e0 e0Var2) {
            super(e0Var, i10, i11, f10, f11, f12, f13);
            this.f7136o = i12;
            this.f7137p = e0Var2;
        }

        @Override // androidx.recyclerview.widget.m.h, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f7156l) {
                return;
            }
            if (this.f7136o <= 0) {
                m mVar = m.this;
                mVar.f7120m.clearView(mVar.f7125r, this.f7137p);
            } else {
                m.this.f7108a.add(this.f7137p.itemView);
                this.f7153i = true;
                int i10 = this.f7136o;
                if (i10 > 0) {
                    m.this.y(this, i10);
                }
            }
            m mVar2 = m.this;
            View view = mVar2.f7131x;
            View view2 = this.f7137p.itemView;
            if (view == view2) {
                mVar2.A(view2);
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f7139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7140b;

        public d(h hVar, int i10) {
            this.f7139a = hVar;
            this.f7140b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = m.this.f7125r;
            if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                return;
            }
            h hVar = this.f7139a;
            if (hVar.f7156l || hVar.f7149e.getAdapterPosition() == -1) {
                return;
            }
            RecyclerView.l itemAnimator = m.this.f7125r.getItemAnimator();
            if ((itemAnimator == null || !itemAnimator.r(null)) && !m.this.u()) {
                m.this.f7120m.onSwiped(this.f7139a.f7149e, this.f7140b);
            } else {
                m.this.f7125r.post(this);
            }
        }
    }

    public class e implements RecyclerView.j {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public int a(int i10, int i11) {
            m mVar = m.this;
            View view = mVar.f7131x;
            if (view == null) {
                return i11;
            }
            int iIndexOfChild = mVar.f7132y;
            if (iIndexOfChild == -1) {
                iIndexOfChild = mVar.f7125r.indexOfChild(view);
                m.this.f7132y = iIndexOfChild;
            }
            return i11 == i10 + (-1) ? iIndexOfChild : i11 < iIndexOfChild ? i11 : i11 + 1;
        }
    }

    public static abstract class f {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        public static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new a();
        private static final Interpolator sDragViewScrollCapInterpolator = new b();
        private int mCachedMaxScrollSpeed = -1;

        public static class a implements Interpolator {
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                return f10 * f10 * f10 * f10 * f10;
            }
        }

        public static class b implements Interpolator {
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = f10 - 1.0f;
                return (f11 * f11 * f11 * f11 * f11) + 1.0f;
            }
        }

        public static int convertToRelativeDirection(int i10, int i11) {
            int i12;
            int i13 = i10 & ABS_HORIZONTAL_DIR_FLAGS;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (~i13);
            if (i11 == 0) {
                i12 = i13 << 2;
            } else {
                int i15 = i13 << 1;
                i14 |= (-789517) & i15;
                i12 = (i15 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return i14 | i12;
        }

        @n0
        public static n getDefaultUIUtil() {
            return o.f7162a;
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeFlag(int i10, int i11) {
            return i11 << (i10 * 8);
        }

        public static int makeMovementFlags(int i10, int i11) {
            return makeFlag(2, i10) | makeFlag(1, i11) | makeFlag(0, i11 | i10);
        }

        public boolean canDropOver(@n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var, @n0 RecyclerView.e0 e0Var2) {
            return true;
        }

        public RecyclerView.e0 chooseDropTarget(@n0 RecyclerView.e0 e0Var, @n0 List<RecyclerView.e0> list, int i10, int i11) {
            int bottom;
            int iAbs;
            int top2;
            int iAbs2;
            int left;
            int iAbs3;
            int right;
            int iAbs4;
            int width = i10 + e0Var.itemView.getWidth();
            int height = i11 + e0Var.itemView.getHeight();
            int left2 = i10 - e0Var.itemView.getLeft();
            int top3 = i11 - e0Var.itemView.getTop();
            int size = list.size();
            RecyclerView.e0 e0Var2 = null;
            int i12 = -1;
            for (int i13 = 0; i13 < size; i13++) {
                RecyclerView.e0 e0Var3 = list.get(i13);
                if (left2 > 0 && (right = e0Var3.itemView.getRight() - width) < 0 && e0Var3.itemView.getRight() > e0Var.itemView.getRight() && (iAbs4 = Math.abs(right)) > i12) {
                    e0Var2 = e0Var3;
                    i12 = iAbs4;
                }
                if (left2 < 0 && (left = e0Var3.itemView.getLeft() - i10) > 0 && e0Var3.itemView.getLeft() < e0Var.itemView.getLeft() && (iAbs3 = Math.abs(left)) > i12) {
                    e0Var2 = e0Var3;
                    i12 = iAbs3;
                }
                if (top3 < 0 && (top2 = e0Var3.itemView.getTop() - i11) > 0 && e0Var3.itemView.getTop() < e0Var.itemView.getTop() && (iAbs2 = Math.abs(top2)) > i12) {
                    e0Var2 = e0Var3;
                    i12 = iAbs2;
                }
                if (top3 > 0 && (bottom = e0Var3.itemView.getBottom() - height) < 0 && e0Var3.itemView.getBottom() > e0Var.itemView.getBottom() && (iAbs = Math.abs(bottom)) > i12) {
                    e0Var2 = e0Var3;
                    i12 = iAbs;
                }
            }
            return e0Var2;
        }

        public void clearView(@n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var) {
            o.f7162a.a(e0Var.itemView);
        }

        public int convertToAbsoluteDirection(int i10, int i11) {
            int i12;
            int i13 = i10 & RELATIVE_DIR_FLAGS;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (~i13);
            if (i11 == 0) {
                i12 = i13 >> 2;
            } else {
                int i15 = i13 >> 1;
                i14 |= (-3158065) & i15;
                i12 = (i15 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return i14 | i12;
        }

        public final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.e0 e0Var) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, e0Var), u0.Z(recyclerView));
        }

        public long getAnimationDuration(@n0 RecyclerView recyclerView, int i10, float f10, float f11) {
            RecyclerView.l itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i10 == 8 ? 200L : 250L : i10 == 8 ? itemAnimator.o() : itemAnimator.p();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(@n0 RecyclerView.e0 e0Var) {
            return 0.5f;
        }

        public abstract int getMovementFlags(@n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var);

        public float getSwipeEscapeVelocity(float f10) {
            return f10;
        }

        public float getSwipeThreshold(@n0 RecyclerView.e0 e0Var) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f10) {
            return f10;
        }

        public boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.e0 e0Var) {
            return (getAbsoluteMovementFlags(recyclerView, e0Var) & 16711680) != 0;
        }

        public boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.e0 e0Var) {
            return (getAbsoluteMovementFlags(recyclerView, e0Var) & 65280) != 0;
        }

        public int interpolateOutOfBoundsScroll(@n0 RecyclerView recyclerView, int i10, int i11, int i12, long j10) {
            int iSignum = (int) (((int) (((int) Math.signum(i11)) * getMaxDragScroll(recyclerView) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i11) * 1.0f) / i10)))) * sDragScrollInterpolator.getInterpolation(j10 <= 2000 ? j10 / 2000.0f : 1.0f));
            return iSignum == 0 ? i11 > 0 ? 1 : -1 : iSignum;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(@n0 Canvas canvas, @n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var, float f10, float f11, int i10, boolean z10) {
            o.f7162a.d(canvas, recyclerView, e0Var.itemView, f10, f11, i10, z10);
        }

        public void onChildDrawOver(@n0 Canvas canvas, @n0 RecyclerView recyclerView, RecyclerView.e0 e0Var, float f10, float f11, int i10, boolean z10) {
            o.f7162a.c(canvas, recyclerView, e0Var.itemView, f10, f11, i10, z10);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.e0 e0Var, List<h> list, int i10, float f10, float f11) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                h hVar = list.get(i11);
                hVar.e();
                int iSave = canvas.save();
                onChildDraw(canvas, recyclerView, hVar.f7149e, hVar.f7154j, hVar.f7155k, hVar.f7150f, false);
                canvas.restoreToCount(iSave);
            }
            if (e0Var != null) {
                int iSave2 = canvas.save();
                onChildDraw(canvas, recyclerView, e0Var, f10, f11, i10, true);
                canvas.restoreToCount(iSave2);
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.e0 e0Var, List<h> list, int i10, float f10, float f11) {
            int size = list.size();
            boolean z10 = false;
            for (int i11 = 0; i11 < size; i11++) {
                h hVar = list.get(i11);
                int iSave = canvas.save();
                onChildDrawOver(canvas, recyclerView, hVar.f7149e, hVar.f7154j, hVar.f7155k, hVar.f7150f, false);
                canvas.restoreToCount(iSave);
            }
            if (e0Var != null) {
                int iSave2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, e0Var, f10, f11, i10, true);
                canvas.restoreToCount(iSave2);
            }
            for (int i12 = size - 1; i12 >= 0; i12--) {
                h hVar2 = list.get(i12);
                boolean z11 = hVar2.f7157m;
                if (z11 && !hVar2.f7153i) {
                    list.remove(i12);
                } else if (!z11) {
                    z10 = true;
                }
            }
            if (z10) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean onMove(@n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var, @n0 RecyclerView.e0 e0Var2);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(@n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var, int i10, @n0 RecyclerView.e0 e0Var2, int i11, int i12, int i13) {
            RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof j) {
                ((j) layoutManager).g(e0Var.itemView, e0Var2.itemView, i12, i13);
                return;
            }
            if (layoutManager.v()) {
                if (layoutManager.g0(e0Var2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.D1(i11);
                }
                if (layoutManager.j0(e0Var2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.D1(i11);
                }
            }
            if (layoutManager.w()) {
                if (layoutManager.k0(e0Var2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.D1(i11);
                }
                if (layoutManager.e0(e0Var2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.D1(i11);
                }
            }
        }

        public void onSelectedChanged(@p0 RecyclerView.e0 e0Var, int i10) {
            if (e0Var != null) {
                o.f7162a.b(e0Var.itemView);
            }
        }

        public abstract void onSwiped(@n0 RecyclerView.e0 e0Var, int i10);
    }

    public class g extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7143a = true;

        public g() {
        }

        public void a() {
            this.f7143a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View viewQ;
            RecyclerView.e0 e0VarT0;
            if (!this.f7143a || (viewQ = m.this.q(motionEvent)) == null || (e0VarT0 = m.this.f7125r.t0(viewQ)) == null) {
                return;
            }
            m mVar = m.this;
            if (mVar.f7120m.hasDragFlag(mVar.f7125r, e0VarT0)) {
                int pointerId = motionEvent.getPointerId(0);
                int i10 = m.this.f7119l;
                if (pointerId == i10) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i10);
                    float x10 = motionEvent.getX(iFindPointerIndex);
                    float y10 = motionEvent.getY(iFindPointerIndex);
                    m mVar2 = m.this;
                    mVar2.f7111d = x10;
                    mVar2.f7112e = y10;
                    mVar2.f7116i = 0.0f;
                    mVar2.f7115h = 0.0f;
                    if (mVar2.f7120m.isLongPressDragEnabled()) {
                        m.this.C(e0VarT0, 2);
                    }
                }
            }
        }
    }

    public static class h implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f7145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f7146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f7147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f7148d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RecyclerView.e0 f7149e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7150f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ValueAnimator f7151g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f7152h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f7153i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f7154j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f7155k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f7156l = false;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f7157m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f7158n;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                h.this.c(valueAnimator.getAnimatedFraction());
            }
        }

        public h(RecyclerView.e0 e0Var, int i10, int i11, float f10, float f11, float f12, float f13) {
            this.f7150f = i11;
            this.f7152h = i10;
            this.f7149e = e0Var;
            this.f7145a = f10;
            this.f7146b = f11;
            this.f7147c = f12;
            this.f7148d = f13;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f7151g = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new a());
            valueAnimatorOfFloat.setTarget(e0Var.itemView);
            valueAnimatorOfFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.f7151g.cancel();
        }

        public void b(long j10) {
            this.f7151g.setDuration(j10);
        }

        public void c(float f10) {
            this.f7158n = f10;
        }

        public void d() {
            this.f7149e.setIsRecyclable(false);
            this.f7151g.start();
        }

        public void e() {
            float f10 = this.f7145a;
            float f11 = this.f7147c;
            if (f10 == f11) {
                this.f7154j = this.f7149e.itemView.getTranslationX();
            } else {
                this.f7154j = f10 + (this.f7158n * (f11 - f10));
            }
            float f12 = this.f7146b;
            float f13 = this.f7148d;
            if (f12 == f13) {
                this.f7155k = this.f7149e.itemView.getTranslationY();
            } else {
                this.f7155k = f12 + (this.f7158n * (f13 - f12));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f7157m) {
                this.f7149e.setIsRecyclable(true);
            }
            this.f7157m = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static abstract class i extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7161b;

        public i(int i10, int i11) {
            this.f7160a = i11;
            this.f7161b = i10;
        }

        public int a(@n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var) {
            return this.f7161b;
        }

        public int b(@n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var) {
            return this.f7160a;
        }

        public void c(int i10) {
            this.f7161b = i10;
        }

        public void d(int i10) {
            this.f7160a = i10;
        }

        @Override // androidx.recyclerview.widget.m.f
        public int getMovementFlags(@n0 RecyclerView recyclerView, @n0 RecyclerView.e0 e0Var) {
            return f.makeMovementFlags(a(recyclerView, e0Var), b(recyclerView, e0Var));
        }
    }

    public interface j {
        void g(@n0 View view, @n0 View view2, int i10, int i11);
    }

    public m(@n0 f fVar) {
        this.f7120m = fVar;
    }

    public static boolean v(View view, float f10, float f11, float f12, float f13) {
        return f10 >= f12 && f10 <= f12 + ((float) view.getWidth()) && f11 >= f13 && f11 <= f13 + ((float) view.getHeight());
    }

    public void A(View view) {
        if (view == this.f7131x) {
            this.f7131x = null;
            if (this.f7130w != null) {
                this.f7125r.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean B() {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.m.B():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(@g.p0 androidx.recyclerview.widget.RecyclerView.e0 r24, int r25) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.m.C(androidx.recyclerview.widget.RecyclerView$e0, int):void");
    }

    public final void D() {
        this.f7124q = ViewConfiguration.get(this.f7125r.getContext()).getScaledTouchSlop();
        this.f7125r.n(this);
        this.f7125r.q(this.B);
        this.f7125r.p(this);
        F();
    }

    public void E(@n0 RecyclerView.e0 e0Var) {
        if (this.f7120m.hasDragFlag(this.f7125r, e0Var) && e0Var.itemView.getParent() == this.f7125r) {
            x();
            this.f7116i = 0.0f;
            this.f7115h = 0.0f;
            C(e0Var, 2);
        }
    }

    public final void F() {
        this.A = new g();
        this.f7133z = new androidx.core.view.l(this.f7125r.getContext(), this.A);
    }

    public void G(@n0 RecyclerView.e0 e0Var) {
        if (this.f7120m.hasSwipeFlag(this.f7125r, e0Var) && e0Var.itemView.getParent() == this.f7125r) {
            x();
            this.f7116i = 0.0f;
            this.f7115h = 0.0f;
            C(e0Var, 1);
        }
    }

    public final void H() {
        g gVar = this.A;
        if (gVar != null) {
            gVar.a();
            this.A = null;
        }
        if (this.f7133z != null) {
            this.f7133z = null;
        }
    }

    public final int I(RecyclerView.e0 e0Var) {
        if (this.f7121n == 2) {
            return 0;
        }
        int movementFlags = this.f7120m.getMovementFlags(this.f7125r, e0Var);
        int iConvertToAbsoluteDirection = (this.f7120m.convertToAbsoluteDirection(movementFlags, u0.Z(this.f7125r)) & 65280) >> 8;
        if (iConvertToAbsoluteDirection == 0) {
            return 0;
        }
        int i10 = (movementFlags & 65280) >> 8;
        if (Math.abs(this.f7115h) > Math.abs(this.f7116i)) {
            int iK = k(e0Var, iConvertToAbsoluteDirection);
            if (iK > 0) {
                return (i10 & iK) == 0 ? f.convertToRelativeDirection(iK, u0.Z(this.f7125r)) : iK;
            }
            int iM = m(e0Var, iConvertToAbsoluteDirection);
            if (iM > 0) {
                return iM;
            }
        } else {
            int iM2 = m(e0Var, iConvertToAbsoluteDirection);
            if (iM2 > 0) {
                return iM2;
            }
            int iK2 = k(e0Var, iConvertToAbsoluteDirection);
            if (iK2 > 0) {
                return (i10 & iK2) == 0 ? f.convertToRelativeDirection(iK2, u0.Z(this.f7125r)) : iK2;
            }
        }
        return 0;
    }

    public void J(MotionEvent motionEvent, int i10, int i11) {
        float x10 = motionEvent.getX(i11);
        float y10 = motionEvent.getY(i11);
        float f10 = x10 - this.f7111d;
        this.f7115h = f10;
        this.f7116i = y10 - this.f7112e;
        if ((i10 & 4) == 0) {
            this.f7115h = Math.max(0.0f, f10);
        }
        if ((i10 & 8) == 0) {
            this.f7115h = Math.min(0.0f, this.f7115h);
        }
        if ((i10 & 1) == 0) {
            this.f7116i = Math.max(0.0f, this.f7116i);
        }
        if ((i10 & 2) == 0) {
            this.f7116i = Math.min(0.0f, this.f7116i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void a(@n0 View view) {
        A(view);
        RecyclerView.e0 e0VarT0 = this.f7125r.t0(view);
        if (e0VarT0 == null) {
            return;
        }
        RecyclerView.e0 e0Var = this.f7110c;
        if (e0Var != null && e0VarT0 == e0Var) {
            C(null, 0);
            return;
        }
        o(e0VarT0, false);
        if (this.f7108a.remove(e0VarT0.itemView)) {
            this.f7120m.clearView(this.f7125r, e0VarT0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void b(@n0 View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        float f10;
        float f11;
        this.f7132y = -1;
        if (this.f7110c != null) {
            t(this.f7109b);
            float[] fArr = this.f7109b;
            float f12 = fArr[0];
            f11 = fArr[1];
            f10 = f12;
        } else {
            f10 = 0.0f;
            f11 = 0.0f;
        }
        this.f7120m.onDraw(canvas, recyclerView, this.f7110c, this.f7123p, this.f7121n, f10, f11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void h(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        float f10;
        float f11;
        if (this.f7110c != null) {
            t(this.f7109b);
            float[] fArr = this.f7109b;
            float f12 = fArr[0];
            f11 = fArr[1];
            f10 = f12;
        } else {
            f10 = 0.0f;
            f11 = 0.0f;
        }
        this.f7120m.onDrawOver(canvas, recyclerView, this.f7110c, this.f7123p, this.f7121n, f10, f11);
    }

    public final void i() {
    }

    public void j(@p0 RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f7125r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            n();
        }
        this.f7125r = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f7113f = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
            this.f7114g = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
            D();
        }
    }

    public final int k(RecyclerView.e0 e0Var, int i10) {
        if ((i10 & 12) == 0) {
            return 0;
        }
        int i11 = this.f7115h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.f7127t;
        if (velocityTracker != null && this.f7119l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f7120m.getSwipeVelocityThreshold(this.f7114g));
            float xVelocity = this.f7127t.getXVelocity(this.f7119l);
            float yVelocity = this.f7127t.getYVelocity(this.f7119l);
            int i12 = xVelocity <= 0.0f ? 4 : 8;
            float fAbs = Math.abs(xVelocity);
            if ((i12 & i10) != 0 && i11 == i12 && fAbs >= this.f7120m.getSwipeEscapeVelocity(this.f7113f) && fAbs > Math.abs(yVelocity)) {
                return i12;
            }
        }
        float width = this.f7125r.getWidth() * this.f7120m.getSwipeThreshold(e0Var);
        if ((i10 & i11) == 0 || Math.abs(this.f7115h) <= width) {
            return 0;
        }
        return i11;
    }

    public void l(int i10, MotionEvent motionEvent, int i11) {
        RecyclerView.e0 e0VarS;
        int absoluteMovementFlags;
        if (this.f7110c != null || i10 != 2 || this.f7121n == 2 || !this.f7120m.isItemViewSwipeEnabled() || this.f7125r.getScrollState() == 1 || (e0VarS = s(motionEvent)) == null || (absoluteMovementFlags = (this.f7120m.getAbsoluteMovementFlags(this.f7125r, e0VarS) & 65280) >> 8) == 0) {
            return;
        }
        float x10 = motionEvent.getX(i11);
        float y10 = motionEvent.getY(i11);
        float f10 = x10 - this.f7111d;
        float f11 = y10 - this.f7112e;
        float fAbs = Math.abs(f10);
        float fAbs2 = Math.abs(f11);
        int i12 = this.f7124q;
        if (fAbs >= i12 || fAbs2 >= i12) {
            if (fAbs > fAbs2) {
                if (f10 < 0.0f && (absoluteMovementFlags & 4) == 0) {
                    return;
                }
                if (f10 > 0.0f && (absoluteMovementFlags & 8) == 0) {
                    return;
                }
            } else {
                if (f11 < 0.0f && (absoluteMovementFlags & 1) == 0) {
                    return;
                }
                if (f11 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                    return;
                }
            }
            this.f7116i = 0.0f;
            this.f7115h = 0.0f;
            this.f7119l = motionEvent.getPointerId(0);
            C(e0VarS, 1);
        }
    }

    public final int m(RecyclerView.e0 e0Var, int i10) {
        if ((i10 & 3) == 0) {
            return 0;
        }
        int i11 = this.f7116i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f7127t;
        if (velocityTracker != null && this.f7119l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f7120m.getSwipeVelocityThreshold(this.f7114g));
            float xVelocity = this.f7127t.getXVelocity(this.f7119l);
            float yVelocity = this.f7127t.getYVelocity(this.f7119l);
            int i12 = yVelocity <= 0.0f ? 1 : 2;
            float fAbs = Math.abs(yVelocity);
            if ((i12 & i10) != 0 && i12 == i11 && fAbs >= this.f7120m.getSwipeEscapeVelocity(this.f7113f) && fAbs > Math.abs(xVelocity)) {
                return i12;
            }
        }
        float height = this.f7125r.getHeight() * this.f7120m.getSwipeThreshold(e0Var);
        if ((i10 & i11) == 0 || Math.abs(this.f7116i) <= height) {
            return 0;
        }
        return i11;
    }

    public final void n() {
        this.f7125r.q1(this);
        this.f7125r.t1(this.B);
        this.f7125r.s1(this);
        for (int size = this.f7123p.size() - 1; size >= 0; size--) {
            this.f7120m.clearView(this.f7125r, this.f7123p.get(0).f7149e);
        }
        this.f7123p.clear();
        this.f7131x = null;
        this.f7132y = -1;
        z();
        H();
    }

    public void o(RecyclerView.e0 e0Var, boolean z10) {
        for (int size = this.f7123p.size() - 1; size >= 0; size--) {
            h hVar = this.f7123p.get(size);
            if (hVar.f7149e == e0Var) {
                hVar.f7156l |= z10;
                if (!hVar.f7157m) {
                    hVar.a();
                }
                this.f7123p.remove(size);
                return;
            }
        }
    }

    public h p(MotionEvent motionEvent) {
        if (this.f7123p.isEmpty()) {
            return null;
        }
        View viewQ = q(motionEvent);
        for (int size = this.f7123p.size() - 1; size >= 0; size--) {
            h hVar = this.f7123p.get(size);
            if (hVar.f7149e.itemView == viewQ) {
                return hVar;
            }
        }
        return null;
    }

    public View q(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        RecyclerView.e0 e0Var = this.f7110c;
        if (e0Var != null) {
            View view = e0Var.itemView;
            if (v(view, x10, y10, this.f7117j + this.f7115h, this.f7118k + this.f7116i)) {
                return view;
            }
        }
        for (int size = this.f7123p.size() - 1; size >= 0; size--) {
            h hVar = this.f7123p.get(size);
            View view2 = hVar.f7149e.itemView;
            if (v(view2, x10, y10, hVar.f7154j, hVar.f7155k)) {
                return view2;
            }
        }
        return this.f7125r.Z(x10, y10);
    }

    public final List<RecyclerView.e0> r(RecyclerView.e0 e0Var) {
        RecyclerView.e0 e0Var2 = e0Var;
        List<RecyclerView.e0> list = this.f7128u;
        if (list == null) {
            this.f7128u = new ArrayList();
            this.f7129v = new ArrayList();
        } else {
            list.clear();
            this.f7129v.clear();
        }
        int boundingBoxMargin = this.f7120m.getBoundingBoxMargin();
        int iRound = Math.round(this.f7117j + this.f7115h) - boundingBoxMargin;
        int iRound2 = Math.round(this.f7118k + this.f7116i) - boundingBoxMargin;
        int i10 = boundingBoxMargin * 2;
        int width = e0Var2.itemView.getWidth() + iRound + i10;
        int height = e0Var2.itemView.getHeight() + iRound2 + i10;
        int i11 = (iRound + width) / 2;
        int i12 = (iRound2 + height) / 2;
        RecyclerView.o layoutManager = this.f7125r.getLayoutManager();
        int iY = layoutManager.Y();
        int i13 = 0;
        while (i13 < iY) {
            View viewX = layoutManager.X(i13);
            if (viewX != e0Var2.itemView && viewX.getBottom() >= iRound2 && viewX.getTop() <= height && viewX.getRight() >= iRound && viewX.getLeft() <= width) {
                RecyclerView.e0 e0VarT0 = this.f7125r.t0(viewX);
                if (this.f7120m.canDropOver(this.f7125r, this.f7110c, e0VarT0)) {
                    int iAbs = Math.abs(i11 - ((viewX.getLeft() + viewX.getRight()) / 2));
                    int iAbs2 = Math.abs(i12 - ((viewX.getTop() + viewX.getBottom()) / 2));
                    int i14 = (iAbs * iAbs) + (iAbs2 * iAbs2);
                    int size = this.f7128u.size();
                    int i15 = 0;
                    for (int i16 = 0; i16 < size && i14 > this.f7129v.get(i16).intValue(); i16++) {
                        i15++;
                    }
                    this.f7128u.add(i15, e0VarT0);
                    this.f7129v.add(i15, Integer.valueOf(i14));
                }
            }
            i13++;
            e0Var2 = e0Var;
        }
        return this.f7128u;
    }

    public final RecyclerView.e0 s(MotionEvent motionEvent) {
        View viewQ;
        RecyclerView.o layoutManager = this.f7125r.getLayoutManager();
        int i10 = this.f7119l;
        if (i10 == -1) {
            return null;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i10);
        float x10 = motionEvent.getX(iFindPointerIndex) - this.f7111d;
        float y10 = motionEvent.getY(iFindPointerIndex) - this.f7112e;
        float fAbs = Math.abs(x10);
        float fAbs2 = Math.abs(y10);
        int i11 = this.f7124q;
        if (fAbs < i11 && fAbs2 < i11) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.v()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.w()) && (viewQ = q(motionEvent)) != null) {
            return this.f7125r.t0(viewQ);
        }
        return null;
    }

    public final void t(float[] fArr) {
        if ((this.f7122o & 12) != 0) {
            fArr[0] = (this.f7117j + this.f7115h) - this.f7110c.itemView.getLeft();
        } else {
            fArr[0] = this.f7110c.itemView.getTranslationX();
        }
        if ((this.f7122o & 3) != 0) {
            fArr[1] = (this.f7118k + this.f7116i) - this.f7110c.itemView.getTop();
        } else {
            fArr[1] = this.f7110c.itemView.getTranslationY();
        }
    }

    public boolean u() {
        int size = this.f7123p.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f7123p.get(i10).f7157m) {
                return true;
            }
        }
        return false;
    }

    public void w(RecyclerView.e0 e0Var) {
        if (!this.f7125r.isLayoutRequested() && this.f7121n == 2) {
            float moveThreshold = this.f7120m.getMoveThreshold(e0Var);
            int i10 = (int) (this.f7117j + this.f7115h);
            int i11 = (int) (this.f7118k + this.f7116i);
            if (Math.abs(i11 - e0Var.itemView.getTop()) >= e0Var.itemView.getHeight() * moveThreshold || Math.abs(i10 - e0Var.itemView.getLeft()) >= e0Var.itemView.getWidth() * moveThreshold) {
                List<RecyclerView.e0> listR = r(e0Var);
                if (listR.size() == 0) {
                    return;
                }
                RecyclerView.e0 e0VarChooseDropTarget = this.f7120m.chooseDropTarget(e0Var, listR, i10, i11);
                if (e0VarChooseDropTarget == null) {
                    this.f7128u.clear();
                    this.f7129v.clear();
                    return;
                }
                int adapterPosition = e0VarChooseDropTarget.getAdapterPosition();
                int adapterPosition2 = e0Var.getAdapterPosition();
                if (this.f7120m.onMove(this.f7125r, e0Var, e0VarChooseDropTarget)) {
                    this.f7120m.onMoved(this.f7125r, e0Var, adapterPosition2, e0VarChooseDropTarget, adapterPosition, i10, i11);
                }
            }
        }
    }

    public void x() {
        VelocityTracker velocityTracker = this.f7127t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f7127t = VelocityTracker.obtain();
    }

    public void y(h hVar, int i10) {
        this.f7125r.post(new d(hVar, i10));
    }

    public final void z() {
        VelocityTracker velocityTracker = this.f7127t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f7127t = null;
        }
    }
}

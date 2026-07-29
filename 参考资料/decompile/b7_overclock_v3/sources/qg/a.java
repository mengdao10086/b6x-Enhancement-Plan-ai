package qg;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.e0;
import androidx.core.view.i0;
import androidx.viewpager.widget.ViewPager;
import g.n0;
import java.util.LinkedList;
import mg.e;
import mg.i;
import mg.k;

/* JADX INFO: loaded from: classes5.dex */
public class a implements e, sg.a, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f47352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f47353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f47354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f47355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f47356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f47357f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f47358g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f47359h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f47360i = new d();

    public a(@n0 View view) {
        this.f47354c = view;
        this.f47353b = view;
        this.f47352a = view;
    }

    @Override // sg.a
    public void a(boolean z10, boolean z11) {
        this.f47358g = z10;
        this.f47359h = z11;
    }

    @Override // mg.e
    public void b(boolean z10) {
        this.f47360i.f47363c = z10;
    }

    @Override // mg.e
    public void c(k kVar) {
        if (kVar instanceof d) {
            this.f47360i = (d) kVar;
        } else {
            this.f47360i.f47362b = kVar;
        }
    }

    @Override // mg.e
    public boolean d() {
        return this.f47358g && this.f47360i.a(this.f47352a);
    }

    @Override // mg.e
    public void e(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.f47352a.getLeft(), -this.f47352a.getTop());
        View view = this.f47354c;
        View view2 = this.f47352a;
        if (view != view2) {
            this.f47354c = l(view2, pointF, view);
        }
        if (this.f47354c == this.f47352a) {
            this.f47360i.f47361a = null;
        } else {
            this.f47360i.f47361a = pointF;
        }
    }

    @Override // mg.e
    public void f(int i10, int i11, int i12) {
        boolean z10;
        View viewFindViewById;
        View viewFindViewById2;
        boolean z11 = true;
        if (i11 == -1 || (viewFindViewById2 = this.f47353b.findViewById(i11)) == null) {
            z10 = false;
        } else if (i10 > 0) {
            viewFindViewById2.setTranslationY(i10);
            z10 = true;
        } else {
            if (viewFindViewById2.getTranslationY() > 0.0f) {
                viewFindViewById2.setTranslationY(0.0f);
            }
            z10 = false;
        }
        if (i12 == -1 || (viewFindViewById = this.f47353b.findViewById(i12)) == null) {
            z11 = z10;
        } else if (i10 < 0) {
            viewFindViewById.setTranslationY(i10);
        } else {
            if (viewFindViewById.getTranslationY() < 0.0f) {
                viewFindViewById.setTranslationY(0.0f);
            }
            z11 = z10;
        }
        if (z11) {
            this.f47353b.setTranslationY(0.0f);
        } else {
            this.f47353b.setTranslationY(i10);
        }
        View view = this.f47355d;
        if (view != null) {
            view.setTranslationY(Math.max(0, i10));
        }
        View view2 = this.f47356e;
        if (view2 != null) {
            view2.setTranslationY(Math.min(0, i10));
        }
    }

    @Override // mg.e
    public ValueAnimator.AnimatorUpdateListener g(int i10) {
        View view = this.f47354c;
        if (view == null || i10 == 0) {
            return null;
        }
        if ((i10 >= 0 || !tg.b.c(view, 1)) && (i10 <= 0 || !tg.b.c(this.f47354c, -1))) {
            return null;
        }
        this.f47357f = i10;
        return this;
    }

    @Override // mg.e
    @n0
    public View getView() {
        return this.f47352a;
    }

    @Override // mg.e
    public boolean h() {
        return this.f47359h && this.f47360i.b(this.f47352a);
    }

    @Override // mg.e
    @n0
    public View i() {
        return this.f47354c;
    }

    @Override // mg.e
    public void j(i iVar, View view, View view2) {
        k(this.f47352a, iVar);
        if (view == null && view2 == null) {
            return;
        }
        this.f47355d = view;
        this.f47356e = view2;
        FrameLayout frameLayout = new FrameLayout(this.f47352a.getContext());
        int iIndexOfChild = iVar.h().getLayout().indexOfChild(this.f47352a);
        iVar.h().getLayout().removeView(this.f47352a);
        frameLayout.addView(this.f47352a, 0, new ViewGroup.LayoutParams(-1, -1));
        iVar.h().getLayout().addView(frameLayout, iIndexOfChild, this.f47352a.getLayoutParams());
        this.f47352a = frameLayout;
        if (view != null) {
            view.setTag("fixed-top");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int iIndexOfChild2 = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams.height = tg.b.i(view);
            viewGroup.addView(new o1.a(this.f47352a.getContext()), iIndexOfChild2, layoutParams);
            frameLayout.addView(view, 1, layoutParams);
        }
        if (view2 != null) {
            view2.setTag("fixed-bottom");
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int iIndexOfChild3 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
            layoutParams2.height = tg.b.i(view2);
            viewGroup2.addView(new o1.a(this.f47352a.getContext()), iIndexOfChild3, layoutParams2);
            layoutParams3.gravity = 80;
            frameLayout.addView(view2, 1, layoutParams3);
        }
    }

    public void k(View view, i iVar) {
        boolean zIsInEditMode = this.f47352a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof i0) || (view2 instanceof e0))) {
                break;
            }
            view = m(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!zIsInEditMode) {
                tg.a.a(view, iVar, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.f47354c = view2;
        }
    }

    public View l(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (tg.b.h(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && tg.b.f(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View viewL = l(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return viewL;
                }
            }
        }
        return view2;
    }

    public View m(View view, boolean z10) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z10 || view3 != view) && tg.b.f(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                        linkedList.add(viewGroup.getChildAt(i10));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (iIntValue - this.f47357f) * this.f47354c.getScaleY();
            View view = this.f47354c;
            if (view instanceof AbsListView) {
                tg.b.k((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f47357f = iIntValue;
    }
}

package nd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.y0;
import androidx.core.view.j1;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.t;
import com.google.android.material.navigation.NavigationBarView;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class c extends NavigationBarView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f42072l = 5;

    public class a implements b0.e {
        public a() {
        }

        @Override // com.google.android.material.internal.b0.e
        @n0
        public j1 a(View view, @n0 j1 j1Var, @n0 b0.f fVar) {
            fVar.f20410d += j1Var.o();
            boolean z10 = u0.Z(view) == 1;
            int iP = j1Var.p();
            int iQ = j1Var.q();
            fVar.f20407a += z10 ? iQ : iP;
            int i10 = fVar.f20409c;
            if (!z10) {
                iP = iQ;
            }
            fVar.f20409c = i10 + iP;
            fVar.a(view);
            return j1Var;
        }
    }

    @Deprecated
    public interface b extends NavigationBarView.c {
    }

    /* JADX INFO: renamed from: nd.c$c, reason: collision with other inner class name */
    @Deprecated
    public interface InterfaceC0473c extends NavigationBarView.d {
    }

    public c(@n0 Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public com.google.android.material.navigation.c d(@n0 Context context) {
        return new nd.b(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    public final void k(@n0 Context context) {
        View view = new View(context);
        view.setBackgroundColor(h0.d.f(context, R.color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    public final void l() {
        b0.d(this, new a());
    }

    public boolean m() {
        return ((nd.b) getMenuView()).u();
    }

    public final int n(int i10) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i10) == 1073741824 || suggestedMinimumHeight <= 0) {
            return i10;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), suggestedMinimumHeight + getPaddingTop() + getPaddingBottom()), 1073741824);
    }

    public final boolean o() {
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, n(i11));
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        nd.b bVar = (nd.b) getMenuView();
        if (bVar.u() != z10) {
            bVar.setItemHorizontalTranslationEnabled(z10);
            getPresenter().c(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@p0 b bVar) {
        setOnItemReselectedListener(bVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@p0 InterfaceC0473c interfaceC0473c) {
        setOnItemSelectedListener(interfaceC0473c);
    }

    public c(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    public c(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, R.style.Widget_Design_BottomNavigationView);
    }

    public c(@n0 Context context, @p0 AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Context context2 = getContext();
        y0 y0VarL = t.l(context2, attributeSet, R.styleable.BottomNavigationView, i10, i11, new int[0]);
        setItemHorizontalTranslationEnabled(y0VarL.a(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int i12 = R.styleable.BottomNavigationView_android_minHeight;
        if (y0VarL.C(i12)) {
            setMinimumHeight(y0VarL.g(i12, 0));
        }
        y0VarL.I();
        if (o()) {
            k(context2);
        }
        l();
    }
}

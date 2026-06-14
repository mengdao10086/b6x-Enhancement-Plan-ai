package a;

import a.w4;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class n5 extends x3 implements sf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g5 f6875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h5 f2007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i5 f2008a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k5 f2009a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l5 f2010a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final m5 f2011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f2012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseBooleanArray f2013a;
    public boolean b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2014c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f2015d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f2016e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f2017f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f2018g;
    public boolean h;

    public n5(Context context) {
        super(context, z.abc_action_menu_layout, z.abc_action_menu_item_layout);
        this.f2013a = new SparseBooleanArray();
        this.f2011a = new m5(this);
    }

    public Drawable A() {
        k5 k5Var = this.f2009a;
        if (k5Var != null) {
            return k5Var.getDrawable();
        }
        if (this.b) {
            return this.f2012a;
        }
        return null;
    }

    public boolean B() {
        Object obj;
        i5 i5Var = this.f2008a;
        if (i5Var != null && (obj = ((x3) this).f3517a) != null) {
            ((View) obj).removeCallbacks(i5Var);
            this.f2008a = null;
            return true;
        }
        l5 l5Var = this.f2010a;
        if (l5Var == null) {
            return false;
        }
        l5Var.b();
        return true;
    }

    public boolean C() {
        g5 g5Var = this.f6875a;
        if (g5Var == null) {
            return false;
        }
        g5Var.b();
        return true;
    }

    public boolean D() {
        return this.f2008a != null || E();
    }

    public boolean E() {
        l5 l5Var = this.f2010a;
        return l5Var != null && l5Var.d();
    }

    public void F(Configuration configuration) {
        if (!this.f2016e) {
            this.e = j3.b(((x3) this).f3520b).d();
        }
        i4 i4Var = ((x3) this).f3515a;
        if (i4Var != null) {
            i4Var.K(true);
        }
    }

    public void G(boolean z) {
        this.h = z;
    }

    public void H(ActionMenuView actionMenuView) {
        ((x3) this).f3517a = actionMenuView;
        actionMenuView.d(((x3) this).f3515a);
    }

    public void I(Drawable drawable) {
        k5 k5Var = this.f2009a;
        if (k5Var != null) {
            k5Var.setImageDrawable(drawable);
        } else {
            this.b = true;
            this.f2012a = drawable;
        }
    }

    public void J(boolean z) {
        this.f2014c = z;
        this.f2015d = true;
    }

    public boolean K() {
        i4 i4Var;
        if (!this.f2014c || E() || (i4Var = ((x3) this).f3515a) == null || ((x3) this).f3517a == null || this.f2008a != null || i4Var.z().isEmpty()) {
            return false;
        }
        i5 i5Var = new i5(this, new l5(this, ((x3) this).f3520b, ((x3) this).f3515a, this.f2009a, true));
        this.f2008a = i5Var;
        ((View) ((x3) this).f3517a).post(i5Var);
        return true;
    }

    @Override // a.x3, a.v4
    public void b(i4 i4Var, boolean z) {
        y();
        super.b(i4Var, z);
    }

    @Override // a.x3
    public void c(l4 l4Var, w4.a aVar) {
        aVar.e(l4Var, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) ((x3) this).f3517a);
        if (this.f2007a == null) {
            this.f2007a = new h5(this);
        }
        actionMenuItemView.setPopupCallback(this.f2007a);
    }

    @Override // a.x3, a.v4
    public void f(Context context, i4 i4Var) {
        super.f(context, i4Var);
        Resources resources = context.getResources();
        j3 j3VarB = j3.b(context);
        if (!this.f2015d) {
            this.f2014c = j3VarB.f();
        }
        if (!this.f2018g) {
            this.c = j3VarB.c();
        }
        if (!this.f2016e) {
            this.e = j3VarB.d();
        }
        int measuredWidth = this.c;
        if (this.f2014c) {
            if (this.f2009a == null) {
                k5 k5Var = new k5(this, ((x3) this).f3518a);
                this.f2009a = k5Var;
                if (this.b) {
                    k5Var.setImageDrawable(this.f2012a);
                    this.f2012a = null;
                    this.b = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f2009a.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f2009a.getMeasuredWidth();
        } else {
            this.f2009a = null;
        }
        this.d = measuredWidth;
        this.f = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [a.n5] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r15v1, types: [a.l4] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // a.v4
    public boolean h() {
        ArrayList<l4> arrayListE;
        int size;
        int i;
        int iL;
        ?? r0;
        int i2;
        n5 n5Var = this;
        i4 i4Var = ((x3) n5Var).f3515a;
        View view = null;
        ?? r3 = 0;
        if (i4Var != null) {
            arrayListE = i4Var.E();
            size = arrayListE.size();
        } else {
            arrayListE = null;
            size = 0;
        }
        int i3 = n5Var.e;
        int i4 = n5Var.d;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) ((x3) n5Var).f3517a;
        boolean z = false;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            l4 l4Var = arrayListE.get(i7);
            if (l4Var.q()) {
                i5++;
            } else if (l4Var.p()) {
                i6++;
            } else {
                z = true;
            }
            if (n5Var.h && l4Var.isActionViewExpanded()) {
                i3 = 0;
            }
        }
        if (n5Var.f2014c && (z || i6 + i5 > i3)) {
            i3--;
        }
        int i8 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = n5Var.f2013a;
        sparseBooleanArray.clear();
        if (n5Var.f2017f) {
            int i9 = n5Var.f;
            iL = i4 / i9;
            i = i9 + ((i4 % i9) / iL);
        } else {
            i = 0;
            iL = 0;
        }
        int i10 = 0;
        int i11 = 0;
        ?? r02 = n5Var;
        while (i10 < size) {
            l4 l4Var2 = arrayListE.get(i10);
            if (l4Var2.q()) {
                View viewN = r02.n(l4Var2, view, viewGroup);
                if (r02.f2017f) {
                    iL -= ActionMenuView.L(viewN, i, iL, iMakeMeasureSpec, r3);
                } else {
                    viewN.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewN.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                int groupId = l4Var2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                l4Var2.w(true);
                r0 = r3;
                i2 = size;
            } else if (l4Var2.p()) {
                int groupId2 = l4Var2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i8 > 0 || z2) && i4 > 0 && (!r02.f2017f || iL > 0);
                boolean z4 = z3;
                i2 = size;
                if (z3) {
                    View viewN2 = r02.n(l4Var2, null, viewGroup);
                    if (r02.f2017f) {
                        int iL2 = ActionMenuView.L(viewN2, i, iL, iMakeMeasureSpec, 0);
                        iL -= iL2;
                        if (iL2 == 0) {
                            z4 = false;
                        }
                    } else {
                        viewN2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = viewN2.getMeasuredWidth();
                    i4 -= measuredWidth2;
                    if (i11 == 0) {
                        i11 = measuredWidth2;
                    }
                    z3 = z5 & (!r02.f2017f ? i4 + i11 <= 0 : i4 < 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i12 = 0; i12 < i10; i12++) {
                        l4 l4Var3 = arrayListE.get(i12);
                        if (l4Var3.getGroupId() == groupId2) {
                            if (l4Var3.n()) {
                                i8++;
                            }
                            l4Var3.w(false);
                        }
                    }
                }
                if (z3) {
                    i8--;
                }
                l4Var2.w(z3);
                r0 = 0;
            } else {
                r0 = r3;
                i2 = size;
                l4Var2.w(r0);
            }
            i10++;
            r3 = r0;
            size = i2;
            view = null;
            r02 = this;
        }
        return true;
    }

    @Override // a.x3, a.v4
    public void i(boolean z) {
        super.i(z);
        ((View) ((x3) this).f3517a).requestLayout();
        i4 i4Var = ((x3) this).f3515a;
        boolean z2 = false;
        if (i4Var != null) {
            ArrayList<l4> arrayListS = i4Var.s();
            int size = arrayListS.size();
            for (int i = 0; i < size; i++) {
                uf ufVarC = arrayListS.get(i).c();
                if (ufVarC != null) {
                    ufVarC.i(this);
                }
            }
        }
        i4 i4Var2 = ((x3) this).f3515a;
        ArrayList<l4> arrayListZ = i4Var2 != null ? i4Var2.z() : null;
        if (this.f2014c && arrayListZ != null) {
            int size2 = arrayListZ.size();
            if (size2 == 1) {
                z2 = !arrayListZ.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        k5 k5Var = this.f2009a;
        if (z2) {
            if (k5Var == null) {
                this.f2009a = new k5(this, ((x3) this).f3518a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f2009a.getParent();
            if (viewGroup != ((x3) this).f3517a) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f2009a);
                }
                ActionMenuView actionMenuView = (ActionMenuView) ((x3) this).f3517a;
                actionMenuView.addView(this.f2009a, actionMenuView.F());
            }
        } else if (k5Var != null) {
            Object parent = k5Var.getParent();
            Object obj = ((x3) this).f3517a;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.f2009a);
            }
        }
        ((ActionMenuView) ((x3) this).f3517a).setOverflowReserved(this.f2014c);
    }

    @Override // a.x3, a.v4
    public boolean j(c5 c5Var) {
        boolean z = false;
        if (!c5Var.hasVisibleItems()) {
            return false;
        }
        c5 c5Var2 = c5Var;
        while (c5Var2.e0() != ((x3) this).f3515a) {
            c5Var2 = (c5) c5Var2.e0();
        }
        View viewZ = z(c5Var2.getItem());
        if (viewZ == null) {
            return false;
        }
        c5Var.getItem().getItemId();
        int size = c5Var.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = c5Var.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        g5 g5Var = new g5(this, ((x3) this).f3520b, c5Var, viewZ);
        this.f6875a = g5Var;
        g5Var.g(z);
        this.f6875a.k();
        super.j(c5Var);
        return true;
    }

    @Override // a.x3
    public boolean l(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f2009a) {
            return false;
        }
        return super.l(viewGroup, i);
    }

    @Override // a.x3
    public View n(l4 l4Var, View view, ViewGroup viewGroup) {
        View actionView = l4Var.getActionView();
        if (actionView == null || l4Var.l()) {
            actionView = super.n(l4Var, view, viewGroup);
        }
        actionView.setVisibility(l4Var.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // a.x3
    public w4 o(ViewGroup viewGroup) {
        w4 w4Var = ((x3) this).f3517a;
        w4 w4VarO = super.o(viewGroup);
        if (w4Var != w4VarO) {
            ((ActionMenuView) w4VarO).setPresenter(this);
        }
        return w4VarO;
    }

    @Override // a.x3
    public boolean q(int i, l4 l4Var) {
        return l4Var.n();
    }

    public boolean y() {
        return B() | C();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View z(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) ((x3) this).f3517a;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof w4.a) && ((w4.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }
}

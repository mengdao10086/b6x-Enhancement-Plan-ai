package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ActionMenuPresenter extends androidx.appcompat.view.menu.a implements b.a {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f2062k0 = "ActionMenuPresenter";
    public c A;
    public b B;
    public final f C;
    public int D;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f2063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f2064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2065m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2067o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2068p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2069q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2070r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2071s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2072t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2073u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2074v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2075w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final SparseBooleanArray f2076x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public e f2077y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f2078z;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2079a;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f2079a);
        }

        public SavedState(Parcel parcel) {
            this.f2079a = parcel.readInt();
        }
    }

    public class a extends androidx.appcompat.view.menu.i {
        public a(Context context, androidx.appcompat.view.menu.m mVar, View view) {
            super(context, mVar, view, false, R.attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.h) mVar.getItem()).o()) {
                View view2 = ActionMenuPresenter.this.f2063k;
                h(view2 == null ? (View) ActionMenuPresenter.this.f1876i : view2);
            }
            a(ActionMenuPresenter.this.C);
        }

        @Override // androidx.appcompat.view.menu.i
        public void g() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f2078z = null;
            actionMenuPresenter.D = 0;
            super.g();
        }
    }

    public class b extends ActionMenuItemView.b {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public m.f a() {
            a aVar = ActionMenuPresenter.this.f2078z;
            if (aVar != null) {
                return aVar.e();
            }
            return null;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f2082a;

        public c(e eVar) {
            this.f2082a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.f1870c != null) {
                ActionMenuPresenter.this.f1870c.d();
            }
            View view = (View) ActionMenuPresenter.this.f1876i;
            if (view != null && view.getWindowToken() != null && this.f2082a.o()) {
                ActionMenuPresenter.this.f2077y = this.f2082a;
            }
            ActionMenuPresenter.this.A = null;
        }
    }

    public class d extends AppCompatImageView implements ActionMenuView.a {

        public class a extends h0 {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ ActionMenuPresenter f2085j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.f2085j = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.h0
            public m.f b() {
                e eVar = ActionMenuPresenter.this.f2077y;
                if (eVar == null) {
                    return null;
                }
                return eVar.e();
            }

            @Override // androidx.appcompat.widget.h0
            public boolean c() {
                ActionMenuPresenter.this.Q();
                return true;
            }

            @Override // androidx.appcompat.widget.h0
            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.A != null) {
                    return false;
                }
                actionMenuPresenter.E();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            b1.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean d() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.Q();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                n0.c.l(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    public class e extends androidx.appcompat.view.menu.i {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z10) {
            super(context, eVar, view, z10, R.attr.actionOverflowMenuStyle);
            j(8388613);
            a(ActionMenuPresenter.this.C);
        }

        @Override // androidx.appcompat.view.menu.i
        public void g() {
            if (ActionMenuPresenter.this.f1870c != null) {
                ActionMenuPresenter.this.f1870c.close();
            }
            ActionMenuPresenter.this.f2077y = null;
            super.g();
        }
    }

    public class f implements j.a {
        public f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void b(@g.n0 androidx.appcompat.view.menu.e eVar, boolean z10) {
            if (eVar instanceof androidx.appcompat.view.menu.m) {
                eVar.G().f(false);
            }
            j.a aVarQ = ActionMenuPresenter.this.q();
            if (aVarQ != null) {
                aVarQ.b(eVar, z10);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean c(@g.n0 androidx.appcompat.view.menu.e eVar) {
            if (eVar == ActionMenuPresenter.this.f1870c) {
                return false;
            }
            ActionMenuPresenter.this.D = ((androidx.appcompat.view.menu.m) eVar).getItem().getItemId();
            j.a aVarQ = ActionMenuPresenter.this.q();
            if (aVarQ != null) {
                return aVarQ.c(eVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.f2076x = new SparseBooleanArray();
        this.C = new f();
    }

    public boolean B() {
        return E() | F();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View C(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1876i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof k.a) && ((k.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable D() {
        d dVar = this.f2063k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f2065m) {
            return this.f2064l;
        }
        return null;
    }

    public boolean E() {
        Object obj;
        c cVar = this.A;
        if (cVar != null && (obj = this.f1876i) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.A = null;
            return true;
        }
        e eVar = this.f2077y;
        if (eVar == null) {
            return false;
        }
        eVar.dismiss();
        return true;
    }

    public boolean F() {
        a aVar = this.f2078z;
        if (aVar == null) {
            return false;
        }
        aVar.dismiss();
        return true;
    }

    public boolean G() {
        return this.A != null || H();
    }

    public boolean H() {
        e eVar = this.f2077y;
        return eVar != null && eVar.f();
    }

    public boolean I() {
        return this.f2066n;
    }

    public void J(Configuration configuration) {
        if (!this.f2071s) {
            this.f2070r = l.a.b(this.f1869b).d();
        }
        androidx.appcompat.view.menu.e eVar = this.f1870c;
        if (eVar != null) {
            eVar.N(true);
        }
    }

    public void K(boolean z10) {
        this.f2074v = z10;
    }

    public void L(int i10) {
        this.f2070r = i10;
        this.f2071s = true;
    }

    public void M(ActionMenuView actionMenuView) {
        this.f1876i = actionMenuView;
        actionMenuView.e(this.f1870c);
    }

    public void N(Drawable drawable) {
        d dVar = this.f2063k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f2065m = true;
            this.f2064l = drawable;
        }
    }

    public void O(boolean z10) {
        this.f2066n = z10;
        this.f2067o = true;
    }

    public void P(int i10, boolean z10) {
        this.f2068p = i10;
        this.f2072t = z10;
        this.f2073u = true;
    }

    public boolean Q() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f2066n || H() || (eVar = this.f1870c) == null || this.f1876i == null || this.A != null || eVar.C().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f1869b, this.f1870c, this.f2063k, true));
        this.A = cVar;
        ((View) this.f1876i).post(cVar);
        return true;
    }

    @Override // androidx.core.view.b.a
    public void a(boolean z10) {
        if (z10) {
            super.l(null);
            return;
        }
        androidx.appcompat.view.menu.e eVar = this.f1870c;
        if (eVar != null) {
            eVar.f(false);
        }
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void b(androidx.appcompat.view.menu.e eVar, boolean z10) {
        B();
        super.b(eVar, z10);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void c(boolean z10) {
        super.c(z10);
        ((View) this.f1876i).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f1870c;
        boolean z11 = false;
        if (eVar != null) {
            ArrayList<androidx.appcompat.view.menu.h> arrayListV = eVar.v();
            int size = arrayListV.size();
            for (int i10 = 0; i10 < size; i10++) {
                androidx.core.view.b bVarB = arrayListV.get(i10).b();
                if (bVarB != null) {
                    bVarB.k(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f1870c;
        ArrayList<androidx.appcompat.view.menu.h> arrayListC = eVar2 != null ? eVar2.C() : null;
        if (this.f2066n && arrayListC != null) {
            int size2 = arrayListC.size();
            if (size2 == 1) {
                z11 = !arrayListC.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z11 = true;
            }
        }
        if (z11) {
            if (this.f2063k == null) {
                this.f2063k = new d(this.f1868a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f2063k.getParent();
            if (viewGroup != this.f1876i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f2063k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1876i;
                actionMenuView.addView(this.f2063k, actionMenuView.J());
            }
        } else {
            d dVar = this.f2063k;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.f1876i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f2063k);
                }
            }
        }
        ((ActionMenuView) this.f1876i).setOverflowReserved(this.f2066n);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public boolean e() {
        ArrayList<androidx.appcompat.view.menu.h> arrayListH;
        int size;
        int i10;
        int iP;
        int i11;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.e eVar = actionMenuPresenter.f1870c;
        View view = null;
        int i12 = 0;
        if (eVar != null) {
            arrayListH = eVar.H();
            size = arrayListH.size();
        } else {
            arrayListH = null;
            size = 0;
        }
        int i13 = actionMenuPresenter.f2070r;
        int i14 = actionMenuPresenter.f2069q;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f1876i;
        boolean z10 = false;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            androidx.appcompat.view.menu.h hVar = arrayListH.get(i17);
            if (hVar.d()) {
                i15++;
            } else if (hVar.q()) {
                i16++;
            } else {
                z10 = true;
            }
            if (actionMenuPresenter.f2074v && hVar.isActionViewExpanded()) {
                i13 = 0;
            }
        }
        if (actionMenuPresenter.f2066n && (z10 || i16 + i15 > i13)) {
            i13--;
        }
        int i18 = i13 - i15;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f2076x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f2072t) {
            int i19 = actionMenuPresenter.f2075w;
            iP = i14 / i19;
            i10 = i19 + ((i14 % i19) / iP);
        } else {
            i10 = 0;
            iP = 0;
        }
        int i20 = 0;
        int i21 = 0;
        while (i20 < size) {
            androidx.appcompat.view.menu.h hVar2 = arrayListH.get(i20);
            if (hVar2.d()) {
                View viewR = actionMenuPresenter.r(hVar2, view, viewGroup);
                if (actionMenuPresenter.f2072t) {
                    iP -= ActionMenuView.P(viewR, i10, iP, iMakeMeasureSpec, i12);
                } else {
                    viewR.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewR.getMeasuredWidth();
                i14 -= measuredWidth;
                if (i21 == 0) {
                    i21 = measuredWidth;
                }
                int groupId = hVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                hVar2.x(true);
                i11 = size;
            } else if (hVar2.q()) {
                int groupId2 = hVar2.getGroupId();
                boolean z11 = sparseBooleanArray.get(groupId2);
                boolean z12 = (i18 > 0 || z11) && i14 > 0 && (!actionMenuPresenter.f2072t || iP > 0);
                boolean z13 = z12;
                i11 = size;
                if (z12) {
                    View viewR2 = actionMenuPresenter.r(hVar2, null, viewGroup);
                    if (actionMenuPresenter.f2072t) {
                        int iP2 = ActionMenuView.P(viewR2, i10, iP, iMakeMeasureSpec, 0);
                        iP -= iP2;
                        if (iP2 == 0) {
                            z13 = false;
                        }
                    } else {
                        viewR2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z14 = z13;
                    int measuredWidth2 = viewR2.getMeasuredWidth();
                    i14 -= measuredWidth2;
                    if (i21 == 0) {
                        i21 = measuredWidth2;
                    }
                    z12 = z14 & (!actionMenuPresenter.f2072t ? i14 + i21 <= 0 : i14 < 0);
                }
                if (z12 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z11) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i22 = 0; i22 < i20; i22++) {
                        androidx.appcompat.view.menu.h hVar3 = arrayListH.get(i22);
                        if (hVar3.getGroupId() == groupId2) {
                            if (hVar3.o()) {
                                i18++;
                            }
                            hVar3.x(false);
                        }
                    }
                }
                if (z12) {
                    i18--;
                }
                hVar2.x(z12);
            } else {
                i11 = size;
                hVar2.x(false);
                i20++;
                view = null;
                actionMenuPresenter = this;
                size = i11;
                i12 = 0;
            }
            i20++;
            view = null;
            actionMenuPresenter = this;
            size = i11;
            i12 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void i(@g.n0 Context context, @g.p0 androidx.appcompat.view.menu.e eVar) {
        super.i(context, eVar);
        Resources resources = context.getResources();
        l.a aVarB = l.a.b(context);
        if (!this.f2067o) {
            this.f2066n = aVarB.h();
        }
        if (!this.f2073u) {
            this.f2068p = aVarB.c();
        }
        if (!this.f2071s) {
            this.f2070r = aVarB.d();
        }
        int measuredWidth = this.f2068p;
        if (this.f2066n) {
            if (this.f2063k == null) {
                d dVar = new d(this.f1868a);
                this.f2063k = dVar;
                if (this.f2065m) {
                    dVar.setImageDrawable(this.f2064l);
                    this.f2064l = null;
                    this.f2065m = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f2063k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f2063k.getMeasuredWidth();
        } else {
            this.f2063k = null;
        }
        this.f2069q = measuredWidth;
        this.f2075w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
        int i10;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof SavedState) && (i10 = ((SavedState) parcelable).f2079a) > 0 && (menuItemFindItem = this.f1870c.findItem(i10)) != null) {
            l((androidx.appcompat.view.menu.m) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.a
    public void k(androidx.appcompat.view.menu.h hVar, k.a aVar) {
        aVar.h(hVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1876i);
        if (this.B == null) {
            this.B = new b();
        }
        actionMenuItemView.setPopupCallback(this.B);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public boolean l(androidx.appcompat.view.menu.m mVar) {
        boolean z10 = false;
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.m mVar2 = mVar;
        while (mVar2.n0() != this.f1870c) {
            mVar2 = (androidx.appcompat.view.menu.m) mVar2.n0();
        }
        View viewC = C(mVar2.getItem());
        if (viewC == null) {
            return false;
        }
        this.D = mVar.getItem().getItemId();
        int size = mVar.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            MenuItem item = mVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i10++;
        }
        a aVar = new a(this.f1869b, mVar, viewC);
        this.f2078z = aVar;
        aVar.i(z10);
        this.f2078z.l();
        super.l(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public androidx.appcompat.view.menu.k m(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.k kVar = this.f1876i;
        androidx.appcompat.view.menu.k kVarM = super.m(viewGroup);
        if (kVar != kVarM) {
            ((ActionMenuView) kVarM).setPresenter(this);
        }
        return kVarM;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable n() {
        SavedState savedState = new SavedState();
        savedState.f2079a = this.D;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean p(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f2063k) {
            return false;
        }
        return super.p(viewGroup, i10);
    }

    @Override // androidx.appcompat.view.menu.a
    public View r(androidx.appcompat.view.menu.h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.m()) {
            actionView = super.r(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean t(int i10, androidx.appcompat.view.menu.h hVar) {
        return hVar.o();
    }
}

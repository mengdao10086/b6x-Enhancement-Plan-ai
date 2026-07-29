package com.google.android.material.internal;

import a1.d;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.j;
import androidx.core.view.j1;
import androidx.core.view.u0;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import g.d1;
import g.i0;
import g.n0;
import g.p0;
import g.t0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class l implements androidx.appcompat.view.menu.j {
    public static final int D = 0;
    public static final String K0 = "android:menu:adapter";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f20424k0 = "android:menu:list";

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final String f20425k1 = "android:menu:header";
    public int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NavigationMenuView f20426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f20427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j.a f20428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.appcompat.view.menu.e f20429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f20431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LayoutInflater f20432g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public ColorStateList f20434i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f20436k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f20437l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f20438m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RippleDrawable f20439n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f20440o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @t0
    public int f20441p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f20442q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20443r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @t0
    public int f20444s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @t0
    public int f20445t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @t0
    public int f20446u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @t0
    public int f20447v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f20448w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f20450y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f20451z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20433h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20435j = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f20449x = true;
    public int B = -1;
    public final View.OnClickListener C = new a();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z10 = true;
            l.this.Z(true);
            androidx.appcompat.view.menu.h itemData = ((NavigationMenuItemView) view).getItemData();
            l lVar = l.this;
            boolean zP = lVar.f20429d.P(itemData, lVar, 0);
            if (itemData != null && itemData.isCheckable() && zP) {
                l.this.f20431f.x(itemData);
            } else {
                z10 = false;
            }
            l.this.Z(false);
            if (z10) {
                l.this.c(false);
            }
        }
    }

    public static class b extends AbstractC0208l {
        public b(View view) {
            super(view);
        }
    }

    public class c extends RecyclerView.g<AbstractC0208l> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f20453e = "android:menu:checked";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f20454f = "android:menu:action_views";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f20455g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f20456h = 1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f20457i = 2;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f20458j = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<e> f20459a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.appcompat.view.menu.h f20460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f20461c;

        public class a extends androidx.core.view.a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f20463d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f20464e;

            public a(int i10, boolean z10) {
                this.f20463d = i10;
                this.f20464e = z10;
            }

            @Override // androidx.core.view.a
            public void g(@n0 View view, @n0 a1.d dVar) {
                super.g(view, dVar);
                dVar.e1(d.e.h(c.this.m(this.f20463d), 1, 1, 1, this.f20464e, view.isSelected()));
            }
        }

        public c() {
            u();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemCount() {
            return this.f20459a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public long getItemId(int i10) {
            return i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemViewType(int i10) {
            e eVar = this.f20459a.get(i10);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public final int m(int i10) {
            int i11 = i10;
            for (int i12 = 0; i12 < i10; i12++) {
                if (l.this.f20431f.getItemViewType(i12) == 2) {
                    i11--;
                }
            }
            return l.this.f20427b.getChildCount() == 0 ? i11 - 1 : i11;
        }

        public final void n(int i10, int i11) {
            while (i10 < i11) {
                ((g) this.f20459a.get(i10)).f20469b = true;
                i10++;
            }
        }

        @n0
        public Bundle o() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.h hVar = this.f20460b;
            if (hVar != null) {
                bundle.putInt(f20453e, hVar.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f20459a.size();
            for (int i10 = 0; i10 < size; i10++) {
                e eVar = this.f20459a.get(i10);
                if (eVar instanceof g) {
                    androidx.appcompat.view.menu.h hVarA = ((g) eVar).a();
                    View actionView = hVarA != null ? hVarA.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(hVarA.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray(f20454f, sparseArray);
            return bundle;
        }

        public androidx.appcompat.view.menu.h p() {
            return this.f20460b;
        }

        public int q() {
            int i10 = l.this.f20427b.getChildCount() == 0 ? 0 : 1;
            for (int i11 = 0; i11 < l.this.f20431f.getItemCount(); i11++) {
                int itemViewType = l.this.f20431f.getItemViewType(i11);
                if (itemViewType == 0 || itemViewType == 1) {
                    i10++;
                }
            }
            return i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@n0 AbstractC0208l abstractC0208l, int i10) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType == 2) {
                        f fVar = (f) this.f20459a.get(i10);
                        abstractC0208l.itemView.setPadding(l.this.f20444s, fVar.b(), l.this.f20445t, fVar.a());
                        return;
                    } else {
                        if (itemViewType != 3) {
                            return;
                        }
                        w(abstractC0208l.itemView, i10, true);
                        return;
                    }
                }
                TextView textView = (TextView) abstractC0208l.itemView;
                textView.setText(((g) this.f20459a.get(i10)).a().getTitle());
                int i11 = l.this.f20433h;
                if (i11 != 0) {
                    androidx.core.widget.r.E(textView, i11);
                }
                textView.setPadding(l.this.f20446u, textView.getPaddingTop(), l.this.f20447v, textView.getPaddingBottom());
                ColorStateList colorStateList = l.this.f20434i;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                w(textView, i10, true);
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) abstractC0208l.itemView;
            navigationMenuItemView.setIconTintList(l.this.f20437l);
            int i12 = l.this.f20435j;
            if (i12 != 0) {
                navigationMenuItemView.setTextAppearance(i12);
            }
            ColorStateList colorStateList2 = l.this.f20436k;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable = l.this.f20438m;
            u0.I1(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            RippleDrawable rippleDrawable = l.this.f20439n;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            g gVar = (g) this.f20459a.get(i10);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.f20469b);
            l lVar = l.this;
            int i13 = lVar.f20440o;
            int i14 = lVar.f20441p;
            navigationMenuItemView.setPadding(i13, i14, i13, i14);
            navigationMenuItemView.setIconPadding(l.this.f20442q);
            l lVar2 = l.this;
            if (lVar2.f20448w) {
                navigationMenuItemView.setIconSize(lVar2.f20443r);
            }
            navigationMenuItemView.setMaxLines(l.this.f20450y);
            navigationMenuItemView.h(gVar.a(), 0);
            w(navigationMenuItemView, i10, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        @p0
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public AbstractC0208l onCreateViewHolder(ViewGroup viewGroup, int i10) {
            if (i10 == 0) {
                l lVar = l.this;
                return new i(lVar.f20432g, viewGroup, lVar.C);
            }
            if (i10 == 1) {
                return new k(l.this.f20432g, viewGroup);
            }
            if (i10 == 2) {
                return new j(l.this.f20432g, viewGroup);
            }
            if (i10 != 3) {
                return null;
            }
            return new b(l.this.f20427b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(AbstractC0208l abstractC0208l) {
            if (abstractC0208l instanceof i) {
                ((NavigationMenuItemView) abstractC0208l.itemView).H();
            }
        }

        public final void u() {
            if (this.f20461c) {
                return;
            }
            this.f20461c = true;
            this.f20459a.clear();
            this.f20459a.add(new d());
            int i10 = -1;
            int size = l.this.f20429d.H().size();
            boolean z10 = false;
            int size2 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                androidx.appcompat.view.menu.h hVar = l.this.f20429d.H().get(i11);
                if (hVar.isChecked()) {
                    x(hVar);
                }
                if (hVar.isCheckable()) {
                    hVar.w(false);
                }
                if (hVar.hasSubMenu()) {
                    SubMenu subMenu = hVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i11 != 0) {
                            this.f20459a.add(new f(l.this.A, 0));
                        }
                        this.f20459a.add(new g(hVar));
                        int size3 = this.f20459a.size();
                        int size4 = subMenu.size();
                        boolean z11 = false;
                        for (int i12 = 0; i12 < size4; i12++) {
                            androidx.appcompat.view.menu.h hVar2 = (androidx.appcompat.view.menu.h) subMenu.getItem(i12);
                            if (hVar2.isVisible()) {
                                if (!z11 && hVar2.getIcon() != null) {
                                    z11 = true;
                                }
                                if (hVar2.isCheckable()) {
                                    hVar2.w(false);
                                }
                                if (hVar.isChecked()) {
                                    x(hVar);
                                }
                                this.f20459a.add(new g(hVar2));
                            }
                        }
                        if (z11) {
                            n(size3, this.f20459a.size());
                        }
                    }
                } else {
                    int groupId = hVar.getGroupId();
                    if (groupId != i10) {
                        size2 = this.f20459a.size();
                        z10 = hVar.getIcon() != null;
                        if (i11 != 0) {
                            size2++;
                            ArrayList<e> arrayList = this.f20459a;
                            int i13 = l.this.A;
                            arrayList.add(new f(i13, i13));
                        }
                    } else if (!z10 && hVar.getIcon() != null) {
                        n(size2, this.f20459a.size());
                        z10 = true;
                    }
                    g gVar = new g(hVar);
                    gVar.f20469b = z10;
                    this.f20459a.add(gVar);
                    i10 = groupId;
                }
            }
            this.f20461c = false;
        }

        public void v(@n0 Bundle bundle) {
            androidx.appcompat.view.menu.h hVarA;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.h hVarA2;
            int i10 = bundle.getInt(f20453e, 0);
            if (i10 != 0) {
                this.f20461c = true;
                int size = this.f20459a.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    e eVar = this.f20459a.get(i11);
                    if ((eVar instanceof g) && (hVarA2 = ((g) eVar).a()) != null && hVarA2.getItemId() == i10) {
                        x(hVarA2);
                        break;
                    }
                    i11++;
                }
                this.f20461c = false;
                u();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(f20454f);
            if (sparseParcelableArray != null) {
                int size2 = this.f20459a.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    e eVar2 = this.f20459a.get(i12);
                    if ((eVar2 instanceof g) && (hVarA = ((g) eVar2).a()) != null && (actionView = hVarA.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(hVarA.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public final void w(View view, int i10, boolean z10) {
            u0.B1(view, new a(i10, z10));
        }

        public void x(@n0 androidx.appcompat.view.menu.h hVar) {
            if (this.f20460b == hVar || !hVar.isCheckable()) {
                return;
            }
            androidx.appcompat.view.menu.h hVar2 = this.f20460b;
            if (hVar2 != null) {
                hVar2.setChecked(false);
            }
            this.f20460b = hVar;
            hVar.setChecked(true);
        }

        public void y(boolean z10) {
            this.f20461c = z10;
        }

        public void z() {
            u();
            notifyDataSetChanged();
        }
    }

    public static class d implements e {
    }

    public interface e {
    }

    public static class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f20467b;

        public f(int i10, int i11) {
            this.f20466a = i10;
            this.f20467b = i11;
        }

        public int a() {
            return this.f20467b;
        }

        public int b() {
            return this.f20466a;
        }
    }

    public static class g implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.appcompat.view.menu.h f20468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f20469b;

        public g(androidx.appcompat.view.menu.h hVar) {
            this.f20468a = hVar;
        }

        public androidx.appcompat.view.menu.h a() {
            return this.f20468a;
        }
    }

    public class h extends androidx.recyclerview.widget.y {
        public h(@n0 RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.y, androidx.core.view.a
        public void g(View view, @n0 a1.d dVar) {
            super.g(view, dVar);
            dVar.d1(d.C0006d.e(l.this.f20431f.q(), 1, false));
        }
    }

    public static class i extends AbstractC0208l {
        public i(@n0 LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    public static class j extends AbstractC0208l {
        public j(@n0 LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    public static class k extends AbstractC0208l {
        public k(@n0 LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.l$l, reason: collision with other inner class name */
    public static abstract class AbstractC0208l extends RecyclerView.e0 {
        public AbstractC0208l(View view) {
            super(view);
        }
    }

    @t0
    public int A() {
        return this.f20447v;
    }

    @t0
    public int B() {
        return this.f20446u;
    }

    public View C(@i0 int i10) {
        View viewInflate = this.f20432g.inflate(i10, (ViewGroup) this.f20427b, false);
        d(viewInflate);
        return viewInflate;
    }

    public boolean D() {
        return this.f20449x;
    }

    public void E(@n0 View view) {
        this.f20427b.removeView(view);
        if (this.f20427b.getChildCount() == 0) {
            NavigationMenuView navigationMenuView = this.f20426a;
            navigationMenuView.setPadding(0, this.f20451z, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public void F(boolean z10) {
        if (this.f20449x != z10) {
            this.f20449x = z10;
            a0();
        }
    }

    public void G(@n0 androidx.appcompat.view.menu.h hVar) {
        this.f20431f.x(hVar);
    }

    public void H(@t0 int i10) {
        this.f20445t = i10;
        c(false);
    }

    public void I(@t0 int i10) {
        this.f20444s = i10;
        c(false);
    }

    public void J(int i10) {
        this.f20430e = i10;
    }

    public void K(@p0 Drawable drawable) {
        this.f20438m = drawable;
        c(false);
    }

    public void L(@p0 RippleDrawable rippleDrawable) {
        this.f20439n = rippleDrawable;
        c(false);
    }

    public void M(int i10) {
        this.f20440o = i10;
        c(false);
    }

    public void N(int i10) {
        this.f20442q = i10;
        c(false);
    }

    public void O(@g.r int i10) {
        if (this.f20443r != i10) {
            this.f20443r = i10;
            this.f20448w = true;
            c(false);
        }
    }

    public void P(@p0 ColorStateList colorStateList) {
        this.f20437l = colorStateList;
        c(false);
    }

    public void Q(int i10) {
        this.f20450y = i10;
        c(false);
    }

    public void R(@d1 int i10) {
        this.f20435j = i10;
        c(false);
    }

    public void S(@p0 ColorStateList colorStateList) {
        this.f20436k = colorStateList;
        c(false);
    }

    public void T(@t0 int i10) {
        this.f20441p = i10;
        c(false);
    }

    public void U(int i10) {
        this.B = i10;
        NavigationMenuView navigationMenuView = this.f20426a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i10);
        }
    }

    public void V(@p0 ColorStateList colorStateList) {
        this.f20434i = colorStateList;
        c(false);
    }

    public void W(@t0 int i10) {
        this.f20447v = i10;
        c(false);
    }

    public void X(@t0 int i10) {
        this.f20446u = i10;
        c(false);
    }

    public void Y(@d1 int i10) {
        this.f20433h = i10;
        c(false);
    }

    public void Z(boolean z10) {
        c cVar = this.f20431f;
        if (cVar != null) {
            cVar.y(z10);
        }
    }

    public final void a0() {
        int i10 = (this.f20427b.getChildCount() == 0 && this.f20449x) ? this.f20451z : 0;
        NavigationMenuView navigationMenuView = this.f20426a;
        navigationMenuView.setPadding(0, i10, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(androidx.appcompat.view.menu.e eVar, boolean z10) {
        j.a aVar = this.f20428c;
        if (aVar != null) {
            aVar.b(eVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(boolean z10) {
        c cVar = this.f20431f;
        if (cVar != null) {
            cVar.z();
        }
    }

    public void d(@n0 View view) {
        this.f20427b.addView(view);
        NavigationMenuView navigationMenuView = this.f20426a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean f(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public int getId() {
        return this.f20430e;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f20428c = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(@n0 Context context, @n0 androidx.appcompat.view.menu.e eVar) {
        this.f20432g = LayoutInflater.from(context);
        this.f20429d = eVar;
        this.A = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f20426a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle(K0);
            if (bundle2 != null) {
                this.f20431f.v(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray(f20425k1);
            if (sparseParcelableArray2 != null) {
                this.f20427b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public void k(@n0 j1 j1Var) {
        int iR = j1Var.r();
        if (this.f20451z != iR) {
            this.f20451z = iR;
            a0();
        }
        NavigationMenuView navigationMenuView = this.f20426a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, j1Var.o());
        u0.p(this.f20427b, j1Var);
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean l(androidx.appcompat.view.menu.m mVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public androidx.appcompat.view.menu.k m(ViewGroup viewGroup) {
        if (this.f20426a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f20432g.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.f20426a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.f20426a));
            if (this.f20431f == null) {
                this.f20431f = new c();
            }
            int i10 = this.B;
            if (i10 != -1) {
                this.f20426a.setOverScrollMode(i10);
            }
            this.f20427b = (LinearLayout) this.f20432g.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.f20426a, false);
            this.f20426a.setAdapter(this.f20431f);
        }
        return this.f20426a;
    }

    @Override // androidx.appcompat.view.menu.j
    @n0
    public Parcelable n() {
        Bundle bundle = new Bundle();
        if (this.f20426a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f20426a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f20431f;
        if (cVar != null) {
            bundle.putBundle(K0, cVar.o());
        }
        if (this.f20427b != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.f20427b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray(f20425k1, sparseArray2);
        }
        return bundle;
    }

    @p0
    public androidx.appcompat.view.menu.h o() {
        return this.f20431f.p();
    }

    @t0
    public int p() {
        return this.f20445t;
    }

    @t0
    public int q() {
        return this.f20444s;
    }

    public int r() {
        return this.f20427b.getChildCount();
    }

    public View s(int i10) {
        return this.f20427b.getChildAt(i10);
    }

    @p0
    public Drawable t() {
        return this.f20438m;
    }

    public int u() {
        return this.f20440o;
    }

    public int v() {
        return this.f20442q;
    }

    public int w() {
        return this.f20450y;
    }

    @p0
    public ColorStateList x() {
        return this.f20436k;
    }

    @p0
    public ColorStateList y() {
        return this.f20437l;
    }

    @t0
    public int z() {
        return this.f20441p;
    }
}

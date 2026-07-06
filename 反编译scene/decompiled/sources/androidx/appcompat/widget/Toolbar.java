package androidx.appcompat.widget;

import a.ak;
import a.bg;
import a.c0;
import a.c5;
import a.d0;
import a.d7;
import a.eg;
import a.eh;
import a.f8;
import a.i4;
import a.l3;
import a.l4;
import a.n5;
import a.o8;
import a.p8;
import a.r2;
import a.s3;
import a.s8;
import a.t;
import a.v4;
import a.w6;
import a.y5;
import a.z8;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class Toolbar extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f8 f4104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i4.a f4105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public n5 f4106a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public s8 f4107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public v4.a f4108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f4109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f4110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f4111a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f4112a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageButton f4113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f4114a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f4115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ActionMenuView.e f4116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionMenuView f4117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f4118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f4119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f4120a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f4121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<View> f4122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f4123a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ColorStateList f4124b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ImageButton f4125b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TextView f4126b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f4127b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<View> f4128b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4129b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public CharSequence f4130c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4131c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4132d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public class a implements ActionMenuView.e {
        public a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            f fVar = Toolbar.this.f4119a;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.O();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    public class d implements v4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i4 f8178a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public l4 f4133a;

        public d() {
        }

        @Override // a.v4
        public void b(i4 i4Var, boolean z) {
        }

        @Override // a.v4
        public boolean d(i4 i4Var, l4 l4Var) {
            KeyEvent.Callback callback = Toolbar.this.f4112a;
            if (callback instanceof l3) {
                ((l3) callback).b();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f4112a);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f4125b);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f4112a = null;
            toolbar3.a();
            this.f4133a = null;
            Toolbar.this.requestLayout();
            l4Var.t(false);
            return true;
        }

        @Override // a.v4
        public void f(Context context, i4 i4Var) {
            l4 l4Var;
            i4 i4Var2 = this.f8178a;
            if (i4Var2 != null && (l4Var = this.f4133a) != null) {
                i4Var2.f(l4Var);
            }
            this.f8178a = i4Var;
        }

        @Override // a.v4
        public void g(v4.a aVar) {
        }

        @Override // a.v4
        public boolean h() {
            return false;
        }

        @Override // a.v4
        public void i(boolean z) {
            if (this.f4133a != null) {
                i4 i4Var = this.f8178a;
                boolean z2 = false;
                if (i4Var != null) {
                    int size = i4Var.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        if (this.f8178a.getItem(i) == this.f4133a) {
                            z2 = true;
                            break;
                        }
                        i++;
                    }
                }
                if (z2) {
                    return;
                }
                d(this.f8178a, this.f4133a);
            }
        }

        @Override // a.v4
        public boolean j(c5 c5Var) {
            return false;
        }

        @Override // a.v4
        public boolean k(i4 i4Var, l4 l4Var) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f4125b.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f4125b);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f4125b);
            }
            Toolbar.this.f4112a = l4Var.getActionView();
            this.f4133a = l4Var;
            ViewParent parent2 = Toolbar.this.f4112a.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f4112a);
                }
                e eVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                eVarGenerateDefaultLayoutParams.f5842a = 8388611 | (toolbar4.d & 112);
                eVarGenerateDefaultLayoutParams.b = 2;
                toolbar4.f4112a.setLayoutParams(eVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f4112a);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            l4Var.t(true);
            KeyEvent.Callback callback = Toolbar.this.f4112a;
            if (callback instanceof l3) {
                ((l3) callback).f();
            }
            return true;
        }
    }

    public static class e extends d0.a {
        public int b;

        public e(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.f5842a = 8388627;
        }

        public e(d0.a aVar) {
            super(aVar);
            this.b = 0;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        public e(e eVar) {
            super((d0.a) eVar);
            this.b = 0;
            this.b = eVar.b;
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class g extends ak {
        public static final Parcelable.Creator<g> CREATOR = new p8();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8179a;
        public boolean b;

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8179a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // a.ak, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f8179a);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = 8388627;
        this.f4122a = new ArrayList<>();
        this.f4128b = new ArrayList<>();
        this.f4123a = new int[2];
        this.f4116a = new a();
        this.f4121a = new b();
        o8 o8VarV = o8.v(getContext(), attributeSet, c0.Toolbar, i, 0);
        eh.i0(this, context, c0.Toolbar, attributeSet, o8VarV.r(), i, 0);
        this.b = o8VarV.n(c0.Toolbar_titleTextAppearance, 0);
        this.c = o8VarV.n(c0.Toolbar_subtitleTextAppearance, 0);
        this.l = o8VarV.l(c0.Toolbar_android_gravity, this.l);
        this.d = o8VarV.l(c0.Toolbar_buttonGravity, 48);
        int iE = o8VarV.e(c0.Toolbar_titleMargin, 0);
        iE = o8VarV.s(c0.Toolbar_titleMargins) ? o8VarV.e(c0.Toolbar_titleMargins, iE) : iE;
        this.i = iE;
        this.h = iE;
        this.g = iE;
        this.f = iE;
        int iE2 = o8VarV.e(c0.Toolbar_titleMarginStart, -1);
        if (iE2 >= 0) {
            this.f = iE2;
        }
        int iE3 = o8VarV.e(c0.Toolbar_titleMarginEnd, -1);
        if (iE3 >= 0) {
            this.g = iE3;
        }
        int iE4 = o8VarV.e(c0.Toolbar_titleMarginTop, -1);
        if (iE4 >= 0) {
            this.h = iE4;
        }
        int iE5 = o8VarV.e(c0.Toolbar_titleMarginBottom, -1);
        if (iE5 >= 0) {
            this.i = iE5;
        }
        this.e = o8VarV.f(c0.Toolbar_maxButtonHeight, -1);
        int iE6 = o8VarV.e(c0.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iE7 = o8VarV.e(c0.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iF = o8VarV.f(c0.Toolbar_contentInsetLeft, 0);
        int iF2 = o8VarV.f(c0.Toolbar_contentInsetRight, 0);
        h();
        this.f4104a.e(iF, iF2);
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            this.f4104a.g(iE6, iE7);
        }
        this.j = o8VarV.e(c0.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.k = o8VarV.e(c0.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f4111a = o8VarV.g(c0.Toolbar_collapseIcon);
        this.f4120a = o8VarV.p(c0.Toolbar_collapseContentDescription);
        CharSequence charSequenceP = o8VarV.p(c0.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceP)) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceP2 = o8VarV.p(c0.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceP2)) {
            setSubtitle(charSequenceP2);
        }
        this.f4109a = getContext();
        setPopupTheme(o8VarV.n(c0.Toolbar_popupTheme, 0));
        Drawable drawableG = o8VarV.g(c0.Toolbar_navigationIcon);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceP3 = o8VarV.p(c0.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceP3)) {
            setNavigationContentDescription(charSequenceP3);
        }
        Drawable drawableG2 = o8VarV.g(c0.Toolbar_logo);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceP4 = o8VarV.p(c0.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceP4)) {
            setLogoDescription(charSequenceP4);
        }
        if (o8VarV.s(c0.Toolbar_titleTextColor)) {
            setTitleTextColor(o8VarV.c(c0.Toolbar_titleTextColor));
        }
        if (o8VarV.s(c0.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(o8VarV.c(c0.Toolbar_subtitleTextColor));
        }
        if (o8VarV.s(c0.Toolbar_menu)) {
            x(o8VarV.n(c0.Toolbar_menu, 0));
        }
        o8VarV.w();
    }

    private MenuInflater getMenuInflater() {
        return new s3(getContext());
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f4117a;
        return actionMenuView != null && actionMenuView.J();
    }

    public final int B(View view, int i, int[] iArr, int i2) {
        e eVar = (e) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int iMax = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int iQ = q(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iQ, iMax + measuredWidth, view.getMeasuredHeight() + iQ);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    public final int C(View view, int i, int[] iArr, int i2) {
        e eVar = (e) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iQ = q(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iQ, iMax, view.getMeasuredHeight() + iQ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    public final int D(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void E(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final void F() {
        removeCallbacks(this.f4121a);
        post(this.f4121a);
    }

    public void G() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((e) childAt.getLayoutParams()).b != 2 && childAt != this.f4117a) {
                removeViewAt(childCount);
                this.f4128b.add(childAt);
            }
        }
    }

    public void H(int i, int i2) {
        h();
        this.f4104a.g(i, i2);
    }

    public void I(i4 i4Var, n5 n5Var) {
        if (i4Var == null && this.f4117a == null) {
            return;
        }
        k();
        i4 i4VarN = this.f4117a.N();
        if (i4VarN == i4Var) {
            return;
        }
        if (i4VarN != null) {
            i4VarN.O(this.f4106a);
            i4VarN.O(this.f4118a);
        }
        if (this.f4118a == null) {
            this.f4118a = new d();
        }
        n5Var.G(true);
        if (i4Var != null) {
            i4Var.c(n5Var, this.f4109a);
            i4Var.c(this.f4118a, this.f4109a);
        } else {
            n5Var.f(this.f4109a, null);
            this.f4118a.f(this.f4109a, null);
            n5Var.i(true);
            this.f4118a.i(true);
        }
        this.f4117a.setPopupTheme(this.f8174a);
        this.f4117a.setPresenter(n5Var);
        this.f4106a = n5Var;
    }

    public void J(v4.a aVar, i4.a aVar2) {
        this.f4108a = aVar;
        this.f4105a = aVar2;
        ActionMenuView actionMenuView = this.f4117a;
        if (actionMenuView != null) {
            actionMenuView.O(aVar, aVar2);
        }
    }

    public void K(Context context, int i) {
        this.c = i;
        TextView textView = this.f4126b;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void L(Context context, int i) {
        this.b = i;
        TextView textView = this.f4115a;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public final boolean M() {
        if (!this.f4132d) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (N(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean N(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public boolean O() {
        ActionMenuView actionMenuView = this.f4117a;
        return actionMenuView != null && actionMenuView.P();
    }

    public void a() {
        for (int size = this.f4128b.size() - 1; size >= 0; size--) {
            addView(this.f4128b.get(size));
        }
        this.f4128b.clear();
    }

    public final void b(List<View> list, int i) {
        boolean z = eh.y(this) == 1;
        int childCount = getChildCount();
        int iB = bg.b(i, eh.y(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b == 0 && N(childAt) && p(eVar.f5842a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.b == 0 && N(childAt2) && p(eVar2.f5842a) == iB) {
                list.add(childAt2);
            }
        }
    }

    public final void c(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e eVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        eVarGenerateDefaultLayoutParams.b = 1;
        if (!z || this.f4112a == null) {
            addView(view, eVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(eVarGenerateDefaultLayoutParams);
            this.f4128b.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f4117a) != null && actionMenuView.K();
    }

    public void e() {
        d dVar = this.f4118a;
        l4 l4Var = dVar == null ? null : dVar.f4133a;
        if (l4Var != null) {
            l4Var.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f4117a;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    public void g() {
        if (this.f4125b == null) {
            y5 y5Var = new y5(getContext(), null, t.toolbarNavigationButtonStyle);
            this.f4125b = y5Var;
            y5Var.setImageDrawable(this.f4111a);
            this.f4125b.setContentDescription(this.f4120a);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.f5842a = 8388611 | (this.d & 112);
            eVarGenerateDefaultLayoutParams.b = 2;
            this.f4125b.setLayoutParams(eVarGenerateDefaultLayoutParams);
            this.f4125b.setOnClickListener(new c());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f4125b;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f4125b;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        f8 f8Var = this.f4104a;
        if (f8Var != null) {
            return f8Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.k;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        f8 f8Var = this.f4104a;
        if (f8Var != null) {
            return f8Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        f8 f8Var = this.f4104a;
        if (f8Var != null) {
            return f8Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        f8 f8Var = this.f4104a;
        if (f8Var != null) {
            return f8Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.j;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        i4 i4VarN;
        ActionMenuView actionMenuView = this.f4117a;
        return actionMenuView != null && (i4VarN = actionMenuView.N()) != null && i4VarN.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.k, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return eh.y(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return eh.y(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.j, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f4114a;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f4114a;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f4117a.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f4113a;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f4113a;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public n5 getOuterActionMenuPresenter() {
        return this.f4106a;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f4117a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f4109a;
    }

    public int getPopupTheme() {
        return this.f8174a;
    }

    public CharSequence getSubtitle() {
        return this.f4130c;
    }

    public final TextView getSubtitleTextView() {
        return this.f4126b;
    }

    public CharSequence getTitle() {
        return this.f4127b;
    }

    public int getTitleMarginBottom() {
        return this.i;
    }

    public int getTitleMarginEnd() {
        return this.g;
    }

    public int getTitleMarginStart() {
        return this.f;
    }

    public int getTitleMarginTop() {
        return this.h;
    }

    public final TextView getTitleTextView() {
        return this.f4115a;
    }

    public d7 getWrapper() {
        if (this.f4107a == null) {
            this.f4107a = new s8(this, true);
        }
        return this.f4107a;
    }

    public final void h() {
        if (this.f4104a == null) {
            this.f4104a = new f8();
        }
    }

    public final void i() {
        if (this.f4114a == null) {
            this.f4114a = new AppCompatImageView(getContext());
        }
    }

    public final void j() {
        k();
        if (this.f4117a.N() == null) {
            i4 i4Var = (i4) this.f4117a.getMenu();
            if (this.f4118a == null) {
                this.f4118a = new d();
            }
            this.f4117a.setExpandedActionViewsExclusive(true);
            i4Var.c(this.f4118a, this.f4109a);
        }
    }

    public final void k() {
        if (this.f4117a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f4117a = actionMenuView;
            actionMenuView.setPopupTheme(this.f8174a);
            this.f4117a.setOnMenuItemClickListener(this.f4116a);
            this.f4117a.O(this.f4108a, this.f4105a);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.f5842a = 8388613 | (this.d & 112);
            this.f4117a.setLayoutParams(eVarGenerateDefaultLayoutParams);
            c(this.f4117a, false);
        }
    }

    public final void l() {
        if (this.f4113a == null) {
            this.f4113a = new y5(getContext(), null, t.toolbarNavigationButtonStyle);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.f5842a = 8388611 | (this.d & 112);
            this.f4113a.setLayoutParams(eVarGenerateDefaultLayoutParams);
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof d0.a ? new e((d0.a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f4121a);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f4131c = false;
        }
        if (!this.f4131c) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f4131c = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f4131c = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0299 A[LOOP:0: B:109:0x0297->B:110:0x0299, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02bb A[LOOP:1: B:112:0x02b9->B:113:0x02bb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02f4 A[LOOP:2: B:121:0x02f2->B:122:0x02f4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x021f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 777
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        char c2;
        char c3;
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int measuredHeight;
        int iCombineMeasuredStates2;
        int iMax2;
        int[] iArr = this.f4123a;
        if (z8.b(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c2 = 1;
            c3 = 0;
        }
        if (N(this.f4113a)) {
            E(this.f4113a, i, 0, i2, 0, this.e);
            measuredWidth = this.f4113a.getMeasuredWidth() + s(this.f4113a);
            iMax = Math.max(0, this.f4113a.getMeasuredHeight() + t(this.f4113a));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f4113a.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (N(this.f4125b)) {
            E(this.f4125b, i, 0, i2, 0, this.e);
            measuredWidth = this.f4125b.getMeasuredWidth() + s(this.f4125b);
            iMax = Math.max(iMax, this.f4125b.getMeasuredHeight() + t(this.f4125b));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f4125b.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = 0 + Math.max(currentContentInsetStart, measuredWidth);
        iArr[c3] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (N(this.f4117a)) {
            E(this.f4117a, i, iMax3, i2, 0, this.e);
            measuredWidth2 = this.f4117a.getMeasuredWidth() + s(this.f4117a);
            iMax = Math.max(iMax, this.f4117a.getMeasuredHeight() + t(this.f4117a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f4117a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[c2] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (N(this.f4112a)) {
            iMax4 += D(this.f4112a, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.f4112a.getMeasuredHeight() + t(this.f4112a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f4112a.getMeasuredState());
        }
        if (N(this.f4114a)) {
            iMax4 += D(this.f4114a, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.f4114a.getMeasuredHeight() + t(this.f4114a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f4114a.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (((e) childAt.getLayoutParams()).b == 0 && N(childAt)) {
                iMax4 += D(childAt, i, iMax4, i2, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + t(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i4 = this.h + this.i;
        int i5 = this.f + this.g;
        if (N(this.f4115a)) {
            D(this.f4115a, i, iMax4 + i5, i2, i4, iArr);
            int measuredWidth3 = this.f4115a.getMeasuredWidth() + s(this.f4115a);
            measuredHeight = this.f4115a.getMeasuredHeight() + t(this.f4115a);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f4115a.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (N(this.f4126b)) {
            iMax2 = Math.max(iMax2, D(this.f4126b, i, iMax4 + i5, i2, measuredHeight + i4, iArr));
            measuredHeight += this.f4126b.getMeasuredHeight() + t(this.f4126b);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f4126b.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2), M() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.q());
        ActionMenuView actionMenuView = this.f4117a;
        i4 i4VarN = actionMenuView != null ? actionMenuView.N() : null;
        int i = gVar.f8179a;
        if (i != 0 && this.f4118a != null && i4VarN != null && (menuItemFindItem = i4VarN.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (gVar.b) {
            F();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        h();
        this.f4104a.f(i == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        l4 l4Var;
        g gVar = new g(super.onSaveInstanceState());
        d dVar = this.f4118a;
        if (dVar != null && (l4Var = dVar.f4133a) != null) {
            gVar.f8179a = l4Var.getItemId();
        }
        gVar.b = A();
        return gVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f4129b = false;
        }
        if (!this.f4129b) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f4129b = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f4129b = false;
        }
        return true;
    }

    public final int p(int i) {
        int iY = eh.y(this);
        int iB = bg.b(i, iY) & 7;
        return (iB == 1 || iB == 3 || iB == 5) ? iB : iY == 1 ? 5 : 3;
    }

    public final int q(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int iR = r(eVar.f5842a);
        if (iR == 48) {
            return getPaddingTop() - i2;
        }
        if (iR == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i3 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (iMax < i3) {
            iMax = i3;
        } else {
            int i4 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i5 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i4 < i5) {
                iMax = Math.max(0, iMax - (i5 - i4));
            }
        }
        return paddingTop + iMax;
    }

    public final int r(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.l & 112;
    }

    public final int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return eg.b(marginLayoutParams) + eg.a(marginLayoutParams);
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f4125b;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(r2.d(getContext(), i));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f4125b.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f4125b;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f4111a);
            }
        }
    }

    public void setCollapsible(boolean z) {
        this.f4132d = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.k) {
            this.k = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.j) {
            this.j = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(r2.d(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!y(this.f4114a)) {
                c(this.f4114a, true);
            }
        } else {
            ImageView imageView = this.f4114a;
            if (imageView != null && y(imageView)) {
                removeView(this.f4114a);
                this.f4128b.remove(this.f4114a);
            }
        }
        ImageView imageView2 = this.f4114a;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f4114a;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f4113a;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(r2.d(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!y(this.f4113a)) {
                c(this.f4113a, true);
            }
        } else {
            ImageButton imageButton = this.f4113a;
            if (imageButton != null && y(imageButton)) {
                removeView(this.f4113a);
                this.f4128b.remove(this.f4113a);
            }
        }
        ImageButton imageButton2 = this.f4113a;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f4113a.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.f4119a = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f4117a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f8174a != i) {
            this.f8174a = i;
            if (i == 0) {
                this.f4109a = getContext();
            } else {
                this.f4109a = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f4126b;
            if (textView != null && y(textView)) {
                removeView(this.f4126b);
                this.f4128b.remove(this.f4126b);
            }
        } else {
            if (this.f4126b == null) {
                Context context = getContext();
                w6 w6Var = new w6(context);
                this.f4126b = w6Var;
                w6Var.setSingleLine();
                this.f4126b.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.c;
                if (i != 0) {
                    this.f4126b.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f4124b;
                if (colorStateList != null) {
                    this.f4126b.setTextColor(colorStateList);
                }
            }
            if (!y(this.f4126b)) {
                c(this.f4126b, true);
            }
        }
        TextView textView2 = this.f4126b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f4130c = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f4124b = colorStateList;
        TextView textView = this.f4126b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f4115a;
            if (textView != null && y(textView)) {
                removeView(this.f4115a);
                this.f4128b.remove(this.f4115a);
            }
        } else {
            if (this.f4115a == null) {
                Context context = getContext();
                w6 w6Var = new w6(context);
                this.f4115a = w6Var;
                w6Var.setSingleLine();
                this.f4115a.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.b;
                if (i != 0) {
                    this.f4115a.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f4110a;
                if (colorStateList != null) {
                    this.f4115a.setTextColor(colorStateList);
                }
            }
            if (!y(this.f4115a)) {
                c(this.f4115a, true);
            }
        }
        TextView textView2 = this.f4115a;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f4127b = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.i = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.g = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.h = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f4110a = colorStateList;
        TextView textView = this.f4115a;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public final int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final int u(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int measuredWidth = 0;
        while (i3 < size) {
            View view = list.get(i3);
            e eVar = (e) view.getLayoutParams();
            int i4 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i;
            int i5 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i2;
            int iMax = Math.max(0, i4);
            int iMax2 = Math.max(0, i5);
            int iMax3 = Math.max(0, -i4);
            int iMax4 = Math.max(0, -i5);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i3++;
            i2 = iMax4;
            i = iMax3;
        }
        return measuredWidth;
    }

    public boolean v() {
        d dVar = this.f4118a;
        return (dVar == null || dVar.f4133a == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f4117a;
        return actionMenuView != null && actionMenuView.H();
    }

    public void x(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public final boolean y(View view) {
        return view.getParent() == this || this.f4128b.contains(view);
    }

    public boolean z() {
        ActionMenuView actionMenuView = this.f4117a;
        return actionMenuView != null && actionMenuView.I();
    }
}

package com.google.android.material.textfield;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.j0;
import androidx.core.view.u0;
import g.i0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class v extends androidx.appcompat.widget.d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f21031l = 15;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final j0 f21032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final AccessibilityManager f21033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final Rect f21034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @i0
    public final int f21035h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f21036i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f21037j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public ColorStateList f21038k;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            v vVar = v.this;
            v.this.j(i10 < 0 ? vVar.f21032e.C() : vVar.getAdapter().getItem(i10));
            AdapterView.OnItemClickListener onItemClickListener = v.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i10 < 0) {
                    view = v.this.f21032e.F();
                    i10 = v.this.f21032e.E();
                    j10 = v.this.f21032e.D();
                }
                onItemClickListener.onItemClick(v.this.f21032e.k(), view, i10, j10);
            }
            v.this.f21032e.dismiss();
        }
    }

    public class b<T> extends ArrayAdapter<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public ColorStateList f21040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public ColorStateList f21041b;

        public b(@n0 Context context, int i10, @n0 String[] strArr) {
            super(context, i10, strArr);
            f();
        }

        @p0
        public final ColorStateList a() {
            if (!c() || !d()) {
                return null;
            }
            int[] iArr = {R.attr.state_hovered, -16842919};
            int[] iArr2 = {R.attr.state_selected, -16842919};
            return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{vd.m.m(v.this.f21037j, v.this.f21038k.getColorForState(iArr2, 0)), vd.m.m(v.this.f21037j, v.this.f21038k.getColorForState(iArr, 0)), v.this.f21037j});
        }

        @p0
        public final Drawable b() {
            if (!c()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(v.this.f21037j);
            if (this.f21041b == null) {
                return colorDrawable;
            }
            n0.c.o(colorDrawable, this.f21040a);
            return new RippleDrawable(this.f21041b, colorDrawable, null);
        }

        public final boolean c() {
            return v.this.f21037j != 0;
        }

        public final boolean d() {
            return v.this.f21038k != null;
        }

        public final ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {R.attr.state_pressed};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{v.this.f21038k.getColorForState(iArr, 0), 0});
        }

        public void f() {
            this.f21041b = e();
            this.f21040a = a();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, @p0 View view, ViewGroup viewGroup) {
            View view2 = super.getView(i10, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                u0.I1(textView, v.this.getText().toString().contentEquals(textView.getText()) ? b() : null);
            }
            return view2;
        }
    }

    public v(@n0 Context context) {
        this(context, null);
    }

    @p0
    public final TextInputLayout g() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView
    @p0
    public CharSequence getHint() {
        TextInputLayout textInputLayoutG = g();
        return (textInputLayoutG == null || !textInputLayoutG.a0()) ? super.getHint() : textInputLayoutG.getHint();
    }

    public float getPopupElevation() {
        return this.f21036i;
    }

    public int getSimpleItemSelectedColor() {
        return this.f21037j;
    }

    @p0
    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f21038k;
    }

    public final int h() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutG = g();
        int i10 = 0;
        if (adapter == null || textInputLayoutG == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f21032e.E()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutG);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable drawableI = this.f21032e.i();
        if (drawableI != null) {
            drawableI.getPadding(this.f21034g);
            Rect rect = this.f21034g;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutG.getEndIconView().getMeasuredWidth();
    }

    public final void i() {
        TextInputLayout textInputLayoutG = g();
        if (textInputLayoutG != null) {
            textInputLayoutG.H0();
        }
    }

    public final <T extends ListAdapter & Filterable> void j(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutG = g();
        if (textInputLayoutG != null && textInputLayoutG.a0() && super.getHint() == null && com.google.android.material.internal.i.c()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), h()), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@p0 T t10) {
        super.setAdapter(t10);
        this.f21032e.q(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(@p0 AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f21032e.g0(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i10) {
        super.setRawInputType(i10);
        i();
    }

    public void setSimpleItemSelectedColor(int i10) {
        this.f21037j = i10;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(@p0 ColorStateList colorStateList) {
        this.f21038k = colorStateList;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItems(@g.e int i10) {
        setSimpleItems(getResources().getStringArray(i10));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f21033f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f21032e.a();
        }
    }

    public v(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.autoCompleteTextViewStyle);
    }

    public void setSimpleItems(@n0 String[] strArr) {
        setAdapter(new b(getContext(), this.f21035h, strArr));
    }

    public v(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(pe.a.c(context, attributeSet, i10, 0), attributeSet, i10);
        this.f21034g = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayK = com.google.android.material.internal.t.k(context2, attributeSet, com.google.android.material.R.styleable.MaterialAutoCompleteTextView, i10, com.google.android.material.R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i11 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_inputType;
        if (typedArrayK.hasValue(i11) && typedArrayK.getInt(i11, 0) == 0) {
            setKeyListener(null);
        }
        this.f21035h = typedArrayK.getResourceId(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemLayout, com.google.android.material.R.layout.mtrl_auto_complete_simple_item);
        this.f21036i = typedArrayK.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_popupElevation, com.google.android.material.R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        this.f21037j = typedArrayK.getColor(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.f21038k = ie.c.a(context2, typedArrayK, com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.f21033f = (AccessibilityManager) context2.getSystemService("accessibility");
        j0 j0Var = new j0(context2);
        this.f21032e = j0Var;
        j0Var.d0(true);
        j0Var.S(this);
        j0Var.a0(2);
        j0Var.q(getAdapter());
        j0Var.f0(new a());
        int i12 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItems;
        if (typedArrayK.hasValue(i12)) {
            setSimpleItems(typedArrayK.getResourceId(i12, 0));
        }
        typedArrayK.recycle();
    }
}

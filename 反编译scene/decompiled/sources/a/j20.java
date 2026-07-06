package a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Filterable;
import android.widget.ListAdapter;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j20 extends o5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t7 f6465a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f1494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AccessibilityManager f1495a;

    public j20(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, zu.autoCompleteTextViewStyle);
    }

    public j20(Context context, AttributeSet attributeSet, int i) {
        super(r20.c(context, attributeSet, i, 0), attributeSet, i);
        this.f1494a = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayH = dy.h(context2, attributeSet, jv.MaterialAutoCompleteTextView, i, iv.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayH.hasValue(jv.MaterialAutoCompleteTextView_android_inputType) && typedArrayH.getInt(jv.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.f1495a = (AccessibilityManager) context2.getSystemService("accessibility");
        t7 t7Var = new t7(context2);
        this.f6465a = t7Var;
        t7Var.J(true);
        this.f6465a.D(this);
        this.f6465a.I(2);
        this.f6465a.n(getAdapter());
        this.f6465a.L(new i20(this));
        typedArrayH.recycle();
    }

    public final TextInputLayout c() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final int d() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutC = c();
        int i = 0;
        if (adapter == null || textInputLayoutC == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f6465a.x()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutC);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable drawableG = this.f6465a.g();
        if (drawableG != null) {
            drawableG.getPadding(this.f1494a);
            Rect rect = this.f1494a;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutC.getEndIconView().getMeasuredWidth();
    }

    public final <T extends ListAdapter & Filterable> void e(Object obj) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(obj), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(obj));
        setAdapter(adapter);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutC = c();
        return (textInputLayoutC == null || !textInputLayoutC.N()) ? super.getHint() : textInputLayoutC.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutC = c();
        if (textInputLayoutC != null && textInputLayoutC.N() && super.getHint() == null && ux.a()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), d()), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.f6465a.n(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager;
        if (getInputType() == 0 && (accessibilityManager = this.f1495a) != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.f6465a.c();
        } else {
            super.showDropDown();
        }
    }
}

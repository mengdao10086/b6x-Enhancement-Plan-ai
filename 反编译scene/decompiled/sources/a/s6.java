package a;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class s6 extends Spinner implements qg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f7365a = {R.attr.spinnerMode};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l7 f2841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final p5 f2842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public r6 f2843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2844a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f2845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SpinnerAdapter f2846a;
    public final boolean b;

    public s6(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.spinnerStyle);
    }

    public s6(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public s6(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f A[PHI: r10 r11
  0x004f: PHI (r10v2 int) = (r10v0 int), (r10v4 int) binds: [B:25:0x0060, B:16:0x004d] A[DONT_GENERATE, DONT_INLINE]
  0x004f: PHI (r11v6 android.content.res.TypedArray) = (r11v5 android.content.res.TypedArray), (r11v8 android.content.res.TypedArray) binds: [B:25:0x0060, B:16:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public s6(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.s6.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.f2845a);
        Rect rect = this.f2845a;
        return iMax2 + rect.left + rect.right;
    }

    public void b() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f2843a.p(getTextDirection(), getTextAlignment());
        } else {
            this.f2843a.p(-1, -1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        p5 p5Var = this.f2842a;
        if (p5Var != null) {
            p5Var.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        r6 r6Var = this.f2843a;
        if (r6Var != null) {
            return r6Var.i();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        r6 r6Var = this.f2843a;
        if (r6Var != null) {
            return r6Var.k();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f2843a != null) {
            return this.f2840a;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public final r6 getInternalPopup() {
        return this.f2843a;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        r6 r6Var = this.f2843a;
        if (r6Var != null) {
            return r6Var.g();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f2844a;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        r6 r6Var = this.f2843a;
        return r6Var != null ? r6Var.o() : super.getPrompt();
    }

    @Override // a.qg
    public ColorStateList getSupportBackgroundTintList() {
        p5 p5Var = this.f2842a;
        if (p5Var != null) {
            return p5Var.c();
        }
        return null;
    }

    @Override // a.qg
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        p5 p5Var = this.f2842a;
        if (p5Var != null) {
            return p5Var.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r6 r6Var = this.f2843a;
        if (r6Var == null || !r6Var.a()) {
            return;
        }
        this.f2843a.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2843a == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        q6 q6Var = (q6) parcelable;
        super.onRestoreInstanceState(q6Var.getSuperState());
        if (!q6Var.b || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new i6(this));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        q6 q6Var = new q6(super.onSaveInstanceState());
        r6 r6Var = this.f2843a;
        q6Var.b = r6Var != null && r6Var.a();
        return q6Var;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        l7 l7Var = this.f2841a;
        if (l7Var == null || !l7Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        r6 r6Var = this.f2843a;
        if (r6Var == null) {
            return super.performClick();
        }
        if (r6Var.a()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.b) {
            this.f2846a = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f2843a != null) {
            Context context = this.f2844a;
            if (context == null) {
                context = getContext();
            }
            this.f2843a.n(new k6(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        p5 p5Var = this.f2842a;
        if (p5Var != null) {
            p5Var.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        p5 p5Var = this.f2842a;
        if (p5Var != null) {
            p5Var.g(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        r6 r6Var = this.f2843a;
        if (r6Var != null) {
            r6Var.f(i);
            this.f2843a.l(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        r6 r6Var = this.f2843a;
        if (r6Var != null) {
            r6Var.d(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f2843a != null) {
            this.f2840a = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        r6 r6Var = this.f2843a;
        if (r6Var != null) {
            r6Var.b(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(r2.d(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        r6 r6Var = this.f2843a;
        if (r6Var != null) {
            r6Var.j(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // a.qg
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        p5 p5Var = this.f2842a;
        if (p5Var != null) {
            p5Var.i(colorStateList);
        }
    }

    @Override // a.qg
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        p5 p5Var = this.f2842a;
        if (p5Var != null) {
            p5Var.j(mode);
        }
    }
}

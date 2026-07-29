package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.b1;
import androidx.appcompat.widget.h0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionMenuItemView extends AppCompatTextView implements k.a, View.OnClickListener, ActionMenuView.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f1833r = "ActionMenuItemView";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f1834s = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f1835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f1836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f1837i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e.b f1838j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h0 f1839k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f1840l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1841m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1842n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1843o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1844p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1845q;

    public class a extends h0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.h0
        public m.f b() {
            b bVar = ActionMenuItemView.this.f1840l;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.h0
        public boolean c() {
            m.f fVarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            e.b bVar = actionMenuItemView.f1838j;
            return bVar != null && bVar.a(actionMenuItemView.f1835g) && (fVarB = b()) != null && fVarB.d();
        }
    }

    public static abstract class b {
        public abstract m.f a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return j();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void c(boolean z10, char c10) {
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean d() {
        return j() && this.f1835g.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean f() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean g() {
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public h getItemData() {
        return this.f1835g;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void h(h hVar, int i10) {
        this.f1835g = hVar;
        setIcon(hVar.getIcon());
        setTitle(hVar.l(this));
        setId(hVar.getItemId());
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.f1839k == null) {
            this.f1839k = new a();
        }
    }

    public boolean j() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean k() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        return i10 >= 480 || (i10 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void l() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f1836h);
        if (this.f1837i != null && (!this.f1835g.E() || (!this.f1841m && !this.f1842n))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        setText(z12 ? this.f1836h : null);
        CharSequence contentDescription = this.f1835g.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z12 ? null : this.f1835g.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f1835g.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            b1.a(this, z12 ? null : this.f1835g.getTitle());
        } else {
            b1.a(this, tooltipText);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.b bVar = this.f1838j;
        if (bVar != null) {
            bVar.a(this.f1835g);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1841m = k();
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        boolean zJ = j();
        if (zJ && (i12 = this.f1844p) >= 0) {
            super.setPadding(i12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f1843o) : this.f1843o;
        if (mode != 1073741824 && this.f1843o > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i11);
        }
        if (zJ || this.f1837i == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f1837i.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        h0 h0Var;
        if (this.f1835g.hasSubMenu() && (h0Var = this.f1839k) != null && h0Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setCheckable(boolean z10) {
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f1842n != z10) {
            this.f1842n = z10;
            h hVar = this.f1835g;
            if (hVar != null) {
                hVar.e();
            }
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setIcon(Drawable drawable) {
        this.f1837i = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.f1845q;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (intrinsicHeight * (i10 / intrinsicWidth));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (intrinsicWidth * (i10 / intrinsicHeight));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        setCompoundDrawables(drawable, null, null, null);
        l();
    }

    public void setItemInvoker(e.b bVar) {
        this.f1838j = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        this.f1844p = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(b bVar) {
        this.f1840l = bVar;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setTitle(CharSequence charSequence) {
        this.f1836h = charSequence;
        l();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources = context.getResources();
        this.f1841m = k();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i10, 0);
        this.f1843o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f1845q = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1844p = -1;
        setSaveEnabled(false);
    }
}

package androidx.appcompat.view.menu;

import a.c0;
import a.i4;
import a.l4;
import a.l7;
import a.t8;
import a.w4;
import a.w6;
import a.y4;
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
import androidx.appcompat.widget.ActionMenuView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ActionMenuItemView extends w6 implements w4.a, View.OnClickListener, ActionMenuView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8139a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i4.b f3989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l4 f3990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l7 f3991a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f3992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f3993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f3994a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3995b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3996c;

    public class a extends l7 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // a.l7
        public y4 b() {
            b bVar = ActionMenuItemView.this.f3993a;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // a.l7
        public boolean c() {
            y4 y4VarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            i4.b bVar = actionMenuItemView.f3989a;
            return bVar != null && bVar.c(actionMenuItemView.f3990a) && (y4VarB = b()) != null && y4VarB.a();
        }
    }

    public static abstract class b {
        public abstract y4 a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f3995b = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.ActionMenuItemView, i, 0);
        this.f8139a = typedArrayObtainStyledAttributes.getDimensionPixelSize(c0.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.c = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.b = -1;
        setSaveEnabled(false);
    }

    @Override // a.w4.a
    public boolean a() {
        return true;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return f() && this.f3990a.getIcon() == null;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean c() {
        return f();
    }

    @Override // a.w4.a
    public void e(l4 l4Var, int i) {
        this.f3990a = l4Var;
        setIcon(l4Var.getIcon());
        setTitle(l4Var.k(this));
        setId(l4Var.getItemId());
        setVisibility(l4Var.isVisible() ? 0 : 8);
        setEnabled(l4Var.isEnabled());
        if (l4Var.hasSubMenu() && this.f3991a == null) {
            this.f3991a = new a();
        }
    }

    public boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // a.w4.a
    public l4 getItemData() {
        return this.f3990a;
    }

    public final void h() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f3994a);
        if (this.f3992a != null && (!this.f3990a.D() || (!this.f3995b && !this.f3996c))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f3994a : null);
        CharSequence contentDescription = this.f3990a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z3 ? null : this.f3990a.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.f3990a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            t8.a(this, z3 ? null : this.f3990a.getTitle());
        } else {
            t8.a(this, tooltipText);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i4.b bVar = this.f3989a;
        if (bVar != null) {
            bVar.c(this.f3990a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3995b = g();
        h();
    }

    @Override // a.w6, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        boolean zF = f();
        if (zF && (i3 = this.b) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f8139a) : this.f8139a;
        if (mode != 1073741824 && this.f8139a > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (zF || this.f3992a == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f3992a.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        l7 l7Var;
        if (this.f3990a.hasSubMenu() && (l7Var = this.f3991a) != null && l7Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f3996c != z) {
            this.f3996c = z;
            l4 l4Var = this.f3990a;
            if (l4Var != null) {
                l4Var.e();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f3992a = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.c;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            int i2 = this.c;
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
                intrinsicHeight = i2;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(i4.b bVar) {
        this.f3989a = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.b = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(b bVar) {
        this.f3993a = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f3994a = charSequence;
        h();
    }
}

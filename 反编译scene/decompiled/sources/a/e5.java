package a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class e5 extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5966a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d5 f672a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public lh f673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public n5 f674a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionMenuView f676a;
    public boolean b;
    public boolean c;

    public e5(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f672a = new d5(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(t.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f675a = context;
        } else {
            this.f675a = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int d(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    public int c(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    public int e(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public lh f(int i, long j) {
        lh lhVar = this.f673a;
        if (lhVar != null) {
            lhVar.b();
        }
        if (i != 0) {
            lh lhVarC = eh.c(this);
            lhVarC.a(0.0f);
            lhVarC.d(j);
            d5 d5Var = this.f672a;
            d5Var.d(lhVarC, i);
            lhVarC.f(d5Var);
            return lhVarC;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        lh lhVarC2 = eh.c(this);
        lhVarC2.a(1.0f);
        lhVarC2.d(j);
        d5 d5Var2 = this.f672a;
        d5Var2.d(lhVarC2, i);
        lhVarC2.f(d5Var2);
        return lhVarC2;
    }

    public int getAnimatedVisibility() {
        return this.f673a != null ? this.f672a.f5861a : getVisibility();
    }

    public int getContentHeight() {
        return this.f5966a;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, c0.ActionBar, t.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(c0.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        n5 n5Var = this.f674a;
        if (n5Var != null) {
            n5Var.F(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.c = false;
        }
        if (!this.c) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.c = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.c = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.b = false;
        }
        if (!this.b) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.b = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.b = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            lh lhVar = this.f673a;
            if (lhVar != null) {
                lhVar.b();
            }
            super.setVisibility(i);
        }
    }
}

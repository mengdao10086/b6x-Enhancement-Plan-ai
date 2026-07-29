package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.o;
import g.d0;
import g.i0;
import g.n0;
import g.p0;
import l.b;

/* JADX INFO: loaded from: classes2.dex */
public class j extends androidx.activity.j implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f1652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o.a f1653e;

    public j(@n0 Context context) {
        this(context, 0);
    }

    public static int i(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.g
    public void F2(l.b bVar) {
    }

    @Override // androidx.appcompat.app.g
    public void S(l.b bVar) {
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void addContentView(@n0 View view, ViewGroup.LayoutParams layoutParams) {
        g().d(view, layoutParams);
    }

    @Override // androidx.appcompat.app.g
    @p0
    public l.b c2(b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        g().A();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return androidx.core.view.o.e(this.f1653e, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    @p0
    public <T extends View> T findViewById(@d0 int i10) {
        return (T) g().n(i10);
    }

    @n0
    public h g() {
        if (this.f1652d == null) {
            this.f1652d = h.j(this, this);
        }
        return this.f1652d;
    }

    public a h() {
        return g().s();
    }

    @Override // android.app.Dialog
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void invalidateOptionsMenu() {
        g().v();
    }

    boolean j(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean k(int i10) {
        return g().I(i10);
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        g().u();
        super.onCreate(bundle);
        g().z(bundle);
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void onStop() {
        super.onStop();
        g().F();
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void setContentView(@i0 int i10) {
        g().K(i10);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        g().S(charSequence);
    }

    public j(@n0 Context context, int i10) {
        super(context, i(context, i10));
        this.f1653e = new o.a() { // from class: androidx.appcompat.app.i
            @Override // androidx.core.view.o.a
            public final boolean I1(KeyEvent keyEvent) {
                return this.f1651a.j(keyEvent);
            }
        };
        h hVarG = g();
        hVarG.R(i(context, i10));
        hVarG.z(null);
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void setContentView(@n0 View view) {
        g().L(view);
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void setContentView(@n0 View view, ViewGroup.LayoutParams layoutParams) {
        g().M(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i10) {
        super.setTitle(i10);
        g().S(getContext().getString(i10));
    }

    public j(@n0 Context context, boolean z10, @p0 DialogInterface.OnCancelListener onCancelListener) {
        super(context);
        this.f1653e = new o.a() { // from class: androidx.appcompat.app.i
            @Override // androidx.core.view.o.a
            public final boolean I1(KeyEvent keyEvent) {
                return this.f1651a.j(keyEvent);
            }
        };
        setCancelable(z10);
        setOnCancelListener(onCancelListener);
    }
}

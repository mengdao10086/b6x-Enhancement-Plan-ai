package a;

import a.cg;
import a.k3;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class y1 extends Dialog implements w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cg.a f7939a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public x0 f3644a;

    public y1(Context context, int i) {
        super(context, b(context, i));
        this.f7939a = new x1(this);
        x0 x0VarA = a();
        x0VarA.J(b(context, i));
        x0VarA.t(null);
    }

    public static int b(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(t.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public x0 a() {
        if (this.f3644a == null) {
            this.f3644a = x0.j(this, this);
        }
        return this.f3644a;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().d(view, layoutParams);
    }

    public boolean c(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean d(int i) {
        return a().C(i);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a().u();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return cg.e(this.f7939a, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) a().k(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().r();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        a().q();
        super.onCreate(bundle);
        a().t(bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        a().z();
    }

    @Override // a.w0
    public void onSupportActionModeFinished(k3 k3Var) {
    }

    @Override // a.w0
    public void onSupportActionModeStarted(k3 k3Var) {
    }

    @Override // a.w0
    public k3 onWindowStartingSupportActionMode(k3.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        a().D(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().E(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().F(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        a().K(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().K(charSequence);
    }
}

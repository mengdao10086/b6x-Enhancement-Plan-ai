package a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ListAdapter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7448a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final q0 f2936a;

    public t0(Context context) {
        this(context, u0.f(context, 0));
    }

    public t0(Context context, int i) {
        this.f2936a = new q0(new ContextThemeWrapper(context, u0.f(context, i)));
        this.f7448a = i;
    }

    public u0 a() {
        u0 u0Var = new u0(this.f2936a.f2491a, this.f7448a);
        this.f2936a.a(u0Var.f7550a);
        u0Var.setCancelable(this.f2936a.f2505a);
        if (this.f2936a.f2505a) {
            u0Var.setCanceledOnTouchOutside(true);
        }
        u0Var.setOnCancelListener(this.f2936a.f2492a);
        u0Var.setOnDismissListener(this.f2936a.f2494a);
        DialogInterface.OnKeyListener onKeyListener = this.f2936a.f2495a;
        if (onKeyListener != null) {
            u0Var.setOnKeyListener(onKeyListener);
        }
        return u0Var;
    }

    public Context b() {
        return this.f2936a.f2491a;
    }

    public t0 c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        q0 q0Var = this.f2936a;
        q0Var.f2502a = listAdapter;
        q0Var.f2518d = onClickListener;
        return this;
    }

    public t0 d(View view) {
        this.f2936a.f2500a = view;
        return this;
    }

    public t0 e(Drawable drawable) {
        this.f2936a.f2498a = drawable;
        return this;
    }

    public t0 f(DialogInterface.OnKeyListener onKeyListener) {
        this.f2936a.f2495a = onKeyListener;
        return this;
    }

    public t0 g(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
        q0 q0Var = this.f2936a;
        q0Var.f2502a = listAdapter;
        q0Var.f2518d = onClickListener;
        q0Var.h = i;
        q0Var.f2521d = true;
        return this;
    }

    public t0 h(CharSequence charSequence) {
        this.f2936a.f2503a = charSequence;
        return this;
    }
}

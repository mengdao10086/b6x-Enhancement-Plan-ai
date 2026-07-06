package a;

import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class x80 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v70 f7861a;

    public x80(v70 v70Var) {
        this.f7861a = v70Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        v70 v70Var = this.f7861a;
        if (v70Var != null) {
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            v70Var.n(((CompoundButton) view).isChecked());
        }
    }
}

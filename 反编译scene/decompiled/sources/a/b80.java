package a;

import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class b80 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d70 f5681a;

    public b80(d70 d70Var) {
        this.f5681a = d70Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        d70 d70Var = this.f5681a;
        if (d70Var != null) {
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            d70Var.j(((CompoundButton) view).isChecked());
        }
    }
}

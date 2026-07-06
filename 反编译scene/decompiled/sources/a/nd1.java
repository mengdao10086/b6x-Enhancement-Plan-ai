package a;

import android.view.View;
import android.widget.Switch;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nd1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nd1 f6903a = new nd1();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        hz0 hz0Var = hz0.f1282a;
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
        }
        hz0Var.H0(((Switch) view).isChecked());
        e50.Q0(e50.f677a, null, 1, null);
    }
}

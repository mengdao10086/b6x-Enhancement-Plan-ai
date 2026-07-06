package a;

import android.view.View;
import android.widget.Switch;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ud1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ud1 f7587a = new ud1();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        hz0 hz0Var = hz0.f1282a;
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
        }
        hz0Var.I0(((Switch) view).isChecked());
    }
}

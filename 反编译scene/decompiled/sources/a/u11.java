package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class u11 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ s11 f3106a;

    public u11(s11 s11Var, int i) {
        this.f3106a = s11Var;
        this.f7555a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3106a.K(-1, false);
        r11 r11Var = this.f3106a.b;
        if (r11Var != null) {
            r11Var.b(this.f7555a);
        }
    }
}

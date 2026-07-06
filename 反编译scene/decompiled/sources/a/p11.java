package a;

import android.view.View;
import android.widget.Button;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class p11 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n11 f2351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Button f2352a;

    public p11(Button button, n11 n11Var, int i) {
        this.f2352a = button;
        this.f2351a = n11Var;
        this.f7073a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        m11 m11Var = this.f2351a.f6862a;
        if (m11Var != null) {
            m11Var.a(this.f2352a, this.f7073a);
        }
    }
}

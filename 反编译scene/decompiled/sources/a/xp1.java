package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xp1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ iq1 f7911a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f3607a;

    public xp1(iq1 iq1Var, p80.b bVar) {
        this.f7911a = iq1Var;
        this.f3607a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3607a.c();
        iq1 iq1Var = this.f7911a;
        Boolean bool = iq1Var.U().updated;
        f92.c(bool, "app.updated");
        iq1Var.K(bool.booleanValue());
    }
}

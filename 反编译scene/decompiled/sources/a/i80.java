package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class i80 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6384a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ q80 f1338a;

    public i80(q80 q80Var, p80.b bVar) {
        this.f1338a = q80Var;
        this.f6384a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        q80 q80Var = this.f1338a;
        if (q80Var == null) {
            this.f6384a.c();
            return;
        }
        if (q80Var.a()) {
            this.f6384a.c();
        }
        Runnable runnableB = this.f1338a.b();
        if (runnableB != null) {
            runnableB.run();
        }
    }
}

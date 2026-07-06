package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oo1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f7043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ qo1 f2278a;

    public oo1(qo1 qo1Var, p80.b bVar) {
        this.f2278a = qo1Var;
        this.f7043a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7043a.c();
        s60 s60Var = s60.f7366a;
        String string = this.f2278a.a().getString(u61.cmd_power_fastboot);
        f92.c(string, "context.getString(R.string.cmd_power_fastboot)");
        s60Var.c(string);
    }
}

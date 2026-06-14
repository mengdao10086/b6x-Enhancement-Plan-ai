package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lo1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ qo1 f1842a;

    public lo1(qo1 qo1Var, p80.b bVar) {
        this.f1842a = qo1Var;
        this.f6727a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6727a.c();
        s60 s60Var = s60.f7366a;
        String string = this.f1842a.a().getString(u61.cmd_power_reboot);
        f92.c(string, "context.getString(R.string.cmd_power_reboot)");
        s60Var.c(string);
    }
}

package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class po1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f7135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ qo1 f2445a;

    public po1(qo1 qo1Var, p80.b bVar) {
        this.f2445a = qo1Var;
        this.f7135a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7135a.c();
        s60 s60Var = s60.f7366a;
        String string = this.f2445a.a().getString(u61.cmd_power_emergency);
        f92.c(string, "context.getString(R.string.cmd_power_emergency)");
        s60Var.c(string);
    }
}

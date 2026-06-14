package a;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class iu1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f6445a;

    public iu1(kv1 kv1Var) {
        this.f6445a = kv1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zg0 zg0Var = new zg0();
        Context contextP = this.f6445a.p();
        f92.b(contextP);
        f92.c(contextP, "context!!");
        if (!zg0Var.a(contextP)) {
            this.f6445a.X1();
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClassName("com.omarea.vtools", "com.omarea.vtools.activities.ActivityFreezeApps2");
        this.f6445a.s1(intent);
    }
}

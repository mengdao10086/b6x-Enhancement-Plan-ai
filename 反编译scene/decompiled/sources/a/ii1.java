package a;

import a.p80;
import android.content.Context;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ii1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ki1 f6417a;

    public ii1(ki1 ki1Var) {
        this.f6417a = ki1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6417a.f1644a.setText(this.f6417a.f1642a.getString(u61.apps_op_completed));
        try {
            this.f6417a.f1641a.c();
        } catch (Exception unused) {
        }
        if (!bc2.p(this.f6417a.f1646a)) {
            p80.a aVar = p80.f2403a;
            Context context = this.f6417a.f1642a;
            String string = this.f6417a.f1642a.getString(u61.apps_op_error);
            f92.c(string, "context.getString(R.string.apps_op_error)");
            String string2 = this.f6417a.f1646a.toString();
            f92.c(string2, "error.toString()");
            p80.a.b(aVar, context, string, string2, null, 8, null);
        }
    }
}

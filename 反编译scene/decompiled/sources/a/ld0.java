package a;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ld0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ he0 f6694a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ nd0 f1787a;

    public ld0(nd0 nd0Var, he0 he0Var) {
        this.f1787a = nd0Var;
        this.f6694a = he0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1787a.f6902a.f7008a.J1(this.f1787a.f6902a.f2231a, this.f1787a.f6902a.f2233a, this.f1787a.f6902a.f2232a, this.f6694a.c(this.f1787a.f6902a.f2234a));
        } catch (Exception e) {
            Context contextP = this.f1787a.f6902a.f7008a.p();
            f92.b(contextP);
            Toast.makeText(contextP, "" + e.getMessage(), 1).show();
        }
    }
}

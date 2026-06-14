package a;

import a.p80;
import android.widget.TextView;
import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rh1 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l92 f7300a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f2742a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ uh1 f2743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f2744a;

    public rh1(uh1 uh1Var, l92 l92Var, p80.b bVar, TextView textView) {
        this.f2743a = uh1Var;
        this.f7300a = l92Var;
        this.f2742a = bVar;
        this.f2744a = textView;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        l92 l92Var = this.f7300a;
        int i = l92Var.f6687a - 1;
        l92Var.f6687a = i;
        if (i >= 1) {
            this.f2743a.f3176a.post(new qh1(this));
            return;
        }
        cancel();
        if (this.f2742a.g()) {
            this.f2743a.f3176a.post(new ph1(this));
            this.f2743a.f7598a.o();
            this.f2743a.f7598a.n();
        }
    }
}

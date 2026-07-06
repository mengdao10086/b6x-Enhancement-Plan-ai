package a;

import android.content.Context;
import android.view.View;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nt1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ot1 f6948a;

    public nt1(ot1 ot1Var) {
        this.f6948a = ot1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Scene.f4798a.m(hz0.f1282a.c0(), "SOURCE_SCENE_CUSTOM");
        View view = this.f6948a.f2303a;
        f92.c(view, "this");
        Context context = view.getContext();
        f92.c(context, "this.context");
        new tx0(context).l();
        try {
            e42 e42Var = g42.f6169a;
            this.f6948a.f7055a.a2();
            g42.a(m42.f6769a);
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            g42.a(h42.a(th));
        }
        this.f6948a.f2302a.c();
    }
}

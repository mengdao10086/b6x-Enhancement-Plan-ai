package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class m80 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6782a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f1906a;

    public m80(p80.b bVar, Runnable runnable) {
        this.f6782a = bVar;
        this.f1906a = runnable;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6782a.c();
        Runnable runnable = this.f1906a;
        if (runnable != null) {
            runnable.run();
        }
    }
}

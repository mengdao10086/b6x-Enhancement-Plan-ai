package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class l80 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f1770a;

    public l80(p80.b bVar, Runnable runnable) {
        this.f6683a = bVar;
        this.f1770a = runnable;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6683a.c();
        Runnable runnable = this.f1770a;
        if (runnable != null) {
            runnable.run();
        }
    }
}

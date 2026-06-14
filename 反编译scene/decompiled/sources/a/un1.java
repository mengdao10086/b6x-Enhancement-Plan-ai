package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class un1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f7615a;

    public un1(Runnable runnable) {
        this.f7615a = runnable;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7615a.run();
    }
}

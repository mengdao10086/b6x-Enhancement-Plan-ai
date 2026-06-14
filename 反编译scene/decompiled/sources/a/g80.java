package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class g80 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f982a;

    public g80(p80.b bVar, Runnable runnable) {
        this.f6181a = bVar;
        this.f982a = runnable;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6181a.c();
        Runnable runnable = this.f982a;
        if (runnable != null) {
            runnable.run();
        }
    }
}

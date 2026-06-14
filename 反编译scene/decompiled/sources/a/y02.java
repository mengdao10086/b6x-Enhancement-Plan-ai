package a;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class y02 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f7938a;

    public y02(View view) {
        this.f7938a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Build.VERSION.SDK_INT >= 27) {
            qc2.d(hf2.f6309a, qe2.b(), null, new x02(this, null), 2, null);
        }
    }
}

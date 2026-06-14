package a;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class f02 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6060a;

    public f02(View view) {
        this.f6060a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Build.VERSION.SDK_INT >= 27) {
            qc2.d(hf2.f6309a, qe2.b(), null, new e02(this, null), 2, null);
        }
    }
}

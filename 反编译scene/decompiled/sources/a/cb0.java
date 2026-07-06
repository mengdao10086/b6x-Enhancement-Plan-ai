package a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cb0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ db0 f5774a;

    public cb0(db0 db0Var) {
        this.f5774a = db0Var;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Runnable runnable;
        if (intent == null || !intent.hasExtra("id") || intent.getIntExtra("id", 0) != this.f5774a.c || (runnable = this.f5774a.f530a) == null) {
            return;
        }
        runnable.run();
    }
}

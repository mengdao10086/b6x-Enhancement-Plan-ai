package a;

import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class eo1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fo1 f6026a;

    public eo1(fo1 fo1Var) {
        this.f6026a = fo1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6026a.f6124a.f1572a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f6026a.f6124a.f1573a)));
    }
}

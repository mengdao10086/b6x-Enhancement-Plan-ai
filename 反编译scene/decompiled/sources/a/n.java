package a;

import android.os.Bundle;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6855a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ o f1980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Bundle f1981a;

    public n(o oVar, int i, Bundle bundle) {
        this.f1980a = oVar;
        this.f6855a = i;
        this.f1981a = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1980a.q(this.f6855a, this.f1981a);
    }
}

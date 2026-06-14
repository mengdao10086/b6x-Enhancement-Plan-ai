package a;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f6860a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BroadcastReceiver f1984a;

    public n1(w1 w1Var) {
        this.f6860a = w1Var;
    }

    public void a() {
        BroadcastReceiver broadcastReceiver = this.f1984a;
        if (broadcastReceiver != null) {
            try {
                this.f6860a.f3335a.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
            this.f1984a = null;
        }
    }

    public abstract IntentFilter b();

    public abstract int c();

    public abstract void d();

    public void e() {
        a();
        IntentFilter intentFilterB = b();
        if (intentFilterB == null || intentFilterB.countActions() == 0) {
            return;
        }
        if (this.f1984a == null) {
            this.f1984a = new m1(this);
        }
        this.f6860a.f3335a.registerReceiver(this.f1984a, intentFilterB);
    }
}

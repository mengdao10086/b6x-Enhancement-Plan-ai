package a;

import android.content.IntentFilter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class o1 extends n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k2 f6968a;
    public final /* synthetic */ w1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(w1 w1Var, k2 k2Var) {
        super(w1Var);
        this.b = w1Var;
        this.f6968a = k2Var;
    }

    @Override // a.n1
    public IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        return intentFilter;
    }

    @Override // a.n1
    public int c() {
        return this.f6968a.d() ? 2 : 1;
    }

    @Override // a.n1
    public void d() {
        this.b.e();
    }
}

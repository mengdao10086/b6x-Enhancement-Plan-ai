package a;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class l1 extends n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PowerManager f6662a;
    public final /* synthetic */ w1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(w1 w1Var, Context context) {
        super(w1Var);
        this.b = w1Var;
        this.f6662a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @Override // a.n1
    public IntentFilter b() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        return intentFilter;
    }

    @Override // a.n1
    public int c() {
        return (Build.VERSION.SDK_INT < 21 || !this.f6662a.isPowerSaveMode()) ? 1 : 2;
    }

    @Override // a.n1
    public void d() {
        this.b.e();
    }
}

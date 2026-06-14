package a;

import android.content.Intent;
import android.view.View;
import com.omarea.vtools.activities.ActivityChargeStat;
import com.omarea.vtools.activities.ActivityPowerStat;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bs1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zs1 f5730a;

    public bs1(zs1 zs1Var) {
        this.f5730a = zs1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zs1 zs1Var;
        Intent intent;
        if (fa0.f867a.c() == 3 || fa0.f867a.c() == 4) {
            zs1Var = this.f5730a;
            intent = new Intent(this.f5730a.p(), (Class<?>) ActivityPowerStat.class);
        } else {
            zs1Var = this.f5730a;
            intent = new Intent(this.f5730a.p(), (Class<?>) ActivityChargeStat.class);
        }
        zs1Var.s1(intent);
    }
}

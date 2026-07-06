package a;

import android.content.Intent;
import android.view.View;
import com.omarea.vtools.activities.ActivityChargeControl;
import com.omarea.vtools.activities.ActivityPowerStat;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ve1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPowerStat.c f7687a;

    public ve1(ActivityPowerStat.c cVar) {
        this.f7687a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActivityPowerStat.this.startActivity(new Intent(ActivityPowerStat.this.getContext(), (Class<?>) ActivityChargeControl.class));
    }
}

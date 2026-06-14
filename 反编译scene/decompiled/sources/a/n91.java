package a;

import android.content.Intent;
import android.view.View;
import com.omarea.vtools.activities.ActivityChargeControl;
import com.omarea.vtools.activities.ActivityChargeStat;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n91 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o91 f6890a;

    public n91(o91 o91Var) {
        this.f6890a = o91Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActivityChargeStat.this.startActivity(new Intent(ActivityChargeStat.this.getContext(), (Class<?>) ActivityChargeControl.class));
    }
}

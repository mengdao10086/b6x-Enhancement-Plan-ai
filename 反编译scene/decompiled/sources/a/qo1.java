package a;

import a.p80;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qo1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f7226a;

    public qo1(Activity activity) {
        f92.d(activity, "context");
        this.f7226a = activity;
    }

    public final Activity a() {
        return this.f7226a;
    }

    public final void b() {
        View viewInflate = this.f7226a.getLayoutInflater().inflate(2131558536, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f7226a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        viewInflate.findViewById(t61.power_shutdown).setOnClickListener(new ko1(this, bVarT));
        viewInflate.findViewById(t61.power_reboot).setOnClickListener(new lo1(this, bVarT));
        viewInflate.findViewById(t61.power_hot_reboot).setOnClickListener(new mo1(this, bVarT));
        viewInflate.findViewById(t61.power_recovery).setOnClickListener(new no1(this, bVarT));
        viewInflate.findViewById(t61.power_fastboot).setOnClickListener(new oo1(this, bVarT));
        viewInflate.findViewById(t61.power_emergency).setOnClickListener(new po1(this, bVarT));
    }
}

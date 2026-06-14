package a;

import android.view.View;
import com.omarea.vtools.activities.ActivityPerfOptions;
import com.omarea.vtools.activities.ActivitySwap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lg1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivitySwap f6705a;

    public lg1(ActivitySwap activitySwap) {
        this.f6705a = activitySwap;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActivityPerfOptions.a aVar = ActivityPerfOptions.f8803a;
        ActivitySwap activitySwap = this.f6705a;
        m30 m30VarA = new pu0(this.f6705a).a();
        String string = this.f6705a.getString(u61.lmk_enhanced);
        f92.c(string, "context.getString(R.string.lmk_enhanced)");
        aVar.b(activitySwap, m30VarA, "features/lmk_enhanced.conf", string);
    }
}

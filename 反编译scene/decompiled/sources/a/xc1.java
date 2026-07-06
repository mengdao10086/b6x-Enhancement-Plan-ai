package a;

import a.p80;
import android.view.View;
import com.omarea.model.MagiskModuleUnofficial;
import com.omarea.vtools.activities.ActivityModuleUpload;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xc1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MagiskModuleUnofficial f7876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityModuleUpload f3571a;

    public xc1(ActivityModuleUpload activityModuleUpload, MagiskModuleUnofficial magiskModuleUnofficial) {
        this.f3571a = activityModuleUpload;
        this.f7876a = magiskModuleUnofficial;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        p80.a aVar = p80.f2403a;
        ActivityModuleUpload activityModuleUpload = this.f3571a;
        String string = activityModuleUpload.getString(u61.module_delete);
        f92.c(string, "getString(R.string.module_delete)");
        String string2 = this.f3571a.getString(u61.module_delete_desc);
        f92.c(string2, "getString(R.string.module_delete_desc)");
        aVar.M(activityModuleUpload, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : string2, (16 & 8) != 0 ? null : new wc1(this), (16 & 16) != 0 ? null : null);
    }
}

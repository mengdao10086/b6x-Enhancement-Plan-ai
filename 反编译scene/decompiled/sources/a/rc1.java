package a;

import android.content.Intent;
import android.view.View;
import com.omarea.model.MagiskModuleUnofficial;
import com.omarea.vtools.activities.ActivityModuleDetail;
import com.omarea.vtools.activities.ActivityModuleUpload;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rc1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MagiskModuleUnofficial f7288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityModuleDetail f2729a;

    public rc1(ActivityModuleDetail activityModuleDetail, boolean z, MagiskModuleUnofficial magiskModuleUnofficial) {
        this.f2729a = activityModuleDetail;
        this.f7288a = magiskModuleUnofficial;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.f2729a, (Class<?>) ActivityModuleUpload.class);
        intent.putExtra("id", this.f7288a.getDbId());
        this.f2729a.startActivity(intent);
        this.f2729a.setResult(-1);
        this.f2729a.finishAfterTransition();
    }
}

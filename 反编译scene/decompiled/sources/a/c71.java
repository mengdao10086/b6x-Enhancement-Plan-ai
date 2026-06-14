package a;

import android.view.View;
import com.omarea.krscript.model.PageMenuOption;
import com.omarea.vtools.activities.ActivityActionPage;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class c71 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageMenuOption f5765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityActionPage f357a;

    public c71(ActivityActionPage activityActionPage, PageMenuOption pageMenuOption) {
        this.f357a = activityActionPage;
        this.f5765a = pageMenuOption;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f357a.G(this.f5765a);
    }
}

package a;

import com.omarea.krscript.model.PageMenuOption;
import com.omarea.vtools.activities.ActivityActionPage;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class g71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityActionPage.d f6179a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f981a;

    public g71(ActivityActionPage.d dVar, String str) {
        this.f6179a = dVar;
        this.f981a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityActionPage.d dVar = this.f6179a;
        ActivityActionPage activityActionPage = ActivityActionPage.this;
        PageMenuOption pageMenuOption = dVar.f8472a;
        HashMap map = new HashMap();
        map.put("state", this.f6179a.f8472a.getKey());
        map.put("menu_id", this.f6179a.f8472a.getKey());
        map.put("file", this.f981a);
        map.put("folder", this.f981a);
        m42 m42Var = m42.f6769a;
        activityActionPage.F(pageMenuOption, map);
    }
}

package a;

import android.widget.ListView;
import com.omarea.vtools.activities.ActivityAppConfig2;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class a81 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityAppConfig2.a f5580a;

    public a81(ActivityAppConfig2.a aVar) {
        this.f5580a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityAppConfig2.n(ActivityAppConfig2.this).c();
        ActivityAppConfig2 activityAppConfig2 = ActivityAppConfig2.this;
        ArrayList arrayList = activityAppConfig2.b;
        ListView listView = (ListView) ActivityAppConfig2.this._$_findCachedViewById(t61.scene_app_list);
        f92.c(listView, "scene_app_list");
        activityAppConfig2.F(arrayList, listView);
    }
}

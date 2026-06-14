package a;

import com.omarea.common.ui.OverScrollListView;
import com.omarea.vtools.activities.ActivityAppXposedConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class s81 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityAppXposedConfig.a f7373a;

    public s81(ActivityAppXposedConfig.a aVar) {
        this.f7373a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityAppXposedConfig.m(ActivityAppXposedConfig.this).c();
        ActivityAppXposedConfig activityAppXposedConfig = ActivityAppXposedConfig.this;
        ArrayList arrayList = activityAppXposedConfig.b;
        OverScrollListView overScrollListView = (OverScrollListView) ActivityAppXposedConfig.this._$_findCachedViewById(t61.scene_app_list);
        f92.c(overScrollListView, "scene_app_list");
        activityAppXposedConfig.y(arrayList, overScrollListView);
    }
}

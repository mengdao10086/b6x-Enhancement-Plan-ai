package a;

import a.p80;
import com.omarea.model.AppInfo;
import com.omarea.vtools.activities.ActivityAppRetrieve;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class p81 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityAppRetrieve.b f7096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f2407a;
    public final /* synthetic */ ArrayList b;

    public p81(ActivityAppRetrieve.b bVar, ArrayList arrayList, ArrayList arrayList2) {
        this.f7096a = bVar;
        this.f2407a = arrayList;
        this.b = arrayList2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityAppRetrieve.m(ActivityAppRetrieve.this).c();
        ActivityAppRetrieve.this.setResult(-1);
        if (this.f2407a.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator it = this.f2407a.iterator();
            while (it.hasNext()) {
                sb.append(((AppInfo) it.next()).getAppName());
                sb.append("\n");
            }
            p80.a aVar = p80.f2403a;
            ActivityAppRetrieve activityAppRetrieve = ActivityAppRetrieve.this;
            String string = activityAppRetrieve.getString(u61.apps_retrieve_fail);
            f92.c(string, "getString(R.string.apps_retrieve_fail)");
            p80.a.B(aVar, activityAppRetrieve, string, sb.toString() + "\n\n" + ActivityAppRetrieve.this.getString(u61.apps_retrieve_fail), null, 8, null);
            if (this.b.size() == this.f7096a.f5157a.size()) {
                return;
            }
        }
        ActivityAppRetrieve.this.loadData();
    }
}

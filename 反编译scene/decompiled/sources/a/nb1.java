package a;

import a.d70;
import com.omarea.vtools.activities.ActivityFreezeApps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nb1 implements w70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ob1 f6896a;

    public nb1(ob1 ob1Var) {
        this.f6896a = ob1Var;
    }

    @Override // a.w70
    public void a(List<? extends d70.a> list) {
        f92.d(list, "apps");
        ActivityFreezeApps activityFreezeApps = ActivityFreezeApps.this;
        ArrayList arrayList = new ArrayList(z42.m(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((d70.a) it.next()).getPackageName());
        }
        activityFreezeApps.addFreezeApps(new ArrayList(arrayList));
    }
}

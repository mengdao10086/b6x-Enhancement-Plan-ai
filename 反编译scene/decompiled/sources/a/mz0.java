package a;

import a.d70;
import com.omarea.sysmbol.PerfOptionsRender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mz0 implements w70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PerfOptionsRender.c f6853a;

    public mz0(PerfOptionsRender.c cVar) {
        this.f6853a = cVar;
    }

    @Override // a.w70
    public void a(List<? extends d70.a> list) {
        f92.d(list, "apps");
        rh0 rh0Var = this.f6853a.f4810a;
        ArrayList arrayList = new ArrayList(z42.m(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((d70.a) it.next()).getPackageName());
        }
        rh0Var.a(arrayList);
        this.f6853a.f4813a.run();
    }
}

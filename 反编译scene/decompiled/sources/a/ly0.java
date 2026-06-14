package a;

import com.omarea.model.FpsWatchSession;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ly0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f6747a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ d30 f1854a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ey0 f1855a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ py0 f1856a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ FpsWatchSession f1857a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1858a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ List f1859a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String[] f1860a;
    public final /* synthetic */ List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ly0(py0 py0Var, long j, FpsWatchSession fpsWatchSession, ey0 ey0Var, d30 d30Var, String[] strArr, List list, List list2, ArrayList arrayList) {
        super(1);
        this.f1856a = py0Var;
        this.f6747a = j;
        this.f1857a = fpsWatchSession;
        this.f1855a = ey0Var;
        this.f1854a = d30Var;
        this.f1860a = strArr;
        this.f1859a = list;
        this.b = list2;
        this.f1858a = arrayList;
    }

    public final void a(l30 l30Var) throws Exception {
        f92.d(l30Var, "$receiver");
        l30Var.E("session", new l30(new jy0(this)));
        l30Var.E("data", new l30(new ky0(this)));
        List list = this.f1859a;
        ArrayList arrayList = new ArrayList(z42.m(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                y42.l();
                throw null;
            }
            arrayList.add(new l30(new hy0(i, (List) obj, this)));
            i = i2;
        }
        l30Var.D("threads", arrayList);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}

package a;

import android.widget.ListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ss1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ts1 f7429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f2921a;

    public ss1(ts1 ts1Var, ArrayList arrayList) {
        this.f7429a = ts1Var;
        this.f2921a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListView listView = (ListView) this.f7429a.f3058a.w1(t61.home_process_list);
        f21 f21Var = (f21) (listView != null ? listView.getAdapter() : null);
        if (f21Var != null) {
            f21Var.k(this.f2921a);
        }
    }
}

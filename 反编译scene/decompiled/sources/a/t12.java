package a;

import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t12 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f7454a;

    public t12(ArrayList arrayList) {
        this.f7454a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListView listView;
        View viewA = u12.f3107a.a();
        f21 f21Var = (f21) ((viewA == null || (listView = (ListView) viewA.findViewById(2131362792)) == null) ? null : listView.getAdapter());
        if (f21Var != null) {
            f21Var.k(this.f7454a);
        }
    }
}

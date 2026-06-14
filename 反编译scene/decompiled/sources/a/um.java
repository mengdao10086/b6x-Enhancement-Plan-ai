package a;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class um implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f7611a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Map f3198a;

    public um(wm wmVar, ArrayList arrayList, Map map) {
        this.f7611a = arrayList;
        this.f3198a = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.f7611a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f7611a.get(i);
            String strH = eh.H(view);
            if (strH != null) {
                eh.z0(view, wm.i(this.f3198a, strH));
            }
        }
    }
}

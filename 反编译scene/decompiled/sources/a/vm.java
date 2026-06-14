package a;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class vm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f7706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Map f3291a;

    public vm(wm wmVar, ArrayList arrayList, Map map) {
        this.f7706a = arrayList;
        this.f3291a = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.f7706a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f7706a.get(i);
            eh.z0(view, (String) this.f3291a.get(eh.H(view)));
        }
    }
}

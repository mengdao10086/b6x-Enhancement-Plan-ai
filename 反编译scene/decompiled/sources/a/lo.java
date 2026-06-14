package a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class lo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ to f6725a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1839a;

    public lo(to toVar, ArrayList arrayList) {
        this.f6725a = toVar;
        this.f1839a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f1839a.iterator();
        while (it.hasNext()) {
            this.f6725a.R((RecyclerView.d0) it.next());
        }
        this.f1839a.clear();
        this.f6725a.f.remove(this.f1839a);
    }
}

package a;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ko implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ to f6624a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f1669a;

    public ko(to toVar, ArrayList arrayList) {
        this.f6624a = toVar;
        this.f1669a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f1669a.iterator();
        while (it.hasNext()) {
            this.f6624a.S((ro) it.next());
        }
        this.f1669a.clear();
        this.f6624a.h.remove(this.f1669a);
    }
}

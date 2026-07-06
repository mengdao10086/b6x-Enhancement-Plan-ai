package a;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class a40 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f5568a;

    public a40(ArrayList arrayList) {
        this.f5568a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f5568a.iterator();
        while (it.hasNext()) {
            try {
                ((g82) it.next()).f("error");
            } catch (Exception unused) {
            }
        }
    }
}

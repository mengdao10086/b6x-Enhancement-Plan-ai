package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class im implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f6426a;

    public im(ArrayList arrayList) {
        this.f6426a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        nm.B(this.f6426a, 4);
    }
}

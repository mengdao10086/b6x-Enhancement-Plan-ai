package a;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xk implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f7898a;

    public xk(Fragment fragment) {
        this.f7898a = fragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7898a.f();
    }
}

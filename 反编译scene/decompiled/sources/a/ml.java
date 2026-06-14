package a;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ml implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nl f6818a;

    public ml(nl nlVar) {
        this.f6818a = nlVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6818a.f2108a.m() != null) {
            this.f6818a.f2108a.i1(null);
            nl nlVar = this.f6818a;
            yl ylVar = nlVar.f6928a;
            Fragment fragment = nlVar.f2108a;
            ylVar.S0(fragment, fragment.I(), 0, 0, false);
        }
    }
}

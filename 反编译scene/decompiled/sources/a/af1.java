package a;

import com.omarea.vtools.activities.ActivityProcess;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class af1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityProcess.b f5601a;

    public af1(ActivityProcess.b bVar) {
        this.f5601a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityProcess.b bVar = this.f5601a;
        bVar.f5469a.setImageDrawable(yb.d(ActivityProcess.this.getContext(), 2131231120));
    }
}

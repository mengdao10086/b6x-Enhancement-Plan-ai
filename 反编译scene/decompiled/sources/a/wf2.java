package a;

import a.qf2;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class wf2<J extends qf2> extends id2 implements re2, jf2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J f7784a;

    public wf2(J j) {
        this.f7784a = j;
    }

    @Override // a.jf2
    public boolean a() {
        return true;
    }

    @Override // a.re2
    public void b() {
        J j = this.f7784a;
        if (j == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        }
        ((bg2) j).r0(this);
    }

    @Override // a.jf2
    public gg2 c() {
        return null;
    }
}

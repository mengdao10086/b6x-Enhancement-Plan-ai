package a;

import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ak0 extends gk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GL10 f5616a;

    public ak0(bk0 bk0Var, GL10 gl10) {
        this.f5616a = gl10;
        this.c = this.f5616a.glGetString(7937);
        this.b = this.f5616a.glGetString(7936);
        super.f6215a = this.f5616a.glGetString(7938);
        this.f5616a.glGetString(7939);
    }
}

package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class n2 implements oh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p2 f6865a;

    public n2(p2 p2Var) {
        this.f6865a = p2Var;
    }

    @Override // a.oh
    public void a(View view) {
        ((View) this.f6865a.f2367a.getParent()).invalidate();
    }
}

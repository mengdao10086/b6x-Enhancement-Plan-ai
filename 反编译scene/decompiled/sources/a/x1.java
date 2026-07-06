package a;

import a.cg;
import android.view.KeyEvent;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class x1 implements cg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y1 f7842a;

    public x1(y1 y1Var) {
        this.f7842a = y1Var;
    }

    @Override // a.cg.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f7842a.c(keyEvent);
    }
}

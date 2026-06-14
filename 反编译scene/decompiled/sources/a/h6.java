package a;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class h6 extends l7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o6 f6279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ s6 f1124a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h6(s6 s6Var, View view, o6 o6Var) {
        super(view);
        this.f1124a = s6Var;
        this.f6279a = o6Var;
    }

    @Override // a.l7
    public y4 b() {
        return this.f6279a;
    }

    @Override // a.l7
    @SuppressLint({"SyntheticAccessor"})
    public boolean c() {
        if (this.f1124a.getInternalPopup().a()) {
            return true;
        }
        this.f1124a.b();
        return true;
    }
}

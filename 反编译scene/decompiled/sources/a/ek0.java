package a;

import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ek0 implements ck0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ck0 f6015a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ fk0 f766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewGroup f767a;

    public ek0(fk0 fk0Var, ViewGroup viewGroup, fk0 fk0Var2, ck0 ck0Var) {
        this.f767a = viewGroup;
        this.f766a = fk0Var2;
        this.f6015a = ck0Var;
    }

    @Override // a.ck0
    public void a(gk0 gk0Var) {
        this.f767a.getRootView().post(new dk0(this, gk0Var));
    }
}

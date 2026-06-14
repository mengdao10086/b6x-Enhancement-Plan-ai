package a;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class w31 extends dm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x31 f7752a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w31(x31 x31Var, jl jlVar) {
        super(jlVar);
        this.f7752a = x31Var;
    }

    @Override // a.ku
    public int c() {
        return this.f7752a.f3529a.size();
    }

    @Override // a.ku
    public CharSequence e(int i) {
        return "";
    }

    @Override // a.dm
    public Fragment q(int i) {
        Object obj = this.f7752a.f3529a.get(i);
        f92.c(obj, "fragments.get(position)");
        return (Fragment) obj;
    }
}

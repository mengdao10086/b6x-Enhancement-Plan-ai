package a;

import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentHome$updateInfo$2", f = "FragmentHome.kt", l = {}, m = "invokeSuspend")
public final class ts1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zs1 f3058a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ts1(zs1 zs1Var, b62 b62Var) {
        super(2, b62Var);
        this.f3058a = zs1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ts1 ts1Var = new ts1(this.f3058a, b62Var);
        ts1Var.f7530a = (wd2) obj;
        return ts1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ts1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        Scene.f4798a.i(new ss1(this, this.f3058a.f3876a.a()));
        return m42.f6769a;
    }
}

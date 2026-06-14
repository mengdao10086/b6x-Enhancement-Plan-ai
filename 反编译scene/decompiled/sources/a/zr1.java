package a;

import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentHome$onViewCreated$1$1", f = "FragmentHome.kt", l = {}, m = "invokeSuspend")
public final class zr1 extends d72 implements g82<b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cs1 f8092a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zr1(cs1 cs1Var, b62 b62Var) {
        super(1, b62Var);
        this.f8092a = cs1Var;
    }

    @Override // a.g82
    public final Object f(b62<? super m42> b62Var) {
        return ((zr1) n(b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f8092a.f5825a.J1();
        Scene.f4798a.n(u61.home_cache_cleared, 0);
        return m42.f6769a;
    }

    public final b62<m42> n(b62<?> b62Var) {
        f92.d(b62Var, "completion");
        return new zr1(this.f8092a, b62Var);
    }
}

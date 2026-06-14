package a;

import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentHome$onViewCreated$2$1", f = "FragmentHome.kt", l = {140}, m = "invokeSuspend")
public final class ds1 extends d72 implements g82<b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ es1 f5934a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ds1(es1 es1Var, b62 b62Var) {
        super(1, b62Var);
        this.f5934a = es1Var;
    }

    @Override // a.g82
    public final Object f(b62<? super m42> b62Var) {
        return ((ds1) n(b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            zs1 zs1Var = this.f5934a.f6037a;
            this.b = 1;
            obj = zs1Var.L1(1, this);
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        Scene.f4798a.o((String) obj, 0);
        return m42.f6769a;
    }

    public final b62<m42> n(b62<?> b62Var) {
        f92.d(b62Var, "completion");
        return new ds1(this.f5934a, b62Var);
    }
}

package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentPerf$onViewCreated$2$2", f = "FragmentPerf.kt", l = {}, m = "invokeSuspend")
public final class ru1 extends d72 implements g82<b62<? super String>, Object> {
    public int b;

    public ru1(b62 b62Var) {
        super(1, b62Var);
    }

    @Override // a.g82
    public final Object f(b62<? super String> b62Var) {
        return ((ru1) n(b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        return e50.Q0(e50.f677a, null, 1, null);
    }

    public final b62<m42> n(b62<?> b62Var) {
        f92.d(b62Var, "completion");
        return new ru1(b62Var);
    }
}

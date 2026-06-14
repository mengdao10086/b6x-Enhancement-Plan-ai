package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentPerf$onViewCreated$2$1", f = "FragmentPerf.kt", l = {133}, m = "invokeSuspend")
public final class qu1 extends d72 implements g82<b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ su1 f7241a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qu1(su1 su1Var, b62 b62Var) {
        super(1, b62Var);
        this.f7241a = su1Var;
    }

    @Override // a.g82
    public final Object f(b62<? super m42> b62Var) {
        return ((qu1) n(b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            kv1 kv1Var = this.f7241a.f7435a;
            this.b = 1;
            if (kv1Var.Y1(this) == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return m42.f6769a;
    }

    public final b62<m42> n(b62<?> b62Var) {
        f92.d(b62Var, "completion");
        return new qu1(this.f7241a, b62Var);
    }
}

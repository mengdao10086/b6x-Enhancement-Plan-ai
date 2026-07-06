package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class u51 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ v51 f3140a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3141a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u51(v51 v51Var, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f3140a = v51Var;
        this.f7567a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        u51 u51Var = new u51(this.f3140a, this.f7567a, b62Var);
        u51Var.f3141a = (wd2) obj;
        return u51Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((u51) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f3140a.f7660a.R().setText(((eh0) this.f7567a.f6891a).a());
        this.f3140a.f7660a.N().setImageDrawable(((eh0) this.f7567a.f6891a).b());
        return m42.f6769a;
    }
}

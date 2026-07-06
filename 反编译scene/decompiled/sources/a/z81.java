package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class z81 extends d72 implements k82<wd2, b62<? super eh0>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a91 f8045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3800a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3801a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z81(String str, b62 b62Var, a91 a91Var) {
        super(2, b62Var);
        this.f3801a = str;
        this.f8045a = a91Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        z81 z81Var = new z81(this.f3801a, b62Var, this.f8045a);
        z81Var.f3799a = (wd2) obj;
        return z81Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super eh0> b62Var) {
        return ((z81) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f3799a;
            fe2<eh0> fe2VarI = ((ih0) this.f8045a.f5583a.f6891a).i(this.f3801a);
            this.f3800a = wd2Var;
            this.b = 1;
            obj = fe2VarI.s(this);
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return obj;
    }
}

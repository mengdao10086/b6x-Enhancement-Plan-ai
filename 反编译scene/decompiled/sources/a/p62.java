package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class p62 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ k82 f2399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Object f2400a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p62(b62 b62Var, l62 l62Var, b62 b62Var2, l62 l62Var2, k82 k82Var, Object obj) {
        super(b62Var2, l62Var2);
        this.f2399a = k82Var;
        this.f2400a = obj;
    }

    @Override // a.s62
    public Object j(Object obj) {
        int i = this.f7090a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f7090a = 2;
            h42.b(obj);
            return obj;
        }
        this.f7090a = 1;
        h42.b(obj);
        k82 k82Var = this.f2399a;
        if (k82Var == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        r92.b(k82Var, 2);
        return k82Var.d(this.f2400a, this);
    }
}

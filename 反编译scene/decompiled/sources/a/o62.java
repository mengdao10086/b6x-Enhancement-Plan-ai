package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class o62 extends c72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ k82 f2211a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Object f2212a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o62(b62 b62Var, b62 b62Var2, k82 k82Var, Object obj) {
        super(b62Var2);
        this.f2211a = k82Var;
        this.f2212a = obj;
    }

    @Override // a.s62
    public Object j(Object obj) {
        int i = this.f6989a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f6989a = 2;
            h42.b(obj);
            return obj;
        }
        this.f6989a = 1;
        h42.b(obj);
        k82 k82Var = this.f2211a;
        if (k82Var == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        r92.b(k82Var, 2);
        return k82Var.d(this.f2212a, this);
    }
}

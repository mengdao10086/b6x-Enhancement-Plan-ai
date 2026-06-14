package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$socketSendRequest$2", f = "Daemon.kt", l = {}, m = "invokeSuspend")
public final class u40 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v50 f7564a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ byte[] f3134a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u40(v50 v50Var, byte[] bArr, b62 b62Var) {
        super(2, b62Var);
        this.f7564a = v50Var;
        this.f3134a = bArr;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        u40 u40Var = new u40(this.f7564a, this.f3134a, b62Var);
        u40Var.f3133a = (wd2) obj;
        return u40Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((u40) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        e50 e50Var = e50.f677a;
        synchronized (e50.f683a) {
            this.f7564a.e(this.f3134a);
            m42 m42Var = m42.f6769a;
        }
        return m42.f6769a;
    }
}

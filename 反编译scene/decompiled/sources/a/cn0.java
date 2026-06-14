package a;

import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.shell.SwapUtils$swappiness$1", f = "SwapUtils.kt", l = {485}, m = "invokeSuspend")
public final class cn0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fn0 f5811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f435a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cn0(fn0 fn0Var, String str, b62 b62Var) {
        super(2, b62Var);
        this.f5811a = fn0Var;
        this.f435a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        cn0 cn0Var = new cn0(this.f5811a, this.f435a, b62Var);
        cn0Var.f433a = (wd2) obj;
        return cn0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((cn0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f433a;
            x60 x60Var = x60.f7856a;
            List listY = i52.Y(y42.c(j42.a(this.f5811a.h + "/hybridswapd_swappiness", this.f435a), j42.a(this.f5811a.h + "/vm_swappiness_threshold1", this.f435a), j42.a(this.f5811a.h + "/vm_swappiness_threshold2", this.f435a)));
            this.f434a = wd2Var;
            this.b = 1;
            if (x60.l(x60Var, listY, 0, this, 2, null) == objC) {
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
}

package a;

import a.p80;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFiles$onViewCreated$1$1$1$1", f = "ActivityFiles.kt", l = {}, m = "invokeSuspend")
public final class ma1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f6787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ na1 f1912a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1913a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ma1(na1 na1Var, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f1912a = na1Var;
        this.f6787a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ma1 ma1Var = new ma1(this.f1912a, this.f6787a, b62Var);
        ma1Var.f1913a = (wd2) obj;
        return ma1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ma1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ((p80.b) this.f1912a.f2029a.f6891a).c();
        if (!f92.a((String) this.f6787a.f6891a, "error")) {
            Scene.c.p(Scene.f4798a, "OK", 0, 2, null);
        }
        return m42.f6769a;
    }
}

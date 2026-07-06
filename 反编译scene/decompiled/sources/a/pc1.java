package a;

import com.omarea.model.MagiskModuleUnofficial;
import com.omarea.vtools.activities.ActivityModuleDetail;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityModuleDetail$onCreate$1$1", f = "ActivityModuleDetail.kt", l = {}, m = "invokeSuspend")
public final class pc1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityModuleDetail.a f2416a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pc1(ActivityModuleDetail.a aVar, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f2416a = aVar;
        this.f7104a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        pc1 pc1Var = new pc1(this.f2416a, this.f7104a, b62Var);
        pc1Var.f2415a = (wd2) obj;
        return pc1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((pc1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        T t = this.f7104a.f6891a;
        if (((MagiskModuleUnofficial) t) != null) {
            try {
                ActivityModuleDetail.this.m(ActivityModuleDetail.this, (MagiskModuleUnofficial) t);
            } catch (Exception unused) {
                ActivityModuleDetail.this.finishAfterTransition();
            }
        } else {
            ActivityModuleDetail.this.finishAfterTransition();
        }
        return m42.f6769a;
    }
}

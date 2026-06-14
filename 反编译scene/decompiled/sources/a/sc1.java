package a;

import com.omarea.model.MagiskModuleUnofficial;
import com.omarea.vtools.activities.ActivityModuleUpload;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityModuleUpload$onCreate$1$1", f = "ActivityModuleUpload.kt", l = {}, m = "invokeSuspend")
public final class sc1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7384a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityModuleUpload.a f2875a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sc1(ActivityModuleUpload.a aVar, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f2875a = aVar;
        this.f7384a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        sc1 sc1Var = new sc1(this.f2875a, this.f7384a, b62Var);
        sc1Var.f2874a = (wd2) obj;
        return sc1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((sc1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        T t = this.f7384a.f6891a;
        if (((MagiskModuleUnofficial) t) != null) {
            try {
                ActivityModuleUpload.this.o(ActivityModuleUpload.this, (MagiskModuleUnofficial) t);
            } catch (Exception unused) {
                ActivityModuleUpload.this.finishAfterTransition();
            }
        } else {
            ActivityModuleUpload.this.finishAfterTransition();
        }
        return m42.f6769a;
    }
}

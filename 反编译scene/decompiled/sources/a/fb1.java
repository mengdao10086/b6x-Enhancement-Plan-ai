package a;

import com.omarea.vtools.activities.ActivityFpsSessions;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fb1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gb1 f6090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f878a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fb1(gb1 gb1Var, b62 b62Var) {
        super(2, b62Var);
        this.f6090a = gb1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        fb1 fb1Var = new fb1(this.f6090a, b62Var);
        fb1Var.f878a = (wd2) obj;
        return fb1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((fb1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f6090a.f6191a.c();
        ActivityFpsSessions.this.z();
        return m42.f6769a;
    }
}

package a;

import a.p80;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ef1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ff1 f5997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f728a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ef1(ff1 ff1Var, p80.b bVar, b62 b62Var) {
        super(2, b62Var);
        this.f5997a = ff1Var;
        this.f727a = bVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ef1 ef1Var = new ef1(this.f5997a, this.f727a, b62Var);
        ef1Var.f728a = (wd2) obj;
        return ef1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ef1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        e50.f677a.Z0("/proc/" + this.f5997a.f897a.pid + "/reclaim", "all", 436, t62.f(15000L));
        this.f727a.c();
        return m42.f6769a;
    }
}

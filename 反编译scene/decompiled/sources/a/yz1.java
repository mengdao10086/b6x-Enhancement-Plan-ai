package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yz1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f8021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zz1 f3782a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yz1(zz1 zz1Var, b62 b62Var) {
        super(2, b62Var);
        this.f3782a = zz1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        yz1 yz1Var = new yz1(this.f3782a, b62Var);
        yz1Var.f8021a = (wd2) obj;
        return yz1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((yz1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f3782a.f8113a.b.run();
        return m42.f6769a;
    }
}

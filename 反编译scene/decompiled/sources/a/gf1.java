package a;

import a.p80;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gf1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hf1 f6203a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f1003a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1004a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1005a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ String f1006b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gf1(hf1 hf1Var, String str, String str2, p80.b bVar, b62 b62Var) {
        super(2, b62Var);
        this.f6203a = hf1Var;
        this.f1005a = str;
        this.f1006b = str2;
        this.f1003a = bVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        gf1 gf1Var = new gf1(this.f6203a, this.f1005a, this.f1006b, this.f1003a, b62Var);
        gf1Var.f1004a = (wd2) obj;
        return gf1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((gf1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        e50.f677a.Z0((String) this.f6203a.f6308a.f6891a, "1", 436, t62.f(15000L));
        if (f92.a(this.f1005a, "0")) {
            x60.f7856a.j(this.f1006b, this.f1005a);
        }
        this.f1003a.c();
        return m42.f6769a;
    }
}

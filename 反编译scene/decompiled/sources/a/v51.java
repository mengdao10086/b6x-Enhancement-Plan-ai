package a;

import a.t51;
import com.omarea.model.PowerStatAVG;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class v51 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t51.a f7660a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ t51 f3237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3238a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ PowerStatAVG f3239a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3240a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3241a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3242b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v51(t51.a aVar, String str, b62 b62Var, t51 t51Var, PowerStatAVG powerStatAVG) {
        super(2, b62Var);
        this.f7660a = aVar;
        this.f3241a = str;
        this.f3237a = t51Var;
        this.f3239a = powerStatAVG;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        v51 v51Var = new v51(this.f7660a, this.f3241a, b62Var, this.f3237a, this.f3239a);
        v51Var.f3238a = (wd2) obj;
        return v51Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((v51) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Type inference failed for: r8v6, types: [T, a.eh0] */
    @Override // a.s62
    public final Object j(Object obj) {
        wd2 wd2Var;
        n92 n92Var;
        n92 n92Var2;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2Var = this.f3238a;
            n92Var = new n92();
            ih0 ih0Var = this.f3237a.f2963a;
            String str = this.f3241a;
            f92.c(str, "app");
            fe2<eh0> fe2VarI = ih0Var.i(str);
            this.f3240a = wd2Var;
            this.f3242b = n92Var;
            this.c = n92Var;
            this.b = 1;
            obj = fe2VarI.s(this);
            if (obj == objC) {
                return objC;
            }
            n92Var2 = n92Var;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
                return m42.f6769a;
            }
            n92Var = (n92) this.c;
            n92Var2 = (n92) this.f3242b;
            wd2Var = (wd2) this.f3240a;
            h42.b(obj);
        }
        n92Var.f6891a = (eh0) obj;
        if (f92.a(this.f7660a.S(), this.f3241a)) {
            fg2 fg2VarC = qe2.c();
            u51 u51Var = new u51(this, n92Var2, null);
            this.f3240a = wd2Var;
            this.f3242b = n92Var2;
            this.b = 2;
            if (oc2.g(fg2VarC, u51Var, this) == objC) {
                return objC;
            }
        }
        return m42.f6769a;
    }
}

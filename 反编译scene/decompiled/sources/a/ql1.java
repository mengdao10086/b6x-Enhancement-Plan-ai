package a;

import a.p80;
import com.omarea.Scene;
import com.omarea.model.ExchangeResponse;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.dialogs.DialogExchange$exchange$1", f = "DialogExchange.kt", l = {}, m = "invokeSuspend")
public final class ql1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nm1 f7220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f2574a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2575a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2576a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f2577b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ql1(nm1 nm1Var, String str, boolean z, p80.b bVar, b62 b62Var) {
        super(2, b62Var);
        this.f7220a = nm1Var;
        this.f2576a = str;
        this.f2577b = z;
        this.f2574a = bVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ql1 ql1Var = new ql1(this.f7220a, this.f2576a, this.f2577b, this.f2574a, b62Var);
        ql1Var.f2575a = (wd2) obj;
        return ql1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ql1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ExchangeResponse exchangeResponseC = new mp0(this.f7220a.f2115a).C(this.f2576a, this.f2577b);
        this.f7220a.r(false);
        if (exchangeResponseC != null) {
            Scene.f4798a.i(new pl1(this, exchangeResponseC));
        } else {
            Scene.c cVar = Scene.f4798a;
            String string = cVar.c().getString(u61.license_no_response);
            f92.c(string, "Scene.context.getString(…ring.license_no_response)");
            Scene.c.p(cVar, string, 0, 2, null);
        }
        return m42.f6769a;
    }
}

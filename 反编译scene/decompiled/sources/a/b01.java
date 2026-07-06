package a;

import a.zz0;
import android.graphics.drawable.Drawable;
import com.omarea.model.AppInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class b01 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5659a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zz0.a f185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zz0 f186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AppInfo f187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f188a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f189a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ zz0.a f190b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f191b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b01(zz0.a aVar, b62 b62Var, zz0 zz0Var, AppInfo appInfo, zz0.a aVar2, String str) {
        super(2, b62Var);
        this.f185a = aVar;
        this.f186a = zz0Var;
        this.f187a = appInfo;
        this.f190b = aVar2;
        this.f189a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        b01 b01Var = new b01(this.f185a, b62Var, this.f186a, this.f187a, this.f190b, this.f189a);
        b01Var.f5659a = (wd2) obj;
        return b01Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((b01) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, android.widget.ImageView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v6, types: [T, android.graphics.drawable.Drawable] */
    @Override // a.s62
    public final Object j(Object obj) {
        wd2 wd2Var;
        n92 n92Var;
        n92 n92Var2;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2Var = this.f5659a;
            n92Var = new n92();
            fe2<Drawable> fe2VarL = this.f186a.f8111a.l(this.f187a.getPackageName());
            this.f188a = wd2Var;
            this.f191b = n92Var;
            this.c = n92Var;
            this.b = 1;
            obj = fe2VarL.s(this);
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
            n92Var2 = (n92) this.f191b;
            wd2Var = (wd2) this.f188a;
            h42.b(obj);
        }
        n92Var.f6891a = (Drawable) obj;
        n92 n92Var3 = new n92();
        ?? O = this.f185a.O();
        f92.b(O);
        n92Var3.f6891a = O;
        if (((Drawable) n92Var2.f6891a) != null && f92.a(this.f190b.Q(), this.f189a)) {
            fg2 fg2VarC = qe2.c();
            a01 a01Var = new a01(n92Var3, n92Var2, null);
            this.f188a = wd2Var;
            this.f191b = n92Var2;
            this.c = n92Var3;
            this.b = 2;
            if (oc2.g(fg2VarC, a01Var, this) == objC) {
                return objC;
            }
        }
        return m42.f6769a;
    }
}

package a;

import android.widget.EditText;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.FormValueHandler$bindInputDecimal$1", f = "FormValueHandler.kt", l = {170}, m = "invokeSuspend")
public final class ki0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j92 f6610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rh0 f1636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1637a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f1638a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1639a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f1640b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ki0(rh0 rh0Var, j92 j92Var, EditText editText, b62 b62Var) {
        super(2, b62Var);
        this.f1636a = rh0Var;
        this.f6610a = j92Var;
        this.f1638a = editText;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ki0 ki0Var = new ki0(this.f1636a, this.f6610a, this.f1638a, b62Var);
        ki0Var.f1637a = (wd2) obj;
        return ki0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ki0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        try {
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f1637a;
                j92 j92Var = new j92();
                double dDoubleValue = ((Number) this.f1636a.getValue()).doubleValue();
                j92Var.f6490a = dDoubleValue;
                this.f6610a.f6490a = dDoubleValue;
                fg2 fg2VarC = qe2.c();
                ji0 ji0Var = new ji0(this, j92Var, null);
                this.f1639a = wd2Var;
                this.f1640b = j92Var;
                this.b = 1;
                if (oc2.g(fg2VarC, ji0Var, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
        } catch (Exception unused) {
        }
        return m42.f6769a;
    }
}

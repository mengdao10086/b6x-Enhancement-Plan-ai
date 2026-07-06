package a;

import a.p80;
import com.omarea.vtools.activities.ActivityImg;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityImg$exportConfirm$1$1$1", f = "ActivityImg.kt", l = {}, m = "invokeSuspend")
public final class jc1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kc1 f6497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f1523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1524a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jc1(kc1 kc1Var, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f6497a = kc1Var;
        this.f1523a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        jc1 jc1Var = new jc1(this.f6497a, this.f1523a, b62Var);
        jc1Var.f1524a = (wd2) obj;
        return jc1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((jc1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        ActivityImg activityImg;
        int i;
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ((u90) this.f6497a.f6592a.f6891a).c();
        p80.a aVar = p80.f2403a;
        ActivityImg activityImg2 = ActivityImg.this;
        if (f92.a((String) this.f1523a.f6891a, "0")) {
            activityImg = ActivityImg.this;
            i = u61.img_succeed;
        } else {
            activityImg = ActivityImg.this;
            i = u61.img_fail;
        }
        String string = activityImg.getString(i);
        f92.c(string, "if (r == \"0\") {\n        …il)\n                    }");
        p80.a.B(aVar, activityImg2, string, "", null, 8, null);
        return m42.f6769a;
    }
}

package a;

import android.widget.ListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentAppSystem$setList$1$1", f = "FragmentAppSystem.kt", l = {}, m = "invokeSuspend")
public final class cr1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dr1 f5822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f440a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr1(dr1 dr1Var, b62 b62Var) {
        super(2, b62Var);
        this.f5822a = dr1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        cr1 cr1Var = new cr1(this.f5822a, b62Var);
        cr1Var.f440a = (wd2) obj;
        return cr1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((cr1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        gr1.A1(this.f5822a.f5931a).c();
        ListView listView = (ListView) this.f5822a.f5931a.w1(t61.app_list);
        if (listView != null) {
            gr1 gr1Var = this.f5822a.f5931a;
            gr1Var.L1(gr1Var.F1(), listView);
        }
        return m42.f6769a;
    }
}

package a;

import android.widget.ListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentAppBackup$setList$1$1", f = "FragmentAppBackup.kt", l = {}, m = "invokeSuspend")
public final class sq1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tq1 f7423a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2917a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sq1(tq1 tq1Var, b62 b62Var) {
        super(2, b62Var);
        this.f7423a = tq1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        sq1 sq1Var = new sq1(this.f7423a, b62Var);
        sq1Var.f2917a = (wd2) obj;
        return sq1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((sq1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        wq1.A1(this.f7423a.f3055a).c();
        ListView listView = (ListView) this.f7423a.f3055a.w1(t61.app_list);
        if (listView != null) {
            wq1 wq1Var = this.f7423a.f3055a;
            wq1Var.L1(wq1Var.F1(), listView);
        }
        return m42.f6769a;
    }
}

package a;

import android.widget.ListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentAppUser$setList$1$1", f = "FragmentAppUser.kt", l = {}, m = "invokeSuspend")
public final class nr1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ or1 f6942a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2153a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nr1(or1 or1Var, b62 b62Var) {
        super(2, b62Var);
        this.f6942a = or1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        nr1 nr1Var = new nr1(this.f6942a, b62Var);
        nr1Var.f2153a = (wd2) obj;
        return nr1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((nr1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        rr1.B1(this.f6942a.f7050a).c();
        ListView listView = (ListView) this.f6942a.f7050a.w1(t61.app_list);
        if (listView != null) {
            rr1 rr1Var = this.f6942a.f7050a;
            rr1Var.M1(rr1Var.G1(), listView);
        }
        return m42.f6769a;
    }
}

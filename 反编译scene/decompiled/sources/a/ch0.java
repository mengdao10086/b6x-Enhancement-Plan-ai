package a;

import android.content.pm.PackageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.AppContents$buildCache$1", f = "AppContents.kt", l = {139}, m = "invokeSuspend")
public final class ch0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dh0 f5792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f402a;
    public int b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ch0(dh0 dh0Var, n92 n92Var, int i, b62 b62Var) {
        super(2, b62Var);
        this.f5792a = dh0Var;
        this.f400a = n92Var;
        this.c = i;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ch0 ch0Var = new ch0(this.f5792a, this.f400a, this.c, b62Var);
        ch0Var.f401a = (wd2) obj;
        return ch0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ch0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f401a;
            List list = (List) this.f400a.f6891a;
            ArrayList arrayList = new ArrayList(z42.m(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(qc2.b(wd2Var, null, null, new bh0((PackageInfo) it.next(), null, this, wd2Var), 3, null));
            }
            this.f402a = wd2Var;
            this.b = 1;
            if (lc2.a(arrayList, this) == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        this.f5792a.f5900a.e();
        return m42.f6769a;
    }
}

package a;

import a.p80;
import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityApplications;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityApplications$onOptionsItemSelected$1$1", f = "ActivityApplications.kt", l = {}, m = "invokeSuspend")
public final class a91 extends d72 implements k82<wd2, b62<? super Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f50a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityApplications.g f51a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ List f52a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a91(ActivityApplications.g gVar, List list, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f51a = gVar;
        this.f52a = list;
        this.f5583a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        a91 a91Var = new a91(this.f51a, this.f52a, this.f5583a, b62Var);
        a91Var.f50a = (wd2) obj;
        return a91Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super Object> b62Var) {
        return ((a91) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        if (this.f52a.isEmpty()) {
            ((p80.b) this.f51a.f8567a.f6891a).c();
            Scene.c.p(Scene.f4798a, "没有可移除的应用", 0, 2, null);
            return m42.f6769a;
        }
        ((p80.b) this.f51a.f8567a.f6891a).c();
        p80.a aVar = p80.f2403a;
        ActivityApplications activityApplications = ActivityApplications.this;
        StringBuilder sb = new StringBuilder();
        sb.append("根据此前的应用使用记录，Scene会帮你移除以下应用：\n");
        List list = this.f52a;
        ArrayList arrayList = new ArrayList(z42.m(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((eh0) pc2.b(null, new z81((String) it.next(), null, this), 1, null)).a());
        }
        sb.append(i52.H(arrayList, "\n", null, null, 0, null, null, 62, null));
        return aVar.M(activityApplications, (16 & 2) != 0 ? "" : "卸载应用", (16 & 4) != 0 ? "" : sb.toString(), (16 & 8) != 0 ? null : new y81(this), (16 & 16) != 0 ? null : null);
    }
}

package a;

import a.p80;
import com.omarea.vtools.activities.ActivityApplications;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityApplications$onOptionsItemSelected$1$2", f = "ActivityApplications.kt", l = {}, m = "invokeSuspend")
public final class b91 extends d72 implements k82<wd2, b62<? super p80.b>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityApplications.g f248a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b91(ActivityApplications.g gVar, b62 b62Var) {
        super(2, b62Var);
        this.f248a = gVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        b91 b91Var = new b91(this.f248a, b62Var);
        b91Var.f5685a = (wd2) obj;
        return b91Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super p80.b> b62Var) {
        return ((b91) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ((p80.b) this.f248a.f8567a.f6891a).c();
        return p80.a.C(p80.f2403a, ActivityApplications.this, "Scene并不提供应用卸载建议。只有你主动将(Scene的)设置同步到服务器，才能在此按照以前的偏好，对系统自带应用完成一键卸载。", null, 4, null);
    }
}

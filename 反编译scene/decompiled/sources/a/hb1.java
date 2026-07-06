package a;

import com.omarea.vtools.activities.ActivityFpsSessions;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFpsSessions$loadData$1$2", f = "ActivityFpsSessions.kt", l = {}, m = "invokeSuspend")
public final class hb1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f6298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFpsSessions.d f1152a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb1(ActivityFpsSessions.d dVar, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f1152a = dVar;
        this.f6298a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        hb1 hb1Var = new hb1(this.f1152a, this.f6298a, b62Var);
        hb1Var.f1151a = (wd2) obj;
        return hb1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((hb1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        if (ActivityFpsSessions.this.isDestroyed()) {
            return m42.f6769a;
        }
        ActivityFpsSessions.this.F((ArrayList) this.f6298a.f6891a);
        return m42.f6769a;
    }
}

package a;

import com.omarea.sysmbol.PerfOptionsRender;
import com.omarea.vtools.activities.ActivityPerfOptions;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityPerfOptions$onViewCreated$1$1", f = "ActivityPerfOptions.kt", l = {}, m = "invokeSuspend")
public final class be1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityPerfOptions.b f267a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be1(ActivityPerfOptions.b bVar, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f267a = bVar;
        this.f5699a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        be1 be1Var = new be1(this.f267a, this.f5699a, b62Var);
        be1Var.f266a = (wd2) obj;
        return be1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((be1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        if (!ActivityPerfOptions.this.isDestroyed() && ((ArrayList) this.f5699a.f6891a) != null) {
            ((PerfOptionsRender) ActivityPerfOptions.this._$_findCachedViewById(t61.perf_options)).n((ArrayList) this.f5699a.f6891a, ActivityPerfOptions.this.f5396a);
        }
        return m42.f6769a;
    }
}

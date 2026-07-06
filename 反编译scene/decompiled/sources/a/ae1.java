package a;

import com.omarea.ui.SeekBar;
import com.omarea.ui.Tags;
import com.omarea.vtools.activities.ActivityPerfBench;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ae1 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f5599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityPerfBench.h f64a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae1(ActivityPerfBench.h hVar, long j) {
        super(1);
        this.f64a = hVar;
        this.f5599a = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(l30 l30Var) throws Exception {
        f92.d(l30Var, "$receiver");
        l30Var.E("coreCount", Integer.valueOf(((SeekBar) ActivityPerfBench.this._$_findCachedViewById(t61.cpu_bench_threads)).getProgress()));
        l30Var.E("targetLoad", Integer.valueOf(((SeekBar) ActivityPerfBench.this._$_findCachedViewById(t61.cpu_bench_load)).getProgress()));
        l30Var.E("durationMS", Long.valueOf(this.f5599a));
        l30Var.E("period", Integer.valueOf(((SeekBar) ActivityPerfBench.this._$_findCachedViewById(t61.cpu_bench_period)).getProgress()));
        l30Var.E("mode", ((Tags) ActivityPerfBench.this._$_findCachedViewById(t61.cpu_load_type)).getCheckedIndex() == 1 ? "float" : "int");
        l30Var.H("cpus", s42.h((boolean[]) this.f64a.f8797a.f6891a));
        l30Var.E("smartCore", Boolean.FALSE);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}

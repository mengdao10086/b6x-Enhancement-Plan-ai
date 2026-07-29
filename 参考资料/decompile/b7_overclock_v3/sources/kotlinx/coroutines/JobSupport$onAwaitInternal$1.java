package kotlinx.coroutines;

import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class JobSupport$onAwaitInternal$1 extends FunctionReferenceImpl implements ik.q<JobSupport, kotlinx.coroutines.selects.j<?>, Object, kotlin.z1> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final JobSupport$onAwaitInternal$1 f38261c = new JobSupport$onAwaitInternal$1();

    public JobSupport$onAwaitInternal$1() {
        super(3, JobSupport.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // ik.q
    public /* bridge */ /* synthetic */ kotlin.z1 A(JobSupport jobSupport, kotlinx.coroutines.selects.j<?> jVar, Object obj) {
        X0(jobSupport, jVar, obj);
        return kotlin.z1.f38230a;
    }

    public final void X0(@yt.k JobSupport jobSupport, @yt.k kotlinx.coroutines.selects.j<?> jVar, @yt.l Object obj) {
        jobSupport.g1(jVar, obj);
    }
}

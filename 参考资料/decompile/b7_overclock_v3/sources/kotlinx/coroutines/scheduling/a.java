package kotlinx.coroutines.scheduling;

import hk.h;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    @h(name = "isSchedulerWorker")
    public static final boolean a(@k Thread thread) {
        return thread instanceof CoroutineScheduler.c;
    }

    @h(name = "mayNotBlock")
    public static final boolean b(@k Thread thread) {
        return (thread instanceof CoroutineScheduler.c) && ((CoroutineScheduler.c) thread).f38986c == CoroutineScheduler.WorkerState.CPU_ACQUIRED;
    }
}

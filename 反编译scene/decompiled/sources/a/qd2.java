package a;

import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class qd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<CoroutineExceptionHandler> f7202a = wa2.g(ta2.a(a.a()));

    public static final void a(l62 l62Var, Throwable th) {
        Iterator<CoroutineExceptionHandler> it = f7202a.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(l62Var, th);
            } catch (Throwable th2) {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, rd2.b(th, th2));
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}

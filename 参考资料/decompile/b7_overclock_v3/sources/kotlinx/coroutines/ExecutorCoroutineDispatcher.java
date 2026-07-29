package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final Key f38237c = new Key(null);

    @kotlin.q
    public static final class Key extends kotlin.coroutines.b<CoroutineDispatcher, ExecutorCoroutineDispatcher> {
        public Key() {
            super(CoroutineDispatcher.f38234b, new ik.l<CoroutineContext.a, ExecutorCoroutineDispatcher>() { // from class: kotlinx.coroutines.ExecutorCoroutineDispatcher.Key.1
                @Override // ik.l
                @yt.l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final ExecutorCoroutineDispatcher i(@yt.k CoroutineContext.a aVar) {
                    if (aVar instanceof ExecutorCoroutineDispatcher) {
                        return (ExecutorCoroutineDispatcher) aVar;
                    }
                    return null;
                }
            });
        }

        public /* synthetic */ Key(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public abstract void close();

    @yt.k
    public abstract Executor m2();
}

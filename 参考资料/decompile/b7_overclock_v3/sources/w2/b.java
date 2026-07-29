package w2;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import g.n0;
import java.util.concurrent.Executor;
import v2.j;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b implements w2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f53833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f53834b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f53835c = new a();

    public class a implements Executor {
        public a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@n0 Runnable command) {
            b.this.a(command);
        }
    }

    public b(@n0 Executor backgroundExecutor) {
        this.f53833a = new j(backgroundExecutor);
    }

    @Override // w2.a
    public void a(Runnable runnable) {
        this.f53834b.post(runnable);
    }

    @Override // w2.a
    public Executor b() {
        return this.f53835c;
    }

    @Override // w2.a
    public void c(Runnable runnable) {
        this.f53833a.execute(runnable);
    }

    @Override // w2.a
    @n0
    public j d() {
        return this.f53833a;
    }
}

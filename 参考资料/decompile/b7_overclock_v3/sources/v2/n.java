package v2;

import androidx.annotation.RestrictTo;
import g.n0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class n implements Executor {
    @Override // java.util.concurrent.Executor
    public void execute(@n0 Runnable command) {
        command.run();
    }
}

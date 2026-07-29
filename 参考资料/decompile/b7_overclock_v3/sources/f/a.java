package f;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<I, O> {

    /* JADX INFO: renamed from: f.a$a, reason: collision with other inner class name */
    public static final class C0315a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f27337a;

        public C0315a(T t10) {
            this.f27337a = t10;
        }

        public final T a() {
            return this.f27337a;
        }
    }

    @k
    public abstract Intent a(@k Context context, I i10);

    @l
    public C0315a<O> b(@k Context context, I i10) {
        f0.p(context, "context");
        return null;
    }

    public abstract O c(int i10, @l Intent intent);
}

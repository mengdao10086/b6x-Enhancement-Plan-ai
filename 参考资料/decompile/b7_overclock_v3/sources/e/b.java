package e;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final Set<c> f26538a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public volatile Context f26539b;

    public final void a(@k c listener) {
        f0.p(listener, "listener");
        Context context = this.f26539b;
        if (context != null) {
            listener.a(context);
        }
        this.f26538a.add(listener);
    }

    public final void b() {
        this.f26539b = null;
    }

    public final void c(@k Context context) {
        f0.p(context, "context");
        this.f26539b = context;
        Iterator<c> it2 = this.f26538a.iterator();
        while (it2.hasNext()) {
            it2.next().a(context);
        }
    }

    @l
    public final Context d() {
        return this.f26539b;
    }

    public final void e(@k c listener) {
        f0.p(listener, "listener");
        this.f26538a.remove(listener);
    }
}

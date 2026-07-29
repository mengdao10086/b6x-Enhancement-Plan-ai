package androidx.work;

import android.content.Context;
import androidx.work.a;
import g.n0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class WorkManagerInitializer implements e2.a<v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8296a = l.f("WrkMgrInitializer");

    @Override // e2.a
    @n0
    public List<Class<? extends e2.a<?>>> a() {
        return Collections.emptyList();
    }

    @Override // e2.a
    @n0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public v b(@n0 Context context) {
        l.c().a(f8296a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        v.A(context, new a.b().a());
        return v.p(context);
    }
}

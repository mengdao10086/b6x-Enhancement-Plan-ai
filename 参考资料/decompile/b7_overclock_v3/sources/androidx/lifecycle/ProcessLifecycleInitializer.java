package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.o0;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcessLifecycleInitializer implements e2.a<y> {
    @Override // e2.a
    @yt.k
    public List<Class<? extends e2.a<?>>> a() {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // e2.a
    @yt.k
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public y b(@yt.k Context context) {
        kotlin.jvm.internal.f0.p(context, "context");
        androidx.startup.a aVarE = androidx.startup.a.e(context);
        kotlin.jvm.internal.f0.o(aVarE, "getInstance(context)");
        if (!aVarE.g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
        }
        u.a(context);
        o0.b bVar = o0.f6218i;
        bVar.c(context);
        return bVar.a();
    }
}

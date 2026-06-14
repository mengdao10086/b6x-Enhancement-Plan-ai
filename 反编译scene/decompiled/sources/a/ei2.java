package a;

import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ei2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fg2 f6009a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final boolean f741a;

    static {
        ei2 ei2Var = new ei2();
        f741a = mi2.e("kotlinx.coroutines.fast.service.loader", true);
        f6009a = ei2Var.a();
    }

    public final fg2 a() {
        Object next;
        fg2 fg2VarD;
        try {
            List<MainDispatcherFactory> listC = f741a ? uh2.f7599a.c() : wa2.g(ta2.a(a.b()));
            Iterator<T> it = listC.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            return (mainDispatcherFactory == null || (fg2VarD = fi2.d(mainDispatcherFactory, listC)) == null) ? fi2.b(null, null, 3, null) : fg2VarD;
        } catch (Throwable th) {
            return fi2.b(th, null, 2, null);
        }
    }
}

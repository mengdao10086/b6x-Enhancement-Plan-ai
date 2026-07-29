package tt;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<i> f51687d = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f51688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f51689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f51690c;

    public i(Object obj, p pVar) {
        this.f51688a = obj;
        this.f51689b = pVar;
    }

    public static i a(p pVar, Object obj) {
        List<i> list = f51687d;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new i(obj, pVar);
            }
            i iVarRemove = list.remove(size - 1);
            iVarRemove.f51688a = obj;
            iVarRemove.f51689b = pVar;
            iVarRemove.f51690c = null;
            return iVarRemove;
        }
    }

    public static void b(i iVar) {
        iVar.f51688a = null;
        iVar.f51689b = null;
        iVar.f51690c = null;
        List<i> list = f51687d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(iVar);
            }
        }
    }
}

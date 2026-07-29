package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Object> f37955a;

    public u0(int i10) {
        this.f37955a = new ArrayList<>(i10);
    }

    public void a(Object obj) {
        this.f37955a.add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f37955a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f37955a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f37955a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it2 = ((Iterable) obj).iterator();
            while (it2.hasNext()) {
                this.f37955a.add(it2.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it3 = (Iterator) obj;
            while (it3.hasNext()) {
                this.f37955a.add(it3.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int c() {
        return this.f37955a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f37955a.toArray(objArr);
    }
}

package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class w0<T> extends c3 {
    public w0(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public abstract void g(c2.i iVar, T t10);

    public final void h(Iterable<? extends T> iterable) {
        c2.i iVarA = a();
        try {
            Iterator<? extends T> it2 = iterable.iterator();
            while (it2.hasNext()) {
                g(iVarA, it2.next());
                iVarA.Z1();
            }
        } finally {
            f(iVarA);
        }
    }

    public final void i(T t10) {
        c2.i iVarA = a();
        try {
            g(iVarA, t10);
            iVarA.Z1();
        } finally {
            f(iVarA);
        }
    }

    public final void j(T[] tArr) {
        c2.i iVarA = a();
        try {
            for (T t10 : tArr) {
                g(iVarA, t10);
                iVarA.Z1();
            }
        } finally {
            f(iVarA);
        }
    }

    public final long k(T t10) {
        c2.i iVarA = a();
        try {
            g(iVarA, t10);
            return iVarA.Z1();
        } finally {
            f(iVarA);
        }
    }

    public final long[] l(Collection<? extends T> collection) {
        c2.i iVarA = a();
        try {
            long[] jArr = new long[collection.size()];
            int i10 = 0;
            Iterator<? extends T> it2 = collection.iterator();
            while (it2.hasNext()) {
                g(iVarA, it2.next());
                jArr[i10] = iVarA.Z1();
                i10++;
            }
            return jArr;
        } finally {
            f(iVarA);
        }
    }

    public final long[] m(T[] tArr) {
        c2.i iVarA = a();
        try {
            long[] jArr = new long[tArr.length];
            int i10 = 0;
            for (T t10 : tArr) {
                g(iVarA, t10);
                jArr[i10] = iVarA.Z1();
                i10++;
            }
            return jArr;
        } finally {
            f(iVarA);
        }
    }

    public final Long[] n(Collection<? extends T> collection) {
        c2.i iVarA = a();
        try {
            Long[] lArr = new Long[collection.size()];
            int i10 = 0;
            Iterator<? extends T> it2 = collection.iterator();
            while (it2.hasNext()) {
                g(iVarA, it2.next());
                lArr[i10] = Long.valueOf(iVarA.Z1());
                i10++;
            }
            return lArr;
        } finally {
            f(iVarA);
        }
    }

    public final Long[] o(T[] tArr) {
        c2.i iVarA = a();
        try {
            Long[] lArr = new Long[tArr.length];
            int i10 = 0;
            for (T t10 : tArr) {
                g(iVarA, t10);
                lArr[i10] = Long.valueOf(iVarA.Z1());
                i10++;
            }
            return lArr;
        } finally {
            f(iVarA);
        }
    }

    public final List<Long> p(Collection<? extends T> collection) {
        c2.i iVarA = a();
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            int i10 = 0;
            Iterator<? extends T> it2 = collection.iterator();
            while (it2.hasNext()) {
                g(iVarA, it2.next());
                arrayList.add(i10, Long.valueOf(iVarA.Z1()));
                i10++;
            }
            return arrayList;
        } finally {
            f(iVarA);
        }
    }

    public final List<Long> q(T[] tArr) {
        c2.i iVarA = a();
        try {
            ArrayList arrayList = new ArrayList(tArr.length);
            int i10 = 0;
            for (T t10 : tArr) {
                g(iVarA, t10);
                arrayList.add(i10, Long.valueOf(iVarA.Z1()));
                i10++;
            }
            return arrayList;
        } finally {
            f(iVarA);
        }
    }
}

package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class v0<T> extends c3 {
    public v0(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    @Override // androidx.room.c3
    public abstract String d();

    public abstract void g(c2.i iVar, T t10);

    public final int h(T t10) {
        c2.i iVarA = a();
        try {
            g(iVarA, t10);
            return iVarA.a0();
        } finally {
            f(iVarA);
        }
    }

    public final int i(Iterable<? extends T> iterable) {
        c2.i iVarA = a();
        int iA0 = 0;
        try {
            Iterator<? extends T> it2 = iterable.iterator();
            while (it2.hasNext()) {
                g(iVarA, it2.next());
                iA0 += iVarA.a0();
            }
            return iA0;
        } finally {
            f(iVarA);
        }
    }

    public final int j(T[] tArr) {
        c2.i iVarA = a();
        try {
            int iA0 = 0;
            for (T t10 : tArr) {
                g(iVarA, t10);
                iA0 += iVarA.a0();
            }
            return iA0;
        } finally {
            f(iVarA);
        }
    }
}

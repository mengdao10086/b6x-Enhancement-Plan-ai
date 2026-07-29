package androidx.core.util;

import androidx.annotation.RestrictTo;
import com.blankj.utilcode.util.i0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class f {
    public static void a(Object obj, StringBuilder sb2) {
        int iLastIndexOf;
        if (obj == null) {
            sb2.append(i0.f11859x);
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(iLastIndexOf + 1);
        }
        sb2.append(simpleName);
        sb2.append('{');
        sb2.append(Integer.toHexString(System.identityHashCode(obj)));
    }
}

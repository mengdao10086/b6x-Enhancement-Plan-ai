package sh;

import android.content.Context;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.Item;
import java.util.Iterator;
import java.util.Set;
import th.b;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f49838a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f49839b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f49840c = 1024;

    public abstract Set<MimeType> a();

    public abstract b b(Context context, Item item);

    public boolean c(Context context, Item item) {
        Iterator<MimeType> it2 = a().iterator();
        while (it2.hasNext()) {
            if (it2.next().checkType(context.getContentResolver(), item.a())) {
                return true;
            }
        }
        return false;
    }
}

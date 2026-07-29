package androidx.work;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public interface s {
    @n0
    ListenableFuture<Void> a(@n0 Context context, @n0 UUID id2, @n0 d data);
}

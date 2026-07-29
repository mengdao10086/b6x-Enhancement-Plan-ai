package kotlinx.coroutines.stream;

import java.util.stream.Stream;
import kotlinx.coroutines.flow.e;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    @k
    public static final <T> e<T> a(@k Stream<T> stream) {
        return new StreamFlow(stream);
    }
}

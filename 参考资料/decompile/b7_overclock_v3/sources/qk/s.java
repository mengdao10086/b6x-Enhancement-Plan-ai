package qk;

import java.lang.Comparable;
import kotlin.jvm.internal.f0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.7")
@kotlin.q
public interface s<T extends Comparable<? super T>> {

    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@yt.k s<T> sVar, @yt.k T value) {
            f0.p(value, "value");
            return value.compareTo(sVar.a()) >= 0 && value.compareTo(sVar.d()) < 0;
        }

        public static <T extends Comparable<? super T>> boolean b(@yt.k s<T> sVar) {
            return sVar.a().compareTo(sVar.d()) >= 0;
        }
    }

    @yt.k
    T a();

    boolean contains(@yt.k T t10);

    @yt.k
    T d();

    boolean isEmpty();
}

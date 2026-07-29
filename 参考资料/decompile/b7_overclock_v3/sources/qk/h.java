package qk;

import java.lang.Comparable;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public interface h<T extends Comparable<? super T>> {

    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@yt.k h<T> hVar, @yt.k T value) {
            f0.p(value, "value");
            return value.compareTo(hVar.a()) >= 0 && value.compareTo(hVar.e()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(@yt.k h<T> hVar) {
            return hVar.a().compareTo(hVar.e()) > 0;
        }
    }

    @yt.k
    T a();

    boolean contains(@yt.k T t10);

    @yt.k
    T e();

    boolean isEmpty();
}

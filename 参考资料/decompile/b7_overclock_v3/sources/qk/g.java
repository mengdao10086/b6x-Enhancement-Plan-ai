package qk;

import java.lang.Comparable;
import kotlin.jvm.internal.f0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.1")
public interface g<T extends Comparable<? super T>> extends h<T> {

    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@yt.k g<T> gVar, @yt.k T value) {
            f0.p(value, "value");
            return gVar.b(gVar.a(), value) && gVar.b(value, gVar.e());
        }

        public static <T extends Comparable<? super T>> boolean b(@yt.k g<T> gVar) {
            return !gVar.b(gVar.a(), gVar.e());
        }
    }

    boolean b(@yt.k T t10, @yt.k T t11);

    @Override // qk.h
    boolean contains(@yt.k T t10);

    @Override // qk.h
    boolean isEmpty();
}

package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import okhttp3.e0;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.f;

/* JADX INFO: loaded from: classes6.dex */
@IgnoreJRERequirement
public final class m extends f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f.a f48618a = new m();

    @IgnoreJRERequirement
    public static final class a<T> implements f<e0, Optional<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f<e0, T> f48619a;

        public a(f<e0, T> fVar) {
            this.f48619a = fVar;
        }

        @Override // retrofit2.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Optional<T> a(e0 e0Var) throws IOException {
            return Optional.ofNullable(this.f48619a.a(e0Var));
        }
    }

    @Override // retrofit2.f.a
    @Nullable
    public f<e0, ?> d(Type type, Annotation[] annotationArr, s sVar) {
        if (f.a.b(type) != Optional.class) {
            return null;
        }
        return new a(sVar.n(f.a.a(0, (ParameterizedType) type), annotationArr));
    }
}

package mu;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.c0;
import okhttp3.e0;
import retrofit2.f;
import retrofit2.s;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f41695a;

    public a(Gson gson) {
        this.f41695a = gson;
    }

    public static a f() {
        return g(new Gson());
    }

    public static a g(Gson gson) {
        Objects.requireNonNull(gson, "gson == null");
        return new a(gson);
    }

    @Override // retrofit2.f.a
    public f<?, c0> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        return new b(this.f41695a, this.f41695a.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.f.a
    public f<e0, ?> d(Type type, Annotation[] annotationArr, s sVar) {
        return new c(this.f41695a, this.f41695a.getAdapter(TypeToken.get(type)));
    }
}

package mu;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.c0;
import okhttp3.w;
import okio.j;
import retrofit2.f;

/* JADX INFO: loaded from: classes6.dex */
public final class b<T> implements f<T, c0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w f41696c = w.h("application/json; charset=UTF-8");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f41697d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f41698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f41699b;

    public b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f41698a = gson;
        this.f41699b = typeAdapter;
    }

    @Override // retrofit2.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c0 a(T t10) throws IOException {
        j jVar = new j();
        JsonWriter jsonWriterNewJsonWriter = this.f41698a.newJsonWriter(new OutputStreamWriter(jVar.a2(), f41697d));
        this.f41699b.write(jsonWriterNewJsonWriter, t10);
        jsonWriterNewJsonWriter.close();
        return c0.g(f41696c, jVar.Z0());
    }
}

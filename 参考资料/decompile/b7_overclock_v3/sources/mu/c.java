package mu;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import okhttp3.e0;
import retrofit2.f;

/* JADX INFO: loaded from: classes6.dex */
public final class c<T> implements f<e0, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f41700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f41701b;

    public c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f41700a = gson;
        this.f41701b = typeAdapter;
    }

    @Override // retrofit2.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(e0 e0Var) throws IOException {
        JsonReader jsonReaderNewJsonReader = this.f41700a.newJsonReader(e0Var.charStream());
        try {
            T t10 = this.f41701b.read(jsonReaderNewJsonReader);
            if (jsonReaderNewJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return t10;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            e0Var.close();
        }
    }
}

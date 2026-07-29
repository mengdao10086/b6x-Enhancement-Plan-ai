package retrofit2;

import com.blankj.utilcode.util.i0;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class HttpException extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient r<?> f48558a;
    private final int code;
    private final String message;

    public HttpException(r<?> rVar) {
        super(b(rVar));
        this.code = rVar.b();
        this.message = rVar.h();
        this.f48558a = rVar;
    }

    public static String b(r<?> rVar) {
        Objects.requireNonNull(rVar, "response == null");
        return "HTTP " + rVar.b() + i0.f11861z + rVar.h();
    }

    public int a() {
        return this.code;
    }

    public String c() {
        return this.message;
    }

    @Nullable
    public r<?> d() {
        return this.f48558a;
    }
}

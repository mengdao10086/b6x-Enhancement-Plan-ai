package b4;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.d;
import g.n0;
import h4.g;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.e;
import okhttp3.e0;
import okhttp3.f;
import v4.c;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public class a implements d<InputStream>, f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9059g = "OkHttpFetcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e.a f9060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f9061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f9062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e0 f9063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d.a<? super InputStream> f9064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile e f9065f;

    public a(e.a aVar, g gVar) {
        this.f9060a = aVar;
        this.f9061b = gVar;
    }

    @Override // com.bumptech.glide.load.data.d
    @n0
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        try {
            InputStream inputStream = this.f9062c;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        e0 e0Var = this.f9063d;
        if (e0Var != null) {
            e0Var.close();
        }
        this.f9064e = null;
    }

    @Override // okhttp3.f
    public void c(@n0 e eVar, @n0 d0 d0Var) {
        this.f9063d = d0Var.L();
        if (!d0Var.k1()) {
            this.f9064e.c(new HttpException(d0Var.m1(), d0Var.W()));
            return;
        }
        InputStream inputStreamC = c.c(this.f9063d.byteStream(), ((e0) m.d(this.f9063d)).contentLength());
        this.f9062c = inputStreamC;
        this.f9064e.d(inputStreamC);
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        e eVar = this.f9065f;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // okhttp3.f
    public void d(@n0 e eVar, @n0 IOException iOException) {
        this.f9064e.c(iOException);
    }

    @Override // com.bumptech.glide.load.data.d
    @n0
    public DataSource e() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.d
    public void f(@n0 Priority priority, @n0 d.a<? super InputStream> aVar) {
        b0.a aVarB = new b0.a().B(this.f9061b.h());
        for (Map.Entry<String, String> entry : this.f9061b.e().entrySet()) {
            aVarB.a(entry.getKey(), entry.getValue());
        }
        b0 b0VarB = aVarB.b();
        this.f9064e = aVar;
        this.f9065f = this.f9060a.a(b0VarB);
        this.f9065f.b0(this);
    }
}

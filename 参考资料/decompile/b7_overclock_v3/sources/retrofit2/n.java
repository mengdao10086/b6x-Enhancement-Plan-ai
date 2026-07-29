package retrofit2;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.c0;
import okhttp3.x;

/* JADX INFO: loaded from: classes6.dex */
public abstract class n<T> {

    public class a extends n<Iterable<T>> {
        public a() {
        }

        @Override // retrofit2.n
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.p pVar, @Nullable Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            Iterator<T> it2 = iterable.iterator();
            while (it2.hasNext()) {
                n.this.a(pVar, it2.next());
            }
        }
    }

    public class b extends n<Object> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.n
        public void a(retrofit2.p pVar, @Nullable Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i10 = 0; i10 < length; i10++) {
                n.this.a(pVar, Array.get(obj, i10));
            }
        }
    }

    public static final class c<T> extends n<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f48622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final retrofit2.f<T, c0> f48624c;

        public c(Method method, int i10, retrofit2.f<T, c0> fVar) {
            this.f48622a = method;
            this.f48623b = i10;
            this.f48624c = fVar;
        }

        @Override // retrofit2.n
        public void a(retrofit2.p pVar, @Nullable T t10) {
            if (t10 == null) {
                throw w.o(this.f48622a, this.f48623b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                pVar.l(this.f48624c.a(t10));
            } catch (IOException e10) {
                throw w.p(this.f48622a, e10, this.f48623b, "Unable to convert " + t10 + " to RequestBody", new Object[0]);
            }
        }
    }

    public static final class d<T> extends n<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f48625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final retrofit2.f<T, String> f48626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f48627c;

        public d(String str, retrofit2.f<T, String> fVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f48625a = str;
            this.f48626b = fVar;
            this.f48627c = z10;
        }

        @Override // retrofit2.n
        public void a(retrofit2.p pVar, @Nullable T t10) throws IOException {
            String strA;
            if (t10 == null || (strA = this.f48626b.a(t10)) == null) {
                return;
            }
            pVar.a(this.f48625a, strA, this.f48627c);
        }
    }

    public static final class e<T> extends n<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f48628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final retrofit2.f<T, String> f48630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f48631d;

        public e(Method method, int i10, retrofit2.f<T, String> fVar, boolean z10) {
            this.f48628a = method;
            this.f48629b = i10;
            this.f48630c = fVar;
            this.f48631d = z10;
        }

        @Override // retrofit2.n
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.p pVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw w.o(this.f48628a, this.f48629b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw w.o(this.f48628a, this.f48629b, "Field map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw w.o(this.f48628a, this.f48629b, "Field map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strA = this.f48630c.a(value);
                if (strA == null) {
                    throw w.o(this.f48628a, this.f48629b, "Field map value '" + value + "' converted to null by " + this.f48630c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                pVar.a(key, strA, this.f48631d);
            }
        }
    }

    public static final class f<T> extends n<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f48632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final retrofit2.f<T, String> f48633b;

        public f(String str, retrofit2.f<T, String> fVar) {
            Objects.requireNonNull(str, "name == null");
            this.f48632a = str;
            this.f48633b = fVar;
        }

        @Override // retrofit2.n
        public void a(retrofit2.p pVar, @Nullable T t10) throws IOException {
            String strA;
            if (t10 == null || (strA = this.f48633b.a(t10)) == null) {
                return;
            }
            pVar.b(this.f48632a, strA);
        }
    }

    public static final class g<T> extends n<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f48634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final retrofit2.f<T, String> f48636c;

        public g(Method method, int i10, retrofit2.f<T, String> fVar) {
            this.f48634a = method;
            this.f48635b = i10;
            this.f48636c = fVar;
        }

        @Override // retrofit2.n
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.p pVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw w.o(this.f48634a, this.f48635b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw w.o(this.f48634a, this.f48635b, "Header map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw w.o(this.f48634a, this.f48635b, "Header map contained null value for key '" + key + "'.", new Object[0]);
                }
                pVar.b(key, this.f48636c.a(value));
            }
        }
    }

    public static final class h extends n<okhttp3.t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f48637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48638b;

        public h(Method method, int i10) {
            this.f48637a = method;
            this.f48638b = i10;
        }

        @Override // retrofit2.n
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.p pVar, @Nullable okhttp3.t tVar) {
            if (tVar == null) {
                throw w.o(this.f48637a, this.f48638b, "Headers parameter must not be null.", new Object[0]);
            }
            pVar.c(tVar);
        }
    }

    public static final class i<T> extends n<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f48639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final okhttp3.t f48641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final retrofit2.f<T, c0> f48642d;

        public i(Method method, int i10, okhttp3.t tVar, retrofit2.f<T, c0> fVar) {
            this.f48639a = method;
            this.f48640b = i10;
            this.f48641c = tVar;
            this.f48642d = fVar;
        }

        @Override // retrofit2.n
        public void a(retrofit2.p pVar, @Nullable T t10) {
            if (t10 == null) {
                return;
            }
            try {
                pVar.d(this.f48641c, this.f48642d.a(t10));
            } catch (IOException e10) {
                throw w.o(this.f48639a, this.f48640b, "Unable to convert " + t10 + " to RequestBody", e10);
            }
        }
    }

    public static final class j<T> extends n<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f48643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final retrofit2.f<T, c0> f48645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f48646d;

        public j(Method method, int i10, retrofit2.f<T, c0> fVar, String str) {
            this.f48643a = method;
            this.f48644b = i10;
            this.f48645c = fVar;
            this.f48646d = str;
        }

        @Override // retrofit2.n
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.p pVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw w.o(this.f48643a, this.f48644b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw w.o(this.f48643a, this.f48644b, "Part map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw w.o(this.f48643a, this.f48644b, "Part map contained null value for key '" + key + "'.", new Object[0]);
                }
                pVar.d(okhttp3.t.p(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f48646d), this.f48645c.a(value));
            }
        }
    }

    public static final class k<T> extends n<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f48647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f48649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final retrofit2.f<T, String> f48650d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f48651e;

        public k(Method method, int i10, String str, retrofit2.f<T, String> fVar, boolean z10) {
            this.f48647a = method;
            this.f48648b = i10;
            Objects.requireNonNull(str, "name == null");
            this.f48649c = str;
            this.f48650d = fVar;
            this.f48651e = z10;
        }

        @Override // retrofit2.n
        public void a(retrofit2.p pVar, @Nullable T t10) throws IOException {
            if (t10 != null) {
                pVar.f(this.f48649c, this.f48650d.a(t10), this.f48651e);
                return;
            }
            throw w.o(this.f48647a, this.f48648b, "Path parameter \"" + this.f48649c + "\" value must not be null.", new Object[0]);
        }
    }

    public static final class l<T> extends n<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f48652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final retrofit2.f<T, String> f48653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f48654c;

        public l(String str, retrofit2.f<T, String> fVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f48652a = str;
            this.f48653b = fVar;
            this.f48654c = z10;
        }

        @Override // retrofit2.n
        public void a(retrofit2.p pVar, @Nullable T t10) throws IOException {
            String strA;
            if (t10 == null || (strA = this.f48653b.a(t10)) == null) {
                return;
            }
            pVar.g(this.f48652a, strA, this.f48654c);
        }
    }

    public static final class m<T> extends n<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f48655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48656b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final retrofit2.f<T, String> f48657c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f48658d;

        public m(Method method, int i10, retrofit2.f<T, String> fVar, boolean z10) {
            this.f48655a = method;
            this.f48656b = i10;
            this.f48657c = fVar;
            this.f48658d = z10;
        }

        @Override // retrofit2.n
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.p pVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw w.o(this.f48655a, this.f48656b, "Query map was null", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw w.o(this.f48655a, this.f48656b, "Query map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw w.o(this.f48655a, this.f48656b, "Query map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strA = this.f48657c.a(value);
                if (strA == null) {
                    throw w.o(this.f48655a, this.f48656b, "Query map value '" + value + "' converted to null by " + this.f48657c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                pVar.g(key, strA, this.f48658d);
            }
        }
    }

    /* JADX INFO: renamed from: retrofit2.n$n, reason: collision with other inner class name */
    public static final class C0558n<T> extends n<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.f<T, String> f48659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f48660b;

        public C0558n(retrofit2.f<T, String> fVar, boolean z10) {
            this.f48659a = fVar;
            this.f48660b = z10;
        }

        @Override // retrofit2.n
        public void a(retrofit2.p pVar, @Nullable T t10) throws IOException {
            if (t10 == null) {
                return;
            }
            pVar.g(this.f48659a.a(t10), null, this.f48660b);
        }
    }

    public static final class o extends n<x.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f48661a = new o();

        @Override // retrofit2.n
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.p pVar, @Nullable x.c cVar) {
            if (cVar != null) {
                pVar.e(cVar);
            }
        }
    }

    public static final class p extends n<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f48662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48663b;

        public p(Method method, int i10) {
            this.f48662a = method;
            this.f48663b = i10;
        }

        @Override // retrofit2.n
        public void a(retrofit2.p pVar, @Nullable Object obj) {
            if (obj == null) {
                throw w.o(this.f48662a, this.f48663b, "@Url parameter is null.", new Object[0]);
            }
            pVar.m(obj);
        }
    }

    public static final class q<T> extends n<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f48664a;

        public q(Class<T> cls) {
            this.f48664a = cls;
        }

        @Override // retrofit2.n
        public void a(retrofit2.p pVar, @Nullable T t10) {
            pVar.h(this.f48664a, t10);
        }
    }

    public abstract void a(retrofit2.p pVar, @Nullable T t10) throws IOException;

    public final n<Object> b() {
        return new b();
    }

    public final n<Iterable<T>> c() {
        return new a();
    }
}

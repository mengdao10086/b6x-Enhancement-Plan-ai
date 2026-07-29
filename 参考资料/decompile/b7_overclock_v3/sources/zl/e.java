package zl;

import com.arialyy.aria.core.inf.IOptionConstant;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.Protocol;
import xf.j;
import xf.z;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B7\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011\u0012\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0018"}, d2 = {"Lzl/e;", "Lzl/h;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/z1;", "f", "c", j.f55230b, "Ljava/lang/reflect/Method;", "putMethod", "getMethod", "removeMethod", "Ljava/lang/Class;", "clientProviderClass", "serverProviderClass", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V", "a", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class e extends h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @k
    public static final b f58622k = new b(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final Method f58623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public final Method f58624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public final Method f58625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @k
    public final Class<?> f58626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @k
    public final Class<?> f58627j;

    @d0(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ2\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lzl/e$a;", "Ljava/lang/reflect/InvocationHandler;", "", IOptionConstant.proxy, "Ljava/lang/reflect/Method;", z.f55306i, "", "args", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "", "unsupported", "Z", "b", "()Z", "d", "(Z)V", "", "selected", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "", "protocols", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final List<String> f58628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f58629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @l
        public String f58630c;

        public a(@k List<String> protocols) {
            f0.p(protocols, "protocols");
            this.f58628a = protocols;
        }

        @l
        public final String a() {
            return this.f58630c;
        }

        public final boolean b() {
            return this.f58629b;
        }

        public final void c(@l String str) {
            this.f58630c = str;
        }

        public final void d(boolean z10) {
            this.f58629b = z10;
        }

        @Override // java.lang.reflect.InvocationHandler
        @l
        public Object invoke(@k Object proxy, @k Method method, @l Object[] objArr) throws Throwable {
            f0.p(proxy, "proxy");
            f0.p(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (f0.g(name, "supports") && f0.g(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (f0.g(name, "unsupported") && f0.g(Void.TYPE, returnType)) {
                this.f58629b = true;
                return null;
            }
            if (f0.g(name, "protocols")) {
                if (objArr.length == 0) {
                    return this.f58628a;
                }
            }
            if ((!f0.g(name, "selectProtocol") && !f0.g(name, "select")) || !f0.g(String.class, returnType) || objArr.length != 1 || !(objArr[0] instanceof List)) {
                if ((!f0.g(name, "protocolSelected") && !f0.g(name, "selected")) || objArr.length != 1) {
                    return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
                }
                Object obj = objArr[0];
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f58630c = (String) obj;
                return null;
            }
            Object obj2 = objArr[0];
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List list = (List) obj2;
            int size = list.size();
            if (size >= 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    Object obj3 = list.get(i10);
                    Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.String");
                    String str = (String) obj3;
                    if (this.f58628a.contains(str)) {
                        this.f58630c = str;
                        return str;
                    }
                    if (i10 == size) {
                        break;
                    }
                    i10 = i11;
                }
            }
            String str2 = this.f58628a.get(0);
            this.f58630c = str2;
            return str2;
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0006"}, d2 = {"Lzl/e$b;", "", "Lzl/h;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @l
        public final h a() {
            String jvmVersion = System.getProperty("java.specification.version", "unknown");
            try {
                f0.o(jvmVersion, "jvmVersion");
                if (Integer.parseInt(jvmVersion) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName(f0.C("org.eclipse.jetty.alpn.ALPN", "$Provider"), true, null);
                Class<?> clientProviderClass = Class.forName(f0.C("org.eclipse.jetty.alpn.ALPN", "$ClientProvider"), true, null);
                Class<?> serverProviderClass = Class.forName(f0.C("org.eclipse.jetty.alpn.ALPN", "$ServerProvider"), true, null);
                Method putMethod = cls.getMethod("put", SSLSocket.class, cls2);
                Method getMethod = cls.getMethod("get", SSLSocket.class);
                Method removeMethod = cls.getMethod("remove", SSLSocket.class);
                f0.o(putMethod, "putMethod");
                f0.o(getMethod, "getMethod");
                f0.o(removeMethod, "removeMethod");
                f0.o(clientProviderClass, "clientProviderClass");
                f0.o(serverProviderClass, "serverProviderClass");
                return new e(putMethod, getMethod, removeMethod, clientProviderClass, serverProviderClass);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }
    }

    public e(@k Method putMethod, @k Method getMethod, @k Method removeMethod, @k Class<?> clientProviderClass, @k Class<?> serverProviderClass) {
        f0.p(putMethod, "putMethod");
        f0.p(getMethod, "getMethod");
        f0.p(removeMethod, "removeMethod");
        f0.p(clientProviderClass, "clientProviderClass");
        f0.p(serverProviderClass, "serverProviderClass");
        this.f58623f = putMethod;
        this.f58624g = getMethod;
        this.f58625h = removeMethod;
        this.f58626i = clientProviderClass;
        this.f58627j = serverProviderClass;
    }

    @Override // zl.h
    public void c(@k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        try {
            this.f58625h.invoke(null, sslSocket);
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to remove ALPN", e11);
        }
    }

    @Override // zl.h
    public void f(@k SSLSocket sslSocket, @l String str, @k List<? extends Protocol> protocols) {
        f0.p(sslSocket, "sslSocket");
        f0.p(protocols, "protocols");
        try {
            this.f58623f.invoke(null, sslSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f58626i, this.f58627j}, new a(h.f58636a.b(protocols))));
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to set ALPN", e11);
        }
    }

    @Override // zl.h
    @l
    public String j(@k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f58624g.invoke(null, sslSocket));
            if (invocationHandler == null) {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            a aVar = (a) invocationHandler;
            if (!aVar.b() && aVar.a() == null) {
                h.n(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (aVar.b()) {
                return null;
            }
            return aVar.a();
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to get ALPN selected protocol", e11);
        }
    }
}

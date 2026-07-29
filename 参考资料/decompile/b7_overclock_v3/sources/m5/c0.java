package m5;

import com.blankj.utilcode.util.j1;
import com.flydigi.base.net.ApiException;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.LoginBaseResponse;
import com.flydigi.data.R;
import i9.a;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import retrofit2.HttpException;

/* JADX INFO: loaded from: classes2.dex */
public class c0 {
    public static /* synthetic */ LoginBaseResponse A(LoginBaseResponse loginBaseResponse) throws Exception {
        if (loginBaseResponse.state == 0) {
            return loginBaseResponse;
        }
        throw new ApiException(loginBaseResponse.state, loginBaseResponse.msg);
    }

    public static /* synthetic */ xi.e0 B(xi.z zVar) {
        return zVar.A3(new dj.o() { // from class: m5.v
            @Override // dj.o
            public final Object apply(Object obj) {
                return c0.A((LoginBaseResponse) obj);
            }
        });
    }

    public static /* synthetic */ BaseResponse C(BaseResponse baseResponse) throws Exception {
        if (baseResponse.state == 0) {
            return baseResponse;
        }
        throw new ApiException(baseResponse.state, baseResponse.msg);
    }

    public static /* synthetic */ xi.e0 D(Throwable th2) throws Exception {
        return ((th2 instanceof NoRouteToHostException) || (th2 instanceof UnknownHostException) || (th2 instanceof SocketTimeoutException) || (th2 instanceof SSLException)) ? xi.z.f2(new ApiException(ApiException.f13376a, j1.a().getString(R.string.net_state_error))) : xi.z.f2(th2);
    }

    public static /* synthetic */ xi.e0 E(xi.z zVar) throws Exception {
        return zVar.l2(new dj.o() { // from class: m5.z
            @Override // dj.o
            public final Object apply(Object obj) {
                return c0.D((Throwable) obj);
            }
        });
    }

    public static /* synthetic */ xi.e0 F(xi.z zVar) {
        return zVar.A3(new dj.o() { // from class: m5.t
            @Override // dj.o
            public final Object apply(Object obj) {
                return c0.C((BaseResponse) obj);
            }
        }).S4(new dj.o() { // from class: m5.x
            @Override // dj.o
            public final Object apply(Object obj) {
                return c0.E((xi.z) obj);
            }
        });
    }

    public static /* synthetic */ void G(Throwable th2) throws Exception {
        if (th2 instanceof ApiException) {
            s(((ApiException) th2).a());
        } else if (th2 instanceof HttpException) {
            s(((HttpException) th2).a());
        }
    }

    public static /* synthetic */ xi.e0 H(xi.z zVar) {
        return zVar.W1(new dj.g() { // from class: m5.o
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                c0.G((Throwable) obj);
            }
        });
    }

    public static <T> xi.f0<LoginBaseResponse<T>, T> o() {
        return new xi.f0() { // from class: m5.r
            @Override // xi.f0
            public final xi.e0 c(xi.z zVar) {
                return c0.v(zVar);
            }
        };
    }

    public static <T> xi.f0<BaseResponse<T>, T> p() {
        return new xi.f0() { // from class: m5.p
            @Override // xi.f0
            public final xi.e0 c(xi.z zVar) {
                return c0.z(zVar);
            }
        };
    }

    public static <T> xi.f0<LoginBaseResponse<T>, LoginBaseResponse<T>> q() {
        return new xi.f0() { // from class: m5.b0
            @Override // xi.f0
            public final xi.e0 c(xi.z zVar) {
                return c0.B(zVar);
            }
        };
    }

    public static <T> xi.f0<BaseResponse<T>, BaseResponse<T>> r() {
        return new xi.f0() { // from class: m5.q
            @Override // xi.f0
            public final xi.e0 c(xi.z zVar) {
                return c0.F(zVar);
            }
        };
    }

    public static void s(final int stateCode) {
        if (stateCode == 401) {
            a5.f.i().t();
            h3.a.j().d(a.C0378a.f31905b).navigation();
        } else if (stateCode == 403) {
            a5.f.i().t();
            h3.a.j().d(a.C0378a.f31905b).navigation();
        }
    }

    public static <T> xi.f0<T, T> t() {
        return new xi.f0() { // from class: m5.s
            @Override // xi.f0
            public final xi.e0 c(xi.z zVar) {
                return c0.H(zVar);
            }
        };
    }

    public static /* synthetic */ Object u(LoginBaseResponse loginBaseResponse) throws Exception {
        if (loginBaseResponse.state == 0) {
            return loginBaseResponse.data;
        }
        throw new ApiException(loginBaseResponse.state, loginBaseResponse.msg);
    }

    public static /* synthetic */ xi.e0 v(xi.z zVar) {
        return zVar.A3(new dj.o() { // from class: m5.w
            @Override // dj.o
            public final Object apply(Object obj) {
                return c0.u((LoginBaseResponse) obj);
            }
        });
    }

    public static /* synthetic */ Object w(BaseResponse baseResponse) throws Exception {
        if (baseResponse.state == 0) {
            return baseResponse.data;
        }
        throw new ApiException(baseResponse.state, baseResponse.msg);
    }

    public static /* synthetic */ xi.e0 x(Throwable th2) throws Exception {
        return ((th2 instanceof NoRouteToHostException) || (th2 instanceof UnknownHostException) || (th2 instanceof SocketTimeoutException) || (th2 instanceof SSLException)) ? xi.z.f2(new ApiException(ApiException.f13376a, j1.a().getString(R.string.net_state_error))) : xi.z.f2(th2);
    }

    public static /* synthetic */ xi.e0 y(xi.z zVar) throws Exception {
        return zVar.l2(new dj.o() { // from class: m5.a0
            @Override // dj.o
            public final Object apply(Object obj) {
                return c0.x((Throwable) obj);
            }
        });
    }

    public static /* synthetic */ xi.e0 z(xi.z zVar) {
        return zVar.A3(new dj.o() { // from class: m5.u
            @Override // dj.o
            public final Object apply(Object obj) {
                return c0.w((BaseResponse) obj);
            }
        }).S4(new dj.o() { // from class: m5.y
            @Override // dj.o
            public final Object apply(Object obj) {
                return c0.y((xi.z) obj);
            }
        });
    }
}

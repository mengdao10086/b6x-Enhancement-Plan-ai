package m5;

import com.flydigi.base.net.ApiException;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.LoginBaseResponse;
import i9.a;
import retrofit2.HttpException;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    public static <T> xi.p<LoginBaseResponse<T>, T> k() {
        return new xi.p() { // from class: m5.j
            @Override // xi.p
            public final bu.c a(xi.j jVar) {
                return n.r(jVar);
            }
        };
    }

    public static <T> xi.p<BaseResponse<T>, T> l() {
        return new xi.p() { // from class: m5.l
            @Override // xi.p
            public final bu.c a(xi.j jVar) {
                return n.t(jVar);
            }
        };
    }

    public static <T> xi.p<LoginBaseResponse<T>, LoginBaseResponse<T>> m() {
        return new xi.p() { // from class: m5.k
            @Override // xi.p
            public final bu.c a(xi.j jVar) {
                return n.v(jVar);
            }
        };
    }

    public static <T> xi.p<BaseResponse<T>, BaseResponse<T>> n() {
        return new xi.p() { // from class: m5.m
            @Override // xi.p
            public final bu.c a(xi.j jVar) {
                return n.x(jVar);
            }
        };
    }

    public static void o(final int stateCode) {
        if (stateCode == 401) {
            a5.f.i().t();
            h3.a.j().d(a.C0378a.f31905b).navigation();
        } else if (stateCode == 403) {
            a5.f.i().t();
            h3.a.j().d(a.C0378a.f31905b).navigation();
        }
    }

    public static <T> xi.p<T, T> p() {
        return new xi.p() { // from class: m5.i
            @Override // xi.p
            public final bu.c a(xi.j jVar) {
                return n.z(jVar);
            }
        };
    }

    public static /* synthetic */ Object q(LoginBaseResponse loginBaseResponse) throws Exception {
        if (loginBaseResponse.state == 0) {
            return loginBaseResponse.data;
        }
        throw new ApiException(loginBaseResponse.state, loginBaseResponse.msg);
    }

    public static /* synthetic */ bu.c r(xi.j jVar) {
        return jVar.K3(new dj.o() { // from class: m5.h
            @Override // dj.o
            public final Object apply(Object obj) {
                return n.q((LoginBaseResponse) obj);
            }
        });
    }

    public static /* synthetic */ Object s(BaseResponse baseResponse) throws Exception {
        if (baseResponse.state == 0) {
            return baseResponse.data;
        }
        throw new ApiException(baseResponse.state, baseResponse.msg);
    }

    public static /* synthetic */ bu.c t(xi.j jVar) {
        return jVar.K3(new dj.o() { // from class: m5.e
            @Override // dj.o
            public final Object apply(Object obj) {
                return n.s((BaseResponse) obj);
            }
        });
    }

    public static /* synthetic */ LoginBaseResponse u(LoginBaseResponse loginBaseResponse) throws Exception {
        if (loginBaseResponse.state == 0) {
            return loginBaseResponse;
        }
        throw new ApiException(loginBaseResponse.state, loginBaseResponse.msg);
    }

    public static /* synthetic */ bu.c v(xi.j jVar) {
        return jVar.K3(new dj.o() { // from class: m5.g
            @Override // dj.o
            public final Object apply(Object obj) {
                return n.u((LoginBaseResponse) obj);
            }
        });
    }

    public static /* synthetic */ BaseResponse w(BaseResponse baseResponse) throws Exception {
        if (baseResponse.state == 0) {
            return baseResponse;
        }
        throw new ApiException(baseResponse.state, baseResponse.msg);
    }

    public static /* synthetic */ bu.c x(xi.j jVar) {
        return jVar.K3(new dj.o() { // from class: m5.f
            @Override // dj.o
            public final Object apply(Object obj) {
                return n.w((BaseResponse) obj);
            }
        });
    }

    public static /* synthetic */ void y(Throwable th2) throws Exception {
        if (th2 instanceof ApiException) {
            o(((ApiException) th2).a());
        } else if (th2 instanceof HttpException) {
            o(((HttpException) th2).a());
        }
    }

    public static /* synthetic */ bu.c z(xi.j jVar) {
        return jVar.b2(new dj.g() { // from class: m5.d
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                n.y((Throwable) obj);
            }
        });
    }
}

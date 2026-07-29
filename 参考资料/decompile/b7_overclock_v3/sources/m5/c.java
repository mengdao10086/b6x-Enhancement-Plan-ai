package m5;

import com.blankj.utilcode.util.d1;
import com.flydigi.base.net.ApiException;
import com.flydigi.base.net.BaseResponse;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T extends BaseResponse> implements xi.g0<T> {
    public void a(String errorMsg, int stateCode) {
    }

    @Override // xi.g0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onNext(T t10) {
        c(false);
        int i10 = t10.state;
        com.flydigi.base.common.n.a(t10.toString());
        if (i10 == 0) {
            d(t10);
            return;
        }
        g0.a(i10);
        String str = d1.g(t10.msg) ? "未知错误" : t10.msg;
        com.flydigi.base.common.n.b("网络请求异常：%s", str);
        a(str, i10);
    }

    public void c(boolean state) {
    }

    public abstract void d(T t10);

    @Override // xi.g0
    public void onComplete() {
    }

    @Override // xi.g0
    public void onError(Throwable throwable) {
        c(false);
        if (throwable instanceof ApiException) {
            a(throwable.getMessage(), ((ApiException) throwable).a());
        } else {
            a(throwable.getMessage(), -1);
        }
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b d10) {
        c(true);
    }
}

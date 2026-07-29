package c5;

import a5.f;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.j1;
import com.flydigi.account.R;
import com.flydigi.base.common.n;
import com.flydigi.base.net.ApiException;
import com.flydigi.data.LoginBaseResponse;
import i9.a;
import xi.g0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T extends LoginBaseResponse> implements g0<T> {
    public void a(String str, int i10) {
    }

    @Override // xi.g0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onNext(T t10) {
        c(false);
        int i10 = t10.state;
        n.a(t10.toString());
        String string = t10.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("返回数据---");
        sb2.append(string);
        if (i10 == 0) {
            d(t10);
            return;
        }
        String strA = d.a(i10);
        if (d1.g(strA)) {
            strA = t10.msg;
        }
        n.b("网络请求异常：%s", strA);
        a(strA, i10);
    }

    public void c(boolean z10) {
    }

    public abstract void d(T t10);

    @Override // xi.g0
    public void onComplete() {
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        c(false);
        if (!(th2 instanceof ApiException)) {
            a(j1.a().getString(R.string.api_error_notice), -1);
            return;
        }
        int iA = ((ApiException) th2).a();
        if (iA == 401) {
            h3.a.j().d(a.C0378a.f31905b).navigation();
        } else if (iA != 403) {
            a(th2.getMessage(), iA);
        } else {
            f.i().t();
            h3.a.j().d(a.C0378a.f31905b).navigation();
        }
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        c(true);
    }
}

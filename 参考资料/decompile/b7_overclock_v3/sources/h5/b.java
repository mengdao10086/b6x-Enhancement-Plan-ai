package h5;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.bean.GameConfigDownloadBean;
import com.flydigi.data.bean.RecommendConfigBean;
import nu.f;
import nu.t;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    @f("/android/v3/gameConfig")
    z<BaseResponse<RecommendConfigBean>> a(@t(db.d.f26139i) long version, @t("pkgname") String packageName, @t("gameName") String gameName);

    @f("/android/v2/gameMacro")
    z<BaseResponse<GameConfigDownloadBean>> b(@t("pkgname") String packageName);
}

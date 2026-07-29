package b7;

import com.flydigi.data.bean.ArticleForGame;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.data.bean.NoticeBean;
import com.flydigi.data.bean.ProductSale;
import java.util.List;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public interface a {
    z<List<FirmwareInfoBean>> a(@yt.k String str);

    z<FirmwareInfoBean> b(@yt.k String str);

    xi.a d(String str);

    z<NoticeBean> e(String str);

    z<List<ArticleForGame>> f(String str, int i10);

    xi.a u(String str, int i10);

    z<ProductSale> v();

    void w(String str, NoticeBean noticeBean);
}

package com.flydigi.game.data.api;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.bean.BannerBean;
import com.flydigi.game.data.bean.GameCatEntity;
import com.flydigi.game.data.bean.GameDetailBean;
import com.flydigi.game.data.bean.GameInCat;
import com.flydigi.game.data.bean.RecoGameBean;
import com.flydigi.game.data.bean.SearchBean;
import com.flydigi.game.data.bean.SearchRecoBean;
import db.d;
import java.util.List;
import nu.c;
import nu.e;
import nu.f;
import nu.o;
import nu.t;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public interface GameApiService {
    @f("/android/v1/games/downlist")
    z<BaseResponse<List<GameDetailBean>>> getDownloadableSubscribedGame();

    @f("/android/gameBanner")
    z<BaseResponse<List<BannerBean>>> getGameBanner();

    @f("/android/v1/games")
    z<BaseResponse<GameInCat>> getGameByCat(@t("page") int i10, @t("size") int i11, @t("catid") String str);

    @f("/android/v1/cat")
    z<BaseResponse<List<GameCatEntity>>> getGameCatList();

    @f("/android/v1/games/detail")
    z<BaseResponse<GameDetailBean>> getGameDetail(@t("id") String str);

    @f("/android/v1/catindex")
    z<BaseResponse<RecoGameBean>> getRecoGameList(@t("page") int i10, @t("size") int i11);

    @f("https://api.flydigi.com/android/v1/games/deviceRecList")
    z<BaseResponse<GameInCat>> getRecommendGames(@t(d.f26139i) long j10);

    @f("/android/v1/search/rec")
    z<BaseResponse<List<SearchRecoBean>>> getSearchReco(@t("size") int i10);

    @f("/android/v1/search")
    z<BaseResponse<SearchBean>> getSearchResult(@t("title") String str, @t("pkgname") String str2, @t("size") int i10, @t("page") int i11);

    @o("/android/v1/games/subscribe")
    @e
    z<BaseResponse<Object>> subscribeGame(@c("game_id") String str);
}

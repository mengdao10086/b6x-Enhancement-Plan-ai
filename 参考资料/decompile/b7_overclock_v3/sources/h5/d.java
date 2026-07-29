package h5;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.bean.AdvertiseBean;
import com.flydigi.data.bean.ArticleForGame;
import com.flydigi.data.bean.BannerBean;
import com.flydigi.data.bean.ChangeUserGroupData;
import com.flydigi.data.bean.CheckAlphaGroupInvitationData;
import com.flydigi.data.bean.CheckPhoneSupportBean;
import com.flydigi.data.bean.CloudConfigBean;
import com.flydigi.data.bean.CommunityRedDotData;
import com.flydigi.data.bean.ConfigShareResult;
import com.flydigi.data.bean.DeviceDetailBean;
import com.flydigi.data.bean.DeviceListBean;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.data.bean.GameStrategyBean;
import com.flydigi.data.bean.GetSharedConfigUrlResponse;
import com.flydigi.data.bean.KeyPropertyData;
import com.flydigi.data.bean.NoticeBean;
import com.flydigi.data.bean.ProductSale;
import com.flydigi.data.bean.ShareUserConfigResponse;
import com.flydigi.data.bean.SupportedGameListBean;
import com.flydigi.data.bean.UnreadMessageBean;
import com.flydigi.data.bean.UpdateInfoBean;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.an;
import java.util.List;
import nu.f;
import nu.o;
import nu.t;
import nu.w;
import nu.y;
import okhttp3.e0;
import retrofit2.r;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public interface d {
    @f("https://api.flydigi.com//android/v3/games")
    z<BaseResponse<SupportedGameListBean>> A(@t(db.d.f26139i) long version);

    @f("https://api.flydigi.com//android/v1/firmwares/getNewVersion")
    z<BaseResponse<FirmwareInfoBean>> B(@t("type") String deviceCode);

    @f("https://api.flydigi.com/android/manufacture/checkPhoneSupport")
    z<BaseResponse<CheckPhoneSupportBean>> C();

    @f("https://api.flydigi.com/android/v1/firmwares/getMinVersion")
    z<BaseResponse<Object>> D();

    @f("https://api.flydigi.com//android/config/product")
    z<BaseResponse<ProductSale>> E();

    @o("https://api.flydigi.com//android/v1/keyPropertyCfg")
    @nu.e
    z<BaseResponse<KeyPropertyData>> F(@nu.c("pkgname") String pkgname, @nu.c("update_time") long update_time);

    @f("https://api.flydigi.com//android/v1/firmwares")
    z<BaseResponse<List<FirmwareInfoBean>>> a(@t("type") String type);

    @f("https://api.flydigi.com/ios/v1/notice")
    z<BaseResponse<NoticeBean>> e(@t("deviceName") String deviceCode);

    @f("https://api.flydigi.com//android/v3/games/article_info")
    z<BaseResponse<List<ArticleForGame>>> f(@t("pkgname") String packageName, @t(an.f23207ai) int deviceType);

    @f("https://bbsnew.flydigi.com//api/community/red_dot")
    z<BaseResponse<CommunityRedDotData>> g();

    @f("https://bbsnew.flydigi.com//api/Banner/index")
    z<BaseResponse<List<BannerBean>>> h(@t(Constants.PARAM_PLATFORM) String platform);

    @f("https://bbsnew.flydigi.com//api/v1/Home/getMessageNum")
    z<BaseResponse<UnreadMessageBean>> j(@t("uid") String uid);

    @nu.b("https://api.flydigi.com//android/v1/usercfg/delete")
    z<BaseResponse<String>> k(@t("fid") String fid);

    @f("https://bbsnew.flydigi.com//api/user_group/check_remind")
    z<BaseResponse<CheckAlphaGroupInvitationData>> l();

    @o("https://bbsnew.flydigi.com//api/community/red_dot")
    @nu.e
    z<BaseResponse<CommunityRedDotData>> m(@nu.c("id") String id2);

    @f("https://api.flydigi.com//android/v2/ad")
    z<BaseResponse<AdvertiseBean>> n();

    @f("https://api.flydigi.com//android/v1/usercfg")
    z<BaseResponse<List<CloudConfigBean>>> o(@t("pkgname") String pkgname);

    @f("https://api.flydigi.com//android/v1/sharecfg/download")
    z<BaseResponse<GetSharedConfigUrlResponse>> p(@t("share_code_id") String code);

    @f("https://bbsnew.flydigi.com//api/user_group")
    z<BaseResponse<ChangeUserGroupData>> q(@t("action_type") int actionType);

    @f("https://api.flydigi.com/android/v1/index/init")
    z<BaseResponse<UpdateInfoBean>> r(@t("app_class_type") String app_class_type);

    @f("https://api.flydigi.com//android/v1/product")
    z<BaseResponse<DeviceListBean>> s(@t(db.d.f26139i) long version);

    @o("https://data.flydigi.com/api/service/evaluat")
    @nu.e
    z<BaseResponse> t(@nu.c("session_id") String sessionId, @nu.c("score") int level, @nu.c("content") String content);

    @f("https://api.flydigi.com//android/v1/GameConfigNotice")
    z<BaseResponse<GameStrategyBean>> u(@t("pkgname") String pkgname, @t("update_time") long update_time);

    @f("https://api.flydigi.com//android/v1/product/detail")
    z<BaseResponse<DeviceDetailBean>> v(@t(an.f23207ai) String deviceType, @t(db.d.f26139i) long version);

    @o("https://api.flydigi.com//android/v1/usercfg")
    @nu.e
    z<BaseResponse<Object>> w(@nu.c("pkgname") String pkgname, @nu.c("data") String data);

    @o("https://api.flydigi.com//android/v1/usercfg/share")
    @nu.e
    z<BaseResponse<ShareUserConfigResponse>> x(@nu.c("pkgname") String pkgname);

    @o("https://api.flydigi.com//android/v1/sharecfg")
    @nu.e
    z<BaseResponse<ConfigShareResult>> y(@nu.c("pkgname") String pkgName, @nu.c("fid") String fid, @nu.c("title") String title, @nu.c("url") String url, @nu.c(db.d.f26139i) String version, @nu.c("game_name") String gameName, @nu.c("gamepad") String gamePad, @nu.c(Constants.PARAM_MODEL_NAME) String modelName);

    @w
    @f
    z<r<e0>> z(@y String url);
}

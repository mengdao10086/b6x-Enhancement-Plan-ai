package c5;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.LoginBaseResponse;
import com.flydigi.data.bean.FZUserAccount;
import java.util.List;
import nu.e;
import nu.f;
import nu.o;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    @o("https://passport.flydigi.com//v1/Account/registerStepOne")
    @e
    z<LoginBaseResponse> c(@nu.c("mobile") String str);

    @o("https://passport.flydigi.com//v1/Account/registerStepTwo")
    @e
    z<LoginBaseResponse> h(@nu.c("mobile") String str, @nu.c("code") String str2, @nu.c("password") String str3);

    @o("https://passport.flydigi.com//v1/Account/resetStepTwo")
    @e
    z<LoginBaseResponse> m(@nu.c("mobile") String str, @nu.c("code") String str2, @nu.c("password") String str3);

    @f("https://passport.flydigi.com/account/LoginOut")
    z<BaseResponse<Object>> n();

    @o("https://passport.flydigi.com//v1/Account/BindStepOne")
    @e
    z<LoginBaseResponse> o(@nu.c("mobile") String str, @nu.c(com.umeng.socialize.tracker.a.f24780h) String str2, @nu.c("type") String str3);

    @o("https://passport.flydigi.com//v1/Account/Oauth")
    @e
    z<LoginBaseResponse<FZUserAccount>> p(@nu.c(com.umeng.socialize.tracker.a.f24780h) String str, @nu.c("type") String str2);

    @o("https://passport.flydigi.com/v1/Account/Loginnew")
    @e
    z<LoginBaseResponse<FZUserAccount>> q(@nu.c("email") String str, @nu.c("password") String str2, @nu.c("isuid") String str3, @nu.c("device_id") String str4);

    @o("https://passport.flydigi.com//Account/setAvatar")
    @e
    z<LoginBaseResponse<Object>> r(@nu.c("uid") String str, @nu.c("type") String str2, @nu.c("picture") String str3);

    @o("https://passport.flydigi.com//v1/Account/BindStepTwo")
    @e
    z<LoginBaseResponse<FZUserAccount>> s(@nu.c("mobile") String str, @nu.c("code") String str2, @nu.c(com.umeng.socialize.tracker.a.f24780h) String str3, @nu.c("type") String str4);

    @o("https://passport.flydigi.com/Account/changeUsername")
    @e
    z<LoginBaseResponse<List<Object>>> t(@nu.c("uid") String str, @nu.c("username") String str2);

    @o("https://passport.flydigi.com//v1/Account/resetStepOne")
    @e
    z<LoginBaseResponse> u(@nu.c("mobile") String str, @nu.c("uuid") String str2);

    @o("https://passport.flydigi.com/Account/cancel")
    @e
    z<LoginBaseResponse<Object>> v(@nu.c("password") String str);

    @o("https://passport.flydigi.com/Account/checkUsername")
    @e
    z<LoginBaseResponse<Object>> w(@nu.c("username") String str);
}

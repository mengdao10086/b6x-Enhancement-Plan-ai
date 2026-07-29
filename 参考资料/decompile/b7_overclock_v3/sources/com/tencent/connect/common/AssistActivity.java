package com.tencent.connect.common;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import hb.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class AssistActivity extends Activity {
    public static final String EXTRA_INTENT = "openSDK_LOG.AssistActivity.ExtraIntent";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f22512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private QQStayReceiver f22513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f22514f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f22511c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22509a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f22510b = new Handler() { // from class: com.tencent.connect.common.AssistActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && !AssistActivity.this.isFinishing()) {
                SLog.w("openSDK_LOG.AssistActivity", "-->finish by timeout");
                AssistActivity.this.finish();
            }
        }
    };

    public class QQStayReceiver extends BroadcastReceiver {
        private QQStayReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str = "#";
            Intent intent2 = new Intent();
            intent2.putExtra(Constants.KEY_ACTION, "action_share");
            try {
                Uri uri = (Uri) intent.getParcelableExtra("uriData");
                String string = uri.toString();
                if (!string.contains("#")) {
                    str = "?";
                }
                for (String str2 : string.substring(string.indexOf(str) + 1).split("&")) {
                    String[] strArrSplit = str2.split(u.f30904o);
                    intent2.putExtra(strArrSplit[0], strArrSplit[1]);
                }
                intent2.setData(uri);
            } catch (Exception e10) {
                SLog.i("openSDK_LOG.AssistActivity", "QQStayReceiver parse uri error : " + e10.getMessage());
                intent2.putExtra(CommonNetImpl.RESULT, d.O);
                intent2.putExtra("response", "parse error.");
            }
            AssistActivity.this.setResult(-1, intent2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.os.Bundle r13) {
        /*
            r12 = this;
            java.lang.String r0 = "viaShareType"
            java.lang.String r8 = r13.getString(r0)
            java.lang.String r0 = "callbackAction"
            java.lang.String r0 = r13.getString(r0)
            java.lang.String r1 = "url"
            java.lang.String r1 = r13.getString(r1)
            java.lang.String r2 = "openId"
            java.lang.String r2 = r13.getString(r2)
            java.lang.String r3 = "appId"
            java.lang.String r3 = r13.getString(r3)
            java.lang.String r13 = "shareToQQ"
            boolean r13 = r13.equals(r0)
            java.lang.String r4 = ""
            if (r13 == 0) goto L2f
            java.lang.String r13 = "ANDROIDQQ.SHARETOQQ.XX"
            java.lang.String r4 = "10"
        L2c:
            r5 = r4
            r4 = r13
            goto L3d
        L2f:
            java.lang.String r13 = "shareToQzone"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L3c
            java.lang.String r13 = "ANDROIDQQ.SHARETOQZ.XX"
            java.lang.String r4 = "11"
            goto L2c
        L3c:
            r5 = r4
        L3d:
            boolean r13 = com.tencent.open.utils.k.a(r12, r1)
            if (r13 != 0) goto L6e
            com.tencent.connect.common.UIListenerManager r13 = com.tencent.connect.common.UIListenerManager.getInstance()
            com.tencent.tauth.IUiListener r13 = r13.getListnerWithAction(r0)
            if (r13 == 0) goto L59
            com.tencent.tauth.UiError r0 = new com.tencent.tauth.UiError
            r1 = -6
            r6 = 0
            java.lang.String r7 = "打开浏览器失败!"
            r0.<init>(r1, r7, r6)
            r13.onError(r0)
        L59:
            com.tencent.open.b.e r1 = com.tencent.open.b.e.a()
            java.lang.String r6 = "3"
            java.lang.String r7 = "1"
            java.lang.String r9 = "0"
            java.lang.String r10 = "2"
            java.lang.String r11 = "0"
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.finish()
            goto L7f
        L6e:
            com.tencent.open.b.e r1 = com.tencent.open.b.e.a()
            java.lang.String r6 = "3"
            java.lang.String r7 = "0"
            java.lang.String r9 = "0"
            java.lang.String r10 = "2"
            java.lang.String r11 = "0"
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L7f:
            android.content.Intent r13 = r12.getIntent()
            java.lang.String r0 = "shareH5"
            r13.removeExtra(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.common.AssistActivity.a(android.os.Bundle):void");
    }

    public static Intent getAssistActivityIntent(Context context) {
        return new Intent(context, (Class<?>) AssistActivity.class);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--onActivityResult--requestCode: ");
        sb2.append(i10);
        sb2.append(" | resultCode: ");
        sb2.append(i11);
        sb2.append("data = null ? ");
        sb2.append(intent == null);
        SLog.i("openSDK_LOG.AssistActivity", sb2.toString());
        super.onActivityResult(i10, i11, intent);
        if (i10 == 0) {
            return;
        }
        if (intent != null) {
            intent.putExtra(Constants.KEY_ACTION, "action_login");
        }
        setResultData(i10, intent);
        if (this.f22514f) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.connect.common.AssistActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    SLog.i("openSDK_LOG.AssistActivity", "onActivityResult finish delay");
                    AssistActivity.this.finish();
                }
            }, 200L);
        } else {
            SLog.i("openSDK_LOG.AssistActivity", "onActivityResult finish immediate");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().addFlags(67108864);
        requestWindowFeature(1);
        super.onCreate(bundle);
        this.f22514f = getIntent().getBooleanExtra(Constants.KEY_RESTORE_LANDSCAPE, false);
        SLog.i("openSDK_LOG.AssistActivity", "--onCreate-- mRestoreLandscape=" + this.f22514f);
        if (getIntent() == null) {
            SLog.e("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
            finish();
        }
        Intent intent = (Intent) getIntent().getParcelableExtra(EXTRA_INTENT);
        int intExtra = intent == null ? 0 : intent.getIntExtra(Constants.KEY_REQUEST_CODE, 0);
        this.f22512d = intent == null ? "" : intent.getStringExtra("appid");
        Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
        if (bundle != null) {
            this.f22511c = bundle.getBoolean("RESTART_FLAG");
            this.f22509a = bundle.getBoolean("RESUME_FLAG", false);
        }
        if (this.f22511c) {
            SLog.d("openSDK_LOG.AssistActivity", "is restart");
            return;
        }
        if (bundleExtra != null) {
            SLog.w("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
            a(bundleExtra);
            return;
        }
        if (intent == null) {
            SLog.e("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
            finish();
            return;
        }
        SLog.i("openSDK_LOG.AssistActivity", "--onCreate--activityIntent not null, will start activity, reqcode = " + intExtra);
        try {
            IntentFilter intentFilter = new IntentFilter(Constants.SHARE_QQ_AND_STAY + intent.getData().getQueryParameter("share_id"));
            if (this.f22513e == null) {
                this.f22513e = new QQStayReceiver();
            }
            registerReceiver(this.f22513e, intentFilter);
        } catch (Exception e10) {
            SLog.i("openSDK_LOG.AssistActivity", "registerReceiver exception : " + e10.getMessage());
        }
        startActivityForResult(intent, intExtra);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onDestroy");
        super.onDestroy();
        QQStayReceiver qQStayReceiver = this.f22513e;
        if (qQStayReceiver != null) {
            unregisterReceiver(qQStayReceiver);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent");
        super.onNewIntent(intent);
        int intExtra = intent.getIntExtra(Constants.KEY_REQUEST_CODE, -1);
        if (intExtra == 10108) {
            intent.putExtra(Constants.KEY_ACTION, "action_request_avatar");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intExtra == 10109) {
            intent.putExtra(Constants.KEY_ACTION, "action_request_set_emotion");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intExtra == 10110) {
            intent.putExtra(Constants.KEY_ACTION, "action_request_dynamic_avatar");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intExtra == 10111) {
            intent.putExtra(Constants.KEY_ACTION, "joinGroup");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intExtra != 10112) {
            intent.putExtra(Constants.KEY_ACTION, "action_share");
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
            finish();
            return;
        }
        intent.putExtra(Constants.KEY_ACTION, "bindGroup");
        if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
            moveTaskToBack(true);
        }
        setResult(-1, intent);
        if (isFinishing()) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    public void onPause() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onPause");
        this.f22510b.removeMessages(0);
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (intent.getBooleanExtra("is_login", false)) {
            return;
        }
        if (!intent.getBooleanExtra("is_qq_mobile_share", false) && this.f22511c && !isFinishing()) {
            finish();
        }
        if (!this.f22509a) {
            this.f22509a = true;
        } else {
            this.f22510b.sendMessage(this.f22510b.obtainMessage(0));
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        SLog.i("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        bundle.putBoolean("RESUME_FLAG", this.f22509a);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onStart");
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onStop");
        super.onStop();
    }

    public void setResultData(int i10, Intent intent) {
        if (intent == null) {
            SLog.w("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
            setResult(0);
            if (i10 == 11101) {
                e.a().a("", this.f22512d, "2", "1", "7", "2");
                return;
            }
            return;
        }
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_RESPONSE);
            SLog.d("openSDK_LOG.AssistActivity", "--setResultDataForLogin-- ");
            if (TextUtils.isEmpty(stringExtra)) {
                SLog.w("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
                setResult(-1, intent);
            } else {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String strOptString = jSONObject.optString("openid");
                String strOptString2 = jSONObject.optString("access_token");
                String strOptString3 = jSONObject.optString("proxy_code");
                long jOptLong = jSONObject.optLong("proxy_expires_in");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                    SLog.i("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
                    setResult(-1, intent);
                    e.a().a(strOptString, this.f22512d, "2", "1", "7", "0");
                } else if (TextUtils.isEmpty(strOptString3) || jOptLong == 0) {
                    SLog.w("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
                    setResult(0, intent);
                    e.a().a("", this.f22512d, "2", "1", "7", "1");
                } else {
                    SLog.i("openSDK_LOG.AssistActivity", "--setResultData--proxy_code and proxy_expires_in are valid");
                    setResult(-1, intent);
                }
            }
        } catch (Exception e10) {
            SLog.e("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
            e10.printStackTrace();
        }
    }
}

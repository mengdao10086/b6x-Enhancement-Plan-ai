package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.e;
import com.tencent.open.b.h;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.k;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.handler.UMTencentSSOHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class ImageActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f22452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private QQToken f22453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f22454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f22455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f22456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Button f22457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Button f22458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f22459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f22460i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ProgressBar f22461j;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f22469r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Bitmap f22470s;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f22462k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f22463l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f22464m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f22465n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f22466o = 640;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f22467p = 640;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Rect f22468q = new Rect();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final View.OnClickListener f22471t = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.f22461j.setVisibility(0);
            ImageActivity.this.f22458g.setEnabled(false);
            ImageActivity.this.f22458g.setTextColor(Color.rgb(21, 21, 21));
            ImageActivity.this.f22457f.setEnabled(false);
            ImageActivity.this.f22457f.setTextColor(Color.rgb(36, 94, 134));
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageActivity.this.c();
                }
            }).start();
            if (ImageActivity.this.f22463l) {
                ImageActivity.this.a("10657", 0L);
                return;
            }
            ImageActivity.this.a("10655", System.currentTimeMillis() - ImageActivity.this.f22464m);
            if (ImageActivity.this.f22456e.f22492b) {
                ImageActivity.this.a("10654", 0L);
            }
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final View.OnClickListener f22472u = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.a("10656", System.currentTimeMillis() - ImageActivity.this.f22464m);
            ImageActivity.this.setResult(0);
            ImageActivity.this.d();
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final IUiListener f22473v = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.5
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            ImageActivity.this.f22458g.setEnabled(true);
            int i10 = -1;
            ImageActivity.this.f22458g.setTextColor(-1);
            ImageActivity.this.f22457f.setEnabled(true);
            ImageActivity.this.f22457f.setTextColor(-1);
            ImageActivity.this.f22461j.setVisibility(8);
            JSONObject jSONObject = (JSONObject) obj;
            try {
                i10 = jSONObject.getInt(UMTencentSSOHandler.RET);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            if (i10 != 0) {
                ImageActivity.this.a("设置出错了，请重新登录再尝试下呢：）", 1);
                e.a().a(ImageActivity.this.f22453b.getOpenId(), ImageActivity.this.f22453b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_ACT_TYPE_NINETEEN, "1");
                return;
            }
            ImageActivity.this.a("设置成功", 0);
            ImageActivity.this.a("10658", 0L);
            e.a().a(ImageActivity.this.f22453b.getOpenId(), ImageActivity.this.f22453b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, "3", "0");
            ImageActivity imageActivity = ImageActivity.this;
            if (imageActivity.f22454c != null && !"".equals(ImageActivity.this.f22454c)) {
                Intent intent = new Intent();
                intent.setClassName(imageActivity, ImageActivity.this.f22454c);
                if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                    imageActivity.startActivity(intent);
                }
            }
            ImageActivity.this.a(0, jSONObject.toString(), null, null);
            ImageActivity.this.d();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            ImageActivity.this.f22458g.setEnabled(true);
            ImageActivity.this.f22458g.setTextColor(-1);
            ImageActivity.this.f22457f.setEnabled(true);
            ImageActivity.this.f22457f.setTextColor(-1);
            ImageActivity.this.f22457f.setText("重试");
            ImageActivity.this.f22461j.setVisibility(8);
            ImageActivity.this.f22463l = true;
            ImageActivity.this.a(uiError.errorMessage, 1);
            ImageActivity.this.a("10660", 0L);
        }
    };

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final IUiListener f22474w = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.6
        private void a(int i10) {
            if (ImageActivity.this.f22462k < 2) {
                ImageActivity.this.e();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            int i10 = -1;
            try {
                i10 = jSONObject.getInt(UMTencentSSOHandler.RET);
                if (i10 == 0) {
                    final String string = jSONObject.getString(UMTencentSSOHandler.NICKNAME);
                    ImageActivity.this.f22455d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageActivity.this.c(string);
                        }
                    });
                    ImageActivity.this.a("10659", 0L);
                } else {
                    ImageActivity.this.a("10661", 0L);
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            if (i10 != 0) {
                a(i10);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            a(0);
        }
    };

    public class QQAvatarImp extends BaseApi {
        public QQAvatarImp(QQToken qQToken) {
            super(qQToken);
        }

        public void setAvator(Bitmap bitmap, IUiListener iUiListener) {
            Bundle bundleA = a();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
            bundleA.putByteArray("picture", byteArray);
            HttpUtils.requestAsync(this.f22519c, f.a(), "user/set_user_face", bundleA, Constants.HTTP_POST, tempRequestListener);
            e.a().a(this.f22519c.getOpenId(), this.f22519c.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_ACT_TYPE_NINETEEN, "0");
        }
    }

    public class a extends View {
        public a(Context context) {
            super(context);
        }

        public void a(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawableB = ImageActivity.this.b("com.tencent.plus.blue_normal.png");
            Drawable drawableB2 = ImageActivity.this.b("com.tencent.plus.blue_down.png");
            Drawable drawableB3 = ImageActivity.this.b("com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, drawableB2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, drawableB);
            stateListDrawable.addState(View.ENABLED_STATE_SET, drawableB);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, drawableB);
            stateListDrawable.addState(View.EMPTY_STATE_SET, drawableB3);
            button.setBackgroundDrawable(stateListDrawable);
        }

        public void b(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawableB = ImageActivity.this.b("com.tencent.plus.gray_normal.png");
            Drawable drawableB2 = ImageActivity.this.b("com.tencent.plus.gray_down.png");
            Drawable drawableB3 = ImageActivity.this.b("com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, drawableB2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, drawableB);
            stateListDrawable.addState(View.ENABLED_STATE_SET, drawableB);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, drawableB);
            stateListDrawable.addState(View.EMPTY_STATE_SET, drawableB3);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        d();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(a());
        this.f22455d = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra(Constants.KEY_PARAMS);
        this.f22469r = bundleExtra.getString("picture");
        this.f22454c = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString("access_token");
        long j10 = bundleExtra.getLong("expires_in");
        String string3 = bundleExtra.getString("openid");
        this.f22465n = bundleExtra.getInt("exitAnim");
        QQToken qQToken = new QQToken(string);
        this.f22453b = qQToken;
        qQToken.setAccessToken(string2, ((j10 - System.currentTimeMillis()) / 1000) + "");
        this.f22453b.setOpenId(string3);
        b();
        e();
        this.f22464m = System.currentTimeMillis();
        a("10653", 0L);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f22456e.setImageBitmap(null);
        Bitmap bitmap = this.f22470s;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f22470s.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        float fWidth = this.f22468q.width();
        Matrix imageMatrix = this.f22456e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f10 = fArr[2];
        float f11 = fArr[5];
        float f12 = fArr[0];
        float f13 = 640.0f / fWidth;
        Rect rect = this.f22468q;
        int i10 = (int) ((rect.left - f10) / f12);
        int i11 = i10 < 0 ? 0 : i10;
        int i12 = (int) ((rect.top - f11) / f12);
        int i13 = i12 < 0 ? 0 : i12;
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(f13, f13);
        int i14 = (int) (650.0f / f12);
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f22470s, i11, i13, Math.min(this.f22470s.getWidth() - i11, i14), Math.min(this.f22470s.getHeight() - i13, i14), matrix, true);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, 640, 640);
            bitmapCreateBitmap.recycle();
            a(bitmapCreateBitmap2);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e10.getMessage());
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        finish();
        int i10 = this.f22465n;
        if (i10 != 0) {
            overridePendingTransition(0, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f22462k++;
        new UserInfo(this, this.f22453b).getUserInfo(this.f22474w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable b(String str) {
        return k.a(str, this);
    }

    private void b() {
        Bitmap bitmapA;
        try {
            bitmapA = a(this.f22469r);
            this.f22470s = bitmapA;
        } catch (IOException e10) {
            e10.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e10.getMessage());
            d();
        }
        if (bitmapA != null) {
            this.f22456e.setImageBitmap(bitmapA);
            this.f22457f.setOnClickListener(this.f22471t);
            this.f22458g.setOnClickListener(this.f22472u);
            this.f22452a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.connect.avatar.ImageActivity.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ImageActivity.this.f22452a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ImageActivity imageActivity = ImageActivity.this;
                    imageActivity.f22468q = imageActivity.f22459h.a();
                    ImageActivity.this.f22456e.a(ImageActivity.this.f22468q);
                }
            });
            return;
        }
        throw new IOException("cannot read picture: '" + this.f22469r + "'!");
    }

    private String d(String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
    }

    private Bitmap a(String str) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i10 = 1;
        options.inJustDecodeBounds = true;
        Uri uri = Uri.parse(str);
        InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        try {
            BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
        }
        inputStreamOpenInputStream.close();
        int i11 = options.outWidth;
        int i12 = options.outHeight;
        while (i11 * i12 > 4194304) {
            i11 /= 2;
            i12 /= 2;
            i10 *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i10;
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, options);
        } catch (OutOfMemoryError e11) {
            e11.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i10) {
        Toast toastMakeText = Toast.makeText(this, str, 1);
        LinearLayout linearLayout = (LinearLayout) toastMakeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 16.0f), com.tencent.connect.avatar.a.a(this, 16.0f)));
        if (i10 == 0) {
            imageView.setImageDrawable(b("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(b("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        toastMakeText.setView(linearLayout);
        toastMakeText.setGravity(17, 0, 0);
        toastMakeText.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String strD = d(str);
        if ("".equals(strD)) {
            return;
        }
        this.f22460i.setText(strD);
        this.f22460i.setVisibility(0);
    }

    private View a() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f22452a = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.f22452a.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(layoutParams3);
        this.f22452a.addView(relativeLayout2);
        c cVar = new c(this);
        this.f22456e = cVar;
        cVar.setLayoutParams(layoutParams2);
        this.f22456e.setScaleType(ImageView.ScaleType.MATRIX);
        relativeLayout2.addView(this.f22456e);
        this.f22459h = new b(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.f22459h.setLayoutParams(layoutParams4);
        relativeLayout2.addView(this.f22459h);
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.tencent.connect.avatar.a.a(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f22452a.addView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 24.0f), com.tencent.connect.avatar.a.a(this, 24.0f)));
        imageView.setImageDrawable(b("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.f22460i = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f22460i.setLayoutParams(layoutParams6);
        this.f22460i.setEllipsize(TextUtils.TruncateAt.END);
        this.f22460i.setSingleLine();
        this.f22460i.setTextColor(-1);
        this.f22460i.setTextSize(24.0f);
        this.f22460i.setVisibility(8);
        linearLayout.addView(this.f22460i);
        RelativeLayout relativeLayout3 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.tencent.connect.avatar.a.a(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout3.setLayoutParams(layoutParams7);
        relativeLayout3.setBackgroundDrawable(b("com.tencent.plus.bar.png"));
        int iA = com.tencent.connect.avatar.a.a(this, 10.0f);
        relativeLayout3.setPadding(iA, iA, iA, 0);
        this.f22452a.addView(relativeLayout3);
        a aVar = new a(this);
        int iA2 = com.tencent.connect.avatar.a.a(this, 14.0f);
        int iA3 = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f22458g = new Button(this);
        this.f22458g.setLayoutParams(new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f)));
        this.f22458g.setText("取消");
        this.f22458g.setTextColor(-1);
        this.f22458g.setTextSize(18.0f);
        this.f22458g.setPadding(iA2, iA3, iA2, iA3);
        aVar.b(this.f22458g);
        relativeLayout3.addView(this.f22458g);
        this.f22457f = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f22457f.setLayoutParams(layoutParams8);
        this.f22457f.setTextColor(-1);
        this.f22457f.setTextSize(18.0f);
        this.f22457f.setPadding(iA2, iA3, iA2, iA3);
        this.f22457f.setText("选取");
        aVar.a(this.f22457f);
        relativeLayout3.addView(this.f22457f);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("移动和缩放");
        textView.setPadding(0, com.tencent.connect.avatar.a.a(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout3.addView(textView);
        this.f22461j = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.f22461j.setLayoutParams(layoutParams10);
        this.f22461j.setVisibility(8);
        this.f22452a.addView(this.f22461j);
        return this.f22452a;
    }

    private void a(Bitmap bitmap) {
        new QQAvatarImp(this.f22453b).setAvator(bitmap, this.f22473v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i10) {
        this.f22455d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ImageActivity.this.b(str, i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_ERROR_CODE, i10);
        intent.putExtra(Constants.KEY_ERROR_MSG, str2);
        intent.putExtra(Constants.KEY_ERROR_DETAIL, str3);
        intent.putExtra(Constants.KEY_RESPONSE, str);
        setResult(-1, intent);
    }

    public void a(String str, long j10) {
        a(str, j10, this.f22453b.getAppId());
    }

    public static void a(String str, long j10, String str2) {
        HashMap map = new HashMap();
        map.put("strValue", str2);
        map.put("nValue", str);
        map.put("qver", Constants.SDK_VERSION);
        if (j10 != 0) {
            map.put("elt", String.valueOf(j10));
        }
        h.a().a("https://cgi.qplus.com/report/report", map);
    }
}

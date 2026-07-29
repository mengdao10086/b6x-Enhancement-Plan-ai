package com.umeng.socialize.editorpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.ResContainer;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import fh.a;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class ShareActivity extends Activity implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f24630c = "ShareActivity";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f24631d = 140;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f24632a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f24635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f24636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f24637h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ResContainer f24638i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private EditText f24639j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f24640k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Context f24641l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f24642m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private SHARE_MEDIA f24643n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ImageView f24645p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f24646q;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f24634e = "7.2.2";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f24644o = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextWatcher f24633b = new TextWatcher() { // from class: com.umeng.socialize.editorpage.ShareActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ShareActivity shareActivity = ShareActivity.this;
            shareActivity.f24642m = shareActivity.e();
        }
    };

    private String b(String str) {
        return str.equals("TENCENT") ? getResources().getString(this.f24638i.string("umeng_socialize_sharetotencent")) : str.equals("RENREN") ? getResources().getString(this.f24638i.string("umeng_socialize_sharetorenren")) : str.equals("DOUBAN") ? getResources().getString(this.f24638i.string("umeng_socialize_sharetodouban")) : str.equals("TWITTER") ? getResources().getString(this.f24638i.string("umeng_socialize_sharetotwitter")) : str.equals("LINKEDIN") ? getResources().getString(this.f24638i.string("umeng_socialize_sharetolinkin")) : getResources().getString(this.f24638i.string("umeng_socialize_sharetosina"));
    }

    private void c() {
        SHARE_MEDIA share_media;
        String string = this.f24639j.getText().toString();
        if (TextUtils.isEmpty(string.trim()) && this.f24643n == SHARE_MEDIA.SINA && (TextUtils.isEmpty(this.f24637h) || this.f24637h.equals("web") || this.f24637h.equals("video") || this.f24637h.equals("music"))) {
            Toast.makeText(this.f24641l, UmengText.SHARE.CONTEXT_EMPTY, 0).show();
            return;
        }
        if (SocializeUtils.countContentLength(string) <= f24631d || (share_media = this.f24643n) == SHARE_MEDIA.TWITTER || share_media == SHARE_MEDIA.LINKEDIN) {
            if (this.f24642m && this.f24643n != SHARE_MEDIA.TWITTER) {
                Toast.makeText(this.f24641l, UmengText.SHARE.CONTEXT_LONG, 0).show();
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(SocializeConstants.KEY_TEXT, string);
            bundle.putString("pic", this.f24637h);
            intent.putExtras(bundle);
            setResult(-1, intent);
            a();
        }
    }

    private void d() {
        this.f24637h = null;
        findViewById(this.f24638i.id("root")).setBackgroundColor(Color.parseColor("#D4E0E5"));
        findViewById(this.f24638i.id("umeng_socialize_share_bottom_area")).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        int iCountContentLength = f24631d - SocializeUtils.countContentLength(this.f24639j.getText().toString());
        this.f24640k.setText(SocializeUtils.countContentLength(this.f24639j.getText().toString()) + a.f28350w + f24631d);
        return iCountContentLength < 0;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!SocializeConstants.BACKKEY_COMPLETE_CLOSE || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        new Handler().postDelayed(new Runnable() { // from class: com.umeng.socialize.editorpage.ShareActivity.2
            @Override // java.lang.Runnable
            public void run() {
                ShareActivity.this.setResult(1000);
                ShareActivity.this.finish();
            }
        }, 400L);
        return true;
    }

    public void onCancel(View view) {
        setResult(1000);
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == this.f24638i.id("umeng_back")) {
            onCancel(view);
        } else if (id2 == this.f24638i.id("umeng_share_btn")) {
            c();
        } else if (id2 == this.f24638i.id("umeng_del")) {
            d();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f24638i = ResContainer.get(this);
        this.f24644o = SocializeUtils.isFloatWindowStyle(this);
        super.onCreate(bundle);
        this.f24641l = this;
        setContentView(this.f24638i.layout("umeng_socialize_share"));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.softInputMode = 32;
        if (this.f24644o) {
            int[] floatWindowSize = SocializeUtils.getFloatWindowSize(this.f24641l);
            attributes.width = floatWindowSize[0];
            attributes.height = floatWindowSize[1];
        }
        getWindow().setAttributes(attributes);
        SLog.E(UmengText.SHARE.SHAREVIEWV + this.f24634e);
        Bundle extras = getIntent().getExtras();
        SHARE_MEDIA share_mediaA = a(extras.getString(SocializeConstants.KEY_PLATFORM));
        this.f24643n = share_mediaA;
        if (share_mediaA == SHARE_MEDIA.RENREN) {
            f24631d = 120;
        } else {
            f24631d = 140;
        }
        this.f24635f = extras.getString(SocializeConstants.KEY_TEXT);
        this.f24637h = extras.getString("pic");
        this.f24636g = extras.getString("title");
        b();
        this.f24645p = (ImageView) findViewById(this.f24638i.id("umeng_del"));
        this.f24639j.addTextChangedListener(this.f24633b);
        ((TextView) findViewById(this.f24638i.id("umeng_title"))).setText(b(extras.getString(SocializeConstants.KEY_PLATFORM)));
        findViewById(this.f24638i.id("umeng_back")).setOnClickListener(this);
        findViewById(this.f24638i.id("umeng_share_btn")).setOnClickListener(this);
        this.f24645p.setOnClickListener(this);
        this.f24640k = (TextView) findViewById(this.f24638i.id("umeng_socialize_share_word_num"));
        this.f24642m = e();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4 && keyEvent.getRepeatCount() == 0) {
            setResult(1000);
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.f24639j.requestFocus();
        super.onResume();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }

    private SHARE_MEDIA a(String str) {
        if (str.equals("TENCENT")) {
            return SHARE_MEDIA.TENCENT;
        }
        if (str.equals("RENREN")) {
            return SHARE_MEDIA.RENREN;
        }
        if (str.equals("DOUBAN")) {
            return SHARE_MEDIA.DOUBAN;
        }
        if (str.equals("TWITTER")) {
            return SHARE_MEDIA.TWITTER;
        }
        if (str.equals("LINKEDIN")) {
            return SHARE_MEDIA.LINKEDIN;
        }
        return SHARE_MEDIA.SINA;
    }

    private void b() {
        this.f24639j = (EditText) findViewById(this.f24638i.id("umeng_socialize_share_edittext"));
        if (!TextUtils.isEmpty(this.f24635f)) {
            this.f24639j.setText(this.f24635f);
            this.f24639j.setSelection(this.f24635f.length());
        }
        this.f24646q = (TextView) findViewById(this.f24638i.id("umeng_web_title"));
        this.f24632a = (ImageView) findViewById(this.f24638i.id("umeng_share_icon"));
        if (this.f24637h != null) {
            findViewById(this.f24638i.id("umeng_socialize_share_bottom_area")).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(this.f24638i.id("umeng_share_icon"));
            this.f24632a = imageView;
            imageView.setVisibility(0);
            if (this.f24637h.equals("video")) {
                this.f24632a.setImageResource(ResContainer.getResourceId(this.f24641l, "drawable", "umeng_socialize_share_video"));
            } else if (this.f24637h.equals("music")) {
                this.f24632a.setImageResource(ResContainer.getResourceId(this.f24641l, "drawable", "umeng_socialize_share_music"));
            } else if (this.f24637h.equals("web")) {
                this.f24632a.setImageResource(ResContainer.getResourceId(this.f24641l, "drawable", "umeng_socialize_share_web"));
            } else {
                this.f24632a.setImageURI(Uri.fromFile(new File(this.f24637h)));
            }
            if (!TextUtils.isEmpty(this.f24636g)) {
                this.f24646q.setVisibility(0);
                this.f24646q.setText(this.f24636g);
            }
            findViewById(this.f24638i.id("root")).setBackgroundColor(-1);
            return;
        }
        if (TextUtils.isEmpty(this.f24636g)) {
            return;
        }
        this.f24632a.setImageResource(ResContainer.getResourceId(this.f24641l, "drawable", "umeng_socialize_share_web"));
        this.f24646q.setVisibility(0);
        this.f24646q.setText(this.f24636g);
    }

    public void a() {
        finish();
    }
}

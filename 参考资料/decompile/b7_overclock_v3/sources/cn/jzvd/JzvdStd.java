package cn.jzvd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.e1;
import com.umeng.socialize.handler.UMTencentSSOHandler;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class JzvdStd extends Jzvd {
    public static Timer DISMISS_CONTROL_VIEW_TIMER = null;
    public static int LAST_GET_BATTERYLEVEL_PERCENT = 70;
    public static long LAST_GET_BATTERYLEVEL_TIME;
    public ImageView backButton;
    public BroadcastReceiver battertReceiver;
    public ImageView batteryLevel;
    public LinearLayout batteryTimeLayout;
    public ProgressBar bottomProgressBar;
    public TextView clarity;
    public PopupWindow clarityPopWindow;
    public ArrayDeque<Runnable> delayTask;
    public GestureDetector gestureDetector;
    public ProgressBar loadingProgressBar;
    public Dialog mBrightnessDialog;
    public ProgressBar mDialogBrightnessProgressBar;
    public TextView mDialogBrightnessTextView;
    public ImageView mDialogIcon;
    public ProgressBar mDialogProgressBar;
    public TextView mDialogSeekTime;
    public TextView mDialogTotalTime;
    public ImageView mDialogVolumeImageView;
    public ProgressBar mDialogVolumeProgressBar;
    public TextView mDialogVolumeTextView;
    public DismissControlViewTimerTask mDismissControlViewTimerTask;
    public boolean mIsWifi;
    public Dialog mProgressDialog;
    public TextView mRetryBtn;
    public LinearLayout mRetryLayout;
    public Dialog mVolumeDialog;
    public ImageView posterImageView;
    public TextView replayTextView;
    public ImageView tinyBackImageView;
    public TextView titleTextView;
    public TextView videoCurrentTime;
    public BroadcastReceiver wifiReceiver;

    public class DismissControlViewTimerTask extends TimerTask {
        public DismissControlViewTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            JzvdStd.this.dissmissControlView();
        }
    }

    public JzvdStd(Context context) {
        super(context);
        this.battertReceiver = new BroadcastReceiver() { // from class: cn.jzvd.JzvdStd.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    JzvdStd.LAST_GET_BATTERYLEVEL_PERCENT = (intent.getIntExtra(UMTencentSSOHandler.LEVEL, 0) * 100) / intent.getIntExtra("scale", 100);
                    JzvdStd.this.setBatteryLevel();
                    try {
                        JzvdStd jzvdStd = JzvdStd.this;
                        jzvdStd.jzvdContext.unregisterReceiver(jzvdStd.battertReceiver);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
        };
        this.wifiReceiver = new BroadcastReceiver() { // from class: cn.jzvd.JzvdStd.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    boolean zIsWifiConnected = JZUtils.isWifiConnected(context2);
                    JzvdStd jzvdStd = JzvdStd.this;
                    if (jzvdStd.mIsWifi == zIsWifiConnected) {
                        return;
                    }
                    jzvdStd.mIsWifi = zIsWifiConnected;
                    if (zIsWifiConnected || Jzvd.WIFI_TIP_DIALOG_SHOWED || jzvdStd.state != 5) {
                        return;
                    }
                    jzvdStd.startButton.performClick();
                    JzvdStd.this.showWifiDialog();
                }
            }
        };
        this.delayTask = new ArrayDeque<>();
        this.gestureDetector = new GestureDetector(getContext().getApplicationContext(), new GestureDetector.SimpleOnGestureListener() { // from class: cn.jzvd.JzvdStd.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                int i10 = JzvdStd.this.state;
                if (i10 == 5 || i10 == 6) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("doublClick [");
                    sb2.append(hashCode());
                    sb2.append("] ");
                    JzvdStd.this.startButton.performClick();
                }
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                super.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                JzvdStd jzvdStd = JzvdStd.this;
                if (!jzvdStd.mChangePosition && !jzvdStd.mChangeVolume) {
                    jzvdStd.onClickUiToggle();
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clickClarity$0(LinearLayout linearLayout, View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        JZDataSource jZDataSource = this.jzDataSource;
        jZDataSource.currentUrlIndex = iIntValue;
        changeUrl(jZDataSource, getCurrentPositionWhenPlaying());
        this.clarity.setText(this.jzDataSource.getCurrentKey().toString());
        for (int i10 = 0; i10 < linearLayout.getChildCount(); i10++) {
            if (i10 == this.jzDataSource.currentUrlIndex) {
                ((TextView) linearLayout.getChildAt(i10)).setTextColor(Color.parseColor("#fff85959"));
            } else {
                ((TextView) linearLayout.getChildAt(i10)).setTextColor(Color.parseColor("#ffffff"));
            }
        }
        PopupWindow popupWindow = this.clarityPopWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dissmissControlView$3() {
        this.bottomContainer.setVisibility(4);
        this.topContainer.setVisibility(4);
        this.startButton.setVisibility(4);
        if (this.screen != 2) {
            this.bottomProgressBar.setVisibility(0);
        }
        cancelProgressTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showWifiDialog$1(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        Jzvd.WIFI_TIP_DIALOG_SHOWED = true;
        if (this.state == 6) {
            this.startButton.performClick();
        } else {
            startVideo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showWifiDialog$2(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        Jzvd.releaseAllVideos();
        clearFloatScreen();
    }

    public void cancelDismissControlViewTimer() {
        Timer timer = DISMISS_CONTROL_VIEW_TIMER;
        if (timer != null) {
            timer.cancel();
        }
        DismissControlViewTimerTask dismissControlViewTimerTask = this.mDismissControlViewTimerTask;
        if (dismissControlViewTimerTask != null) {
            dismissControlViewTimerTask.cancel();
        }
    }

    public void changeStartButtonSize(int i10) {
        ViewGroup.LayoutParams layoutParams = this.startButton.getLayoutParams();
        layoutParams.height = i10;
        layoutParams.width = i10;
        ViewGroup.LayoutParams layoutParams2 = this.loadingProgressBar.getLayoutParams();
        layoutParams2.height = i10;
        layoutParams2.width = i10;
    }

    public void changeUIToPreparingChangeUrl() {
        int i10 = this.screen;
        if (i10 == 0 || i10 == 1) {
            setAllControlsVisiblity(4, 4, 4, 0, 0, 4, 4);
            updateStartImage();
        }
    }

    public void changeUIToPreparingPlaying() {
        int i10 = this.screen;
        if (i10 == 0 || i10 == 1) {
            setAllControlsVisiblity(0, 0, 4, 0, 4, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToComplete() {
        int i10 = this.screen;
        if (i10 == 0 || i10 == 1) {
            setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToError() {
        int i10 = this.screen;
        if (i10 == 0) {
            setAllControlsVisiblity(4, 4, 0, 4, 4, 4, 0);
            updateStartImage();
        } else {
            if (i10 != 1) {
                return;
            }
            setAllControlsVisiblity(0, 4, 0, 4, 4, 4, 0);
            updateStartImage();
        }
    }

    public void changeUiToNormal() {
        int i10 = this.screen;
        if (i10 == 0 || i10 == 1) {
            setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToPauseClear() {
        int i10 = this.screen;
        if (i10 == 0 || i10 == 1) {
            setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        }
    }

    public void changeUiToPauseShow() {
        int i10 = this.screen;
        if (i10 == 0 || i10 == 1) {
            setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToPlayingClear() {
        int i10 = this.screen;
        if (i10 == 0 || i10 == 1) {
            setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        }
    }

    public void changeUiToPlayingShow() {
        int i10 = this.screen;
        if (i10 == 0 || i10 == 1) {
            setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToPreparing() {
        int i10 = this.screen;
        if (i10 == 0 || i10 == 1) {
            setAllControlsVisiblity(4, 4, 4, 0, 0, 4, 4);
            updateStartImage();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void changeUrl(JZDataSource jZDataSource, long j10) {
        super.changeUrl(jZDataSource, j10);
        this.titleTextView.setText(jZDataSource.title);
    }

    public void clickBack() {
        Jzvd.backPress();
    }

    public void clickBackTiny() {
        clearFloatScreen();
    }

    public void clickClarity() {
        onCLickUiToggleToClear();
        final LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) this.jzvdContext.getSystemService("layout_inflater")).inflate(R.layout.jz_layout_clarity, (ViewGroup) null);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: cn.jzvd.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11014a.lambda$clickClarity$0(linearLayout, view);
            }
        };
        for (int i10 = 0; i10 < this.jzDataSource.urlsMap.size(); i10++) {
            String keyFromDataSource = this.jzDataSource.getKeyFromDataSource(i10);
            TextView textView = (TextView) View.inflate(this.jzvdContext, R.layout.jz_layout_clarity_item, null);
            textView.setText(keyFromDataSource);
            textView.setTag(Integer.valueOf(i10));
            linearLayout.addView(textView, i10);
            textView.setOnClickListener(onClickListener);
            if (i10 == this.jzDataSource.currentUrlIndex) {
                textView.setTextColor(Color.parseColor("#fff85959"));
            }
        }
        PopupWindow popupWindow = new PopupWindow((View) linearLayout, JZUtils.dip2px(this.jzvdContext, 240.0f), -1, true);
        this.clarityPopWindow = popupWindow;
        popupWindow.setContentView(linearLayout);
        this.clarityPopWindow.setAnimationStyle(R.style.pop_animation);
        this.clarityPopWindow.showAtLocation(this.textureViewContainer, 8388613, 0, 0);
    }

    public void clickPoster() {
        JZDataSource jZDataSource = this.jzDataSource;
        if (jZDataSource == null || jZDataSource.urlsMap.isEmpty() || this.jzDataSource.getCurrentUrl() == null) {
            Toast.makeText(this.jzvdContext, getResources().getString(R.string.no_url), 0).show();
            return;
        }
        int i10 = this.state;
        if (i10 != 0) {
            if (i10 == 7) {
                onClickUiToggle();
            }
        } else if (this.jzDataSource.getCurrentUrl().toString().startsWith(m7.a.f40702b) || this.jzDataSource.getCurrentUrl().toString().startsWith(fh.a.f28350w) || JZUtils.isWifiConnected(this.jzvdContext) || Jzvd.WIFI_TIP_DIALOG_SHOWED) {
            startVideo();
        } else {
            showWifiDialog();
        }
    }

    public void clickRetryBtn() {
        if (this.jzDataSource.urlsMap.isEmpty() || this.jzDataSource.getCurrentUrl() == null) {
            Toast.makeText(this.jzvdContext, getResources().getString(R.string.no_url), 0).show();
            return;
        }
        if (!this.jzDataSource.getCurrentUrl().toString().startsWith(m7.a.f40702b) && !this.jzDataSource.getCurrentUrl().toString().startsWith(fh.a.f28350w) && !JZUtils.isWifiConnected(this.jzvdContext) && !Jzvd.WIFI_TIP_DIALOG_SHOWED) {
            showWifiDialog();
        } else {
            this.seekToInAdvance = this.mCurrentPosition;
            startVideo();
        }
    }

    public void clickSurfaceContainer() {
        startDismissControlViewTimer();
    }

    public Dialog createDialogWithView(View view) {
        Dialog dialog = new Dialog(this.jzvdContext, R.style.jz_style_dialog_progress);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.addFlags(8);
        window.addFlags(32);
        window.addFlags(16);
        window.setLayout(-2, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        return dialog;
    }

    @Override // cn.jzvd.Jzvd
    public void dismissBrightnessDialog() {
        super.dismissBrightnessDialog();
        Dialog dialog = this.mBrightnessDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void dismissProgressDialog() {
        super.dismissProgressDialog();
        Dialog dialog = this.mProgressDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void dismissVolumeDialog() {
        super.dismissVolumeDialog();
        Dialog dialog = this.mVolumeDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void dissmissControlView() {
        int i10 = this.state;
        if (i10 == 0 || i10 == 8 || i10 == 7) {
            return;
        }
        post(new Runnable() { // from class: cn.jzvd.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f11016a.lambda$dissmissControlView$3();
            }
        });
    }

    @Override // cn.jzvd.Jzvd
    public int getLayoutId() {
        return R.layout.jz_layout_std;
    }

    @Override // cn.jzvd.Jzvd
    public void init(Context context) {
        super.init(context);
        this.batteryTimeLayout = (LinearLayout) findViewById(R.id.battery_time_layout);
        this.bottomProgressBar = (ProgressBar) findViewById(R.id.bottom_progress);
        this.titleTextView = (TextView) findViewById(R.id.title);
        this.backButton = (ImageView) findViewById(R.id.back);
        this.posterImageView = (ImageView) findViewById(R.id.poster);
        this.loadingProgressBar = (ProgressBar) findViewById(R.id.loading);
        this.tinyBackImageView = (ImageView) findViewById(R.id.back_tiny);
        this.batteryLevel = (ImageView) findViewById(R.id.battery_level);
        this.videoCurrentTime = (TextView) findViewById(R.id.video_current_time);
        this.replayTextView = (TextView) findViewById(R.id.replay_text);
        this.clarity = (TextView) findViewById(R.id.clarity);
        this.mRetryBtn = (TextView) findViewById(R.id.retry_btn);
        this.mRetryLayout = (LinearLayout) findViewById(R.id.retry_layout);
        if (this.batteryTimeLayout == null) {
            this.batteryTimeLayout = new LinearLayout(context);
        }
        if (this.bottomProgressBar == null) {
            this.bottomProgressBar = new ProgressBar(context);
        }
        if (this.titleTextView == null) {
            this.titleTextView = new TextView(context);
        }
        if (this.backButton == null) {
            this.backButton = new ImageView(context);
        }
        if (this.posterImageView == null) {
            this.posterImageView = new ImageView(context);
        }
        if (this.loadingProgressBar == null) {
            this.loadingProgressBar = new ProgressBar(context);
        }
        if (this.tinyBackImageView == null) {
            this.tinyBackImageView = new ImageView(context);
        }
        if (this.batteryLevel == null) {
            this.batteryLevel = new ImageView(context);
        }
        if (this.videoCurrentTime == null) {
            this.videoCurrentTime = new TextView(context);
        }
        if (this.replayTextView == null) {
            this.replayTextView = new TextView(context);
        }
        if (this.clarity == null) {
            this.clarity = new TextView(context);
        }
        if (this.mRetryBtn == null) {
            this.mRetryBtn = new TextView(context);
        }
        if (this.mRetryLayout == null) {
            this.mRetryLayout = new LinearLayout(context);
        }
        this.posterImageView.setOnClickListener(this);
        this.backButton.setOnClickListener(this);
        this.tinyBackImageView.setOnClickListener(this);
        this.clarity.setOnClickListener(this);
        this.mRetryBtn.setOnClickListener(this);
    }

    public void onCLickUiToggleToClear() {
        int i10 = this.state;
        if (i10 == 1) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPreparing();
            }
        } else if (i10 == 5) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPlayingClear();
            }
        } else if (i10 == 6) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPauseClear();
            }
        } else if (i10 == 7 && this.bottomContainer.getVisibility() == 0) {
            changeUiToComplete();
        }
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id2 = view.getId();
        if (id2 == R.id.poster) {
            clickPoster();
            return;
        }
        if (id2 == R.id.surface_container) {
            clickSurfaceContainer();
            PopupWindow popupWindow = this.clarityPopWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
                return;
            }
            return;
        }
        if (id2 == R.id.back) {
            clickBack();
            return;
        }
        if (id2 == R.id.back_tiny) {
            clickBackTiny();
        } else if (id2 == R.id.clarity) {
            clickClarity();
        } else if (id2 == R.id.retry_btn) {
            clickRetryBtn();
        }
    }

    public void onClickUiToggle() {
        if (this.bottomContainer.getVisibility() != 0) {
            setSystemTimeAndBattery();
            this.clarity.setText(this.jzDataSource.getCurrentKey().toString());
        }
        int i10 = this.state;
        if (i10 == 1) {
            changeUiToPreparing();
            if (this.bottomContainer.getVisibility() == 0) {
                return;
            }
            setSystemTimeAndBattery();
            return;
        }
        if (i10 == 5) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPlayingClear();
                return;
            } else {
                changeUiToPlayingShow();
                return;
            }
        }
        if (i10 == 6) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPauseClear();
            } else {
                changeUiToPauseShow();
            }
        }
    }

    @Override // cn.jzvd.Jzvd
    public void onCompletion() {
        super.onCompletion();
        cancelDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd
    public void onProgress(int i10, long j10, long j11) {
        super.onProgress(i10, j10, j11);
        if (i10 != 0) {
            this.bottomProgressBar.setProgress(i10);
        }
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        cancelDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd
    public void onStateAutoComplete() {
        super.onStateAutoComplete();
        changeUiToComplete();
        cancelDismissControlViewTimer();
        this.bottomProgressBar.setProgress(100);
    }

    @Override // cn.jzvd.Jzvd
    public void onStateError() {
        super.onStateError();
        changeUiToError();
    }

    @Override // cn.jzvd.Jzvd
    public void onStateNormal() {
        super.onStateNormal();
        changeUiToNormal();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePause() {
        super.onStatePause();
        changeUiToPauseShow();
        cancelDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePlaying() {
        super.onStatePlaying();
        changeUiToPlayingClear();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePreparing() {
        super.onStatePreparing();
        changeUiToPreparing();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePreparingChangeUrl() {
        super.onStatePreparingChangeUrl();
        changeUIToPreparingChangeUrl();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePreparingPlaying() {
        super.onStatePreparingPlaying();
        changeUIToPreparingPlaying();
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        startDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id2 = view.getId();
        if (id2 == R.id.surface_container) {
            if (motionEvent.getAction() == 1) {
                startDismissControlViewTimer();
                if (this.mChangePosition) {
                    long duration = getDuration();
                    long j10 = this.mSeekTimePosition * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.bottomProgressBar.setProgress((int) (j10 / duration));
                }
            }
            this.gestureDetector.onTouchEvent(motionEvent);
        } else if (id2 == R.id.bottom_seek_progress) {
            int action = motionEvent.getAction();
            if (action == 0) {
                cancelDismissControlViewTimer();
            } else if (action == 1) {
                startDismissControlViewTimer();
            }
        }
        return super.onTouch(view, motionEvent);
    }

    public void registerWifiListener(Context context) {
        if (context == null) {
            return;
        }
        this.mIsWifi = JZUtils.isWifiConnected(context);
        context.registerReceiver(this.wifiReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // cn.jzvd.Jzvd
    public void reset() {
        super.reset();
        cancelDismissControlViewTimer();
        unregisterWifiListener(getApplicationContext());
    }

    @Override // cn.jzvd.Jzvd
    public void resetProgressAndTime() {
        super.resetProgressAndTime();
        this.bottomProgressBar.setProgress(0);
        this.bottomProgressBar.setSecondaryProgress(0);
    }

    public void setAllControlsVisiblity(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.topContainer.setVisibility(i10);
        this.bottomContainer.setVisibility(i11);
        this.startButton.setVisibility(i12);
        this.loadingProgressBar.setVisibility(i13);
        this.posterImageView.setVisibility(i14);
        this.bottomProgressBar.setVisibility(i15);
        this.mRetryLayout.setVisibility(i16);
    }

    public void setBatteryLevel() {
        int i10 = LAST_GET_BATTERYLEVEL_PERCENT;
        if (i10 < 15) {
            this.batteryLevel.setBackgroundResource(R.drawable.jz_battery_level_10);
            return;
        }
        if (i10 >= 15 && i10 < 40) {
            this.batteryLevel.setBackgroundResource(R.drawable.jz_battery_level_30);
            return;
        }
        if (i10 >= 40 && i10 < 60) {
            this.batteryLevel.setBackgroundResource(R.drawable.jz_battery_level_50);
            return;
        }
        if (i10 >= 60 && i10 < 80) {
            this.batteryLevel.setBackgroundResource(R.drawable.jz_battery_level_70);
            return;
        }
        if (i10 >= 80 && i10 < 95) {
            this.batteryLevel.setBackgroundResource(R.drawable.jz_battery_level_90);
        } else {
            if (i10 < 95 || i10 > 100) {
                return;
            }
            this.batteryLevel.setBackgroundResource(R.drawable.jz_battery_level_100);
        }
    }

    @Override // cn.jzvd.Jzvd
    public void setBufferProgress(int i10) {
        super.setBufferProgress(i10);
        if (i10 != 0) {
            this.bottomProgressBar.setSecondaryProgress(i10);
        }
    }

    @Override // cn.jzvd.Jzvd
    public void setScreenFullscreen() {
        super.setScreenFullscreen();
        this.fullscreenButton.setImageResource(R.drawable.jz_shrink);
        this.backButton.setVisibility(0);
        this.tinyBackImageView.setVisibility(4);
        this.batteryTimeLayout.setVisibility(0);
        if (this.jzDataSource.urlsMap.size() == 1) {
            this.clarity.setVisibility(8);
        } else {
            this.clarity.setText(this.jzDataSource.getCurrentKey().toString());
            this.clarity.setVisibility(0);
        }
        changeStartButtonSize((int) getResources().getDimension(R.dimen.jz_start_button_w_h_fullscreen));
        setSystemTimeAndBattery();
    }

    @Override // cn.jzvd.Jzvd
    public void setScreenNormal() {
        super.setScreenNormal();
        this.fullscreenButton.setImageResource(R.drawable.jz_enlarge);
        this.backButton.setVisibility(8);
        this.tinyBackImageView.setVisibility(4);
        changeStartButtonSize((int) getResources().getDimension(R.dimen.jz_start_button_w_h_normal));
        this.batteryTimeLayout.setVisibility(8);
        this.clarity.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    public void setScreenTiny() {
        super.setScreenTiny();
        this.tinyBackImageView.setVisibility(0);
        setAllControlsVisiblity(4, 4, 4, 4, 4, 4, 4);
        this.batteryTimeLayout.setVisibility(8);
        this.clarity.setVisibility(8);
    }

    public void setSystemTimeAndBattery() {
        this.videoCurrentTime.setText(new SimpleDateFormat("HH:mm").format(new Date()));
        if (System.currentTimeMillis() - LAST_GET_BATTERYLEVEL_TIME <= 30000) {
            setBatteryLevel();
        } else {
            LAST_GET_BATTERYLEVEL_TIME = System.currentTimeMillis();
            this.jzvdContext.registerReceiver(this.battertReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    @Override // cn.jzvd.Jzvd
    public void setUp(JZDataSource jZDataSource, int i10, Class cls) {
        if (System.currentTimeMillis() - this.gobakFullscreenTime >= 200 && System.currentTimeMillis() - this.gotoFullscreenTime >= 200) {
            super.setUp(jZDataSource, i10, cls);
            this.titleTextView.setText(jZDataSource.title);
            setScreen(i10);
        }
    }

    @Override // cn.jzvd.Jzvd
    public void showBrightnessDialog(int i10) {
        super.showBrightnessDialog(i10);
        if (this.mBrightnessDialog == null) {
            View viewInflate = LayoutInflater.from(this.jzvdContext).inflate(R.layout.jz_dialog_brightness, (ViewGroup) null);
            this.mDialogBrightnessTextView = (TextView) viewInflate.findViewById(R.id.tv_brightness);
            this.mDialogBrightnessProgressBar = (ProgressBar) viewInflate.findViewById(R.id.brightness_progressbar);
            this.mBrightnessDialog = createDialogWithView(viewInflate);
        }
        if (!this.mBrightnessDialog.isShowing()) {
            this.mBrightnessDialog.show();
        }
        if (i10 > 100) {
            i10 = 100;
        } else if (i10 < 0) {
            i10 = 0;
        }
        this.mDialogBrightnessTextView.setText(i10 + i6.a.f31863g);
        this.mDialogBrightnessProgressBar.setProgress(i10);
        onCLickUiToggleToClear();
    }

    @Override // cn.jzvd.Jzvd
    public void showProgressDialog(float f10, String str, long j10, String str2, long j11) {
        super.showProgressDialog(f10, str, j10, str2, j11);
        if (this.mProgressDialog == null) {
            View viewInflate = LayoutInflater.from(this.jzvdContext).inflate(R.layout.jz_dialog_progress, (ViewGroup) null);
            this.mDialogProgressBar = (ProgressBar) viewInflate.findViewById(R.id.duration_progressbar);
            this.mDialogSeekTime = (TextView) viewInflate.findViewById(R.id.tv_current);
            this.mDialogTotalTime = (TextView) viewInflate.findViewById(R.id.tv_duration);
            this.mDialogIcon = (ImageView) viewInflate.findViewById(R.id.duration_image_tip);
            this.mProgressDialog = createDialogWithView(viewInflate);
        }
        if (!this.mProgressDialog.isShowing()) {
            this.mProgressDialog.show();
        }
        this.mDialogSeekTime.setText(str);
        this.mDialogTotalTime.setText(" / " + str2);
        this.mDialogProgressBar.setProgress(j11 <= 0 ? 0 : (int) ((j10 * 100) / j11));
        if (f10 > 0.0f) {
            this.mDialogIcon.setBackgroundResource(R.drawable.jz_forward_icon);
        } else {
            this.mDialogIcon.setBackgroundResource(R.drawable.jz_backward_icon);
        }
        onCLickUiToggleToClear();
    }

    @Override // cn.jzvd.Jzvd
    public void showVolumeDialog(float f10, int i10) {
        super.showVolumeDialog(f10, i10);
        if (this.mVolumeDialog == null) {
            View viewInflate = LayoutInflater.from(this.jzvdContext).inflate(R.layout.jz_dialog_volume, (ViewGroup) null);
            this.mDialogVolumeImageView = (ImageView) viewInflate.findViewById(R.id.volume_image_tip);
            this.mDialogVolumeTextView = (TextView) viewInflate.findViewById(R.id.tv_volume);
            this.mDialogVolumeProgressBar = (ProgressBar) viewInflate.findViewById(R.id.volume_progressbar);
            this.mVolumeDialog = createDialogWithView(viewInflate);
        }
        if (!this.mVolumeDialog.isShowing()) {
            this.mVolumeDialog.show();
        }
        if (i10 <= 0) {
            this.mDialogVolumeImageView.setBackgroundResource(R.drawable.jz_close_volume);
        } else {
            this.mDialogVolumeImageView.setBackgroundResource(R.drawable.jz_add_volume);
        }
        if (i10 > 100) {
            i10 = 100;
        } else if (i10 < 0) {
            i10 = 0;
        }
        this.mDialogVolumeTextView.setText(i10 + i6.a.f31863g);
        this.mDialogVolumeProgressBar.setProgress(i10);
        onCLickUiToggleToClear();
    }

    @Override // cn.jzvd.Jzvd
    public void showWifiDialog() {
        super.showWifiDialog();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.jzvdContext);
        builder.setMessage(getResources().getString(R.string.tips_not_wifi));
        builder.setPositiveButton(getResources().getString(R.string.tips_not_wifi_confirm), new DialogInterface.OnClickListener() { // from class: cn.jzvd.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f11013a.lambda$showWifiDialog$1(dialogInterface, i10);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.tips_not_wifi_cancel), new DialogInterface.OnClickListener() { // from class: cn.jzvd.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f11012a.lambda$showWifiDialog$2(dialogInterface, i10);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cn.jzvd.JzvdStd.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                Jzvd.releaseAllVideos();
                JzvdStd.this.clearFloatScreen();
            }
        });
        builder.create().show();
    }

    public void startDismissControlViewTimer() {
        cancelDismissControlViewTimer();
        DISMISS_CONTROL_VIEW_TIMER = new Timer();
        DismissControlViewTimerTask dismissControlViewTimerTask = new DismissControlViewTimerTask();
        this.mDismissControlViewTimerTask = dismissControlViewTimerTask;
        DISMISS_CONTROL_VIEW_TIMER.schedule(dismissControlViewTimerTask, e1.f2443l);
    }

    @Override // cn.jzvd.Jzvd
    public void startVideo() {
        super.startVideo();
        registerWifiListener(getApplicationContext());
    }

    public void unregisterWifiListener(Context context) {
        if (context == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.wifiReceiver);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
        }
    }

    public void updateStartImage() {
        int i10 = this.state;
        if (i10 == 5) {
            this.startButton.setVisibility(0);
            this.startButton.setImageResource(R.drawable.jz_click_pause_selector);
            this.replayTextView.setVisibility(8);
        } else if (i10 == 8) {
            this.startButton.setVisibility(4);
            this.replayTextView.setVisibility(8);
        } else if (i10 != 7) {
            this.startButton.setImageResource(R.drawable.jz_click_play_selector);
            this.replayTextView.setVisibility(8);
        } else {
            this.startButton.setVisibility(0);
            this.startButton.setImageResource(R.drawable.jz_click_replay_selector);
            this.replayTextView.setVisibility(0);
        }
    }

    public JzvdStd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.battertReceiver = new BroadcastReceiver() { // from class: cn.jzvd.JzvdStd.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    JzvdStd.LAST_GET_BATTERYLEVEL_PERCENT = (intent.getIntExtra(UMTencentSSOHandler.LEVEL, 0) * 100) / intent.getIntExtra("scale", 100);
                    JzvdStd.this.setBatteryLevel();
                    try {
                        JzvdStd jzvdStd = JzvdStd.this;
                        jzvdStd.jzvdContext.unregisterReceiver(jzvdStd.battertReceiver);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
        };
        this.wifiReceiver = new BroadcastReceiver() { // from class: cn.jzvd.JzvdStd.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    boolean zIsWifiConnected = JZUtils.isWifiConnected(context2);
                    JzvdStd jzvdStd = JzvdStd.this;
                    if (jzvdStd.mIsWifi == zIsWifiConnected) {
                        return;
                    }
                    jzvdStd.mIsWifi = zIsWifiConnected;
                    if (zIsWifiConnected || Jzvd.WIFI_TIP_DIALOG_SHOWED || jzvdStd.state != 5) {
                        return;
                    }
                    jzvdStd.startButton.performClick();
                    JzvdStd.this.showWifiDialog();
                }
            }
        };
        this.delayTask = new ArrayDeque<>();
        this.gestureDetector = new GestureDetector(getContext().getApplicationContext(), new GestureDetector.SimpleOnGestureListener() { // from class: cn.jzvd.JzvdStd.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                int i10 = JzvdStd.this.state;
                if (i10 == 5 || i10 == 6) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("doublClick [");
                    sb2.append(hashCode());
                    sb2.append("] ");
                    JzvdStd.this.startButton.performClick();
                }
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                super.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                JzvdStd jzvdStd = JzvdStd.this;
                if (!jzvdStd.mChangePosition && !jzvdStd.mChangeVolume) {
                    jzvdStd.onClickUiToggle();
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
    }
}

package cn.jzvd;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.media.AudioManager;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Jzvd extends FrameLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    public static Jzvd CURRENT_JZVD = null;
    public static final int SCREEN_FULLSCREEN = 1;
    public static final int SCREEN_NORMAL = 0;
    public static final int SCREEN_TINY = 2;
    public static final int STATE_AUTO_COMPLETE = 7;
    public static final int STATE_ERROR = 8;
    public static final int STATE_IDLE = -1;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_PAUSE = 6;
    public static final int STATE_PLAYING = 5;
    public static final int STATE_PREPARED = 4;
    public static final int STATE_PREPARING = 1;
    public static final int STATE_PREPARING_CHANGE_URL = 2;
    public static final int STATE_PREPARING_PLAYING = 3;
    public static final String TAG = "JZVD";
    public static final int THRESHOLD = 80;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_ADAPTER = 0;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_FILL_PARENT = 1;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_FILL_SCROP = 2;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_ORIGINAL = 3;
    public Timer UPDATE_PROGRESS_TIMER;
    public int blockHeight;
    public int blockIndex;
    public ViewGroup.LayoutParams blockLayoutParams;
    public int blockWidth;
    public ViewGroup bottomContainer;
    public TextView currentTimeTextView;
    public ImageView fullscreenButton;
    public long gobakFullscreenTime;
    public long gotoFullscreenTime;
    public int heightRatio;
    public JZDataSource jzDataSource;
    public Context jzvdContext;
    public AudioManager mAudioManager;
    public boolean mChangeBrightness;
    public boolean mChangePosition;
    public boolean mChangeVolume;
    public long mCurrentPosition;
    public float mDownX;
    public float mDownY;
    public float mGestureDownBrightness;
    public long mGestureDownPosition;
    public int mGestureDownVolume;
    public ProgressTimerTask mProgressTimerTask;
    public int mScreenHeight;
    public int mScreenWidth;
    public long mSeekTimePosition;
    public boolean mTouchingProgressBar;
    public JZMediaInterface mediaInterface;
    public Class mediaInterfaceClass;
    public int positionInList;
    public boolean preloading;
    public SeekBar progressBar;
    public int screen;
    public long seekToInAdvance;
    public int seekToManulPosition;
    public ImageView startButton;
    public int state;
    public JZTextureView textureView;
    public ViewGroup textureViewContainer;
    public ViewGroup topContainer;
    public TextView totalTimeTextView;
    public int videoRotation;
    public int widthRatio;
    public static LinkedList<ViewGroup> CONTAINER_LIST = new LinkedList<>();
    public static boolean TOOL_BAR_EXIST = true;
    public static int FULLSCREEN_ORIENTATION = 6;
    public static int NORMAL_ORIENTATION = 1;
    public static boolean SAVE_PROGRESS = true;
    public static boolean WIFI_TIP_DIALOG_SHOWED = false;
    public static int VIDEO_IMAGE_DISPLAY_TYPE = 0;
    public static long lastAutoFullscreenTime = 0;
    public static int ON_PLAY_PAUSE_TMP_STATE = 0;
    public static int backUpBufferState = -1;
    public static float PROGRESS_DRAG_RATE = 1.0f;
    public static AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: cn.jzvd.Jzvd.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i10) {
            if (i10 != -2) {
                if (i10 != -1) {
                    return;
                }
                Jzvd.releaseAllVideos();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("AUDIOFOCUS_LOSS [");
                sb2.append(hashCode());
                sb2.append("]");
                return;
            }
            try {
                Jzvd jzvd = Jzvd.CURRENT_JZVD;
                if (jzvd != null && jzvd.state == 5) {
                    jzvd.startButton.performClick();
                }
            } catch (IllegalStateException e10) {
                e10.printStackTrace();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("AUDIOFOCUS_LOSS_TRANSIENT [");
            sb3.append(hashCode());
            sb3.append("]");
        }
    };

    public static class JZAutoFullscreenListener implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            if ((f10 < -12.0f || f10 > 12.0f) && System.currentTimeMillis() - Jzvd.lastAutoFullscreenTime > 2000) {
                Jzvd jzvd = Jzvd.CURRENT_JZVD;
                if (jzvd != null) {
                    jzvd.autoFullscreen(f10);
                }
                Jzvd.lastAutoFullscreenTime = System.currentTimeMillis();
            }
        }
    }

    public class ProgressTimerTask extends TimerTask {
        public ProgressTimerTask() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            long currentPositionWhenPlaying = Jzvd.this.getCurrentPositionWhenPlaying();
            long duration = Jzvd.this.getDuration();
            Jzvd.this.onProgress((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Jzvd jzvd = Jzvd.this;
            int i10 = jzvd.state;
            if (i10 == 5 || i10 == 6 || i10 == 3) {
                jzvd.post(new Runnable() { // from class: cn.jzvd.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11011a.lambda$run$0();
                    }
                });
            }
        }
    }

    public Jzvd(Context context) {
        super(context);
        this.state = -1;
        this.screen = -1;
        this.widthRatio = 0;
        this.heightRatio = 0;
        this.positionInList = -1;
        this.videoRotation = 0;
        this.seekToManulPosition = -1;
        this.seekToInAdvance = 0L;
        this.preloading = false;
        this.gobakFullscreenTime = 0L;
        this.gotoFullscreenTime = 0L;
        init(context);
    }

    public static boolean backPress() {
        Jzvd jzvd;
        Jzvd jzvd2;
        if (CONTAINER_LIST.size() != 0 && (jzvd2 = CURRENT_JZVD) != null) {
            jzvd2.gotoNormalScreen();
            return true;
        }
        if (CONTAINER_LIST.size() != 0 || (jzvd = CURRENT_JZVD) == null || jzvd.screen == 0) {
            return false;
        }
        jzvd.clearFloatScreen();
        return true;
    }

    public static void goOnPlayOnPause() {
        Jzvd jzvd = CURRENT_JZVD;
        if (jzvd != null) {
            int i10 = jzvd.state;
            if (i10 == 7 || i10 == 0 || i10 == 8) {
                releaseAllVideos();
                return;
            }
            if (i10 == 1) {
                setCurrentJzvd(jzvd);
                CURRENT_JZVD.state = 1;
            } else {
                ON_PLAY_PAUSE_TMP_STATE = i10;
                jzvd.onStatePause();
                CURRENT_JZVD.mediaInterface.pause();
            }
        }
    }

    public static void goOnPlayOnResume() {
        Jzvd jzvd = CURRENT_JZVD;
        if (jzvd != null) {
            int i10 = jzvd.state;
            if (i10 == 6) {
                if (ON_PLAY_PAUSE_TMP_STATE == 6) {
                    jzvd.onStatePause();
                    CURRENT_JZVD.mediaInterface.pause();
                } else {
                    jzvd.onStatePlaying();
                    CURRENT_JZVD.mediaInterface.start();
                }
                ON_PLAY_PAUSE_TMP_STATE = 0;
            } else if (i10 == 1) {
                jzvd.startVideo();
            }
            Jzvd jzvd2 = CURRENT_JZVD;
            if (jzvd2.screen == 1) {
                JZUtils.hideStatusBar(jzvd2.jzvdContext);
                JZUtils.hideSystemUI(CURRENT_JZVD.jzvdContext);
            }
        }
    }

    public static void releaseAllVideos() {
        Jzvd jzvd = CURRENT_JZVD;
        if (jzvd != null) {
            jzvd.reset();
            CURRENT_JZVD = null;
        }
    }

    public static void setCurrentJzvd(Jzvd jzvd) {
        Jzvd jzvd2 = CURRENT_JZVD;
        if (jzvd2 != null) {
            jzvd2.reset();
        }
        CURRENT_JZVD = jzvd;
    }

    public static void setTextureViewRotation(int i10) {
        JZTextureView jZTextureView;
        Jzvd jzvd = CURRENT_JZVD;
        if (jzvd == null || (jZTextureView = jzvd.textureView) == null) {
            return;
        }
        jZTextureView.setRotation(i10);
    }

    public static void setVideoImageDisplayType(int i10) {
        JZTextureView jZTextureView;
        VIDEO_IMAGE_DISPLAY_TYPE = i10;
        Jzvd jzvd = CURRENT_JZVD;
        if (jzvd == null || (jZTextureView = jzvd.textureView) == null) {
            return;
        }
        jZTextureView.requestLayout();
    }

    public static void startFullscreenDirectly(Context context, Class cls, String str, String str2) {
        startFullscreenDirectly(context, cls, new JZDataSource(str, str2));
    }

    public void addTextureView() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("addTextureView [");
        sb2.append(hashCode());
        sb2.append("] ");
        JZTextureView jZTextureView = this.textureView;
        if (jZTextureView != null) {
            this.textureViewContainer.removeView(jZTextureView);
        }
        JZTextureView jZTextureView2 = new JZTextureView(getContext().getApplicationContext());
        this.textureView = jZTextureView2;
        jZTextureView2.setSurfaceTextureListener(this.mediaInterface);
        this.textureViewContainer.addView(this.textureView, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void autoFullscreen(float f10) {
        int i10;
        if (CURRENT_JZVD != null) {
            int i11 = this.state;
            if ((i11 != 5 && i11 != 6) || (i10 = this.screen) == 1 || i10 == 2) {
                return;
            }
            if (f10 > 0.0f) {
                JZUtils.setRequestedOrientation(getContext(), 0);
            } else {
                JZUtils.setRequestedOrientation(getContext(), 8);
            }
            gotoFullscreen();
        }
    }

    public void autoQuitFullscreen() {
        if (System.currentTimeMillis() - lastAutoFullscreenTime > 2000 && this.state == 5 && this.screen == 1) {
            lastAutoFullscreenTime = System.currentTimeMillis();
            backPress();
        }
    }

    public void cancelProgressTimer() {
        Timer timer = this.UPDATE_PROGRESS_TIMER;
        if (timer != null) {
            timer.cancel();
        }
        ProgressTimerTask progressTimerTask = this.mProgressTimerTask;
        if (progressTimerTask != null) {
            progressTimerTask.cancel();
        }
    }

    public void changeUrl(JZDataSource jZDataSource, long j10) {
        this.jzDataSource = jZDataSource;
        this.seekToInAdvance = j10;
        onStatePreparingChangeUrl();
    }

    public void clearFloatScreen() {
        JZUtils.showStatusBar(getContext());
        JZUtils.setRequestedOrientation(getContext(), NORMAL_ORIENTATION);
        JZUtils.showSystemUI(getContext());
        ((ViewGroup) JZUtils.scanForActivity(getContext()).getWindow().getDecorView()).removeView(this);
        JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.release();
        }
        CURRENT_JZVD = null;
    }

    public void clickFullscreen() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onClick fullscreen [");
        sb2.append(hashCode());
        sb2.append("] ");
        if (this.state == 7) {
            return;
        }
        if (this.screen == 1) {
            backPress();
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("toFullscreenActivity [");
        sb3.append(hashCode());
        sb3.append("] ");
        gotoFullscreen();
    }

    public void clickStart() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onClick start [");
        sb2.append(hashCode());
        sb2.append("] ");
        JZDataSource jZDataSource = this.jzDataSource;
        if (jZDataSource == null || jZDataSource.urlsMap.isEmpty() || this.jzDataSource.getCurrentUrl() == null) {
            Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
            return;
        }
        int i10 = this.state;
        if (i10 == 0) {
            if (this.jzDataSource.getCurrentUrl().toString().startsWith(m7.a.f40702b) || this.jzDataSource.getCurrentUrl().toString().startsWith(fh.a.f28350w) || JZUtils.isWifiConnected(getContext()) || WIFI_TIP_DIALOG_SHOWED) {
                startVideo();
                return;
            } else {
                showWifiDialog();
                return;
            }
        }
        if (i10 == 5) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("pauseVideo [");
            sb3.append(hashCode());
            sb3.append("] ");
            this.mediaInterface.pause();
            onStatePause();
            return;
        }
        if (i10 == 6) {
            this.mediaInterface.start();
            onStatePlaying();
        } else if (i10 == 7) {
            startVideo();
        }
    }

    public void cloneAJzvd(ViewGroup viewGroup) {
        try {
            Jzvd jzvd = (Jzvd) getClass().getConstructor(Context.class).newInstance(getContext());
            jzvd.setId(getId());
            jzvd.setMinimumWidth(this.blockWidth);
            jzvd.setMinimumHeight(this.blockHeight);
            viewGroup.addView(jzvd, this.blockIndex, this.blockLayoutParams);
            jzvd.setUp(this.jzDataSource.cloneMe(), 0, this.mediaInterfaceClass);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (InstantiationException e11) {
            e11.printStackTrace();
        } catch (NoSuchMethodException e12) {
            e12.printStackTrace();
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
        }
    }

    public void dismissBrightnessDialog() {
    }

    public void dismissProgressDialog() {
    }

    public void dismissVolumeDialog() {
    }

    public Context getApplicationContext() {
        Context applicationContext;
        Context context = getContext();
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public long getCurrentPositionWhenPlaying() {
        int i10 = this.state;
        if (i10 != 5 && i10 != 6 && i10 != 3) {
            return 0L;
        }
        try {
            return this.mediaInterface.getCurrentPosition();
        } catch (IllegalStateException e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    public long getDuration() {
        try {
            return this.mediaInterface.getDuration();
        } catch (IllegalStateException e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    public abstract int getLayoutId();

    public void gotoFullscreen() {
        this.gotoFullscreenTime = System.currentTimeMillis();
        ViewGroup viewGroup = (ViewGroup) getParent();
        this.jzvdContext = viewGroup.getContext();
        this.blockLayoutParams = getLayoutParams();
        this.blockIndex = viewGroup.indexOfChild(this);
        this.blockWidth = getWidth();
        this.blockHeight = getHeight();
        viewGroup.removeView(this);
        cloneAJzvd(viewGroup);
        CONTAINER_LIST.add(viewGroup);
        ((ViewGroup) JZUtils.scanForActivity(this.jzvdContext).getWindow().getDecorView()).addView(this, new FrameLayout.LayoutParams(-1, -1));
        setScreenFullscreen();
        JZUtils.hideStatusBar(this.jzvdContext);
        JZUtils.setRequestedOrientation(this.jzvdContext, FULLSCREEN_ORIENTATION);
        JZUtils.hideSystemUI(this.jzvdContext);
    }

    public void gotoNormalCompletion() {
        this.gobakFullscreenTime = System.currentTimeMillis();
        ((ViewGroup) JZUtils.scanForActivity(this.jzvdContext).getWindow().getDecorView()).removeView(this);
        this.textureViewContainer.removeView(this.textureView);
        CONTAINER_LIST.getLast().removeViewAt(this.blockIndex);
        CONTAINER_LIST.getLast().addView(this, this.blockIndex, this.blockLayoutParams);
        CONTAINER_LIST.pop();
        setScreenNormal();
        JZUtils.showStatusBar(this.jzvdContext);
        JZUtils.setRequestedOrientation(this.jzvdContext, NORMAL_ORIENTATION);
        JZUtils.showSystemUI(this.jzvdContext);
    }

    public void gotoNormalScreen() {
        this.gobakFullscreenTime = System.currentTimeMillis();
        ((ViewGroup) JZUtils.scanForActivity(this.jzvdContext).getWindow().getDecorView()).removeView(this);
        CONTAINER_LIST.getLast().removeViewAt(this.blockIndex);
        CONTAINER_LIST.getLast().addView(this, this.blockIndex, this.blockLayoutParams);
        CONTAINER_LIST.pop();
        setScreenNormal();
        JZUtils.showStatusBar(this.jzvdContext);
        JZUtils.setRequestedOrientation(this.jzvdContext, NORMAL_ORIENTATION);
        JZUtils.showSystemUI(this.jzvdContext);
    }

    public void init(Context context) {
        View.inflate(context, getLayoutId(), this);
        this.jzvdContext = context;
        this.startButton = (ImageView) findViewById(R.id.start);
        this.fullscreenButton = (ImageView) findViewById(R.id.fullscreen);
        this.progressBar = (SeekBar) findViewById(R.id.bottom_seek_progress);
        this.currentTimeTextView = (TextView) findViewById(R.id.current);
        this.totalTimeTextView = (TextView) findViewById(R.id.total);
        this.bottomContainer = (ViewGroup) findViewById(R.id.layout_bottom);
        this.textureViewContainer = (ViewGroup) findViewById(R.id.surface_container);
        this.topContainer = (ViewGroup) findViewById(R.id.layout_top);
        if (this.startButton == null) {
            this.startButton = new ImageView(context);
        }
        if (this.fullscreenButton == null) {
            this.fullscreenButton = new ImageView(context);
        }
        if (this.progressBar == null) {
            this.progressBar = new SeekBar(context);
        }
        if (this.currentTimeTextView == null) {
            this.currentTimeTextView = new TextView(context);
        }
        if (this.totalTimeTextView == null) {
            this.totalTimeTextView = new TextView(context);
        }
        if (this.bottomContainer == null) {
            this.bottomContainer = new LinearLayout(context);
        }
        if (this.textureViewContainer == null) {
            this.textureViewContainer = new FrameLayout(context);
        }
        if (this.topContainer == null) {
            this.topContainer = new RelativeLayout(context);
        }
        this.startButton.setOnClickListener(this);
        this.fullscreenButton.setOnClickListener(this);
        this.progressBar.setOnSeekBarChangeListener(this);
        this.bottomContainer.setOnClickListener(this);
        this.textureViewContainer.setOnClickListener(this);
        this.textureViewContainer.setOnTouchListener(this);
        this.mScreenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.mScreenHeight = getContext().getResources().getDisplayMetrics().heightPixels;
        this.state = -1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.start) {
            clickStart();
        } else if (id2 == R.id.fullscreen) {
            clickFullscreen();
        }
    }

    public void onCompletion() {
        Runtime.getRuntime().gc();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAutoCompletion  [");
        sb2.append(hashCode());
        sb2.append("] ");
        cancelProgressTimer();
        dismissBrightnessDialog();
        dismissProgressDialog();
        dismissVolumeDialog();
        onStateAutoComplete();
        this.mediaInterface.release();
        JZUtils.scanForActivity(getContext()).getWindow().clearFlags(128);
        JZUtils.saveProgress(getContext(), this.jzDataSource.getCurrentUrl(), 0L);
        if (this.screen == 1) {
            if (CONTAINER_LIST.size() == 0) {
                clearFloatScreen();
            } else {
                gotoNormalCompletion();
            }
        }
    }

    public void onError(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onError ");
        sb2.append(i10);
        sb2.append(" - ");
        sb2.append(i11);
        sb2.append(" [");
        sb2.append(hashCode());
        sb2.append("] ");
        if (i10 == 38 || i11 == -38 || i10 == -38 || i11 == 38 || i11 == -19) {
            return;
        }
        onStateError();
        this.mediaInterface.release();
    }

    public void onInfo(int i10, int i11) {
        int i12;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onInfo what - ");
        sb2.append(i10);
        sb2.append(" extra - ");
        sb2.append(i11);
        if (i10 == 3) {
            int i13 = this.state;
            if (i13 == 4 || i13 == 2 || i13 == 3) {
                onStatePlaying();
                return;
            }
            return;
        }
        if (i10 == 701) {
            backUpBufferState = this.state;
            setState(3);
        } else {
            if (i10 != 702 || (i12 = backUpBufferState) == -1) {
                return;
            }
            setState(i12);
            backUpBufferState = -1;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = this.screen;
        if (i12 == 1 || i12 == 2) {
            super.onMeasure(i10, i11);
            return;
        }
        if (this.widthRatio == 0 || this.heightRatio == 0) {
            super.onMeasure(i10, i11);
            return;
        }
        int size = View.MeasureSpec.getSize(i10);
        int i13 = (int) ((size * this.heightRatio) / this.widthRatio);
        setMeasuredDimension(size, i13);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
    }

    public void onPrepared() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onPrepared  [");
        sb2.append(hashCode());
        sb2.append("] ");
        this.state = 4;
        if (!this.preloading) {
            this.mediaInterface.start();
            this.preloading = false;
        }
        if (this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("mp3") || this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("wma") || this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("aac") || this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("m4a") || this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("wav")) {
            onStatePlaying();
        }
    }

    public void onProgress(int i10, long j10, long j11) {
        this.mCurrentPosition = j10;
        if (!this.mTouchingProgressBar) {
            int i11 = this.seekToManulPosition;
            if (i11 != -1) {
                if (i11 > i10) {
                    return;
                } else {
                    this.seekToManulPosition = -1;
                }
            } else if (i10 != 0) {
                this.progressBar.setProgress(i10);
            }
        }
        if (j10 != 0) {
            this.currentTimeTextView.setText(JZUtils.stringForTime(j10));
        }
        this.totalTimeTextView.setText(JZUtils.stringForTime(j11));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        if (z10) {
            this.currentTimeTextView.setText(JZUtils.stringForTime((((long) i10) * getDuration()) / 100));
        }
    }

    public void onSeekComplete() {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("bottomProgress onStartTrackingTouch [");
        sb2.append(hashCode());
        sb2.append("] ");
        cancelProgressTimer();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void onStateAutoComplete() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onStateAutoComplete  [");
        sb2.append(hashCode());
        sb2.append("] ");
        this.state = 7;
        cancelProgressTimer();
        this.progressBar.setProgress(100);
        this.currentTimeTextView.setText(this.totalTimeTextView.getText());
    }

    public void onStateError() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onStateError  [");
        sb2.append(hashCode());
        sb2.append("] ");
        this.state = 8;
        cancelProgressTimer();
    }

    public void onStateNormal() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onStateNormal  [");
        sb2.append(hashCode());
        sb2.append("] ");
        this.state = 0;
        cancelProgressTimer();
        JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.release();
        }
    }

    public void onStatePause() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onStatePause  [");
        sb2.append(hashCode());
        sb2.append("] ");
        this.state = 6;
        startProgressTimer();
    }

    public void onStatePlaying() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onStatePlaying  [");
        sb2.append(hashCode());
        sb2.append("] ");
        if (this.state == 4) {
            long j10 = this.seekToInAdvance;
            if (j10 != 0) {
                this.mediaInterface.seekTo(j10);
                this.seekToInAdvance = 0L;
            } else {
                long savedProgress = JZUtils.getSavedProgress(getContext(), this.jzDataSource.getCurrentUrl());
                if (savedProgress != 0) {
                    this.mediaInterface.seekTo(savedProgress);
                }
            }
        }
        this.state = 5;
        startProgressTimer();
    }

    public void onStatePreparing() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onStatePreparing  [");
        sb2.append(hashCode());
        sb2.append("] ");
        this.state = 1;
        resetProgressAndTime();
    }

    public void onStatePreparingChangeUrl() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onStatePreparingChangeUrl  [");
        sb2.append(hashCode());
        sb2.append("] ");
        this.state = 2;
        releaseAllVideos();
        startVideo();
    }

    public void onStatePreparingPlaying() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onStatePreparingPlaying  [");
        sb2.append(hashCode());
        sb2.append("] ");
        this.state = 3;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("bottomProgress onStopTrackingTouch [");
        sb2.append(hashCode());
        sb2.append("] ");
        startProgressTimer();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i10 = this.state;
        if (i10 == 5 || i10 == 6) {
            long progress = (((long) seekBar.getProgress()) * getDuration()) / 100;
            this.seekToManulPosition = seekBar.getProgress();
            this.mediaInterface.seekTo(progress);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("seekTo ");
            sb3.append(progress);
            sb3.append(" [");
            sb3.append(hashCode());
            sb3.append("] ");
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (view.getId() != R.id.surface_container) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            touchActionDown(x10, y10);
            return false;
        }
        if (action == 1) {
            touchActionUp();
            return false;
        }
        if (action != 2) {
            return false;
        }
        touchActionMove(x10, y10);
        return false;
    }

    public void onVideoSizeChanged(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onVideoSizeChanged  [");
        sb2.append(hashCode());
        sb2.append("] ");
        JZTextureView jZTextureView = this.textureView;
        if (jZTextureView != null) {
            int i12 = this.videoRotation;
            if (i12 != 0) {
                jZTextureView.setRotation(i12);
            }
            this.textureView.setVideoSize(i10, i11);
        }
    }

    public void reset() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("reset  [");
        sb2.append(hashCode());
        sb2.append("] ");
        int i10 = this.state;
        if (i10 == 5 || i10 == 6) {
            JZUtils.saveProgress(getContext(), this.jzDataSource.getCurrentUrl(), getCurrentPositionWhenPlaying());
        }
        cancelProgressTimer();
        dismissBrightnessDialog();
        dismissProgressDialog();
        dismissVolumeDialog();
        onStateNormal();
        this.textureViewContainer.removeAllViews();
        ((AudioManager) getApplicationContext().getSystemService("audio")).abandonAudioFocus(onAudioFocusChangeListener);
        JZUtils.scanForActivity(getContext()).getWindow().clearFlags(128);
        JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.release();
        }
    }

    public void resetProgressAndTime() {
        this.mCurrentPosition = 0L;
        this.progressBar.setProgress(0);
        this.progressBar.setSecondaryProgress(0);
        this.currentTimeTextView.setText(JZUtils.stringForTime(0L));
        this.totalTimeTextView.setText(JZUtils.stringForTime(0L));
    }

    public void setBufferProgress(int i10) {
        if (i10 != 0) {
            this.progressBar.setSecondaryProgress(i10);
        }
    }

    public void setMediaInterface(Class cls) {
        reset();
        this.mediaInterfaceClass = cls;
    }

    public void setScreen(int i10) {
        if (i10 == 0) {
            setScreenNormal();
        } else if (i10 == 1) {
            setScreenFullscreen();
        } else {
            if (i10 != 2) {
                return;
            }
            setScreenTiny();
        }
    }

    public void setScreenFullscreen() {
        this.screen = 1;
    }

    public void setScreenNormal() {
        this.screen = 0;
    }

    public void setScreenTiny() {
        this.screen = 2;
    }

    public void setState(int i10) {
        switch (i10) {
            case 0:
                onStateNormal();
                break;
            case 1:
                onStatePreparing();
                break;
            case 2:
                onStatePreparingChangeUrl();
                break;
            case 3:
                onStatePreparingPlaying();
                break;
            case 5:
                onStatePlaying();
                break;
            case 6:
                onStatePause();
                break;
            case 7:
                onStateAutoComplete();
                break;
            case 8:
                onStateError();
                break;
        }
    }

    public void setUp(String str, String str2) {
        setUp(new JZDataSource(str, str2), 0);
    }

    public void showBrightnessDialog(int i10) {
    }

    public void showProgressDialog(float f10, String str, long j10, String str2, long j11) {
    }

    public void showVolumeDialog(float f10, int i10) {
    }

    public void showWifiDialog() {
    }

    public void startPreloading() {
        this.preloading = true;
        startVideo();
    }

    public void startProgressTimer() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startProgressTimer:  [");
        sb2.append(hashCode());
        sb2.append("] ");
        cancelProgressTimer();
        this.UPDATE_PROGRESS_TIMER = new Timer();
        ProgressTimerTask progressTimerTask = new ProgressTimerTask();
        this.mProgressTimerTask = progressTimerTask;
        this.UPDATE_PROGRESS_TIMER.schedule(progressTimerTask, 0L, 300L);
    }

    public void startVideo() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startVideo [");
        sb2.append(hashCode());
        sb2.append("] ");
        setCurrentJzvd(this);
        try {
            this.mediaInterface = (JZMediaInterface) this.mediaInterfaceClass.getConstructor(Jzvd.class).newInstance(this);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (InstantiationException e11) {
            e11.printStackTrace();
        } catch (NoSuchMethodException e12) {
            e12.printStackTrace();
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
        }
        addTextureView();
        AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService("audio");
        this.mAudioManager = audioManager;
        audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
        JZUtils.scanForActivity(getContext()).getWindow().addFlags(128);
        onStatePreparing();
    }

    public void startVideoAfterPreloading() {
        if (this.state == 4) {
            this.mediaInterface.start();
        } else {
            this.preloading = false;
            startVideo();
        }
    }

    public void touchActionDown(float f10, float f11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onTouch surfaceContainer actionDown [");
        sb2.append(hashCode());
        sb2.append("] ");
        this.mTouchingProgressBar = true;
        this.mDownX = f10;
        this.mDownY = f11;
        this.mChangeVolume = false;
        this.mChangePosition = false;
        this.mChangeBrightness = false;
    }

    public void touchActionMove(float f10, float f11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onTouch surfaceContainer actionMove [");
        sb2.append(hashCode());
        sb2.append("] ");
        float f12 = f10 - this.mDownX;
        float f13 = f11 - this.mDownY;
        float fAbs = Math.abs(f12);
        float fAbs2 = Math.abs(f13);
        if (this.screen == 1) {
            if (this.mDownX > JZUtils.getScreenWidth(getContext()) || this.mDownY < JZUtils.getStatusBarHeight(getContext())) {
                return;
            }
            if (!this.mChangePosition && !this.mChangeVolume && !this.mChangeBrightness && (fAbs > 80.0f || fAbs2 > 80.0f)) {
                cancelProgressTimer();
                if (fAbs >= 80.0f) {
                    if (this.state != 8) {
                        this.mChangePosition = true;
                        this.mGestureDownPosition = getCurrentPositionWhenPlaying();
                    }
                } else if (this.mDownX < this.mScreenHeight * 0.5f) {
                    this.mChangeBrightness = true;
                    float f14 = JZUtils.getWindow(getContext()).getAttributes().screenBrightness;
                    if (f14 < 0.0f) {
                        try {
                            this.mGestureDownBrightness = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness");
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("current system brightness: ");
                            sb3.append(this.mGestureDownBrightness);
                        } catch (Settings.SettingNotFoundException e10) {
                            e10.printStackTrace();
                        }
                    } else {
                        this.mGestureDownBrightness = f14 * 255.0f;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("current activity brightness: ");
                        sb4.append(this.mGestureDownBrightness);
                    }
                } else {
                    this.mChangeVolume = true;
                    this.mGestureDownVolume = this.mAudioManager.getStreamVolume(3);
                }
            }
        }
        if (this.mChangePosition) {
            long duration = getDuration();
            if (PROGRESS_DRAG_RATE <= 0.0f) {
                PROGRESS_DRAG_RATE = 1.0f;
            }
            long j10 = (int) (this.mGestureDownPosition + ((duration * f12) / (this.mScreenWidth * PROGRESS_DRAG_RATE)));
            this.mSeekTimePosition = j10;
            if (j10 > duration) {
                this.mSeekTimePosition = duration;
            }
            showProgressDialog(f12, JZUtils.stringForTime(this.mSeekTimePosition), this.mSeekTimePosition, JZUtils.stringForTime(duration), duration);
        }
        if (this.mChangeVolume) {
            f13 = -f13;
            this.mAudioManager.setStreamVolume(3, this.mGestureDownVolume + ((int) (((this.mAudioManager.getStreamMaxVolume(3) * f13) * 3.0f) / this.mScreenHeight)), 0);
            showVolumeDialog(-f13, (int) (((this.mGestureDownVolume * 100) / r13) + (((f13 * 3.0f) * 100.0f) / this.mScreenHeight)));
        }
        if (this.mChangeBrightness) {
            float f15 = -f13;
            WindowManager.LayoutParams attributes = JZUtils.getWindow(getContext()).getAttributes();
            float f16 = this.mGestureDownBrightness;
            float f17 = (int) (((f15 * 255.0f) * 3.0f) / this.mScreenHeight);
            if ((f16 + f17) / 255.0f >= 1.0f) {
                attributes.screenBrightness = 1.0f;
            } else if ((f16 + f17) / 255.0f <= 0.0f) {
                attributes.screenBrightness = 0.01f;
            } else {
                attributes.screenBrightness = (f16 + f17) / 255.0f;
            }
            JZUtils.getWindow(getContext()).setAttributes(attributes);
            showBrightnessDialog((int) (((this.mGestureDownBrightness * 100.0f) / 255.0f) + (((f15 * 3.0f) * 100.0f) / this.mScreenHeight)));
        }
    }

    public void touchActionUp() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onTouch surfaceContainer actionUp [");
        sb2.append(hashCode());
        sb2.append("] ");
        this.mTouchingProgressBar = false;
        dismissProgressDialog();
        dismissVolumeDialog();
        dismissBrightnessDialog();
        if (this.mChangePosition) {
            this.mediaInterface.seekTo(this.mSeekTimePosition);
            long duration = getDuration();
            long j10 = this.mSeekTimePosition * 100;
            if (duration == 0) {
                duration = 1;
            }
            this.progressBar.setProgress((int) (j10 / duration));
        }
        startProgressTimer();
    }

    public static void startFullscreenDirectly(Context context, Class cls, JZDataSource jZDataSource) {
        JZUtils.hideStatusBar(context);
        JZUtils.setRequestedOrientation(context, FULLSCREEN_ORIENTATION);
        JZUtils.hideSystemUI(context);
        ViewGroup viewGroup = (ViewGroup) JZUtils.scanForActivity(context).getWindow().getDecorView();
        try {
            Jzvd jzvd = (Jzvd) cls.getConstructor(Context.class).newInstance(context);
            viewGroup.addView(jzvd, new FrameLayout.LayoutParams(-1, -1));
            jzvd.setUp(jZDataSource, 1);
            jzvd.startVideo();
        } catch (InstantiationException e10) {
            e10.printStackTrace();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void setUp(String str, String str2, int i10) {
        setUp(new JZDataSource(str, str2), i10);
    }

    public void setUp(JZDataSource jZDataSource, int i10) {
        setUp(jZDataSource, i10, JZMediaSystem.class);
    }

    public void setUp(String str, String str2, int i10, Class cls) {
        setUp(new JZDataSource(str, str2), i10, cls);
    }

    public void setUp(JZDataSource jZDataSource, int i10, Class cls) {
        this.jzDataSource = jZDataSource;
        this.screen = i10;
        onStateNormal();
        this.mediaInterfaceClass = cls;
    }

    public Jzvd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.state = -1;
        this.screen = -1;
        this.widthRatio = 0;
        this.heightRatio = 0;
        this.positionInList = -1;
        this.videoRotation = 0;
        this.seekToManulPosition = -1;
        this.seekToInAdvance = 0L;
        this.preloading = false;
        this.gobakFullscreenTime = 0L;
        this.gotoFullscreenTime = 0L;
        init(context);
    }
}

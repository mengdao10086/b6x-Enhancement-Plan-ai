package com.omarea.data.customer;

import a.a42;
import a.aa0;
import a.b92;
import a.f92;
import a.fa0;
import a.g92;
import a.ga0;
import a.ha0;
import a.hl0;
import a.hz0;
import a.ia0;
import a.ja0;
import a.m42;
import a.t60;
import a.v72;
import a.wj0;
import a.x60;
import a.z32;
import a.zj0;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.omarea.Scene;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class BatteryReceiver implements ha0 {
    public final double batteryCapacity;
    public hl0 batteryUtils;
    public boolean cdpDisableDelay;
    public boolean chargeDisabled;
    public SharedPreferences config;
    public final Context context;
    public Timer governorTimer;
    public final boolean isAsync;
    public t60 keepShellAsync;
    public int lastLimitValue;
    public long lastSetChargeLimit;
    public final double limitExit;
    public boolean limited;
    public int lowSpeedExtreme;
    public final z32 lowSpeedHigh$delegate;
    public final z32 lowSpeedMedium$delegate;
    public final double tempL1;
    public final double tempL2;
    public final double tempL3;

    public static final class a extends g92 implements v72<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8358a = new a();

        public a() {
            super(0);
        }

        public final int a() {
            return fa0.f867a.k() / 8;
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ Integer i() {
            return Integer.valueOf(a());
        }
    }

    public static final class b extends g92 implements v72<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8359a = new b();

        public b() {
            super(0);
        }

        public final int a() {
            return fa0.f867a.k() / 4;
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ Integer i() {
            return Integer.valueOf(a());
        }
    }

    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            BatteryReceiver.this.cdpDisableDelay = false;
            ga0.a(BatteryReceiver.this, aa0.BATTERY_CHANGED, null, 2, null);
        }
    }

    public BatteryReceiver(Context context, boolean z) {
        f92.d(context, "context");
        this.context = context;
        this.isAsync = z;
        SharedPreferences sharedPreferences = context.getSharedPreferences(hz0.f1282a.f(), 0);
        f92.c(sharedPreferences, "context.getSharedPrefere…PF, Context.MODE_PRIVATE)");
        this.config = sharedPreferences;
        this.chargeDisabled = f92.a(x60.f7856a.d("/dev/bypass"), "1");
        this.batteryCapacity = new zj0().a(this.context);
        this.batteryUtils = new hl0();
        this.lowSpeedMedium$delegate = a42.a(b.f8359a);
        this.lowSpeedHigh$delegate = a42.a(a.f8358a);
        this.lowSpeedExtreme = 100;
        this.lastLimitValue = -1;
        if (this.keepShellAsync == null) {
            this.keepShellAsync = new t60(this.context, false, 2, null);
        }
        String str = Build.MANUFACTURER;
        f92.c(str, "Build.MANUFACTURER");
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        double d = f92.a(lowerCase, "xiaomi") ? 48.0d : 44.5d;
        this.tempL3 = d;
        double d2 = d - 0.7d;
        this.tempL2 = d2;
        double d3 = d2 - 2.2d;
        this.tempL1 = d3;
        this.limitExit = d3 - ((double) 1);
    }

    public /* synthetic */ BatteryReceiver(Context context, boolean z, int i, b92 b92Var) {
        this(context, (i & 2) != 0 ? true : z);
    }

    private final void autoChangeLimitValue(aa0 aa0Var) {
        if (this.config.getBoolean(hz0.f1282a.p(), false) && fa0.f867a.a() > 79) {
            setChargerLimitToValue(fa0.f867a.a() > 94 ? this.lowSpeedExtreme : fa0.f867a.a() > 89 ? getLowSpeedHigh() : getLowSpeedMedium(), aa0Var, true);
        } else if (this.config.getBoolean(hz0.f1282a.q(), false)) {
            setChargerLimitToValue(getQcLimit(), aa0Var, false);
        }
    }

    private final void disableCharge() {
        this.chargeDisabled = this.batteryUtils.s();
    }

    private final boolean getBpAllowed() {
        return this.config.getBoolean(hz0.f1282a.g(), false);
    }

    private final int getBpLevel() {
        return this.config.getInt(hz0.f1282a.h(), hz0.f1282a.i());
    }

    private final boolean getCdpDisable() {
        return !this.cdpDisableDelay && this.config.getBoolean(hz0.f1282a.j(), false);
    }

    private final int getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(11) * 60) + calendar.get(12);
    }

    private final int getGetUpTime() {
        return this.config.getInt(hz0.f1282a.t(), hz0.f1282a.u());
    }

    private final int getGoToBedTime() {
        return this.config.getInt(hz0.f1282a.v(), hz0.f1282a.w());
    }

    private final int getLowSpeedHigh() {
        return ((Number) this.lowSpeedHigh$delegate.getValue()).intValue();
    }

    private final int getLowSpeedMedium() {
        return ((Number) this.lowSpeedMedium$delegate.getValue()).intValue();
    }

    private final boolean getOnCharge() {
        return fa0.f867a.c() == 2;
    }

    private final int getQcLimit() {
        return this.config.getInt(hz0.f1282a.r(), hz0.f1282a.s());
    }

    private final boolean getShouldBP() {
        if (getBpAllowed() && (fa0.f867a.a() >= getBpLevel() || (this.chargeDisabled && fa0.f867a.a() > getBpLevel() + (-20)))) {
            return true;
        }
        if (!getCdpDisable() || fa0.f867a.a() <= 9) {
            return false;
        }
        return this.batteryUtils.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void governorRun() {
        if (this.config.getInt(hz0.f1282a.k(), hz0.f1282a.l()) != hz0.f1282a.n() || inSleepTime() || this.chargeDisabled) {
            stopGovernorTimer();
        } else {
            autoChangeLimitValue(aa0.TIMER);
        }
    }

    private final boolean inSleepTime() {
        if (!this.config.getBoolean(hz0.f1282a.p(), false)) {
            return false;
        }
        int currentTime = getCurrentTime();
        int getUpTime = getGetUpTime();
        int goToBedTime = getGoToBedTime();
        if (getUpTime <= goToBedTime || goToBedTime > currentTime || getUpTime < currentTime) {
            if (getUpTime >= goToBedTime) {
                return false;
            }
            if (currentTime < goToBedTime && currentTime > getUpTime) {
                return false;
            }
        }
        return true;
    }

    private final void resumeCharge() {
        this.chargeDisabled = !this.batteryUtils.w();
    }

    private final void setChargerLimitToValue(int i, aa0 aa0Var, boolean z) {
        int iPow;
        fa0.f867a.y(1000L);
        double dO = fa0.f867a.o();
        boolean z2 = false;
        boolean z3 = true;
        if (dO > this.tempL1 || (this.limited && dO > this.limitExit)) {
            this.limited = true;
            int i2 = i <= 15000 ? i : 15000;
            double d = this.tempL3;
            if (dO > d) {
                dO = d;
            }
            double d2 = 10;
            int iPow2 = (int) (((double) i2) * Math.pow(0.94d, (dO - this.tempL1) * d2));
            double d3 = this.tempL2;
            iPow = dO > d3 ? (int) (((double) iPow2) * Math.pow(0.85d, (dO - d3) * d2)) : iPow2;
            if (iPow < 2000) {
                iPow = 2000;
            }
        } else {
            this.limited = false;
            iPow = i;
        }
        int i3 = this.config.getInt(hz0.f1282a.k(), hz0.f1282a.l());
        try {
            if (aa0Var == aa0.CHARGE_CONFIG_CHANGED) {
                boolean z4 = z3;
                z3 = false;
                z2 = z4;
            } else if (i3 != hz0.f1282a.m()) {
                if (i3 == hz0.f1282a.n()) {
                    if (z) {
                        stopGovernorTimer();
                        if (z && System.currentTimeMillis() - this.lastSetChargeLimit < 5000) {
                            z3 = false;
                        }
                    } else if (aa0Var != aa0.TIMER) {
                        startGovernorTimer();
                    }
                } else if (i3 != hz0.f1282a.o() || (z && System.currentTimeMillis() - this.lastSetChargeLimit < 5000)) {
                    z3 = false;
                }
                boolean z42 = z3;
                z3 = false;
                z2 = z42;
            } else if (aa0Var == aa0.BATTERY_CAPACITY_CHANGED || aa0Var == aa0.POWER_CONNECTED || aa0Var == aa0.POWER_DISCONNECTED) {
                z2 = true;
            }
            if (z2) {
                this.lastSetChargeLimit = System.currentTimeMillis();
                this.lastLimitValue = iPow;
                this.batteryUtils.z(iPow, z3);
            }
        } catch (Exception unused) {
        }
    }

    private final boolean sleepChargeMode(int i, int i2, int i3, aa0 aa0Var) {
        if (i < 20 || !inSleepTime()) {
            return false;
        }
        int getUpTime = getGetUpTime();
        if (i >= i2) {
            int i4 = this.lastLimitValue;
            int i5 = this.lowSpeedExtreme;
            if (i4 != i5) {
                this.lastLimitValue = i5;
                this.batteryUtils.z(i5, aa0Var == aa0.BATTERY_CAPACITY_CHANGED);
            }
        } else {
            int iB = (int) ((((double) ((i2 - i) / 100.0f)) * this.batteryCapacity) / ((double) (new wj0(getUpTime).b() / 60.0f)));
            int i6 = this.lowSpeedExtreme;
            if (iB < i6) {
                i3 = i6;
            } else if (iB <= i3) {
                i3 = iB;
            }
            if (this.lastLimitValue != i3) {
                this.lastLimitValue = i3;
                this.batteryUtils.z(i3, aa0Var == aa0.BATTERY_CAPACITY_CHANGED);
            }
        }
        return true;
    }

    private final void startGovernorTimer() {
        if (this.governorTimer == null) {
            Timer timer = new Timer("ChargeControl");
            timer.schedule(new ja0(this), 0L, 1000L);
            m42 m42Var = m42.f6769a;
            this.governorTimer = timer;
        }
    }

    private final void stopGovernorTimer() {
        Timer timer = this.governorTimer;
        if (timer != null) {
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = this.governorTimer;
            if (timer2 != null) {
                timer2.purge();
            }
            this.governorTimer = null;
        }
    }

    @Override // a.ha0
    public boolean eventFilter(aa0 aa0Var) {
        f92.d(aa0Var, "eventType");
        switch (ia0.f6391a[aa0Var.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    @Override // a.ha0
    public boolean isAsync() {
        return this.isAsync;
    }

    public final void onDestroy$app_release_mini() {
        resumeCharge();
        t60 t60Var = this.keepShellAsync;
        if (t60Var != null) {
            t60Var.a();
        }
        this.keepShellAsync = null;
    }

    @Override // a.ha0
    public void onReceive(aa0 aa0Var, HashMap<String, Object> map) {
        f92.d(aa0Var, "eventType");
        if (fa0.f867a.a() < 0) {
            return;
        }
        if (aa0Var == aa0.POWER_CONNECTED) {
            this.cdpDisableDelay = true;
            Scene.f4798a.j(new c(), 5000L);
        }
        try {
            boolean shouldBP = getShouldBP();
            if (shouldBP != this.chargeDisabled) {
                if (!shouldBP) {
                    resumeCharge();
                    return;
                }
                disableCharge();
            }
            if (getOnCharge()) {
                if (sleepChargeMode(fa0.f867a.a(), getBpAllowed() ? getBpLevel() : 100, getQcLimit(), aa0Var) || !this.config.getBoolean(hz0.f1282a.q(), false)) {
                    return;
                }
                autoChangeLimitValue(aa0Var);
            }
        } catch (Exception unused) {
        }
    }

    @Override // a.ha0
    public void onSubscribe() {
    }

    @Override // a.ha0
    public void onUnsubscribe() {
    }
}

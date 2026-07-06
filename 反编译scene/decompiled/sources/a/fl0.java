package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fl0 extends g92 implements v72<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fl0 f6117a = new fl0();

    public fl0() {
        super(0);
    }

    public final boolean a() {
        return x60.f7856a.a(new String[]{"/sys/class/power_supply/battery/constant_charge_current_max", "/sys/class/power_supply/battery/constant_charge_current", "/sys/class/power_supply/main/constant_charge_current_max", "/sys/class/xm_power/charger/charger_thermal/wired_chg_curr"}) != null;
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ Boolean i() {
        return Boolean.valueOf(a());
    }
}

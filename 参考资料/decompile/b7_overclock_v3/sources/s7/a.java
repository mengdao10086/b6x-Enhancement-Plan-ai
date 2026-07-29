package s7;

import android.content.IntentFilter;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.j1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f49520a = b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f49521b = {"/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/devices/platform/s5p-tmu/temperature", "/sys/devices/platform/s5p-tmu/curr_temp", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/class/thermal/thermal_zone0/temp", "/sys/class/thermal/thermal_zone1/temp", "/sys/class/thermal/thermal_zone3/temp", "/sys/class/thermal/thermal_zone4/temp", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/htc/cpu_temp", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/ext_temperature", "/sys/devices/platform/tegra-tsensor/tsensor_temperature"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<Integer> f49522c;

    public static class b implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches(f4.b.f27965b, file.getName());
        }

        public b() {
        }
    }

    public static int a() {
        List<Integer> listE = e();
        int i10 = 0;
        int iIntValue = 0;
        while (true) {
            int i11 = f49520a;
            if (i10 >= i11) {
                return Math.min(iIntValue / i11, 100);
            }
            iIntValue += (listE.get(i10).intValue() * 100) / f(i10);
            i10++;
        }
    }

    public static int b() {
        try {
            return new File(f4.b.f27966c).listFiles(new b()).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static int c(int i10) {
        if (i10 < 100) {
            return i10;
        }
        do {
            i10 /= 10;
        } while (i10 >= 100);
        return i10;
    }

    public static int d() {
        int iC = 0;
        for (String str : f49521b) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line = bufferedReader.readLine();
                    bufferedReader.close();
                    fileReader.close();
                    iC = Integer.parseInt(line);
                    try {
                        iC = c(iC);
                    } catch (Exception unused) {
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
        return iC <= 0 ? (j1.a().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("temperature", 0) / 10) + ((a() * 5) / 100) : iC;
    }

    public static List<Integer> e() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < f49520a; i10++) {
            String strTrim = a0.s("/sys/devices/system/cpu/cpu" + i10 + "/cpufreq/scaling_cur_freq").trim();
            arrayList.add(Integer.valueOf(strTrim != null ? Integer.parseInt(strTrim) : 0));
        }
        return arrayList;
    }

    public static int f(int i10) {
        Integer numValueOf;
        if (f49522c == null) {
            f49522c = new ArrayList(f49520a);
            for (int i11 = 0; i11 < f49520a; i11++) {
                f49522c.add(-1000);
            }
        }
        if (f49522c.get(i10).intValue() != -1000) {
            numValueOf = f49522c.get(i10);
        } else {
            String strTrim = a0.s("/sys/devices/system/cpu/cpu" + i10 + "/cpufreq/cpuinfo_max_freq").trim();
            if (strTrim == null) {
                for (int i12 = 0; i12 < f49520a; i12++) {
                    a0.s("/sys/devices/system/cpu/cpu" + i12 + "/cpufreq/cpuinfo_max_freq").trim();
                }
                return -1000;
            }
            f49522c.set(i10, Integer.valueOf(strTrim));
            numValueOf = Integer.valueOf(strTrim);
        }
        return numValueOf.intValue();
    }
}

package xa;

import android.content.res.AssetManager;
import android.os.Environment;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f54981a = "MPChart-FileUtils";

    public static List<BarEntry> a(AssetManager assetManager, String str) throws Throwable {
        BufferedReader bufferedReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(str), "UTF-8"));
                } catch (IOException e10) {
                    e = e10;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e11) {
            e11.toString();
        }
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] strArrSplit = line.split("#");
                arrayList.add(new BarEntry(Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[0])));
            }
            bufferedReader.close();
        } catch (IOException e12) {
            e = e12;
            bufferedReader2 = bufferedReader;
            e.toString();
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e13) {
                    e13.toString();
                }
            }
            throw th;
        }
        return arrayList;
    }

    public static List<Entry> b(AssetManager assetManager, String str) throws Throwable {
        BufferedReader bufferedReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(str), "UTF-8"));
                } catch (IOException e10) {
                    e10.toString();
                }
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] strArrSplit = line.split("#");
                if (strArrSplit.length <= 2) {
                    arrayList.add(new Entry(Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[0])));
                } else {
                    int length = strArrSplit.length - 1;
                    float[] fArr = new float[length];
                    for (int i10 = 0; i10 < length; i10++) {
                        fArr[i10] = Float.parseFloat(strArrSplit[i10]);
                    }
                    arrayList.add(new BarEntry(Integer.parseInt(strArrSplit[strArrSplit.length - 1]), fArr));
                }
            }
            bufferedReader.close();
        } catch (IOException e12) {
            e = e12;
            bufferedReader2 = bufferedReader;
            e.toString();
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e13) {
                    e13.toString();
                }
            }
            throw th;
        }
        return arrayList;
    }

    public static List<Entry> c(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] strArrSplit = line.split("#");
                if (strArrSplit.length <= 2) {
                    arrayList.add(new Entry(Float.parseFloat(strArrSplit[0]), Integer.parseInt(strArrSplit[1])));
                } else {
                    int length = strArrSplit.length - 1;
                    float[] fArr = new float[length];
                    for (int i10 = 0; i10 < length; i10++) {
                        fArr[i10] = Float.parseFloat(strArrSplit[i10]);
                    }
                    arrayList.add(new BarEntry(Integer.parseInt(strArrSplit[strArrSplit.length - 1]), fArr));
                }
            }
        } catch (IOException e10) {
            e10.toString();
        }
        return arrayList;
    }

    public static void d(List<Entry> list, String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e10) {
                e10.toString();
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Entry entry : list) {
                bufferedWriter.append((CharSequence) (entry.e() + "#" + entry.F()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e11) {
            e11.toString();
        }
    }
}

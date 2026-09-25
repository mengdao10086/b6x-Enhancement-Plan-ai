package com.example.waspwingtempctrl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 骨架占位图：把三页各自「已经建好、还没绑具体数据」的样子截成半分辨率图落在 {@code cacheDir} 下，
 * 供下次启动时先盖住页面区、真页面画出来再撤（显示侧在 {@link SetupActivity}）。
 *
 * <p><b>为什么落盘而不是留内存</b>：它要跨进程生效 —— 下一轮冷启动的首帧之前就得能拿出来，那时进程里
 * 除了一份磁盘缓存什么都没有；图本身又是「大块、可重建、只在那一瞬有用」的东西，占内存不值得。
 *
 * <p><b>为什么在主包而不是 {@code ui/}</b>：唯一的调用方是 {@link SetupActivity}（同包）。它只以包内
 * 可见对外，挪去 {@code ui/} 就必须改成 {@code public}，那等于凭空多出一个公共接口（本类不接受）。

 *
 * <p><b>失效键</b>（{@link #currentKey}）= 夜间模式 + 屏幕宽×高(px) + densityDpi + fontScale +
 * versionCode。前两项决定画面长什么样，字体缩放会改文字排版，版本升级可能改布局与主题；任一变即重截。
 * 只对<b>本进程自己</b>负责：{@code cacheDir} 被系统清掉时键也一起没了，{@link #isCurrent} 自然判失效。
 *
 * <p><b>线程</b>：{@link #captureIfNeeded} 在<b>主线程</b>调（{@code view.draw} 必须在主线程，对已
 * measure+layout 的 offscreen 视图同样有效），编码与写盘在本类的后台线程；{@link #load} 是同步的、
 * <b>只能在后台线程调</b>（File IO + 解码）。{@link #isCurrent}（一次小文件读 + 一次已 memo 的
 * versionCode 读）与 {@link #clear}（目录列表 + 删文件）没有重活，主线程调得起。
 *
 * <p><b>写盘顺序</b>：先清旧键 → 逐页写图 → 全成了才写 key.txt。键是「这批图属于哪套外观」的唯一凭据，
 * 缺键即失效，故中途失败只会导致下次启动重截，不会让新旧图混着用。
 */
final class SkeletonStore {

    /** 缓存目录（{@code cacheDir} 下，与守护进程产物所在的 {@code filesDir} 分开：清缓存即作废）。 */
    private static final String DIR_NAME = "skeleton";
    /** 失效键文件名。 */
    private static final String KEY_NAME = "key.txt";
    /** 每页一个文件；名字里的数字即页序号（与 {@code SetupActivity.MENU_IDS} 同序）。 */
    private static final String PAGE_PREFIX = "page";
    private static final String PAGE_SUFFIX = ".webp";

    /** 截图缩放除数：宽高各取 1/2。占位图只看轮廓，半分辨率省一半磁盘、解码内存与编码耗时。 */
    private static final int HALF = 2;
    /** WebP 有损质量：85 时单页约百 KB 级（目标 ≲300KB），再往上肉眼收益很小而体积成倍涨。 */
    private static final int QUALITY = 85;
    /** 键文件只有几十字节，一次读完的上界。 */
    private static final int KEY_MAX_BYTES = 256;

    /** 编码 + 写盘线程：进程级一个（一套外观只截一次三页，不值得线程池）。 */
    private static final ExecutorService WRITER = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "ww-skeleton");
        thread.setDaemon(true);
        return thread;
    });

    /**
     * 本进程的 versionCode，取到一次即 memo：进程存活期间它不可能变，故 {@link #isCurrent} 即便在
     * 主线程调，最多也只多出一次 binder IPC（{@code getPackageInfo} 是 IPC，见 StatusFragment 的口径）。
     * 取值用 SDK 分支而不是 compat 类：本模块不直接依赖 androidx.core（见 build.gradle.kts 的依赖注释）。
     */
    private static volatile long versionCodeMemo = -1L;

    private SkeletonStore() {
    }

    /** 现有这套图是否与当前外观 / 尺寸 / 版本配套（键文件与现算的键一致）。 */
    static boolean isCurrent(Context context) {
        return currentKey(context).equals(readKey(keyFile(dir(context))));
    }

    /**
     * 截一套图（幂等：{@link #isCurrent} 为真直接返回）。
     *
     * <p><b>主线程调</b>：三页都已经是绘制过的视图，用软件画布重画一遍即可（不依赖 display list），
     * 也不清空 / 刷新任何真实数据 —— 截的就是调用这一刻页面长什么样。
     *
     * @param pageRoots 三页的根视图，<b>下标即页序号</b>；某页还没有视图时该位传 {@code null}。
     *                  只要有一位没准备好就整批放弃、不写键（下次启动重来），免得留下半套图
     */
    static void captureIfNeeded(Context context, View[] pageRoots) {
        if (isCurrent(context)) {
            return;
        }
        int count = pageRoots.length;
        int[] width = new int[count];
        int[] height = new int[count];
        for (int i = 0; i < count; i++) {
            View root = pageRoots[i];
            // 没量出尺寸的视图画出来是空图，不如不截
            if (root == null || root.getWidth() <= 0 || root.getHeight() <= 0) {
                return;
            }
            width[i] = root.getWidth();
            height[i] = root.getHeight();
        }
        // 主线程只负责 draw；清旧图、编码、写盘全交给后台。这里先换成 Application Context 给后台用，
        // 免得把 Activity 钉在写盘线程上
        Context app = context.getApplicationContext();
        String key = currentKey(app);
        Bitmap[] shots = new Bitmap[count];
        for (int i = 0; i < count; i++) {
            shots[i] = drawHalf(pageRoots[i], width[i], height[i]);
        }
        WRITER.execute(() -> {
            File dir = dir(app);
            if (!dir.isDirectory() && !dir.mkdirs()) {
                return;
            }
            // 先清旧键（顺带清旧图）：写到一半就退出时，留着旧键会把「新图 + 旧键」凑成一份
            // 看起来配套的缓存，缺键则下次启动老实重截
            clear(app);
            writeAll(dir, shots, key);
        });
    }

    /**
     * 取某页的骨架图（<b>后台线程调</b>）。没有图 / 键已失效 / 解不出来，一律返回 {@code null}，
     * 调用方据此退回「不显示覆盖层」的现状。
     *
     * <p>解出来的就是半分辨率图，由 ImageView 按 FIT_XY 拉满页面区（宽高比与截图时一致，故不变形）。
     */
    static Bitmap load(Context context, int pageIndex) {
        if (!isCurrent(context)) {
            return null;
        }
        try {
            return BitmapFactory.decodeFile(pageFile(dir(context), pageIndex).getAbsolutePath());
        } catch (Throwable t) {
            // 缓存内容不受控（可能被清理 / 写坏）：解不出来一律当没有，不许把启动带崩
            return null;
        }
    }

    /**
     * 清掉整套图与键（重截前先调，见 {@link #captureIfNeeded}）。删不掉的留着也无害：
     * 缺键即失效，没有键的图永远不会被 {@link #load} 用上。
     */
    static void clear(Context context) {
        File[] files = dir(context).listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            file.delete();
        }
    }

    // ==================== 内部：截图与写盘 ====================

    /** 把一页的根视图缩到半分辨率位图（主线程）。 */
    private static Bitmap drawHalf(View root, int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(
                Math.max(1, width / HALF), Math.max(1, height / HALF), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.scale(1f / HALF, 1f / HALF);
        root.draw(canvas);
        return bitmap;
    }

    /** 后台：逐页编码写盘，全写成了才写键（见类注释的写盘顺序）。 */
    private static void writeAll(File dir, Bitmap[] shots, String key) {
        for (int i = 0; i < shots.length; i++) {
            boolean ok = writePage(dir, i, shots[i]);
            shots[i].recycle();   // 编完立刻还内存：三页半屏 ≈ 数 MB，不留给 GC 慢慢收
            if (!ok) {
                return;
            }
        }
        writeKey(dir, key);
    }

    /** 编码一页并替换掉旧文件（临时文件 + renameTo，与 profile.conf 的写法同口径）。 */
    private static boolean writePage(File dir, int page, Bitmap bitmap) {
        File tmp = new File(dir, PAGE_PREFIX + page + PAGE_SUFFIX + ".tmp");
        try (FileOutputStream out = new FileOutputStream(tmp, false)) {
            // 用已废弃的 WEBP 而不是 WEBP_LOSSY：后者自 API 30 才有，本模块 minSdk 25，
            // 低版本上会 NoSuchFieldError；而 WEBP 在低版本上本来就是有损 + 按 quality 编码，正是这里要的
            if (!bitmap.compress(Bitmap.CompressFormat.WEBP, QUALITY, out)) {
                return false;
            }
        } catch (IOException e) {
            return false;   // 写不成 = 没图：不写键，下次启动重截
        }
        return replace(tmp, pageFile(dir, page));
    }

    private static void writeKey(File dir, String key) {
        File tmp = new File(dir, KEY_NAME + ".tmp");
        try (FileOutputStream out = new FileOutputStream(tmp, false)) {
            out.write(key.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            return;
        }
        replace(tmp, keyFile(dir));
    }

    /** 临时文件原子替换目标；失败时清掉临时文件，不留半截产物。 */
    private static boolean replace(File tmp, File dst) {
        if (tmp.renameTo(dst)) {
            return true;
        }
        // 少数文件系统上 renameTo 不能覆盖已存在的目标：删掉目标再试一次
        if (dst.delete() && tmp.renameTo(dst)) {
            return true;
        }
        tmp.delete();
        return false;
    }

    // ==================== 内部：键 ====================

    /** 现算的失效键（见类注释）。 */
    private static String currentKey(Context context) {
        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        boolean night = (config.uiMode & Configuration.UI_MODE_NIGHT_MASK)
                == Configuration.UI_MODE_NIGHT_YES;
        return "night=" + (night ? 1 : 0)
                + ";w=" + metrics.widthPixels
                + ";h=" + metrics.heightPixels
                + ";dpi=" + metrics.densityDpi
                + ";font=" + config.fontScale
                + ";ver=" + versionCode(context);
    }

    /** 本进程版本的 versionCode（memo，见字段注释）。读不到时记 0：键仍靠其余四项区分，不至于次次重截。 */
    private static long versionCode(Context context) {
        long memo = versionCodeMemo;
        if (memo >= 0L) {
            return memo;
        }
        long value = 0L;
        try {
            PackageInfo info = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            value = Build.VERSION.SDK_INT >= 28 ? info.getLongVersionCode() : info.versionCode;
        } catch (Throwable ignored) {
            // 用 0 兜底
        }
        versionCodeMemo = value;
        return value;
    }

    /** 读键文件；没有 / 读不到返回空串（空串与任何现算的键都不等，即判失效）。 */
    private static String readKey(File file) {
        try (FileInputStream in = new FileInputStream(file)) {
            byte[] buf = new byte[KEY_MAX_BYTES];
            int read = in.read(buf);
            return read <= 0 ? "" : new String(buf, 0, read, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return "";
        }
    }

    // ==================== 内部：落点 ====================

    private static File dir(Context context) {
        return new File(context.getCacheDir(), DIR_NAME);
    }

    private static File pageFile(File dir, int page) {
        return new File(dir, PAGE_PREFIX + page + PAGE_SUFFIX);
    }

    private static File keyFile(File dir) {
        return new File(dir, KEY_NAME);
    }
}

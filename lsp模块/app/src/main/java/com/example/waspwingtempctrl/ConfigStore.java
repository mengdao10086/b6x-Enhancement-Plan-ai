package com.example.waspwingtempctrl;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <b>I3（已冻结）：配置读写归属</b> —— 界面只用本类读写 {@code profile.conf}，
 * 不得自己拼 shell 命令或直接碰文件。
 *
 * <p>写入一律「同目录临时文件 → fsync → rename」；改单键只替换该行的值片段，其余字节不动。
 * 全部方法是本地磁盘 I/O（毫秒级阻塞），可在主线程调用；本类不含任何 root 调用。
 *
 * <p>设计理由、解析口径、校验语义、memo 与指纹等详见 app/逻辑说明.md §3。
 */
public final class ConfigStore {

    /** 配置文件固定名（与 {@code params.json} 的 {@code configFileName} 一致）。 */
    public static final String CONFIG_FILE_NAME = "profile.conf";

    /** 参数定义（I1 产物，APK 内单一来源）。 */
    public static final String PARAMS_ASSET = "params.json";

    /**
     * C 端私有目录（{@code tempctrl.c} 的 {@code PRIVATE_DIR} 宏，硬编码）；改包名或改该宏时两边须同步。
     * 跨端落点一致性检查的由来见 app/逻辑说明.md §3.1。
     */
    public static final String DAEMON_PRIVATE_DIR = "/data/data/com.example.waspwingtempctrl/files";

    private static volatile ConfigStore instance;

    /** {@link #read()} 的最近一次结果；指纹一致就直接回吐（见 app/逻辑说明.md §3.5）。 */
    private volatile Memo memo;

    /** 一份快照 + 它对应的文件指纹。不可变对象，故 volatile 一次读写即一致（见 app/逻辑说明.md §3.5）。 */
    private static final class Memo {
        final String fingerprint;
        final Snapshot snapshot;

        Memo(String fingerprint, Snapshot snapshot) {
            this.fingerprint = fingerprint;
            this.snapshot = snapshot;
        }
    }

    private final File filesDir;
    private final File configFile;

    /** params.json 顺序的键表。 */
    private final LinkedHashMap<String, KeyMeta> keys = new LinkedHashMap<>();
    private final List<GroupMeta> groups = new ArrayList<>();
    private final String configFileNameFromDef;
    private String loadError = "";

    private ConfigStore(Context context) {
        // 记账（旁路）：定义加载（读 assets/params.json + 建键表）的耗时。构造只可能成功一次
        // （双检锁），而"谁来构造"取决于哪根线程先到，故计时贴在这里（干活的地方）而不是任一调用点
        long startedAt = StartupTiming.now();
        Context app = context.getApplicationContext();
        this.filesDir = app.getFilesDir();
        this.configFile = new File(filesDir, CONFIG_FILE_NAME);
        JSONObject root = null;
        String fileName = CONFIG_FILE_NAME;
        try {
            root = new JSONObject(readAsset(app, PARAMS_ASSET));
            String defName = root.optString("configFileName", "");
            if (!defName.isEmpty()) {
                fileName = defName;
            }
        } catch (Exception e) {
            loadError = "读取 assets/" + PARAMS_ASSET + " 失败：" + e.getMessage();
        }
        this.configFileNameFromDef = fileName;
        if (root != null) {
            parseDefinitions(root);
        }
        StartupTiming.span(StartupTiming.DEF_LOAD, startedAt);
    }

    public static ConfigStore get(Context context) {
        ConfigStore local = instance;
        if (local == null) {
            synchronized (ConfigStore.class) {
                local = instance;
                if (local == null) {
                    local = new ConfigStore(context);
                    instance = local;
                }
            }
        }
        return local;
    }

    // ==================== 路径 ====================

    /** 配置文件绝对路径（app 侧真实可写落点）。 */
    public File getConfigFile() {
        return configFile;
    }

    /** app 私有目录（C 端的 PRIVATE_DIR 目标）。 */
    public File getPrivateDir() {
        return filesDir;
    }

    public boolean exists() {
        return configFile.isFile();
    }

    /**
     * 跨端落点是否一致：C 端 {@code PRIVATE_DIR} 与 app 的 {@link Context#getFilesDir()} 同路径时为 true。
     * 返回 false 即守护进程读不到本类写的配置，界面必须如实告警。护栏由来见 app/逻辑说明.md §3.1。
     */
    public boolean isPathAlignedWithDaemon() {
        // 只做字面比较会误报：Context.getFilesDir() 在设备上通常是 /data/user/0/<包名>/files，
        // 而 C 端硬编码 /data/data/<包名>/files（/data/data 是前者的符号链接，同一目录）。
        try {
            if (filesDir.getCanonicalPath().equals(new File(DAEMON_PRIVATE_DIR).getCanonicalPath())) {
                return true;
            }
        } catch (IOException ignored) {
            // 取不到规范路径时退回字面比较
        }
        return filesDir.getAbsolutePath().equals(DAEMON_PRIVATE_DIR);
    }

    /** C 端会去找的配置文件绝对路径（不管是否与 app 侧一致）。 */
    public String daemonConfigPath() {
        return DAEMON_PRIVATE_DIR + "/" + configFileNameFromDef;
    }

    /** 参数定义是否加载成功。 */
    public boolean definitionsLoaded() {
        return loadError.isEmpty() && !keys.isEmpty();
    }

    // ==================== 元数据（来自 params.json） ====================

    public List<GroupMeta> groups() {
        return Collections.unmodifiableList(groups);
    }

    /** 全部键元数据，按 params.json 顺序。 */
    public List<KeyMeta> keys() {
        return Collections.unmodifiableList(new ArrayList<>(keys.values()));
    }

    /** 未知键返回 null（界面必须按 null 处理，不得静默当默认值）。 */
    public KeyMeta key(String key) {
        return keys.get(key);
    }

    public String configFileName() {
        return configFileNameFromDef;
    }

    /** 键总数（定义里现有 57；界面可据此自检）。 */
    public int keyCount() {
        return keys.size();
    }

    // ==================== 读 ====================

    /**
     * 一次读取的快照。
     *
     * <p>{@code values} 中缺键用 {@link KeyMeta#defaultValue} 补齐；{@code unknownKeys}
     * 是文件里存在但 params.json 未定义的键（界面应提示，不得静默忽略）。
     */
    public static final class Snapshot {
        public final Map<String, Value> values;
        public final List<String> unknownKeys;
        public final boolean exists;
        public final long mtimeMs;
        public final List<String> notes;

        Snapshot(Map<String, Value> values, List<String> unknownKeys, boolean exists,
                 long mtimeMs, List<String> notes) {
            this.values = Collections.unmodifiableMap(values);
            this.unknownKeys = Collections.unmodifiableList(unknownKeys);
            this.exists = exists;
            this.mtimeMs = mtimeMs;
            this.notes = Collections.unmodifiableList(notes);
        }

        public Value get(String key) {
            return values.get(key);
        }
    }

    /**
     * 读全文并解析。<b>同一份文件（{@link #configFingerprint()} 未变）复用上一份快照</b>：
     * 不再读盘、也不再解析。文件不存在 → 全部取 {@link KeyMeta#defaultValue}。
     *
     * <p>解析口径照 C 端 {@code config_parse_line()}（见 app/逻辑说明.md §3.3）；
     * memo 与「读失败不留档」见 app/逻辑说明.md §3.5。
     *
     * <p>指纹未变时返回的<b>就是上一份快照</b>，故它与 {@link Snapshot} 自己的字段一样只读。
     */
    public Snapshot read() {
        String fingerprint = configFingerprint();
        Memo cached = memo;
        if (cached != null && fingerprint.equals(cached.fingerprint)) {
            return cached.snapshot;
        }
        if (!exists()) {
            Snapshot absent = allDefaults(false, 0L,
                    "配置不存在，以下为出厂默认值：" + configFile.getAbsolutePath());
            memo = new Memo(fingerprint, absent);   // 文件一出现指纹就变，不会读到旧账
            return absent;
        }
        long mtime = configFile.lastModified();
        // 记账（旁路）：只量"真读盘 + 真解析"这一段（上面几处命中 memo / 文件不存在都已早退）。
        // 首次写入胜出，故并发时只认本次进程里先完成的那一次
        long startedAt = StartupTiming.now();
        String text;
        try {
            text = new String(readAllBytes(configFile), StandardCharsets.UTF_8);
        } catch (IOException e) {
            // 读失败不进 memo（与 Deployer.ASSET_MD5_MEMO 同口径）：一次瞬时失败不该被永久记住，
            // 文件没变、指纹也认不出这一茬，留档就等于此后连重试的机会都没有
            return allDefaults(true, mtime, "配置读取失败：" + e.getMessage());
        }
        Snapshot snapshot = parseText(text, mtime);
        StartupTiming.span(StartupTiming.SNAP_LOAD, startedAt);
        // 登记前复核：仅当读盘期间 memo 没被别人换过才登记（st_mtime 秒级精度认不出同秒改写，见 §3.5）
        if (memo == cached && fingerprint.equals(configFingerprint())) {
            memo = new Memo(fingerprint, snapshot);
        }
        return snapshot;
    }

    /**
     * 配置文件指纹（{@code mtime:size}）；文件不存在时 {@code "-"}。必带 {@code size}，
     * 共用口径与理由见 app/逻辑说明.md §3.5。
     */
    public String configFingerprint() {
        if (!configFile.isFile()) {
            return "-";
        }
        return configFile.lastModified() + ":" + configFile.length();
    }

    /** 读不到盘时的快照：每个定义键取出厂默认值，附一条说明（{@link #read()} 的两条退化路径共用）。 */
    private Snapshot allDefaults(boolean exists, long mtimeMs, String note) {
        LinkedHashMap<String, Value> values = new LinkedHashMap<>();
        for (KeyMeta meta : keys.values()) {
            values.put(meta.key, meta.defaultValue);
        }
        return new Snapshot(values, new ArrayList<>(), exists, mtimeMs,
                new ArrayList<>(Collections.singletonList(note)));
    }

    /**
     * 解析一段已就位的配置文本（口径见 {@link #read()}）。不碰磁盘，故写盘成功后可以拿刚写进去的
     * 那段文本直接走这里（见 {@link #rememberWritten}）。理由见 app/逻辑说明.md §3.3。
     *
     * @param mtimeMs 该段文本对应的文件 mtime（只用于快照里给界面显示的元信息）
     */
    private Snapshot parseText(String text, long mtimeMs) {
        LinkedHashMap<String, Value> values = new LinkedHashMap<>();
        List<String> unknown = new ArrayList<>();
        List<String> notes = new ArrayList<>();
        Set<String> seenUnknown = new HashSet<>();
        LinkedHashMap<String, Value> fromFile = new LinkedHashMap<>();
        for (String line : ConfText.splitLines(text)) {
            int eq = ConfText.configLineEq(line);
            if (eq < 0) {
                continue;
            }
            String rawKey = ConfText.trimRight(line.substring(ConfText.lineStartOf(line), eq));
            String rawVal = line.substring(eq + 1);
            KeyMeta meta = keys.get(rawKey);
            if (meta == null) {
                if (seenUnknown.add(rawKey)) {
                    unknown.add(rawKey);
                }
                continue;
            }
            fromFile.put(rawKey, parseValue(meta, rawVal));
        }
        // 对外按 params.json 顺序输出（与界面表单顺序一致）；文件中缺失的键用出厂默认值补齐
        for (KeyMeta meta : keys.values()) {
            Value v = fromFile.get(meta.key);
            values.put(meta.key, v != null ? v : meta.defaultValue);
        }
        return new Snapshot(values, unknown, true, mtimeMs, notes);
    }

    /**
     * 写盘成功后就地更新 {@link #memo}：新内容就在手上，不必等下一次 {@link #read()} 再读盘解一遍。
     * 与「重新读一遍盘」同源（{@link #parseText}）。详见 app/逻辑说明.md §3.5。
     */
    private void rememberWritten(String text) {
        memo = new Memo(configFingerprint(), parseText(text, configFile.lastModified()));
    }

    /** 单键取值；文件缺失或键缺失 → 出厂默认值。 */
    public Value get(String key) {
        return read().get(key);
    }

    // ==================== 写 ====================

    /** 一次写入的结果（{@link #describe()} 出人话）。 */
    public static final class WriteResult {
        public final boolean ok;
        public final boolean skipped;
        public final boolean changed;
        public final int replaced;
        public final int appended;
        public final long mtimeMs;
        public final String error;
        public final String note;

        WriteResult(boolean ok, boolean skipped, boolean changed, int replaced, int appended,
                    long mtimeMs, String error, String note) {
            this.ok = ok;
            this.skipped = skipped;
            this.changed = changed;
            this.replaced = replaced;
            this.appended = appended;
            this.mtimeMs = mtimeMs;
            this.error = error;
            this.note = note;
        }

        static WriteResult failure(String error) {
            return new WriteResult(false, false, false, 0, 0, 0L, error, "");
        }

        static WriteResult skipped(String note) {
            return new WriteResult(true, true, false, 0, 0, 0L, "", note);
        }

        public String describe() {
            if (!ok) {
                return "写入失败：" + error;
            }
            if (skipped) {
                return "未写入：" + note;
            }
            if (!changed) {
                return "值未变化，无需写入";
            }
            return "已写入（替换 " + replaced + " 行"
                    + (appended > 0 ? "，追加 " + appended + " 行" : "")
                    + "，mtime=" + mtimeMs + "）";
        }
    }

    /**
     * 批量改键：全部改动合并为<b>一次</b> rename，避免多次 mtime 触发多轮 C 端重载。
     *
     * <p>保留全文只替换目标行的值片段；未知键拒绝写入；值未变化时直接跳过。
     * 详见 app/逻辑说明.md §3.2。
     */
    public WriteResult setAll(Map<String, Value> changes) {
        if (!definitionsLoaded()) {
            return WriteResult.failure("参数定义未加载：" + loadError);
        }
        if (changes == null || changes.isEmpty()) {
            return WriteResult.failure("没有要写入的键");
        }
        for (String key : changes.keySet()) {
            KeyMeta meta = keys.get(key);
            if (meta == null) {
                return WriteResult.failure("未知键（params.json 未定义）：" + key);
            }
            if (changes.get(key) == null) {
                return WriteResult.failure("键 " + key + " 的值为 null");
            }
        }
        String text;
        boolean fileExists = exists();
        if (fileExists) {
            try {
                byte[] raw = readAllBytes(configFile);
                text = new String(raw, StandardCharsets.UTF_8);
                if (!Arrays.equals(text.getBytes(StandardCharsets.UTF_8), raw)) {
                    return WriteResult.failure("配置文件不是合法 UTF-8，拒绝改写以免损坏内容");
                }
            } catch (IOException e) {
                return WriteResult.failure("读取失败：" + e.getMessage());
            }
        } else {
            text = header();
        }

        LinkedHashMap<String, String> pending = new LinkedHashMap<>();
        LinkedHashMap<String, String> appendComments = new LinkedHashMap<>();
        for (Map.Entry<String, Value> e : changes.entrySet()) {
            pending.put(e.getKey(), e.getValue().format());
            appendComments.put(e.getKey(), keys.get(e.getKey()).label);
        }
        ConfText.Edit edit = ConfText.apply(text, pending, appendComments);
        int replaced = edit.replaced;
        int appended = edit.appended;

        if (edit.text.equals(text) && fileExists) {
            return new WriteResult(true, false, false, replaced, appended, configFile.lastModified(), "", "");
        }
        try {
            writeAtomic(edit.text);
        } catch (IOException e) {
            return WriteResult.failure(e.getMessage());
        }
        rememberWritten(edit.text);
        return new WriteResult(true, false, true, replaced, appended, configFile.lastModified(), "", "");
    }

    /**
     * 写出厂配置：<b>仅当文件不存在时</b>；已存在则一个字都不覆盖（包括空白文件）。
     * 值取自 {@code params.json} 的 {@code factory} 字段（不是 {@code default}）。
     *
     * <p><b>由 {@link Deployer} 在部署时调用，界面不要自己调</b>。详见 app/逻辑说明.md §3.1。
     */
    public WriteResult writeFactoryIfAbsent() {
        if (!definitionsLoaded()) {
            return WriteResult.failure("参数定义未加载：" + loadError);
        }
        if (exists()) {
            return WriteResult.skipped("配置已存在，按决策保留不覆盖：" + configFile.getAbsolutePath());
        }
        StringBuilder sb = new StringBuilder(8192);
        sb.append(header());
        Set<String> emitted = new HashSet<>();
        for (GroupMeta group : groups) {
            sb.append('\n').append("# ").append(group.title).append('\n');
            // 组总开关不在 group.keys 里，必须先单独写出来（否则生成的配置里没有总开关行）
            if (group.master != null) {
                KeyMeta master = keys.get(group.master);
                if (master != null && emitted.add(master.key)) {
                    sb.append("# 组总开关：=0 时本组多数键不生效\n");
                    sb.append("# ").append(master.commentLine()).append('\n');
                    sb.append(master.key).append('=').append(master.factoryValue.format()).append('\n');
                }
            }
            for (String key : group.keys) {
                KeyMeta meta = keys.get(key);
                if (meta == null || !emitted.add(key)) {
                    continue;
                }
                sb.append("# ").append(meta.commentLine()).append('\n');
                sb.append(key).append('=').append(meta.factoryValue.format()).append('\n');
            }
        }
        // 兜底：没被任何分组覆盖的键也要写出来（否则出厂配置静默缺键，C 端会退回代码默认值）
        int orphans = 0;
        for (KeyMeta meta : keys.values()) {
            if (emitted.contains(meta.key)) {
                continue;
            }
            if (orphans == 0) {
                sb.append('\n').append("# 未分组\n");
            }
            sb.append("# ").append(meta.commentLine()).append('\n');
            sb.append(meta.key).append('=').append(meta.factoryValue.format()).append('\n');
            orphans++;
        }
        String text = sb.toString();
        try {
            writeAtomic(text);
        } catch (IOException e) {
            return WriteResult.failure(e.getMessage());
        }
        rememberWritten(text);
        return new WriteResult(true, false, true, 0, emitted.size() + orphans,
                configFile.lastModified(), "", "");
    }

    // ==================== 校验语义（P0 告警落地处） ====================

    /** 界面侧评估结果：「界面能接受的值」+ 是否被改动过（数值钳制 / enum 回落出厂值）。 */
    public static final class Assessment {
        /** 界面可接受并写出的值（数值按 min/max 逐字段钳制；enum 表外回落出厂值）。 */
        public final Value uiValue;
        public final boolean changedByClamp;
        /** 人话说明。 */
        public final List<String> notes;

        Assessment(Value uiValue, boolean changedByClamp, List<String> notes) {
            this.uiValue = uiValue;
            this.changedByClamp = changedByClamp;
            this.notes = Collections.unmodifiableList(notes);
        }
    }

    /**
     * 把用户输入折算成「界面能接受的值」：数值键按 {@code params.json} 的 min/max 逐字段钳制，
     * 文本键按自己的值域收敛（path 只 trim，enum 只认 {@code options} 里的字面量、表外回落出厂值）。
     * 详见 app/逻辑说明.md §3.4。
     */
    public Assessment assess(String key, Value raw) {
        KeyMeta meta = key(key);
        List<String> notes = new ArrayList<>();
        if (meta == null) {
            notes.add("未知键，params.json 未定义，不会写入");
            return new Assessment(raw, false, notes);
        }
        if (meta.isPath()) {
            if (raw.text().trim().isEmpty()) {
                notes.add("路径为空：C 端会跳过该键，保持代码默认值");
            }
            if (raw.text().indexOf('#') >= 0) {
                notes.add("路径含 '#'：C 端不剥离行内注释，'#' 之后会被当成路径的一部分");
            }
            return new Assessment(Value.ofText(raw.text().trim()), !raw.text().equals(raw.text().trim()),
                    notes);
        }
        if (meta.isEnum()) {
            // 取值域是文本的闭合集合，没有"区间可钳制"一说：只认表里的字面量，
            // 表外的值一律回落出厂值（出厂值由定义保证在取值域内），并记一条 note
            String text = raw.text().trim();
            if (meta.hasOption(text)) {
                return new Assessment(Value.ofText(text), !text.equals(raw.text()), notes);
            }
            notes.add("取值「" + text + "」不在定义的可选项内，已回落到出厂值「"
                    + meta.factoryValue.text() + "」");
            return new Assessment(meta.factoryValue, true, notes);
        }
        int n = Math.max(1, meta.fieldCount());
        List<Integer> nums = new ArrayList<>();
        boolean clamped = false;
        for (int i = 0; i < n; i++) {
            int v = raw.intAt(i);
            Integer min = meta.min(i);
            Integer max = meta.max(i);
            if (min != null && v < min) {
                v = min;
                clamped = true;
            }
            if (max != null && v > max) {
                v = max;
                clamped = true;
            }
            nums.add(v);
        }
        if (clamped) {
            notes.add("已按定义 min/max 钳制（界面能接受的值）");
        }
        Value ui = nums.size() == 1 ? Value.ofInt(nums.get(0)) : Value.ofNumbers(toIntArray(nums));
        return new Assessment(ui, clamped, notes);
    }

    // ==================== 诊断 ====================

    /** 诊断串（路径 / 定义 / 一致性 / 出厂值冲突）。 */
    public String describeState() {
        return describeState(read());
    }

    /**
     * 诊断串（路径 / 定义 / 一致性），复用调用方刚读到的快照（避免为拿提示白读一遍整文件）。
     * 详见 app/逻辑说明.md §3.4。
     *
     * @param snap 已读到的快照（调用方负责它确实是最近一次读取的结果）
     */
    public String describeState(Snapshot snap) {
        StringBuilder sb = new StringBuilder();
        sb.append("配置文件: ").append(configFile.getAbsolutePath())
                .append(exists() ? "（存在，" + configFile.length() + " B）" : "（不存在）").append('\n');
        sb.append("C 端路径: ").append(daemonConfigPath())
                .append(isPathAlignedWithDaemon() ? "（一致）" : "（不一致！守护进程读不到 app 写的配置）").append('\n');
        sb.append("参数定义: ").append(PARAMS_ASSET).append(" · ")
                .append(loadError.isEmpty() ? keyCount() + " 键" : loadError).append('\n');
        if (!snap.unknownKeys.isEmpty()) {
            sb.append("未定义键: ").append(join(snap.unknownKeys, ", ")).append('\n');
        }
        for (String note : snap.notes) {
            sb.append("提示: ").append(note).append('\n');
        }
        return sb.toString();
    }

    // ==================== 内部：定义解析 ====================

    private void parseDefinitions(JSONObject root) {
        try {
            JSONArray groupArr = root.optJSONArray("groups");
            if (groupArr != null) {
                for (int i = 0; i < groupArr.length(); i++) {
                    JSONObject g = groupArr.getJSONObject(i);
                    List<String> gk = new ArrayList<>();
                    JSONArray ka = g.optJSONArray("keys");
                    if (ka != null) {
                        for (int j = 0; j < ka.length(); j++) {
                            gk.add(ka.getString(j));
                        }
                    }
                    groups.add(new GroupMeta(g.optString("id", ""), g.optString("title", ""),
                            g.isNull("master") ? null : g.optString("master", null), gk));
                }
            }
            JSONObject keyObj = root.optJSONObject("keys");
            if (keyObj == null) {
                loadError = "params.json 缺少 keys 段";
                return;
            }
            java.util.Iterator<String> it = keyObj.keys();
            while (it.hasNext()) {
                String name = it.next();
                JSONObject o = keyObj.getJSONObject(name);
                KeyMeta meta = new KeyMeta(name, o);
                keys.put(name, meta);
            }
        } catch (Exception e) {
            loadError = "params.json 解析失败：" + e.getMessage();
            keys.clear();
            groups.clear();
        }
    }

    /** 一个键的元数据（全部来自 params.json）。 */
    public static final class KeyMeta {
        public final String key;
        public final String type;
        public final String label;
        public final String desc;
        public final String unit;
        public final String unitNote;
        public final Value defaultValue;
        public final Value factoryValue;
        public final List<String> requires;
        /**
         * 反向依赖：这些键中任一当前值为 1 时，本行在界面上<b>整行隐藏</b>（仅界面渲染用，不给 C 端）。
         * 与 {@link #requires}（值为 1 时才生效 → 否则压暗）方向相反；定义里没写即空表、行为与改动前一致。
         * 渲染落点见 {@link com.example.waspwingtempctrl.ui.ConfigKeyRow}。
         */
        public final List<String> hiddenWhen;
        public final boolean daemonConsumes;
        /** 多值键的字段定义；单值键为 null。 */
        public final List<FieldMeta> fields;
        /** enum 键的取值域（{@code options[]}）；无选项时为空表，恒不为 null。 */
        public final List<OptionMeta> options;

        /** 单值键的范围（多值键见 {@link #fields}）；null = 无界。 */
        private final Integer rawMin;
        private final Integer rawMax;

        KeyMeta(String key, JSONObject o) {
            this.key = key;
            this.type = o.optString("type", "");
            this.label = o.optString("label", key);
            this.desc = o.optString("desc", "");
            this.unit = o.optString("unit", "");
            this.unitNote = o.optString("unitNote", "");
            this.requires = jsonStringList(o.optJSONArray("requires"));
            this.hiddenWhen = jsonStringList(o.optJSONArray("hiddenWhen"));
            this.daemonConsumes = o.optBoolean("daemonConsumes", true);
            // 字段表与范围必须先就位：下面的 parseValue() 依赖 fieldCount()/min()/max()
            List<FieldMeta> f = new ArrayList<>();
            JSONArray fa = o.optJSONArray("fields");
            if (fa != null) {
                for (int i = 0; i < fa.length(); i++) {
                    JSONObject fo = fa.optJSONObject(i);
                    if (fo == null) {
                        continue;
                    }
                    f.add(new FieldMeta(fo.optString("label", "字段" + (i + 1)),
                            fo.optString("unit", ""),
                            fo.isNull("min") ? null : Integer.valueOf(fo.optInt("min")),
                            fo.isNull("max") ? null : Integer.valueOf(fo.optInt("max")),
                            fo.optInt("default", 0),
                            fo.optBoolean("bool", false)));
                }
            }
            this.fields = f.isEmpty() ? null : Collections.unmodifiableList(f);
            // 取值域与 fieldCount/min/max 无关，但要先于 defaultValue/factoryValue 就位：
            // 那两个值的解析口径由 type 决定（见 parseValue），出现顺序不影响结果，放一起便于阅读
            List<OptionMeta> opts = new ArrayList<>();
            JSONArray oa = o.optJSONArray("options");
            if (oa != null) {
                for (int i = 0; i < oa.length(); i++) {
                    JSONObject oo = oa.optJSONObject(i);
                    if (oo == null) {
                        continue;
                    }
                    String value = oo.optString("value", "");
                    if (value.isEmpty()) {
                        // 空值不是合法取值：放进来等于"选中它会写出空行"，直接跳过
                        continue;
                    }
                    opts.add(new OptionMeta(value, oo.optString("label", value)));
                }
            }
            this.options = Collections.unmodifiableList(opts);
            this.rawMin = o.isNull("min") ? null : Integer.valueOf(o.optInt("min"));
            this.rawMax = o.isNull("max") ? null : Integer.valueOf(o.optInt("max"));
            this.defaultValue = parseValue(this, jsonValue(o, "default"));
            this.factoryValue = parseValue(this, jsonValue(o, "factory"));
        }

        public boolean isMulti() {
            return "multi".equals(type);
        }

        public boolean isSwitch() {
            return "switch".equals(type);
        }

        public boolean isPath() {
            return "path".equals(type);
        }

        /** enum 型：值是<b>文本</b>，取值域是 {@link #options}（不是数值区间）。 */
        public boolean isEnum() {
            return "enum".equals(type);
        }

        /**
         * 值是文本（path / enum）：解析与校验都走"文本"这条路，不做数值切分
         * （见 {@link ConfigStore#parseValue} 与 {@link ConfigStore#assess}）。
         */
        public boolean isText() {
            return isPath() || isEnum();
        }

        /** {@code value} 是否落在本键的取值域内（enum 键用；其它类型的 {@link #options} 为空表）。 */
        public boolean hasOption(String value) {
            for (OptionMeta option : options) {
                if (option.value.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        /** 值的字段个数（path / enum 视为 1）。 */
        public int fieldCount() {
            return fields != null ? fields.size() : 1;
        }

        /** 第 i 个字段的下界；null = 无下界。 */
        public Integer min(int i) {
            if (fields != null) {
                return i < fields.size() ? fields.get(i).min : null;
            }
            return rawMin;
        }

        public Integer max(int i) {
            if (fields != null) {
                return i < fields.size() ? fields.get(i).max : null;
            }
            return rawMax;
        }

        /** 生成配置文件注释行用（label + 单位 + 范围 + 依赖）。 */
        String commentLine() {
            StringBuilder sb = new StringBuilder(label);
            if (!unit.isEmpty()) {
                sb.append("（").append(unit).append("）");
            }
            if (isPath()) {
                sb.append("：路径字符串");
            } else if (fields != null) {
                sb.append("：");
                for (int i = 0; i < fields.size(); i++) {
                    if (i > 0) {
                        sb.append(" · ");
                    }
                    sb.append(fields.get(i).label).append(' ')
                            .append(fields.get(i).min).append('~').append(fields.get(i).max);
                }
            } else if (rawMin != null && rawMax != null) {
                sb.append("：范围 ").append(rawMin).append('~').append(rawMax);
            }
            if (!requires.isEmpty()) {
                sb.append("；仅 ").append(joinEach(requires, "=1、")).append("=1 时生效");
            }
            return sb.toString();
        }
    }

    /** 多值键的一个字段。 */
    public static final class FieldMeta {
        public final String label;
        public final String unit;
        public final Integer min;
        public final Integer max;
        public final int defaultValue;
        /**
         * true = 布尔子开关（值只有 0/1）：界面据此渲染成开关而非数字输入框，C 端逐字段 clamp 跳过。
         * 详见 app/逻辑说明.md §3.4。
         */
        public final boolean bool;

        FieldMeta(String label, String unit, Integer min, Integer max, int defaultValue,
                  boolean bool) {
            this.label = label;
            this.unit = unit;
            this.min = min;
            this.max = max;
            this.defaultValue = defaultValue;
            this.bool = bool;
        }
    }

    /**
     * enum 键的一个可选值（{@code options[]} 的一项）：{@link #value} 是落盘字面量，
     * {@link #label} 是界面文案；取值域闭合（见 {@link ConfigStore#assess}）。
     * 详见 app/逻辑说明.md §3.4。
     */
    public static final class OptionMeta {
        public final String value;
        public final String label;

        OptionMeta(String value, String label) {
            this.value = value;
            this.label = label;
        }
    }

    /** 一个分组。 */
    public static final class GroupMeta {
        public final String id;
        public final String title;
        /** 组总开关键名；无则 null。 */
        public final String master;
        public final List<String> keys;

        GroupMeta(String id, String title, String master, List<String> keys) {
            this.id = id;
            this.title = title;
            this.master = master;
            this.keys = Collections.unmodifiableList(keys);
        }
    }

    // ==================== 内部：值 ====================

    /** 一个键的值。数值型用 {@code numbers}，路径型用 {@code text}。 */
    public static final class Value {
        private final int[] numbers;
        private final String text;

        private Value(int[] numbers, String text) {
            this.numbers = numbers;
            this.text = text;
        }

        public static Value ofInt(int v) {
            return new Value(new int[]{v}, null);
        }

        public static Value ofNumbers(int... v) {
            return new Value(v == null ? new int[0] : v.clone(), null);
        }

        public static Value ofNumbers(List<Integer> v) {
            return new Value(toIntArray(v), null);
        }

        public static Value ofText(String t) {
            return new Value(null, t == null ? "" : t);
        }

        public int size() {
            return text != null ? 1 : numbers.length;
        }

        public int intAt(int i) {
            if (text != null) {
                return 0;
            }
            return i >= 0 && i < numbers.length ? numbers[i] : 0;
        }

        public String text() {
            return text == null ? "" : text;
        }

        /** 写进配置文件的字面量（多值空格分隔）。 */
        public String format() {
            if (text != null) {
                return text;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numbers.length; i++) {
                if (i > 0) {
                    sb.append(' ');
                }
                sb.append(numbers[i]);
            }
            return sb.toString();
        }

        @Override
        public String toString() {
            return format();
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Value)) {
                return false;
            }
            Value v = (Value) o;
            return format().equals(v.format());
        }

        @Override
        public int hashCode() {
            return format().hashCode();
        }
    }

    // ==================== 内部：文本改写 ====================

    /** 文件头（新生成时使用）。 */
    private String header() {
        return "# 飞智 B6X 增强计划 — 智能温控配置\n"
                + "# 由 APK 首次部署生成，值取自 assets/" + PARAMS_ASSET + " 的 factory 字段\n"
                + "# 格式：KEY=VALUE（等号两边不要空格），# 开头为注释，空行自动跳过\n"
                + "# 多值键用单个空格分隔；行内注释请写在值的后面（路径类键不要写行内注释）\n"
                + "# 修改后无需重启 daemon，下一轮 5 秒循环自动热重载\n";
    }

    /**
     * 纯文本改写层（不引用任何 Android API，可在桌面 JVM 上直接跑测试）：「改单键逐字节可复现」
     * 的唯一实现点。详见 app/逻辑说明.md §3.2。
     */
    public static final class ConfText {

        /** {@link #apply} 的结果。 */
        public static final class Edit {
            public final String text;
            /** 被替换的行数（同键多行时 &gt; 1）。 */
            public final int replaced;
            /** 追加的行数（键不存在时）。 */
            public final int appended;

            Edit(String text, int replaced, int appended) {
                this.text = text;
                this.replaced = replaced;
                this.appended = appended;
            }
        }

        private ConfText() {
        }

        /**
         * 把 {@code changes}（键 → 已格式化的值字面量）应用到 {@code text}：
         * 命中的行只替换值片段，未命中的键追加到文件末尾（带一行注释头）。
         *
         * @param appendComments 追加时用的注释文本（键 → 说明），缺省时用键名
         */
        public static Edit apply(String text, Map<String, String> changes,
                                 Map<String, String> appendComments) {
            Map<String, String> pending = new LinkedHashMap<>(changes);
            Set<String> matched = new HashSet<>();
            StringBuilder out = new StringBuilder(text.length() + 256);
            int replaced = 0;
            int from = 0;
            while (true) {
                int nl = text.indexOf('\n', from);
                int lineEnd = nl < 0 ? text.length() : nl;
                String line = text.substring(from, lineEnd);
                int eq = configLineEq(line);
                String rewritten = null;
                if (eq >= 0) {
                    String rawKey = trimRight(line.substring(lineStartOf(line), eq));
                    String newValue = pending.get(rawKey);
                    if (newValue != null) {
                        // 同键多行时每一行都替换：C 端按行顺序覆盖，只改一行会不生效
                        rewritten = spliceValue(line, eq, newValue);
                        replaced++;
                        matched.add(rawKey);
                    }
                }
                out.append(rewritten != null ? rewritten : line);
                if (nl < 0) {
                    break;
                }
                out.append('\n');
                from = nl + 1;
            }

            int appended = 0;
            if (matched.size() < pending.size()) {
                if (out.length() > 0 && out.charAt(out.length() - 1) != '\n') {
                    out.append('\n');
                }
                for (Map.Entry<String, String> e : pending.entrySet()) {
                    if (matched.contains(e.getKey())) {
                        continue;
                    }
                    String comment = appendComments == null ? null : appendComments.get(e.getKey());
                    out.append('\n').append("# ")
                            .append(comment == null ? e.getKey() : comment)
                            .append("（本行由界面补写）\n");
                    out.append(e.getKey()).append('=').append(e.getValue()).append('\n');
                    appended++;
                }
            }
            return new Edit(out.toString(), replaced, appended);
        }

        /** 行首非空白字符下标（C 端 {@code trim_line()} 同口径）。 */
        public static int lineStartOf(String line) {
            int p = 0;
            while (p < line.length() && (line.charAt(p) == ' ' || line.charAt(p) == '\t')) {
                p++;
            }
            return p;
        }

        /** 返回 '=' 的下标；注释行 / 空行 / 无 '=' 的行返回 -1（C 端 {@code config_parse_line()} 同口径）。 */
        public static int configLineEq(String line) {
            int p = lineStartOf(line);
            if (p >= line.length() || line.charAt(p) == '#') {
                return -1;
            }
            return line.indexOf('=', p);
        }

        public static String trimRight(String s) {
            int end = s.length();
            while (end > 0 && (s.charAt(end - 1) == ' ' || s.charAt(end - 1) == '\t')) {
                end--;
            }
            return s.substring(0, end);
        }

        public static boolean isSpace(char c) {
            return c == ' ' || c == '\t' || c == '\r';
        }

        /**
         * 把一行的值片段换成 {@code newValue}：保留 {@code =} 之前的内容、值前后的空白
         * 与 {@code #} 之后的注释原文。详见 app/逻辑说明.md §3.2。
         */
        public static String spliceValue(String line, int eq, String newValue) {
            int hash = line.indexOf('#', eq + 1);
            int regionEnd = hash >= 0 ? hash : line.length();
            String region = line.substring(eq + 1, regionEnd);
            int head = 0;
            while (head < region.length() && isSpace(region.charAt(head))) {
                head++;
            }
            if (head == region.length()) {
                // 值片段全是空白（原值为空）：整段当作「值之后的对齐空白」，
                // 否则 CRLF 行会变成 "KEY=\r值"，行内注释也会跑到值前面
                return line.substring(0, eq + 1) + newValue + region
                        + (hash >= 0 ? line.substring(hash) : "");
            }
            int tail = region.length();
            while (tail > head && isSpace(region.charAt(tail - 1))) {
                tail--;
            }
            String gapHead = region.substring(0, head);
            String gapTail = region.substring(tail);
            return line.substring(0, eq + 1) + gapHead + newValue + gapTail
                    + (hash >= 0 ? line.substring(hash) : "");
        }

        public static List<String> splitLines(String text) {
            List<String> lines = new ArrayList<>();
            int from = 0;
            while (true) {
                int nl = text.indexOf('\n', from);
                if (nl < 0) {
                    lines.add(text.substring(from));
                    return lines;
                }
                lines.add(text.substring(from, nl));
                from = nl + 1;
            }
        }
    }

    /** 原子替换：同目录临时文件 → fsync → rename。 */
    private void writeAtomic(String content) throws IOException {
        File dir = configFile.getParentFile();
        if (dir != null && !dir.isDirectory() && !dir.mkdirs()) {
            throw new IOException("目录不可用：" + dir);
        }
        File tmp = new File(dir, CONFIG_FILE_NAME + ".tmp");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(tmp, false);
            fos.write(content.getBytes(StandardCharsets.UTF_8));
            fos.flush();
            fos.getFD().sync();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ignored) {
                    // 关闭失败不影响后续 rename 的判定
                }
            }
        }
        if (!tmp.renameTo(configFile)) {
            // rename 失败（极少见）→ 不留下半截文件，删掉临时文件并明确报错
            if (!tmp.delete()) {
                throw new IOException("rename 失败且临时文件无法删除：" + tmp);
            }
            throw new IOException("rename 失败：" + tmp + " → " + configFile);
        }
    }

    // ==================== 内部：解析辅助 ====================

    /**
     * 按类型解析文件里的一行值（口径同 C 端：数值取前 N 个整数 token，文本型（path / enum）
     * 取 trim 后原文）。
     */
    private static Value parseValue(KeyMeta meta, String raw) {
        if (meta.isText()) {
            return Value.ofText(trimValue(raw));
        }
        int n = Math.max(1, meta.fieldCount());
        int[] nums = new int[n];
        int idx = 0;
        int i = 0;
        int len = raw.length();
        while (idx < n && i < len) {
            while (i < len && !isDigitOrSign(raw.charAt(i))) {
                i++;
            }
            if (i >= len) {
                break;
            }
            int start = i;
            if (raw.charAt(i) == '+' || raw.charAt(i) == '-') {
                i++;
            }
            while (i < len && Character.isDigit(raw.charAt(i))) {
                i++;
            }
            try {
                nums[idx] = Integer.parseInt(raw.substring(start, i));
                idx++;
            } catch (NumberFormatException ignored) {
                // 超出 int 范围的 token 按 C 端 atoi 的未定义行为处理：跳过
            }
        }
        int[] trimmed = Arrays.copyOf(nums, Math.max(1, idx));
        return trimmed.length == 1 ? Value.ofInt(trimmed[0]) : Value.ofNumbers(trimmed);
    }

    private static Value parseValue(KeyMeta meta, Object jsonValue) {
        if (meta.isText()) {
            // enum 的 default / factory 在定义里就是文本（如 "config"），与 path 同一条路
            return Value.ofText(jsonValue == null ? "" : String.valueOf(jsonValue));
        }
        if (jsonValue instanceof JSONArray) {
            JSONArray a = (JSONArray) jsonValue;
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < a.length(); i++) {
                nums.add(a.optInt(i));
            }
            return nums.size() == 1 ? Value.ofInt(nums.get(0)) : Value.ofNumbers(nums);
        }
        if (jsonValue instanceof Number) {
            return Value.ofInt(((Number) jsonValue).intValue());
        }
        if (jsonValue == null || JSONObject.NULL.equals(jsonValue)) {
            return Value.ofInt(0);
        }
        return Value.ofText(String.valueOf(jsonValue));
    }

    private static boolean isDigitOrSign(char c) {
        return Character.isDigit(c) || c == '+' || c == '-';
    }

    private static String trimValue(String s) {
        int a = 0;
        int b = s.length();
        while (a < b && ConfText.isSpace(s.charAt(a))) {
            a++;
        }
        while (b > a && ConfText.isSpace(s.charAt(b - 1))) {
            b--;
        }
        return s.substring(a, b);
    }

    private static Object jsonValue(JSONObject o, String name) {
        if (!o.has(name) || o.isNull(name)) {
            return null;
        }
        return o.opt(name);
    }

    private static List<String> jsonStringList(JSONArray a) {
        List<String> out = new ArrayList<>();
        if (a != null) {
            for (int i = 0; i < a.length(); i++) {
                out.add(a.optString(i));
            }
        }
        return Collections.unmodifiableList(out);
    }

    private static int[] toIntArray(List<Integer> list) {
        int[] out = new int[list.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = list.get(i);
        }
        return out;
    }

    private static String join(List<String> list, String sep) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(sep);
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    private static String joinEach(List<String> list, String itemSuffix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(itemSuffix);
        }
        return sb.toString();
    }

    static byte[] readAllBytes(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream(Math.max(1024, (int) file.length()));
            byte[] buf = new byte[8192];
            int n;
            while ((n = in.read(buf)) > 0) {
                out.write(buf, 0, n);
            }
            return out.toByteArray();
        } finally {
            try {
                in.close();
            } catch (IOException ignored) {
                // 只读流关闭失败无影响
            }
        }
    }

    static String readAsset(Context context, String path) throws IOException {
        InputStream in = context.getAssets().open(path);
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream(64 * 1024);
            byte[] buf = new byte[8192];
            int n;
            while ((n = in.read(buf)) > 0) {
                out.write(buf, 0, n);
            }
            return new String(out.toByteArray(), StandardCharsets.UTF_8);
        } finally {
            try {
                in.close();
            } catch (IOException ignored) {
                // 只读流关闭失败无影响
            }
        }
    }
}

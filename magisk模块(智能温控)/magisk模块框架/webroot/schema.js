/* ============================================================
 * B6X 智能温控 WebUI — 参数定义 (schema)
 * 键范围以 tempctrl.c 的 clamp() 为准；说明摘自 profile.conf 注释
 * 注意：改 profile.conf 加/改参数时，必须同步更新本文件
 * ============================================================ */
/* ========== 参数定义风格约定（新增/修改参数时照此编写） ==========
 * label：中文名词短语，简短；单位后缀用括号，如 (0.1°C) (%) (×1000)。
 * desc：只陈述事实——用途、单位换算、默认值、生效条件、取值范围；
 *       可含示例（如「默认 2 33 = 0.2°C 近区 ×33%」）；开关类写「=0 关闭 / =1 开启」。
 * multi：label 概括该组，desc 用空格/斜线逐值说明（各字段标签自带单位）。
 * 不加「（合并 xx）」来源注记；被合并/改名的旧键直接删除，不保留。
 * 已在别处删掉说明的参数，本文件保持 desc:""，不补写。
 * 范围 min/max 须与 tempctrl.c 的 clamp 一致；改 clamp 时同步改这里。
 * ============================================================ */
window.B6X_SCHEMA = {
  moduleId: "b6x-Enhancement-Plan",
  configPath: "/data/adb/modules/b6x-Enhancement-Plan/profile.conf",
  statusB6: "/data/local/tmp/tempctrl_b6x.status",  // 保留备用（app.js 未引用）
  statusB7: "/data/local/tmp/tempctrl_b7x.status",  // 保留备用（app.js 未引用）
  gearFile: "/data/local/tmp/tempctrl.gear",        // 保留备用（app.js 未引用）
  dataFile: "/data/local/tmp/tempctrl_webui.data",  // C 每 1s 写入的曲线数据文件
  chartWindowOptions: [120, 180, 240, 360, 480, 720],

  groups: [
    // [0] 日志 & 调试（置顶）
    {
      id: "g1", title: "[0] 日志 & 调试", master: "DEBUG_ENABLED",
      headerSwitch: "DEBUG_ENABLED",
      keys: [],
      subKeys: ["DEBUG_SENSOR", "DEBUG_EXEC",
                "DEBUG_CONN", "DEBUG_CONFIG", "DEBUG_MAIN", "DEBUG_PID", "DEBUG_LAUNCH"]
    },
    // [1] 性能参数：组头开关 PERF_ENABLED + 通用参数 + PID 子面板（合并原 [2]，复用开关+子面板机制）
    {
      id: "g0", title: "[1] 性能参数", master: "PERF_ENABLED",
      headerSwitch: "PERF_ENABLED",
      keys: [],
      subKeys: ["RATE_LIMIT_FAN_UP", "RATE_LIMIT_FAN_DOWN",
                "RATE_LIMIT_COLD", "BATT_BASELINE",
                "COLD_MAP", "HOT_MAP", "RPM_SMOOTH_ALPHA", "FAN_RPM",
                "HOT_DERATE", "RECONNECT_KEEP_CYCLES",
                "PID_GAIN", "PID_TARGET", "PID_TARGET_DIR", "PID_CH_THRESHOLD", "PID_CPU_COMP",
                "PID_SPD_RECALL", "PID_COLD"]
    },
    // [2] sysfs 路径与缩放：独立大类（SYSFS_ENABLED 开关控制加载）
    {
      id: "g2", title: "[2] sysfs 路径与缩放", headerSwitch: "SYSFS_ENABLED",
      keys: [],
      subKeys: ["BATT_TEMP_PATH", "BATT_TEMP_DIVISOR", "BATT_CURRENT_PATH",
                "BATT_CURRENT_DIVISOR", "CPU_TEMP_PATH_FMT", "CPU_TEMP_DIVISOR",
                "CPU_ZONE", "CPU_ZONE_RESCAN", "LOG_FILE", "LOG_MAX"]
    },
    // [3] 自动拉起散热器 app：独立分组，开关常显在组头；组内含可编辑参数 APP_WATCHDOG（可折叠/展开）
    {
      id: "g3", title: "[3] 自动拉起散热器 app", headerSwitch: "APP_LAUNCH_ENABLED",
      keys: ["APP_WATCHDOG", "APP_LAUNCH_COOLDOWN", "APP_LAUNCH_SCREEN_GATE"]
    },
    // [4] WebUI 界面：仅 WebUI 读取的显示参数，守护进程忽略
    {
      id: "g5", title: "[4] WebUI 界面",
      keys: [],
      subKeys: ["WEBUI_GAP_DETECT_SEC", "WEBUI_GAP_MAX_SEC"]
    }
  ],

  keys: {
    // ---- [1] 总开关 ----
    PERF_ENABLED: { type: "switch", label: "性能参数总开关", desc: "" },

    // ---- [0] 日志 & 调试 ----
    DEBUG_ENABLED: { type: "switch", label: "调试日志总开关", desc: "" },
    DEBUG_SENSOR: { type: "switch", label: "传感器读数", desc: "" },
    DEBUG_EXEC: { type: "switch", label: "执行下发", desc: "" },
    DEBUG_CONN: { type: "switch", label: "连接状态", desc: "" },
    DEBUG_CONFIG: { type: "switch", label: "配置加载", desc: "" },
    DEBUG_MAIN: { type: "switch", label: "主循环", desc: "" },
    DEBUG_PID: { type: "switch", label: "PID", desc: "" },
    DEBUG_LAUNCH: { type: "switch", label: "自动拉起", value: "0", desc: "" },

    // ---- [2] sysfs 路径与缩放 ----
    SYSFS_ENABLED: { type: "switch", label: "sysfs 路径与缩放开关", desc: "" },
    BATT_TEMP_PATH: { type: "path", label: "电池温度 sysfs",
      desc: "" },
    BATT_TEMP_DIVISOR: { type: "int", min: 1, max: 10000, label: "电池温度缩放系数",
      desc: "原始值 ÷ 缩放系数 以结果精确至 0.1°C 为宜" },
    BATT_CURRENT_PATH: { type: "path", label: "电池电流 sysfs",
      desc: "" },
    BATT_CURRENT_DIVISOR: { type: "int", min: 1, max: 100000, label: "电池电流缩放系数",
      desc: "原始值 ÷ 缩放系数 以结果精确至 0.01A 为宜" },
    CPU_TEMP_PATH_FMT: { type: "path", label: "CPU 温度 sysfs 模板",
      desc: "%d 会替换为目标 thermal_zone 编号" },
    CPU_TEMP_DIVISOR: { type: "int", min: 1, max: 10000, label: "CPU 温度缩放系数",
      desc: "原始值 ÷ 缩放系数 以结果精确至 0.1°C 为宜" },
    CPU_ZONE: { type: "multi", fields: [{ label: "最小 zone", min: 0, max: 99 }, { label: "最大 zone", min: 0, max: 99 }],
      label: "CPU thermal_zone 扫描范围", desc: "K60 推荐 30~40" },
    LOG_FILE: { type: "path", label: "日志文件路径",
      desc: "" },
    LOG_MAX: { type: "int", min: 0, max: 1048576, label: "日志上限（字节）",
      desc: "超限时删除最早的超出部分，0=关闭日志" },
    CPU_ZONE_RESCAN: { type: "multi", fields: [{ label: "重扫间隔(秒)", min: 5, max: 3600 }, { label: "保留温度值个数", min: 1, max: 64 }],
      label: "CPU zone 重扫间隔/保留数", desc: "按此间隔重扫，保留温度最高的 N 个 zone" },

    // ---- [1] 总开关 — 通用参数 ----
    RATE_LIMIT_FAN_UP: { type: "multi", fields: [{ label: "升速基础值", min: 50, max: 2000 }, { label: "升速倍率", min: 1, max: 200 }],
      label: "风扇升速限制", desc: "基础值 / 每°额外提高值" },
    RATE_LIMIT_FAN_DOWN: { type: "multi", fields: [{ label: "每周期最大降速量", min: 50, max: 2000 }, { label: "降速防抖阈值", min: 0, max: 2000 }],
      label: "风扇降速限制",
      desc: "每周期最大降速量 / 最小降低幅度" },
    RATE_LIMIT_COLD: { type: "multi", fields: [{ label: "基础值", min: 1, max: 194 }, { label: "倍率", min: 1, max: 100 }, { label: "最小变化幅度", min: 1, max: 50 }],
      label: "制冷强度限速",
      desc: "基础值 / 每°偏离额外变化量 / 最小变化幅度(升降都不变)" },
    // ---- [3] 自动拉起散热器 app ----
    APP_LAUNCH_ENABLED: { type: "switch", label: "自动拉起散热器 app", desc: "" },
    APP_WATCHDOG: { type: "int", min: 0, max: 120, label: "锁死自动重启周期数",
      desc: "实际制冷停滞且未达目标连续 N 次后 kill 散热器 app 并重新拉起；0=关闭" },
    APP_LAUNCH_COOLDOWN: { type: "int", min: 0, max: 3600, label: "拉起冷却间隔（秒）",
      desc: "两次拉起的最小间隔；0=不加冷却" },
    APP_LAUNCH_SCREEN_GATE: { type: "multi", fields: [{ label: "开关", min: 0, max: 1 }, { label: "读取失败默认值", min: 0, max: 1 }, { label: "Dozing算亮屏", min: 0, max: 1 }],
      label: "拉起前屏幕状态门禁",
      desc: "仅 mWakefulness=Awake 才拉起；Asleep/Dozing 算灭屏跳过，每 5 秒重试；失败兜底1=可拉起" },
    RECONNECT_KEEP_CYCLES: { type: "int", min: 0, max: 30, label: "断联保留状态周期数",
      desc: "断联少于 N 个控制周期不重置 PID 状态；0=关闭" },
    BATT_BASELINE: { type: "int", min: 300, max: 500, label: "基准温度（0.1°C）",
      desc: "" },
    COLD_MAP: { type: "multi", fields: [{ label: "起始强度", min: 0, max: 194 }, { label: "指数", min: 50, max: 500 }],
      label: "制冷映射",
      desc: "起始强度：低于此值时线性外推下限；指数：n^exp（÷100，150=1.50）" },
    HOT_MAP: { type: "multi", fields: [{ label: "最低温度", min: 200, max: 500 }, { label: "最高温度", min: 200, max: 500 }],
      label: "热端线性映射范围",
      desc: "热端在此区间线性映射到风扇转速，超出取边界" },
    RPM_SMOOTH_ALPHA: { type: "int", min: 1, max: 99, label: "冷/热端→RPM 平滑系数%",
      desc: "冷端与热端共用，值越大越跟随原始值，越小越平滑" },
    FAN_RPM: { type: "multi", fields: [{ label: "最低转速", min: 1000, max: 6000 }, { label: "最高转速(B6X)", min: 1000, max: 6000 }, { label: "最高转速(B7X)", min: 2000, max: 6000 }],
      label: "风扇转速范围", desc: "最低转速 B6X最高转速 B7X最高转速" },
    HOT_DERATE: { type: "multi", fields: [{ label: "阈值(0.1°C)", min: 350, max: 700 }, { label: "倍率=恢复值", min: 1, max: 20 }, { label: "冷却周期数(×5s)", min: 0, max: 20 }],
      label: "热端每°过温制冷上限削减值",
      desc: "热端>阈值每 0.1°C 削减上限(热端−阈值)×倍率/10；回落每次恢复倍率；削减/恢复后冷却 N 周期" },

    // ---- [1] PID 控制（单累积器）----
    PID_GAIN: { type: "multi", fields: [{ label: "KDP融合系数", min: 1, max: 1000 }, { label: "KI积分增益", min: 1, max: 1000 }, { label: "速度倍率", min: 0, max: 1000 }],
      label: "PID 增益组合(×1000)",
      desc: "三值均 ÷1000：KDP 融合比例+微分，KI 消静差，SPEED 速度倍率" },
    PID_TARGET: { type: "multi", fields: [{ label: "目标系数", min: 1, max: 1000 }, { label: "目标平滑%", min: 1, max: 100 }, { label: "目标上限(0.1°C)", min: 1, max: 100 }],
      label: "PID 目标组合",
      desc: "动态目标 = clamp(误差×系数, ±目标上限)；目标 EMA 平滑%越大越快速跟随；上限默认 10=1.0°C" },
    PID_TARGET_DIR: { type: "multi", fields: [{ label: "开关", min: 0, max: 1 }, { label: "远离基线alpha%", min: 1, max: 100 }, { label: "回归基线alpha%", min: 1, max: 100 }],
      label: "PID 目标方向性滤波",
      desc: "目标量级回升(远离基线)用远离alpha求快、回落(回归基线)用回归alpha求稳；开关0=退回 PID_TARGET 第2值单一alpha" },
    PID_CH_THRESHOLD: { type: "int", min: 1, max: 100, label: "稳态冻结阈值(0.1°C)",
      desc: "温度未变且上次 |ch|≤此值时整轮冻结（防抖）；1=默认0.1°C" },
    PID_CPU_COMP: { type: "multi", fields: [{ label: "滤波系数(%)", min: 1, max: 100 }, { label: "除数", min: 5, max: 200 }, { label: "偏移量(0.1°C)", min: 0, max: 500 }],
      label: "CPU 补偿",
      desc: "滤波强度 / 补偿系数 / 偏移量" },
    PID_SPD_RECALL: { type: "multi", fields: [{ label: "开关", min: 0, max: 1 }, { label: "回溯速度权重(×1000)", min: 100, max: 1000 }],
      label: "PID 无变化回溯",
      desc: "温度未变时回溯最后一次变化算速度；权重÷1000，1000=注入全量；无上限" },
    PID_COLD: { type: "multi", fields: [{ label: "下限", min: 0, max: 194 }, { label: "上限(B6X)", min: 0, max: 194 }, { label: "上限(B7X)", min: 1, max: 190 }],
      label: "制冷强度范围", desc: "下限 B6X上限 B7X上限" },

    // ---- [4] WebUI 界面 ----
    WEBUI_GAP_DETECT_SEC: { type: "int", min: 1, max: 120, label: "断联判定阈值（秒）",
      desc: "" },
    WEBUI_GAP_MAX_SEC: { type: "int", min: 1, max: 600, label: "断联空白最大宽度（秒）",
      desc: "" }
  },

};

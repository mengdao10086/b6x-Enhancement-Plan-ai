/* ============================================================
 * B6X 智能温控 WebUI — 参数定义 (schema)
 * 键范围以 tempctrl.c 的 clamp() 为准；说明摘自 profile.conf 注释
 * 注意：改 profile.conf 加/改参数时，必须同步更新本文件
 * ============================================================ */
/* ========== 参数定义风格约定（新增/修改参数时照此编写） ==========
 * label：中文名词短语，简短；单位后缀用半角括号，如 (0.1°C) (%) (÷1000)。
 * desc：只陈述事实——用途、单位换算、默认值、生效条件、取值范围；
 *       可含示例（如「默认 1 20 10 = 远离 0.2、回归 0.1」）；开关类写「=0 关闭 / =1 开启」。
 * multi：字段标签自带单位；desc 写共享公式/默认值/生效条件，不逐值复述字段名
 *       （取值顺序由 app.js 按 fields 顺序渲染在输入框下方，不写进 desc）。
 * 不加「（合并 xx）」来源注记；被合并/改名的旧键直接删除，不保留。
 * 已在别处删掉说明的参数，本文件保持 desc:""，不补写。
 * [4] WebUI 组的键无 tempctrl.c 依据，范围与语义以 app.js 实际使用为准。
 * 范围 min/max 须与 tempctrl.c 的 clamp 一致；改 clamp 时同步改这里。
 * keys / subKeys 的书写顺序与 profile.conf 中键的出现顺序一致（subKeys 顺序即 WebUI 渲染顺序）。
 * ============================================================ */
window.B6X_SCHEMA = {
  moduleId: "b6x-Enhancement-Plan",
  configPath: "/data/adb/modules/b6x-Enhancement-Plan/profile.conf",
  statusB6: "/data/local/tmp/tempctrl_b6x.status",  // 保留备用（app.js 未引用）
  statusB7: "/data/local/tmp/tempctrl_b7x.status",  // 保留备用（app.js 未引用）
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
    // [1] 性能参数：组头开关 PERF_ENABLED + 通用参数 + PID 子面板
    {
      id: "g0", title: "[1] 性能参数", master: "PERF_ENABLED",
      headerSwitch: "PERF_ENABLED",
      keys: [],
      subKeys: ["RATE_LIMIT_FAN_UP", "RATE_LIMIT_FAN_DOWN",
                "RATE_LIMIT_COLD", "RECONNECT_KEEP_CYCLES", "BATT_BASELINE", "CPU_FILTER_ALPHA",
                "COLD_RPM_MAP", "HOT_RPM_MAP", "MAP_INPUT_SMOOTH_ALPHA", "FAN_RPM_RANGE",
                "FAN_RPM_ROUND_UNIT",
                "HOT_DERATE", "PID_KDP", "PID_KI_RATE", "PID_SPEED",
                "PID_TARGET", "PID_CH_THRESHOLD", "PID_CPU_COMP", "PID_TARGET_DIR",
                "PID_SPEED_RECALL", "PID_COLD_RANGE"]
    },
    // [2] sysfs 路径与缩放：独立大类（SYSFS_ENABLED 开关控制加载）
    {
      id: "g2", title: "[2] sysfs 路径与缩放", headerSwitch: "SYSFS_ENABLED",
      keys: [],
      subKeys: ["BATT_TEMP_PATH", "BATT_TEMP_DIVISOR", "BATT_CURRENT_PATH",
                "BATT_CURRENT_DIVISOR", "CPU_TEMP_PATH_FMT", "CPU_TEMP_DIVISOR",
                "CPU_ZONE", "CPU_ZONE_RESCAN", "LOG_FILE", "LOG_MAX"]
    },
    // [3] 自动拉起散热器 app：独立分组，开关常显在组头；组内含可编辑参数（可折叠/展开）
    {
      id: "g3", title: "[3] 自动拉起散热器 app", headerSwitch: "APP_LAUNCH_ENABLED",
      keys: ["APP_LAUNCH_COOLDOWN", "APP_LAUNCH_SCREEN_GATE", "APP_WATCHDOG"]
    },
    // [4] WebUI 界面：仅 WebUI 读取的显示参数，守护进程忽略
    {
      id: "g5", title: "[4] WebUI 界面",
      keys: [],
      subKeys: ["WEBUI_GAP_DETECT_SEC", "WEBUI_GAP_MAX_SEC", "WEBUI_LABEL_MERGE_PX",
                "WEBUI_RPM_AXIS_MIN"]
    }
  ],

  // 书写顺序 = profile.conf 中键的出现顺序
  keys: {
    // ---- [0] 日志 & 调试 ----
    DEBUG_ENABLED: { type: "switch", label: "调试日志总开关", desc: "" },
    DEBUG_SENSOR: { type: "switch", label: "传感器读数", desc: "" },
    DEBUG_EXEC: { type: "switch", label: "执行下发", desc: "" },
    DEBUG_CONN: { type: "switch", label: "连接状态", desc: "" },
    DEBUG_CONFIG: { type: "switch", label: "配置加载", desc: "" },
    DEBUG_MAIN: { type: "switch", label: "主循环", desc: "" },
    DEBUG_PID: { type: "switch", label: "PID", desc: "" },
    DEBUG_LAUNCH: { type: "switch", label: "自动拉起", value: "0", desc: "" },

    // ---- [1] 性能参数 ----
    PERF_ENABLED: { type: "switch", label: "性能参数总开关", desc: "" },
    RATE_LIMIT_FAN_UP: { type: "multi", fields: [{ label: "每周期最大升速量", min: 50, max: 2000 }, { label: "升速防抖阈值", min: 0, max: 2000 }],
      label: "风扇升速上限",
      desc: "升速量 ≤ 防抖阈值时保持不升（仅升速方向生效）；阈值 0=关闭防抖，距最高转速 < 阈值×1.5 时失效" },
    RATE_LIMIT_FAN_DOWN: { type: "multi", fields: [{ label: "每周期最大降速量", min: 50, max: 2000 }, { label: "降速防抖阈值", min: 0, max: 2000 }],
      label: "风扇降速上限",
      desc: "降速量 ≤ 防抖阈值时保持不降（仅降速方向生效）；阈值 0=关闭防抖，距最低转速 < 阈值×1.5 时失效" },
    RATE_LIMIT_COLD: { type: "multi", fields: [{ label: "基础值", min: 1, max: 194 }, { label: "倍率", min: 1, max: 100 }, { label: "死区", min: 1, max: 50 }],
      label: "制冷强度限速",
      desc: "升速 = 基础值 + dev × 倍率 / 10，降速 = 基础值 − dev × 倍率 / 10（dev = 电池温度 − 基准温度，有符号），负值取 0=禁止该方向；|目标 − 回传| < 死区时升降都不下发" },
    RECONNECT_KEEP_CYCLES: { type: "int", min: 0, max: 30, label: "断联保留状态周期数",
      desc: "断联时长 < N×5 秒时保留 PID 状态（积分/误差等）；超过 N×5 秒或设为 0 → 完整重置并进入待对齐" },
    BATT_BASELINE: { type: "int", min: 300, max: 500, label: "基准温度(0.1°C)",
      desc: "" },
    CPU_FILTER_ALPHA: { type: "int", min: 1, max: 100, label: "CPU 温度 EMA 平滑系数(%)",
      desc: "首次直取，此后按系数平滑；值越大越跟随原始值" },
    COLD_RPM_MAP: { type: "multi", fields: [{ label: "起始强度", min: 0, max: 194 }, { label: "指数", min: 50, max: 500 }],
      label: "制冷映射",
      desc: "转速 ∝ n^指数（n = 制冷超出起始强度的比例，指数 = 值/100，150 → 1.50）；指数 >1 时低制冷段风扇更慢；制冷低于起始强度时线性外推下限" },
    HOT_RPM_MAP: { type: "multi", fields: [{ label: "最低温度", min: 200, max: 500 }, { label: "最高温度", min: 200, max: 500 }],
      label: "热端线性映射范围",
      desc: "热端在此区间线性映射到风扇转速；低于最低或高于最高温度时线性外推（最终转速仍钳制在风扇范围内）" },
    MAP_INPUT_SMOOTH_ALPHA: { type: "int", min: 1, max: 99, label: "冷端/热端映射输入 平滑系数(%)",
      desc: "冷端指数映射与热端线性映射共用，输入先平滑、映射后不再滤波；值越大越跟随原始值，越小越平滑" },
    FAN_RPM_RANGE: { type: "multi", fields: [{ label: "最低转速", min: 1000, max: 6000 }, { label: "最高转速(B6X)", min: 1000, max: 6000 }, { label: "最高转速(B7X)", min: 2000, max: 8000 }],
      label: "风扇转速范围", desc: "前两值须同给；B7X 最高转速目前与 B6X 相同，可单独调整" },
    FAN_RPM_ROUND_UNIT: { type: "int", min: 1, max: 500, label: "风扇转速取整单位(RPM)",
      desc: "下发风扇转速前就近取整到该单位的整数倍（默认 10：2044→2040、2045→2050）" },
    HOT_DERATE: { type: "multi", fields: [{ label: "阈值(0.1°C)", min: 350, max: 700 }, { label: "倍率=恢复值", min: 1, max: 20 }, { label: "冷却周期数(×5s)", min: 0, max: 20 }],
      label: "热端过温制冷削减",
      desc: "热端 > 阈值 → 单次削减 (热端 − 阈值) × 倍率 / 10：首次削减把上限压到「当前实际制冷值 − 削减量」，之后每次触发在当前上限上继续累减（不回看历史触发值）；热端 ≤ 阈值且有削减 → 上限每次 +「倍率」逐级上爬，封顶配置上限；削减/恢复各自独立冷却 N 个周期" },
    PID_KDP: { type: "int", min: 1, max: 1000, label: "KDP 融合系数(÷1000)",
      desc: "kdp = 系数/1000 ×（误差 + 速度项×0.33 + CPU 补偿）；速度项已按 PID_SPEED 缩放；无记忆，温度未变时沿用上周期值" },
    PID_KI_RATE: { type: "multi", fields: [{ label: "升速率", min: 1, max: 1000 }, { label: "降速率", min: 1, max: 1000 }],
      label: "KI 积分升/降速率(÷1000)",
      desc: "被积项 = ch − 动态目标；被积项 ≥0 用升速率、<0 用降速率，每周期 积分累积值 += 速率/1000 × 被积项（不乘 dt）；默认 20 30" },
    PID_SPEED: { type: "int", min: 0, max: 1000, label: "速度倍率(÷10)",
      desc: "100 = 速度×10；温度变化速度对控制量的权重，同时进入积分与 KDP；0=关闭" },
    PID_TARGET: { type: "multi", fields: [{ label: "目标系数", min: 1, max: 1000 }, { label: "目标平滑(%)", min: 1, max: 100 }, { label: "目标上限(0.1°C)", min: 1, max: 100 }],
      label: "动态目标",
      desc: "动态目标 = clamp(误差 × 系数/1000, ±上限)；平滑%越大越快速跟随；上限默认 15=1.5°C；第 2 值仅在 PID_TARGET_DIR 开关=0 时生效" },
    PID_CH_THRESHOLD: { type: "int", min: 1, max: 100, label: "稳态冻结阈值(0.1°C)",
      desc: "温度未变且上次 |ch| ≤ 阈值/10 时整轮冻结（积分/KDP/动态目标均不更新）；默认 2=0.2°C" },
    PID_CPU_COMP: { type: "multi", fields: [{ label: "平滑系数(%)", min: 1, max: 100 }, { label: "除数", min: 5, max: 200 }, { label: "偏移量(0.1°C)", min: 0, max: 500 }],
      label: "CPU 补偿",
      desc: "补偿 = clamp(CPU 平滑温度 − 电池温度 − 偏移量, 0) ÷ (除数 × 10)，再按平滑系数 EMA；门控滞回：条件消失后平滑值归零才退出" },
    PID_TARGET_DIR: { type: "multi", fields: [{ label: "开关", min: 0, max: 1 }, { label: "远离基线 α(%)", min: 1, max: 100 }, { label: "回归基线 α(%)", min: 1, max: 100 }],
      label: "PID 目标方向性滤波",
      desc: "目标量级增大（远离基线）用「远离 α」求快，否则用「回归 α」求稳；默认 1 20 10 = 远离 0.2、回归 0.1；开关=0 时退回 PID_TARGET 第 2 值的单一 α" },
    PID_SPEED_RECALL: { type: "multi", fields: [{ label: "开关", min: 0, max: 1 }, { label: "回溯速度权重(÷1000)", min: 100, max: 1000 }],
      label: "PID 无变化回溯",
      desc: "温度未变时用最近一次变化前的温度作锚点算速度：v = (当前温度 − 锚点温度) ÷ 累计周期数 ÷ 10 × 权重/1000，不再额外限幅；默认 1 1000 = 开启、注入全量速度" },
    PID_COLD_RANGE: { type: "multi", fields: [{ label: "下限", min: 0, max: 194 }, { label: "上限(B6X)", min: 0, max: 194 }, { label: "上限(B7X)", min: 1, max: 255 }],
      label: "制冷强度范围", desc: "前两值须同给；B7X 上限为 1~255（B6X 为 0~194）" },

    // ---- [2] sysfs 路径与缩放 ----
    SYSFS_ENABLED: { type: "switch", label: "sysfs 路径与缩放开关", desc: "" },
    BATT_TEMP_PATH: { type: "path", label: "电池温度 sysfs",
      desc: "" },
    BATT_TEMP_DIVISOR: { type: "int", min: 1, max: 10000, label: "电池温度缩放系数",
      desc: "内部值 = 原始值 ÷ 系数，结果以精确至 0.1°C 为宜（原始单位已是 0.1°C 时填 1）" },
    BATT_CURRENT_PATH: { type: "path", label: "电池电流 sysfs",
      desc: "" },
    BATT_CURRENT_DIVISOR: { type: "int", min: 1, max: 100000, label: "电池电流缩放系数",
      desc: "内部值 = 原始值 ÷ 系数，结果以精确至 0.01A 为宜；当前版本未参与控制，仅解析保留" },
    CPU_TEMP_PATH_FMT: { type: "path", label: "CPU 温度 sysfs 模板",
      desc: "%d 会替换为目标 thermal_zone 编号" },
    CPU_TEMP_DIVISOR: { type: "int", min: 1, max: 10000, label: "CPU 温度缩放系数",
      desc: "内部值 = 原始值 ÷ 系数，结果以精确至 0.1°C 为宜（原始单位 m°C 时填 100）" },
    CPU_ZONE: { type: "multi", fields: [{ label: "最小 zone", min: 0, max: 99 }, { label: "最大 zone", min: 0, max: 99 }],
      label: "CPU thermal_zone 扫描范围", desc: "首次扫描此区间建立有效 zone 名单，后续只扫名单内 zone；缩小范围可加速首次扫描，K60 推荐 30~40" },
    CPU_ZONE_RESCAN: { type: "multi", fields: [{ label: "重扫间隔(秒)", min: 5, max: 3600 }, { label: "保留温度值个数", min: 1, max: 64 }],
      label: "CPU zone 重扫间隔/保留数", desc: "首次真全量扫描建立有效 zone 名单（排除初值 ≤0）；此后每「重扫间隔」秒在名单内重排，保留温度最高的 N 个" },
    LOG_FILE: { type: "path", label: "日志文件路径",
      desc: "" },
    LOG_MAX: { type: "int", min: 0, max: 1048576, label: "日志上限(字节)",
      desc: "超限时截断保留尾部并从完整行首起；0=关闭日志；需 SYSFS_ENABLED=1" },

    // ---- [3] 自动拉起散热器 app ----
    APP_LAUNCH_ENABLED: { type: "switch", label: "自动拉起散热器 app", desc: "" },
    APP_LAUNCH_COOLDOWN: { type: "int", min: 0, max: 3600, label: "拉起冷却间隔(秒)",
      desc: "两次拉起的最小间隔，防断连频繁拉起；0=不冷却" },
    APP_LAUNCH_SCREEN_GATE: { type: "multi", fields: [{ label: "开关", min: 0, max: 1 }, { label: "读取失败默认值", min: 0, max: 1 }, { label: "Dozing 算亮屏", min: 0, max: 1 }],
      label: "拉起前屏幕状态门禁",
      desc: "仅 mWakefulness=Awake 才拉起，灭屏/息屏跳过并每 5 秒重试；第 2 值 = 读取失败时是否可拉起（1=可拉起）；第 3 值 = 1 时 Dozing 也算亮屏" },
    APP_WATCHDOG: { type: "int", min: 0, max: 120, label: "锁死自动重启停滞次数",
      desc: "实际制冷停滞（=上周期实际）且未达目标（≠上周期下发）连续 N 次下发 → kill app 并重新拉起；0=关闭；前置条件 APP_LAUNCH_ENABLED=1（自动拉起关闭时运行时强制置 0）" },

    // ---- [4] WebUI 界面 ----
    WEBUI_GAP_DETECT_SEC: { type: "int", min: 1, max: 120, label: "断联判定阈值(秒)",
      desc: "" },
    WEBUI_GAP_MAX_SEC: { type: "int", min: 1, max: 600, label: "断联空白最大宽度(秒)",
      desc: "" },
    WEBUI_LABEL_MERGE_PX: { type: "int", min: 1, max: 40, label: "标注合并阈值(px)",
      desc: "两条及以上曲线头部垂直相距不超过此值时合并为一个标签行；默认 9=0.8×标签高" },
    WEBUI_RPM_AXIS_MIN: { type: "int", min: 0, max: 8000, label: "风扇转速纵轴下限(RPM)",
      desc: "风扇转速低于此值的样本不参与左轴上下限计算，该段画到图外；0=关闭" }
  },

};

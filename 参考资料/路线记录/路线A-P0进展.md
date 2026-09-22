# 路线 A — P0：参数定义冻结（已完成）

> 本文件在 `.claude/`（根 .gitignore 第 5 行已忽略），**未 git add**。

## 已完成
- [x] 读 `待办.md` 80–248（路线 A 全节）+ 251–296（R1/R2/R15）
- [x] 四份来源对账：`schema.js` keys(52) / `profile.conf`(52) / `逻辑说明.md` 参数表(52) / `tempctrl.c`（`INT_CFG_KEYS[]` + `parse_*` + `load_config`，47 键 = 52 − 5 个 `WEBUI_*`）
- [x] 键集合校验：四份**无缺无多**；不一致集中在「键序 / 默认值语义 / 分组元字段 / 类型覆盖」四类，逐条裁定
- [x] 单一来源 `参数定义/params.def.json`（52 键 + 5 分组 + `chart` 段 + `audit` 段）
- [x] 生成脚本 `参数定义/gen_params.py`（幂等；`--audit` 四源漂移审计）
- [x] 产物 `lsp模块(apk修复+温控接口)/app/src/main/assets/params.json`（44629 B，52 键）
- [x] `参数定义/check_params.py`（A 产物可复现 / B 产物自洽 / C 四源无漂移）
- [x] `参数定义/对齐报告.md`（含 CI 接线一行说明 + 交接「期望生成的内容」）

## 验证证据（可复现）
```
python 参数定义/gen_params.py           # 重复执行「无变化」= 幂等
python 参数定义/check_params.py         # A/B/C 全 PASS，EXIT=0（仓库根与 参数定义/ 两处 cwd 均通过）
python 参数定义/gen_params.py --audit   # 漂移 0 条
  C 侧自动核对：默认值 通过 66 / 豁免 1 / 无 C 变量 7
                范围   通过 47 / 无 clamp 20 / 无 C 变量 7
```
反向验证（已实测报错，未改动真实 tempctrl.c，用临时副本）：
- 改一处 `clamp` 上界 → `范围不一致 FAN_RPM_RANGE[1]`
- 删 `is_sysfs_key()` 的一个 `strcmp` → `is_sysfs_key() 的键集合与 sysfs 分组不一致`
- 篡改 `params.json` 一字节 / 改定义不重新生成 → 退出码 1

第三方依赖：**无**（仅 argparse/io/json/os/re/sys）。

## 待办（移交 P2 / 线 C，均有明确交接物）
- [ ] `profile.conf` **三处值**待改：`APP_LAUNCH_ENABLED` 1→0、`APP_WATCHDOG` 6→0（冻结决策「两个开关默认关」）、`LOG_FILE` `/cache/tempctrl.log` → `/data/data/com.example.waspwingtempctrl/files/tempctrl.log`（C 端落点已改私有目录）
- [ ] `build.yml` 加一步 `run: python 参数定义/check_params.py`（插在 LSPosed job 的 checkout 之后、Gradle 编译之前）
- [ ] `schema.js` / `profile.conf` / `逻辑说明.md` 参数表改由本定义生成（形态见 `对齐报告.md` G 节）
- [ ] 就 `对齐报告.md` A2（文档表序二选一）拍板后，再生成文档参数表
- [ ] 线 C `Deployer`：配置不存在时写入 `factory`，已存在则一律保留
- [ ] 线 A 落地后把 `check_params.py` 全量接入 CI（当前 C 侧审计依赖 `tempctrl.c` 稳定）

## 风险 / 未决
- **未改 `tempctrl.c`、`profile.conf`、`build.yml`、任何 md**（全部按所有权只读）；`webroot/schema.js` 经授权只加 12 行纯注释的状态说明（见 `对齐报告.md` H2）
- 产物内**已无内部溯源**：P3 发现的 3 处 `（app.js）` 已清除，另清 3 处同类；`LOG_FILE` desc 的「三处一致」是有意保留的跨处约束（报告 H 节列为唯一例外）
- `profile.conf` 已由 P2 重生成，4 个 `default≠factory` 键的实际值与定义 `factory` 逐字相同、键序一致（已实测回流核对）
- `check_params.py` 的 C 侧审计在 CI 中默认**致命**（退出 2）：线 A 改 `tempctrl.c` 的窗口期内如出现无关红灯，可用 `--no-audit`
- `tempctrl.c` 的 `WEBUI_DATA_MAX_LINES 720` 与 `chart.rollingMaxLines` 无法自动核对（C 侧是宏），改小会静默导致界面出现不存在的档位
- `PID_KI_DYN_*` 是护栏式校验（越界拒绝），界面按 min/max 钳制会让用户触发不到该分支——已在定义文件 `rangeNote` 写明，界面**不得声称等同 C 端钳制**

## 上下文用量
本轮 P0 单 agent 执行，未派 subagent；自查约 155k/1000k tokens。

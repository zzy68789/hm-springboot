# 在 IntelliJ IDEA 中启动项目指南

## 项目信息
- **项目类型**: Spring Boot 3.3.2
- **Java版本**: 17
- **构建工具**: Maven
- **主类**: `com.example.hello.HelloApplication`
- **默认端口**: 8080

---

## 方法一：从GitHub克隆项目（推荐）

### 步骤 1: 克隆项目到本地

1. **打开IDEA**
   - 启动 IntelliJ IDEA

2. **克隆仓库**
   - 点击 `File` → `New` → `Project from Version Control...`
   - 或者点击欢迎界面的 `Get from VCS`
   - 选择 `Git`
   - 输入仓库URL: `https://github.com/zzy68789/hm-springboot.git`
   - 选择本地保存路径（Directory）
   - 点击 `Clone`

3. **等待克隆完成**
   - IDEA会自动检测项目类型并提示导入

### 步骤 2: 导入Maven项目

1. **自动导入提示**
   - IDEA检测到`pom.xml`后，会弹出提示
   - 选择 `Import Maven Project` 或 `Trust Project`

2. **手动导入（如果没有自动提示）**
   - 右键点击 `pom.xml` → `Add as Maven Project`
   - 或者 `File` → `Settings` → `Build, Execution, Deployment` → `Build Tools` → `Maven`
   - 确保Maven配置正确

3. **等待依赖下载**
   - IDEA会自动下载Maven依赖
   - 右下角会显示进度条
   - 等待所有依赖下载完成（可能需要几分钟）

### 步骤 3: 配置JDK

1. **设置项目JDK**
   - `File` → `Project Structure` (快捷键: `Ctrl+Alt+Shift+S`)
   - 选择 `Project`
   - 在 `SDK` 下拉框中选择 `JDK 17`（如果没有，需要先安装）
   - 在 `Language level` 选择 `17 - Sealed types, always-strict floating-point semantics`

2. **设置模块JDK**
   - 在 `Project Structure` 中选择 `Modules`
   - 选择项目模块
   - 在 `Language level` 选择 `17`

### 步骤 4: 配置数据库（重要）

项目需要MySQL数据库，需要修改配置文件：

1. **打开配置文件**
   - 找到 `src/main/resources/application.yml`
   - 修改数据库连接信息：

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/你的数据库名?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
    username: 你的数据库用户名
    password: 你的数据库密码
```

2. **确保MySQL已启动**
   - 确保本地MySQL服务正在运行
   - 确保数据库已创建

### 步骤 5: 运行项目

#### 方式一：直接运行主类（最简单）

1. **找到主类**
   - 打开 `src/main/java/com/example/hello/HelloApplication.java`

2. **运行**
   - 右键点击 `HelloApplication.java`
   - 选择 `Run 'HelloApplication.main()'`
   - 或者点击类名旁边的绿色运行按钮 ▶️
   - 或者使用快捷键 `Shift+F10`

3. **查看控制台**
   - 底部会显示运行日志
   - 看到 `Started HelloApplication` 表示启动成功
   - 默认访问地址: `http://localhost:8080`

#### 方式二：使用Maven运行

1. **打开Maven工具窗口**
   - 右侧边栏点击 `Maven` 标签
   - 或者 `View` → `Tool Windows` → `Maven`

2. **运行Spring Boot**
   - 展开项目 → `Plugins` → `spring-boot`
   - 双击 `spring-boot:run`

#### 方式三：配置运行配置

1. **创建运行配置**
   - `Run` → `Edit Configurations...`
   - 点击左上角 `+` → `Application`
   - 配置如下：
     - **Name**: `HelloApplication`
     - **Main class**: `com.example.hello.HelloApplication`
     - **Use classpath of module**: 选择项目模块
     - **JRE**: `17`
   - 点击 `OK`

2. **运行**
   - 选择刚创建的配置
   - 点击运行按钮 ▶️

---

## 方法二：如果项目已经在本地

### 步骤 1: 打开项目

1. **打开IDEA**
2. **选择 `Open`**
3. **选择项目根目录**（包含`pom.xml`的目录）
4. **选择 `Open as Project`**

### 步骤 2-5: 同方法一的步骤2-5

---

## 常见问题解决

### 1. JDK未安装或版本不对

**问题**: 提示找不到JDK 17

**解决**:
- 下载并安装JDK 17
- IDEA会自动检测，或手动添加：
  - `File` → `Project Structure` → `SDKs` → `+` → `Add JDK...`

### 2. Maven依赖下载失败

**问题**: 依赖下载很慢或失败

**解决**:
- 配置Maven镜像（使用阿里云镜像）:
  - `File` → `Settings` → `Build, Execution, Deployment` → `Build Tools` → `Maven`
  - 在 `User settings file` 中配置，或修改 `~/.m2/settings.xml`:

```xml
<mirrors>
  <mirror>
    <id>aliyunmaven</id>
    <mirrorOf>*</mirrorOf>
    <name>阿里云公共仓库</name>
    <url>https://maven.aliyun.com/repository/public</url>
  </mirror>
</mirrors>
```

### 3. 数据库连接失败

**问题**: 启动时报数据库连接错误

**解决**:
- 检查MySQL服务是否启动
- 检查`application.yml`中的数据库配置是否正确
- 检查数据库是否存在
- 检查用户名密码是否正确

### 4. 端口被占用

**问题**: 提示端口8080已被占用

**解决**:
- 修改端口：在`application.yml`中添加：
```yaml
server:
  port: 8081  # 改为其他端口
```

### 5. 编译错误

**问题**: 代码有红色波浪线

**解决**:
- 右键项目 → `Maven` → `Reload Project`
- `File` → `Invalidate Caches...` → `Invalidate and Restart`

---

## 验证项目是否启动成功

1. **查看控制台输出**
   - 应该看到类似以下信息：
   ```
   Started HelloApplication in X.XXX seconds
   ```

2. **访问应用**
   - 打开浏览器访问: `http://localhost:8080`
   - 或者测试API端点（根据项目中的Controller）

3. **查看日志**
   - 控制台会显示Spring Boot启动日志
   - 如果有错误，会在日志中显示

---

## 快速启动检查清单

- [ ] IDEA已安装并打开
- [ ] 项目已从GitHub克隆或打开
- [ ] Maven项目已正确导入
- [ ] JDK 17已配置
- [ ] Maven依赖已下载完成
- [ ] MySQL数据库已配置并运行
- [ ] `application.yml`中的数据库配置已修改
- [ ] 主类`HelloApplication`可以运行
- [ ] 控制台显示启动成功
- [ ] 浏览器可以访问 `http://localhost:8080`

---

## 项目结构说明

```
hm-springboot/
├── src/
│   ├── main/
│   │   ├── java/com/example/hello/
│   │   │   ├── HelloApplication.java    # 主启动类
│   │   │   ├── controller/              # 控制器
│   │   │   ├── service/                 # 服务层
│   │   │   ├── mapper/                  # MyBatis映射器
│   │   │   ├── entity/                  # 实体类
│   │   │   └── config/                  # 配置类
│   │   └── resources/
│   │       ├── application.yml          # 主配置文件
│   │       └── mapper/                  # MyBatis XML映射文件
│   └── test/                            # 测试代码
├── pom.xml                              # Maven配置文件
└── README.md                            # 项目说明
```

---

祝您使用愉快！如有问题，请检查上述常见问题解决方案。


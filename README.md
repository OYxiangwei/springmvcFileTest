# springmvcFileTest
springmvc实现文件上传和下载
1、打开 pom.xml，添加 maven 依赖
2、配置 web.xml 文件（servlet前端控制器-声明springmvc的配置文件位置-欢迎页）
3、配置文件 springmvc-config.xml（开启扫描-配置扫描包-配置视图解析器-配置文件上传解析器）
4、添加 FileInfo 实体类
5、新建 Controller 类 如果上传成功返回“download”页面
6、编写视图页面"upload、success、failure、download"

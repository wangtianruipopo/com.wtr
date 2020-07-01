# 启动Redis服务
在windows环境下启动redis服务，前提是你安装好了，启动如下：

一，进入redis的安装目录下，在地址栏输入“cmd”，回车
二，然后会进入cmd界面，直接运行命令redis-server.exe redis.windows.conf。如果报错，依次执行第一条指令：redis-cli.exe，第二条指令：shutdown第三条指令：exit
三，在命令行窗口输入redis-server.exe redis.windows.conf，就会显示Redis服务器的信息，就代表Redis服务器已经启动了。

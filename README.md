# NIO 相关知识及代码实现 #


## 基本概念 ##

**NIO**:NIO（New IO、Non Blocking IO）是面向缓冲区的、基于通道的IO操作，以更加高效的方式进行文 件的读写操作  
**主要特性**：  
1. 为所有的原始类型提供缓存（Buffer）支持  
2. 提供字符集编解码解决方案  
3. Channel: 全新的原始I/O对象  
4. 支持锁和内存映射文件的文件访问接口  
5. 提供多路（non-blocking）非阻塞的高伸缩网络I/O  

**缓冲区**：包在一个对象内的基本数据元素数组  
**属性**：  
1. 容量（Capacity）:缓冲区能够容纳的数据元素的最大数量  
2. 上界（Limit）:缓冲区现存元素的技术，类似于指针  
3. 位置（Position）:下一个要被读或写的元素索引位置，位置会自动更新  
4. 标记（Mark）:备忘位置  
**分类**：  
1. ByteBufer  
2. CharBuffer  
3. DoubleBuffer、FloatBuffer  
4. IntBuffer  
5. LongBuffer、ShortBuffer  
其中，上面的各类型的缓冲区都提供了get()和put()，缓冲区大小可以通过allocation()来创建空间大小，也可以通过warp()将数组包装到缓冲区为缓冲区内容分配空间。









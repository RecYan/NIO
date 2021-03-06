# NIO 相关知识及代码实现 #


## 基本概念 ##

**NIO**:NIO（New IO、Non Blocking IO）是面向缓冲区的、基于通道的IO操作，以更加高效的方式进行文 件的读写操作  
*高效的原因*：NIO将填充，排放缓冲区等的时间性I/O活动移回操作系统，从而大大提高了操作速度。  
**主要特性**：  
1. 为所有的原始类型提供缓存（Buffer）支持  
2. 提供字符集编解码解决方案  
3. Channel: 全新的原始I/O对象  
4. 支持锁和内存映射文件的文件访问接口  
5. 提供多路（non-blocking）非阻塞的高伸缩网络I/O  
>**通道和缓冲区(Channels and Buffers)**：在标准I/O API中，使用字符流和字节流。 在NIO中，使用**通道<双向通信>和缓冲区<数据存储区域>**。数据总是从缓冲区写入通道，并从通道读取到缓冲区。  
>**选择器(Selectors)**：Java NIO提供了“选择器”的概念。这是一个可以用于监视多个通道的对象，如数据到达，连接打开等。因此，单线程可以监视多个通道中的数据，选择器用于使用单个线程处理多个通道。因此，它需要较少的线程来处理这些通道。  
>**非阻塞I/O(Non-blocking I/O)**：Java NIO提供非阻塞I/O的功能。这里应用程序立即返回任何可用的数据，应用程序应该具有池化机制，以查明是否有更多数据准备就绪。  
6. NIO读写过程：**从通道读取：**创建一个缓冲区，然后请求通道读取数据。**通道写入：**创建一个缓冲区，填充数据，并要求通道写入数据  
**缓冲区**：包在一个对象内的基本数据元素数组  
**属性**：  
1. 容量（Capacity）: 缓冲区能够容纳的数据元素的最大数量  
2. 上界（Limit）: 缓冲区现存元素的技术，类似于指针  
3. 位置（Position）: 下一个要被读或写的元素索引位置，位置会自动更新  
4. 标记（Mark）:备忘位置  

**分类**：  
1. ByteBufer  
2. CharBuffer  
3. DoubleBuffer、FloatBuffer  
4. IntBuffer  
5. LongBuffer、ShortBuffer  
>其中，上面的各类型的缓冲区都提供了get()和put()，缓冲区大小可以通过allocation()来创建空间大小，也可以通过warp()将数组包装到缓冲区为缓冲区内容分配空间。









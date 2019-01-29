# DataStructure
Implementation of common data structures in Java.
### 数组
+ 特点：定长、按顺序访问、存取速度快、结构性操作性能低(插入和删除)
+ 适用场景：有固定个数个元素而且对存取速度要求高的场景可以使用数组
---
### 列表
+ 特点：基于数组，变长，变长是通过复制数组实现扩容的，如果扩容量太大用不了那么耗费资源，如果扩容太小就会导致频繁扩容，会进一步消耗系统性能
+ 适用场景：在对数据个数不清楚的情况下可以使用列表进行存储
---
### 散列表
+ 常用哈希函数：
	- 直接寻址法：取关键字或关键字的某个线性函数值为散列地址；
	- 数字分析法：通过对数据分析，发现数据中冲突较少的部分，并构造散列地址；
	- 平方取中法：先求出关键字的平方值，然后按需要取平方值的中间几位作为散列地址；
	- 取随机数法：使用一个随机函数，取关键字的随机值作为散列地址；
	- 除留取余法：取关键字被某个不大于散列表长n的数m除后所得的余数p为散列地址，m一般取素数或者直接用表长n
+ 碰撞的解决办法：
	- 开放寻址法：如果对key进行哈希之后发现地址处有值，那么就对计算出的地址进行一次探测再哈希，比如往后移动一个地址，如果这个地址没被占用，那么就用这个地址；
	- 再哈希法：在产生冲突之后，使用关键字的其它部分继续计算地址，如果还是有冲突，则继续使用其它部分再计算地址；
	- 链地址法：将地址处的所有key-value链成链表；
	- 建立一个公共溢出区：当地址存在冲突时，把新的地址放在公共溢出区
+ 散列表的特点：访问速度很快、需要额外的空间(因为地址可能存在冲突，对冲突的处理就需要额外空间，而且散列表的地址不一定被用满)、无序、可能会产生碰撞
+ 散列表的适用场景：缓存、快速查找
---
### 链表
+ 链表的特点：插入和删除操作快、查找和修改操作性能低、物理空间不连续空间开销大(因为需要空间存储指针信息)、在运行时可以动态添加
+ 链表的适用场景：emmmmmm，容我想想再来写
---
### 栈
+ 栈的特点：先进后出或后进先出
+ 栈的适用场景：逆序输出(先正序入栈，然后依次出栈)、语法检查(由于括号成对出现，那么遇到左半边就入栈，然后peek栈顶的左半边与下一个字符比较，如果遇到右半边就出栈pop，再检查isEmpty就可以确定是否匹配成功)、数制转换(指的是将十进制转换为2~9任意进制，由于是逆向排序，那么刚好除一次就入栈一次，最后依次出栈)

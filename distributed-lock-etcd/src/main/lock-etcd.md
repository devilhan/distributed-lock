#H1 etcd常见应用场景
    1. 配置中心
        etcd是一个分布式的键值存储系统，其优秀的读写性能、一致性和可用性的机制，非常适合用来做配置中心角色。
    2. 分布式锁
        etcd的强一致性保证，可以用来做分布式场景下的同步机制保证。
    3. leader选举组件
        分布式场景下，常采用leader-follower模式来保证有状态服务的高可用（即使leader挂掉，其他follower立马补上），
        比如k8s和kafka partition高可用机制。可以很方便的借助etcd来实现leader选举机制，这里有个leader election
    4. 服务注册与服务发现
        为了解决微服务场景下，服务地址的注册和发现问题。和配置中心功能类似，不同之处在于服务注册和服务发现，还伴随着状态检测。
    5. 消息订阅和发布
        etcd内置watch机制，完全可以实现一个小型的消息订阅和发布组件。

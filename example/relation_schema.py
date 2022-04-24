from edu.cug.cs.dbp.tutorials.c06.attribute_set import AttributeSet
# from edu.cug.cs.dbp.tutorials.c06.functional_dependency import FunctionalDependency
from edu.cug.cs.dbp.tutorials.c06.functional_dependency_set import FunctionalDependencySet


# 求关系模式rs中，属性集a_set关于F的闭包
def get_closure_of_attribute_set(u_set, fd_set, a_set):
    u = u_set
    fds = fd_set.get_functional_dependency_list().copy()
    if a_set.is_subset(u):
        a = AttributeSet()
        a.copy(a_set)
        b = AttributeSet()
        while True:
            t = AttributeSet()
            del_list = []
            # 依次取函数依赖的左部，判断其左部是否为aset的子集，如果是，则将其右部加入到结果中
            for f in fds:
                las = f.get_left_attribute_set()
                if las.is_subset(a):
                    t.append_all(f.get_right_attribute_group())
                    del_list.append(f)
            # 删除需要删除的函数依赖
            for d in del_list:
                fds.remove(d)
            b = a
            a = a | t
            # 如果等于全集或上一步的集合，则a就是闭包计算的结果
            if a == b or a == u:
                break
        a.sort()
        return a
    else:
        return AttributeSet()


# 求关系模式rs中，属性集a_set关于F的闭包
def get_closure_of_attribute_set_2(rs, a_set):
    return get_closure_of_attribute_set(rs.get_attribute_set(), rs.get_functional_dependency_set(), a_set)


# 求关系模式中F的最小覆盖集
def get_canonical_cover(rs):
    # 1 所有函数依赖的右部分裂为单项属性
    rs.get_functional_dependency_set().right_split()
    # 2 F , G
    u = rs.get_attribute_set()
    fds = rs.get_functional_dependency_set()
    g = fds.clone()
    c = fds.count()
    for i in range(0, c):
        f = fds[i]
        g.remove(f)
        cat = get_closure_of_attribute_set(u, g, f.get_left_attribute_set())
        f_right = f.get_right_attribute_set()
        if f_right.is_subset(cat):
            continue
        else:
            g.append(f)
    # 3 处理左部的冗余属性
    pass
    return g


# 关系模式
class RelationSchema:
    def __init__(self):
        self.fd_set = FunctionalDependencySet()
        self.a_set = AttributeSet()

    def __str__(self):
        s = 'U=' + self.a_set.__str__()
        s += '\n'
        s += 'F=' + self.fd_set.__str__()
        return s

    def get_attribute_set(self):
        return self.a_set

    def get_functional_dependency_set(self):
        return self.fd_set

    def add_attribute(self, attribute):
        self.a_set.append(attribute)

    def add_functional_dependency(self, f):
        self.fd_set.append(f)

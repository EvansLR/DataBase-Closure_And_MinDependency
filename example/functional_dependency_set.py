# 函数依赖集
class FunctionalDependencySet:
    def __init__(self):
        self.fds = []

    def __getitem__(self, item):
        return self.fds[item]

    def __eq__(self, other):
        return self.__str__() == other.__str__()

    def __str__(self):
        sa = []
        for f in self.fds:
            sa.append(f.__str__())
        sa.sort()
        sc = '{'
        for s in sa:
            sc += (s + ',')
        sc = sc.rstrip(',') + '}'
        return sc

    def __ne__(self, other):
        return self.__str__() != other.__str__()

    def append(self, fd):
        self.fds.append(fd)

    def remove(self, fd):
        self.fds.remove(fd)

    def index(self, fd):
        return self.fds.index(fd)

    def get_functional_dependency_list(self):
        return self.fds

    def count(self):
        return len(self.fds)

    def clone(self):
        a = FunctionalDependencySet()
        a.fds = self.fds.copy()
        return a

    def right_split(self):
        del_list = []
        add_list = []
        for f in self.fds:
            r = f.right_split()
            if r is None:
                continue
            else:
                del_list.append(f)
                for i in r:
                    add_list.append(i)
        for i in del_list:
            self.fds.remove(i)
        for i in add_list:
            self.fds.append(i)
        self.fds.sort()

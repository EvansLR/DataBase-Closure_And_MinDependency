from edu.cug.cs.dbp.tutorials.c06.attribute_group import AttributeGroup
from edu.cug.cs.dbp.tutorials.c06.attribute_set import from_group


# 函数依赖类
class FunctionalDependency:
    def __init__(self, left=None, right=None):
        if left is None:
            self.left = AttributeGroup()
        else:
            self.left = left
        if right is None:
            self.right = AttributeGroup()
        else:
            self.right = right

    def __eq__(self, other):
        if self.left == other.left and self.right == other.right:
            return True
        else:
            return False

    def __ne__(self, other):
        if self.left == other.left and self.right == other.right:
            return False
        else:
            return True

    def __lt__(self, other):
        if self.left.__str__() < other.left.__str__():
            return True
        else:
            return False

    def __gt__(self, other):
        if self.left.__str__() > other.left.__str__():
            return True
        else:
            return False

    def __str__(self):
        self.left.sort()
        self.right.sort()
        s_left = self.left.__str__()
        s_right = self.right.__str__()
        return s_left + '->' + s_right

    def __hash__(self):
        return hash(self.__str__())

    def get_left_attribute_group(self):
        return self.left

    def get_right_attribute_group(self):
        return self.right

    def get_left_attribute_set(self):
        return from_group(self.left)

    def get_right_attribute_set(self):
        return from_group(self.right)

    def clone(self):
        a = FunctionalDependency()
        a.left = self.left.clone()
        a.right = self.right.clone()
        return a

    def right_split(self):
        if self.right.count() > 1:
            r = []
            for i in self.right:
                ag = AttributeGroup(i)
                f = FunctionalDependency(self.left, ag)
                r.append(f)
            return r
        else:
            return None

    def left_split(self):
        if len(self.left) > 1:
            r = []
            for i in self.left:
                ag = AttributeGroup(i)
                f = FunctionalDependency(self.ag, self.right)
                r.append(f)
            return r
        else:
            return None

from edu.cug.cs.dbp.tutorials.c06.attribute_list import AttributeList


def from_list(a_list):
    a = AttributeSet()
    a.attributes = a_list.get_attributes().copy()
    return a


def from_group(a_group):
    a = AttributeSet()
    a.attributes = a_group.get_attributes().copy()
    return a


# 属性集类，与AttributeGroup的区别在于，AttributeSet支持集合计算
class AttributeSet(AttributeList):
    def __init__(self):
        super().__init__()

    def __eq__(self, other):
        return super().__eq__(other)

    def __ne__(self, other):
        return super().__ne__(other)

    def __sub__(self, other):
        return self.difference(other)

    def __add__(self, other):
        return self.union(other)

    def __or__(self, other):
        return self.union(other)

    def __and__(self, other):
        return self.intersection(other)

    def __xor__(self, other):
        return self.symmetric_difference(other)

    def is_subset(self, a_set):
        a = set(super().get_attributes())
        return a.issubset(set(a_set.get_attributes()))

    def is_superset(self, a_set):
        a = set(super().get_attributes())
        return a.issuperset(set(a_set.get_attributes()))

    def intersection(self, other):
        a = set(self.get_attributes())
        b = set(other.get_attributes())
        c = a.intersection(b)
        d = AttributeSet()
        d.attributes = list(c)
        return d

    def union(self, other):
        a = set(self.get_attributes())
        b = set(other.get_attributes())
        c = a.union(b)
        d = AttributeSet()
        d.attributes = list(c)
        return d

    def difference(self, other):
        a = set(self.get_attributes())
        b = set(other.get_attributes())
        c = a.difference(b)
        d = AttributeSet()
        d.attributes = list(c)
        return d

    def symmetric_difference(self, other):
        a = set(self.get_attributes())
        b = set(other.get_attributes())
        c = a.symmetric_difference(b)
        d = AttributeSet()
        d.attributes = list(c)
        return d

    def is_disjoint(self, other):
        a = set(self.get_attributes())
        b = set(other.get_attributes())
        return a.isdisjoint(b)

    def clone(self):
        a = AttributeSet()
        a.attributes = self.attributes.copy()
        return a

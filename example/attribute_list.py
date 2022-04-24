# 属性列表类，是属性组AttributeGroup和AttributeSet的基类
class AttributeList:
    def __init__(self):
        self.attributes = []

    def __getitem__(self, item):
        return self.attributes[item]

    def __eq__(self, other):
        c1 = len(self.attributes)
        c2 = len(other.attributes)
        if c1 != c2:
            return False
        else:
            for i in range(0, c1):
                if self.attributes[i] != other.attributes[i]:
                    return False
                else:
                    continue
            return True

    def __ne__(self, other):
        c1 = len(self.attributes)
        c2 = len(other.attributes)
        if c1 != c2:
            return True
        else:
            for i in range(0, c1):
                if self.attributes[i] != other.attributes[i]:
                    return True
                else:
                    continue
            return False

    def __str__(self):
        s = '{'
        for c in self.attributes:
            s += c.get_name()
            s += ','
        s = s.rstrip(',') + '}'
        return s

    def remove(self, attribute):
        self.attributes.remove(attribute)

    def index(self, attribute):
        return self.attributes.index(attribute)

    def append(self, attribute):
        self.attributes.append(attribute)

    def append_all(self, attribute_set):
        for c in attribute_set.attributes:
            self.attributes.append(c)

    def get_attributes(self):
        return self.attributes

    def copy(self, other):
        self.attributes = other.attributes.copy()

    def clone(self):
        a = AttributeList()
        a.attributes = self.attributes.copy()
        return a

    def sort(self):
        self.attributes.sort()

    def count(self):
        return len(self.attributes)

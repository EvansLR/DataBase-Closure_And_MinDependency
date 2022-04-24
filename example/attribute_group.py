from edu.cug.cs.dbp.tutorials.c06.attribute_list import AttributeList


# 属性组类，与AttributeSet的区别在于，AttributeSet支持集合计算
class AttributeGroup(AttributeList):
    def __str__(self):
        if len(self.attributes) > 1:
            s = '('
            for c in self.attributes:
                s += c.get_name()
                s += ','
            s = s.rstrip(',') + ')'
            return s
        else:
            s = ''
            for c in self.attributes:
                s += c.get_name()
            return s

    def __eq__(self, other):
        c1 = len(self.attributes)
        c2 = len(other.attributes)
        if c1 != c2:
            return False
        else:
            self.attributes.sort()
            other.attributes.sort()
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
            self.attributes.sort()
            other.attributes.sort()
            for i in range(0, c1):
                if self.attributes[i] != other.attributes[i]:
                    return True
                else:
                    continue
            return False

    def clone(self):
        a = AttributeGroup()
        a.attributes = self.attributes.copy()
        return a

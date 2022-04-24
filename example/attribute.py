# 属性类
class Attribute:
    def __init__(self, name):
        self.name = name

    def __eq__(self, other):
        return self.name == other.name

    def __ne__(self, other):
        return self.name != other.name

    def __lt__(self, other):
        return self.name < other.name

    def __gt__(self, other):
        return self.name > other.name

    def __hash__(self):
        return hash(self.name)

    def __str__(self):
        return self.name

    def get_name(self):
        return self.name

    def clone(self):
        s = self.name
        c = Attribute(s)
        return c

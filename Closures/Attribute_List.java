import java.util.ArrayList;



// 属性列表，将所有属性保存在其中
public class Attribute_List {
    
    // 使用数组存储
    public ArrayList<Attribute>attributes;

    // 构造函数,初始化属性数组
    public Attribute_List(){
        attributes=new ArrayList<Attribute>();
    }

    // 判断两个属性数组是否相同：
    public boolean is_equal(Attribute_List other)
    {
        // 判断属性组长度是否相同
        int length0=this.attributes.size();
        int length1=other.attributes.size();
        // 数组长度不相同直接返回false
        if (length0!=length1)return false;

        for(int i=0;i<length0;i++){
            Attribute a=this.attributes.get(i);
            Attribute b=other.attributes.get(i);
            // 假如字符串不相等，直接返回false
            if (!a.get_name().equals(b.get_name()))
            return false;
        }
    // 全部相同直接返回真
       return true;
    }

    // 获取属性列表的index位置的属性
    public  Attribute get_item(int index){
        return this.attributes.get(index);
    }


    // 将属性列表内容输出
    public String toString() 
    {
        String str="{";
        for(int i=0;i<this.attributes.size();i++){
             str+=this.attributes.get(i).get_name();
             str+=",";
        }
        str=str.substring(0,str.length()-1);
        str+="}";

        // 返回值,example{A,B,C,D,E}
        return str;
    }

    // 删除元素
    public boolean remove(Attribute r){
        
        // 删除该元素
        return attributes.remove(r);
    }


    // 查找下标
    public int index(Attribute r){

        // 返回位置
        return attributes.indexOf(r);
    }


    // 加入一个新属性
    public void append(Attribute r){
        // 添加
        this.attributes.add(r);
    }

    //加入一个属性列
    public void append_list(Attribute_List r) {
        for (int i=0;i<r.attributes.size();i++){
            // 将一个属性列表加入到现有的属性列表中
            this.attributes.add(r.attributes.get(i));
        }
    }

    // 获得所有的属性列
    public ArrayList<Attribute> get_attributes(){
        return this.attributes;
    }

    // 属性值保存
    public void copy(Attribute_List r){
        this.attributes=new ArrayList<Attribute>(r.attributes);
    }

    // 属性值复制
    public Attribute_List clone(){
        Attribute_List new_a=new Attribute_List();
        new_a.attributes=new ArrayList<Attribute>(this.attributes);
        return new_a;
    }

    // 根据属性值String进行排序
    public void sort(){
        this.attributes.sort(new SortByIndex());
    }

    // 获取属性集的长度
    public int count(){
        return this.attributes.size();
    }

}

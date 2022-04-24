
import java.util.*;

// 属性集子类 支持集合运算，继承于属性集
public class Attribute_Set extends Attribute_List
{
    // 初始化已经继承

    // 相等判断已经继承

    // 差集运算
    public Attribute_Set sub(Attribute_Set r)
    {
       
        // 分别转换为集合
        Set<Attribute> r_set = new HashSet<>(r.attributes);
        Set<Attribute> n_set = new HashSet<>(this.attributes);
        // 存放结果
        Set<Attribute> res = new HashSet<>();
        res.addAll(n_set);
        res.removeAll(r_set);
        ArrayList<Attribute> list2 = new ArrayList<Attribute> (res);  
        Attribute_Set b=new Attribute_Set();
        b.attributes=list2;
        return b;
    }

    // 并集运算
    public Attribute_Set add(Attribute_Set r)
    {
       
        // 分别转换为集合
        Set<Attribute> r_set = new HashSet<>(r.attributes);
        Set<Attribute> n_set = new HashSet<>(this.attributes);
        // 存放结果
        Set<Attribute> res = new HashSet<>();
        res.addAll(n_set);
        res.addAll(r_set);
        ArrayList<Attribute> list2 = new ArrayList<Attribute> (res);  
        Attribute_Set b=new Attribute_Set();
        b.attributes=list2;
        return b;
    }

    // 或运算
    public Attribute_Set or_(Attribute_Set r)
    {
       
        // 分别转换为集合
        Set<Attribute> r_set = new HashSet<>(r.attributes);
        Set<Attribute> n_set = new HashSet<>(this.attributes);
        // 存放结果
        Set<Attribute> res = new HashSet<>();
        res.addAll(n_set);
        res.addAll(r_set);
        ArrayList<Attribute> list2 = new ArrayList<Attribute> (res);  
        Attribute_Set b=new Attribute_Set();
        b.attributes=list2;
        return b;
    }

    // 与运算
    public Attribute_Set and_(Attribute_Set r)
    {
       
        // 分别转换为集合
        Set<Attribute> r_set = new HashSet<>(r.attributes);
        Set<Attribute> n_set = new HashSet<>(this.attributes);
        // 存放结果
        Set<Attribute> res = new HashSet<>();
        res.addAll(n_set);
        res.retainAll(r_set);
        
        ArrayList<Attribute> list2 = new ArrayList<Attribute> (res);  
        Attribute_Set b=new Attribute_Set();
        b.attributes=list2;
        return b;
    }

    // 判断是否是子集
    public boolean is_subset(Attribute_Set r){
            // 分别转换为集合
            Set<Attribute> r_set = new HashSet<>(r.attributes);
            Set<Attribute> n_set = new HashSet<>(this.attributes);
           
            
            // System.out.print(r_set.);
            
        return r_set.containsAll(n_set);
    }

    // 判断是否是超集
    public boolean is_superset(Attribute_Set r)
    {
        // 分别转换为集合
        Set<Attribute> r_set = new HashSet<>(r.attributes);
        Set<Attribute> n_set = new HashSet<>(this.attributes);
        return n_set.containsAll(r_set);
    }   

    // 属性值复制
    public Attribute_Set clone(){
        Attribute_Set new_a=new Attribute_Set();
        new_a.attributes=new ArrayList<Attribute>(this.attributes);
        return new_a;
     }

    //  判断是否有交集
    public boolean is_disjoint(Attribute_Set r){
        Set<Attribute> r_set = new HashSet<>(r.attributes);
        Set<Attribute> n_set = new HashSet<>(this.attributes);
        // 存放结果
        Set<Attribute> res = new HashSet<>();
        res.addAll(n_set);
        res.retainAll(r_set);
        if (res.size()>0){
            return true;
        }
        return false;
    }




}

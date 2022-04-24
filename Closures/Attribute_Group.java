import java.util.*;

public class Attribute_Group extends Attribute_List{

    // 将属性转为字符串
    public String toString(){

        if (this.attributes.size()>1){
            String res="(";
            for(int i=0;i<this.attributes.size();i++){
                res+=this.attributes.get(i).get_name();
                res+=",";
            }
            res=res.substring(0,res.length()-1);
            res+=")";
            return res;
        }
        else{
            String res="";
            res+=this.attributes.get(0).get_name();
            return res;
        }
    }

    // 判断属性集是否相等
    public boolean is_equal(Attribute_Group r){
         // 判断属性组长度是否相同
         int length0=this.attributes.size();
         int length1=r.attributes.size();
         // 数组长度不相同直接返回false
         if (length0!=length1)return false;
 
         for(int i=0;i<length0;i++){
             Attribute a=this.attributes.get(i);
             Attribute b=r.attributes.get(i);
             // 假如字符串不相等，直接返回false
             if (!a.get_name().equals(b.get_name()))
             return false;
         }
     // 全部相同直接返回真
        return true;

    }

    // 复制属性集
    public Attribute_Group clone(){
        Attribute_Group new_a=new Attribute_Group();
        new_a.attributes=new ArrayList<Attribute>(this.attributes);
        return new_a;
    }
}

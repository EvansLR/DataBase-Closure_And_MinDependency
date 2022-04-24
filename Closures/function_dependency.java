import java.util.ArrayList;
import java.util.*;

// 函数依赖类，保存每一个函数依赖
public class function_dependency {

    // 保存函数依赖的两边
    Attribute_Group left;
    Attribute_Group right;
    public function_dependency(){

    }

    //  含参构造函数
    public function_dependency(Attribute_Group left,Attribute_Group right){
          this.left=left;
          this.right=right;

    }
    // 判断函数依赖是否相等
    public boolean equals(function_dependency r){

        // 判断左右两边是否相等均相等才相等
        return this.left.is_equal(r.left)&&this.right.is_equal(r.right);
    }

    // 判断大小关系
    
    public int compareTo(function_dependency r)
    {
       return (this.left.toString().compareTo(r.left.toString()));
    }



     

    // 判断大小关系
    public boolean greater_than(function_dependency r){
        return (this.left.toString().compareTo(r.left.toString()))>0;
    }

    // 重写hash方法
    @Override
    public int hashCode() {
 
        return Objects.hash(left.toString(),right.toString());
    }


    // 转换为字符串
    public String toString(){
        this.left.sort();
        this.right.sort();
        String left_s=left.toString();
        left_s+="->";
        left_s+=right.toString();
        return left_s;
    }

    // 获得左边的属性组
    public Attribute_Group get_left_Attribute_Group(){
        return this.left;
    }
    // 获得右边的属性组
    public Attribute_Group get_right_Attribute_Group(){
        return this.right;
    }

    // 获得左边的属性集
    public Attribute_Set get_left_Attribute_Set(){

        Attribute_Set a=new Attribute_Set();
        a.attributes=this.left.clone().attributes;
        return a;
    }

    // 获得右边的属性集
    public Attribute_Set get_right_Attribute_Set(){

        Attribute_Set a=new Attribute_Set();
        a.attributes=this.right.clone().attributes;
        return a;
    }

    // 复制函数依赖
    public function_dependency clone(){
        function_dependency a=new function_dependency(this.left.clone(),this.right.clone());

        return a;
    }

    // 对函数依赖的左半部进行分割
    public ArrayList<function_dependency> left_split(){
        // 放置数组
        ArrayList<function_dependency> res=new ArrayList<function_dependency>();

        if (this.left.attributes.size()>1){
            for (int i=0;i<this.left.attributes.size();i++){
                Attribute_Group c=new Attribute_Group();
                c.append(this.left.attributes.get(i));
                function_dependency f=new function_dependency(c,this.right);
                res.add(f);

            }
        
        }
        // 假如数组大小为空，则说明不可分割
        return res;


    }

    
    // 对函数依赖的右半部进行分割
    public ArrayList<function_dependency> right_split(){
        // 放置数组
        ArrayList<function_dependency> res=new ArrayList<function_dependency>();

        if (this.right.attributes.size()>1){
            for (int i=0;i<this.right.attributes.size();i++){
                Attribute_Group c=new Attribute_Group();
                c.append(this.right.attributes.get(i));
                function_dependency f=new function_dependency(this.left,c);
                res.add(f);

            }
        
        }
        // 假如数组大小为空，则说明不可分割
        return res;

    }






}

class SortByIndex2 implements Comparator<function_dependency> 
{
      @Override
        public int compare(function_dependency o1, function_dependency o2) 
        {
            return o1.left.toString().compareTo(o2.left.toString());
    }

}
